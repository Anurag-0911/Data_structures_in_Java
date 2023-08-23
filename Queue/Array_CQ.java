package Queue;

public class Array_CQ {
    public static class CQ{
        int f=-1;
        int r=-1;
        int size=0;
        int [] arr = new int[4];
        public void enqueue(int val){
            if(size==0){
                f=r=0;
                arr[0]=val;
            }
            else if(size==arr.length){
                System.out.println("Queue is full");
                return;
            }
            else if(r==arr.length-1){
                r=0;
                arr[0]=val;
            }
            else if(r<arr.length-1){
                r++;
                arr[r]=val;
            }
            size++;
        }
        public int dequeue(){
            if(size==0){
                System.out.println("Queue is empty!");
                return -1;
            }
            int temp = arr[f];
            if(f==arr.length-1){
                f=0;
            }
            else f++;
            size--;
            return temp;
        }
        public void display(){

            if(size==0){
                System.out.println("Queue is empty!");
                return;
            }
            if(f<=r){
                for(int i=f;i<=r;i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }
            else{
                for(int i=f;i<=arr.length-1;i++){
                    System.out.print(arr[i]+" ");
                }
                for(int i=0;i<=r;i++){
                    System.out.print(arr[i]+" ");
                }
            }
        }
    }
    public static void main(String[] args) {
        CQ q = new CQ();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.display();
        q.dequeue();
        q.display();
        q.enqueue(8);
        q.display();                                     // this just prints the actual element of the array you might not be able to see the actual working of circular queue.
        for(int i=0;i<q.arr.length;i++){
            System.out.print(q.arr[i]+" ");              // for watching actual work of circular queue
        }
    }
}
