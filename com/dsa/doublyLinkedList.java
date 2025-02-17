package com.dsa;
public class doublyLinkedList{
    
    public class Node {
        private Integer data;
        private Node next;
        private Node prev;
    
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private Integer size;

    public doublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert(int data){
        insertAtEnd(data);
    }

    public void insert(int data,int index){
        if(index < 0 || index > size){
            System.out.println("Index out of bound");
            return;
        }

        if(index == 0){
            insertAtStart(data);
            return;
        }

        if(index == size){
            insertAtEnd(data);
            return;
        }

        Node tempNode = head;
        int temp = 0;

        while(temp < index){
            tempNode = tempNode.next;
            temp++;
        }

        Node newNode = new Node(data);
        newNode.next = tempNode;
        newNode.prev = tempNode.prev;
        tempNode.prev.next = newNode;
        tempNode.prev = newNode;
        
        size++;
    }

    private void insertAtEnd(Integer data){
        Node newNode = new Node(data);

        if(size == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    private void insertAtStart(Integer data){
        Node newNode = new Node(data);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode; 
        }
        size++;
    }

    public void delete(){
        deleteAtEnd();
    }

    public void delete(int index){
        if(index < 0 || index >= size){
            System.out.println("Index out of bound");
            return;
        }
        
        if(index == 0){
            deleteAtStart();
            return;
        }
        
        if(index == size - 1){
            deleteAtEnd();
            return;
        }

        int currIndex = 0;
        Node currNode = head;

        while(currIndex < index){
            currNode = currNode.next;
            currIndex++;
        }

        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;
        
        size--;
    }

    private void deleteAtEnd(){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }
        
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    private void deleteAtStart(){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }
        
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            if(temp.next == null){
                System.out.print(temp.data + " --> End");
                System.out.println(", Size : " + size);
            }
            else{
                System.out.print(temp.data + " --> ");
            }
            temp = temp.next;
        }
    }

    public void invertedDisplay(){
        Node temp = tail;
        while(temp != null){
            if(temp.prev == null){
                System.out.print(temp.data + " --> Start");
                System.out.println(", Size : " + size);
            }
            else{
                System.out.print(temp.data + " --> ");
            }
            temp = temp.prev;
        }
    }
}
