package BJ_1450;
//말만 냅색 문제지 DP 로는 못푸는 문제
//1. 우선 숫자가 너무 크니까 반으로 잘라서 각각 생각하는 아이디어 (list1 은 1~N/2까지 모든 경우의 수의 무게, list2 는 N+1~N까지 모든 경우의 수의 무게)
//2. 투 포인터를 이용해서 숫자를 세는 아이디어 (모든 list1.get(i)의 무게가 x일 때, C-x인 값의 갯수를 list2로부터 찾아서 더하면 됨)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}
class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N, C;
    long ans = 0;
    int arr[] = new int[31];
    ArrayList<Long> list1;
    ArrayList<Long> list2;
    ArrayList<Long> tempList = new ArrayList<>();
    public Solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, N/2, 0);
        list1 = (ArrayList<Long>)tempList.clone();
        tempList.clear();
        dfs(N/2+1, N-1, 0);
        list2 = (ArrayList<Long>)tempList.clone();
        Collections.sort(list1);
        Collections.sort(list2);
        for(int i = 0; i < list1.size(); i++){
            ans += binarySearch(list2, C-list1.get(i));
        }
        System.out.println(ans);
    }
    void dfs(int now, int end, long cost){
        if(now > end){
            if(cost <= C) {
                tempList.add(cost);
            }
            return;
        }
        dfs(now+1, end, cost+arr[now]);
        dfs(now+1, end, cost);
    }
    long binarySearch(ArrayList<Long> list, long num){
        int l = 0;
        int r = list.size()-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(list.get(mid) > num){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}

