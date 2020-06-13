package hashtableADT;

import java.util.ArrayList;

public class Hashtable<K extends Comparable<K>, V> implements HashtableInterface<K, V> {
    private ArrayList<HashNode<K, V>> bucket = new ArrayList<>();
    private int initialCapacity;

    public Hashtable() {
        initialCapacity = 10;
        for (int i = 0; i < initialCapacity; i++) {
            bucket.add(null);
        }
    }

    public Hashtable(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        for (int i = 0; i < initialCapacity; i++) {
            bucket.add(null);
        }
    }

    public int hashfuction(K key) {
        String a = (String) key;
        int sum = 0;
        char[] b = a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            int c = (int) b[i];
            sum = sum + c;
        }
        int index = sum % initialCapacity;
        return index;
    }

    @Override
    public void insert(K key, V value) {
        int index = hashfuction(key);
        HashNode<K, V> node = new HashNode<K, V>(key, value);
        if (bucket.get(index) == null) {
            bucket.set(index, node);
        } else {
            HashNode<K, V> hashNode = bucket.get(index);
            while (hashNode.next != null) {
                hashNode = hashNode.next;
            }
            hashNode.next = new HashNode<K, V>(key, value);
        }
    }

    @Override
    public V search(K key) {
        int index = hashfuction(key);
        if (bucket.get(index) == null) {
            System.out.println("key is null !");
            return null;
        }
        HashNode<K, V> node = bucket.get(index);
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.next;
        }
        System.out.println("Error 404 Not found !");
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashfuction(key);
        if (bucket.get(index) == null) {
            return null;
        } else {
            HashNode<K, V> hashNode = bucket.get(index);
            if (hashNode.getKey().equals(key)) {
                V value = hashNode.getValue();
                bucket.set(index, hashNode.next);
                return value;

            } else {
                System.out.println("here");
                while (hashNode.next != null) {

                    if (hashNode.next.getKey().equals(key)) {
                        V va = hashNode.getValue();
                        hashNode.next = hashNode.next.next;
                        return va;
                    } else {
                        // preNode = hashNode;
                        hashNode = hashNode.next;
                    }
                }
            }
            return null;
        }
    }
    public ArrayList<HashNode<K, V>> getBucket() {
		return bucket;
	}
    public static void main(String[] args) {
        Hashtable<String, String> a = new Hashtable<>();
        a.insert("14", "nguyenham"); // 101
        a.insert("05", "value"); // 101
        System.out.println(a.search("14"));
        System.out.println(a.search("05"));
        System.out.println(a.remove("14"));
        System.out.println(a.search("14"));
        String c = a.search("14");
        System.out.println(c);

    }
}