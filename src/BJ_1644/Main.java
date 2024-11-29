package BJ_1644;

//에라토스테네스의 체로 소수를 걸러내고
//걸러낸 소수를 start와 end범위를 조정해가면서 조건에 만족하는 경우의 수를 찾는 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int N;
    int ans = 0;
    boolean[] oddNums = new boolean[4000001];
    ArrayList<Integer> oddNumList = new ArrayList<Integer>();
    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arrays.fill(oddNums, true);
        oddNums[1] = false;
        for(int i = 2; i <= N; i++) {
            if (oddNums[i]) {
                int n = i*2;
                while (n <= 4000000){
                    oddNums[n] = false;
                    n += i;
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(oddNums[i]){
                oddNumList.add(i);
            }
        }
        oddNumList.add(0);
        int start = 0;
        int end = 0;
        int sum = 2;
        while(end < oddNumList.size()-1){
            if(sum < N){
                end++;
                sum += oddNumList.get(end);
            }else if(sum > N){
                sum -= oddNumList.get(start);
                start++;
            }else {
                ans++;
                end++;
                sum += oddNumList.get(end);
            }
        }
        System.out.println(ans);
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}

