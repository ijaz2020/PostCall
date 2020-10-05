package com.cp.finiteStateMachine;

public class FrogsCroaking {
  public static void main(String[] args) {
    System.out.println(new FrogsCroaking().minNumberOfFrogs("cr"));
  }

  public int minNumberOfFrogs(String croakOfFrogs) {
    // use 5 finite state machine
    int[] fsm = new int[5];
    int result = 0;
    for(char c : croakOfFrogs.toCharArray()) {
      if(c=='c') {
        fsm[0]++;
      } else if(c=='r') {
        fsm[0]--;
        fsm[1]++;
      } else if(c=='o') {
        fsm[1]--;
        fsm[2]++;
      } else if(c=='a') {
        fsm[2]--;
        fsm[3]++;
      } else if(c=='k') {
        fsm[3]--;
        fsm[4]++;
      }

      if(fsm[0] < 0 || fsm[1] < 0 || fsm[2] < 0 || fsm[3] < 0 || fsm[4] < 0) {
        return -1;
      }
      int totalMachine = 0;
      for(int i = 0; i < 4; i++) {
        totalMachine += fsm[i];
      }
      result = Math.max(result, totalMachine);
    }
    for(int i = 0; i < 4; i++) {
      if(fsm[i] != 0) {
        return -1;
      }
    }
    return result;
  }
}
