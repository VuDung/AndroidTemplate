package vn.tnc.androidtemplate.app;

import android.support.annotation.NonNull;

import vn.tnc.androidtemplate.app.di.AppComponent;
import vn.tnc.androidtemplate.app.di.VisitorComponent;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public interface IApplication {
    @NonNull
    AppComponent appComponent();
    @NonNull
    VisitorComponent visitorComponent();
}
