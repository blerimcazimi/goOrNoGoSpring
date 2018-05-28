package project.Controller.API.Facebook;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FacebookGraph
{

    //AOP
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * 
     * @param token
     * @return
     */
    public String getFacebookIDByAccessToken(String token)
    {

        String graph = null;
        String urlToBeCalled = "https://graph.facebook.com/me?access_token=" + token;

        log.info("Getting facebook id by accesstoken...");

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

            log.info("Successfully retrieved the fb id, " + facebook_id);

            return facebook_id;

        } catch (Exception e)
        {

            log.info("Error trying to get facebook-id " + e.getMessage());

            return "0";

        }

    }

}
