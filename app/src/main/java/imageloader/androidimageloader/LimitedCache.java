package imageloader.androidimageloader;

import java.lang.ref.Reference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/******************************************
 * 类名称：LimitedCache
 * 类描述：有限缓存，提供对象存储，对象的大小 ({@link #getSize(Object)})
 * 所有存储对象的大小不会超过大小限制({@link #getSizeLimit()}).<br />
 *
 * @param <K> key type
 * @param <V> value type
 ******************************************/

public abstract class LimitedCache<K, V> {
    /**
     * 包含强引用到存储对象，每一个下一个对象被添加，如果硬盘缓存大小超过限制则删除最后一个对象
     */
    private final LinkedList<V> hardCache = new LinkedList<>();
    /**
     * 没有强引用，如果硬盘缓存包含一个存储对象从这个Map里，然后这个对象不会被GC掉
     */
    private final Map<K, Reference<V>> softMap = new HashMap<>();

    public V get(K key) {
        if (contansKey(key)) {
            Reference<V> reference = softMap.get(key);
            return reference.get();
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        int valueSize = getSize(value);
        int sizeLimit = getSizeLimit();
        //加入硬盘缓存
        if (valueSize < sizeLimit) {
            while (getMapSize() + valueSize > sizeLimit) {
                hardCache.removeLast();
            }
            hardCache.addFirst(value);
        }
        //add to soft cache
        softMap.put(key, createReference(value));
    }

    private int getMapSize() {
        int size = 0;
        for (V v : hardCache) {
            size += getSize(v);
        }
        return size;
    }

    public void clear() {
        hardCache.clear();
        softMap.clear();
    }

    public boolean contansKey(K key) {
        return softMap.containsKey(key);
    }

    protected abstract Reference<V> createReference(V value);

    protected abstract int getSize(V value);

    protected abstract int getSizeLimit();
}