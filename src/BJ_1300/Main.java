package BJ_1300;
//이분탐색을 이용해서 답을 구함
//핵심은 x보다 작은 숫자를 어떻게 구하느냐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();

    }
}
class Solution{
    int N, K;
    Map<Long, Long> map = new HashMap<>();
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        Long start = 1L;
        Long end = K*1L;
        Long mid;
        while(start < end){
            mid = (start+end)/2;
            if(K<=countLessNum(mid)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(start);
    }
    public Long countLessNum(Long num){
        Long ans = 0L;
        for(int i = 1; i <= N; i++){
            ans += Math.min(num/i, N);
        }
        return ans;
    }
}

