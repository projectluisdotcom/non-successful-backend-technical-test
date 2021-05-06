package consumption.registers.domain.entity;

public class Client {
    private final String id;
    private final Period period;

    public Client(String id, Period period) {
        this.id = id;
        this.period = period;
    }

    public String getId() {
        return id;
    }

    public Period getPeriod() {
        return period;
    }

    public boolean isSuspicious() {
        for (Register register: this.period.getRegisters()) {
            if(register.isSuspicious(this.period)){
                return true;
            }
        }

        return false;
    }

    public Long getMedian() {
        return this.period.getMedian();
    }
}
