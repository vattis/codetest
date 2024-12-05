package BJ_17143;
//어디서 본 유형이라 DP를 떠올리긴 했음
//문제를 안읽어서 DP를 잘못 정했음
//DP를 DFS방식으로 해결하려 했지만 점화식으로 해결하는 문제였음 시발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    int[][] arr;
    int R, C, M;
    Shark[] sharks;
    int ans = 0;
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R+3][C+1];
        for(int i = 0; i < R+3; i++) {
            Arrays.fill(arr[i], -1);
        }
        M = Integer.parseInt(st.nextToken());
        sharks = new Shark[M];
        //System.out.println("R : " + R + ", C : " + C + ", M : " + M);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = i;
            sharks[i] = new Shark(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < R+1; i++){
            humanAction(i);
            for(int j = 0; j < M; j++){
                if(sharks[j].valid){
                    moveShark(j, sharks[j]);
                }
            }
        }
        System.out.println(ans);

    }
    public void moveShark(int index, Shark shark){

        switch(shark.direction){
            case 1: //위
                arr[shark.r][shark.c] = -1;
                int cycle1 = shark.speed / (C-1);
                int rem1 = shark.speed % (C-1);
                if(shark.c-rem1 < 1){
                    cycle1++;
                    shark.c = rem1-shark.c;
                }else{
                    shark.c -= rem1;
                }
                if(cycle1 % 2 != 0){
                    shark.direction = 2;
                }
                break;
            case 2: //아래
                arr[shark.r][shark.c] = -1;
                int cycle2 = shark.speed / (C-1);
                int rem2 = shark.speed % (C-1);
                if(shark.c+rem2 > C){
                    cycle2++;
                    shark.c = 2*C-(shark.c+rem2);
                }else{
                    shark.c += rem2;
                }
                if(cycle2 % 2 != 0){
                    shark.direction = 1;
                }
                break;
            case 3: //오른쪽
                arr[shark.r][shark.c] = -1;
                int cycle3 = shark.speed / (R-1);
                int rem3 = shark.speed % (R-1);
                if(shark.r-rem3 > R){
                    cycle3++;
                    shark.r = 2*R-(shark.r+rem3);
                }else{
                    shark.r += rem3;
                }
                if(cycle3 % 2 != 0){
                    shark.direction = 4;
                }
                break;
            case 4: //왼쪽
                arr[shark.r][shark.c] = -1;
                int cycle4 = shark.speed / (R-1);
                int rem4 = shark.speed % (R-1);
                if(shark.r-rem4 < 1){
                    cycle4++;
                    shark.r = rem4-shark.r;
                }else{
                    shark.r-=rem4;
                }
                if(cycle4 % 2 != 0){
                    shark.direction = 3;
                }
                break;
            default: break;
        }
        if(arr[shark.r][shark.c] != -1){ //상어가 겹칠떄
            if(sharks[arr[shark.r][shark.c]].size < shark.size){ //기존 상어보다 클 때
                sharks[arr[shark.r][shark.c]].notValid();//기존 상어를 잡아먹음
                arr[shark.r][shark.c] = index;
            }else{
                shark.notValid();  //상어가 잡아 먹혔음
            }
        }else{  //상어가 겹치지 않을 때
            arr[shark.r][shark.c] = index;
        }
        System.out.println(index + "번 상어) 방향: " + shark.direction + " (" + shark.r + ", " + shark.c + ")");
    }
    public void humanAction(int i){
        for(int j = 1; j <= C; j++){
            if(arr[i][j] != -1){
                int sharkIndex = arr[i][j];
                System.out.println("잡아먹힌 상어: "+sharkIndex);
                ans += sharks[sharkIndex].size;
                arr[i][j] = -1;
                break;
            }
        }
    }
}
class Shark{
    int r, c;
    int size;
    int speed;
    int direction;
    boolean valid;
    public Shark(int r, int c, int s, int direction, int size){
        this.r = r;
        this.c = c;
        this.size = size;
        this.speed = s;
        this.direction = direction;
        valid = true;
    }
    public void notValid(){
        valid = false;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

