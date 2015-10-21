package vn.tnc.androidtemplate.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import vn.tnc.androidtemplate.app.di.AppComponent;
import vn.tnc.androidtemplate.app.di.AppModule;
import vn.tnc.androidtemplate.app.di.DaggerAppComponent;
import vn.tnc.androidtemplate.app.di.VisitorComponent;
import vn.tnc.androidtemplate.app.di.VisitorModule;
import vn.tnc.commonandroid.utils.AndroidUtilsModule;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public class App extends Application implements IApplication{
    private AppComponent appComponent;
    private VisitorComponent visitorComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    /**
     * get app onject from context
     */
    public static App get(@NonNull final Context context){
        return (App)context.getApplicationContext();
    }

    private void initInjector(){
        if(appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .androidUtilsModule(new AndroidUtilsModule(this))
                    .build();
        }
        visitorComponent = appComponent.plus(new VisitorModule());
    }

    @NonNull
    @Override
    public AppComponent appComponent() {
        return appComponent;
    }

    @NonNull
    @Override
    public VisitorComponent visitorComponent() {
        return visitorComponent;
    }
}
