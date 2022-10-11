import database.databaseController;
import functions.argsHandle;

public class Main {
    //TODO: Make an unsafe version determined by arguments, allowing infinite amount of bots.(Done)
    //TODO: Remove all unnecessary code out of main to their own respective classes.(Done)

    //TODO: Find the reason for crash and fix it. Most likely it is because of :
    // it takes data as url and some don't fit the criteria causing crash
    // we can possibly fix this issue via validateURL method inside our program. Before being crawled, if the url is invalid
    // it will be ignored.
    public static void main(String[] args) {
        if(databaseController.CheckConnection()){
            argsHandle.argumentHandler(args);
        }
    }
}
