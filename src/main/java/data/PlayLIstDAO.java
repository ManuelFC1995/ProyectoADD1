/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.CancionDAO;
import data.Conection;
import data.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.PlayList;

/**
 *
 * @author manue
 */
public class PlayLIstDAO  {

    Connection con;

    public PlayLIstDAO() {
        this.con =  Conection.GetConnection();
    }

   

    public List<PlayList> SelectPlayList() throws SQLException {
        ArrayList<PlayList> Listas = new ArrayList<>();
   

        if (con != null) {
            Statement st = con.createStatement();
            try (ResultSet rs = st.executeQuery("SELECT id,nombre,descripcion from lista order by id")) {
                while (rs != null && rs.next()) {
                    PlayList PL = new PlayList();
                    int id = rs.getInt(1);
                    String Nombre = rs.getString(2);
                    String Descripcion = rs.getString(3);
                 

                    PL.setId(id);
                    PL.setDescripcion(Descripcion);
                    PL.setNombre(Nombre);
              
               
                   
                      Listas.add(PL);
                }
            } finally {
                st.close();
            }
        }
        return Listas;
    }
    
      public void InsertPlaylist(PlayList Plist) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("INSERT INTO lista(Nombre,Descripcion,ID_usuario)VALUES(?,?,?)");

            ps.setString(1, Plist.getNombre());
            ps.setString(2, Plist.getDescripcion());
            if(Plist.getCreador()!=null){
            ps.setInt(3, Plist.getCreador().getId());
            }else {
                ps.setInt(3,0);
            }
              if(ps.executeUpdate()==0) {
                  throw new SQLException("NO se ha insertado correctamente");
              }
        } finally {
            if (ps != null) {
                ps.close();
            }

        }
    }
      
       public void DeletePlist(int id) throws SQLException {
        Statement st = null;

        try {
            if (con != null) {

                st = con.createStatement();

                st.executeUpdate("DELETE FROM lista WHERE ID=" + id);
            }

        } finally {
            if (con != null) {
                st.close();
            }
        }
    }
       
       
         public void updatePlayListinfo(int id) throws SQLException {
        Statement st = null;
PlayList plist = new PlayList();
        try {
            if (con != null) {

                st = con.createStatement();
                System.out.println("Introduzca nuevo Nombre de la PlayList");
                plist.setNombre(utilities.Utilidades.getString());
                  System.out.println("Introduzca nueva Descripcion de la PlayLIst");
                plist.setDescripcion(utilities.Utilidades.getString());
                  

                st.executeUpdate("UPDATE  lista "
     + "SET " + "Nombre="+plist.getNombre()+","
               + "Descripcion="+plist.getDescripcion()+"WHERE ID="+id);
            }

        } finally {
            if (con != null) {
                st.close();
            }
        }
    }
}
