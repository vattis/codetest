package BJ_11444;
//일단 숫자가 무식하게 커서 일반적인 방법으론 안된다는 걸 알았음
//그다음 생각한게 이 숫자를 감당하려면 로그의 시간복잡도를 가져야 한다는 생각
//여기서 막혔는데 수학적으로 접근해야했음
//결국 F[2n] = F[n] 과 같은 방정식을 찾는 것이 이 문제의 핵심
//이건 그냥 여러 식 써보고 대입하면서 찾아내는거라 뭐...
//그리로 이 숫자를 감당하기 위해서 BigInteger를 썼음
//구현은 ㅈㄴ 쉬움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

class Solution {
    String N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<BigInteger, BigInteger> DP = new HashMap<>();

    public Solution() throws IOException {
        DP.put(new BigInteger("0"), new BigInteger("0"));
        DP.put(new BigInteger("1"), new BigInteger("1"));
        N = br.readLine();
        System.out.println(recur(new BigInteger(N)).remainder(new BigInteger("1000000007")).toString());
    }

    BigInteger recur(BigInteger index){
        if(DP.containsKey(index)){
            //System.out.println("DP 사용함");
            return DP.get(index);
        }
        if(index.remainder(new BigInteger("2")).compareTo(new BigInteger("0")) == 0){ //짝수인 경우
            BigInteger a = recur(index.divide(new BigInteger("2")));  //F[n]
            BigInteger b = recur(index.divide(new BigInteger("2")).subtract(new BigInteger("1")));  //F[n-1]
            BigInteger ans = (a.multiply(a).add(a.multiply(b).multiply(new BigInteger("2"))));
            ans = ans.remainder(new BigInteger("1000000007"));
            DP.put(index, ans);
            return ans; //F[n]^2 + F[n]F[n-1]
        }else{  // 홀수인 경우
            BigInteger a = recur(index.divide(new BigInteger("2")));  //F[n]
            BigInteger b = recur(index.divide(new BigInteger("2")).add(new BigInteger("1")));
            BigInteger ans = a.multiply(a).add(b.multiply(b));
            ans = ans.remainder(new BigInteger("1000000007"));
            DP.put(index, ans);
            return ans;
        }
    }

}

public class Main {
    public static void main(String[] ars) throws IOException {
        Solution sol = new Solution();
    }
}

