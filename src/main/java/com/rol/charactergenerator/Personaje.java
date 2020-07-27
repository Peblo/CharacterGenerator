/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rol.charactergenerator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tipozico
 */
public class Personaje {
    
    private final String SQL_SELECT = "SELECT * FROM PERSONAJE";
    private final String SQL_SELECT_PERSONAJE = "SELECT * FROM PERSONAJE WHERE CODIGOPERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_TALENTOS = "SELECT * FROM TALENTORACIALAPRENDIDO WHERE PERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_IDIOMAS = "SELECT * FROM IDIOMAAPRENDIDO WHERE PERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_ARMADURAS_ARMAS = "SELECT * FROM ARMADURASARMAS WHERE PERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_RASGO_TRANSFONDO = "SELECT * FROM RASGODETRANSFONDO WHERE PERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_HABILIDADES = "SELECT * FROM HABILIDADES WHERE PERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_UTENSILIOS_HABILIDADES = "SELECT * FROM UTENSILIOSHABILIDADES WHERE PERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_TRANSFONDO = "SELECT * FROM TRANSFONDO WHERE PERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_MONEDAS = "SELECT * FROM MONEDAS WHERE PERSONAJE=";
    private final String SQL_SELECT_PERSONAJE_ENSERES_OBTENIDOS = "SELECT * FROM ENSERESOBTENIDOS WHERE PERSONAJE=";
    
    private PreparedStatement PS;
    private Conexion CN;
    private DefaultTableModel DT;
    private ResultSet RS;
    
    public Personaje() throws InstantiationException, IllegalAccessException{
        PS = null;
        CN = new Conexion();
    }
    
    private DefaultTableModel setTitulos(){
        
        DT = new DefaultTableModel();
        
        DT.addColumn("Nombre");
        DT.addColumn("Jugador");
        DT.addColumn("Fecha");
        DT.addColumn("En Party");
        DT.addColumn("Codigo");
        
        /*
            DT.addColumn("Apellidos");
            DT.addColumn("Clase");
            DT.addColumn("Transfondo");
            DT.addColumn("Edad");
            DT.addColumn("Raza");
            DT.addColumn("Fe");
            DT.addColumn("Altura");
            DT.addColumn("Peso");
            DT.addColumn("Alineamiento");
            DT.addColumn("Pelo");
            DT.addColumn("Ojos");
            DT.addColumn("Sexo");
        */
        
        return DT;
    }
    
