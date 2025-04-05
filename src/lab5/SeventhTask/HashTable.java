package lab5.SeventhTask;

import datastructures.LinkedList;

public class HashTable<K, V> {
    private LinkedList<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = capacity;
    }

    private int hash(K key) {
        String strKey = key.toString();
        int hash = 0;
        int p = 31; // простое число
        int m = size; // модуль — размер таблицы

        for (int i = 0; i < strKey.length(); i++) {
            hash = (hash * p + strKey.charAt(i)) % m;
        }

        return Math.abs(hash);
    }

    public void put(K key, V value) {
        int index = hash(key);
        table[index].add(key, value);
    }

    public V get(K key) {
        int index = hash(key);
        return table[index].find(key);
    }

    public V delete(K key) {
        int index = hash(key);
        return table[index].remove(key);
    }
}
