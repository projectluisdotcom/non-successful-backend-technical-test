package consumption.registers.data.source.csv;

import com.opencsv.bean.CsvBindByName;

public class RegisterCsv {
    @CsvBindByName(column = "client")
    private String client;

    @CsvBindByName(column = "period")
    private String period;

    @CsvBindByName(column = "reading")
    private String reading;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }
}
