package vn.tnc.androidtemplate.app.di;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vn.tnc.androidtemplate.app.App;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
@Module
public class AppModule {
    private final App mApp;

    public AppModule(App app){
        this.mApp = app;
    }

    @Provides
    @Singleton
    App provideApplication(){
        return mApp;
    }

    @Provides
    @Singleton
    Resources provideResources(){
        return mApp.getResources();
    }

    @Provides
    @Singleton
    Context provideContext(){
        return mApp;
    }
}
