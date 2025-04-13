package lab8.FourthTask;

public class HashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K,V>[] table;
    private int size;
    private int capacity;
    private final float loadFactor = 0.75f;

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.capacity = 16;
        this.table = (Node<K,V>[]) new Node[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        return (key == null ? 0 : key.hashCode()) & (capacity - 1);
    }

    public V get(K key) {
        int index = hash(key);
        Node<K,V> node = table[index];
        while(node != null) {
            if((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int index = hash(key);
        Node<K,V> node = table[index];
        while(node != null) {
            if((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }

        Node<K,V> newNode = new Node<>(key, value, table[index]);
        table[index] = newNode;
        size++;

        if (size >= capacity * loadFactor) {
            resize();
        }
        return null;
    }

    public V getOrDefault(K key, V defaultValue) {
        V value = get(key);
        return value != null ? value : defaultValue;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = capacity;
        capacity = capacity * 2;
        Node<K,V>[] oldTable = table;
        table = (Node<K,V>[]) new Node[capacity];
        size = 0;
        for (int i = 0; i < oldCapacity; i++) {
            Node<K,V> node = oldTable[i];
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }
}