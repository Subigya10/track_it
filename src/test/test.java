/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.*;
/**
 *
 * @author Acer
 */

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author Acer
 */
public class test {
    public static void main(String []args){
        Database db =new MySqlConnection();
        if( db.openConnection()!=null){
            System.out.println("Database Connected Successfully");
        }else{
            System.out.println("failed to connect to database");
        }
        }
    }
    
    
    
