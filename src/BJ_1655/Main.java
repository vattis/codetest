package BJ_1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//priority queue 2개를 이용해서
//한쪽은 중간보다 큰 수를, 한쪽은 중간보다 작은 수를 저장함
//작은 쪽의 수가 큰 쪽보다 크거나 같도록 유지하는 방식으로 중간 값을 계속해서 찾는다
//이때 중간 값은 작은 쪽 priority queue 에서 가장 큰 값

class Solution {
    int N;
    int curNum;
    Solution() throws IOException {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        curNum = Integer.parseInt(br.readLine());
        minQueue.add(curNum);
        System.out.println(curNum);
        for(int i = 2; i <= N; i++) {
            int t = Integer.parseInt(br.readLine());
            if(minQueue.size() <= maxQueue.size()){ //max가 더 클 때
                if(curNum < t){//크기가 더 클 때
                    maxQueue.add(t);
                    int p = maxQueue.poll();
                    minQueue.add(p);
                    curNum = minQueue.peek();
                }
                else{  //크기가 더 작을 때
                    minQueue.add(t);
                    curNum = minQueue.peek();
                }
            }else{ //짝수 번째
                if(curNum <= t){ //크기가 같거나 클 때
                    maxQueue.add(t);
                    curNum = minQueue.peek();
                }
                else{  //크기가 더 작을 때
                    minQueue.add(t);
                    int p = minQueue.poll();
                    maxQueue.add(p);
                    curNum = minQueue.peek();
                }
            }
            System.out.println(curNum);
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}

