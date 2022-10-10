package functions;

import crawler.crawlerSetup;
import database.databaseController;

import java.util.Scanner;

public class argsHandle {
    private static final Scanner scn = new Scanner(System.in);
    private static final crawlerSetup CRAWLER_SETUP = new crawlerSetup();
    private static final databaseController dbCtrl = new databaseController();

    /*Issue is that I need the loop to keep going until all arguments have been settled.
    * Question is how do I create the loop?*/
    public static void argumentHandler(String[] args){
        if(args.length == 0){
            acceptURL();
        }else{
            System.out.println("Argument count: " + args.length);
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argument " + i + ": " + args[i]);
                switch (args[i]) {
                    case "--unsafe" -> acceptURL(300);
                    case "--flush" -> dbCtrl.FLUSHData();
                    case "--generate"-> dbCtrl.GenerateDatabase();
                    default -> System.out.println("Invalid argument(s). Proceeding normally.");
                }
            }
            acceptURL();
        }
    }
    private static void acceptURL(){//Safe mode
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
    private static void acceptURL(int limiter){//Unsafe mode.
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
