package BJ_1700;
//처음에는 빈도수를 기준으로 우선순위 큐를 만드려고 했음
//금방 반례를 찾았고 다음 순서가 가장 늦게 찾아오는 코드를 뺀다는 아이디어를 찾긴 했지만 확신이 없었음
//구현하는 것도 어려웠음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    int N, K;
    int[] schedule;
    int[] code;

    Solution() throws IOException {
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        schedule = new int[K];
        code = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(st.nextToken());
            schedule[i] = num;
        }

        for(int i = 0; i < schedule.length; i++){
            //System.out.print(schedule[i] + ")");
           // for(int cc : code){
            //    System.out.print(cc + " ");
            //}
            //System.out.println();
            int a = schedule[i];
            int len = -1;
            int indexMem = -1;
            int flag = 1;
            for(int j = 0; j < code.length; j++){
                if(code[j] == schedule[i]){ //이미 꽂혀있는 전자제품을 사용할 때
                    //System.out.println("이미 사용중");
                    flag = 0;
                    break;
                }
                else if(code[j] == 0){ // 빈자리가 있을 때
                    //System.out.println("빈자리 있음");
                    code[j] = a;
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){ // 코드에 빈자리가 없을 때
                for(int c = 0; c < code.length; c++){
                    int ff = 0;
                    for(int t = i+1; t < schedule.length; t++){
                        if(code[c] == schedule[t]){
                            ff = 1;
                            if(len < t-i){
                                len = t-i;
                                indexMem = c;
                            }
                            break;
                        }
                    }
                    if(ff == 0){ //c번째 code가 다시는 사용되지 않는 경우
                        code[c] = a;
                        ans++;
                        //System.out.println("해당 코드는 더이상 사용안함");
                        indexMem = -1;
                        break;
                    }
                }
                if(indexMem != -1){ //가장 늦게 쓸 예정인 코드 제거
                    code[indexMem] = a;
                    ans++;
                    //System.out.println("bbbbbbbbbbbbbbb");
                }
            }
        }
        System.out.println(ans);
    }
}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}

