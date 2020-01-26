// you can also use imports, for example:
//import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int j = 0;
        int[] ATemp = new int[A.length];
        for(int i = 0; i < A.length; i++){
            //System.out.println(A.length);
            if(K == A.length){
                ATemp[j] = A[i];
                j++;
            } else {
                while(j<K){
                    if((i + ((K-1)+j)) < A.length){
                        ATemp[j]=A[i + ((K-1)+j)];
                    } 
                    j++;
                }
                for(int t = 0; t < K; t++){
                     if((K)+t <  A.length){
                        ATemp[(K)+t] = A[t];
                         
                     }
                }
            }
        }
        return ATemp;
    }
}
