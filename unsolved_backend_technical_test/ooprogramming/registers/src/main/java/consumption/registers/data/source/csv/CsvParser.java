package consumption.registers.data.source.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvBadConverterException;
import consumption.registers.data.source.base.Register;
import consumption.registers.data.source.base.DataParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class CsvParser implements DataParser {
    @Override
    public String getExtension() {
        return "csv";
    }

    @Override
    public Stream<Register> parse(Reader buffer) throws CsvBadConverterException, IOException {
        CsvToBean<RegisterCsv> csvToBean = new CsvToBeanBuilder<RegisterCsv>(buffer)
                .withType(RegisterCsv.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        List<RegisterCsv> result = csvToBean.parse();
        buffer.close();
        return map(result);
    }

    private Stream<Register> map(List<RegisterCsv> registers) {
        List<Register> parsedRegisters = new LinkedList<>();

        for (RegisterCsv csv : registers) {
            parsedRegisters.add(new Register(csv.getClient(), csv.getPeriod(), csv.getReading()));
        }

        return parsedRegisters.stream();
    }
}


