package vn.tnc.androidtemplate.app.di;

import dagger.Subcomponent;
import vn.tnc.androidtemplate.base.di.ActivityModule;
import vn.tnc.androidtemplate.features.splash.di.SplashComponent;
import vn.tnc.androidtemplate.features.splash.di.SplashModule;
import vn.tnc.common.di.VisitorScope;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
@VisitorScope
@Subcomponent(modules = VisitorModule.class)
public interface VisitorComponent {
    /**
     * Create a sub appComponent for authenticated user. Sub appComponent will extends all objects
     * in super appComponent.
     *
     * @param activityModule the extra module needed to compose this sub appComponent.
     * @param splashModule the extra module needed to compose this sub appComponent.
     * @return sub appComponent for splash activity.
     */
    SplashComponent plus(ActivityModule activityModule, SplashModule splashModule);
}
