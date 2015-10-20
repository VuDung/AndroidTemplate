package vn.tnc.androidtemplate.features.splash.di;

import dagger.Subcomponent;
import vn.tnc.androidtemplate.base.di.ActivityModule;
import vn.tnc.androidtemplate.base.di.BaseMVPComponent;
import vn.tnc.androidtemplate.features.splash.SplashActivity;
import vn.tnc.androidtemplate.features.splash.mvp.SplashPresenter;
import vn.tnc.androidtemplate.features.splash.mvp.SplashView;
import vn.tnc.common.di.ActivityScope;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
@ActivityScope
@Subcomponent(
        modules = {ActivityModule.class, SplashModule.class}
)
public interface SplashComponent extends BaseMVPComponent<SplashView, SplashPresenter>{

    /**
     * Inject dependency into splash activity.
     *
     * @param splashActivity activity to inject dependency.
     */
    void inject(SplashActivity splashActivity);
}
