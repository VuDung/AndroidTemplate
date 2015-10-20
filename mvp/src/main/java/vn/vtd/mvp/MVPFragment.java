package vn.vtd.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;
import vn.vtd.mvp.delegate.FragmentMVPDelegateImpl;
import vn.vtd.mvp.delegate.IFragmentMVPDelegate;
import vn.vtd.mvp.delegate.callback.IBaseMVPDelegateCallback;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public abstract class MVPFragment<V extends MVPView, P extends MVPPresenter<V>>
        extends Fragment
        implements IBaseMVPDelegateCallback<V, P>, MVPView{

    protected IFragmentMVPDelegate<V, P> mvpDelegate;
    protected P presenter;


    public abstract P createPresenter();

    @NonNull
    protected IFragmentMVPDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new FragmentMVPDelegateImpl<>(this);
        }

        return mvpDelegate;
    }
    //======================*^^*============================//


    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public V getMvpView() {
        return (V)this;
    }

    @Override
    public boolean isRetainInstance() {
        return getRetainInstance();
    }

    @Override
    public boolean shouldInstanceBeRetained() {
        FragmentActivity activity = getActivity();
        boolean changingConfig = activity != null && activity.isChangingConfigurations();
        return getRetainInstance() && changingConfig;
    }



    //======================*^^*============================//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMvpDelegate().onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getMvpDelegate().onDestroyView();
    }

    @Override
    public void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getMvpDelegate().onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getMvpDelegate().onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getMvpDelegate().onDetach();
    }
}
