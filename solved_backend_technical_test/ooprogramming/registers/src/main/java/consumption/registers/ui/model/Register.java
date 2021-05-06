package consumption.registers.ui.model;

public class Register {
    private final String clientId;
    private final String month;
    private final String isSuspicious;
    private final String median;

    public Register(String clientId, String month, String isSuspicious, String median) {
        this.clientId = clientId;
        this.month = month;
        this.isSuspicious = isSuspicious;
        this.median = median;
    }

    public static String getHeaders() {
        return "| Client\t| Month\t| Suspicious\t| Median";
    }

    @Override
    public String toString(){
        return String.format("| %s\t| %s\t| %s\t| %s", clientId, month, isSuspicious, median);
    }

    public String getClientId() {
        return clientId;
    }

    public String getMonth() {
        return month;
    }

    public String getIsSuspicious() {
        return isSuspicious;
    }

    public String getMedian() {
        return median;
    }
}
