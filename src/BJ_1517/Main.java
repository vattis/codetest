package BJ_1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
class Solution{
    static int answer = 0;
    public void devFunc(long[] arr, int N){
        if(N == 1){
            return arr;
        }
    }
    public long[] mergeFunc(long[] arr1, long[] arr2){
        int i = 0, j = 0, t = 0;
        long[] ans = new long[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                ans[t] = arr1[i];
                i++;
            }
            else{
                ans[t] = arr2[j];
                j++;
                answer += arr2.length-i;
            }
            t++;
        }
        if(i < arr1.length){
            for(; i < arr1.length; i++){
                ans[t] = arr1[i];
                t++;
            }
        }
        else if(j < arr2.length){
            for(; j < arr2.length; j++){
                ans[t] = arr1[j];
                t++;
            }
        }
        return ans;
    }
}

