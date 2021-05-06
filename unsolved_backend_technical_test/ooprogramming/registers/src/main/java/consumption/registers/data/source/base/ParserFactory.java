package consumption.registers.data.source.base;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;

@Component
public class ParserFactory {
    @Autowired
    private List<DataParser> parsers;

    public DataParser Create(Path path) throws Exception {
        String extension = FilenameUtils.getExtension(path.getFileName().toString());

        for (DataParser parser: parsers) {
            if(parser.getExtension().equals(extension)){
                return parser;
            }
        }

        String errorMessage = String.format("No parser found for exception %s", extension);
        throw new Exception(errorMessage);
    }
}
