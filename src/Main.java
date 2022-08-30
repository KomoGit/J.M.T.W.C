import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    //Making the set below public object might help with index out of range issue I am facing.
    private static final Set<String> set = new HashSet<>();
    private static final Scanner scn = new Scanner(System.in);
    //TODO: Make a unsafe version determined by arguments, allowing infinite amount of bots.
    public static void main(String[] args) {
        inputURL();
        inputDepth();
    }
    static void inputURL(){
        System.out.print("Insert URLs, 5 at max: (TYPE BREAK IF YOU WISH TO STOP ADDING FURTHER URLS)");
        for(int i = 0; i < 5; i++){
            String URL = scn.nextLine();
            if (URL.equals("Break")) {
                System.out.println("Breaking out of the loop");
                userCLI.prepareCrawler(set);
                break;
            }
            set.add(URL + "");
        }
        userCLI.prepareCrawler(set);
    }
    static void inputDepth(){
        System.out.print("Please insert the depth you want bots to visit: ");
        int depth = scn.nextInt();
        userCLI.prepareCrawler(depth);
    }

}
