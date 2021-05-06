package consumption.registers.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class RegistersConfig {
    @Bean
    public PeriodConfiguration personService() {
        return new PeriodConfiguration(12, 1.5f, 0.5f);
    }
}
