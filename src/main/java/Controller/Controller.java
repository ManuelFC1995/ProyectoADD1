/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import data.CancionDAO;
import data.DAOException;
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
    public void ActualizarAristaInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void EliminaArtista() {
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
    public void ActualizarDiscoInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void EliminarDisco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ListarCanciones() {
       CancionDAO cdao = new CancionDAO();
      ArrayList<Cancion> canciones= (ArrayList<Cancion>) cdao.obtenerTodos();
      for (Cancion c :canciones){
          System.out.println(c);
      }
    }
    
    public void EliminarCancionLIsta() throws SQLException{
         CancionDAO cdao = new CancionDAO();
       int idLista=utilities.Utilidades.getInt("introduzca el id de la lista");
       int idcancion=utilities.Utilidades.getInt("introduzca el id de la cancion");
       cdao.DeleteCancionPlist(idcancion, idLista);
    }

    @Override
    public void CrearCanciones() {
          CancionDAO cdao = new CancionDAO();
        try {
            cdao.InsertCancion();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ActualizarCancion() {
        Cancion c = new Cancion();
        c.setId(utilities.Utilidades.getInt("Que Cancion desea modificar? introduzca su id"));
        c.setNombre(utilities.Utilidades.getString("nuevo nombre"));
        c.setDuracion(utilities.Utilidades.getString("nueva duracion"));
          CancionDAO cdao = new CancionDAO();
        try {
            cdao.modificar(c);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void EliminarCancion() {
        ListarCanciones();
       int id=utilities.Utilidades.getInt("Introduzca el id de la cancion");
        CancionDAO cdao = new CancionDAO();
        try {
            cdao.eliminar(id);
        } catch (DAOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
    
        try {
            pdao.InsertPlaylist();
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
    public void AñadirCancionPlayLIst() {
       CancionDAO cdao = new CancionDAO();
    
        try {
            cdao.InsertCancionLista();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void ListarPlaylistUser(int id) throws SQLException{
        PlayLIstDAO pdao = new PlayLIstDAO();
        ArrayList<PlayList> listas =(ArrayList<PlayList>) pdao.SelectPlayListUsuario(id);
        for(PlayList p:listas){
            System.out.println(p);
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

   
   public void ListarCancionesPL(int id) throws SQLException{
       CancionDAO cdao = new CancionDAO();
      
      ArrayList<Cancion> cn= (ArrayList<Cancion>) cdao.SelectCancioLista(id);
       for (Cancion c :cn){
           System.out.println(cn);
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

  public void ListarPlayListUsuario(int id) throws SQLException{
     PlayLIstDAO pdao = new PlayLIstDAO();
      ArrayList <PlayList> listas =(ArrayList <PlayList>) pdao.SelectPlayListUsuario(id);
     for (PlayList p : listas){
         System.out.println(p);
     }
      
  }

    @Override
    public void ListarCancionesDisco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
