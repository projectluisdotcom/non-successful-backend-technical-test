package consumption.registers.ui;

import consumption.registers.ui.model.Register;
import org.springframework.stereotype.Component;

@Component
public class CliView implements ClientPresenter.View {
    public void showHeader() {
        String headers = Register.getHeaders();
        System.out.println(headers);
    }

    @Override
    public void showRegister(Register register) {
        System.out.println(register.toString());
    }

    public void showSeparator() {
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
