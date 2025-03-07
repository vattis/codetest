package BJ_11729;
//하노이를 직접 해보니까 감이 잡혔음
//하노이 자체가 재귀적으로 계속 문제를 반복하는 방식의 퍼즐임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    int N;
    StringBuilder sb = new StringBuilder();
    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2, N) - 1);
        hanoi(N, 1, 3);
        System.out.println(sb.toString());
    }
    void hanoi(int h, int start, int target) {
        if (h == 1) {
            sb.append(start).append(" ").append(target).append("\n");
            return;
        }
        if (start == 1 && target == 3) {
            hanoi(h - 1, start, 2);
            sb.append(start).append(" ").append(target).append("\n");
            hanoi(h-1, 2, target);
        } else if (start == 1 && target == 2) {
            hanoi(h - 1, start, 3);
            sb.append(start).append(" ").append(target).append("\n");
            hanoi(h-1, 3, target);
        } else if (start == 2 && target == 3) {
            hanoi(h - 1, start, 1);
            sb.append(start).append(" ").append(target).append("\n");
            hanoi(h-1, 1, target);
        } else if (start == 2 && target == 1) {
            hanoi(h - 1, start, 3);
            sb.append(start).append(" ").append(target).append("\n");
            hanoi(h-1, 3, target);
        } else if (start == 3 && target == 2) {
            hanoi(h - 1, start, 1);
            sb.append(start).append(" ").append(target).append("\n");
            hanoi(h-1, 1, target);
        } else if (start == 3 && target == 1) {
            hanoi(h - 1, start, 2);
            sb.append(start).append(" ").append(target).append("\n");
            hanoi(h-1, 2, target);
        }
    }
}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

