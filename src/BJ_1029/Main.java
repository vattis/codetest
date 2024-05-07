package BJ_1029;
//시간초과 뜸 dp로 어떻게 표현해야할 지 모르겠음
//비트마스킹을 사용하면 좋다고 한다 
//검색해보니까 외판원 순회 문제를 알아두면 좋아보임
//일단 외판원 순회 문제를 풀고 다시 보자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution{
    int N;
    int[][] arr;
    int[] dp = new int[15];
    boolean[] visited = new boolean[15];

    static int max = 0;
    public Solution(int[][] arr_, int N_){
        N = N_;
        arr = arr_;
        Arrays.fill(dp, 10);
        Arrays.fill(visited, false);
        visited[0] = true;
    }
    public int solution(){
        return recur(0, 0, visited, 1);
    }

    public int recur(int curPerson, int curCost, boolean[] visited, int visitNum){
        for(int i = 1; i < N; i++){
            if(!visited[i] && dp[curPerson] >= visitNum && curCost <= arr[curPerson][i]){
                dp[curPerson] = visitNum;
                visited[i] = true;
                recur(i, arr[curPerson][i], visited, visitNum+1);
                visited[i] = false;
            }
        }
        if(max < visitNum){
            max = visitNum;
        }
        return max;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        int[][] arr = new int[15][];
        for (int i = 0; i < 15; i++) {
            arr[i] = new int[15];
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - 48;
            }
        }
        Solution solution = new Solution(arr, N);

        System.out.println(solution.solution());
    }

}
