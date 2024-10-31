package BJ_1781;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    int N;
    Cup[] numList;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] ans;
    int s = 0;
    int[] index_t;
    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numList = new Cup[N+1];
        ans = new int[N+1];
        index_t = new int[N+1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            numList[i] = new Cup(n1, n2);
            index_t[i] = i;
        }
        index_t[N] = N;
        Arrays.sort(numList, 0, N);
        for(int i = 0; i < N; i++){
            Cup c = numList[i];
            int index = index_t[c.num1];
            List<Integer> list = new ArrayList<>();
            if(index > N){
                index = N;
            }
            while(index >= 0 && ans[index] != 0){
                list.add(index);
                index--;
            }
            if(index > 0){
                for (Integer integer : list) {
                    index_t[integer] = index - 1;
                }
                //System.out.println(c.num1 + " " + c.num2);
                ans[index] = c.num2;
            }
        }
        for(int i = 1; i <= N; i++){
            s += ans[i];
        }
        System.out.println(s);
    }
}
class Cup implements Comparable<Cup> {
    int num1, num2;
    public Cup(int n1, int n2){
        num1 = n1;
        num2 = n2;
    }
    @Override
    public int compareTo(Cup o) {
        return o.num2-this.num2;
    }
}