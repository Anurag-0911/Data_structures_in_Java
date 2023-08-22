package Queue;

public class Arr_Q {
    public static class A_Q {
        int f = -1;
        int r = -1;
        int size=0;
        int[] arr = new int[10];

        public void enqueue(int val) {
            if (r == 100) {
                System.out.println("Queue is full. ");
                return;
            }
            else if(f==-1){
                f=r=0;
                arr[f]=val;
            }
            else{
                arr[r+1]=val;
                r++;
            }
            size++;
        }
        public void dequeue(){
            if(size==0) System.out.println("Queue is empty. ");
            else{
                f++;
            }
            size--;
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is empty. ");
                return;
            }
            for(int i=f;i<=r;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        A_Q q = new A_Q();
        q.enqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        q.enqueue(20);
        q.enqueue(25);
        q.display();
        q.dequeue();
        q.dequeue();
        q.display();



    }
}
