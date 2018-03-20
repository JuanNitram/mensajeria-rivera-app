package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class MysqlConnect {
	
        /*---------------------------------- Actualmente se conecta a mariaDB (XAMPP) ---------------------------------- */
    
    public Connection conn;
    private Statement statement;
    public static MysqlConnect db;

    private MysqlConnect() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "db_mensajeria";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
            System.out.println("Connection Succesful!");
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static synchronized MysqlConnect getDbCon() {
        if ( db == null ) {
            db = new MysqlConnect();
        }
        return db;
    }
    
    public static void initialize(){
        if ( db == null ) 
            db = new MysqlConnect();
    }

    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    public int execute(String query) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(query);
        return result;
    }
	
}
