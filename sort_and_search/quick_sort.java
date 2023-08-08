package sort_and_search;

import java.util.Scanner;
public class quick_sort {
    public static void printsort(int val[],int end){
        for (int i = 0; i < end;i++){
            System.out.print(val[i]+" ");
        }
    }
    public static int partiton(int val[],int start,int end){
        int pivot = start;
        int i = start;
        int j = end;
        while(i<j) {
            while (val[i] <= val[pivot] && i<end) {
                i++;
            }
            while (val[j] > val[pivot]) {
                j--;
            }
            if (i < j) {
                int temp = val[i];
                val[i] = val[j];
                val[j] = temp;
            }
        }
        int temp = val[start];
        val[start] = val[j];
        val[j] = temp;
        return j;

    }
    public static void quicksort(int val[],int start,int end){
        if (start<end){
            int pivot = partiton(val,start,end);
            quicksort(val,start,pivot-1);
            quicksort(val,pivot+1,end);
        }
    }
    public static void main(String args[]){
        System.out.println("Enter the number of elements:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter the elements:");
        int val[] = new int[size];
        for (int i=0;i<size;i++){
            val[i] = sc.nextInt();
        }
        for (int i=0;i<size;i++){
            System.out.print(val[i]+" ");
        }
        System.out.println(" ");
        int start=0,end = val.length;
        quicksort(val,start,end-1);
        printsort(val,end);

    }
}
