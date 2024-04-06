package BJ_1019;

import java.util.Scanner;

class Tool {
    public int cntBetween(int a, int b){
        return b-a+1;
    }
    public int[] cntNum(int num){
        int[] arr = new int[10];
        while(num != 0){
            arr[num%10]++;
            num/=10;
        }
        return arr;
    }
    public int[] trimNum(int a, int b, int tenPow){
        int[] arr = new int[12];
        while(a <= b && a%10 != 0){
            for(int i = 0; i < 10; i++){
                arr[i]+=cntNum(a)[i]*tenPow;
            }
            a++;
        }
        if(a <= b){
            while(a <= b && b%10 != 9){
                for(int i = 0; i < 10; i++){
                    arr[i]+= cntNum(b)[i]*tenPow;
                }
                b--;
            }
        }
        else{
            arr[10] = a; arr[11] = b;
            return arr;
        }
        arr[10] = a; arr[11] = b;
        return arr;
    }
}
class Solution{
    public int[] solution(int A, int B){
        Tool t = new Tool();
        int[] ans = new int[10];
        int[] arr;
        int tenPow = 1;
        while(A <= B && A != 0){
            arr = t.trimNum(A, B, tenPow);
            A = arr[10]/10; B = arr[11]/10;
            for(int i = 0; i < 10; i ++){
                ans[i] += arr[i];
                if(A != 0){
                    ans[i] += t.cntBetween(A, B)*tenPow;
                }
            }
            tenPow *= 10;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] ars) {
        int N;
        int[] answer;
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        N = sc.nextInt();
        answer = sol.solution(1, N);
        for(int i = 0; i < 10; i++){
            System.out.println(answer[i]);
        }
    }
}