    public DefaultTableModel getDatosVerGuardados(){
        try{
            
            setTitulos();
            
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            
            Object[] fila = new Object[5];
            
            while (RS.next()){
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                
                DT.addRow(fila);
            }
        } catch (SQLException e){
            System.out.println("Error al listar los datos :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.close();
        }
        return DT;
    }
    
    public String[] getDatosVerPersonajeDatos(String codigo){
        
        String[] filaDatos = new String[17];
        
        try{
            
            System.out.println(codigo);
            PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE + "'"+ codigo + "'");
            RS = PS.executeQuery();
            
            while (RS.next()){
                filaDatos[0] = RS.getString(1);
                filaDatos[1] = RS.getString(2);
                filaDatos[2] = RS.getString(3);
                filaDatos[3] = RS.getString(4); 
                filaDatos[4] = RS.getString(5);
                filaDatos[5] = RS.getString(6);
                filaDatos[6] = RS.getString(7);
                filaDatos[7] = RS.getString(8);
                filaDatos[8] = RS.getString(9);
                filaDatos[9] = RS.getString(10);
                filaDatos[10] = RS.getString(11);
                filaDatos[11] = RS.getString(12);
                filaDatos[12] = RS.getString(13);
                filaDatos[13] = RS.getString(14);
                filaDatos[14] = RS.getString(15);
                filaDatos[15] = RS.getString(16);
                filaDatos[16] = RS.getString(17);  
            }
        } catch (SQLException e){
            System.out.println("Error al listar los datos :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        return filaDatos;
    }
    //herehere
    public DefaultListModel<String> getDatosVerPersonajeTalentos(String codigo) throws SQLException{
        DefaultListModel <String> filaTalentos = new DefaultListModel();
        
        System.out.println(codigo);
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_TALENTOS + "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while (RS.next()){
                System.out.println(RS.getString(3));
                filaTalentos.addElement(RS.getString(3));
                //System.out.println(filaTalentos.get(0));
            }
        
        } catch (SQLException e){
            System.out.println("Error al listar los datos :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        
        return filaTalentos;
    }
    
    public Boolean[] getDatosVerPersonajeIdiomas(String codigo) throws SQLException{
        Boolean [] filaIdiomas = new Boolean[19];
        
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_IDIOMAS + "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while(RS.next()){
                filaIdiomas[0] = RS.getBoolean(2);
                filaIdiomas[1] = RS.getBoolean(3);
                filaIdiomas[2] = RS.getBoolean(4);
                filaIdiomas[3] = RS.getBoolean(5);
                filaIdiomas[4] = RS.getBoolean(6);
                filaIdiomas[5] = RS.getBoolean(7);
                filaIdiomas[6] = RS.getBoolean(8);
                filaIdiomas[7] = RS.getBoolean(9);
                filaIdiomas[8] = RS.getBoolean(10);
                filaIdiomas[9] = RS.getBoolean(11);
                filaIdiomas[10] = RS.getBoolean(12);
                filaIdiomas[11] = RS.getBoolean(13);
                filaIdiomas[12] = RS.getBoolean(14);
                filaIdiomas[13] = RS.getBoolean(15);
                filaIdiomas[14] = RS.getBoolean(16);
                filaIdiomas[15] = RS.getBoolean(17);
                filaIdiomas[16] = RS.getBoolean(18);
                filaIdiomas[17] = RS.getBoolean(19);
                filaIdiomas[18] = RS.getBoolean(20);
            }
        } catch (SQLException e){
            System.out.println("Error al listar los idiomas :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        
        return filaIdiomas;
    }
    
    public Boolean[] getDatosVerPersonajeArmadurasArmas(String codigo) throws SQLException{
        Boolean [] filaArmadurasArmas = new Boolean[19];
        
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_ARMADURAS_ARMAS+ "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while(RS.next()){
                filaArmadurasArmas[0] = RS.getBoolean(2);
                filaArmadurasArmas[1] = RS.getBoolean(3);
                filaArmadurasArmas[2] = RS.getBoolean(4);
                filaArmadurasArmas[3] = RS.getBoolean(5);
                filaArmadurasArmas[4] = RS.getBoolean(6);
                filaArmadurasArmas[5] = RS.getBoolean(7);
                filaArmadurasArmas[6] = RS.getBoolean(8);
            }
        } catch (SQLException e){
            System.out.println("Error al listar las armaduras y armas :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        
        return filaArmadurasArmas;
    }
    
    public String getDatosVerPersonajeRasgoTransfondo(String codigo) throws SQLException{
        String RasgoTransfondo = null;
        
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_RASGO_TRANSFONDO+ "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while(RS.next()){
                RasgoTransfondo = RS.getString(2);
            }
        } catch (SQLException e){
            System.out.println("Error al listar el Rasgo de Transfondo :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        
        return RasgoTransfondo;
    }
    
    public int[] getDatosVerPersonajeHabilidades(String codigo) throws SQLException{
        int [] Habilidades = new int[19];
        
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_HABILIDADES + "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while(RS.next()){
                Habilidades[0] = RS.getInt(2);
                Habilidades[1] = RS.getInt(3);
                Habilidades[2] = RS.getInt(4);
                Habilidades[3] = RS.getInt(5);
                Habilidades[4] = RS.getInt(6);
                Habilidades[5] = RS.getInt(7);
                Habilidades[6] = RS.getInt(8);
                Habilidades[7] = RS.getInt(9);
                Habilidades[8] = RS.getInt(10);
                Habilidades[9] = RS.getInt(11);
                Habilidades[10] = RS.getInt(12);
                Habilidades[11] = RS.getInt(13);
                Habilidades[12] = RS.getInt(14);
                Habilidades[13] = RS.getInt(15);
                Habilidades[14] = RS.getInt(16);
                Habilidades[15] = RS.getInt(17);
                Habilidades[16] = RS.getInt(18);
                Habilidades[17] = RS.getInt(19);
                Habilidades[18] = RS.getInt(20);
            }
        } catch (SQLException e){
            System.out.println("Error al listar las habilidades :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        
        return Habilidades;
    }
    
    public String[] getDatosVerPersonajeUtensiliosH(String codigo) throws SQLException{
        String [] UtensiliosHabilidades = new String[19];
        
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_UTENSILIOS_HABILIDADES + "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while(RS.next()){
                UtensiliosHabilidades[0] = RS.getString(2);
                UtensiliosHabilidades[1] = RS.getString(3);
                UtensiliosHabilidades[2] = RS.getString(4);
                UtensiliosHabilidades[3] = RS.getString(5);
                UtensiliosHabilidades[4] = RS.getString(6);
                UtensiliosHabilidades[5] = RS.getString(7);
                UtensiliosHabilidades[6] = RS.getString(8);
                UtensiliosHabilidades[7] = RS.getString(9);
                UtensiliosHabilidades[8] = RS.getString(10);
                UtensiliosHabilidades[9] = RS.getString(11);
                UtensiliosHabilidades[10] = RS.getString(12);
                UtensiliosHabilidades[11] = RS.getString(13);
                UtensiliosHabilidades[12] = RS.getString(14);
                UtensiliosHabilidades[13] = RS.getString(15);
                UtensiliosHabilidades[14] = RS.getString(16);
                UtensiliosHabilidades[15] = RS.getString(17);
                UtensiliosHabilidades[16] = RS.getString(18);
                UtensiliosHabilidades[17] = RS.getString(19);
            }
        } catch (SQLException e){
            System.out.println("Error al listar los utensilios de las habilidades :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        return UtensiliosHabilidades;
    }
    
    public String[] getDatosVerPersonajeTransfondo(String codigo) throws SQLException{
        String [] Transfondo = new String[4];
        
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_TRANSFONDO + "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while(RS.next()){
                Transfondo[0] = RS.getString(2);
                Transfondo[1] = RS.getString(3);
                Transfondo[2] = RS.getString(4);
                Transfondo[3] = RS.getString(5);
            }
        } catch (SQLException e){
            System.out.println("Error al listar los transfondos :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        return Transfondo;
    }
    
    public int[] getDatosVerPersonajeMonedas(String codigo) throws SQLException{
        int [] Monedas = new int[5];
        
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_MONEDAS + "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while(RS.next()){
                Monedas [0] = RS.getInt(2);
                Monedas [1] = RS.getInt(3);
                Monedas [2] = RS.getInt(4);
                Monedas [3] = RS.getInt(5);
                Monedas [4] = RS.getInt(6);
            }
        } catch (SQLException e){
            System.out.println("Error al listar las monedas :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.close();
        }
        return Monedas;
    }
    
    //herehere
    public DefaultListModel <Enser> getDatosVerPersonajeEnseres(String codigo) throws SQLException{
        DefaultListModel <Enser> Enseres = new DefaultListModel();
        Enser EnserAuxiliar = new Enser();
        
        PS = CN.getConnection().prepareStatement(SQL_SELECT_PERSONAJE_ENSERES_OBTENIDOS + "'"+ codigo + "'");
        RS = PS.executeQuery();
        
        try{
            while (RS.next()){
                System.out.println(RS.getString(3));
                EnserAuxiliar 
                Enseres.addElement(RS.get);
                //System.out.println(filaTalentos.get(0));
            }
        
        } catch (SQLException e){
            System.out.println("Error al listar los datos :"+ e.getMessage());
        } finally {
            PS = null;
            RS = null;
            //CN.close();
        }
        
        return Enseres;
    }
}