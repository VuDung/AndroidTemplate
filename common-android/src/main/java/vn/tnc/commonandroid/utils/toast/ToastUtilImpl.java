package vn.tnc.commonandroid.utils.toast;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by md101 on 10/18/15.
 */
public class ToastUtilImpl implements ToastUtil{
    private final Context mContext;

    public ToastUtilImpl(Context context){
        this.mContext = context;
    }

    @Override
    public void makeShortToast(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void makeShortToast(@StringRes int resStr) {
        Toast.makeText(mContext, resStr, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void makeLongToast(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void makeLongToast(@StringRes int resStr) {
        Toast.makeText(mContext, resStr, Toast.LENGTH_LONG).show();
    }
}
