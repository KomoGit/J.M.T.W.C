import java.util.Scanner;

public class Main {
    private static int DEPTH;
    private static int BOT_NUM;
    private static String URL;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<4;i++){
            userGreet(i,scanner);
        }
        userCLI.StartCrawler(URL,DEPTH);
    }
    static void userGreet(int index, Scanner uInput){
        switch (index){
            case 1:
                System.out.print("Please insert the number of bots you wish. MAX(5) | DEFAULT 1 ");
                while(BOT_NUM == 0){
                    BOT_NUM = uInput.nextInt();
                    if(BOT_NUM >= 5){
                        System.out.println("Exceeding max amount of BOTS allowed, setting to 5");
                        BOT_NUM = 5;
                    }
                }
                break;
            case 2:
                System.out.print("Please insert the depth of the bot(s), higher the depth more links the bots will crawl. (MAX 5) | DEFAULT 3 ");
                while(DEPTH == 0){
                    DEPTH = uInput.nextInt();
                    if(DEPTH >= 5){
                        System.out.println("Exceeding max amount of depth, setting to 5");
                    }
                }
                break;
            case 3:
                System.out.println("Please insert url(s) to start scraping process, note - your url(s) should contain http:// or https://");
                URL = uInput.nextLine();
                while(URL.isBlank()){
                    URL = uInput.nextLine();
                }
                break;
        }
    }

}
