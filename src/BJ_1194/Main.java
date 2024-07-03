package BJ_1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    int[] moveX = {0, 1, 0, -1};
    int[] moveY = {-1, 0, 1, 0};
    char[][] map = new char[51][51];
    boolean[][][] visited = new boolean[51][51][64];
    Queue<Node> queue= new LinkedList<>();
    int M, N;

    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i < 51; i++){
            for(int j = 0; j < 51; j++){
                Arrays.fill(visited[i][j], false);
                if(map[i][j] == '0'){
                    queue.add(new Node(j, i, 0, 0));
                }
            }
        }
    }
    public int solution(){
        int min = 100000000;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int curX;
            int curY;
            for(int i = 0; i < 4; i++){
                curX = node.x + moveX[i];
                curY = node.y + moveY[i];
                Node curNode = new Node(curX, curY, node.count+1, node.state);
                if(isInBoundary(curX, curY) && !visited[curY][curX][node.state]){
                    if('A' <= map[curY][curX] && map[curY][curX] <= 'F'){ //문을 만났을 때
                        if(hasKey(node.state, map[curY][curX])){ //키를 갖고 있으면
                            visited[curY][curX][node.state] = true;
                        }
                    }
                    else if('a' <= map[curY][curX] && map[curY][curX] <= 'f'){ //열쇄를 만났을 때
                        char t = (char)(map[curY][curX]-'a');
                        curNode.state = (curNode.state|1<<t);
                        visited[curY][curX][node.state] = true;
                    }
                    else if(map[curY][curX] == '1'){
                        if(curNode.count < min){
                            min = curNode.count;
                        }
                        visited[curY][curX][node.state] = true;
                    }
                    else{
                        visited[curY][curX][node.state] = true;

                    }
                    queue.add(curNode);
                }
            }
        }
        return min;
    }
    public boolean isInBoundary(int x, int y){
        return (0<=x && x < M && 0<=y && y < N && map[y][x] != '#');
    }
    public boolean hasKey(int mask, char gate){
        char t = (char)(gate-'A');
        return mask == (mask|(1 << t));
    }
}
class Node{
    Node(int x_, int y_, int count_, int state_){
        x = x_;
        y = y_;
        count = count_;
        state = state_;
    }
    int x;
    int y;
    int count;
    int state;
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.solution());
    }
}
