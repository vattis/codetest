package BJ_13334;

//스위핑 구조에 대해서 알아두자
//한번 범위를 휩쓸어서 답을 구하는 유형
//이 문제의 포인트는 어떻게 하면 n*n이 아니라 n번 만에 답을 구할 수 있는가
//매번 범위에 포함되는 노드를 다시 계산하는 것이 아니라 기존에 노드에서 추가하고 빼는 방식으로 구한다
//그러기 위해선 start point가 아니라 end point를 정렬하는 것이 핵심이다
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    int n, d;
    int max = -1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Route[] routes;
    public Solution() throws IOException {
        PriorityQueue<Route> pq = new PriorityQueue<>(new RouteStartComparator());
        n = Integer.parseInt(br.readLine());
        routes = new Route[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp_s = Integer.parseInt(st.nextToken());
            int temp_d = Integer.parseInt(st.nextToken());
            if(temp_s > temp_d){
                int t = temp_s;
                temp_s = temp_d;
                temp_d = t;
            }
            routes[i] = new Route(temp_s, temp_d);
        }
        d = Integer.parseInt(br.readLine());
        Arrays.sort(routes, new RouteEndComparator());
        for(int i = 0; i < n; i++){
            int end = routes[i].e;
            int start = end-d;
            pq.add(routes[i]);
            while(pq.peek() != null){
                Route r = pq.peek();
                if(r.s < start){
                    pq.poll();
                }else{
                    break;
                }
            }
            if(max < pq.size()){
                max = pq.size();
            }
        }
        System.out.println(max);
    }
}
class Route {
    int s, e;
    public Route(int s, int e){
        this.s = s;
        this.e = e;
    }
}
class RouteStartComparator implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        if(o1.s == o2.s){
            return o1.e - o2.e;
        }
        return o1.s - o2.s;
    }
}
class RouteEndComparator implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        if(o1.e == o2.e){
            return o1.s - o2.s;
        }
        return o1.e - o2.e;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

