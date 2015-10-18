package vn.tnc.commonandroid.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vn.tnc.commonandroid.utils.rom.MiUIUtil;
import vn.tnc.commonandroid.utils.rom.RomUtil;
import vn.tnc.commonandroid.utils.screen.ScreenUtil;
import vn.tnc.commonandroid.utils.toast.ToastUtil;
import vn.tnc.commonandroid.utils.toast.ToastUtilImpl;

/**
 * Created by md101 on 10/18/15.
 */
@Module
public class AndroidUtilsModule {
    private final Context mContext;

    /**
     * Create instance with the {@link Context} object.
     *
     * @param context the {@link Context} object.
     */
    public AndroidUtilsModule(@NonNull final Context context) {
        mContext = context;
    }

    /**
     * Provide {@link ScreenUtil} with the given context.
     *
     * @return the provided {@link ScreenUtil}
     */
    @Singleton
    @Provides
    ScreenUtil provideScreenUtil() {
        return new ScreenUtil(mContext);
    }

    /**
     * Provide {@link ToastUtil} with the given context.
     *
     * @return the provided {@link ToastUtil}
     */
    @Singleton
    @Provides
    ToastUtil provideToastUtil() {
        return new ToastUtilImpl(mContext);
    }

    /**
     * Provide {@link MiUIUtil} with the given context.
     *
     * @return the provided {@link MiUIUtil}
     */
    @Singleton
    @Provides
    MiUIUtil provideMiUIUtil() {
        return new MiUIUtil(RomUtil.provideRomUtil());
    }
}
