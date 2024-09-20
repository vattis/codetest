package BJ_1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//문제 유형을 보고서야 어떻게 하는지 알았음
//상태에 따른 2차원 배열 히스토리를 만들어야 함
//DFS는 보통 백트랙킹으로 경로를 구하거나 완전 탐색을 해야할 때 사용
//BFS는 보통 단순 최단 거리는 구할 떄 쓰면 좋음
//사소한 건데 break와 continue 잘 구분하자 ㅋㅋ
public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}
class Solution{
    int N, K;
    int s = 0;
    boolean[][] history = new boolean[1000001][11];
    Queue<Node> queue = new LinkedList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue.add(new Node(N, K));
        int max = -1;
        while(N != 0){
            s++;
            N /= 10;
        }
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if(curNode.time == 0){
                if(max < curNode.num){ max = curNode.num; }
                //System.out.println(max);
                continue;
            }
            if(history[curNode.num][curNode.time]){
                continue;
            }
            history[curNode.num][curNode.time] = true;
            for(int i = 1; i <= s-1; i++){
                for(int j = i+1; j <= s; j++){
                    int tt = swap(curNode.num, i, j);
                    //System.out.println(tt);
                    if(tt == -1){
                        continue;
                    }
                    else{
                        Node n = new Node(tt, curNode.time-1);
                        //System.out.println(n.num + " " + n.time);
                        queue.add(n);
                    }
                }
            }
        }
        System.out.println(max);
    }
    public int swap(int num, int i, int j){
        char[] arr = String.valueOf(num).toCharArray();
        char temp = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = temp;
        if(arr[0] == '0'){
            return -1;
        }
        num = Integer.parseInt(String.valueOf(arr));
        return num;
    }

    static class Node{
        Node(int n, int t){
            num = n;
            time = t;
        }
        int num;
        int time;
    }
}
