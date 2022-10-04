package crawler;

import crawler.Crawler;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class crawlerSetup {

    //TODO: Make the set private and apply get and set.
    public final Set<String> URLSet = new HashSet<>();
    private final ArrayList<String> validURL = new ArrayList<>();
    public void prepareCrawler(){
        ArrayList<String> arr = new ArrayList<>(URLSet);
        var validated = arr.stream().filter(this::validateURL).collect(Collectors.toSet());
        validURL.addAll(validated);

        if(validURL.isEmpty()){
            System.out.println("Warning, no viable URL found");
            throw new IllegalArgumentException();
        }else{
            System.out.println("Ready, number of bots that will be added: " + validURL.size());
            Scanner scn = new Scanner(System.in);
            System.out.println("Insert the depth you wish bot(s) to visit. (MAX 5 DEFAULT 3)");
            try{
                int depth = scn.nextInt();
                StartCrawler(depth);
            }catch (InputMismatchException e){
                System.out.println("Input is invalid / Not a number, setting default.");
                StartCrawler(3);
            }
        }
    }
    public void StartCrawler(int Depth){
        ArrayList<Crawler> bots = new ArrayList<>();
        try{
            for (int i = 0; i <= validURL.size(); i++){
                bots.add(new Crawler(validURL.get(i),i,Depth));
            }
        }
        catch (IndexOutOfBoundsException e){
            return;
        }
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
