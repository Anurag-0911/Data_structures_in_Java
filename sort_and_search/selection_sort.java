package sort_and_search;

import java.util.*;

public class selection_sort {
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
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (val[j] < val[min]) {
                    min = j;
                }
            }
            int temp = val[min];
            val[min] = val[i];
            val[i] = temp;
        }
        System.out.println("Your sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(val[i] + " ");
        }
    }
}