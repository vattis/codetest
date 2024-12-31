package BJ_13460;

//방법은 솔직히 바로 알 수 있었음
//구현 하는 데 시간이 좀 걸림
//사소한 부분을 놓치기도 했음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    int N, M;
    char[][] map;
    int[][][][] DP = new int[11][11][11][11];
    int ans = 100;


    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                for(int t = 0; t < 11; t++){
                    Arrays.fill(DP[i][j][t], 11);
                }
            }
        }
        RedBlueBall redBlueBall = new RedBlueBall(0, 0, 0, 0);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N+2][M+2];
        for (int i = 0; i < N; i++) {
            map[i] = new char[M+2];
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    redBlueBall.R_x = j;
                    redBlueBall.R_y = i;
                }
                else if(map[i][j] == 'B'){
                    redBlueBall.B_x = j;
                    redBlueBall.B_y = i;
                }
            }
        }
        recur(0, redBlueBall);
        if(ans == 100){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    RedBlueBall up(RedBlueBall redBlueBall){
        int R_x = redBlueBall.R_x;
        int R_y = redBlueBall.R_y;
        int B_x = redBlueBall.B_x;
        int B_y = redBlueBall.B_y;
        boolean redSuccess = false;
        boolean blueSuccess = false;
        if(R_y < B_y){
            while(map[R_y][R_x] != '#'){ //빨간 공 위로
                R_y--;
                if(map[R_y][R_x] == 'O'){
                    redSuccess = true;
                    break;
                }
            }
            while(map[B_y][B_x] != '#'){ //파란 공 위로
                B_y--;
                if(map[B_y][B_x] == 'O'){
                    blueSuccess = true;
                    break;
                }else if(R_y == B_y && R_x == B_x){
                    B_y++;
                    break;
                }
            }
        }else{
            while(map[B_y][B_x] != '#'){ //파란 공 위로
                B_y--;
                if(map[B_y][B_x] == 'O'){
                    blueSuccess = true;
                    break;
                }
            }
            while(map[R_y][R_x] != '#'){ //빨간 공 위로
                R_y--;
                if(map[R_y][R_x] == 'O'){
                    redSuccess = true;
                    break;
                }else if(R_y == B_y && R_x == B_x){
                    R_y++;
                    break;
                }
            }
        }

        R_y++; B_y++;
        if(blueSuccess){ //파란 공이 들어가는 경우
            return new RedBlueBall(-1, -1, -1, -1);
        }
        else if(redSuccess && !blueSuccess) { //빨간 공만 들어가는 경우
            return new RedBlueBall(0, 0, 0, 0);
        }
        return new RedBlueBall(R_x, R_y, B_x, B_y);
    }

    RedBlueBall down(RedBlueBall redBlueBall){
        int R_x = redBlueBall.R_x;
        int R_y = redBlueBall.R_y;
        int B_x = redBlueBall.B_x;
        int B_y = redBlueBall.B_y;
        boolean redSuccess = false;
        boolean blueSuccess = false;
        if(R_y > B_y){
            while(map[R_y][R_x] != '#'){ //빨간 공 아래로
                R_y++;
                if(map[R_y][R_x] == 'O'){
                    redSuccess = true;
                    break;
                }
            }
            while(map[B_y][B_x] != '#'){ //파란 공 아래로
                B_y++;
                if(map[B_y][B_x] == 'O'){
                    blueSuccess = true;
                    break;
                }else if(R_y == B_y && R_x == B_x){
                    B_y--;
                    break;
                }
            }
        }else{
            while(map[B_y][B_x] != '#'){ //파란 공 아래로
                B_y++;
                if(map[B_y][B_x] == 'O'){
                    blueSuccess = true;
                    break;
                }
            }
            while(map[R_y][R_x] != '#'){ //빨간 공 아래로
                R_y++;
                if(map[R_y][R_x] == 'O'){
                    redSuccess = true;
                    break;
                }else if(R_y == B_y && R_x == B_x){
                    R_y--;
                    break;
                }
            }
        }

        R_y--; B_y--;
        if(blueSuccess){ //파란 공이 들어가는 경우
            return new RedBlueBall(-1, -1, -1, -1);
        }
        else if(redSuccess && !blueSuccess) { //빨간 공만 들어가는 경우
            return new RedBlueBall(0, 0, 0, 0);
        }
        return new RedBlueBall(R_x, R_y, B_x, B_y);
    }

    RedBlueBall left(RedBlueBall redBlueBall){
        int R_x = redBlueBall.R_x;
        int R_y = redBlueBall.R_y;
        int B_x = redBlueBall.B_x;
        int B_y = redBlueBall.B_y;
        boolean redSuccess = false;
        boolean blueSuccess = false;
        if(R_x < B_x){
            while(map[R_y][R_x] != '#'){ //빨간 공 왼쪽
                R_x--;
                if(map[R_y][R_x] == 'O'){
                    redSuccess = true;
                    break;
                }
            }
            while(map[B_y][B_x] != '#'){ //파란 공 왼쪽
                B_x--;
                if(map[B_y][B_x] == 'O'){
                    blueSuccess = true;
                    break;
                }else if(R_y == B_y && R_x == B_x){
                    B_x++;
                    break;
                }
            }
        }else{
            while(map[B_y][B_x] != '#'){ //파란 공 왼쪽
                B_x--;
                if(map[B_y][B_x] == 'O'){
                    blueSuccess = true;
                    break;
                }
            }
            while(map[R_y][R_x] != '#'){ //빨간 공 왼쪽
                R_x--;
                if(map[R_y][R_x] == 'O'){
                    redSuccess = true;
                    break;
                }else if(R_y == B_y && R_x == B_x){
                    R_x++;
                    break;
                }
            }
        }

        R_x++; B_x++;
        if(blueSuccess){ //파란 공이 들어가는 경우
            return new RedBlueBall(-1, -1, -1, -1);
        }
        else if(redSuccess && !blueSuccess) { //빨간 공만 들어가는 경우
            return new RedBlueBall(0, 0, 0, 0);
        }
        return new RedBlueBall(R_x, R_y, B_x, B_y);
    }

    RedBlueBall right(RedBlueBall redBlueBall){
        int R_x = redBlueBall.R_x;
        int R_y = redBlueBall.R_y;
        int B_x = redBlueBall.B_x;
        int B_y = redBlueBall.B_y;
        boolean redSuccess = false;
        boolean blueSuccess = false;
        if(B_x < R_x){
            while(map[R_y][R_x] != '#'){ //빨간 공 오른쪽
                R_x++;
                if(map[R_y][R_x] == 'O'){
                    redSuccess = true;
                    break;
                }
            }
            while(map[B_y][B_x] != '#'){ //파란 공 오른쪽
                B_x++;
                if(map[B_y][B_x] == 'O'){
                    blueSuccess = true;
                    break;
                }else if(R_y == B_y && R_x == B_x){
                    B_x--;
                    break;
                }
            }
        }else{
            while(map[B_y][B_x] != '#'){ //파란 공 오른쪽
                B_x++;
                if(map[B_y][B_x] == 'O'){
                    blueSuccess = true;
                    break;
                }
            }
            while(map[R_y][R_x] != '#'){ //빨간 공 오른쪽
                R_x++;
                if(map[R_y][R_x] == 'O'){
                    redSuccess = true;
                    break;
                }else if(R_y == B_y && R_x == B_x){
                    R_x--;
                    break;
                }
            }
        }

        R_x--; B_x--;
        if(blueSuccess){ //파란 공이 들어가는 경우
            return new RedBlueBall(-1, -1, -1, -1);
        }
        else if(redSuccess && !blueSuccess) { //빨간 공만 들어가는 경우
            return new RedBlueBall(0, 0, 0, 0);
        }
        return new RedBlueBall(R_x, R_y, B_x, B_y);
    }


    int recur(int count, RedBlueBall redBlueBall){
        if(count > 10){
            return 0;
        }
        if(redBlueBall.R_x == 0 && redBlueBall.R_y == 0 && redBlueBall.B_x == 0 && redBlueBall.B_y == 0){ //성공 했을 경우
            if(count < ans){ ans = count; }
            return -1;
        }
        else if(redBlueBall.R_x == -1 && redBlueBall.R_y == -1 && redBlueBall.B_x == -1 && redBlueBall.B_y == -1){
            return -1;
        }
        if(DP[redBlueBall.R_x][redBlueBall.R_y][redBlueBall.B_x][redBlueBall.B_y] < count){ //같은 상황이 이미 나왔을 때
            return -1;
        }
        DP[redBlueBall.R_x][redBlueBall.R_y][redBlueBall.B_x][redBlueBall.B_y] = count;
        recur(count+1, up(redBlueBall));
        recur(count+1, down(redBlueBall));
        recur(count+1, left(redBlueBall));
        recur(count+1, right(redBlueBall));
        return 0;
    }
}
class RedBlueBall{
    int R_x, R_y, B_x, B_y;
    public RedBlueBall(int rx, int ry, int bx, int by){
        R_x = rx;
        R_y = ry;
        B_x = bx;
        B_y = by;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

