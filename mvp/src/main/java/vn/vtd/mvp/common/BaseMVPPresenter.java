package vn.vtd.mvp.common;

import java.lang.ref.WeakReference;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public class BaseMVPPresenter<V extends MVPView> implements MVPPresenter<V> {

    private WeakReference<V> viewRef;

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        if(viewRef != null){
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * Check the view attach to presenter or not
     * @return true/false
     */
    public boolean isViewAttached(){
        return viewRef != null && viewRef.get() != null;
    }
}
