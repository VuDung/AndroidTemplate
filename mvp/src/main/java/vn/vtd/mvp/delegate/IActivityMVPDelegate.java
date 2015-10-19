package vn.vtd.mvp.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public interface IActivityMVPDelegate<V extends MVPView, P extends MVPPresenter<V>> {
    /**
     * This method must be called from {@link Activity#onCreate(Bundle)}.
     * This method internally creates the presenter and attaches the view to it.
     */
    void onCreate(Bundle bundle);

    /**
     * This method must be called from {@link Activity#onDestroy()}}.
     * This method internally detaches the view from presenter
     */
    void onDestroy();

    /**
     * This method must be called from {@link Activity#onPause()}
     */
    void onPause();

    /**
     * This method must be called from {@link Activity#onResume()}
     */
    void onResume();

    /**
     * This method must be called from {@link Activity#onStart()}
     */
    void onStart();

    /**
     * This method must be called from {@link Activity#onStop()}
     */
    void onStop();

    /**
     * This method must be called from {@link Activity#onRestart()}
     */
    void onRestart();

    /**
     * This method must be called from {@link Activity#onContentChanged()}
     */
    void onContentChanged();

    /**
     * This method must be called from {@link Activity#onSaveInstanceState(Bundle)}
     */
    void onSaveInstanceState(Bundle outState);

    /**
     * This method must be called from {@link Activity#onPostCreate(Bundle)}
     */
    void onPostCreate(Bundle savedInstanceState);

    /**
     * This method must be called from {@link FragmentActivity#onRetainCustomNonConfigurationInstance()}
     *
     * @return Don't forget to return the value returned by this delegate method
     */
    Object onRetainCustomNonConfigurationInstance();

    /**
     * @return the value returned from {@link ActivityMvpDelegateCallback#onRetainNonMosbyCustomNonConfigurationInstance()}
     */
    Object getNonMosbyLastCustomNonConfigurationInstance();
}
