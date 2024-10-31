package BJ_1781;
//이걸 왜 못 풀었지....
//이론을 모르는 것도 아니고 걍 아이디어가 안 떠올랐다
//걍 데드라인 순으로 정렬한다음 보상 적은 것부터 교체해가는 문제
//병신인가
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution s = new Solution();
    }
}
class Solution{
    int N;
    int s = 0;
    Cup[] numList;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Cup> queue = new PriorityQueue<>();

    public Solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numList = new Cup[N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            numList[i] = new Cup(n1, n2);
        }
        Arrays.sort(numList, 1, N+1, new CupComparator());
        for(int i = 1; i <= N; i++){
            Cup cup = numList[i];
            if(cup.num1 > queue.size()){
                queue.add(cup);
            }else{
                if(queue.peek().num2 < cup.num2){
                    queue.poll();
                    queue.add(cup);
                }
            }
           // for(Cup c:queue){
           //     System.out.println(c.num1 + "|" + c.num2);
            //}
            //System.out.println("====================");
        }

        for(Cup c:queue){
            s += c.num2;
        }
        System.out.println(s);
    }
}
class Cup implements Comparable<Cup>{
    int num1, num2;
    public Cup(int n1, int n2){
        num1 = n1;
        num2 = n2;
    }

    @Override
    public int compareTo(Cup o) {
        return num2-o.num2;
    }
}
class CupComparator implements Comparator<Cup> {
    @Override
    public int compare(Cup o1, Cup o2) {
        return o1.num1-o2.num1;
    }
}


