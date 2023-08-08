package sort_and_search;

import java.util.Scanner;

public class merge_sort {
    static void printsort(int val[],int size){
        for (int i = 0; i < size;i++){
            System.out.print(val[i]+" ");
        }
    }
    static void merging(int val[], int mid, int low, int high) {
        int i, j, k;
        int[] arr = new int[10];
        i = low;
        j = mid + 1;
        k = low;

        while (i <= mid && j <= high) {
            if (val[i] < val[j]) {
                arr[k] = val[i];
                i++;
            } else {
                arr[k] = val[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = val[i];
            k++;
            i++;
        }
        while (j <= high) {
            arr[k] = val[j];
            k++;
            j++;
        }
        for (int l = low; l <= high; l++) {
            val[l] = arr[l];
        }
    }
    static void mergeSort(int [] val,int size,int low,int high) {
         if (low<high) {
            int mid = (low + high) / 2;
            mergeSort(val,size,low,mid);
            mergeSort(val,size,mid+1,high);
            merging(val,mid,low,high);
        }

    }
    public static void main(String[] args) {
        System.out.println("Enter the size of your array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter the elements of your array:");
        int val[] = new int[size];
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
        }
        printsort(val,size);
        int low=0,high=size-1;
        mergeSort(val,size,low,high);
        System.out.println("Your sorted array is:");
        printsort(val,size);
    }

}



//        int pivot = val[end];
//        int i = start-1;
//        for (int j = start;j < end;j++){
//            if (val[j]<pivot){
//                i++;
//                int temp = val[i];
//                val[i] = val[j];
//                val[j] = temp;
//            }
//        }
//        i++;
//        int temp = val[i];
//        val[i] = val[end];      //end == pivot
//        val[end] = temp;
//        return i;