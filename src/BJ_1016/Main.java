package BJ_1016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Solution{

}

public class Main {
    public static void main(String[] ars) {
        final int NUM = 1001000;
        int ans = 0;
        long min, max;
        boolean[] odds = new boolean[NUM+1];
        boolean[] ansList= new boolean[1000001];
        List<Integer> oddList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        min = sc.nextLong();
        max = sc.nextLong();
        Arrays.fill(odds, true);
        Arrays.fill(ansList, true);
        for(int i = 2; i <= NUM; i++){
            if(odds[i]){
                int j = 2;
                while(i*j <= NUM){
                    odds[i*j] = false;
                    j++;
                }
            }
        }
        for(int i = 2; i <= NUM; i++){
            if(odds[i]){
                oddList.add(i);
            }
        }
        for(long odd: oddList){
            int t = 1;
            if(odd*odd)
        }
        for(int i = 0; i <= max-min; i++){
            if(ansList[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}