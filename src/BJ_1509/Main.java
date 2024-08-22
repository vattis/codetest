package BJ_1509;
//ㅈㄴ 어려웠음
//DP 문제인거 감도 못잡았음
//연쇄 작용이 있을 때는 dp를 의심해보자
//DP를 두번 사용해서
//처음에는 모든 팰린드롬을 구하고,
//구한 팰린드롬을 바탕으로 dp를 계산함
//DP[i] <= i까지의 팰린드롬 최소 갯수
//DP[i] = min(DP[i], DP[j-1]+1)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] ars) throws IOException {
        new Solution();
    }
}
class Solution{
    char[] arr;
    boolean[][] pal = new boolean[2501][2501];
    int[] DP = new int[2501];
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = str.toCharArray();
        for(int i = 0; i <= arr.length; i++){
            DP[i] = i;
        }
        for(int i = 0; i < 2501; i++){
            Arrays.fill(pal[i], false);
        }
        for(int i = 0; i < arr.length; i++){
            pal[i][i] = true;
        }
        for(int i = 0; i < arr.length-1; i++){
            pal[i][i+1] = (arr[i] == arr[i+1]);
        }
        for(int i = 3; i <= arr.length; i++){
            for(int s = 0; s < arr.length; s++){
                if(s + i > arr.length){break;}
                int e = s+i-1;
                if(arr[s] == arr[e] && pal[s+1][e-1]){
                    pal[s][e] = true;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j <= i; j++){
                if(pal[j][i]){
                    DP[i+1] = min(DP[i+1], DP[j]+1);
                }
            }
        }
        System.out.println(DP[arr.length]);
    }

}

