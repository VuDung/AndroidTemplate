package vn.tnc.androidtemplate.base.di;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import vn.tnc.common.di.ActivityScope;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
@Module
public class ActivityModule {
    private final AppCompatActivity mActivity;

    /**
     * Constructor
     */
    public ActivityModule(final AppCompatActivity activity){
        this.mActivity = activity;
    }

    @ActivityScope
    @Provides
    AppCompatActivity provideActivity(){
        return mActivity;
    }
}
