package vn.tnc.commonandroid.jsr310;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by md101 on 10/18/15.
 */
@Module
public class JSR310Module {
    /**
     * Provide {@link ThreeTenABPDelegate} with the given context.
     *
     * @param application the {@link Application} object.
     * @return the provided {@link ThreeTenABPDelegate}
     */
    @Singleton
    @Provides
    ThreeTenABPDelegate provideThreeTenABPDelegate(@NonNull final Application application) {
        return new ThreeTenABPDelegateImpl(application);
    }
}
