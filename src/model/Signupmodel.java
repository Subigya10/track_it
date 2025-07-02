/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Signupmodel {
    private String FullName;
    private String companyname;
    private String Email;
    private String Role;
    private String Password;
    
    
    //getter
    
    public String getFullName(){
            return FullName;
    }
            
    public void setFullName(String FullName){
    this.FullName=FullName;
    
    
}
    
    public String getCompanyName(){
        return companyname;
    }
    public void setCompanyName(String companyname){
        this.companyname=companyname;
    }
    
    
    
    public String getEmail(){
        return Email;
    }
    public void setEmail(String Email){
        this.Email=Email;
        
    }
    public String getRole(){
        return Role;
    }
    public void  setRole(String Role){
        this.Role=Role;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
       public Signupmodel(String FullName, String companyname, String Email, String Role, String Password) {
        this.FullName = FullName;
        this.companyname = companyname;
        this.Email = Email;
        this.Role = Role;
        this.Password = Password;
    
}
}
    
