package lab7.TenthTask;

import java.util.*;

class MySet<E> implements Iterable<E> {
    private Node<E>[] table;
    private int size;

    static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    public MySet() {
        table = new Node[16];  // Начальный размер таблицы
        size = 0;
    }

    private int hash(E key) {
        return key.hashCode() % table.length;
    }

    public boolean add(E value) {
        int index = hash(value);
        Node<E> newNode = new Node<>(value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<E> current = table[index];
            while (current != null) {
                if (current.value.equals(value)) {
                    return false;  // Уже существует
                }
                current = current.next;
            }
            newNode.next = table[index];
            table[index] = newNode;
        }

        size++;
        return true;
    }

    public boolean contains(E value) {
        int index = hash(value);
        Node<E> current = table[index];

        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    // Реализация метода iterator для Iterable интерфейса
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            private Node<E> currentNode = null;

            @Override
            public boolean hasNext() {
                while (index < table.length && (currentNode == null || currentNode.next == null)) {
                    if (table[index] != null) {
                        currentNode = table[index];
                        index++;
                    } else {
                        index++;
                    }
                }
                return currentNode != null;
            }

            @Override
            public E next() {
                E value = currentNode.value;
                currentNode = currentNode.next;
                return value;
            }
        };
    }
}