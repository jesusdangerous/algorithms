package lab5.FirstTask;

public class HashMap {
    private static class Entry {
        String key;
        int value;
        Entry next;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 1000;
    private Entry[] table;

    public HashMap() {
        table = new Entry[SIZE];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(String key, int value) {
        int index = hash(key);
        Entry current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Entry newEntry = new Entry(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public int get(String key) {
        int index = hash(key);
        Entry current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return 0;
    }

    public void increment(String key) {
        put(key, get(key) + 1);
    }

    public int maxValue() {
        int max = 0;
        for (Entry entry : table) {
            while (entry != null) {
                if (entry.value > max) {
                    max = entry.value;
                }
                entry = entry.next;
            }
        }
        return max;
    }
}
