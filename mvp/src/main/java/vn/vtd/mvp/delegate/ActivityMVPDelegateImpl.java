package vn.vtd.mvp.delegate;

import android.os.Bundle;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;
import vn.vtd.mvp.delegate.callback.IActivityMVPDelegateCallback;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public class ActivityMVPDelegateImpl<V extends MVPView, P extends MVPPresenter<V>> implements IActivityMVPDelegate {
    protected InternalMVPDelegate<V, P> internalMVPDelegate;
    protected IActivityMVPDelegateCallback<V, P> delegateCallback;

    public ActivityMVPDelegateImpl(IActivityMVPDelegateCallback<V, P> delegateCallback){
        if(delegateCallback == null){
            throw new NullPointerException("MVPDelegateCallback is null");
        }
        this.delegateCallback = delegateCallback;
    }

    protected InternalMVPDelegate<V, P> getInternalMVPDelegate(){
        if(internalMVPDelegate == null){
            internalMVPDelegate = new InternalMVPDelegate<>(delegateCallback);
        }
        return internalMVPDelegate;
    }

    @Override
    public void onCreate(Bundle bundle) {
        ActivityMVPNonConfigurationInstances<V, P> nci = (ActivityMVPNonConfigurationInstances<V, P>)delegateCallback.getLastCustomNonConfigurationInstance();
        if(nci != null && nci.presenter != null){
            delegateCallback.setPresenter(nci.presenter);
        }else{
            getInternalMVPDelegate().createPresenter();
        }
        getInternalMVPDelegate().attachView();
    }

    @Override
    public void onDestroy() {
        getInternalMVPDelegate().detachView();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onContentChanged() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {

    }

    @Override
    public Object getNonMosbyLastCustomNonConfigurationInstance() {
        ActivityMVPNonConfigurationInstances last = (ActivityMVPNonConfigurationInstances)delegateCallback.getLastCustomNonConfigurationInstance();

        return last == null ? null : last.nonMosbyCustomConfigurationInstance;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        P presenter = delegateCallback.shouldInstanceBeRetained() ? delegateCallback.getPresenter() : null;
        Object nonMosByConfigurationInstance = delegateCallback.onRetainNonMosbyCustomNonConfigurationInstance();
        if(presenter == null && nonMosByConfigurationInstance == null){
            return null;
        }else {
            return new ActivityMVPNonConfigurationInstances<>(presenter, nonMosByConfigurationInstance);
        }
    }
}
