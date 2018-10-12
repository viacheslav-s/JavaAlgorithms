package ru.vyacheslav.ja;

public class DoublyRelatedList {
    private class Node {
        Cat c;
        Node next;
        Node prev;
        public Node(Cat c) {
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }
        @Override
        public String toString() {
            return c.toString();
        }
    }

    private Node head;
    private Node tail;

    public DoublyRelatedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        }
        return false;
    }

    public void insertFirst(Cat c) {
        Node n = new Node(c);
        if (isEmpty()) {
            tail = n;
        } else {
            n.prev = head;
        }
        n.next = head;
        head = n;
    }

    public void insertLast(Cat c) {
        Node n = new Node(c);
        if (isEmpty()) {
            head = n;
        } else {
            tail.next = n;
        }
        n.prev = tail;
        tail = n;
    }

    public Cat removeFirst() {
        if (isEmpty())
            return null;
        Cat c = head.c;
        head = head.next;
        return c;
    }

    public Cat removeLast() {
        if (isEmpty())
            return null;
        Cat c = tail.c;
        tail = tail.next;
        return c;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        if (isEmpty())
            return false;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }

    public boolean delete(Cat c) {
        Node n = new Node(c);
        Node current = head;
        Node previous = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return true;
    }
}
