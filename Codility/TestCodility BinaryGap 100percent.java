// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        //System.out.println("number original "+N);
        String binaryString = Integer.toString(N,2);
        char arrayChar[] = binaryString.toCharArray();
        //System.out.println("binary "+binaryString);
        int conta = 0;
        int aux = 0;
        int validator = 0;
        for(int i = 0; i < arrayChar.length; i++){
            //System.out.println("arr "+arr);

            if(Character.getNumericValue(arrayChar[i])==0){
                conta++;
                if(conta > aux){
                    if(i+1 < arrayChar.length){
                        if(Character.getNumericValue(arrayChar[i]) != Character.getNumericValue(arrayChar[i+1])){
                            aux = conta;
                        }
                    }
                }
            }
            if(Character.getNumericValue(arrayChar[i]) == 1){
                validator++;
                conta = 0;
            }
        }
        //System.out.println("aux "+aux);
        //System.out.println("validator "+validator);

        if(validator>1 && aux ==0){
            return 0;
        } else if( aux >0 && validator == 1){
            return 0;
        }
        return aux;
    }
}
