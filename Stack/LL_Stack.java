package Stack;

import java.util.Scanner;

public class LL_Stack {
    public static class node {
        int val;
        node next;
        node(int val){
            this.val=val;
        }
    }
    public static class Stack{
        node head = null;
        void push(int val){
            node temp = new node(val);
//            if(head==null){
//                head = temp;
//            }
//            else{
//                temp.next=head;
//                head=temp;
//            }
            temp.next=head;
            head=temp;
        }
        void pop(){
            if(head==null) System.out.println("Stack underflow.");
            else head=head.next;
        }
        void display(){
            node temp = head;
            System.out.println();
            if(temp==null) System.out.println("Stack is empty");
            while(temp!=null){

                System.out.println(temp.val + " ");
                temp=temp.next;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        int val;
        int user_ch;
        do {
            System.out.println("Enter 1 for Push operation");
            System.out.println("Enter 2 for Pop operation");
            System.out.println("Enter 3 for displaying Stack");
            System.out.println("Enter 0 to exit.");
            System.out.print("Please Enter your choice: ");
            user_ch = sc.nextInt();

            if (user_ch == 1) {
                System.out.print("Enter the Elements to push in stack. ");
                val = sc.nextInt();
                s.push(val);
            } else if (user_ch == 2) {
                s.pop();
            }
            else if (user_ch == 3) {
                s.display();
            }
            else{
                System.out.println("Invalid choice.");
            }
        } while (user_ch != 0);
    }
}
