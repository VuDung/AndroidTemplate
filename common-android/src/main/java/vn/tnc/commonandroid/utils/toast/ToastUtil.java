package vn.tnc.commonandroid.utils.toast;

import android.support.annotation.StringRes;

/**
 * Created by md101 on 10/18/15.
 */
public interface ToastUtil {
    void makeShortToast(String content);
    void makeShortToast(@StringRes int resStr);
    void makeLongToast(String content);
    void makeLongToast(@StringRes int resStr);
}
