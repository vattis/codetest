package BJ_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

class Solution {
    int N, K;
    String[][] words;
    String[] alpha = new String[26];
    Set<String> alphaSet = new HashSet<>();
    public Solution(String[][] words_, int n, int k){
        words = words_;
        for(int i = 0; i<26; i++){
            alpha[i] = (char)('a'+i)+"";
        }
        N = n;
        K = k;
        alphaSet.add("a");
        alphaSet.add("c");
        alphaSet.add("i");
        alphaSet.add("n");
        alphaSet.add("t");
    }
    public int recur(int start, int cnt){
        int MAX = -1;
        if(cnt < K){
            for(int i = start; i < 26; i++){
                if(!alphaSet.contains(alpha[i])){
                    alphaSet.add(alpha[i]);
                    int t = recur(i+1, cnt+1);
                    if(MAX <  t){MAX = t;}
                    alphaSet.remove(alpha[i]);
                }
            }
        }
        else if(cnt == K){
            return cntAvailableWords(alphaSet);
        }
        return MAX;
    }
    public int cntAvailableWords(Set<String> alphaSet){
        int ans = 0;
        for(int i = 0; i < N; i++){
            if(words[i][0] == ""){ans++;}
            int flag = 0;
            for(int j = 0; j < words[i].length; j++){
                if(!alphaSet.contains(words[i][j])){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                ans++;
            }
        }
        return ans;
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
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.substring(4, str.length() - 4);
            words[i] = str.split("");
        }
        if (K < 5) {
            System.out.println(0);
            return;
        }
        Solution solution = new Solution(words, N, K);
        System.out.println(solution.recur(0, 5));
    }
}
