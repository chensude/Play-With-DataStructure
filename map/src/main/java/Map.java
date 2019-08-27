public interface Map<K,V> {

    boolean isEmpty();

    int getSize();

    void set(K key,V value);

    V get(K key);

    void add(K key,V value);

    V remove(K key);

    boolean contains(K key);
}
