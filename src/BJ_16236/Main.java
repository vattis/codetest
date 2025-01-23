package BJ_16236;
//방법은 생각해 냈는데 디테일 한 부분을 완전 놓쳤음
//그냥 queue를 쓰면 안되고 우선 순위 큐를 썼어야함
//단순 내림차순 올림 차순이 아니라 조건이 있을 땐 우선 순위 큐를 생각해보자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    int N;
    int[][] map;
    int ans = 0;
    boolean[][] visited;
    PriorityQueue<Node> queue = new PriorityQueue<>(new Node.NodeComparator());


    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node startNode = new Node();
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for(int i = 0; i <= N; i++){
            map[i] = new int[N+1];
            visited[i] = new boolean[N+1];
            Arrays.fill(visited[i], false);
        }
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    startNode = new Node(j, i, 2, 0, 0);
                    visited[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }
        queue.add(startNode);
        bfs();
        System.out.println(ans);
    }
    public void bfs() {
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int[] dy = {-1, 0, 0, 1};
            int[] dx = {0, -1, 1, 0};
            int afterX, afterY;
            if(curNode.sharkSize > map[curNode.y][curNode.x] && map[curNode.y][curNode.x] != 0){ //현재 있는 물고기를 먹을 수 있을 때
                ans += curNode.time;
                curNode.count++;
                if(curNode.count == curNode.sharkSize){
                    curNode.count = 0;
                    curNode.sharkSize++;
                }
                curNode.time = 0;
                map[curNode.y][curNode.x] = 0;
                for(int i = 0; i < N; i++){ //방문 기록 초기화
                    Arrays.fill(visited[i], false);
                }
                queue.clear(); //큐 초기화
            }else if(curNode.sharkSize == map[curNode.y][curNode.x] || map[curNode.y][curNode.x] == 0){ //단순히 이동만 할 수 있을 때

            }else{ //상어보다 물고기가 클 때
                continue;
            }
            for(int i = 0; i < 4; i++){
                afterX = curNode.x + dx[i];
                afterY = curNode.y + dy[i];
                if(afterX >= 0 && afterY >= 0 && afterX < N && afterY < N){ //범위 안에 들었을 때
                    if(visited[afterY][afterX]){
                        continue;
                    }
                    visited[afterY][afterX] = true;
                    queue.add(new Node(afterX, afterY, curNode.sharkSize, curNode.count, curNode.time+1));
                }
            }
        }
    }
}
class Node{
    int x, y, sharkSize, count, time;
    Node(int x, int y, int sharkSize, int count, int time){
        super();
        this.x = x;
        this.y = y;
        this.sharkSize = sharkSize;
        this.count = count;
        this.time = time;
    }
    Node(){
        super();
        this.x = 0;
        this.y = 0;
    }
    static class NodeComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.time < o2.time){
                return -1;
            }
            else if(o1.time > o2.time){
                return 1;
            }
            else{
                if(o1.y < o2.y){
                    return -1;
                }
                else if(o1.y > o2.y){
                    return 1;
                }
                else{
                    if(o1.x < o2.x){
                        return -1;
                    }
                    else if(o1.x > o2.x){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

