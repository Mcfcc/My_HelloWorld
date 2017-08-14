package MyCommons.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author fcc
 * @source http://blog.csdn.net/yanzhenjie1003/article/details/51550264
 * @source org.apache.commons.collections.map.MultiValueMap
 * @Date 2017/8/14.
 */
public interface UniqueKeyMultivaluedMap<K, V> {
    /**
     * Add key-value
     *
     * @Param key key.
     * @Param value value.
     */
    void add(K key, V value);

    /**
     * Add key-List<Value>.
     *
     * @Param key key.
     * @Param values List<value>.
     */

    void add(K key, List<V> values);

    /**
     * Set a Key-Value if the Key exists on the replacement, does not exist to add.
     *
     * @Param key key.
     * @Param values values.
     */

    void set(K key, V value);

    /**
     * Set a Key-List <Value> if the key exists on the replacement, does not exist to add.
     *
     * @Param key key.
     * @Param values values.
     * @see set(Object object)
     */

    void set(K key, List<V> values);

    /**
     * Replace all Key-List <Value>
     *
     * @Param Values values.
     */
    void set(Map<K, List<V>> values);

    /**
     * Remove a Key, and all the values will be removed.
     *
     * @Param K key.
     * @Return value.
     */
    List<V> remove(K key);

    /**
     * Remove all Key-Values.
     */
    void clear();

    /**
     * Get the collection of keys.
     *
     * @Return Set.
     */
    Set<K> keySet();

    /**
     * Get a collection of all the values
     *
     * @Return List.
     */
    List<V> values();

    /**
     * Get the value of one of the keys.
     *
     * @Param K key.
     * @Param index index.
     * @Return The value.
     */
    V getValue(K key, int index);

    /**
     * Get a key corresponding to all the value.
     *
     * @Param K key.
     * @Return values.
     */
    List<V> getValues(K key);

    /**
     * Get Map size.
     *
     * @Return map size.
     */
    int size();

    /**
     * Determine whether the Map is empty.
     *
     * @Return True:empty,False:not empty.
     */
    Boolean isEmpty();

    /**
     * Determine whether the Key is in the Map.
     *
     * @Param K key
     * @Return True:contain,False:none
     */
    Boolean containsKey(K key);
}
