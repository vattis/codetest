package BJ_1311;
//비트 마스킹을 눈치를 챘는데 구현이 어려웠음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}
class Solution{
    int N;
    int[][] D = new int[21][21];
    int[][] DP = new int[21][1<<21];
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++){
            D[i] = new int[N+1];
            DP[i] = new int[1<<21];
            Arrays.fill(DP[i], -1);
        }
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(recur(0, 0));


    }
    int recur(int person, int visited){
        if(person == N){ return 0; }  //순회 완료
        if(DP[person][visited] != -1){ return DP[person][visited]; } //지나온 길

        DP[person][visited] = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            if((visited | (1<<i)) == visited){ continue; } //이미 끝난 일
            DP[person][visited] = min(DP[person][visited], recur(person+1, visited | (1<<i)) + D[person][i]);
        }
        return DP[person][visited];
    }
    int addBit(int bit, int place){
        return bit | (1 << place);
    }

    int toBit(boolean[] done){
        int bit = 0;
        for(int i = 1; i <= N; i++){
            bit = bit << 1;
            if(done[i]){
                bit++;
            }
        }
        return bit;
    }
}

