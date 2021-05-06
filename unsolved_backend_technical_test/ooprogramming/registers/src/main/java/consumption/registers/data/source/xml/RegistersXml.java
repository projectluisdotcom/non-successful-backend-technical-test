package consumption.registers.data.source.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "readings")
public class RegistersXml {
    private List<RegisterXml> Registers;

    public List<RegisterXml> getRegisters() {
        return Registers;
    }

    @XmlElement(name="reading")
    public void setRegisters(List<RegisterXml> registers) {
        Registers = registers;
    }
}
