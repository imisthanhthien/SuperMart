/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Admin
 */
/*public class test {
    int n=7;
    int k=3;
    int x[]=new int[500];
    public void toHopAvatar(int i) {

    for (int j = x[i-1] + 1; j <= n-k+i; j++)  {
        x[i] = j;
        if (i == k)
            Xuat();
        else
            toHopAvatar (i+1);
    }
}
    private void Xuat() {
      
     for (int i = 1; i <= k; i++)
    {
        System.out.print(" "+(x[i]-1));
    }
    System.out.println("\n");
     
    
    }
    public static void main(String[] args) {
        test t=new test();
        t.toHopAvatar(1);
    }
}*/
// CPP program to count
// subarrays having sum
// less than k.
import java.util.*;
public class testx {
 
    // Function to find all unique combination of
    // given elements such that their sum is K
 void unique_combination(int l, int sum, int K,
                                   Vector<Integer> local,
                                   Vector<Integer> A)
    {
        // If a unique combination is found
        if (sum == K) {
            System.out.print("{");
            for (int i = 0; i < local.size(); i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(local.get(i));
                if (i != local.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("}");
            return;
        }
 
        // For all other combinations
        for (int i = l; i < A.size(); i++) {
 
            // Check if the sum exceeds K
            if (sum + A.get(i) > K)
                continue;
 
            // Check if it is repeated or not
            if (i > l && A.get(i) == A.get(i - 1) )
                continue;
 
            // Take the element into the combination
            local.add(A.get(i));
 
            // Recursive call
            unique_combination(i + 1, sum + A.get(i), K,
                               local, A);
 
            // Remove element from the combination
            local.remove(local.size() - 1);
        }
    }
 
    // Function to find all combination
    // of the given elements
    void Combination(Vector<Integer> A, int K)
    {
        // Sort the given elements
        Collections.sort(A);
 
        // To store combination
        Vector<Integer> local = new Vector<Integer>();
 
        unique_combination(0, 0, K, local, A);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        testx t=new testx();
        Integer[] arr = { 2,
8,
11,
15,
22,
25,
30,
33,
39,
48,
50,
51,
52,
101,
103,
153,
102,
48,
21,
34,
77,
88,
102,
36,
110,
127,
149 };
         List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(arr));
        Integer[] arr2=new Integer[10000];
        for(int i=0;i<27;i++ )
        {
           // arr2[i]=arr[i];
            list1.add(arr[i]);
           // System.out.println(""+arr2[i]);
        }
         for(int i=0;i<27;i++ )
        {
            //System.out.println(""+arr2[i]);
        }
        
        
        Vector<Integer> A = new Vector<Integer>(list1);
 
        int K = 386;
 t.Combination(A, K);
        // Function call
    }
}
 
// This code is contributed by PrinciRaj1992

