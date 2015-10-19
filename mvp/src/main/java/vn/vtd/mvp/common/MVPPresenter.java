package vn.vtd.mvp.common;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public interface MVPPresenter<V extends MVPView> {
    /**
     * set attach view to this presenter
     */
    public void attachView(V view);

    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * <code>Activity.detachView()</code> or <code>Fragment.onDestroyView()</code>
     */
    public void detachView(boolean retainInstance);
}
