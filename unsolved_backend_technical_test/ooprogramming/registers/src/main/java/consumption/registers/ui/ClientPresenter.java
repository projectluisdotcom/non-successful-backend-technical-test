package consumption.registers.ui;

import consumption.registers.common.Subscriber;
import consumption.registers.domain.entity.Client;
import consumption.registers.domain.useCase.GetClientsUseCase;
import consumption.registers.ui.base.Presenter;
import consumption.registers.ui.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public class ClientPresenter extends Presenter<ClientPresenter.View> {
    @Autowired
    private GetClientsUseCase getClientsUseCase;

    public ClientPresenter(@Autowired View view) {
        super(view);
    }

    public void showAllRegisters(Path path) {
        getClientsUseCase.createTask(path).run(new Subscriber<Stream<Client>>() {
            @Override
            public void onSuccess(Stream<Client> clientStream) {
                view.showHeader();
                view.showSeparator();
                clientStream.forEach(client -> {
                    Register register = parseClient(client);
                    view.showRegister(register);
                });
            }

            @Override
            public void onError(Exception exception) {
                view.showError(exception.getLocalizedMessage());
            }
        });
    }

    private Register parseClient(Client client) {
        String id = client.getId();
        String year = client.getPeriod().getMoth() + "";
        String isSuspicious = client.isSuspicious() + "";
        String median = client.getMedian() + "";
        return new Register(id, year, isSuspicious, median);
    }

    public interface View extends Presenter.View {
        void showHeader();

        void showRegister(Register register);

        void showError(String localizedMessage);

        void showSeparator();
    }
}
