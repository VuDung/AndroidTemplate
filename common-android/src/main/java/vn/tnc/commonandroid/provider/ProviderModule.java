package vn.tnc.commonandroid.provider;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import retrofit.Retrofit;
import vn.tnc.commonandroid.jsr310.ThreeTenABPDelegate;

/**
 * Created by md101 on 10/18/15.
 */
@Module
public class ProviderModule {
    /**
     * Provide the {@link EventBus} singleton.
     *
     * @return the {@link EventBus} singleton.
     */
    @Singleton
    @Provides
    EventBus provideBus() {
        return EventBusProvider.provideEventBus();
    }

    /**
     * Provide the {@link Gson} singleton.
     *
     * @param delegate to initialize the JSR-310 library.
     * @return the {@link Gson} singleton.
     */
    @Singleton
    @Provides
    Gson provideGson(final ThreeTenABPDelegate delegate) {
        delegate.init();
        return GsonProvider.provideGson();
    }

    /**
     * Provide the {@link Retrofit} singleton.
     *
     * @param delegate to initialize the JSR-310 library.
     * @return the {@link Retrofit} singleton.
     */
    @Singleton
    @Provides
    Retrofit provideRetrofit(final ThreeTenABPDelegate delegate) {
        delegate.init();
        return RestProvider.provideRetrofit();
    }

    /**
     * Provide the {@link OkHttpClient} singleton.
     *
     * @return the {@link OkHttpClient} singleton.
     */
    @Singleton
    @Provides
    OkHttpClient provideHttpClient() {
        return HttpClientProvider.provideHttpClient();
    }
}
