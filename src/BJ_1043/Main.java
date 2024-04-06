package BJ_1043;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] ars) {
        int N, M, knownNum, answer;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        knownNum = sc.nextInt();
        ArrayList<Boolean> knownList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> partyList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> partyCheck = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            knownList.add(false);
            partyCheck.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < knownNum; i++){
            knownList.set(sc.nextInt(), true);
        }
        for(int i = 0; i < M; i++){
            int partyMemberNum = sc.nextInt();
            ArrayList<Integer> party = new ArrayList<>();
            for(int j = 0; j < partyMemberNum; j++){
                int m = sc.nextInt();
                party.add(m);
                partyCheck.get(m).add(i);
            }
            partyList.add(party);
        }
        Solution solution = new Solution(partyCheck, partyList, knownList);
        answer = solution.sol(N);
        System.out.println(answer);
    }
}
class Solution{
    public Solution(ArrayList<ArrayList<Integer>> partyCheck_, ArrayList<ArrayList<Integer>> partyList_, ArrayList<Boolean> knownList_){
        partyCheck = partyCheck_;
        partyList = partyList_;
        knownList = knownList_;
    }
    public static ArrayList<ArrayList<Integer>> partyCheck;
    public static ArrayList<ArrayList<Integer>> partyList;
    public static ArrayList<Boolean> knownList;
    public static int sol(int N){
        for(int i = 1; i <= N; i++){
            if(knownList.get(i)){
                searchParty(i);
            }
        }
        return cntAbleParty();
    }
    public static int cntAbleParty(){
        int ans = 0;
        for(ArrayList<Integer> party : partyList){
            int flag = 0;
            for(int member : party){
                if(knownList.get(member)){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                ans++;
            }
        }
        return ans;
    }
    public static void searchParty(int member){
        ArrayList<Integer> parties = partyCheck.get(member);
        for(int p : parties){
            searchPartyMember(p);
        }
    }
    public static void searchPartyMember(int party){
        ArrayList<Integer> partyMembers = partyList.get(party);
        for(int m : partyMembers){
            if(!knownList.get(m)){
                knownList.set(m, true);
                searchParty(m);
            }
        }
    }
}
