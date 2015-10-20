package vn.tnc.androidtemplate.base.di;

import android.support.annotation.NonNull;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public interface BaseMVPComponent<V extends MVPView, P extends MVPPresenter<V>> {
    /**
     * expose the presenter object.
     *
     * @return exposed presenter object.
     */
    @NonNull
    P presenter();
}
