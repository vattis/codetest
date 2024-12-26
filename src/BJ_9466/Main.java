package BJ_9466;

//걍 쉬웠음 ㅇㅇ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    int T;

    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int ans = 0;
            int n = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[n+2];
            boolean[] isTeam = new boolean[n+2];
            Arrays.fill(visited, false);
            Arrays.fill(isTeam, false);
            int[] team = new int[n + 2];
            st = new StringTokenizer(br.readLine());
            int t = 1;
            while (st.hasMoreTokens()) {
                team[t++] = Integer.parseInt(st.nextToken());
            }
            for(int j = 1; j <= n; j++){
                ArrayList<Integer> mem = new ArrayList<>();
                if(!visited[j]){
                    int curIndex = j;
                    while(!visited[curIndex]){
                        visited[curIndex] = true;
                        mem.add(curIndex);
                        curIndex = team[curIndex];
                    }

                    if(curIndex == team[curIndex]){ // 자기 자신을 지목한 경우
                        isTeam[curIndex] = true;
                        for(int k = 0; k < mem.size()-1; k++){
                            isTeam[mem.get(k)] = false;
                        }
                    }
                    else{ //자기 자신을 지목하지 않은 경우
                        for(t = 0; t < mem.size(); t++){
                            if(mem.get(t) == curIndex){ break; }
                        }
                        for(int k = 0; k < t; k++){
                            isTeam[mem.get(k)] = false;
                        }
                        for(int k = t; k < mem.size(); k++){
                            isTeam[mem.get(k)] = true;
                        }
                    }

                }
            }
            for(int m = 1; m <= n; m++){
                if(!isTeam[m]){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

