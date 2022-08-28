import functions.Crawler;
import functions.pingSite;
import jdk.jshell.execution.JdiExecutionControlProvider;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userCLI {
    /*public static void Input(Scanner scn){
        String userInput = scn.nextLine();
        userSentUrl(userInput);
        //int botDepth = scn.nextInt();
        //InputLoop(userInput);
    }*/
    //This piece of code pings the site to check for responsiveness.
    //TODO: Ensure that more than 1 url can be sent through this code.
    /*private static void userSentUrl(String urlInput){
        if(validateURL(urlInput)){
            System.out.println("Pinging site " + urlInput);
            if(!pingSite.pingURL(urlInput,100)){
                System.out.println("Connection timed out.");
            }
            else{
                System.out.println("Connection went through, beginning crawl process.");
                //StartCrawler(urlInput);
            }
        }
        else{
            System.out.println("Error, not a valid url. Try again.");
        }
    }*/
    /*private static void InputLoop(String userInput){
            if(validateURL(userInput)){
                System.out.println("Pinging site " + userInput);
                if(!pingSite.pingURL(userInput,100)){
                    System.out.println("Connection timed out.");
                }
                else{
                    System.out.println("Connection went through, beginning crawl process.");
                    StartCrawler(userInput);
                }
            }
            else{
                System.out.println("Error, not a valid url. Try again.");
            }
    }*/

    public static void StartCrawler(String userInput,int Depth){
        ArrayList<Crawler> bots = new ArrayList<>();
        bots.add(new Crawler(userInput,1, Depth));

        for(Crawler w : bots){
            try {
                w.getThread().join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private static boolean validateURL(String input){
        String urlRegex = "((http://|https://)?(www.)??(.com)??(.org)??(.net)??(.info)??(.az)?(([a-zA-Z0-9-]){2,}\\.){1,4}([a-zA-Z]){2,6}(/([a-zA-Z-_/.0-9#:?=&;,]*)?)?)";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
