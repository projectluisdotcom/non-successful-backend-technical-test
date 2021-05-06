package consumption.registers.entity;

import consumption.registers.config.PeriodConfiguration;
import consumption.registers.domain.entity.Period;
import consumption.registers.domain.entity.Register;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PeriodTest {
    @Test
    void CanGetMedian() {
        PeriodConfiguration configuration = mock(PeriodConfiguration.class);
        when(configuration.getRegisterPerPeriod()).thenReturn(12);

        List<Register> registers = new LinkedList<>();
        for (int i = 0; i < configuration.getRegisterPerPeriod(); i++) {
            Register register = mock(Register.class);
            when(register.getValue()).thenReturn((long)i);
            registers.add(register);
        }

        Period period = new Period(registers, configuration);
        long result = period.getMedian();
        long expected = 5;

        assertEquals(expected, result);
    }
}
