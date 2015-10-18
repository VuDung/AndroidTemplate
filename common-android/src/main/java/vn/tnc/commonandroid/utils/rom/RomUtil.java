package vn.tnc.commonandroid.utils.rom;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import timber.log.Timber;

/**
 * Created by md101 on 10/18/15.
 */
public class RomUtil {
    private static final String TAG = "RomUtil";

    private RomUtil() {
        // singleton
    }

    /**
     * Provide the singleton {@link RomUtil} instance.
     *
     * @return the singleton {@link RomUtil} instance.
     */
    public static RomUtil provideRomUtil() {
        return RomUtilHolder.sRomUtil;
    }

    /**
     * Returns a SystemProperty
     *
     * @param propName The Property to retrieve
     * @return The Property, or NULL if not found
     */
    @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
    public String getSystemProperty(final String propName) {
        String line = null;
        BufferedReader input = null;
        try {
            final Process p = Runtime.getRuntime().exec("getprop " + propName);
            input = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            Timber.e(TAG, "Unable to read sysprop " + propName, ex);
        } finally {
            IOUtils.closeQuietly(input);
        }
        return line;
    }

    /**
     * Checks if there is enough Space on SDCard
     *
     * @param updateSize Size to Check
     * @return {@code true} if the Update will fit on SDCard, {@code false} if not enough space on
     * SDCard. Will also return false, if the SDCard is not mounted as read/write
     */
    @SuppressWarnings("PMD.DataflowAnomalyAnalysis")
    public boolean enoughSpaceOnSdCard(final long updateSize) {
        boolean ret = false;
        final String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            final File path = Environment.getExternalStorageDirectory();
            final StatFs stat = new StatFs(path.getPath());
            final long blockSize = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 ?
                    stat.getBlockSizeLong() : stat.getBlockSize();
            final long availableBlocks =
                    Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 ?
                            stat.getAvailableBlocksLong() : stat.getAvailableBlocks();

            ret = updateSize < availableBlocks * blockSize;
        }

        return ret;
    }

    private static final class RomUtilHolder {
        @SuppressWarnings("PMD.AccessorClassGeneration")
        private static volatile RomUtil sRomUtil = new RomUtil();
    }
}
