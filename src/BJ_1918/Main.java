package BJ_1918;
//시발 그냥 노가다 했고 ㅈㄴ 오래걸림
//반례 찾기 노가다 밖에 안했음
//풀이는 안봤는데 이렇게 푸는게 맞나??
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution solution = new Solution();
    }
}
class Solution {
    Stack<Character> operators = new Stack<>();
    Queue<Character> numbers = new LinkedList<>();
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder("");
        for(int index = 0; index < arr.length; index++) {
            char currentChar = arr[index];
            if(currentChar == '+' || currentChar == '-') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    while (!numbers.isEmpty()) {
                        sb.append(numbers.poll());
                    }
                    sb.append(operators.pop());
                }
                operators.push(currentChar);
            }
            else if(currentChar == '*' || currentChar == '/') {
                if(arr[index+1] == '('){
                    operators.push(currentChar);
                }else{
                    numbers.add(arr[++index]);
                    if(!operators.isEmpty()){
                        //while(operators.peek() != '('){
                            if((operators.peek() == '*' || operators.peek() == '/')){
                                sb.append(operators.pop());
                            }
                            while (!numbers.isEmpty()) {
                                sb.append(numbers.poll());
                            }

                        //}
                    }else{
                        while (!numbers.isEmpty()) {
                            sb.append(numbers.poll());
                        }
                    }
                    sb.append(currentChar);
                }
            }
            else if(currentChar == '(') {
                while (!numbers.isEmpty()) {
                    sb.append(numbers.poll());
                }
                operators.push(currentChar);
            }
            else if(currentChar == ')') {
                while(operators.peek() != '('){
                    while (!numbers.isEmpty()) {
                        sb.append(numbers.poll());
                    }
                    sb.append(operators.pop());
                }
                operators.pop();
            }
            else{
                numbers.add(currentChar);
            }
        }
        while(!numbers.isEmpty()) {
            sb.append(numbers.poll());
        }
        while(!operators.isEmpty()){
            sb.append(operators.pop());
        }
        System.out.println(new String(sb));
    }
}

