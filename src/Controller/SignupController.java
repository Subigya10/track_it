/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Signupmodel;
import view.signup;
import view.login;

/**
 *
 * @author Acer
 */
public class SignupController {
    private final UserDao userdao=new UserDao();
    private final signup userview;
    
    public SignupController(signup userview){
        this.userview=userview;
        
        userview.addAddUserListener(new AddUserListener());
        userview.addLoginListener(new LoginListener());
        
    }
    
    public void open(){
        this.userview.setVisible(true);
    }
    
    public void close(){
        this.userview.dispose();
    }

class AddUserListener implements ActionListener{
    @Override
   public void actionPerformed(ActionEvent e){
       try{
           String fullname=userview.getFullNameText().getText();
           
           String companyname=userview.getCompanyNameText().getText();
           String Email=userview.getEmailText().getText();
           String Role=userview.getRoleText().getText();
           String Password=userview.getPasswordField().getText();
           Signupmodel user=new Signupmodel(fullname,companyname,Email,Role,Password);
           boolean check =userdao.checkUser(user);
           
           if(check){
               JOptionPane.showMessageDialog(userview,"Duplicate user");
           }else{
               userdao.signup(user);
           }
       }catch(Exception ex){
                   System.out.println("Error adding user:"+ex.getMessage());
                   
                   }
       }
           }
       }

class LoginListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        login loginview=new login();
        LoginController login=new LoginController(loginview);
       

        login.open();
    }
}
  