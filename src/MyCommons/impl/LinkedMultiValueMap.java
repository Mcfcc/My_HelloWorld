package MyCommons.impl;

import MyCommons.dao.UniqueKeyMultivaluedMap;

import java.util.*;

/**
 * Created by Administrator on 2017/8/15.
 */
public class LinkedMultiValueMap<K, V> implements UniqueKeyMultivaluedMap<K, V> {
    protected Map<K, List<V>> mSource = new LinkedHashMap<K, List<V>>();

    public LinkedMultiValueMap() {
    }

    @Override
    public void add(K key, V value) {
        if (key != null) {
            //如果key存在就添加value，不存在就添加key和List<V> values
            if (!mSource.containsKey(key)) {
                mSource.put(key, new ArrayList<V>(2));
            } else {
                mSource.get(key).add(value);
            }
        }
    }

    @Override
    public void add(K key, List<V> values) {
        //遍历List中的value，调用上面的添加方法
        for (V v : values) {
            add(key, v);
        }
    }

    @Override
    public void set(K key, V value) {
        //移除这个key添加一个新的key-value
        mSource.remove(key);
        add(key, value);
    }

    @Override
    public void set(K key, List<V> values) {
        //移除这个key添加一个新的key-value
        mSource.remove(key);
        add(key, values);
    }

    @Override
    public void set(Map<K, List<V>> maps) {
        //移除所有值，遍历Map的值添加进来
        mSource.clear();
        mSource.putAll(maps);
    }

    @Override
    public List<V> remove(K key) {
        return mSource.remove(key);
    }

    @Override
    public void clear() {
        mSource.clear();
    }

    @Override
    public Set<K> keySet() {
        return mSource.keySet();
    }

    @Override
    public List<V> values() {
        //新建一个list保存所有value
        List<V> allList = new ArrayList<V>();
        //遍历所有的key的value添加到list
        Set<K> keyset = mSource.keySet();
        for (K key : keyset) {
            allList.addAll(mSource.get(key));
        }
        return allList;
    }

    @Override
    public V getValue(K key, int index) {
        List<V> values = mSource.get(key);
        if (values != null && index < values.size()) {
            return values.get(index);
        } else {
            return null;
        }
    }

    @Override
    public List<V> getValues(K key) {
        return mSource.get(key);
    }

    @Override
    public int size() {
        return mSource.size();
    }

    @Override
    public Boolean isEmpty() {
        return mSource.isEmpty();
    }

    @Override
    public Boolean containsKey(K key) {
        return mSource.containsKey(key);
    }
}
