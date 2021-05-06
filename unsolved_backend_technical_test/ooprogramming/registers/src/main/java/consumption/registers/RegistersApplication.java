package consumption.registers;

import consumption.registers.ui.ListRegistersCommand;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistersApplication implements ApplicationRunner {
	@Autowired
	private ListRegistersCommand listRegistersCommand;

	public static void main(String[] args) {
		SpringApplication.run(RegistersApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Options options = new Options();

		Option output = new Option("P", "path", true, "Path to data.");
		output.setRequired(true);
		options.addOption(output);

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd;

		try {
			cmd = parser.parse(options, args.getSourceArgs());
			listRegistersCommand.run(cmd.getOptionValue("P"));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
}

