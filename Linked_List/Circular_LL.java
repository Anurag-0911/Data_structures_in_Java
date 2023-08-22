package Linked_list;

import java.util.Scanner;

public class Circular_LL {
    public static class node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data=data;
        }
    }
    public static class CLL{
        node head = null;
        node tail = null;
        void insert_begin(int val){
            node temp = new node(val);
            if(head==null){
                head=temp;
                tail=temp;
            }
            else{
                temp.next=head;
                temp.prev=tail;
                head.prev=temp;
                tail.next=temp;
                head=temp;
            }
        }
        void insert_end(int val){
        node temp = new node(val);
            if(head==null){
                head=temp;
                tail=temp;
            }
            else{
                temp.prev=tail;
                temp.next=head;
                tail.next=temp;
                head.prev=temp;
                tail=temp;
            }
        }
        void insert_middle(int val,int pos){
            node temp = new node(val);
            if(pos==0){
                insert_begin(val);
                return;
            }
            else if(pos==size()){
                insert_end(val);
                return;
            }
            else{
                node p = head;
                for (int i = 0; i < pos-1; i++) {
                    p=p.next;
                }
                temp.next=p.next;
                temp.prev=p;
                p.next.prev=temp;
                p.next=temp;
            }
        }
        void deletion_begin(){
            if(head.next==null){
                head=null;
                tail=null;
            }
            else{
                node temp=head;
                head=head.next;
                tail.next=head;
                head.prev=tail;

            }
        }
        void deletion_end(){
            if(head.next==null){
                head=null;
                tail=null;
            }
            else{
                node temp=head;
                for (int i = 1; i < size()-1; i++) {
                    temp=temp.next;
                }
                temp.next=head;
                tail=temp;
            }
        }
        void deletion_middle(int pos){
            node temp = head;
            if(pos==0){
                deletion_begin();
                return;
            }
            else if(pos == size()){
                deletion_end();
                return;
            }
            else{
                for (int i = 1; i < pos-1; i++) {
                    temp=temp.next;
                }
                node p = temp.next.next;
                temp.next=p;
                p.prev= temp;
            }

        }
        void display(){
            node temp = head;
            System.out.print(temp.data+" ");
            temp=temp.next;
            while(temp!=head){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        int size(){
            node temp = head;
            temp=temp.next;
            int count=1;
            while(temp!=head){
                count++;
                temp = temp.next;
            }
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLL cll = new CLL();
        int n=-1;
        do{
            System.out.println("Enter 1 for insertion in linked list.");
            System.out.println("Enter 2 for deletion in linked list.");
            System.out.println("Enter 3 for displaying the linked list.");
            System.out.println("Enter 0 to finish the exection.");
            n = sc.nextInt();
            if(n==1){
                System.out.println("Enter the number which you want to insert.");
                System.out.println("Choose the position");
                int val = sc.nextInt();
                int pos = 0;
            }
        }
        while(n!=0);
        cll.insert_end(0);
        cll.insert_end(1);
        cll.insert_end(2);
        cll.insert_end(3);
        cll.insert_begin(5);
        cll.insert_begin(10);
        cll.insert_begin(15);
        cll.insert_begin(20);
        cll.insert_middle(50,1);
        System.out.println(cll.head.data);
        System.out.println(cll.tail.data);
        cll.display();
        cll.deletion_begin();
        cll.display();
        cll.deletion_end();
        cll.display();
        cll.deletion_middle(3);
        cll.display();
        System.out.println(cll.head.data);
        System.out.println(cll.tail.data);

    }
}
