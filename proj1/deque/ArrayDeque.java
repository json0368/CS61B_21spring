package deque;

import java.util.Iterator;

public class ArrayDeque<Item> implements Iterable<Item>, Deque<Item> {
    private Item[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    private int getArrayIdx(int idx) {
        return (nextFirst + idx + 1) % items.length;
    }

    /** Resize the size of items to newSize*/
    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];

        for(int i = 0; i < size; i++) {
            int idx = getArrayIdx(i);
            newItems[i] = items[idx];
        }

        items = newItems;
        nextFirst = newItems.length - 1;
        nextLast = size;
    }

    @Override
    /**  Adds an item of type Item to the front of the deque. */
    public void addFirst(Item item) {
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) % items.length;
        size++;
    }

    @Override
    /** Adds an item of type Item to the back of the deque.  */
    public void addLast(Item item) {
        if (size == items.length) {
            resize(items.length * 2);
        }

        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }

    @Override
    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    @Override
    /** Prints the items in the deque from first to last, separated by a space.
     Once all the items have been printed, print out a new line. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int idx = getArrayIdx(i);
            System.out.print(get(idx) + " ");
        }
        System.out.println();
    }

    @Override
    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }

        int firstIdx = getArrayIdx(0);
        Item removeItem = get(firstIdx);
        items[firstIdx] = null;
        nextFirst = firstIdx;
        size--;

        if (size < items.length / 4 && size >= 3) {
            resize(items.length / 4);
        }

        return removeItem;
    }

    @Override
    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }

        int lastIdx = getArrayIdx(size - 1);
        Item removeItem = get(lastIdx);
        items[lastIdx] = null;
        nextLast = lastIdx;
        size--;

        if (size < items.length / 4 && size >= 3) {
            resize(items.length / 4);
        }

        return removeItem;
    }

    @Override
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.  */
    public Item get(int idx) {
        return items[idx];
    }

    private class ArrayDequeIterator implements Iterator<Item> {
        private int wisPos;

        public ArrayDequeIterator() {
            wisPos = 0;
        }

        public boolean hasNext() {
            return wisPos < size;
        }

        public Item next() {
            Item returnItem = items[wisPos];
            wisPos++;
            return returnItem;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayDequeIterator();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        ArrayDeque<Item> other = (ArrayDeque<Item>) o;

        if(other.size != size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (other.get(i) != get(i)) {
                return false;
            }
        }

        return true;
    }
}
