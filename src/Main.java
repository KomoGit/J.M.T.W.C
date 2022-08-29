import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static int DEPTH;
    private static final Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        inputURL();
    }
    static void inputURL(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Insert URLs, 5 at max: ");
        for(int i = 0;i<5;i++){
            String URL = scn.nextLine();
            set.add(URL + "");
            if (URL.equals("Break")) {
                System.out.println("Breaking out of the loop");
                userCLI.PrepareCrawler(set);
                break;
            }
        }
    }

}
