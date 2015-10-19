package vn.vtd.mvp.delegate;

import vn.vtd.mvp.common.MVPPresenter;
import vn.vtd.mvp.common.MVPView;

/**
 * Created by CUSDungVT on 10/19/2015.
 */
public class ActivityMVPNonConfigurationInstances<V extends MVPView, P extends MVPPresenter> {
    /**
     * The reference to the presenter
     */
    P presenter;

    /**
     * The reference to the custom non configuration.
     */
    Object nonMosbyCustomConfigurationInstance;

    /**
     * Constructor
     *
     * @param presenter The retaining presenter
     * @param nonMosbyCustomConfigurationInstance the other custom object
     */
    ActivityMVPNonConfigurationInstances(P presenter, Object nonMosbyCustomConfigurationInstance) {
        this.presenter = presenter;
        this.nonMosbyCustomConfigurationInstance = nonMosbyCustomConfigurationInstance;
    }
}
