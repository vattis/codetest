package BJ_2887;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;
//일단 최소 스패닝 트리(MST) 문제라는 걸 모른 거 부터가 사고임
//항상 결과적으로 만들어지는 그래프의 형태를 생각하는 습관을 갖자
//이 문제는 특히 노드 수가 많아서 일반적인 N^2의 시간 복잡도로는 안됨
//문제에 사용할 edge 를 구하는 게 이 문제의 어려운 점
//각 축별로 간선을 정렬해 놓고 인접한 간선을 edge 로 삼는다
//이 edge들을 이용해서 크루스칼 알고리즘으로 최단길이를 구한다
//인접한 간선들을 모아서 최단 경로를 만들 수 있다는 발상이 좀 힘들다
//1차원이었다면 당연한 것이지만 3차원으로 응용하니 직관적인 이해가 힘들었다
//결국 문제 조건에 의해서 1차원의 연장선으로 생각 할 수 있다는 것을 설명을 보고 알았다

class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<OneDemensionNode> oneDemensionNodeX = new PriorityQueue<>();
    PriorityQueue<OneDemensionNode> oneDemensionNodeY = new PriorityQueue<>();
    PriorityQueue<OneDemensionNode> oneDemensionNodeZ = new PriorityQueue<>();
    PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
    ArrayList<Integer> rootArray = new ArrayList<Integer>();
    int N;
    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++){
            rootArray.add(i, i);
        }
        int temp_x, temp_y, temp_z, planetNo;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            planetNo = i;
            temp_x = Integer.parseInt(st.nextToken());
            temp_y = Integer.parseInt(st.nextToken());
            temp_z = Integer.parseInt(st.nextToken());
            oneDemensionNodeX.add(new OneDemensionNode(planetNo, temp_x));
            oneDemensionNodeY.add(new OneDemensionNode(planetNo, temp_y));
            oneDemensionNodeZ.add(new OneDemensionNode(planetNo, temp_z));
        }
        OneDemensionNode curNode = oneDemensionNodeX.poll();
        while (!oneDemensionNodeX.isEmpty()) {
            OneDemensionNode nextNode = oneDemensionNodeX.poll();
            edgeQueue.add(new Edge(curNode.planetNo, nextNode.planetNo, abs(curNode.point-nextNode.point)));
            curNode = nextNode;
        }
        curNode = oneDemensionNodeY.poll();
        while (!oneDemensionNodeY.isEmpty()) {
            OneDemensionNode nextNode = oneDemensionNodeY.poll();
            edgeQueue.add(new Edge(curNode.planetNo, nextNode.planetNo, abs(curNode.point-nextNode.point)));
            curNode = nextNode;
        }
        curNode = oneDemensionNodeZ.poll();
        while (!oneDemensionNodeZ.isEmpty()) {
            OneDemensionNode nextNode = oneDemensionNodeZ.poll();
            edgeQueue.add(new Edge(curNode.planetNo, nextNode.planetNo, abs(curNode.point-nextNode.point)));
            curNode = nextNode;
        }
        System.out.println(kruskal());
    }

    int kruskal(){
        int count = 0;
        int ans = 0;
        while(!edgeQueue.isEmpty()){
            Edge edge = edgeQueue.poll();
            //System.out.println("start: " + edge.startPlanetNo + " end: " + edge.endPlanetNo + " value: " + edge.value);
            if(union(edge.startPlanetNo, edge.endPlanetNo)){
                count++;
                //System.out.println(edge.value);
                ans += edge.value;
            }
            if(count == N-1){
                return ans;
            }
        }
        return ans;

    }
    int findRoot(int planetNo){
        if(rootArray.get(planetNo) == planetNo){
            return planetNo;
        }
        else return findRoot(rootArray.get(planetNo));
    }
    boolean union(int planetNo1, int planetNo2){
        int p1 = findRoot(planetNo1), p2 = findRoot(planetNo2);
        if(p1 == p2){
            return false;
        }
        if(p1 <= p2){
            rootArray.set(p2, p1);
        }else{
            rootArray.set(p1, p2);
        }
        return true;
    }

}
class OneDemensionNode implements Comparable<OneDemensionNode> {
    int planetNo;
    int point;
    public OneDemensionNode(int planetNo, int point) {
        this.planetNo = planetNo;
        this.point = point;
    }

    @Override
    public int compareTo(OneDemensionNode o) {
        return this.point - o.point;
    }
}

class Edge implements Comparable<Edge> {
    public Edge(int start, int end, int value){
        this.startPlanetNo = start;
        this.endPlanetNo = end;
        this.value = value;
    }
    int startPlanetNo;
    int endPlanetNo;
    int value;

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();

    }
}

