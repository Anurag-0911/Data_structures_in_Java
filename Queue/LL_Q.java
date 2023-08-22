package Queue;

public class LL_Q {
    public static class node{
        int val;
        node next;
        node(int val){
            this.val = val;
        }
    }
    public static class linkedQ{
        node head = null;
        node tail = null;
        public void enqueue(int val){
            node temp = new node(val);
            if(head == null) head = tail = temp;
            else{
                tail.next = temp;
                tail=temp;
            }
        }
        public void dequeue(){
            if(head==null){
                System.out.println("Queue is empty");
                return;
            }
            head = head.next;
        }
        public void display(){
            node temp = head;
            if(temp==null){
                System.out.println("Queue is empty");
                return;
            }
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        linkedQ q = new linkedQ();
        q.enqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        q.enqueue(20);
        q.enqueue(25);
        q.display();
        q.dequeue();
        q.display();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
    }
}
