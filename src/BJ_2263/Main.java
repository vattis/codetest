package BJ_2263;

//ㅅㅂ 어려워서 결국 답 봤음
//핵심 아이디어는 3가지
//각 order를 2개로 재귀적으로 분할시키기
//루트를 기준으로 order를 양쪽으로 나누면 나눈 order의 길이는 항상 같다는 것
//마지막으로 배열의 값이 1~N까지 겹치지 않고 N개가 모두 있을때 값을 알면 그 배열의 index 한번에 역추적할 수 있다는 것
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution{
    int N;
    int[] inOrder;
    int[] postOrder;
    int[] inOrderIndex;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        inOrder = new int[N+1];
        postOrder = new int[N+1];
        inOrderIndex = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++){
            inOrderIndex[inOrder[i]] = i;
        }
        func(1, N, 1, N);
        System.out.println(sb.toString());
    }
    void func(int inorderStart, int inorderEnd, int postOrderStart, int postOrderEnd){
        if(inorderStart > inorderEnd || postOrderStart > postOrderEnd){
            return;
        }
        int root = postOrder[postOrderEnd];
        int len = inOrderIndex[root]-inorderStart;
        sb.append(root + " ");
        func(inorderStart, inorderStart+len-1, postOrderStart, postOrderStart+len-1);
        func(inorderStart+len+1, inorderEnd, postOrderStart+len, postOrderEnd-1);
    }
}


public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}