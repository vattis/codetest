package BJ_17143;
//알고리즘이랄게 없음 걍 구현하는게 ㅈㄴ 햇갈렸음
//상어 이동 구현하는게 ㅈ같음
//상어가 동시에 움직인다음 잡아먹는 걸 처음에 고려하지 못했음
//어떻게 할까 고민하다가 배열을 하난 더 만들어서 거기서 움직인 상어끼리 계산한다음
//원래 배열로 복사하는 방식을 채택

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    int[][] arr;
    int[][] arr2;
    int R, C, M;
    Shark[] sharks;
    int ans = 0;
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R+1][C+3];
        arr2 = new int[R+1][C+3];
        for(int i = 0; i < R+1; i++) {
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
            arr2[r][c] = i;
            sharks[i] = new Shark(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i = 1; i < C+1; i++){
            for(int t = 0; t < R+1; t++) {
                Arrays.fill(arr2[t], -1);
            }
            humanAction(i);
            for(int j = 0; j < M; j++){
                if(sharks[j].valid){
                    moveShark(j, sharks[j]);
                }
            }
            for(int t = 0; t < R+1; t++){
                if (C + 3 >= 0) System.arraycopy(arr2[t], 0, arr[t], 0, C + 3);
            }
        }
        System.out.println(ans);

    }
    public void moveShark(int index, Shark shark){

        switch(shark.direction){
            case 1: //위
                arr[shark.r][shark.c] = -1;
                int temp1 = shark.r - shark.speed;
                if(temp1 < 1){
                    int l = temp1*(-1) + 1;
                    int cycle = l/(R-1);
                    int rem = l%(R-1);
                    //System.out.println(index + "번 물고기| l = " + l + " cycle = " + cycle + " rem = " + rem);
                    if(cycle % 2 != 0){
                        shark.r = R - rem;
                    }else{
                        shark.r = 1+rem;
                        shark.direction = 2;
                    }
                }else{
                    shark.r-=shark.speed;
                }
                break;
            case 2: //아래
                arr[shark.r][shark.c] = -1;
                int temp2 = shark.r+shark.speed;
                if(temp2 > R){
                    int l = temp2 - R;
                    int cycle = l/(R-1);
                    int rem = l%(R-1);
                    if(cycle % 2 != 0){
                        shark.r = 1+rem;
                    }else{
                        shark.r = R-rem;
                        shark.direction = 1;
                    }
                }else{
                    shark.r += shark.speed;
                }
                break;
            case 3: //오른쪽
                arr[shark.r][shark.c] = -1;
                int temp3 = shark.c+shark.speed;
                if(temp3 > C){
                    int l = temp3 - C;
                    int cycle = l/(C-1);
                    int rem = l%(C-1);
                    if(cycle % 2 != 0){
                        shark.c = 1+rem;
                    }else{
                        shark.c = C-rem;
                        shark.direction = 4;
                    }
                }else{
                    shark.c += shark.speed;
                }
                break;

            case 4: //왼쪽
                arr[shark.r][shark.c] = -1;
                int temp4 = shark.c - shark.speed;
                if(temp4 < 1){
                    int l = temp4*(-1) + 1;
                    int cycle = l/(C-1);
                    int rem = l%(C-1);
                    //System.out.println(index + "번 물고기| l = " + l + " cycle = " + cycle + " rem = " + rem);
                    if(cycle % 2 != 0){
                        shark.c = C - rem;
                    }else{
                        shark.c = 1+rem;
                        shark.direction = 3;
                    }
                }else{
                    shark.c-=shark.speed;
                }
                break;
            default: break;
        }
        //System.out.println(index + "번 상어) 방향: " + shark.direction + " (" + shark.r + ", " + shark.c + ")");
        if(arr2[shark.r][shark.c] != -1){ //상어가 겹칠떄
            if(sharks[arr2[shark.r][shark.c]].size < shark.size){ //기존 상어보다 클 때
                sharks[arr2[shark.r][shark.c]].notValid();//기존 상어를 잡아먹음
                arr2[shark.r][shark.c] = index;
            }else{
                shark.notValid();  //상어가 잡아 먹혔음
            }
        }else{  //상어가 겹치지 않을 때
            arr2[shark.r][shark.c] = index;
        }

    }
    public void humanAction(int i){
        for(int j = 1; j <= R; j++){
            if(arr[j][i] != -1){
                int sharkIndex = arr[j][i];
                //System.out.println("잡아먹힌 상어: "+sharkIndex);
                ans += sharks[sharkIndex].size;
                arr[j][i] = -1;
                sharks[sharkIndex].notValid();
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
    boolean moved;
    boolean valid;
    public Shark(int r, int c, int s, int direction, int size){
        this.r = r;
        this.c = c;
        this.size = size;
        this.speed = s;
        this.direction = direction;
        valid = true;
        moved = false;
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

