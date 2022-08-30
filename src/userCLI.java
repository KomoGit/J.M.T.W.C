import functions.Crawler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class userCLI {

    //TODO: Make the set private and apply get and set.
    public final Set<String> set = new HashSet<>();
    private final Set<String> validURL = new HashSet<>();
    public void prepareCrawler(){
        //String[] arr = new String[set.size()];
        ArrayList<String> arr = new ArrayList<String>(set.size());
        for (int i = 0; i <= set.size(); i++){
            //TODO:Here we will validate all the inputs (COMPLETED)
            // if an input is invalid we should print out which ones were to the user (COMPLETED)
            var validated = arr.stream().filter(this::validateURL).collect(Collectors.toSet());
            if(validated.isEmpty()){
                System.out.println("Warning, no viable URL found");
                throw new IllegalArgumentException();
            }else{
                ArrayList<Crawler> bots = new ArrayList<>();
                for (String url :validated) {
                    //StartCrawler(bots);
                }
            }
            /*try{
                if(!validateURL(arr[i])){
                    System.out.println("Invalid URL detected, removing the URL: " + arr[i]);
                }
                else{
                    arr.add();
                    //validURL.add(arr[i]);
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("URLs filtered. Total viable url(s): " + arr.length);
                if(validURL.size() == 0){//(arr.length == 0){
                    System.out.println("All URLs are invalid, try the process again.");
                    return;
                }
            }
            finally {
                //TODO: Here you need to make sure the Crawler is started and fed valid URL.
                System.out.println("bla bla bla");
            }*/
        }
    }
    /*private void setToArrayList(){
        for (int i = 0;i<= set.size();i++){
            arr.add(i)
        }
    }*/
    public static void prepareCrawler(int depth){

    }
    //For loop below ensures there are equal amount of bots for each URL provided;
    private static void StartCrawler(ArrayList<Crawler> bots, int Depth){
        //ArrayList<Crawler> bots = new ArrayList<>();
        /*for(int i = 0; i<=URL.length;i++){
            String readyURL = URL[i];
            bots.add(new Crawler(readyURL,i,Depth));
        }*/
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
    private boolean validateURL(String input){
        String urlRegex = "((http://|https://)?(www.)??(.com)??(.org)??(.net)??(.info)??(.az)?(([a-zA-Z0-9-]){2,}\\.){1,4}([a-zA-Z]){2,6}(/([a-zA-Z-_/.0-9#:?=&;,]*)?)?)";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
