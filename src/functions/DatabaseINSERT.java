package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DatabaseINSERT {

    /*public void DatabaseConnection(){
        Connection conn = null;
        try{
            final String DBURL = "jdbc:sqlite:Database/Attorneys";
            conn = DriverManager.getConnection(DBURL);
            System.out.println("Connection to database has been established!");
        }
        catch (SQLException e){
            System.out.println("Connect to database failed!" + e.getMessage());
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
    }*/
    /*public boolean DatabaseConnection(){
        Connection conn = null;
        try{
            String DBURL = "jdbc:sqlite:Database/SiteIndex";
            conn = DriverManager.getConnection(DBURL);
            System.out.println("Connection to database has been established!");
            return true;
        }catch (SQLException e){
            System.out.println("Failed to establish connection to Database! " + e.getMessage());
            return false;
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }*/
    public void INSERTData(String Data,String Bot_id){
        String sql = "INSERT INTO Visited(Site_Url,Bot_Id) VALUES(?,?)";
        try(Connection conn = this.connect();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1,Data);
            statement.setString(2,Bot_id);
            statement.executeBatch();
            statement.addBatch();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private Connection connect(){
        final String DBURL = "jdbc:sqlite:Database/SiteIndex";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DBURL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
