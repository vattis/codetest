package BJ_1074;

//그냥 이차원 이진 탐색하면 되는 문제
//아이디어는 빨리 떠올랐는데 한번에 구현을 못함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(recur(N, (int)pow(2, N-1), (int)pow(2, N-1), r, c));
    }

    public int recur(int num, int axis_r, int axis_c, int r, int c){
        if(num == 0){
            return 0;
        }
        int len = (int) pow(2, num-1);

        if(r < axis_r && c < axis_c){
            return recur(num-1, axis_r-(len/2), axis_c-(len/2), r, c);
        }else if(r >= axis_r && c < axis_c){
            return recur(num-1, axis_r+(len)/2, axis_c-(len/2), r, c)+(len*len);
        }else if(r < axis_r && c >= axis_c){
            return recur(num-1, axis_r-(len/2), axis_c+(len/2), r, c)+(len*len)*2;
        }else{
            return recur(num-1, axis_r+(len)/2, axis_c+(len/2), r, c)+(len*len)*3;
        }
    }
}




