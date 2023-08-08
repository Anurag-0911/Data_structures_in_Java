package sort_and_search;

import java.util.*;
public class Linear_search {
    public static void main(String args[]){
        System.out.println("Enter the size of the array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int arr[] = new int[size];
        for (int i = 0;i <= size-1;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the key which you want to search:");
        int x = sc.nextInt();
        for (int i = 0;i <= arr.length;i++){
            if (i == x){
                System.out.println("Your key " + x + " is found at " + i );
            }
        }
    }
}
