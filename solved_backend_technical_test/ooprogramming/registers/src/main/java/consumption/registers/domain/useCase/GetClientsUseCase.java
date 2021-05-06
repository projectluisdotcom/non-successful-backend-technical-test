package consumption.registers.domain.useCase;

import consumption.registers.common.ObservableTask;
import consumption.registers.domain.entity.Client;
import consumption.registers.domain.repository.ClientRepository;
import consumption.registers.domain.useCase.base.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public class GetClientsUseCase extends UseCase<Path, Stream<Client>> {
    @Autowired
    private ClientRepository repository;

    @Override
    public ObservableTask<Stream<Client>> createTask(Path path) {
        return repository.GetAll(path);
    }
}
