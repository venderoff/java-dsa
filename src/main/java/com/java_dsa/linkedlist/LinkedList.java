package com.java_dsa.linkedlist;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class LinkedList {

    private Node head;
    private Node tail ;
    private int length ;

    public class Node {
        public Node next;
        public int value;
        Node(int value) {
            this.value = value ;
        }
    }

    LinkedList(int value){
        Node newnode = new Node(value) ;
        head = newnode ;
        tail = newnode ;
        length++ ;
    }

    Node append(int value){
        log.info("Adding Value at the Last-->" + value);
        Node newnode = new Node(value) ;
        tail.next = newnode ;
        tail = newnode ;
        length ++ ;
        return  newnode ;
    }

    Node addFirst(int value){
        log.info("Adding Value at First-->"+ value) ;
        Node newnode = new Node(value) ;
        Node temp = head ;
        newnode.next = temp ;
        head = newnode ;
        length++ ;
        return newnode ;
    }

    Node deleteLast(){
        log.info("Deleting last -->" + tail.value);
        Node temp = head ;
        Node prev = null ;
        while(temp.next != null){
            prev= temp ;
            temp = temp.next ;
        }

        prev.next = null ;
        tail = prev ;
        length-- ;
        return prev ;
    }

    Node deleteFirst(){
        log.info("Deleting the First-->" + head.value) ;

        head = head.next ;
        length-- ;
        return head ;
    }

    void reverse(){
        log.info("Reversing the List");
        Node temp = head ;
        head = tail ;
        tail = temp ;

        Node prev = null ;
        Node after = temp.next ;

        while(temp != null){
            after = temp.next ;
            temp.next = prev ;

            prev = temp ;
            temp = after ;

        }

    }
    void printDetails(){
        Node temp =  head ;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next ;
        }
        System.out.println("Head is -->" + head.value);
        System.out.println("Tail is -->" + tail.value);
        System.out.println("Length is -->" + length);
    }
    Node findNodeAtIndex(int index){

        log.info("Finding Node at index-->" + index);
        Node temp = head ;
        for(int i =0 ; i < length ; i++){

            if(i == index){
                return temp ;
            }
            temp = temp.next ;
        }
        return null ;
    }

    Node middleOfTheList(){
        log.info("finding Middle of the List");
        Node temp = head;
        Node slow = temp ;
        Node fast = temp ;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        System.out.println("Middle of Node is-->" + slow.value);
        return slow ;
    }

    void removeDuplicates(){
        log.info("Remove Duplicates");
        Node temp = head ;
        Node prev = null;
        Set<Integer> list = new HashSet<>() ;
        while(temp != null){

            if(list.contains(temp.value)){
                prev.next = temp.next ;
                length-- ;
            }
            else{
                list.add(temp.value) ;
                prev = temp ;
            }

            tail = prev ;

            temp = temp.next ;
        }

    }



    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.addFirst(0) ;
        for(int i = 2 ; i < 11; i++)
        {
            ll.append(i) ;
        }
//        ll.deleteLast() ;
        ll.deleteFirst();

//        ll.reverse();

        for(int i = 4 ; i < 10; i++)
        {
            ll.append(i) ;
        }
        ll.printDetails();
        System.out.println(ll.findNodeAtIndex(2).value);

        ll.removeDuplicates();
        ll.printDetails();

    }


}
