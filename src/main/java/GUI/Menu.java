/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import utilities.Utilidades;


public class Menu {
    public static void Inicial() {
        int opciones = 0;
        do {

            System.out.println("Bienvenido a AppMusic");
            System.out.println("1. Artistas");
            System.out.println("2.Discos");
            System.out.println("3.Canciones");
            System.out.println("4.Listas");
            System.out.println("5 Usuarios");
            System.out.println("6.Salir");
            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    M_Artistas();
                    break;
                    
                case 2:
                    M_Discos();
                    break;
                case 3:
                    M_Canciones();
                    break;
                case 4:
                    M_Listas();
                    break;
                case 5:
                    M_Users();
                    break;
                case 6:
                    System.out.println("Hasta Pronto");
                    break;
                default:
                    System.err.println("Introduzca una opcion válida");
                    break;
            }
            
        } while (opciones == 6);

    }
    
    
    
     public static void M_Artistas() {
        int opciones = 0;
        do {

            System.out.println("1.Ver Lista de Artistas");
            System.out.println("2.Registrar un Artista");
            System.out.println("3.Actualizar información de un Artista");
            System.out.println("4.Eliminar Artista");
            System.out.println("5.Atras");
          
            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    break;
                    
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
             
                default:
                         System.err.println("Introduzca una opcion válida");
                    break;
            }
            
        } while (opciones == 5);

    }
     
      public static void M_Discos() {
        int opciones = 0;
        do {

            System.out.println("1.Ver Lista de Discos");
            System.out.println("2.Registrar un Disco");
            System.out.println("3.Actualizar un Disco");
            System.out.println("4.Eliminar un Disco");
            System.out.println("5.Atras");
          
            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    break;
                    
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
             
                default:
                         System.err.println("Introduzca una opcion válida");
                    break;
            }
            
        } while (opciones == 5);

    }
      
       public static void M_Canciones() {
        int opciones = 0;
        do {

            System.out.println("1.Ver Lista de Canciones");
            System.out.println("2.Registrar una canción");
            System.out.println("3.Actualizar una canción");
            System.out.println("4.Eliminar una Cancíon");
            System.out.println("5.Atras");
          
            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    break;
                    
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
             
                default:
                         System.err.println("Introduzca una opcion válida");
                    break;
            }
            
        } while (opciones == 5);

    }
       
       
       public static void M_Listas() {
        int opciones = 0;
        do {

            System.out.println("1.Listar PlayList");
            System.out.println("2.Crear PlayList");
            System.out.println("3.Actualizar PlayList");
            System.out.println("4.Eliminar PlayList");
            System.out.println("5.Atras");
          
            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    break;
                    
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
             
                default:
                         System.err.println("Introduzca una opcion válida");
                    break;
            }
            
        } while (opciones == 5);

    }
         public static void M_Users() {
        int opciones = 0;
        do {

            System.out.println("1.Listar Usuarios");
            System.out.println("2.Registrar Usuario");
            System.out.println("3.Editar Usuario");
            System.out.println("4.Eliminar Usuario");
            System.out.println("5.Atras");
          
            opciones = Utilidades.getInt();
            switch(opciones){
                case 1:
                    break;
                    
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
             
                default:
                         System.err.println("Introduzca una opcion válida");
                    break;
            }
            
        } while (opciones == 5);

    }
}
