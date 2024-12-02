package BJ_7579;
//처음에 생각한대로 이분탐색 or 해시를 이용해서 탐색하는 문제
//나는 해시맵을 사용했음
//처음엔 해시맵을 사용했는데도 시간 초과 발생
//출력이 너무 많아서 그런듯?
//문자열을 한번에 붙여서 출력하여 시간 줄임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    int N, M;
    Pro[] arr;
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Pro[N];
        for(int i = 0; i < N; i++){
            arr[i] = new Pro();
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i].setMem(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i].setCost(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
    }
}
class Pro implements Comparable<Pro>{
    int cost, mem;
    public void setCost(int cost){
        this.cost = cost;
    }
    public void setMem(int mem){
        this.mem = mem;
    }


    @Override
    public int compareTo(Pro o) {
        return this.mem - o.mem;
    }
}
public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

