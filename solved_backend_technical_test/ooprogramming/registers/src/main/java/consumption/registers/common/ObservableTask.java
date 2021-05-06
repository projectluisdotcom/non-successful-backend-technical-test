package consumption.registers.common;

public abstract class ObservableTask<TResponse> {
    public abstract void run(Subscriber<TResponse> response);
}


