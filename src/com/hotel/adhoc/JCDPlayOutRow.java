package com.hotel.adhoc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JCDPlayOutRow {
  String businessAreaGroup;
  String ProductFormatName;
  String routeFrameID;
  String displayUnitID;
  String displayUnitName;
  String frameCode;
  String playerID;
  String playerName;
  String dateRun;
  String hourID;
  String campaignID;
  String campaignName;
  String bookingRef;
  String advertiser;
  String brand;
  String adCopyID;
  String adCopyName;
  String noOfPlays;
  String averageSpotLength;
  String durationSeconds;

  static String[] header =
    {"businessAreaGroup", "ProductFormatName", "routeFrameID", "displayUnitID", "displayUnitName", "frameCode", "playerID", "playerName", "dateRun", "hourID", "campaignID", "campaignName", "bookingRef", "advertiser", "brand", "adCopyID", "adCopyName", "noOfPlays", "averageSpotLength", "durationSeconds"};
}
