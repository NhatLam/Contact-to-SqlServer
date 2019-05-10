package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import java.sql.Connection;
import android.util.Log;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
    String ip = "192.168.0.100";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "Company";
    String user = "sa";
    String password = "123456";

    @SuppressLint("NewApi")
    public Connection Connect() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + user + ";password="
                    + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }

}
