package datastructures;

public class LinkedList<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private Node<K, V> head;

    public void add(K key, V value) {
        Node<K, V> currentNode = head;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        head = newNode;
    }

    public V find(K key) {
        Node<K, V> currentNode = head;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public V remove(K key) {
        if (head == null) return null;

        if (head.key.equals(key)) {
            V value = head.value;
            head = head.next;
            return value;
        }

        Node<K, V> prev = head;
        Node<K, V> currentNode = head.next;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                prev.next = currentNode.next;
                return currentNode.value;
            }
            prev = currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
}
