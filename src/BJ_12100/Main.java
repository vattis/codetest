package BJ_12100;

//방법은 솔직히 바로 알 수 있었음
//구현 하는 데 시간이 좀 걸림
//사소한 부분을 놓치기도 했음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    int N;
    int[][] arr;
    int ans = -1;

    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(arr, 1);
        System.out.println(ans);
    }
    public void recur(int[][] arr, int time){
        if(time > 5){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(ans<arr[i][j]){
                        ans = arr[i][j];
                    }
                }
            }
            return;
        }

        recur(up(arr), time+1);
        recur(down(arr), time+1);
        recur(right(arr), time+1);
        recur(left(arr), time+1);

    }
    public int[][] up(int[][] arr){
        int[][] res = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            System.arraycopy(arr[i], 0, res[i], 0, N + 1);
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= N-2; j++){
                if(res[j][i] == 0){
                    continue;
                }
                if(res[j+1][i] == 0){
                    int t = j+1;
                    while(t <= N-2 && res[t][i] == 0){
                        t++;
                    }
                    res[j+1][i] = res[t][i];
                    res[t][i] = 0;
                }

                if(res[j][i] == res[j+1][i]){
                    res[j][i] += res[j+1][i];
                    res[j+1][i] = 0;
                }

            }
            for(int j = 0; j <= N-1; j++){
                if(res[j][i] == 0){
                    int t = j;
                    while(t <= N-2 && res[t][i] == 0){
                        t++;
                    }
                    res[j][i] = res[t][i];
                    res[t][i] = 0;
                }
            }
        }
        /*
        System.out.println("[UP]");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

         */
        return res;
    }
    public int[][] down(int[][] arr){
        int[][] res = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            System.arraycopy(arr[i], 0, res[i], 0, N + 1);
        }
        for(int i = 0; i < N; i++){
            for(int j = N-1; j >= 1; j--){
                if(res[j][i] == 0){
                    continue;
                }
                if(res[j-1][i] == 0){
                    int t = j-1;
                    while(t >= 1 && res[t][i] == 0){
                        t--;
                    }
                    res[j-1][i] = res[t][i];
                    res[t][i] = 0;
                }

                if(res[j][i] == res[j-1][i]){
                    res[j][i] += res[j-1][i];
                    res[j-1][i] = 0;
                }

            }
            for(int j = N-1; j >= 0; j--){
                if(res[j][i] == 0){
                    int t = j;
                    while(t >= 1 && res[t][i] == 0){
                        t--;
                    }
                    res[j][i] = res[t][i];
                    res[t][i] = 0;
                }
            }
        }
        /*
        System.out.println("[DOWN]");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

         */
        return res;
    }
    public int[][] right(int[][] arr){
        int[][] res = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            System.arraycopy(arr[i], 0, res[i], 0, N + 1);
        }
        for(int i = 0; i < N; i++){
            for(int j = N-1; j >= 1; j--){
                if(res[i][j] == 0){
                    continue;
                }

                if(res[i][j-1] == 0){
                    int t = j-1;
                    while(t >= 1 && res[i][t] == 0){
                        t--;
                    }
                    res[i][j-1] = res[i][t];
                    res[i][t] = 0;
                }

                if(res[i][j] == res[i][j-1]){
                    res[i][j] += res[i][j-1];
                    res[i][j-1] = 0;
                }
            }
            for(int j = N-1; j >= 0; j--){
                if(res[i][j] == 0){
                    int t = j;
                    while(t >= 1 && res[i][t] == 0){
                        t--;
                    }
                    res[i][j] = res[i][t];
                    res[i][t] = 0;
                }
            }
        }
        /*
        System.out.println("[RIGHT]");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

         */
        return res;
    }
    public int[][] left(int[][] arr){
        int[][] res = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            System.arraycopy(arr[i], 0, res[i], 0, N + 1);
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= N-2; j++){
                if(res[i][j] == 0){
                    continue;
                }
                if(res[i][j+1] == 0){
                    int t = j+1;
                    while(t <= N-2 && res[i][t] == 0){
                        t++;
                    }
                    res[i][j+1] = res[i][t];
                    res[i][t] = 0;
                }
                if(res[i][j] == res[i][j+1]){
                    res[i][j] += res[i][j+1];
                    res[i][j+1] = 0;
                }
            }
            for(int j = 0; j <= N-1; j++){
                if(res[i][j] == 0){
                    int t = j;
                    while(t <= N-2 && res[i][t] == 0){
                        t++;
                    }
                    res[i][j] = res[i][t];
                    res[i][t] = 0;
                }
            }
        }
        /*
        System.out.println("[LEFT]");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        */
        return res;
    }

}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

