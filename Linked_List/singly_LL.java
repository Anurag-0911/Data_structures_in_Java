package Linked_list;

import java.util.Scanner;

public class singly_LL {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static class LL{
        node head = null;
        node tail = null;
        void insert_end(int val){
            node temp = new node(val);
            if(head==null){
                head = temp;
                tail = temp;
            }
            else{
                 tail.next=temp;
                 tail=temp;
            }
        }
        void insert_begin(int val){
            node temp = new node(val);
            if(head==null){
                head=temp;
                tail=temp;
            }
            else{
                temp.next=head;
                head=temp;
            }
        }
        void insert_middle(int val,int pos){
            node temp = new node(val);
            node p = head;
            if(pos==size()){
                insert_end(val);
                return;
            }
            else if(pos==0){
                insert_begin(val);
                return;
            }
            for (int i = 1; i < pos; i++) {
                p=p.next;
            }
            temp.next=p.next;
            p.next=temp;

        }
        void deletion_begin(){
            if(head.next==null){
                head=null;
                tail=null;
            }
            else{
                head=head.next;
            }
        }
        void deletion_end(){
            node temp=head;
            for (int i = 1; i < size()-1 ; i++) {
                temp=temp.next;
            }
            temp.next=null;
            tail=temp;

        }
        void deletion_middle(int pos){
            node p = head;

            for (int i = 1; i < pos; i++) {
                p=p.next;
            }
            node q = p.next.next;
            p.next=q;
        }
        void display(){
            node temp = head;
            while(temp!=null){
                System.out.print(temp.data +" ");
                temp=temp.next;
            }
            System.out.println();
        }
        int size(){
            int count=0;
            node temp = head;
            while(temp!=null){
                count++;
                temp=temp.next;
            }
            return count;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LL ll = new LL();
        ll.insert_end(5);
        ll.insert_end(10);
        ll.insert_end(15);
        ll.insert_end(25);
        ll.insert_end(30);
        ll.insert_begin(0);
        ll.insert_middle(20,0);


        System.out.println(ll.tail.data);
        System.out.println(ll.head.data);
        ll.display();
        ll.deletion_end();
        ll.deletion_end();
        ll.deletion_middle(3);
        ll.display();
        System.out.println(ll.tail.data);
        ll.deletion_begin();
        ll.display();
        System.out.println(ll.head.data);
        System.out.println(ll.tail.data);

































//        do {
//            System.out.println("Enter 1 for insertion");
//            System.out.println("Enter 2 for deletion");
//            System.out.println("Enter 3 for displaying");
//            System.out.println("Enter 0 to exit.");
//            choice = sc.nextInt();
//            if(choice==1){
//                System.out.println("Enter the value to be inserted: ");
//                int val = sc.nextInt();
//                System.out.println("Enter the position: ");
//                int pos = sc.nextInt();
//                insertion(head,val,pos);
//            }
//            else if(choice==2){
//                System.out.println("Enter any position for deletion: ");
//                int pos = sc.nextInt();
//                deletion(head,pos);
//            }
//            else if(choice==3){
//                display(head);
//            }
//        }while(choice!=0);
    }
}
