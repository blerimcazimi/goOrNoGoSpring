package project.Controller.API.Facebook;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FacebookGraph
{

    public String getFacebookIDByAccessToken(String token)
    {

        String graph = null;
        String urlToBeCalled = "https://graph.facebook.com/me?access_token=" + token;

        try
        {

            URL urlObj = new URL(urlToBeCalled);
            URLConnection c = urlObj.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    c.getInputStream()));
            String inputLine;
            StringBuffer b = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
                b.append(inputLine + "\n");
            in.close();
            graph = b.toString();

            //map the string into json..
            JSONObject myResponse = new JSONObject(graph);

            //get fb id from response.
            String facebook_id = myResponse.getString("id");

            return facebook_id;

        } catch (Exception e)
        {

            return "0";

        }

    }

}
