package vn.tnc.androidtemplate.features.splash.di;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import vn.tnc.androidtemplate.features.splash.mvp.SplashPresenter;
import vn.tnc.androidtemplate.features.splash.mvp.SplashPresenterImpl;
import vn.tnc.common.di.ActivityScope;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
@Module
public class SplashModule {

    @ActivityScope
    @Provides
    SplashPresenter provideSplashPresenter(final EventBus bus){
        return new SplashPresenterImpl(bus);
    }
}
