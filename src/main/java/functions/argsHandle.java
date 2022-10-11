package functions;

import crawler.crawlerSetup;
import database.databaseController;

import java.util.Scanner;

public class argsHandle {
    private static final Scanner scn = new Scanner(System.in);
    private static final crawlerSetup CRAWLER_SETUP = new crawlerSetup();
    private static final databaseController dbCtrl = new databaseController();
    private static int limiterPointer = 5; //This prevents bugs.

    public static void argumentHandler(String[] args){
        if(args.length == 0){
            acceptURL();
        }else{
            System.out.println("Argument count: " + args.length);
            for (String arg : args) {
                switch (arg) {
                    case "--unsafe" -> limiterPointer = 300;
                    case "--flush" -> dbCtrl.FLUSHData();
                    case "--generate" -> dbCtrl.GenerateDatabase();
                    default -> System.out.println("Invalid argument: " + arg + " ignoring.....");
                }
            }
            acceptURL();
        }
    }
    private static void acceptURL(){
        if(limiterPointer > 5){
            System.out.println("Unsafe mode, max url has been increased to 300.");
        }
        else{
            System.out.println("Insert URLs, 5 at max: (TYPE BREAK IF YOU WISH TO STOP ADDING FURTHER URLS)");
        }
        for(int i = 0; i < limiterPointer; i++){
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
