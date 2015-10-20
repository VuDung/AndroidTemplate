package vn.tnc.androidtemplate.features.splash.mvp;

import android.support.annotation.NonNull;

import de.greenrobot.event.EventBus;
import vn.tnc.androidtemplate.base.mvp.BaseRxPresenter;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public class SplashPresenterImpl extends BaseRxPresenter<SplashView> implements SplashPresenter{
    @NonNull
    @Override
    protected EventBus getEventBus() {
        return null;
    }
}
