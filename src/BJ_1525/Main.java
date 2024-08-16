package BJ_1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    int[] moveX = {-1, 0, 1, 0};
    int[] moveY = {0, -1, 0, 1};
    Queue<Node> queue = new LinkedList<>();
    Map<String, Boolean> history = new HashMap<>();
    int[][] arr = new int[3][3];
    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str;
        int start = 0;
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sb.append(arr[i][j]);
                if(arr[i][j] == 0) {
                    start = getIndex(j, i);
                }
            }
        }
        str = sb.toString();


        int sx = 0; int sy = 0;

        queue.add(new Node(str, start));
        while(!queue.isEmpty()){
            Node curNode = queue.poll();


        }
        System.out.println(-1);
    }
    public Node swap(int zeroIndex, int targetIndex, String arr){
        String ans = arr;

        ans.replace(targetIndex, arr.charAt(zeroIndex))
    }
    public int getIndex(int x, int y){
        return y * 3 + x;
    }
}

class Node{
    String arr;
    int start;
    Node(String arr, int start){
        this.arr = arr;
        this.start = start;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

