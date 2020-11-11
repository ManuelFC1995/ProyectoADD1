/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import data.PlayLIstDAO;
import data.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Artista;
import modelo.Cancion;
import modelo.Disco;
import modelo.PlayList;
import modelo.Usuario;

/**
 *
 * @author manue
 */
public class Controller implements IController {

    @Override
    public void ListarArtistas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CrearArtista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ActualizarAristaInfo(Artista artista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ActualizarArtistaAñadeDisco(Artista artista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminaArtista(Artista artista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ListarDiscos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CrearDiscos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ActualizarDiscoInfo(Disco disco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AñadirCancionAdisco(Disco disco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarDisco(Disco disco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ListarCanciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CrearCanciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ActualizarCancion(Cancion Cancion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarCancion(Cancion cancion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ListarPlayList() {
       PlayLIstDAO pldao = new PlayLIstDAO();
       ArrayList<PlayList> listas = new ArrayList<>();
        try {
            listas = (ArrayList<PlayList>) pldao.SelectPlayList();
            for(PlayList p : listas){
                System.out.println(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void CrearPlayList() {
       PlayLIstDAO pdao=new PlayLIstDAO();
       UsuarioDAO udao = new UsuarioDAO();
    PlayList p = new PlayList();
       
         System.out.println("Introduzca  Nombre de la PlayLIst");
              p.setNombre(utilities.Utilidades.getString());
                  System.out.println("Introduzca Descripcion");
             p.setDescripcion(utilities.Utilidades.getString());
             
      Usuario u = new Usuario();
     
      p.setCreador(u);
      
        try {
            pdao.InsertPlaylist(p);
            udao.InsertUser(u);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    @Override
    public void ActualizarPlayLIst( ) {
        System.out.println("introduzca id de la lista");
        int id=utilities.Utilidades.getInt();
       PlayLIstDAO pldao= new PlayLIstDAO();
        try {
            pldao.updatePlayListinfo(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void AñadirCancionPlayLIst(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarPlayList() {
        
        System.out.println("introduzca la id de la PlayList");
        int id=utilities.Utilidades.getInt();
    PlayLIstDAO pdao=new PlayLIstDAO();
        try {
            pdao.DeletePlist(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void ListarUsers() {
         UsuarioDAO UsuarioDao= new UsuarioDAO();
        
        try {
            for (Usuario u: UsuarioDao.SelectUsuarios(UsuarioDao.SELECTall)){
                System.out.println(u);
            }       } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void CrearUsuario() {
        Usuario user = new Usuario();
         UsuarioDAO UsuarioDao= new UsuarioDAO();
         System.out.println("Introduzca nuevo correo del usuario");
                user.setCorreo(utilities.Utilidades.getString());
                  System.out.println("Introduzca nuevo nombre de usuario");
                user.setNombre(utilities.Utilidades.getString());
                      System.out.println("Introduzca nuevo foto del usuario");
                user.setFoto(utilities.Utilidades.getString());
                ArrayList<PlayList> misListas =null;
               user.setMisListas(misListas);
        try {
            UsuarioDao.InsertUser(user);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
               
               
                
    }

   
   

   

    public void EliminarUsuario() {
       UsuarioDAO UsuarioDao= new UsuarioDAO();
         System.out.println("introduzca la id del usuario");
        int id=utilities.Utilidades.getInt();
    
        try {
         
            UsuarioDao.DeleteUser(id);
            System.out.println("Usuario  Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ActualizarUsuarioInfo() {
        UsuarioDAO UsuarioDao= new UsuarioDAO();
        System.out.println("introduzca el id");
       int id=utilities.Utilidades.getInt();
     
        try {
            UsuarioDao.updateUserInfo(id);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
    }

  
    
}
