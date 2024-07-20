package BJ_1202;
//지속적으로 sort를 사용해서 값을 정리해야하는 경우 priority queue를 사용하자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}
class Solution {
    int N, K;
    long ans = 0;
    PriorityQueue<Integer> jewels = new PriorityQueue<>(Collections.reverseOrder());
    List<Integer> bags = new ArrayList<>();
    List<Pair> js = new ArrayList<>();
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            js.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        js.sort((p1, p2) ->
        {
            if(p1.x == p2.x) return p2.y-p1.y;
            else return p1.x-p2.x;
        });
        Collections.sort(bags);

        int idx = 0;

        for(int b : bags){
            while(idx < N && b >= js.get(idx).x){
                jewels.add(js.get(idx).y);
                idx++;
            }
            if(!jewels.isEmpty()){
                ans += jewels.poll();
            }
        }
        System.out.println(ans);
    }
}
class Pair{//무게, 가격
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

