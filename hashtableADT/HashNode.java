package hashtableADT;

public class HashNode<K,V> {
    K key;
    V value;
    HashNode<K,V> next;

    public HashNode(K key,V value){
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public HashNode<K, V> getNext() {
		return next;
	}
}