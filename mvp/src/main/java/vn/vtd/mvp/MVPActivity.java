package vn.vtd.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;
import vn.vtd.mvp.delegate.ActivityMVPDelegateImpl;
import vn.vtd.mvp.delegate.IActivityMVPDelegate;
import vn.vtd.mvp.delegate.callback.IActivityMVPDelegateCallback;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public abstract class MVPActivity<V extends MVPView, P extends MVPPresenter<V>>
        extends AppCompatActivity
        implements IActivityMVPDelegateCallback<V, P>, MVPView{

    protected IActivityMVPDelegate mvpDelegate;
    protected P presenter;
    protected boolean retainInstance;

    protected IActivityMVPDelegate<V, P> getMVPDelegate(){
        if(mvpDelegate == null){
            return new ActivityMVPDelegateImpl<>(this);
        }
        return mvpDelegate;
    }
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getMVPDelegate().onCreate(bundle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getMVPDelegate().onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        getMVPDelegate().onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        getMVPDelegate().onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        getMVPDelegate().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getMVPDelegate().onStop();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        getMVPDelegate().onRestart();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        getMVPDelegate().onContentChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMVPDelegate().onSaveInstanceState(outState);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getMVPDelegate().onPostCreate(savedInstanceState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return getMVPDelegate().onRetainCustomNonConfigurationInstance();
    }

    @Override
    public Object getNonMosbyLastCustomNonConfigurationInstance() {
        return getMVPDelegate().getNonMosbyLastCustomNonConfigurationInstance();
    }

    //==========================*^_^*=============================//

    @NonNull
    public abstract P createPresenter();

    //==========================*^_^*=============================//

    @Override
    public Object onRetainNonMosbyCustomNonConfigurationInstance() {
        return null;
    }

    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.presenter =  presenter;
    }

    @Override
    public V getMvpView() {
        return (V)this;
    }

    @Override
    public boolean isRetainInstance() {
        return retainInstance;
    }

    @Override
    public void setRetainInstance(boolean retainingInstance) {
        this.retainInstance = retainingInstance;
    }

    @Override
    public boolean shouldInstanceBeRetained() {
        return retainInstance && isChangingConfigurations();
    }
}
