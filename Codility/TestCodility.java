// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(A) {
    // write your code in JavaScript (Node.js 8.9.4)
    A.sort();
    var temp = 1;
    for(var i = 0; i < A.length; i++){
        if(A[i] > 0){
            if(A[i] != A[i-1] + 1){
                temp = A[i] - 1;
            } else {
                temp = A[i] + 1;
            }
        }
    }
    return temp;
}