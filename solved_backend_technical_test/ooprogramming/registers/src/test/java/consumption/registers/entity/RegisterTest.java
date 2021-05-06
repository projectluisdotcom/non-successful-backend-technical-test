package consumption.registers.entity;

import consumption.registers.domain.entity.Period;
import consumption.registers.domain.entity.Register;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegisterTest {
    @Test
    void WhenValueIsOverMedianIsSuspicious() {
        Register register = new Register(16L, new Date());
        Period period = mock(Period.class);
        when(period.getOverMargin()).thenReturn(1.5f);
        when(period.getUnderMargin()).thenReturn(0.5f);

        boolean isSuspicious = register.isSuspicious(period);

        assertTrue(isSuspicious);
    }

    @Test
    void WhenValueIsUnderMedianIsSuspicious() {
        Register register = new Register(4L, new Date());
        Period period = mock(Period.class);
        when(period.getMedian()).thenReturn(10L);
        when(period.getOverMargin()).thenReturn(1.5f);
        when(period.getUnderMargin()).thenReturn(0.5f);

        boolean isSuspicious = register.isSuspicious(period);

        assertTrue(isSuspicious);
    }

    @Test
    void WhenValueIsNotOverMedianNorUnderMedianIsNotSuspicious() {
        Register register = new Register(10L, new Date());
        Period period = mock(Period.class);
        when(period.getMedian()).thenReturn(10L);
        when(period.getOverMargin()).thenReturn(1.5f);
        when(period.getUnderMargin()).thenReturn(0.5f);

        boolean isSuspicious = register.isSuspicious(period);

        assertFalse(isSuspicious);
    }
}
