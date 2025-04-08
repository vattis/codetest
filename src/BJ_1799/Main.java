package BJ_1799;

//방법은 직관적으로 알았는데 체스의 특성을 이용하는 부분이 생각이 안났음
//비숍 입장에선 체스의 흑백은 독립적이니까 10x10체스판을 전부 생각하는 것이 아니라
//5x5체스판을 두번 생각하는 것이 효율적임
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    int N;
    int Max = 0;
    int ans = 0;
    boolean[][] arr;
    boolean[][] chess;

    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        chess = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = new boolean[N];
            chess[i] = new boolean[N];
            Arrays.fill(arr[i], true);
            Arrays.fill(chess[i], false);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) == 0){
                    arr[i][j] = false;
                }
            }
        }
        recur(0, 0, 0);
        ans += Max;
        Max = 0;
        //System.out.println("==================");
        recur(0, 0, 1);
        ans += Max;
        System.out.println(ans);
    }
    private void recur(int cnt, int i, int j){
        if(cnt > Max){
            Max = cnt;
        }
        if(i == N){
            return;
        }
        //System.out.println("i = " + i + ", j = " + j + ", cnt = " + cnt);
        if(arr[i][j] && check(i,j)){

            //기물을 두는 경우
            chess[i][j] = true;
            if(j+2 >= N){
                if(j % 2 == 0){
                    recur(cnt+1, i+1, 1);
                }else{
                    recur(cnt+1, i+1, 0);
                }
            }else{
                recur(cnt+1, i, j+2);
            }
            chess[i][j] = false;
        }

        //기물을 두지 않는 경우
        if(j+2 >= N){
            if(j % 2 == 0){
                recur(cnt, i+1, 1);
            }else{
                recur(cnt, i+1, 0);
            }
        }else{
            recur(cnt, i, j+2);
        }
    }

    private boolean check(int i, int j){
        int[] dx = {-1, 1, 1, -1};
        int[] dy = {-1, 1, -1, 1};
        for(int t = 0; t < 4; t++){
            int nx = j + dx[t];
            int ny = i + dy[t];
            while(0 <= nx && nx < N && 0 <= ny && ny < N){
                if(chess[ny][nx]){
                    return false;
                }
                nx += dx[t];
                ny += dy[t];
            }
        }
        return true;
    }

}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}