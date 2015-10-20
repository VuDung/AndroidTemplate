package vn.vtd.mvp.delegate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;
import vn.vtd.mvp.delegate.callback.IBaseMVPDelegateCallback;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public class FragmentMVPDelegateImpl<V extends MVPView, P extends MVPPresenter<V>>
        implements IFragmentMVPDelegate<V, P>{
    protected IBaseMVPDelegateCallback<V, P> delegateCallback;
    protected InternalMVPDelegate<V, P> internalDelegate;

    public FragmentMVPDelegateImpl(IBaseMVPDelegateCallback<V, P> delegateCallback) {
        if (delegateCallback == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }

        this.delegateCallback = delegateCallback;
    }

    protected InternalMVPDelegate<V, P> getInternalDelegate(){
        if(internalDelegate == null){
            internalDelegate = new InternalMVPDelegate<>(delegateCallback);
        }
        return internalDelegate;
    }

    @Override
    public void onCreate(Bundle saved) {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getInternalDelegate().createPresenter();
        getInternalDelegate().attachView();
    }

    @Override
    public void onDestroyView() {
        getInternalDelegate().detachView();
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
    public void onActivityCreated(Bundle savedInstanceState) {

    }

    @Override
    public void onAttach(Context context) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
}
