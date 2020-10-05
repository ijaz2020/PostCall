package com.cp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Arpit Mandliya
 */
public class HttpURLConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        // Sending post request
        http.sendingPostRequest();

    }

    // HTTP Post request
    private void sendingPostRequest() throws Exception {

        String url = "http://www.tnpsc.gov.in/ResultDisp-gr_ii_docucall_i_2K18.asp";
        URL obj = new URL(url);

        List<String> list = readFile();
        List<String> result = new ArrayList<>();

        for(String s : list) {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // Setting basic post request
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            String urlParameters = "RN="+s;

            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;


            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(postData);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("nSending 'POST' request to URL : " + url);
            System.out.println("Post Data : " + postData);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();

            //printing result from response
           /* File file =
                    new File("/home/ijaz/Documents/tes.html");
            Scanner sc = new Scanner(file);
            String response = sc.nextLine();*/
            final Pattern pattern = Pattern.compile("Thiru/Tmt/Selvi(.+?)</td>", Pattern.DOTALL);
            final Matcher matcher = pattern.matcher(response);
            matcher.find();
            result.add(s+" " + matcher.group(0));
        }
        writeFile(result);
    }

    private static void writeFile(List<String> list){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("/home/ijaz/code-base/Lynk/rankCalculation.txt"));
            for (String s : list)
                pw.println(s);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> readFile() throws FileNotFoundException {
        File file =
                new File("/home/ijaz/Documents/text.txt");
        Scanner sc = new Scanner(file);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine()) ;
        }
        return list;
    }

}
