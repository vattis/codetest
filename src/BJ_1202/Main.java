package BJ_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {

    }
}
class Solution {
    int N, K;
    PriorityQueue<Pair> jewels = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> bag = new PriorityQueue<>();

    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bag.add(Integer.parseInt(st.nextToken()));
        }

    }
}
class Pair implements Comparable<Pair>{//무게, 가격
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair o) {
        if(this.y < o.y) return -1;
        else if(this.y > o.y) return 1;
        else return Integer.compare(this.x, o.x);
    }
}

