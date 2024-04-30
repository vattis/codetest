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
        int[][] arr = new int[51][5];
        int max = 0;
        for(int i = r1; i <= r2; i++){
            for(int j = c1; j <= c2; j++){
                arr[i-r1][j-c1] = t.findVal(i, j);
                if(max < arr[i-r1][j-c1]){
                    max = arr[i-r1][j-c1];
                }
            }
        }
        int l = (max+"").length();
        switch(l){
            case(1):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
            case(2):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%2d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
            case(3):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%3d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
            case(4):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%4d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
            case(5):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%5d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
            case(6):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%6d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
            case(7):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%7d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
            case(8):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%8d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
            case(9):
                for(int i = r1; i <= r2; i++){
                    for(int j = c1; j <= c2; j++){
                        System.out.printf("%9d" + " ", arr[i-r1][j-c1]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
class Solution{

}
class Tool{

    public int findVal(int r, int c){
        int ans = 0;
        if(r <= 0 && abs(r) >= abs(c)){
            ans = findColOrigin1(r)-c;
        }
        else if(c >= 0 && abs(r) <= abs(c) && c != r){
            ans = findColOrigin2(c)-r;
        }
        else if(r >= 0 && abs(r) >= abs(c)){
            ans = findColOrigin3(r)+c;
        }
        else if(c <= 0 && abs(r) <= abs(c)){
            ans = findColOrigin4(c)+r;
        }
        return ans;
    }
    int findColOrigin1(int r){ r = abs(r); return 1+(r*r-r)*4+3*r;}
    int findColOrigin2(int c){ c = abs(c); return 1+(c*c-c)*4+c;}
    int findColOrigin3(int r){ r= abs(r); return 1+(r*r-r)*4+7*r;}
    int findColOrigin4(int c){ c = abs(c); return 1+(c*c-c)*4+5*c;}

}
