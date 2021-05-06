package consumption.registers.domain.repository;

import consumption.registers.domain.entity.Client;
import consumption.registers.common.ObservableTask;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface ClientRepository {
    ObservableTask<Stream<Client>> GetAll(Path path);
}
