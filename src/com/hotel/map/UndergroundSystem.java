package com.hotel.map;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
  public static void main(String[] args) {
    UndergroundSystem undergroundSystem = new UndergroundSystem();
    undergroundSystem.checkIn(45, "Leyton", 3);
    undergroundSystem.checkIn(32, "Paradise", 8);
    undergroundSystem.checkIn(27, "Leyton", 10);
    undergroundSystem.checkOut(45, "Waterloo", 15);
    undergroundSystem.checkOut(27, "Waterloo", 20);
    undergroundSystem.checkOut(32, "Cambridge", 22);
    System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
    System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
    undergroundSystem.checkIn(10, "Leyton", 24);
    System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0
    undergroundSystem.checkOut(10, "Waterloo", 38);
    System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 12.0

  }
  Map<Integer, Station> checkInMap;
  Map<String, Average> averageMap;

  public UndergroundSystem() {
    checkInMap = new HashMap<>();
    averageMap = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    checkInMap.put(id, new Station(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    Station st = checkInMap.get(id);
    String key = st.name + "-" + stationName;
    averageMap.compute(key, (k, v) ->{
      if(v == null)
        return new Average( t-st.start, 1);
      else {
        v.setCurrentTakenTime(v.getCurrentTakenTime() + (t-st.start));
        v.setCount(v.count + 1);
        return v;
      }
    });
  }

  public double getAverageTime(String startStation, String endStation) {
      Average average = averageMap.get(startStation+"-"+endStation);
      return  (double)average.getCurrentTakenTime() / average.getCount();
  }
}

class Station {
  String name;
  int start;

  Station(String name, int start) {
    this.name = name;
    this.start = start;
  }
}

class Average {
  Integer currentTakenTime;
  Integer count;

  Average(Integer average, Integer count) {
    this.currentTakenTime = average;
    this.count = count;
  }

  Integer getCurrentTakenTime() {
    return this.currentTakenTime;
  }

  void setCurrentTakenTime(Integer currentTakenTime) {
    this.currentTakenTime = currentTakenTime;
  }

  Integer getCount() {
    return this.count;
  }

  void setCount(Integer count) {
    this.count = count;
  }
}


//[null,null,null,null,null,null,null,null,null,86.00000,null,null,3.00000,45.00000,null,null,45.00000,null,null,null,45.00000,133.00000,1.00000,null,null,1.00000,1.00000,133.00000,null,74.00000,133.00000,45.00000,null,9.00000,null,null,null,null,null,45.00000,null,null,null,null,null,3.00000,null,1.00000,null,null,null,null,null,null,null,null,null,null,null,null,133.00000,null,null,null,null,null,null,1016.00000,null,552.00000,40.00000,null,null,null,552.00000,null,null,283.00000,null,null,null,636.00000,1.00000,null,74.00000,960.00000,null,153.00000,null,null,null,40.00000,null,null,null,null,709.00000,null,null,null,null,null,null,1162.00000,null,510.00000,null,null,null,1.00000,null,null,539.00000,null,null,null,null,null,null,null,null,960.00000,null,null,null,1016.00000,null,null,null,null,null,null,null,null,74.00000,null,null,null,347.00000,null,null,null,null,null,null,null,null,960.00000,1016.00000,null,null,null,null,null,null,null,null,9.00000,636.00000,null,null,709.00000,null,null,null,636.00000,1471.00000,null,516.00000,null,null,null,1016.00000,1.00000,null,null,null,null,null,null,null,null,null,null,null,157.00000,null,null,null,null,null,153.00000,null,null,null,2440.00000,null,1522.00000,null,null,null,null,586.00000,null,null,1385.00000,null,960.00000,428.00000,null,null,null,null,null,null,null,null,1806.00000,null,null,null,185.00000,586.00000,133.00000,null,null,936.00000,491.00000,null,null,null,null,1660.00000,1984.00000,null,133.00000,null,5476.00000,null,636.00000,null,null,null,5476.00000,null,7.00000,null,null,2440.00000,null,null,1471.00000,1601.00000,null,null,null,null,40.00000,981.00000,347.00000,null,null,null,1283.00000,null,1522.00000,1487.00000,1078.00000,null,null,153.00000,283.00000,null,133.00000,3651.00000,null,null,1193.00000,2490.00000,1806.00000,703.00000,1.00000,null,323.00000,null,null,null,636.00000,null,null,3.00000,null,null,1493.00000,null,null,null,null,null,null,null,null,null,null,null,null,936.00000,null,2016.00000,666.00000,null,null,null,153.00000,null,325.00000,null,290.00000,null,290.00000,null,null,45.00000,null,null,null,null,null,null,null,null,1517.00000,null,null,null,null,null,null,290.00000,null,2997.00000,null,null,null,null,null,null,653.00000,null,null,null,null,164.00000,null,null,null,1493.00000,null,1283.00000,552.00000,636.00000,36.00000,null,null,null,2299.00000,1487.00000,1193.00000,null,4842.00000,null,157.00000,null,null,null,null,null,null,2269.00000,null,null,4579.00000,null,null,3651.00000,null,null,null,null,null,null,1248.00000,null,null,null,null,null,null,1000.00000,217.00000,null,null,null,2272.00000,864.00000,1317.00000,null,null,347.00000,null,1385.00000,36.00000,null,null,null,null,null,null,null,null,null,325.00000,null,null,null,null,2016.00000,1471.00000,9.00000,null,null,null,null,1259.00000,null,null,1193.00000,null,null,null,2423.00000,null,1900.00000,90.00000,1984.00000,null,null,936.00000,5811.00000,null,107.00000,208.00000,null,null,null,null,null,2.00000,290.00000,null,null,null,217.00000,null,null,null,null,null,null,1722.00000,null,null,541.00000,null,668.00000,1953.00000,1456.00000,null,null,111.00000,null,2016.00000,1471.00000,null,null,null,701.00000,null,171.00000,null,72.00000,5524.00000,2016.00000,null,null,666.00000,null,null,null,68.00000,null,110.00000,1.00000,null,null,502.00000,null,null,13.00000,null,null,703.00000,null,72.00000,2073.00000,null,null,null,null,null,1016.00000,44.00000,null,null,null,null,null,null,null,581.00000,null,null,null,null,null,null,107.00000,null,null,null,null,49.00000,61.00000,571.00000,1317.00000,null,null,428.00000,null,null,null,null,null,2016.00000,null,63.00000,null,null,null,null,null,646.00000,null,null,null,510.00000,null,null,null,null,null,922.00000,191.00000,null,null,null,null,null,null,null,null,null,1048.00000,null,null,399.00000,96.00000,72.00000,null,399.00000,null,null,null,null,null,null,null,2587.00000,153.00000,96.00000,null,null,null,null,1193.00000,null,null,null,null,null,7.00000,null,null,1019.00000,276.00000,null,49.00000,null,782.00000,null,null,1162.00000,null,1806.00000,null,null,null,null,541.00000,2311.00000,null,90.00000,null,701.00000,null,null,null,null,null,null,208.00000,2073.00000,356.00000,null,null,null,null,20.00000,922.00000,null,null,1471.00000,2016.00000,null,1522.00000,null,null,null,null,null,null,null,null,1464.00000,null,null,636.00000,null,null,null,null,922.00000,null,null,506.00000,null,null,1984.00000,72.00000,782.00000,1872.00000,2.00000,null,34.00000,567.00000,null,2440.00000,null,null,null,null,49.00000,20.00000,1268.00000,1451.00000,null,377.00000,300.00000,null,null,null,1193.00000,1872.00000,null,157.00000,null,1601.00000,null,1806.00000,null,526.00000,null,null,1522.00000,null,null,null,null,null,null,34.00000,null,null,474.00000,571.00000,null,null,null,null,null,null,1660.00000,2947.00000,null,null,2544.00000,null,428.00000,null,922.00000,1647.00000,null,null,null,null,709.00000,null,506.00000,1132.00000,null,72.00000,1669.00000,null,null,null,null,null,null,1806.00000,null,null,null,null,548.00000,null,276.00000,null,2331.00000,null,null,null,null,830.00000,null,null,null,null,null,null,null,405.00000,null,null,null,2426.00000,1385.00000,null,null,2311.00000,null,null,null,null,null,null,null,null,null,61.00000,1722.00000,null,null,null,null,2311.00000,276.00000,null,null,null,1806.00000,null,null,null,null,null,null,null,null,3374.00000,null,null,null,null,1176.00000,null,null,111.00000,null,null,2761.00000,960.00000,null,null,null,null,null,null,null,null,44.00000,5476.00000,1563.00000,null,null,74.00000,null,null,null,null,null,null,null,null,null,null,null,null,2626.00000,81.00000,157.00000,null,1806.00000,null,null,null,null,null,null,null,null,null,null,851.00000,null,null,null,759.00000,180.00000,null,null,null,null,208.00000,null,1068.00000,439.00000,301.00000,null,null,3812.00000,1257.00000,922.00000,null,null,564.00000,null,null,820.00000,631.00000,null,2535.00000,null,null,null,null,null,null,null,2626.00000,null,null,null,null,null,null,178.00000,1248.00000,null,null,null,399.00000,null,null,null,null,1147.00000,null,null,3.00000,null,null,null,1517.00000,null,null,5789.00000,null,1095.00000,null,null,39.00000,null,820.00000,820.00000,null,1806.00000,null,null,null,851.00000,null,830.00000,1630.00000,null,null,1563.00000,40.00000,3003.00000,null,null,746.00000,null,1576.00000,null,null,null,null,null,null,null,null,328.00000,20.00000,934.00000,null,3374.00000,null,null,491.00000,5811.00000,558.00000,null,null,null,null,2272.00000,2587.00000,null,1257.00000,null,56.00000,null,null,null,null,null,null,null,null,1563.00000,1563.00000,null,491.00000,null,null,null,369.00000,null,null,202.00000,null,null,null,null,null,2535.00000,292.00000,null,670.00000,null,null,null,9.00000,1464.00000,null,573.00000,null,null,313.00000,737.00000,1074.00000,571.00000,67.00000,2964.00000,null,2490.00000,null,null,null,2544.00000,null,2090.00000,null,null,376.00000,null,null,null,null,1576.00000,null,1248.00000,3000.00000,2086.00000,null,null,3003.00000,null,null,null,2587.00000,null,null,2761.00000,null,null,4544.00000,null,null,2490.00000,1224.00000,510.00000]
//[null,null,null,null,null,null,null,null,null,86.0,null,null,3.0,45.0,null,null,45.0,null,null,null,45.0,133.0,1.0,null,null,1.0,1.0,133.0,null,74.5,133.0,45.0,null,9.0,null,null,null,null,null,45.0,null,null,null,null,null,3.0,null,1.0,null,null,null,null,null,null,null,null,null,null,null,null,133.0,null,null,null,null,null,null,1016.0,null,552.0,40.0,null,null,null,552.0,null,null,283.0,null,null,null,636.0,1.0,null,74.5,960.0,null,153.0,null,null,null,40.0,null,null,null,null,709.0,null,null,null,null,null,null,1162.0,null,510.0,null,null,null,1.0,null,null,539.0,null,null,null,null,null,null,null,null,960.0,null,null,null,1016.0,null,null,null,null,null,null,null,null,74.5,null,null,null,347.0,null,null,null,null,null,null,null,null,960.0,1016.0,null,null,null,null,null,null,null,null,9.0,636.0,null,null,709.0,null,null,null,636.0,1471.0,null,516.0,null,null,null,1016.0,1.0,null,null,null,null,null,null,null,null,null,null,null,157.0,null,null,null,null,null,153.0,null,null,null,2440.0,null,1522.0,null,null,null,null,586.0,null,null,1385.0,null,960.0,428.0,null,null,null,null,null,null,null,null,1806.0,null,null,null,185.0,586.0,133.0,null,null,936.0,491.0,null,null,null,null,1660.0,1984.0,null,133.0,null,5476.0,null,636.0,null,null,null,5476.0,null,7.0,null,null,2440.0,null,null,1471.0,1601.0,null,null,null,null,40.0,981.0,347.0,null,null,null,1283.0,null,1522.0,1487.0,1078.0,null,null,153.0,283.0,null,133.0,3651.0,null,null,1193.0,2490.0,1806.0,703.0,1.0,null,323.0,null,null,null,636.0,null,null,3.0,null,null,1493.0,null,null,null,null,null,null,null,null,null,null,null,null,936.0,null,2016.0,666.0,null,null,null,153.0,null,325.0,null,290.0,null,290.0,null,null,45.0,null,null,null,null,null,null,null,null,1517.0,null,null,null,null,null,null,290.0,null,2997.0,null,null,null,null,null,null,653.0,null,null,null,null,164.0,null,null,null,1493.0,null,1283.0,552.0,636.0,36.0,null,null,null,2299.0,1487.0,1193.0,null,4842.0,null,157.0,null,null,null,null,null,null,2269.0,null,null,4579.0,null,null,3651.0,null,null,null,null,null,null,1248.0,null,null,null,null,null,null,1000.0,217.0,null,null,null,2272.0,864.0,1317.0,null,null,347.0,null,1385.0,36.0,null,null,null,null,null,null,null,null,null,325.0,null,null,null,null,2016.0,1471.0,9.0,null,null,null,null,1259.0,null,null,1193.0,null,null,null,2423.0,null,1900.0,90.0,1984.0,null,null,936.0,5811.0,null,107.0,208.0,null,null,null,null,null,2.0,290.0,null,null,null,217.0,null,null,null,null,null,null,1722.0,null,null,541.0,null,668.0,1953.0,1456.0,null,null,111.0,null,2016.0,1471.0,null,null,null,701.0,null,171.0,null,72.0,5524.0,2016.0,null,null,666.0,null,null,null,68.0,null,110.0,1.0,null,null,502.0,null,null,13.0,null,null,703.0,null,72.0,2073.0,null,null,null,null,null,1016.0,44.0,null,null,null,null,null,null,null,581.0,null,null,null,null,null,null,107.0,null,null,null,null,49.0,61.0,571.0,1317.0,null,null,428.0,null,null,null,null,null,2016.0,null,63.0,null,null,null,null,null,646.0,null,null,null,510.0,null,null,null,null,null,922.0,191.0,null,null,null,null,null,null,null,null,null,1048.0,null,null,399.0,96.0,72.0,null,399.0,null,null,null,null,null,null,null,2587.0,153.0,96.0,null,null,null,null,1193.0,null,null,null,null,null,7.0,null,null,1019.0,276.0,null,49.0,null,782.0,null,null,1162.0,null,1806.0,null,null,null,null,541.0,2311.0,null,90.0,null,701.0,null,null,null,null,null,null,208.0,2073.0,356.0,null,null,null,null,20.0,922.0,null,null,1471.0,2016.0,null,1522.0,null,null,null,null,null,null,null,null,1464.0,null,null,636.0,null,null,null,null,922.0,null,null,506.0,null,null,1984.0,72.0,782.0,1872.0,2.0,null,34.0,567.0,null,2440.0,null,null,null,null,49.0,20.0,1268.0,1451.0,null,377.0,300.0,null,null,null,1193.0,1872.0,null,157.0,null,1601.0,null,1806.0,null,526.0,null,null,1522.0,null,null,null,null,null,null,34.0,null,null,474.0,571.0,null,null,null,null,null,null,1660.0,2947.0,null,null,2544.0,null,428.0,null,922.0,1647.0,null,null,null,null,709.0,null,506.0,1132.0,null,72.0,1669.0,null,null,null,null,null,null,1806.0,null,null,null,null,548.0,null,276.0,null,2331.0,null,null,null,null,830.0,null,null,null,null,null,null,null,405.0,null,null,null,2426.0,1385.0,null,null,2311.0,null,null,null,null,null,null,null,null,null,61.0,1722.0,null,null,null,null,2311.0,276.0,null,null,null,1806.0,null,null,null,null,null,null,null,null,3374.0,null,null,null,null,1176.0,null,null,111.0,null,null,2761.0,960.0,null,null,null,null,null,null,null,null,44.0,5476.0,1563.0,null,null,74.5,null,null,null,null,null,null,null,null,null,null,null,null,2626.0,81.0,157.0,null,1806.0,null,null,null,null,null,null,null,null,null,null,851.0,null,null,null,759.0,180.0,null,null,null,null,208.0,null,1068.0,439.0,301.0,null,null,3812.0,1257.0,922.0,null,null,564.0,null,null,820.0,631.0,null,2535.0,null,null,null,null,null,null,null,2626.0,null,null,null,null,null,null,178.0,1248.0,null,null,null,399.0,null,null,null,null,1147.0,null,null,3.0,null,null,null,1517.0,null,null,5789.0,null,1095.0,null,null,39.0,null,820.0,820.0,null,1806.0,null,null,null,851.0,null,830.0,1630.0,null,null,1563.0,40.0,3003.0,null,null,746.0,null,1576.0,null,null,null,null,null,null,null,null,328.0,20.0,934.0,null,3374.0,null,null,491.0,5811.0,558.0,null,null,null,null,2272.0,2587.0,null,1257.0,null,56.0,null,null,null,null,null,null,null,null,1563.0,1563.0,null,491.0,null,null,null,369.0,null,null,202.0,null,null,null,null,null,2535.0,292.0,null,670.0,null,null,null,9.0,1464.0,null,573.0,null,null,313.0,737.0,1074.0,571.0,67.0,2964.0,null,2490.0,null,null,null,2544.0,null,2090.0,null,null,376.0,null,null,null,null,1576.0,null,1248.0,3000.0,2086.0,null,null,3003.0,null,null,null,2587.0,null,null,2761.0,null,null,4544.0,null,null,2490.0,1224.0,510.0]
