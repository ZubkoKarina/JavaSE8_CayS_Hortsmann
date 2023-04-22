package ch02.sec01;
public class Queue {
    private Node head;
    private Node tail;
    private static class Node {
        String data;
        Node next;
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    public void add(String data) {
        Node newNode = new Node(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
    }
    public String remove() {
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("Hello");
        queue.add("World");
        queue.add("!");
        System.out.println(queue.remove()); // "Hello"
        System.out.println(queue.remove()); // "World"
        System.out.println(queue.remove()); // "!"
        System.out.println(queue.remove()); // null
    }
}

