package com.hotel.greedy;

public class GasStation {
  public static void main(String[] args) {
    int[] gas ={1,2,3,4,5},
         cost ={3,4,5,1,2};
    System.out.println(new GasStation().canCompleteCircuit(gas, cost));
  }

  int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0,total = 0,tank = 0;
    //if car fails at 'start', record the next station
    for(int i=0;i<gas.length;i++) {
      tank = tank + gas[i] - cost[i];
      if ( tank< 0) {
        start = i + 1;
        total += tank;
        tank = 0;
      }
    }
    return (total+tank<0)? -1:start;
  }
}
