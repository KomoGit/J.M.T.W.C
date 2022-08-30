import java.util.Scanner;

public class Main {
    private static final Scanner scn = new Scanner(System.in);
    private static final userCLI uCli = new userCLI();
    //TODO: Make a unsafe version determined by arguments, allowing infinite amount of bots.
    public static void main(String[] args) {
        inputURL();
    }
    private static void inputURL(){
        System.out.print("Insert URLs, 5 at max: (TYPE BREAK IF YOU WISH TO STOP ADDING FURTHER URLS)");
        for(int i = 0; i < 5; i++){
            String URL = scn.nextLine();
            if (URL.equalsIgnoreCase("break")) {
                System.out.println("Breaking out of the loop");
                break;
            }
            uCli.set.add(URL + "");
        }
        uCli.prepareCrawler();
    }

}
