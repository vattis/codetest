package BJ_1052;

import java.util.Scanner;

import static java.lang.Math.pow;

class Solution {
    public int maxTwoPower(double n) {
        int ans = 0;
        while (n >= pow(2, ans)) {
            ans++;
        }
        return ans - 1;
    }

    public Boolean[] checkTwoPower(double N, Boolean[] twoPower) {
        int index = 0;
        while (N > 0) {
            index = maxTwoPower(N);
            twoPower[index] = true;
            N = N - pow(2, index);
        }
        return twoPower;
    }

    public int cntBottle(Boolean[] twoPower) {
        int cnt = 0;
        for (int i = 0; i < 25; i++) {
            if (twoPower[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public Boolean[] addBottle(Boolean[] twoPower, int index) {
        if (twoPower[index]) {
            twoPower[index] = false;
            index++;
            addBottle(twoPower, index);
        } else {
            twoPower[index] = true;
        }
        return twoPower;
    }

    public double solution(double N, int K) {
        Boolean[] twoPower = new Boolean[25];
        for(int i = 0; i < 25; i++){
            twoPower[i] = false;
        }
        int index;
        double ans = 0;
        twoPower = checkTwoPower(N, twoPower);
        int count = cntBottle(twoPower);
        while (K < count) {
            for (int i = 0; i < 25; i++) {
                if (twoPower[i]) {
                    twoPower = addBottle(twoPower, i);
                    ans += pow(2, i);
                    count = cntBottle(twoPower);
                    break;
                }
            }
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] ars) {
        Scanner sc = new Scanner(System.in);
        int N, K;
        Boolean[] twoPower = new Boolean[25];
        N = sc.nextInt();
        K = sc.nextInt();
        Solution s = new Solution();
        System.out.println((int)s.solution(N, K));
    }
}