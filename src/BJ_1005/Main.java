package BJ_1005;

//위상정렬 알고리즘 필요
//다른것보다 서로 연결된 노드 찾는게 어려웠음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] ars) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T, N, K, target;

        T = Integer.parseInt(br.readLine());  // T입력

        for (int t = 0; t < T; t++) {
            Queue<Integer> queue = new LinkedList<>();
            int[] craftTime = new int[1001];
            int[] minTime = new int[1001];
            Arrays.fill(minTime, 0);
            ArrayList<Queue<Integer>> craftGraph = new ArrayList<>();
            ArrayList<Queue<Integer>> craftGraphReverse = new ArrayList<>();

            for (int i = 0; i <= 1000; i++) {
                craftGraph.add(new LinkedList<>());
                craftGraphReverse.add(new LinkedList<>());

            }
            StringTokenizer st = new StringTokenizer(br.readLine());  //  N, K 입력
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()); //건물당 건설 시간
            int k = 1;
            while (st.hasMoreTokens()) {
                craftTime[k] = Integer.parseInt(st.nextToken());
                k++;
            }
            for (int i = 0; i < K; i++) {  //건물 건설 조건 입력
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                craftGraph.get(Y).add(X);
                craftGraphReverse.get(X).add(Y);
            }
            target = Integer.parseInt(br.readLine()); // 목표 건물 입력
            for(int i = 1; i <= N; i++){
                if(craftGraph.get(i).isEmpty())
                    queue.add(i);
            }
            while(!queue.isEmpty()){
                int curNode = queue.poll();
                while(!craftGraphReverse.get(curNode).isEmpty()){
                    int nextNode = craftGraphReverse.get(curNode).poll();
                    craftGraph.get(nextNode).remove(curNode);
                    if(minTime[curNode] + craftTime[curNode] > minTime[nextNode]){
                        minTime[nextNode] = minTime[curNode] + craftTime[curNode];
                    }
                    if(craftGraph.get(nextNode).isEmpty()){
                        queue.add(nextNode);
                    }
                }
            }
            System.out.println(minTime[target] + craftTime[target]);
        }
    }
}
class Solution{
    int[] minTime = new int[1001];
    ArrayList<Set<Integer>> craftGraph = new ArrayList<>();

}



