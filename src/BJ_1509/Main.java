package BJ_1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] ars) throws IOException {
        new Solution();
    }
}
class Solution{
    char[] arr;
    public Solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = str.toCharArray();
    }

}

