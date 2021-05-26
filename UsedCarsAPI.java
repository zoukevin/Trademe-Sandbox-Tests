import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UsedCarsAPI {

    public static void searchCarsAPI() {
            try {
                //Response:-oauth_token=E9DABF39B10AACBF6950FDA9F812B5ED&oauth_token_secret=15F8B88EF0B9DA08452BFB56FF3CA3C1&oauth_callback_confirmed=true
                //https://secure.tmsandbox.co.nz/Oauth/Authorize?oauth_token=7F9A8D1B979A6F294C0130732F461DBD
                //https://www.website-tm-access.co.nz/trademe-callback?oauth_token=E9DABF39B10AACBF6950FDA9F812B5ED&oauth_verifier=272FF11020B1D53A1B29340F3549EE11
                //Response:-oauth_token=C260BA7E1CAB4F6F7E1A446BC7361C41&oauth_token_secret=F98DBBE66725689A772122B921A4E9BB
                
                /*
                URL url = new URL("https://secure.tmsandbox.co.nz/Oauth/RequestToken?scope=MyTradeMeRead");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                connection.setRequestProperty("Authorization", "OAuth oauth_callback=https%3A%2F%2Fwww.website-tm-access.co.nz%2Ftrademe-callback, oauth_consumer_key=5D1B1F90097AC6440E86E703EE3C83B8, oauth_signature_method=PLAINTEXT, oauth_signature=8E01682D7F8A21554E0BCFBFEA3CB874%26");
                StringBuilder postDataBuilder = new StringBuilder();
                byte[] postData = postDataBuilder.toString().getBytes("UTF-8");

                OutputStream out = connection.getOutputStream();
                out.write(postData);
                out.close();
                connection.connect();
                */
                
                URL url = new URL("https://api.tmsandbox.co.nz/v1/MyTradeMe/Watchlist/All.xml");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                connection.setRequestProperty("Authorization", "OAuth oauth_consumer_key=2D89439ECE4C67E42BBCDABFAB7708A7, oauth_token=361AA76183EC915092011E503E436F0E, oauth_signature_method=PLAINTEXT, oauth_signature=19123F42CDBF84A739BDF61BA63FEF69%26E74C1185BDCB57DA4D012FAE3EA2D22F");
                StringBuilder postDataBuilder = new StringBuilder();
                byte[] postData = postDataBuilder.toString().getBytes("UTF-8");
                
                OutputStream out = connection.getOutputStream();
                out.write(postData);
                out.close();
                connection.connect();
                

                //Consumer key: 2D89439ECE4C67E42BBCDABFAB7708A7                CONSUMER KEY
                //Consumer secret: 19123F42CDBF84A739BDF61BA63FEF69             CONSUMER SECRET
                //oauth_token=30B2577992E2C19C0702BCBF7165B359                  TOKEN
                //oauth_token_secret=0BF9738B44CD99BAC8A4AD198FAE7DCA           TOKEN SECRET
                //oauth_verifier=F02C3412712EBED2DBAFBBE574E334F3               VERIFIER
                //oauth_token=361AA76183EC915092011E503E436F0E                  FINAL TOKEN
                //oauth_token_secret=E74C1185BDCB57DA4D012FAE3EA2D22F           FINAL SECRET

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String output;
        
                StringBuffer response = new StringBuffer();
                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
        
                in.close();
                // printing result from response
                System.out.println("Response:-" + response.toString());
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }