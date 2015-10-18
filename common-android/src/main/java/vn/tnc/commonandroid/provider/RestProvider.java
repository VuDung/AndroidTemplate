package vn.tnc.commonandroid.provider;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import vn.tnc.common.Constants;

/**
 * Created by md101 on 10/18/15.
 */
public class RestProvider {
    private RestProvider() {
        // singleton
    }

    /**
     * Provide the {@link Retrofit} singleton instance.
     *
     * @return the singleton {@link Retrofit}.
     */
    static Retrofit provideRetrofit() {
        return RestAdapterHolder.sRetrofit;
    }

    private static class RestAdapterHolder {
        // lazy instantiate
        private static volatile Retrofit sRetrofit =
                new Retrofit.Builder().baseUrl(Constants.GITHUB_SERVER_ENDPOINT)
                        .client(HttpClientProvider.provideHttpClient())
                        .addConverterFactory(
                                GsonConverterFactory.create(GsonProvider.provideGson()))
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
    }
}
