package consumption.registers.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ListRegistersCommand {
    @Autowired
    private ClientPresenter presenter;

    public void run(String p){
        System.out.println(p);
        Path path = Paths.get(p);
        presenter.showAllRegisters(path);
    }
}

