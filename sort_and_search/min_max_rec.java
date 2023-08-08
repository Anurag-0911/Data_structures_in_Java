package sort_and_search;

import java.util.Scanner;
public class min_max_rec {
    static int min;
    static int max;
    public static void minm_maxm(int arr[],int low,int high){
         max =0;  min = 0;
        if (low==high){
            min=arr[low];
            max=arr[low];
        }
        else if (low == high-1) {
            if (arr[low]<arr[high]){
                min=arr[low];
                max=arr[high];
            }
            else{
                min=arr[high];
                max=arr[low];
            }

        }
        else {
            int mid = (low + high) / 2;
            minm_maxm(arr, low, mid);
            int min1=min;
            int max1=max;
            minm_maxm(arr, mid+1, high);
            if (min1<min){
                min=min1;
            }
            if (max1>max){
                max=max1;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        minm_maxm(arr,0,size-1);
        System.out.println("Max = "+ max);
        System.out.println("Min = "+ min);
    }
}
