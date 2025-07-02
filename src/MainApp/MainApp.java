/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainApp;
import  Controller.SignupController;
import view.signup;

/**
 *
 * @author Acer
 */
public class MainApp {
 
    public static void main(String[] args) {
        // Create the signup view (your JFrame form)
        signup signupform=new signup();
        SignupController controller=new SignupController(signupform);
        controller.open();
    }
}

