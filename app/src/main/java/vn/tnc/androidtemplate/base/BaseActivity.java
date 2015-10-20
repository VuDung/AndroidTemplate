package vn.tnc.androidtemplate.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.tnc.androidtemplate.app.IApplication;
import vn.tnc.androidtemplate.app.di.AppComponent;
import vn.tnc.androidtemplate.base.di.ActivityModule;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initInjector();
        super.onCreate(savedInstanceState);
    }

    /**
     * Init dependency injector
     */
    protected abstract void initInjector();

    /**
     * Get application component for dependency injection
     * @return
     */
    protected AppComponent getApplicationComponent(){
        if(!(getApplication() instanceof IApplication)){
            throw new IllegalMonitorStateException("Application class must implement IApplication interface");
        }
        return ((IApplication)getApplication()).appComponent();
    }

    /**
     * Get activity module for dependency injection
     * @return
     */
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }
}
