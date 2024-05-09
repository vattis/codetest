package BJ_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T, N, K, target;

        T = Integer.parseInt(br.readLine());  // T입력

        for (int t = 0; t < T; t++) {
            int[] craftTime = new int[1001];
            boolean[][] craftGraph = new boolean[1001][];
            for (int i = 0; i <= 1000; i++) {
                craftGraph[i] = new boolean[1001];
            }
            StringTokenizer st = new StringTokenizer(br.readLine());  //  N, K 입력
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()); //건물당 건설 시간
            int k = 0;
            while (st.hasMoreTokens()) {
                craftTime[k] = Integer.parseInt(st.nextToken());
                k++;
            }
            for (int i = 0; i < K; i++) {  //건물 건설 조건 입력
                st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                craftGraph[Y][X] = true;
            }
            target = Integer.parseInt(br.readLine()); //목표 건물 입력

            Solution sol = new Solution(craftTime, craftGraph);
            System.out.println(sol.solution(target));
        }
    }
}
class Solution{
    ArrayList<Integer>[] craftGraph;
    ArrayList<Integer> craftTime;

    public Solution(ArrayList<Integer> craftTime_, ArrayList<Integer>[] craftGraph_){
        craftTime = craftTime_;
        craftGraph = craftGraph_;
    }
    public int solution(int target){
        return recur(target);
    }
    public int recur(int building){
        int max = 0;
        int buildTime = craftTime.get(building);

        for(int postBuilding : craftGraph[building]){
            int pt = recur(postBuilding);
            if(max < pt){
                max = pt;
            }
        }
        buildTime += max;
        craftTime.set(building, buildTime);
        craftGraph[building].clear();
        return buildTime;
    }
}



