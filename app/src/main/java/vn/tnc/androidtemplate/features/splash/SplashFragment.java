package vn.tnc.androidtemplate.features.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import vn.tnc.androidtemplate.R;
import vn.tnc.androidtemplate.widget.shimmer.Shimmer;
import vn.tnc.androidtemplate.widget.shimmer.ShimmerTextView;

/**
 * Created by CUSDungVT on 10/20/2015.
 */
public class SplashFragment extends Fragment{
    @Bind(R.id.stvSplash)
    ShimmerTextView stvSplash;
    private Shimmer mShimmer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if(mShimmer != null && mShimmer.isAnimating()){
            mShimmer.cancel();
        }else {
            mShimmer = new Shimmer();
            mShimmer.start(stvSplash);
        }
    }
}
