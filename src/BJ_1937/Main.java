package BJ_1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Math.max;

//DP 문제를 처음으로 제대로 푼 느낌
//중요한건 DP를 입력하고 나서 어지간하면 바뀌지 않는 방향으로 DP를 설정해야한다는 것
//처음엔 단순히 팬더가 시작 노드부터 현재 노드까지 지나온 길을 DP 값으로 설정했지만,
//DP=recur()로 설정해서 팬더가 현재 노드에서 갈 수 있는 최댓값을 DP 값으로 설정함

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution());
    }
    public static class Solution {
        int n, ans;
        int[][] arr = new int[504][504];
        int[][] DP = new int[504][504];
        final int[] moveX = {0, 0, -1, 1};
        final int[] moveY = {-1, 1, 0, 0};
        public Solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(DP[i], -1);
            }
        }
        public int recur(int x, int y){
            if(DP[y][x] != -1){
                return DP[y][x];
            }
            DP[y][x] = 1;
            int curX, curY;
            int max = 0;
            for(int i = 0; i < 4; i++){
                curX = x + moveX[i];
                curY = y + moveY[i];
                if(curX<0 || curY<0 || curX>=n || curY>=n){
                    continue;
                }
                if(arr[curY][curX]>arr[y][x]){
                    DP[y][x] = max(DP[y][x], recur(curX, curY)+1);
                }
            }
            return DP[y][x];
        }
        public int solution(){
            int ans = -1;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    ans = max(ans, recur(j, i));
                }
            }
            return ans;
        }
        public boolean isMin(int x, int y){
            int curX, curY;
            for(int i = 0; i < 4; i++){
                curX = x + moveX[i];
                curY = y + moveY[i];
                if(curX<0 || curY<0 || curX>=n || curY>=n){
                    continue;
                }
                if(arr[y][x] >= arr[curY][curX]){
                    return false;
                }
            }
            return true;
        }
    }
}

