package imageloader.androidimageloader;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Provides application storage paths.
 *
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public final class StorageUtils {
    //不能new出来
    private StorageUtils() {
    }

    /**
     * Returns application cache directory. Cache directory will be created on SD card if card is mounted.
     *
     * @param context
     * @return Cache directory
     */
    public static File getCacheDirectory(Context context) {
        File appCacheDir;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File appDataDir = new File(Environment.getExternalStorageDirectory(), Constants.APP_DIRECTORY);
            appCacheDir = new File(appDataDir, Constants.APP_CACHE_DIRECTORY);
        } else {
            appCacheDir = context.getCacheDir();
        }
        if (!appCacheDir.exists()) {
            appCacheDir.mkdirs();
        }
        return appCacheDir;
    }
}
