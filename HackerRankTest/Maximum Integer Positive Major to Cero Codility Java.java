// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int aux = 0;
        for(int i =0; i < A.length;i++){
            if(A.length == 0){
                return 1;
            }
            if(i+1 < A.length){
                if(A[i]+1!=A[i+1]){
                    if(aux<A[i]+1){
                        aux=A[i]+1;
                    }
                }
            }
            if(i+1==A.length){
                if(aux ==0){
                    aux = A[i]+1;
                }
            }
        }
        if(aux<=0){
            aux = 1;
        }
        return aux;
    }
}
