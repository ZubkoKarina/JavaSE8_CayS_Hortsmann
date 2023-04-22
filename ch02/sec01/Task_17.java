package ch02.sec01;
import java.util.Iterator;

public class Queue {
    private Node head;
    private Node tail;
    public void add(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public String remove() {
        if (head == null) {
            return null;
        } else {
            String value = head.value;
            head = head.next;
            return value;
        }
    }
    public Iterator<String> iterator() {
        return new QueueIterator();
    }
    private class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }
    private class QueueIterator implements Iterator<String> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }
        public String next() {
            String value = current.value;
            current = current.next;
            return value;
        }
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        queue.add("five");

        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

