package vn.tnc.commonandroid.utils.rom;

import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;

/**
 * Created by md101 on 10/18/15.
 */
public class MiUIUtil {
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

    private static final String AUTO_START_MANAGER_PACKAGE = "com.miui.securitycenter";
    private static final String AUTO_START_MANAGER_CLASS =
            "com.miui.permcenter.autostart.AutoStartManagementActivity";

    private final RomUtil mRomUtil;

    /**
     * Create instance with the given {@link RomUtil}.
     *
     * @param romUtil the given {@link RomUtil}.
     */
    public MiUIUtil(final RomUtil romUtil) {
        this.mRomUtil = romUtil;
    }

    /**
     * Check whether the device runs on MiUI.
     *
     * @return {@code true} if the device runs on MiUI.
     */
    public boolean isMiUI() {
        return !TextUtils.isEmpty(mRomUtil.getSystemProperty(KEY_MIUI_VERSION_CODE)) ||
                !TextUtils.isEmpty(mRomUtil.getSystemProperty(KEY_MIUI_VERSION_NAME)) ||
                !TextUtils.isEmpty(mRomUtil.getSystemProperty(KEY_MIUI_INTERNAL_STORAGE));
    }

    /**
     * Get the {@link Intent} that will start the MiUi AutoStartManagerActivity.
     *
     * @return the {@link Intent} that will start the MiUi AutoStartManagerActivity.
     */
    public Intent jump2AutoStartManager() {
        final Intent i = new Intent();
        final ComponentName comp =
                new ComponentName(AUTO_START_MANAGER_PACKAGE, AUTO_START_MANAGER_CLASS);
        i.setComponent(comp);
        return i;
    }
}
