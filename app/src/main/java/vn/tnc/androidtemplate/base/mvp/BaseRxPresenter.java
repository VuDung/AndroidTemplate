package vn.tnc.androidtemplate.base.mvp;

import android.support.annotation.NonNull;


import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;
import vn.vtd.mvp.common.BaseMVPPresenter;
import vn.vtd.mvp.common.MVPView;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public abstract class BaseRxPresenter<V extends MVPView> extends BaseMVPPresenter<V> {
    private CompositeSubscription mSubscription;

    @NonNull
    protected abstract EventBus getEventBus();

    protected void addSubscription(final Subscription subscription){
        if(mSubscription == null || mSubscription.isUnsubscribed()){
            mSubscription = new CompositeSubscription();
        }
        mSubscription.add(subscription);
    }

    protected void unSubscribedAll(){
        if(mSubscription != null && !mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
    }

    @Override
    public void attachView(V view) {
        super.attachView(view);
        if(!getEventBus().isRegistered(this)){
            try{
                getEventBus().register(this);
            }catch (EventBusException e){
                Timber.d("No subscriber at " + this.getClass().getName());
            }
        }
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if(!retainInstance){
            unSubscribedAll();
        }
        if(getEventBus().isRegistered(this)){
            getEventBus().unregister(this);
        }
    }
}
