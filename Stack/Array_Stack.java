package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Array_Stack {
    public static class Stack{
        int[] arr = new int[5];
        int top = -1;
        void push(int val){
            if(top>=size()-1){
                System.out.println("Stack Overflow.");
                return;
            }
            top++;
            arr[top]=val;
        }
        void pop(){
            if(top<0){
                System.out.println("Stack underflow.");
                return;
            }
            int temp = arr[top];
            top--;
        }
        void display(){
            System.out.println();
            System.out.println("Your Stack is: ");
            for (int i=top;i>=0;i--) {
                System.out.println(arr[i] + " ");
            }
            System.out.println();
        }
        int size(){
            return 5;
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
