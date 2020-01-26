// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int[] resp = new int[A.length];
        int counter = 0;
        int value = 0;
        for(int i = 0; i < A.length; i++){
            //System.out.println(A[i]);
            if(i+1<A.length){
                if(A[i]!=A[i+1]){
                    if(counter==0){
                        resp[i]= A[i];
                    } else if(counter>0){
                        counter=0;
                    }
                } else if(A[i]==A[i+1]){
                    counter++;
                }
            }
        }
        for(int r : resp){
            value+=r;
        }
        return value;
    }
}