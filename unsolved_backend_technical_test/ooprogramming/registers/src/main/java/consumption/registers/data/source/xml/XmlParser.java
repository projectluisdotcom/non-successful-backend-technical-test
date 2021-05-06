package consumption.registers.data.source.xml;

import com.opencsv.exceptions.CsvBadConverterException;
import consumption.registers.data.source.base.DataParser;
import consumption.registers.data.source.base.Register;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class XmlParser implements DataParser {
    @Override
    public String getExtension() {
        return "xml";
    }

    @Override
    public Stream<Register> parse(Reader buffer) throws CsvBadConverterException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(RegistersXml.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        RegistersXml registers = (RegistersXml) jaxbUnmarshaller.unmarshal(buffer);
        return map(registers.getRegisters());
    }

    private Stream<Register> map(List<RegisterXml> registers) {
        List<Register> parsedRegisters = new LinkedList<>();

        for (RegisterXml xml : registers) {
            parsedRegisters.add(new Register(xml.getClient(), xml.getPeriod(), xml.getReading()));
        }

        return parsedRegisters.stream();
    }
}
