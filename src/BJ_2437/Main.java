package BJ_2437;

//그리디 알고리즘이 단순히 막 계산하는 것은 아니라는 거...
//일단 배열을 정렬시키고 시작해야겠다는 생각은 들었지만 그 후에 그냥 감도 못잡았음...
//포인트는 숫자를 하나하나 놓고 추를 대입하는 게 아니었음
//정렬된 배열을 하나씩 누적해가면서 가능 범위를 확장해가는 방식
//정렬된 n개의 추로 만들 수 있는 범위가 1~M 이라면 이 다음에 나오는 추는 무개가 M+1까진 문제가 없음 (M까진 기존 추로 만들 수 있고 M+1은 새로운 추 1개면 될테니까)
//n+1번째 추의 무개가 K라면, n+1개의 추로는 1~M+K까지의 범위를 커버 할 수 있게됨
//즉 기존 추로 새로운 추와 동일한 무개를 만들 수 있다면 가능 범위가 새로운 추만큼 늘어나는 샘
//솔직히 이런 발상을 내가 할 수 있을지 모르겠다
//약간 점화식 느낌도 나는 거 같고...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.pow;

class Solution {
   int N;
   Long[] arr;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   public Solution() throws IOException {
       N = Integer.parseInt(br.readLine());
       arr = new Long[N];
       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i = 0; i < N; i++){
           arr[i] = Long.parseLong(st.nextToken());
       }
       Arrays.sort(arr);
       Long sum = arr[0];
       int index = 1;
       if(1 < sum){
           System.out.println(1);
           return;
       }
       while(index<N){
           if(sum+1 < arr[index]){
               System.out.println(sum+1);
               return;
           }
           sum+=arr[index];
           index++;
       }
       System.out.println(sum+1);
   }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}

