package consumption.registers.domain.entity;

import java.util.Date;

public class Register implements Comparable<Register> {
    private final long Value;
    private final Date Date;

    public Register(long value, java.util.Date date) {
        Value = value;
        Date = date;
    }

    public boolean isSuspicious(Period period){
        long median = period.getMedian();
        float overMargin = period.getOverMargin();
        float underMargin = period.getUnderMargin();
        boolean isOverMargin = median * overMargin < Value;
        boolean isUnderMargin = median * underMargin > Value;
        return isOverMargin || isUnderMargin;
    }

    public long getValue() {
        return Value;
    }

    public java.util.Date getDate() {
        return Date;
    }

    @Override
    public int compareTo(Register other) {
        if(other == null){
            return 1;
        }

        return Long.compare(Value, other.Value);
    }
}
