package BJ_7579;
//처음에 생각한대로 이분탐색 or 해시를 이용해서 탐색하는 문제
//나는 해시맵을 사용했음
//처음엔 해시맵을 사용했는데도 시간 초과 발생
//출력이 너무 많아서 그런듯?
//문자열을 한번에 붙여서 출력하여 시간 줄임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
dasdasdad
class Solution {
    int N, M;
    Map<Integer, Integer> n = new HashMap<>();
    int[] m = new int[500001];
    StringBuilder ans = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            if(n.containsKey(t)){
                n.replace(t, n.get(t)+1);
            }else{
                n.put(t, 1);
            }
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < M; i++){
            if(n.containsKey(m[i])){
                ans.append(n.get(m[i])+" ");
            }
            else{
                ans.append(0 + " ");
            }
        }
        System.out.println(ans);
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

