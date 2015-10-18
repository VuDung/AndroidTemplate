package vn.tnc.common.utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vn.tnc.common.Constants;

/**
 * Created by md101 on 10/18/15.
 */
@Module
public class UtilsModule {
    @Provides
    @Singleton
    EmailUtil provideEmailUtil(){
        return new EmailUtil(Constants.RE_PATTERNS_EMAIL_PATTERN);
    }
}
