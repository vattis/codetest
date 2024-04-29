package BJ_1022;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] ars) {
        int r1, r2, c1, c2;
        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
    }
}
class Solution{

}
class Tool{
    int findColOrigin(int r){
        return 1+(r*r-r)/2*8+3*r;
    }
}
