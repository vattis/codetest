package BJ_2467;
// 걍 방법도 바로 알 수 있었음
//이진탐색을 나 혼자 만들걸 괜히 블로그꺼 퍼와서 오래걸림
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
       int a, b;
       int ans1 = 0, ans2 = 0;
       int min = 2000000001;
       for(int i = 0; i < N; i++){;
           a = i;
           b = binarySearch(-arr[a], 0, N-1);
          //System.out.println("a = " + a + " b = " + b);
           if(a == b){
               if(a == 0){
                   b = 1;
               }else if(a == N-1){
                   b = N-2;
               }else{
                   if(Math.abs(arr[a] + arr[a-1]) < Math.abs(arr[a] + arr[a+1])){
                       b = a-1;
                   }else{
                       b = a+1;
                   }
               }
           }
           //System.out.println("####a = " + a + " b = " + b);;
           int t = Math.abs(arr[a] + arr[b]);
           if(t < min){
               min = t;
               ans1 = arr[a];
               ans2 = arr[b];
           }
       }
       if(ans1 < ans2){
            System.out.println(ans1 + " " + ans2);
       }
       else{
           System.out.println(ans2 + " " + ans1);
       }
   }
   int binarySearch(int target, int start, int end){;
       int mid = 0;
       int ans = -1;
       while(start <= end){
           //System.out.println("target" + target + " start" + start + " end" + end);
            mid = (start + end) / 2;
            if(arr[mid] < target){
                start = mid + 1;
                if(start == N){
                    return N-1;
                }
            }else if(arr[mid] > target){
                end = mid - 1;
                if(end == -1){
                    return 0;
                }
            }else{
                return mid;
            }
        }
       if(mid == 0){
           int m1 = Math.abs(target - arr[mid]);
           int m2 = Math.abs(target - arr[mid+1]);
           if(m1 < m2){
               return mid;
           }else{
               return mid + 1;
           }
       }else if(mid == N-1){
           int m1 = Math.abs(target - arr[mid]);
           int m2 = Math.abs(target - arr[mid-1]);
           if(m1 < m2){
               return mid;
           }else{
               return mid - 1;
           }
       }else{
           int m1 = Math.abs(target - arr[mid]);
           int m2 = Math.abs(target - arr[mid+1]);
           int m3 = Math.abs(target - arr[mid-1]);
           if(m1 <= m2){
               if(m1 <= m3){
                   return mid;
               }else{
                   return mid-1;
               }
           }else{
               if(m2 <= m3){
                   return mid+1;
               }else{
                    return mid-1;
               }
           }
       }
   }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}