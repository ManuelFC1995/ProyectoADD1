package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author migue
 */
public class ManagerDAO {
    private Connection conexion;
    
    private ArtistaDAO artista=null;
   
    
    public ManagerDAO(String host,String username,String password,String database)throws SQLException{
        conexion=DriverManager.getConnection("jdbc:mysql://"+host+"/"+database, username, password);
    }

    public ArtistaDAO getArtistaDAO() {
        if(artista==null){
            artista=new ArtistaDAO(conexion) {};
        }
        return artista;
    }

    
}
