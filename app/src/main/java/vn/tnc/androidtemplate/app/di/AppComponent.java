package vn.tnc.androidtemplate.app.di;

import javax.inject.Singleton;

import dagger.Component;
import vn.tnc.common.utils.UtilsModule;
import vn.tnc.commonandroid.jsr310.JSR310Module;
import vn.tnc.commonandroid.provider.ProviderModule;
import vn.tnc.commonandroid.utils.AndroidUtilsModule;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
@Singleton
@Component(
        modules = {AppModule.class,
                ProviderModule.class,
                JSR310Module.class,
                AndroidUtilsModule.class,
                UtilsModule.class}
)

public interface AppComponent {
        /**
         * Create a sub appComponent for visitor. Sub appComponent will extends all objects in super
         * appComponent.
         *
         * @param visitorModule the extra module needed to compose this sub appComponent.
         * @return sub appComponent for visitor.
         */
        VisitorComponent plus(VisitorModule visitorModule);
}
