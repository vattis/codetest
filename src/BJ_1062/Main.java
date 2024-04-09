package BJ_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

class Solution {
    String[][] words;
    String[] alpha = new String[26];

    public Solution(String[][] words_){
        words = words_;
        for(int i = 0; i<26; i++){
            alpha[i] = (char)('a'+i)+"";
        }
    }
    public int solution(int N, int K) {
        for(int i = 0; i < N; i++){

        }
        return 1;
    }
    public int recur(int start, int cnt, int K){
        for(int i = start; i < 25; i++){
            recur(start, cnt, K);
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        int N, K;
        String[][] words = new String[50][50];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            str = str.substring(4, str.length()-4);
            words[i] = str.split("");
        }
        Solution solution = new Solution(words);
        solution.solution(N, K);
    }
}