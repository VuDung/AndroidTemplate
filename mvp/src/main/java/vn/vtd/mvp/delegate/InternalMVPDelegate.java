package vn.vtd.mvp.delegate;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;
import vn.vtd.mvp.delegate.callback.IBaseMVPDelegateCallback;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public class InternalMVPDelegate<V extends MVPView, P extends MVPPresenter<V>> {
    protected IBaseMVPDelegateCallback<V, P> delegateCallback;

    public InternalMVPDelegate(IBaseMVPDelegateCallback<V, P> delegateCallback){
        if(delegateCallback == null){
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
        this.delegateCallback = delegateCallback;
    }

    /**
     * Called  to create the presenter (if no other one already exisits)
     */
    void createPresenter() {

        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            presenter = delegateCallback.createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }

        delegateCallback.setPresenter(presenter);
    }

    /**
     * Attaches the view to the presenter
     */
    void attachView() {
        getPresenter().attachView(delegateCallback.getMvpView());
    }

    /**
     * Called to detach the view from presenter
     */
    void detachView() {
        getPresenter().detachView(delegateCallback.shouldInstanceBeRetained());
    }

    private P getPresenter() {
        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from getPresenter() is null");
        }
        return presenter;
    }
}
