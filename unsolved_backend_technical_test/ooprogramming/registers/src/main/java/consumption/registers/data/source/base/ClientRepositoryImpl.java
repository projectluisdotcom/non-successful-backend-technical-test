package consumption.registers.data.source.base;

import consumption.registers.common.ObservableTask;
import consumption.registers.common.Subscriber;
import consumption.registers.domain.entity.Client;
import consumption.registers.domain.entity.ClientFactory;
import consumption.registers.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ClientRepositoryImpl implements ClientRepository {
    @Autowired
    private ParserFactory parserFactory;

    @Autowired
    private ClientFactory clientFactory;

    @Override
    public ObservableTask<Stream<Client>> GetAll(Path path) {
        return new ObservableTask<Stream<Client>>() {
            @Override
            public void run(Subscriber<Stream<Client>> response) {
                try {
                    FileReader fileReader = new FileReader(path.toAbsolutePath().toString());
                    DataParser parser = parserFactory.Create(path);
                    Stream<Register> registers = parser.parse(fileReader);
                    List<Register> list = registers.collect(Collectors.toList());
                    List<Client> clients = clientFactory.Create(list);
                    response.onSuccess(clients.stream());
                } catch (Exception e) {
                    response.onError(e);
                }
            }
        };
    }
}
