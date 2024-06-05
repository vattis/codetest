package BJ_1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
//top down dfs 방식으로 수열을 계산
//bottom up 방식은 불필요한 수열까지 계산해야함
//10^12크기의 배열을 만들 수 없으므로 hashmap을 이용해서 필요한 값만 저장
public class Main {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long N = Long.parseLong(st.nextToken());
        Long P = Long.parseLong(st.nextToken());
        Long Q = Long.parseLong(st.nextToken());
        Solution solution = new Solution(N, P, Q);
        System.out.println(solution.solution(N));
    }
}
class Solution{
    Long N, P, Q;
    Map<Long, Long> map = new HashMap<>();
    public Solution(Long n, Long p, Long q){
        N = n; P = p; Q = q;
        map.put(0L, 1L);
    }
    public Long solution(Long N){
        return recur(N);
    }
    public Long recur(Long n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        Long t = recur((long)Math.floor(n/P)) + recur((long)Math.floor(n/Q));
        map.put(n, t);
        return t;
    }
}

