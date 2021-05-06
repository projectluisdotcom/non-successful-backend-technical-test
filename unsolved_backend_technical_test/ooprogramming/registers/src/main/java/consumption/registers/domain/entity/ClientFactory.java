package consumption.registers.domain.entity;

import consumption.registers.config.PeriodConfiguration;
import consumption.registers.data.source.base.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ClientFactory {
    @Autowired
    private PeriodConfiguration config;

    public List<Client> Create(List<Register> input) {
        Map<String, List<Register>> mappedRegisters = new HashMap<>();

        for (Register register : input) {
            String id = register.getClientId();
            if(!mappedRegisters.containsKey(id)){
                mappedRegisters.put(id, new LinkedList<>());
            }

            mappedRegisters.get(id).add(register);
        }

        List<Client> clients = new LinkedList<>();
        for (List<Register> registers : mappedRegisters.values()) {
            List<consumption.registers.domain.entity.Register> parsedRegisters = parseRegisters(registers);
            Period period = new Period(parsedRegisters, config);
            Client client = new Client(registers.get(0).getClientId(), period);
            clients.add(client);
        }

        return clients;
    }

    private List<consumption.registers.domain.entity.Register> parseRegisters(List<Register> registers) {
        List<consumption.registers.domain.entity.Register> parsedRegisters = new LinkedList<>();

        for (Register register : registers) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
                Date date = formatter.parse(register.getPeriod());
                consumption.registers.domain.entity.Register parsedRegister = new consumption.registers.domain.entity.Register(Long.parseLong(register.getValue()), date);
                parsedRegisters.add(parsedRegister);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return parsedRegisters;
    }
}
