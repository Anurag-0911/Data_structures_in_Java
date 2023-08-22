package Linked_list;

public class Doubly_LL {
    public static class node{
        int data;
        node prev;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static class DLL{
        node head = null;
        node tail = null;
        void insert_begin(int val){
            node temp = new node(val);
            if(head==null){
                head=temp;
                tail=temp;
            }
            else{
                head.prev=temp;
                temp.next=head;
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
                tail.next=temp;
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
                head.prev=null;
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
                temp.next=null;
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
                for (int i = 0; i < pos-1; i++) {
                    temp=temp.next;
                }
                node p = temp.next.next;
                temp.next=p;
                p.prev= temp;
            }

        }
        void display(){
            node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        int size(){
            node temp = head;
            int count=0;
            while(temp!=null){
                count++;
                temp = temp.next;
            }
            return count;
        }
    }
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insert_end(0);
        dll.insert_end(1);
        dll.insert_end(2);
        dll.insert_end(3);
        dll.insert_begin(5);
        dll.insert_begin(10);
        dll.insert_begin(15);
        dll.insert_begin(20);
        dll.insert_middle(50,1);
        System.out.println(dll.head.data);
        System.out.println(dll.tail.data);
        dll.display();
        dll.deletion_begin();
        dll.display();
        dll.deletion_end();
        dll.display();
        dll.deletion_middle(3);
        dll.display();
        System.out.println(dll.head.data);
        System.out.println(dll.tail.data);

    }
}
