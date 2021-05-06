package consumption.registers.data.source.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class RegisterXml {
    private String client;
    private String period;
    private String reading;

    public String getClient() {
        return client;
    }

    @XmlAttribute(name = "clientID")
    public void setClient(String client) {
        this.client = client;
    }

    public String getPeriod() {
        return period;
    }

    @XmlAttribute(name = "period")
    public void setPeriod(String period) {
        this.period = period;
    }

    public String getReading() {
        return reading;
    }

    @XmlValue
    public void setReading(String reading) {
        this.reading = reading;
    }
}