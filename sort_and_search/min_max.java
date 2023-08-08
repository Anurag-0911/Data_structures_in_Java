package sort_and_search;

import java.util.*;
public class min_max {
    public static void main(String args[]) {
        System.out.println("Enter the size of the array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int arr[] = new int[size];
        for (int i = 0; i <= size - 1; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i <= arr.length-1; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("The maximum number is:" +max);
        System.out.println("The minimum number is:" +min);
    }
}