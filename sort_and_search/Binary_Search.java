package sort_and_search;

import java.util.Scanner;

public class Binary_Search {
    public static int search(int [] arr,int key,int low,int high){
        int mid=(low+high)/2;
        if(arr[mid]==key) return mid;
        else if(arr[mid]>key) return search(arr,key,low,mid-1);
        else return search(arr,key,mid+1,high);
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int arr[] = new int[size];
        for (int i = 0;i <= size-1;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the key which you want to search:");
        int key = sc.nextInt();

        System.out.println("Key found at position "+search(arr,key,0,arr.length-1));
    }
}
