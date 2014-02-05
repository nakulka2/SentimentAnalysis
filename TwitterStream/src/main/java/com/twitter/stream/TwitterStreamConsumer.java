package com.twitter.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class TwitterStreamConsumer extends Thread {

    private static final String STREAM_URI = "https://stream.twitter.com/1.1/statuses/filter.json";

    public void run(){
    	try{
            System.out.println("Starting Twitter public stream consumer thread.");

            // Enter your consumer key and secret below
            OAuthService service = new ServiceBuilder()
                    .provider(TwitterApi.class)
                    .apiKey("61baDpYdp5IKY6EtQUyg")
                    .apiSecret("JhdUC6jTOCVOSJ1PwAVHZymZIYi0tJ4bg7JjHAiCR0")
                    .build();

            // Set your access token
            Token accessToken = new Token("75761079-2rWA1u2pkO3QUj40ShjUxTBOMNIjlFTvJBs2yP8j0", "twZCAo2vxzeWJR8I70I2bfRuy5U4ZImza8NngCwylr7cB");

            // Let's generate the request
            System.out.println("Connecting to Twitter Public Stream");
            OAuthRequest request = new OAuthRequest(Verb.POST, STREAM_URI);
            request.addHeader("version", "HTTP/1.1");
            request.addHeader("host", "stream.twitter.com");
            request.setConnectionKeepAlive(true);
            request.addHeader("user-agent", "Twitter Stream Reader");
            request.addBodyParameter("track", "java,heroku,twitter"); // Set keywords you'd like to track here
            service.signRequest(accessToken, request);
            Response response = request.send();

            // Create a reader to read Twitter's stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getStream()));
            File file = new File("F:\\sentiment_data\\SuperbowlData.txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            
            String line;
            while ((line = reader.readLine()) != null) {
            	if(line.contains("superbowl")||line.contains("Superbowl")||line.contains("broncos")||line.contains("Broncos")||line.contains("seahawks")||line.contains("Seahawks")){
                System.out.println(line);
                out.write(line);
                out.newLine();
            	}
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }    
    }
}