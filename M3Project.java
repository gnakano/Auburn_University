import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * CPSC-3273-AO1 -  Module 3 - Programming Assignment
 *
 * @author     Genji Nakano (GZN0006@tigermail.auburn.edu)
 * @author     Wilbur Rotoni (wzr0018@auburn.edu)
 
 * @version    2 February 2020
 *
 * Creates a an array G with with length L of random numbers.
 * Creates an array A starting with length 5,000
 * sorts A in descending order and increses A by 1,000
 * times algorithm to naive sort the A algorithm on each iteration
 */

public class M3Project {

   public static void main(String[] args) throws IOException {
   
      int L = 10000;   // size limit of Array
      int step = 100;
      int minimumArraySize = 5000;
      Random rand = new Random();
      
   /** 
    * Create file F    
    * The user should change this file directory (and file name) of his choosing. It is strongly recommended
    * that the user selects the same path/folder where this source code (i.e. M1Project.java) is saved.
    */   
      File file = new File("F.txt");
      //Instantiating the PrintStream class
      PrintStream stream = new PrintStream(file);
      
      System.setOut(stream);
      //Printing headers to file F
      System.out.println("n,T(n),T(n)/n,T(n)/n^2,T(n)/n^3");
      
      int[] G = new int[L];
         
         // creating array G
      for(int i = 0; i < L; i++) {
         int randomNumberLow = minimumArraySize;
         int randomNumberHigh = L;
         int randomNumber = rand.nextInt(randomNumberHigh - randomNumberLow) + randomNumberLow;
         G[i] = randomNumber;
      }
         
      for (int n = minimumArraySize; n < L + 1; n = n + step) {
         
         // create array A
         int[] A = new int[n];
         
         // copying in array A the first n values from array G
         for(int i = 0; i < n; i++) {
            A[i] = G[i];
         }
         
         // start sorting Array A and also start timing
         double startTime = System.nanoTime()/1000000;   // time in milliseconds
         // sortArrayA);
         
         //int B[] = new int[]{232, 434, 13, 646, 7567, 632, 886, 21323, 353, 4324, 4678, 24, 758, 532423,434, 34324, 5354, 678658, 35345};
         
         //System.out.println("Given Array"); 
         //printArray(A); 
         System.out.println();
         merge_Sort(A, 0, A.length-1);
         
         //System.out.println("\nSorted array"); 
         //printArray(A); 
         double endTime = System.nanoTime()/1000000;   // time in milliseconds
         double Tn = (endTime - startTime);
      
      // create new variables and compute Tn/n, Tn/n^2 and Tn/n^3 
      
         double first = Tn / n;       // T(n)/n
         double second = Tn / Math.pow(n, 2);     // T(n)/n^2
         double third = Tn / Math.pow(n, 3);      // T(n)/n^3
      
      // print n, Tn/n, Tn/n^2 and Tn/n^3  to file F
         printToFileF(n,Tn, first, second, third);
      }
   
   }
   
   public static void printArray(int arr[]) 
   { 
      int n = arr.length; 
      for (int i=0; i<n; ++i) 
         System.out.print(arr[i] + " "); 
      System.out.println(); 
   } 
   
   public static void merge_Sort(int A[], int p, int r) {
      if (p < r) { 
      	// Find the middle point 
         int q = (p + r)/2; 
      
      	// Sort first and second halves 
         merge_Sort(A, p, q); 
         merge_Sort(A , q + 1, r); 
      
      	// Merge the sorted halves 
         merge(A, p, q, r); 
      } 
   
   
   } 
   
   public static void merge(int A[], int p, int q, int r) {
   
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
  
   
   
   
   
   
   // method to sort Array A (a naive sorting method)
   public static void sortArrayA(int A[]) {
   
      for (int i = 0; i < A.length - 1; i++) {
         for (int j = i + 1; j < A. length; j++) {
            if (A[i] < A[j]) {
                     // swap A[i] and A[j]
               int buffer = A[j];
               A[j] = A[i];
               A[i]  = buffer;
            }
         }
      }
   }
   
   // prints n and Tn/n, Tn/n^2, and Tn/n^3 to File F
      
   public static void printToFileF(int n, double Tn, double first, double second,
                                   double third) throws IOException {
   
      try{
         FileWriter fstream = new FileWriter("F.txt",true);
         BufferedWriter out = new BufferedWriter(fstream);
         
         out.newLine();
      
         out.write(n + "," + Tn + "," + first + "," + second + "," + third);
      
         out.close();
      }catch (Exception e){
         System.err.println("Error while writing to file: " +
            e.getMessage());
      }
   }
   
}