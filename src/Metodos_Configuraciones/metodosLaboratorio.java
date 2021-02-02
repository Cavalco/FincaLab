/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos_Configuraciones;

import Idioma.Propiedades;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class metodosLaboratorio {

    Connection cn;
Propiedades idioma; 
    public metodosLaboratorio(Connection c, String Idioma) {
        cn = c;
        idioma = new Propiedades(Idioma);
    }

   public void insertarBasicos(String sql) {
        try {
            //JOptionPane.showMessageDialog(null, "Entre a insertar");
            System.out.println(sql);
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Insertar\n" + ex);
        }
    }


    public void actualizarBasicos(String sql) {
        try {
            System.out.println(sql);
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            JOptionPane.showMessageDialog(null, "Dato Actualizado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar");
        }
    }

    public void cargarInformacion(DefaultTableModel modelo) {

        try {
            String sql = "SELECT descripcion, OIC, UE, ISO FROM pais where ID_Situacion=1";
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Object[] datos = new Object[4];
                for (int i = 0; i <= 3; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }
            cmd.close();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null,"Excepcion - "+ ex);
        }

    }
public void cargarInformacionPruebaArray(DefaultTableModel modelo, int tamaño, String sql, ArrayList<String> array) {
        try {
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Object[] datos = new Object[tamaño];
                for (int i = 0; i < tamaño; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                array.add(datos[tamaño - 1] + "");
                modelo.addRow(datos);
            }
            cmd.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Excepcion - Error Cargar Prueba Array" + ex);
        }

    }

    public void cargarInformacion2(DefaultTableModel modelo, int tamaño, String sql) {
        try {
            //System.out.println(sql);
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Object[] datos = new Object[tamaño];
                for (int i = 0; i < tamaño; i++) {
                    datos[i] = rs.getString(i + 1);
                   
                }
                modelo.addRow(datos);
            }
            cmd.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Excepcion - Error CargarInfo2" + ex);
        }

    }
    public void cargarInformacion4(DefaultTableModel modelo, int tamaño, String sql) {
        try {
            //System.out.println(sql);
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                String [] datos = new String[10];
                
                for (int i = 0; i < tamaño; i++) {
                    datos[i] = rs.getString(i + 1);
                    if (i==0) {
                        int b,b2;
                        String[] c1= datos[0].split(",");  
      
                         b=Integer.parseInt(c1[0]);
                         b2=Integer.parseInt(c1[1]);   
                         char digit1 = (char) b;
                         char digit2 = (char) b2;
                         datos[0]=digit1+""+digit2; 
                         
                    }
                }
                modelo.addRow(datos);
            }
            cmd.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Excepcion - Error Cargar Info 4" + ex);
        }

    }

    public void cargarInformacion3(DefaultTableModel modelo, int tamaño, String sql) {
        try {
            //System.out.println(sql);
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Object[] datos = new Object[10];
                for (int i = 0; i < tamaño; i++) {

                    datos[i] = rs.getString(i + 1);
                    if (i == 1) {

                        if (datos[1].equals("1")) {
                            datos[1] = true;
                        } else {
                            datos[1] = false;
                        }
                        System.out.println(datos[i]);
                    } else if (i == 2) {
                        if (datos[2].equals("1")) {
                            datos[2] = true;
                        } else {
                            datos[2] = false;
                        }
                    }
                }
                modelo.addRow(datos);
            }
            cmd.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Excepcion - Error Cargar Info 3" + ex);
        }

    }

    public String cargarDatosEditar(String pais) {
        try {
            String sql = "SELECT id, descripcion,OIC,UE,ISO from pais where descripcion='" + pais + "'";
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Object[] datos = new Object[5];
                for (int i = 0; i < 5; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                String a = datos[0] + "," + datos[1] + "," + datos[2] + "," + datos[3] + "," + datos[4];
                return a;
            }
            cmd.close();
        } catch (Exception ex) {

        }
        return null;
    }

 
    public String cargarCombos(String sql) {
        try {
            System.out.println(sql + "\n AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            String a = "";
            while (rs.next()) {
                Object[] datos = new Object[2];
                for (int i = 0; i < 1; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                a += datos[0] + "¬";
            }
            cmd.close();
            return "Seleccione..¬" + a;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error - Cargar Combos \n" + ex);
        }
        return null;
    }
    public String cargarCombos2(String sql) {
        try {
            System.out.println(sql + "\n AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            String a = "";
            while (rs.next()) {
                Object[] datos = new Object[2];
                for (int i = 0; i < 1; i++) {
        datos[i] = rs.getString(i + 1);
                
                }
                a += datos[0] + "¬";
            }
            cmd.close();
            return "Todos¬" + a;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error - Cargar Combos \n" + ex);
        }
        return null;
    }

    public String devuelveIdPais(String pais, String tipo) {
        try {
            String sql = "SELECT id from " + tipo + " where descripcion= '" + pais + "' ";
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            String id = "";
            if (rs.next()) {
                id = rs.getString("ID");
            }
            cmd.close();
            return id;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error - Devolver Id Pais \n" + ex);
        }
        return null;
    }

    public void busquedaBasicos(DefaultTableModel modelo, String sql) {
        try {
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Object[] datos = new Object[4];
                for (int i = 0; i <= 3; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }
            cmd.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en Busqueda Basicos - " + ex);
        }
    }
      
        public String comprobarExistencia(String sql) {
        try {
            //System.out.println(sql);
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Object[] datos = new Object[1];
                for (int i = 0; i < 1; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                String a = datos[0] + "";
                System.out.println("a="+a);
                return a;
            }
            cmd.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error - Comprobar Existencia \n" + ex);
        }
        return null;
    }

    public String devuelveId(String sql) {
        try {
            //String sql = "SELECT id from " + tabla + " where descripcion= '" + valor + "' ";
            //System.out.println(sql);
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            String id = "";
            if (rs.next()) {
                id = rs.getString("ID");
            }
            cmd.close();
            return id;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error - Devolver Id - Metodo \n" + ex);
        }
        return null;
    }

    public String devuelveUnDato(String sql) {
        try {
            System.out.println(sql);
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            String a = "";
            while (rs.next()) {
                Object[] datos = new Object[2];
                for (int i = 0; i < 1; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                a = datos[0] + "";
            }
            System.out.println("a="+a);
            cmd.close();
            return a;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error - Devolver 1 Dato - Metodo \n" + ex);
        }
        return null;
    }
 public String devuelveUnRow(String sql, int tamaño) {
        try {
            System.out.println(sql);
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();
            String a = "";
            while (rs.next()) {
                Object[] datos = new Object[tamaño];
                for (int i = 0; i < tamaño; i++) {
                    datos[i] = rs.getString(i + 1);
                   a=a+ datos[i] + ",";
                }
             
            }
            System.out.println(a);
            cmd.close();
            return a;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error - Devolver 1 row - Metodo \n" + ex);
        }
        return null;
    }
  public void eliminardato(String sql) {
        System.out.println(sql);
      try {
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar");
        }
    }
}
