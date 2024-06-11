package BJ_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.pow;
//애초에 시작이 0부터였음;;
//DP 유형이 많이 부족하다고 느낌
//비트마스크는 할 만 한듯?
//N이 작을 때 사용하면 효과적
class Solution {
    int DP[][][];
    int[][] arr;
    int K, H, W;
    int[] horseMoveX = {1, 2, 2, 1, -1, -2, -2, -1};
    int[] horseMoveY = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] monkeyMoveX = {0, 1, 0, -1};
    int[] monkeyMoveY = {1, 0, -1, 0};
    public Solution(int[][] a, int k, int h, int w){
        DP = new int[201][201][31];
        K = k; H = h; W = w;
        arr = a;
        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                Arrays.fill(DP[i][j], 10000000);
            }
        }
    }
    public int solution(){
        recur(0, 0, 0, 0);
        int min = 1000000000;
        for(int i = 0; i < K; i++){
            if(DP[W-1][H-1][i] < min){
                min = DP[W-1][H-1][i];
            }
        }
        return min;
    }
    public void recur(int x, int y, int moveCount, int cur){
        int x_, y_;
        if(cur < DP[y][x][moveCount]){
            DP[y][x][moveCount] = cur;
        }else{
            return;
        }
        if(x == W-1 && y == H-1){
            return;
        }
        if(moveCount < K){
            for(int i = 0; i < 8; i++){
                x_ = x + horseMoveX[i];
                y_ = y + horseMoveY[i];
                if(0 <= x_ && x_ <= W-1 && 0 <= y_ && y_ <= H-1){
                    if(arr[y_][x_] == 0){
                        recur(x_, y_, moveCount+1, cur+1);
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            x_ = x + monkeyMoveX[i];
            y_ = y + monkeyMoveY[i];
            if(0 <= x_ && x_ <= W-1 && 0 <= y_ && y_ <= H-1) {
                if (arr[y_][x_] == 0) {
                    recur(x_, y_, moveCount, cur + 1);
                }
            }
        }
        return;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        int K, H, W;
        int[][] arr = new int[201][201];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solution solution = new Solution(arr, K, H, W);
        solution.solution();
    }
}

