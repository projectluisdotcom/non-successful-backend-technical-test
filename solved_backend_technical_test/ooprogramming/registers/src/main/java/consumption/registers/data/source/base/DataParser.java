package consumption.registers.data.source.base;

import com.opencsv.exceptions.CsvBadConverterException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Reader;
import java.util.stream.Stream;

public interface DataParser
{
    String getExtension();
    Stream<Register> parse(Reader buffer) throws CsvBadConverterException, IOException, JAXBException;
}

