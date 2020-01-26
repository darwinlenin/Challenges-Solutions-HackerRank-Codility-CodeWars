// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int i = 1;
        int aux = 0;
        while(i <= K){
            for(int j = A.length-1 ; j >=0; j--){
                if(j-1 >= 0){
                    if(j == A.length-1){
                        aux = A[A.length-1];
                    } 
                    A[j]=A[j-1];
                } 
                if(j ==0){ 
                    A[j] = aux ;
                }
            }
            i++;
        }
        return A;
    }
}