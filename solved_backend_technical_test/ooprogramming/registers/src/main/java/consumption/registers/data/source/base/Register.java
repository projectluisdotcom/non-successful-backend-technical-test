package consumption.registers.data.source.base;

public class Register {
    private final String clientId;
    private final String period;
    private final String value;

    public Register(String clientId, String period, String value) {
        this.clientId = clientId;
        this.period = period;
        this.value = value;
    }

    public String getClientId() {
        return clientId;
    }

    public String getPeriod() {
        return period;
    }

    public String getValue() {
        return value;
    }
}
