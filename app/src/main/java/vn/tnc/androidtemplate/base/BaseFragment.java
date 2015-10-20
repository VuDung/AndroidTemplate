package vn.tnc.androidtemplate.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import vn.tnc.androidtemplate.base.di.BaseMVPComponent;
import vn.tnc.common.di.HasComponent;
import vn.vtd.mvp.MVPFragment;
import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public abstract class BaseFragment<V extends MVPView, P extends MVPPresenter<V>, C extends BaseMVPComponent<V, P>>
                extends MVPFragment<V, P>{

    private C mComponent;

    /**
     * Inject dependency
     */
    protected abstract void inject();

    /**
     * Layout res
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutRes();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutRes = getLayoutRes();
        if(layoutRes == 0){
            return super.onCreateView(inflater, container, savedInstanceState);
        }else{
            View v = inflater.inflate(layoutRes, container, false);
            return v;
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectDependencies();
        ButterKnife.bind(this, view);
    }

    protected void injectDependencies(){
        mComponent = ((HasComponent<C>)getActivity()).getComponent();
        presenter = mComponent.presenter();
        setPresenter(presenter);
        this.inject();
    }

    protected C getComponent(){
        return mComponent;
    }


    @Override
    public P createPresenter() {
        return presenter;
    }

}
