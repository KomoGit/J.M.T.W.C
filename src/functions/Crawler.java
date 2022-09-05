package functions;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Crawler implements Runnable{
    DatabaseINSERT dbIn = new DatabaseINSERT();
    private final ArrayList<String> DataCollection = new ArrayList<>();

    private static int DEPTH = 3;
    private final int ID;
    private final Thread thread;
    private final String first_url;
    private final ArrayList<String> visitedLinks = new ArrayList<>();

    public Crawler(String url, int id,int depth){
        System.out.println("Crawler initialized");
        first_url = url;
        ID = id;
        DEPTH = depth;
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        startCrawl(1,first_url);
    }

    private void startCrawl(int level,String url){
        if(level <= DEPTH){
            Document doc = request(url);

            if(doc != null){
                for (Element link : doc.select("a[href]")){
                    String next_link = link.absUrl("href");
                    if(!visitedLinks.contains(next_link)){
                        startCrawl(level++,next_link);
                    }
                }
            }
        }
    }

    private Document request(String url){
        try{
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

            if(con.response().statusCode() == 200){
                System.out.println("\n**Bot ID:" + ID + " Received webpage at " + url);
                String title = doc.title();
                System.out.println(title);
                visitedLinks.add(url);
                DataCollection.add(url);
                DataCollection.add(ID + "");
                DataCollection.add(title);
                InsertDatabase();
                return doc;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    public Thread getThread(){
        return thread;
    }
    private void InsertDatabase(){
        if(DataCollection.size() == 3){
            dbIn.INSERTData(DataCollection);
            DataCollection.clear();
        }
    }
}