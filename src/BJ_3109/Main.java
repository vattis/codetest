package BJ_3109;

//천천히 생각해보고 걍 아이디어를 떠올렸음
//어차피 파이프 교차는 불가능 하기 때문에 파이프가 꼬이면 안됨
//따라서 위에서부터 파이프를 위로 몰아서 설치하는 것이 최적의 방법이다
//500*10000 노드는 전체 탐색을 하기엔 너무 많지만 이번엔 각 노드를 한번씩만 방문하면 된다
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[][] arr;
    boolean[][] visited;
    int R, C;
    int ans = 0;
    int[] dr = {-1, 0, 1};
    int[] dc = {1, 1, 1};
    Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        for(int i  = 0; i < R; i++){
            func(i, 0);
        }
        System.out.println(ans);
    }
    boolean func(int r, int c){
        visited[r][c] = true;
        if(c == C-1){
            ans++;
            return true;
        }
        int current_r, current_c;
        for(int i = 0; i < 3; i++){
            current_r = r + dr[i];
            current_c = c + dc[i];
            if(C <= current_c || R <= current_r || current_r < 0){
                continue;
            }
            if(!visited[current_r][current_c] && arr[current_r][current_c] == '.'){
                if(func(current_r, current_c)){
                    return true;
                }
            }
        }
        return false;
    }
}
