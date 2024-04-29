package BJ_1022;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] ars) {
        int r1, r2, c1, c2;
        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        Tool t = new Tool();
        int[][] arr = new int[50][4];
        for(int i = r1; i <= r2; i++){
            for(int j = c1; j < c2; j++){
                arr[i-c1][j-r1] = t.findVal(i, j);
            }
        }

        for(int i = r1; i <= r2; i++){
            for(int j = c1; j <= c2; j++){
                System.out.print(arr[i-c1][j-r1] + " ");
            }
            System.out.println();
        }
    }
}
class Solution{

}
class Tool{

    public int findVal(int r, int c){
        int ans = 0;
        if(r<0 && abs(r) >= abs(c)){
            ans = findColOrigin1(r)-c;
        }
        else if(c > 0 && abs(r) <= abs(c)){
            ans = findColOrigin2(c)-r;
        }
        else if(r>0 && abs(r) >= abs(c)){
            ans = findColOrigin3(3)+c;
        }
        else if(r<0 && abs(r) <= abs(c)){
            ans = findColOrigin4(4)+r;
        }
        return ans;
    }
    int findColOrigin1(int r){return 1+(r*r-r)/4+3*r;}
    int findColOrigin2(int c){return 1+(c*c-c)/4+c;}
    int findColOrigin3(int r){return 1+(r*r-r)/4+7*r;}
    int findColOrigin4(int c){
        return 1+(c*c-c)/4+5*c;
    }

}
