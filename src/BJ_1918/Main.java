package BJ_1918;

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
        char[] ss = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder("");
        int index = 0;
        while(index < ss.length){
            char s = ss[index];
            if(s == '+' || s =='-'){
                if(!operators.isEmpty()){
                    if(operators.peek() == '+' || operators.peek() == '-'){
                        char s2 = operators.pop();
                        while(s2 != '('){
                            sb.append(s2);
                            s2 = operators.pop();
                            System.out.println(sb);
                        }
                    }
                }
                operators.add(s);
            }
            else if(s == '('){
                operators.add(s);
                while(!numbers.isEmpty()){
                    sb.append(numbers.poll());
                }
            }
            else if(s == ')'){
                while(!numbers.isEmpty()){
                    sb.append(numbers.poll());
                    System.out.println(sb);
                }
                char s2 = ' ';
                while(s2 != '('){
                    s2 = operators.pop();
                    if(s2 != '(' && s2 !=')'){sb.append(s2);}
                    System.out.println(sb);
                }
            }
            else if(s == '*' || s == '/'){
                if(ss[index+1] == '('){
                    operators.add(s);
                }
                else{
                    operators.add('(');
                    operators.add(s);
                    while(numbers.size() > 1){
                        sb.append(numbers.poll());
                        System.out.println(sb);
                    }
                    numbers.add(ss[++index]);
                    while(!numbers.isEmpty()){
                        sb.append(numbers.poll());
                        System.out.println(sb);
                    }
                    char s2 = ' ';
                    while(s2 != '('){
                        s2 = operators.pop();
                        if(s2 != '(' && s2 !=')'){sb.append(s2);}
                        System.out.println(sb);
                    }
                }
            }
            else{
                numbers.add(s);
            }
            index++;
        }

        System.out.println(sb);
    }
}

