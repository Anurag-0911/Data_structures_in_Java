package sort_and_search;

import java.util.*;

public class insertion_sort {


    public static void main(String[] args) {

        System.out.println("Enter the size of your array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter the elements of your array:");
        int val[] = new int[size];
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            System.out.print(val[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < size; i++) {
        int key = val[i];
        int j = i-1;
        while (j >= 0 && key < val[j]){
            val[j+1]  = val[j];
            j--;
        }
        val[j+1] = key;
        }
        System.out.println("Your sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(val[i] + " ");
        }
    }
}
