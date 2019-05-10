package com.example.myapplication;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataEmployee {
    Server server = new Server();
    String z = "";
    ResultSet rs;
    Connection con = server.Connect();
    ArrayList<Employee> list = new ArrayList();
    //QUERY BACSIC
    public ArrayList<Employee> getList() {
        try {
            Statement statement = con.createStatement();
            String sql = "select * from Employee";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Employee(rs.getString("ID"), rs.getString("Name"), rs.getString("Phone")));
            }
        } catch (Exception ex) {
            z = "Exceptions";
        }
        return list;
    }

    public void Delete(String id) {
        try {
            Statement statement = con.createStatement();
            String sql = "DELETE FROM Employee WHERE ID = "+id;
            rs = statement.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Insert(Employee employee) {
        try {
            Statement statement = con.createStatement();
            String sql = "insert into Employee(ID,Name,Phone) values("+employee.getId()+", '"+employee.getName()+"',"+employee.getPhone()+");";
            rs = statement.executeQuery(sql);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Update(Employee employee) {
        try {
            Statement statement = con.createStatement();
            String sql = "UPDATE Employee set Name='"+employee.getName()+"' ,Phone="+employee.getPhone()+"where ID="+employee.getId() ;
            rs = statement.executeQuery(sql);


        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // PRODUCEEEEEEE
//        public ArrayList<Employee> getList() {
//        try {
//            PreparedStatement statement = con.prepareStatement("EXEC SelectAll");
//            rs = statement.executeQuery();
//            while (rs.next()) {
//                list.add(new Employee(rs.getString("ID"), rs.getString("Name"), rs.getString("Phone")));
//            }
//        } catch (Exception ex) {
//            z = "Exceptions";
//        }
//        return list;
//    }
//
//
//
//        public void Delete(String id) {
//        try {
//            PreparedStatement statement = con.prepareStatement("EXEC Delete_Employee '"+id+"'");
//            rs = statement.executeQuery();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    public void Insert(Employee employee) {
//        try {
//            PreparedStatement statement = con.prepareStatement("EXEC Insert_Employee '"+employee.getId()+"','"+
//                    employee.getName()+"','"+employee.getPhone()+"'");
//            rs = statement.executeQuery();
//
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    public void Update(Employee employee) {
//        try {
//            PreparedStatement statement = con.prepareStatement("EXEC Update_Employee '"+employee.getId()+"','"+
//                    employee.getName()+"','"+employee.getPhone()+"'");
//            rs = statement.executeQuery();
//
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
