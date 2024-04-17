package BJ_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        int N;
        int[] arr = new int[2001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, 0, N);
        Solution solution = new Solution(arr, N);
        System.out.println(solution.solution());
    }
}
class Solution{
    int[] arr;
    int N;

    public Solution(int[] arr_, int N_){
        arr = arr_;
        N = N_;
    }
    public int solution(){
        int ans = 0;
        for(int i = 0; i < N; i++){
            if(findCombine(arr[i], i)){
                ans++;
            }
        }
        return ans;
    }
    public boolean findCombine(int goal, int curIndex){
        int start = 0;
        int end = N-1;
        while(start < end){
            int num = arr[start]+arr[end];
            if(goal < num){
                end--;
            }
            else if(goal > num){
                start++;
            }
            else{
                if(start != curIndex && end != curIndex){
                    return true;
                }
                else if(start == curIndex){
                    start++;
                }
                else if(end == curIndex){
                    end--;
                }
            }
        }
        return false;
    }
    /*
    int[] arr;
    int N;

    public Solution(int[] arr_, int N_){
        arr = arr_;
        N = N_;
    }
    public int solution(){
        int ans = 0;
        for(int i = 0; i < N; i++){
            int num = arr[i];
            if(findCombine(i, num)){
                ans++;
            }
        }
        return ans;
    }

    public boolean findCombine(int index, int num){
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(arr[j]+arr[i] == num && i != index && j != index){
                    return true;
                }
                if(num-arr[i] < arr[j]){
                    break;
                }
            }
        }
        return false;
    }
    */
}

