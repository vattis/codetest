package BJ_2467;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {    
   int N;
   int[] arr;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public Solution() throws IOException {
       N = Integer.parseInt(br.readLine());
       arr = new int[N + 1];
       StringTokenizer st = new StringTokenizer(br.readLine());
       for (int i = 0; i < N; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
       }
   }
   int binarySearch(int target, int start, int end){
       int mid = 0;
       int ans = -1;
       while(start <= end){
            mid = (start + end) / 2;
            if(arr[mid] < target){
                start = mid + 1;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                ans = mid;
                return ans;
            }
        }

       int l = Math.abs(target - arr[start]);
       int h = Math.abs(target - arr[end]);
       return l < h ? arr[start] : arr[end];
   }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}

