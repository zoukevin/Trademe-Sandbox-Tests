import java.io.IOException;

import java.io.*;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;


public class UsedCarsAPI {

    public static void searchCarsAPI() {
            try {

                URL url = new URL("https://api.trademe.co.nz/v1/Search/Motors/Used.xml");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("GET");

                connection.setRequestProperty("Authorization", "OAuth oauth_consumer_key=B9D0FC3FBD5D33CE91BFC3E1A855B766, oauth_token=D9C6C6262E682B2293BE295696ABDFB5, oauth_signature_method=PLAINTEXT, oauth_signature=1759A97B2872269EA1753E0CD7C75003%2635522AE8F4F54DEE22CBA6F3DF6DB9CE");
                BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) 
                    System.out.println(inputLine);
                in.close();

                //Consumer key: B9D0FC3FBD5D33CE91BFC3E1A855B766
                //Consumer secret: 1759A97B2872269EA1753E0CD7C75003
                //oauth_token=3CAA732EFB7BF89B3F25A454DCC0C717
                //oauth_token_secret=08EAB07D3857167AA3F1BADC209638C8
                //oauth_verifier=0BF95D20A216F3E4BC1615880869C52E
                //oauth_token=D9C6C6262E682B2293BE295696ABDFB5
                //oauth_token_secret=35522AE8F4F54DEE22CBA6F3DF6DB9CE

                //connection.setRequestProperty("Authorization", "OAuth oauth_consumer_key=B9D0FC3FBD5D33CE91BFC3E1A855B766, oauth_token=D9C6C6262E682B2293BE295696ABDFB5, oauth_signature_method=PLAINTEXT, oauth_signature=35522AE8F4F54DEE22CBA6F3DF6DB9CE%2608EAB07D3857167AA3F1BADC209638C8");
        
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }