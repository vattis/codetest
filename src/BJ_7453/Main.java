package BJ_7453;

//천천히 생각해보고 걍 아이디어를 떠올렸음
//어차피 파이프 교차는 불가능 하기 때문에 파이프가 꼬이면 안됨
//따라서 위에서부터 파이프를 위로 몰아서 설치하는 것이 최적의 방법이다
//500*10000 노드는 전체 탐색을 하기엔 너무 많지만 이번엔 각 노드를 한번씩만 방문하면 된다
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    int[] A, B, C, D, AB, CD;
    int lowerBound(int[] arr, int value){
        int max = arr.length;
        int min = 0;
        while(min<max){
            int mid = (min+max)/2;
            if(value > arr[mid]){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }
    public Solution() throws IOException {
        int ans = 0;
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        B = new int[N+1];
        C = new int[N+1];
        D = new int[N+1];
        AB = new int[N*N];
        CD = new int[N*N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        int c = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                AB[c++] = A[i] + B[j];
            }
        }
        c = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                CD[c++] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        int ab_index = 0;
        int cd_index = 0;
        while(ab_index != N*N-1 && cd_index != N*N-1){
            System.out.println("AB: " + AB[ab_index] + " CD: " + CD[cd_index]);
            if(AB[ab_index] + CD[cd_index] == 0){
                ans++;
                if((AB[ab_index+1]-AB[ab_index]) < (CD[cd_index+1]-CD[cd_index])){
                    ab_index++;
                }
                else{
                    cd_index++;
                }
            }
            else if(Math.abs(AB[ab_index+1] + CD[cd_index]) < Math.abs(AB[ab_index]+CD[cd_index+1])){
                ab_index++;
            }
            else{
                cd_index++;
            }
        }

        if(ab_index == N*N-1){
            while(cd_index != N*N-1){
                if(CD[cd_index] + AB[ab_index] == 0){
                    ans++;
                }
                cd_index++;
            }
        }else if(cd_index == N*N-1){
            while(ab_index != N*N-1){
                System.out.println("AB: " + AB[ab_index] + " CD: " + CD[cd_index]);
                if(AB[ab_index] + CD[cd_index] == 0){
                    ans++;
                }
                ab_index++;
            }
        }
        System.out.println(ans);
    }
}
