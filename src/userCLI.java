import functions.Crawler;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userCLI {
    public static void PrepareCrawler(Set<String> set){
        for (int i = 0; i<= set.size(); i++){

        }
    }

    private static void StartCrawler(String userInput,int Depth){
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
