package consumption.registers.domain.entity;

import consumption.registers.config.PeriodConfiguration;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class Period {
    private final List<Register> registers;
    private final PeriodConfiguration config;

    public Period(List<Register> registers, PeriodConfiguration config) {
        // TODO: Input needs validation since data could be malformed
        Collections.sort(registers);
        this.registers = registers;
        this.config = config;
    }

    public long getMedian() {
        // FIXME: This only will work if registers per period is 12
        return (registers.get(5).getValue() + registers.get(6).getValue()) / 2;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public long getRegisterPerPeriod() {
        return this.config.getRegisterPerPeriod();
    }

    public float getOverMargin() {
        return this.config.getSuspiciousOverMargin();
    }

    public float getUnderMargin() { return this.config.getSuspiciousUnderMargin(); }

    public int getMoth() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.registers.get(0).getDate());
        return calendar.get(Calendar.MONTH) + 1;
    }
}
