package BJ_1525;
//혼자서 못 풀었음
//BFS를 통해서 모든 이동에 대한 탐색을 하자 <= 여기까진 성공
//BFS는 항상 history를 만들어서 중복을 체크해야한다
//위와 같은 경우, 배열로 history를 만들기 애매함
//hashmap으로 history를 만들고 key는 현재 모양을 string으로 변환하여 설정한다
//마지막 100%일때 오답이 났는데, 처음부터 정답인 경우를 고려하자
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
        for(int y = 0; y < 3; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < 3; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
                sb.append(arr[y][x]);
                if(arr[y][x] == 0) {
                    start = getIndex(x, y);
                }
            }
        }
        str = sb.toString();
        if(check(str)){
            System.out.println(0);
            return;
        }

        queue.add(new Node(str, start, 0));
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            //System.out.println(curNode.arr);
            int startX = curNode.start % 3;
            int startY = curNode.start / 3;
            for(int i = 0; i < 4; i++) {
                int dx = startX + moveX[i];
                int dy = startY + moveY[i];
                if (dx < 0 || 3 <= dx || dy < 0 || 3 <= dy) {continue;}
                else {
                    Node node = swap(getIndex(startX, startY), getIndex(dx, dy), curNode);
                    if(history.containsKey(node.arr)){continue;}
                    queue.add(node);
                    history.put(curNode.arr, true);
                    if(check(node.arr)){
                        System.out.println(node.count);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
    public Node swap(int zeroIndex, int targetIndex, Node node){
        String ans = node.arr;
        char[] charArr = ans.toCharArray();
        char zeroNum = charArr[zeroIndex];
        charArr[zeroIndex] = charArr[targetIndex];
        charArr[targetIndex] = zeroNum;
        String str = String.valueOf(charArr);
        return new Node(str, targetIndex, node.count+1);
    }
    public int getIndex(int x, int y){
        return y * 3 + x;
    }
    public boolean check(String arr){
        String str = new String("123456780");
        return arr.equals(str);
    }
}

class Node{
    int count;
    String arr;
    int start;
    Node(String arr, int start, int count){
        this.arr = arr;
        this.start = start;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

