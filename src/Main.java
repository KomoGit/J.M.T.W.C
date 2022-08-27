import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        userGreet();
        Scanner scanner = new Scanner(System.in);
        userCLI.Input(scanner);
    }
    static void userGreet(){
        System.out.println("Please insert url to start scraping process, note - your url should contain http:// or https://");
    }
}
