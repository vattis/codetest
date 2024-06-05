package BJ_1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Solution solution = new Solution(N, arr);
        solution.divFunc(0, N-1);
        System.out.println(Solution.answer);
    }
}
class Solution{
    static long answer = 0;
    static long[] sorted;

    static long[] arr;
    public Solution(int N, long[] arr_){
        sorted = new long[N];
        arr = arr_;
    }

    public void divFunc(int left, int right){
        if(left < right){
            int mid = (right+left)/2;
            divFunc(left, mid);
            divFunc(mid+1, right);
            mergeFunc(left, right, mid);
        }
    }
    public void mergeFunc(int left, int right, int mid){
        int i = left, j = mid+1, t = left;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                sorted[t] = arr[i];
                i++;
            }
            else{
                sorted[t] = arr[j];
                j++;
                answer += (mid-i+1);
            }
            t++;
        }
        while(i <= mid) {
            sorted[t] = arr[i];
            i++;
            t++;
        }

        while(j <= right) {
            sorted[t] = arr[j];
            j++;
            t++;
        }
        for(int m=left; m<right+1; m++) {
            arr[m] = sorted[m];
        }
    }
}

