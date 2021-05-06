package consumption.registers.config;

public class PeriodConfiguration {
    private final int registerPerPeriod;
    private final float suspiciousOverMargin;
    private final float suspiciousUnderMargin;

    public PeriodConfiguration(int registerPerPeriod, float suspiciousOverMargin, float suspiciousUnderMargin) {
        this.registerPerPeriod = registerPerPeriod;
        this.suspiciousOverMargin = suspiciousOverMargin;
        this.suspiciousUnderMargin = suspiciousUnderMargin;
    }

    public int getRegisterPerPeriod() {
        return registerPerPeriod;
    }

    public float getSuspiciousOverMargin() {
        return suspiciousOverMargin;
    }

    public float getSuspiciousUnderMargin() {
        return suspiciousUnderMargin;
    }
}
