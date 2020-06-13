package hashtableADT;

public interface HashtableInterface<K extends Comparable<K>, V> {
    public void insert(K key, V value);
    public V search(K key);
    public V remove (K key);


}