package BJ_1600;
//처음엔 상태를 저장하는 DP형식의 문제로 접근했음
//DP[x좌표][y좌표][horseMove횟수] = 지금까지 해당 노드에 접근한 최단 이동 횟수
//알고리즘은 맞았지만 시간초과 발생
//dfs가 아니라 bfs로 풀자
//메모리 초과가 난 이유
//queue를 사용할 경우 무한루프에 빠지면 queue의 값이 계속 늘어나서 메모리 부족이 뜰 수 있다
//깨달은 것 => 최단 거리 문제는 거의 항상 다익스트라 or bfs를 사용하자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.pow;

class Solution {
    boolean visited[][][];
    int[][] arr;
    int K, H, W;
    int min = 1000000000;
    int[] horseMoveX = {1, 2, 2, 1, -1, -2, -2, -1};
    int[] horseMoveY = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] monkeyMoveX = {0, 1, 0, -1};
    int[] monkeyMoveY = {1, 0, -1, 0};
    public Solution(int[][] a, int k, int h, int w){
        visited = new boolean[201][201][31];
        K = k; H = h; W = w;
        arr = a;
        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                Arrays.fill(visited[i][j], false);
            }
        }
        for(int i = 0; i <= K; i++){
            visited[0][0][i] = true;
        }
    }
    public int solution(){
        int x, y, horseMoveCount, moveCount;
        int x_, y_;
        Queue<CurState> queue = new LinkedList<>();
        queue.add(new CurState(0, 0, 0, 0));
        while(!queue.isEmpty()){
            CurState curState = queue.poll();
            x = curState.x;
            y = curState.y;
            horseMoveCount = curState.horseMoveCount;
            moveCount = curState.moveCount;
            if(x == W-1 && y == H-1){return moveCount;}

            if(horseMoveCount < K){
                for(int i = 0; i < 8; i++){
                    x_ = x + horseMoveX[i];
                    y_ = y + horseMoveY[i];
                    if(0 <= x_ && x_ <= W-1 && 0 <= y_ && y_ <= H-1 && !visited[y_][x_][horseMoveCount+1] && arr[y_][x_] == 0){
                        visited[y_][x_][horseMoveCount+1] = true;
                        queue.add(new CurState(x_, y_, horseMoveCount+1, moveCount+1));
                    }
                }
            }
            for(int i = 0; i < 4; i++){
                x_ = x + monkeyMoveX[i];
                y_ = y + monkeyMoveY[i];
                if(0 <= x_ && x_ <= W-1 && 0 <= y_ && y_ <= H-1 && !visited[y_][x_][horseMoveCount] && arr[y_][x_] == 0){
                    visited[y_][x_][horseMoveCount] = true;
                    queue.add(new CurState(x_, y_, horseMoveCount, moveCount+1));
                }
            }
        }
        return -1;
    }
    public static class CurState{
        public int x, y, horseMoveCount, moveCount;
        public CurState(int x_, int y_, int horseMoveCount_, int moveCount_){
            x = x_; y = y_; horseMoveCount = horseMoveCount_; moveCount = moveCount_;
        }
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
        System.out.println(solution.solution());
    }
}

