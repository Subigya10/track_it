/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Signupmodel;
import model.loginmodel;
/**
 *
 * @author Acer
 */
public class UserDao {
    MySqlConnection mysql=new MySqlConnection();
    
    public void  signup(Signupmodel user){
        Connection conn=mysql.openConnection();
        
        String sql ="INSERT INTO users(FullName,companyname,Email,Role,Password) VALUES(?,?,?,?,?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,user.getFullName());
            pst.setString(2,user.getCompanyName()); 
            pst.setString(3,user.getEmail());
            pst.setString(4,user.getRole());
            pst.setString(5,user.getPassword());
            pst.executeUpdate();
            
        }catch(SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            mysql.closeConnection(conn);
        }
    }
    


public boolean  checkUser(Signupmodel user){
  Connection conn=mysql.openConnection();

String sql="SELECT* FROM users where Email =? or FullName =? or companyname=? or Role=? ";
try(PreparedStatement pst=conn.prepareStatement(sql)){
pst.setString(1, user.getEmail());
pst.setString(2,user.getCompanyName());
pst.setString(3,user.getFullName());
pst.setString(4,user.getRole());
ResultSet result=pst.executeQuery();
return result.next();
}catch (SQLException ex){
Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
}finally{
mysql.closeConnection(conn);
}
return false;
}

public  Signupmodel login(loginmodel login){
    Connection conn =mysql.openConnection();
    String sql ="SELECT * FROM users where Email=? and Password =?";
    try(PreparedStatement pst = conn.prepareStatement(sql)){
        pst.setString(1,login.getEmail());
        pst.setString(2,login.getPassword());
        ResultSet result=pst.executeQuery();
        
        if(result.next()){
            Signupmodel user =new Signupmodel(
         result.getString("FullName"),
        result.getString("companyname"),
        result.getString("Email"),
        result.getString("Role"),
        result.getString("Password")
            );
        return user;
    }
}catch(SQLException ex){
    System.out.println(ex);
}finally{
    mysql.closeConnection(conn);
}
return null;
    }
}





