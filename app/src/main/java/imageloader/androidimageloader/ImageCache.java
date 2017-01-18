package imageloader.androidimageloader;

import android.graphics.Bitmap;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/******************************************
 * 类名称：ImageCache
 * 类描述：
 *
 * @version: 2.3.1
 * @author: caopeng
 * @time: 2017/1/18 14:59
 ******************************************/
public class ImageCache extends LimitedCache<String, Bitmap> {

    private int sizeLimit;

    public ImageCache(int sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    @Override
    protected Reference<Bitmap> createReference(Bitmap value) {
        return new WeakReference<>(value);
    }

    @Override
    protected int getSize(Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

    @Override
    protected int getSizeLimit() {
        return sizeLimit;
    }
}