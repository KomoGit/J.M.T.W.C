import functions.Crawler;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userCLI {
    public static void prepareCrawler(Set<String> set){
        String[] arr = new String[set.size()];
        arr = set.toArray(arr);
        for (int i = 0; i <= set.size(); i++){
            //TODO: Here we will validate all the inputs,
            // if an input is invalid we should print out which ones were to user.
            try{
                //Only internal set is being manipulated when .remove is ran.
                if(!validateURL(arr[i])){
                    set.remove(i);
                    arr = set.toArray(arr);
                    System.out.println("Invalid URL detected, removing the URL: " + arr[i]);
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("URLs filtered, beginning process.");
            }
            finally {
                //TODO: Here you need to make sure the Crawler is started and fed valid URL.
            }
        }
    }
    public static void prepareCrawler(int depth){

    }
    //For loop below ensures there are equal amount of bots for each URL provided;
    private static void StartCrawler(String[] URL,int Depth){
        ArrayList<Crawler> bots = new ArrayList<>();
        for(int i = 0; i<=URL.length;i++){
            String readyURL = URL[i];
            bots.add(new Crawler(readyURL,i,Depth));
        }
        //bots.add(new Crawler(userInput,1, Depth)); Adds single bot for testing reasons. Obsolete.
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
