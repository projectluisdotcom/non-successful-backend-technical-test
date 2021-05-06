package consumption.registers.domain.useCase.base;

import consumption.registers.common.ObservableTask;

public abstract class UseCase<TInput, TOutput> {
    public abstract ObservableTask<TOutput> createTask(TInput input);
}

