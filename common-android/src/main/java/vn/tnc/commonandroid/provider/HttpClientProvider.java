package vn.tnc.commonandroid.provider;

import com.squareup.okhttp.OkHttpClient;

/**
 * Created by md101 on 10/18/15.
 */
public class HttpClientProvider {
    private HttpClientProvider() {
        // singleton
    }

    /**
     * Provide the {@link OkHttpClient} singleton instance. Should be only called in test cases,
     * besides {@link ProviderModule}.
     *
     * @return the singleton {@link OkHttpClient}.
     */
    static OkHttpClient provideHttpClient() {
        return OkHttpClientHolder.sOkHttpClient;
    }

    private static class OkHttpClientHolder {
        // lazy instantiate
        private static volatile OkHttpClient sOkHttpClient;

        static {
            sOkHttpClient = new OkHttpClient();
            //sOkHttpClient.networkInterceptors().add(new StethoInterceptor());
        }
    }
}
