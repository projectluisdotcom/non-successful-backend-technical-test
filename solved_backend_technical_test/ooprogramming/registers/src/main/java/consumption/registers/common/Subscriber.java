package consumption.registers.common;

public interface Subscriber<TOutput> {
    void onSuccess(TOutput output);
    void onError(Exception exception);
}
