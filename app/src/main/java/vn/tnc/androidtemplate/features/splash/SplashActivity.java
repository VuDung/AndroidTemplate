package vn.tnc.androidtemplate.features.splash;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import vn.tnc.androidtemplate.app.App;
import vn.tnc.androidtemplate.base.BaseActivity;
import vn.tnc.androidtemplate.features.splash.di.SplashComponent;
import vn.tnc.androidtemplate.features.splash.di.SplashModule;
import vn.tnc.common.di.HasComponent;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public class SplashActivity extends BaseActivity implements HasComponent<SplashComponent>{
    private SplashComponent mSplashComponent;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(android.R.id.content, new SplashFragment()).commit();
    }

    @Override
    protected void initInjector() {
        mSplashComponent = App.get(this)
                .visitorComponent()
                .plus(getActivityModule(), new SplashModule());
        mSplashComponent.inject(this);
    }

    @Override
    public SplashComponent getComponent() {
        return mSplashComponent;
    }
}
