/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import views.viewLeer;
/**
 *
 * @author LENOVO
 */
public class modelLeer {
    viewLeer viewleer;
    private String path;
    private String texto = "";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }    
    
public void openFile(){
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showOpenDialog(viewleer);
        File archivo = jfc.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(" "))){
            
        }
        else
            path = archivo.getAbsolutePath();
    }

public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                        texto = texto + row;
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Archivo no encontrado:" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Error en I/O operación:" + ex.getMessage());
        }
    }

public void writeFile(){
             try{
                File archivo = new File(path);
                FileWriter fileWriter = new FileWriter (archivo,false);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        printWriter.print(texto);
                        printWriter.close();
                        
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Error en I/O operación:" + ex.getMessage());
                }
            }


}
