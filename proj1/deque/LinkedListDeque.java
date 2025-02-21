package deque;

import java.util.Iterator;

public class LinkedListDeque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private int size;

    private static class Node<Item> {
        Item item;
        private Node<Item> prev;
        private Node<Item> next;

        Node(Item item, Node<Item> prev, Node<Item> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        head = new Node<Item>(null, null, null);
        head.prev = head; // 形成环状结构
        head.next = head;
        size = 0;
    }

    /**  Adds an item of type Item to the front of the deque. */
    public void addFirst(Item item) {
        Node<Item> newNode = new Node<>(item, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    /** Adds an item of type Item to the back of the deque.  */
    public void addLast(Item item) {
        Node<Item> newNode = new Node<>(item, head.prev, head);
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
       Once all the items have been printed, print out a new line. */
    public void printDeque() {
        Node<Item> current = head.next;
        while (current != head) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Item removeItem = get(0);
        head.next.next.prev = head;
        head.next = head.next.next;
        size--;

        return removeItem;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }

        Item removeItem = get(size() - 1);
        head.prev.prev.next = head;
        head.prev = head.prev.prev;
        size--;

        return removeItem;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.  */
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<Item> current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }

        return current.item;
    }

    /** Same as get, but uses recursion. */
    public Item getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            return getNode(index, head.next);
        }
    }

    /** Helper method that recursively gets the Node at the specified location. */
    private Item getNode(int index, Node<Item> current) {
        if(index == 0) {
            return current.item;
        }else {
            return getNode(index--, current.next);
        }
    }

    private class LinkedListDequeIterator implements Iterator<Item> {
        private int wizPos;

        public LinkedListDequeIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public Item next() {
            Item returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

    public Iterator<Item> iterator() {
        return new LinkedListDequeIterator();
    }

//
//    public boolean equals(Object o) {
//
//    }
}
