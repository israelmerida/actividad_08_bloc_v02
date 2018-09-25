/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.viewLeer;
import models.modelLeer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;
import java.util.logging.Level; 
import javax.swing.JFileChooser;
/**
 *
 * @author LENOVO
 */
public class controllerLeer {
    viewLeer viewleer;
    modelLeer modelleer;
    ActionListener actionlistener;

    public controllerLeer(viewLeer viewleer, modelLeer modelleer) {
        this.actionlistener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == viewleer.jmi_leer)
                    abrir();
                else if(e.getSource() == viewleer.jmi_guardar)
                    guardar();
            }
        };
        this.viewleer = viewleer;
        this.modelleer = modelleer;
        
        this.viewleer.jmi_guardar.addActionListener(actionlistener);
        this.viewleer.jmi_leer.addActionListener(actionlistener);
        initComponents();
    
    }
    
    public void guardar(){
        modelleer.setTexto(viewleer.jta_texto.getText());
        modelleer.writeFile();
    }
    
    public void leer(){
        modelleer.readFile();
        viewleer.jta_texto.setText(modelleer.getTexto());
    }
    
    public void abrir(){
        modelleer.openFile();
        leer();
    }
    private void initComponents(){
        viewleer.setVisible(true);
    }
  }
