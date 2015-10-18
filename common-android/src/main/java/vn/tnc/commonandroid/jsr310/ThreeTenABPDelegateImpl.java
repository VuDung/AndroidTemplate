package vn.tnc.commonandroid.jsr310;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

/**
 * Created by md101 on 10/18/15.
 */
public class ThreeTenABPDelegateImpl implements ThreeTenABPDelegate{
    private final Application mApplication;

    /**
     * Create instance with the given {@link Application} object. Used to initialize the
     * ThreeTenABP library.
     *
     * @param application the given {@link Application} object. Used to initialize the ThreeTenABP
     * library.
     */
    public ThreeTenABPDelegateImpl(final Application application) {
        this.mApplication = application;
    }

    @Override
    public void init() {
        AndroidThreeTen.init(mApplication);
    }
}
