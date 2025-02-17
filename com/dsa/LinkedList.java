package com.dsa;

public class LinkedList {

    public class Node {
        private final Integer data;
        private Node next;

        Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    private void InsertAtStart(Integer data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    private void InsertAtEnd(Integer data) {
        if (size == 0) {
            InsertAtStart(data);
            return;
        }

        Node newNode = new Node(data);
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;
    }

    public void insert(Integer data) {
        InsertAtEnd(data);
    }

    public void insert(Integer data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds! Cannot insert.");
            return;
        }
        if (index == 0) {
            InsertAtStart(data);
            return;
        }
        if (index == size) {
            InsertAtEnd(data);
            return;
        }

        Node currNode = head;
        Node newNode = new Node(data);
        int pointer = 0;

        while (pointer < index - 1) {
            currNode = currNode.next;
            pointer++;
        }

        newNode.next = currNode.next;
        currNode.next = newNode;
        size++;
    }

    private void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty! Cannot delete.");
            return;
        }
        if (head.next == null) { // If only one element exists
            head = null;
            size--;
            return;
        }

        Node currNode = head;
        while (currNode.next.next != null) { // Stop at second last node
            currNode = currNode.next;
        }
        currNode.next = null;
        size--;
    }

    private void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty! Cannot delete.");
            return;
        }
        head = head.next;
        size--;
    }

    public void delete() {
        deleteAtEnd();
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds! Cannot delete.");
            return;
        }

        if (index == 0) {
            deleteAtStart();
            return;
        }
        if (index == size - 1) {
            deleteAtEnd();
            return;
        }

        Node currNode = head;
        Node prevNode = null;
        int pointer = 0;

        while (pointer < index) {
            prevNode = currNode;
            currNode = currNode.next;
            pointer++;
        }

        prevNode.next = currNode.next; // Bypass the node to delete
        size--;
    }

    public void display(){
        Node currNode = head;
        while (currNode != null) {  
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("End");
    }
}
