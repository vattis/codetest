package BJ_3015;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    long N;
    long ans = 0;
    Node[] arr = new Node[500001];
    Stack<Node> stack = new Stack<>();
    Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = new Node(Long.parseLong(br.readLine()));
        }
        stack.add(arr[0]);
        for(int i = 1; i < N; i++){
            while(!stack.isEmpty() && arr[i].num > stack.peek().num){
                ans += stack.pop().cnt;
                //System.out.println("AAAAAAAAAAA::::ANS:::" + ans);
            }
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }
            else if(stack.peek().num == arr[i].num) {
                Node temp = stack.pop();
                ans += temp.cnt++;
                if(!stack.isEmpty()){
                    ans++;
                }
                stack.push(temp);
                //System.out.println("BBBBBBBBB::::ANS:::" + ans);
            }else if(stack.peek().num > arr[i].num){
                ans++;
                stack.push(arr[i]);
                //System.out.println("CCCCCCCCC::::ANS:::" + ans);
            }
        }
        System.out.println(ans);
    }
}
class Node{
    long num;
    long cnt;
    Node(long num){
        this.num = num;
        this.cnt = 1;
    }
}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}