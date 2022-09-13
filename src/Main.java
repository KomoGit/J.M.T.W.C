import functions.DatabaseINSERT;

import java.util.Scanner;

public class Main {
    private static final Scanner scn = new Scanner(System.in);
    private static final crawlerSetup CRAWLER_SETUP = new crawlerSetup();
    private static final DatabaseINSERT dbIn = new DatabaseINSERT();

    //TODO: Make a unsafe version determined by arguments, allowing infinite amount of bots.
    public static void main(String[] args) {
        if(dbIn.CheckConnection()){
            if(args.length == 0){
                acceptURL();
            }
            else{
                argumentHandler(args);
            }
        }
    }
    private static void argumentHandler(String[] args){
        for(String arg : args){
            switch (arg) {
                case "--unsafe" -> acceptURL(300);
                case "--flush" -> {
                    dbIn.FLUSHData();
                    System.out.println("Flushed all data from database.");
                    acceptURL();
                }
                default -> {
                    System.out.println("Invalid argument. Proceeding normally.");
                    acceptURL();
                }
            }
        }
    }
    private static void acceptURL(){
        System.out.print("Insert URLs, 5 at max: (TYPE BREAK IF YOU WISH TO STOP ADDING FURTHER URLS)");
        //TODO: Remove repeated code out to it's own method.
        for(int i = 0; i < 5; i++){
            String URL = scn.nextLine();
            if (URL.equalsIgnoreCase("break")) {
                System.out.println("Breaking out of the loop");
                break;
            }
            if(URL.contains("https://")){
                CRAWLER_SETUP.URLSet.add(URL);
            }
            else{
                CRAWLER_SETUP.URLSet.add("https://" + URL);
            }
        }
        CRAWLER_SETUP.prepareCrawler();
    }
    private static void acceptURL(int limiter){
        System.out.print("Unsafe mode, max url has been increased to 300.");
        //TODO: Remove repeated code out to it's own method.
        for(int i = 0; i < limiter; i++){
            String URL = scn.nextLine();
            if (URL.equalsIgnoreCase("break")) {
                System.out.println("Breaking out of the loop");
                break;
            }
            if(URL.contains("https://")){
                CRAWLER_SETUP.URLSet.add(URL);
            }
            else{
                CRAWLER_SETUP.URLSet.add("https://" + URL);
            }
        }
        CRAWLER_SETUP.prepareCrawler();
    }
}
