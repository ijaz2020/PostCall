package com.hotel.tamilrockers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;


public class SearchTamilRockers {
  private final String USER_AGENT = "Mozilla/5.0";
  public static void main(String[] args) throws IOException {
    System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
    String url = "https://tamilrockers.ws/index.php/forum/115-tamil-new-dvdrips-hdrips-bdrips-movies/page-";
    String[] searchTxt = {"aruvam"};
    int page =117;
    new SearchTamilRockers().searchMovie(url, searchTxt, page);
  }

  void searchMovie(String url, String[] txt, int page) throws IOException {

    for (Iterator<Integer> it = IntStream.range(1, page).boxed().iterator(); it.hasNext(); ) {
      int i = it.next();
      URL obj = new URL(url+i);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();
      // Setting basic post request
      con.setRequestMethod("GET");
      con.setRequestProperty("User-Agent", USER_AGENT);
      con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
      con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

      BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
      searchMovie(url+i, br, txt);
      con.disconnect();
    }
  }

  void searchMovie(String url, BufferedReader br, String[] txt) throws IOException {
    String line;
    while ( (line = br.readLine()) != null){
      if(Arrays.stream(txt).parallel().anyMatch(line::contains)){
        System.out.println(url);
      }
    }
  }
}
