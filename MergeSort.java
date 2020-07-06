import java.io.*;
import java.lang.*;
import java.util.*;


/* Java program for Merge Sort */
class MergeSort 
{ 

   public void merge_sort(int A[], int p, int r) { 
      if (p < r) { 
      	// Find the middle point 
         int q = (p + r)/2; 
      
      	// Sort first and second halves 
         merge_sort(A, p, q); 
         merge_sort(A , q + 1, r); 
      
      	// Merge the sorted halves 
         merge(A, p, q, r); 
      } 
   } 

	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
   void merge(int A[], int p, int q, int r)  { 
   	// Find sizes of two subarrays to be merged 
      int n1 = q - p + 1; 
      int n2 = r - q; 
      
      //System.out.println("The n1 is: " + n1);
      //System.out.println("The n2 is: " + n2);
   
   
   	/* Create temp arrays */
      int L[] = new int [n1 + 1]; 
      int R[] = new int [n2 + 1]; 
      
   
   	/*Copy data to temp arrays*/
      for (int i = 0; i < n1; i++) 
         L[i] = A[p + i]; 
      for (int j = 0; j < n2; j++) 
         R[j] = A[q + j + 1]; 
         
      L[n1] = 0xffffffff;
      R[n2] = 0xffffffff;
   
   	/* Merge the temp arrays */
   
   	// Initial indexes of first and second subarrays 
      int i = 0;
      int j = 0; 
   
      int k = p;
      while (i < n1 && j < n2) 
      { 
         if (L[i] <= R[j]) 
         { 
            A[k] = L[i]; 
            i++; 
         } 
         else
         { 
            A[k] = R[j]; 
            j++; 
         } 
         k++; 
      } 
   
   	/* Copy remaining elements of L[] if any */
      while (i < n1) 
      { 
         A[k] = L[i]; 
         i++; 
         k++; 
      } 
   
   	/* Copy remaining elements of R[] if any */
      while (j < n2) 
      { 
         A[k] = R[j]; 
         j++; 
         k++; 
      } 
             
   
   } 

	// Main function that sorts arr[l..r] using 
	// merge() 


	/* A utility function to print array of size n */
   static void printArray(int A[]) 
   { 
      int n = A.length; 
      for (int i=0; i<n; ++i) 
         System.out.print(A[i] + " "); 
      System.out.println(); 
   } 

	// Driver method 
   public static void main(String args[]) 
   { 
      int A[] = {12, 11, 13, 5, 6, 7}; 
   
      System.out.println("Given Array"); 
      printArray(A); 
   
      MergeSort ob = new MergeSort(); 
      ob.merge_sort(A, 0, A.length-1); 
   
      System.out.println("\nSorted array"); 
      printArray(A); 
   } 
} 
