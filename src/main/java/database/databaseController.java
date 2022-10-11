package database;

import java.sql.*;
import java.util.ArrayList;
/*There is a lot of ROOM to try and implement DRY principles here. Some commands are being repeated multiple times.*/
/*The connection is established multiple times. Best to do it once and use a single connection across the methods.*/
public class databaseController {
    private static final String DBURL = "jdbc:sqlite:Database/SiteIndex";
    public static boolean CheckConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DBURL);
            System.out.println("Connection to database has been established!");
            return true;
        }
        catch (SQLException e){
            System.out.println("Connect to database failed!" + e.getMessage());
            return false;
        }
        finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void INSERTData(ArrayList<String> Collection){
        String sql = "INSERT INTO Sites(Web_Url,Bot_Id,Title) VALUES(?,?,?)";
        try(Connection conn = this.connect();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1,Collection.get(0));
            statement.setString(2,Collection.get(1));
            statement.setString(3,Collection.get(2));
            statement.addBatch();
            statement.executeBatch();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            GenerateDatabase();
        }
    }
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DBURL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    // Argument methods.
    public void FLUSHData(){
        String sql = "DELETE FROM Sites";
        try(Connection conn = this.connect();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.execute();//DRY
            System.out.println("Flushed all data out of the database.");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void GenerateDatabase(){
        System.out.println("Generating Database.");
        String sql = """
                CREATE TABLE Sites(
                Web_Url TEXT,
                Bot_Id INTEGER,
                Title TEXT
                );""";
        try(Connection conn = this.connect()){
            Statement statement = conn.createStatement();{
                statement.execute(sql);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
