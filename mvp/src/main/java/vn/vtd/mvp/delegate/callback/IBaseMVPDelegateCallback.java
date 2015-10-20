package vn.vtd.mvp.delegate.callback;

import android.app.Activity;
import android.support.annotation.NonNull;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public interface IBaseMVPDelegateCallback<V extends MVPView, P extends MVPPresenter<V>> {
    /**
     * Creates the presenter instance
     *
     * @return the created presenter instance
     */

    @NonNull
    public P createPresenter();


    /**
     * Get the presenter. If null is returned, then a internally a new presenter instance gets
     * created
     * by calling {@link #createPresenter()}
     *
     * @return the presenter instance. can be null.
     */
    public P getPresenter();

    /**
     * Sets the presenter instance
     *
     * @param presenter The presenter instance
     */
    public void setPresenter(P presenter);

    /**
     * Get the MvpView for the presenter
     *
     * @return The view associated with the presenter
     */
    public V getMvpView();

    /**
     * Indicate whether the retain instance feature is enabled by this view or not
     *
     * @return true if the view has  enabled retaining, otherwise false.
     * @see #setRetainInstance(boolean)
     */
    public boolean isRetainInstance();

    /**
     * Mark this instance as retaining. This means that the feature of a retaining instance is
     * enabled.
     *
     * @param retainingInstance true if retaining instance feature is enabled, otherwise false
     * @see #isRetainInstance()
     */
    public void setRetainInstance(boolean retainingInstance);

    /**
     * Indicates whether or not the the view will be retained during next screen orientation change.
     * This boolean flag is used for {@link MVPPresenter#detachView(boolean)}
     * as parameter. Usually you should take {@link Activity#isChangingConfigurations()} into
     * account. The difference between {@link #shouldInstanceBeRetained()} and {@link
     * #isRetainInstance()} is that {@link #isRetainInstance()} indicates that retain instance
     * feature is enabled or disabled while {@link #shouldInstanceBeRetained()} indicates if the
     * view is going to be destroyed permanently and hence should no more be retained (i.e. Activity
     * is finishing and not just screen orientation changing)
     *
     * @return true if the instance should be retained, otherwise false
     */
    public boolean shouldInstanceBeRetained();
}
