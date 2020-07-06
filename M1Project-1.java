import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * CPSC-3273-AO1 -  Module 1- Programming Assignment
 *
 * @author     Genji Nakano (GZN0006@tigermail.auburn.edu)
 * @author     Wilbur Rotoni (wzr0018@auburn.edu)
 
 * @version    19 January 2020
 *
 * Creates a an array G with with length L of random numbers.
 * Creates an array A starting with length 5,000
 * sorts A in descending order and increses A by 1,000
 * times algorithm to naive sort the A algorithm on each iteration
 */

public class M1Project-1 {

   public static void main(String[] args) throws IOException {
   
      int L = 100000;   // size limit of Array
      int step = 1000;
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
         sortArrayA(A);
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
         FileWriter fstream = new FileWriter("M1Project-FinalFile F.txt",true);
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