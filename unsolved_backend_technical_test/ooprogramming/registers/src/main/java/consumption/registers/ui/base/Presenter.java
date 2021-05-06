package consumption.registers.ui.base;

public abstract class Presenter<TView extends Presenter.View> {
    protected TView view;

    public Presenter(TView view) {
        this.view = view;
    }

    public interface View {
    }
}
