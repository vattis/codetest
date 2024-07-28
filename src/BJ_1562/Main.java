package BJ_1562;
//DP + 비스마스킹을 이용해서 문제를 풀었음
//골1 문제를 오답 없이 한번에 맞춘건 이번이 처음인듯
//처음에는 단순 재귀함수로 생각했지만 그럴경우 2^100이라 무조건 문제가 생김
//DP를 잘 활용해 보자
//저장요소 => 현재 위치, 현재 숫자, 사용한 숫자(비스마스킹)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    int N;
    int[][][]DP = new int[10][101][1050]; //현재 숫자//자리//사용 숫자(비트 마스킹)
    public Solution() throws IOException {
        int ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 10; j++)
            {
                DP[j][i] = new int[1050];
                Arrays.fill(DP[j][i], 0);
            }

        }
        for(int i = 1; i <= 9; i++){
            int b = 1 << i;
            ans += func(i,1, b);
            ans %= 1000000000;
        }
        System.out.println(ans);
    }
    int func(int curNum, int location, int usedNum){
        if(location == N && usedNum == 1023){
            return 1;
        }
        else if(location == N && usedNum != 1023){
            return 0;
        }

        if(DP[curNum][location][usedNum] != 0){
            return DP[curNum][location][usedNum];
        }
        if(curNum == 9){
            DP[curNum][location][usedNum] = (func(curNum-1, location+1, usedNum|(1<<(curNum-1))))%1000000000;
        }
        else if(curNum == 0){
            DP[curNum][location][usedNum] = (func(curNum+1, location+1, usedNum|(1<<(curNum+1))))%1000000000;
        }
        else{
            DP[curNum][location][usedNum]
                   = (func(curNum-1, location+1, usedNum|(1<<(curNum-1)))
                            + func(curNum+1, location+1, usedNum|(1<<(curNum+1))))%1000000000;
        }
        return DP[curNum][location][usedNum];
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}

