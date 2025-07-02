/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Acer
 */
import DAO.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Signupmodel;
import view.login;
import model.loginmodel;

public class LoginController {

    private final UserDao userDao = new UserDao();
    private final login userView;

    public LoginController(login userView) {
        this.userView = userView;
        userView.addLoginUserListener(new LoginListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String email = userView.getEmailText().getText();
                String password = new String(userView.getPasswordText().getText()); // getPassword() returns char[]
                loginmodel loginRequest = new loginmodel(email, password);

                Signupmodel loginUser = userDao.login(loginRequest);

                if (loginUser == null) {
                    JOptionPane.showMessageDialog(userView, "Invalid Credentials", "Login Failed", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(userView, "Login Successful");
                    // You can decide what to do next, for example:
                    // close the login view, open dashboard etc., 
                    // but here we leave it out as requested
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(userView, "Error during login: " + ex.getMessage());
            }
        }
    }
}

