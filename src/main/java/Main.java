import functions.databaseController;

import java.util.Scanner;

public class Main {
    private static final databaseController dbCtrl = new databaseController();

    //TODO: Make a unsafe version determined by arguments, allowing infinite amount of bots.(Done)
    //TODO: Remove all unnecessary code out of main to their own respective classes.(Done)
    public static void main(String[] args) {
        if(dbCtrl.CheckConnection()){
            if(args.length == 0){
                argsHandle.argumentHandler(args);
            }
            else{
                argsHandle.argumentHandler(args);
            }
        }
    }
}
