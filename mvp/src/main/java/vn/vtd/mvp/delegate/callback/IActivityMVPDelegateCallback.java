package vn.vtd.mvp.delegate.callback;

import android.support.v4.app.FragmentActivity;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public interface IActivityMVPDelegateCallback<V extends MVPView, P extends MVPPresenter<V>> extends IBaseMVPDelegateCallback<V, P> {
    /**
     * Return any Object holding the desired state to propagate to the next activity instance. Please
     * note that mosby internals like the presenter are already saved internally and you don't have
     * to take them into account.
     * <p>
     * This mechanism works pretty the same way as {@link FragmentActivity#onRetainCustomNonConfigurationInstance()}
     * and {@link #getNonMosbyLastCustomNonConfigurationInstance()}
     * </p>
     *
     * @return Object holding state.
     */
    Object onRetainNonMosbyCustomNonConfigurationInstance();

    /**
     * @return Return the value previously returned from {@link FragmentActivity#onRetainCustomNonConfigurationInstance()}.
     */
    Object getLastCustomNonConfigurationInstance();

    /**
     * <p>
     * This method is not really a "callback" method (will not invoked from delegate somehow).
     * However, it's part of this interface to ensure that no custom implementation will miss this
     * method since this method is the counterpart to {@link #onRetainNonMosbyCustomNonConfigurationInstance()}
     * </p>
     */
    Object getNonMosbyLastCustomNonConfigurationInstance();
}
