package BJ_12015;
//이 문제 벽느낌
//이거랑 비슷한 유형의 문제가 있다는 걸 알게됐는데 그 문제는 내가 생각한 방법으로 풀림
//얘는 수가 너무 많아서 그 방법으론 안 풀림
//솔직히 해설 보고 좀 더 생각한 다음에야 이해할 수 있었음
//하... 이거랑 비슷한 식으로 사고해야 하는 문제는 다시 나와도 풀 수 있을까...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    int N;
    int[] arr;
    int[] ansList;

    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        ansList = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(ansList[cnt] < arr[i]){
                cnt++;
                ansList[cnt] = arr[i];
            }else if(arr[i] < ansList[cnt]){
                int index = binarySearch(ansList, cnt, arr[i]);
                if(index != -1){
                    ansList[index] = arr[i];
                }
            }
        }
        System.out.println(cnt);
    }
    int binarySearch(int[] ansList, int length, int target){
        int start = 0;
        int end = length-1;
        int mid = 0;
        while(start <= end){
            mid = (start+end)/2;
            if(target < ansList[mid]){
                end = mid-1;
            }else if(ansList[mid] < target){
                start = mid+1;
            }else{
                return -1;
            }
        }
        if(target<ansList[mid]){
            return mid;
        }else{
            return mid+1;
        }
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

