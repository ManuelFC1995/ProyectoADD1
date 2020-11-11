package data;


import data.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cancion;
import modelo.PlayList;

/**
 *
 * @author migue
 */

public class CancionDAO {
    final String INSERT ="INSERT INTO Artista(nombre,nacionalidad,foto)VALUES(?,?,?)";
    final String UPDATE ="UPDATE Artista SET nombre=?,nacionalidad=?,foto=? WHERE id=?";
    final String DELETE ="DELETE FROM Artista WHERE id= ?";
    final String GETALL = "SELECT id,nombre,nacionalidad FROM Artista";
    final String GETONE = "SELECT id,nombre,nacionalidad FROM Artista WHERE id=?";
    final String GETCANCIONESLIST="Select can.nombre from lista as list " +
"left join lista_cancion as lc On lc.ID_lista=list.id" +
"left join canciones as can On lc.ID_Cancion=can.id where list.id=";
    
    
   final private Connection conexion;
    
    public CancionDAO(){
        this.conexion=Conection.GetConnection();
    }


    public void insertar(Cancion c) throws DAOException {
            PreparedStatement stat = null;
            ResultSet rs =null;
            try{
                stat =conexion.prepareStatement(INSERT);
                stat.setString(1,c.getNombre());
                stat.setString(2,c.getDuracion());
                stat.executeUpdate();
                if (stat.executeUpdate()==0){
                    throw new DAOException("Puede que no se haya guardado.");
                }
                rs=stat.getGeneratedKeys();
                if (rs.next()){
                c.setId(rs.getInt(1));
            }else{
                throw new DAOException("No puede asignar ID a esta cancion");    
          }
            } catch (SQLException ex) {
                throw new DAOException("Error en SQL",ex);
        }finally{
                if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
            }
                if(stat != null){
             try{
                 stat.close();
             }catch(SQLException ex){
                 throw new DAOException("Error en SQL", ex);
             }
        }
                
    }
 }


    public void modificar(Cancion c) throws SQLException, DAOException {
        PreparedStatement stat = null;
            ResultSet rs =null;
            try{
                stat =conexion.prepareStatement(UPDATE);
                stat.setString(1,c.getNombre());
                stat.setString(2,c.getDuracion());
                stat.executeUpdate();
                if (stat.executeUpdate()==0){
                    throw new DAOException("Puede que no se haya guardado.");
                }
                
            } catch (SQLException ex) {
                throw new DAOException("Error en SQL",ex);
        }finally{
                if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
            }
                if(stat != null){
             try{
                 stat.close();
             }catch(SQLException ex){
                 throw new DAOException("Error en SQL", ex);
             }
        }
                
    }
 }


    public void eliminar(Cancion c) throws DAOException {
                PreparedStatement stat = null;
            try{
                stat =conexion.prepareStatement(DELETE);
                stat.setInt(1,c.getId());
                if (stat.executeUpdate()==0){
                    throw new DAOException("Puede que no se haya borrado.");
                }
    }catch(SQLException ex){
        throw new DAOException("Error en SQL",ex);
        }finally{
                if(stat != null){
             try{
                 stat.close();
             }catch(SQLException ex){
                 throw new DAOException("Error en SQL", ex);
             }
       }
                    if(stat != null){
             try{
                 stat.close();
             }catch(SQLException ex){
                 throw new DAOException("Error en SQL", ex);
             }
        }
    }
 }

   
     private Cancion convertir (ResultSet rs) throws SQLException{
         String nombre = rs.getString("nombre");
         String duracion = rs.getString("duracion");
         Cancion cancion= new Cancion(nombre,duracion);
         cancion.setId(rs.getInt("id"));
         return cancion;
     }
    public List<Cancion> obtenerTodos(String Query) {
        PreparedStatement stat = null;
        ResultSet rs =null;
        List<Cancion> cancion=new ArrayList<>();
        try{
            stat =conexion.prepareStatement(Query);
            rs=stat.executeQuery();
            while(rs.next()){
                cancion.add(convertir(rs));
            }
        } catch (SQLException ex) {
             try {
                 throw new DAOException("Error SQL",ex);
             } catch (DAOException ex1) {
                 Logger.getLogger(CancionDAO.class.getName()).log(Level.SEVERE, null, ex1);
             }
        }finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
                if(stat!=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
               }
            }
        }
        return cancion;
    }

    public Cancion obtener(int id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs =null;
        Cancion c=null;
        try{
            stat =conexion.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs=stat.executeQuery();
            if(rs.next()){
                c=convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado ese registro.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error SQL",ex);
        }finally{
            if(rs !=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
            }
            if(stat!=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return c;
        
    }
      public List<Cancion> obtenerTodosList(PlayList list) {
        PreparedStatement stat = null;
        ResultSet rs =null;
        List<Cancion> cancion=new ArrayList<>();
        try{
            stat =conexion.prepareStatement(GETCANCIONESLIST+list.getId());
            rs=stat.executeQuery();
            while(rs.next()){
                cancion.add(convertir(rs));
            }
        } catch (SQLException ex) {
             try {
                 throw new DAOException("Error SQL",ex);
             } catch (DAOException ex1) {
                 Logger.getLogger(CancionDAO.class.getName()).log(Level.SEVERE, null, ex1);
             }
        }finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
                if(stat!=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    new DAOException("Error en SQL",ex);
                }
               }
            }
        }
        return cancion;
    }
}
