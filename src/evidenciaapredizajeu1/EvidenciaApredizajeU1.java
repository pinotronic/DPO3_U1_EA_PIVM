package evidenciaapredizajeu1;

import java.awt.Color;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;

public class EvidenciaApredizajeU1 extends JFrame implements ActionListener{

    private JPanel Panelmenu;
    private int size_x = 640, size_y = 500;
    JLabel LBLNombreAlumno, LBLMatricula, LBLTitulo;
    JButton BTNCrearArchivo, BTNAbrirArchivo, BTNGuardarArchivo, BTNEliminarArchivo;
    JTextField TextNombreArchivo;
    public boolean abrioArchivo = false;
    public boolean creoNuevo = false;
    
    
    public EvidenciaApredizajeU1() {
                this.setTitle("Cargando Texto");
        this.setSize(size_x, size_y);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

       GUI2();
        
    }

    public static void main(String[] args) {
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        EvidenciaApredizajeU1 ventana = new EvidenciaApredizajeU1();
        ventana.setVisible(true);
         
    }

   
    public void GUI2() {
        Panelmenu = new JPanel();

        LBLTitulo = new JLabel("Manejador de Archivo de Texto. Evidencia de Aprendizaje");
        LBLTitulo.setBounds(130, 10, 400, 20);
        Panelmenu.add(LBLTitulo);

        JTextArea JtextTexto = new JTextArea();
        JtextTexto.setBounds(10, 40, 450, 380);
        Panelmenu.add(JtextTexto);

        LBLNombreAlumno = new JLabel("Pino Martin Vargas Marquez.");
        LBLNombreAlumno.setBounds(150, 440, 180, 20);
        Panelmenu.add(LBLNombreAlumno);

        LBLMatricula = new JLabel("ES172005165");
        LBLMatricula.setBounds(350, 440, 150, 20);
        Panelmenu.add(LBLMatricula);

        TextNombreArchivo = new JTextField("Archivo.txt");
        TextNombreArchivo.setBounds(469, 280, 150, 20);
        Panelmenu.add(TextNombreArchivo);

        JButton BTNCrearArchivo = new JButton("Crear Archivo");
        BTNCrearArchivo.setBounds(470, 40, 150, 50);
        BTNCrearArchivo.addActionListener(this);
        Panelmenu.add(BTNCrearArchivo);

        JButton BTNAbrirArchivo = new JButton("Abrir Archivo");
        BTNAbrirArchivo.setBounds(470, 100, 150, 50);
        BTNAbrirArchivo.addActionListener(this);
        Panelmenu.add(BTNAbrirArchivo);

        JButton BTNGuardarArchivo = new JButton("Guardar Archivo");
        BTNGuardarArchivo.setBounds(470, 160, 150, 50);
        BTNGuardarArchivo.addActionListener(this);
        Panelmenu.add(BTNGuardarArchivo);

        JButton BTNEliminarArchivo = new JButton("Eliminar Archivo");
        BTNEliminarArchivo.setBounds(470, 220, 150, 50);
        //BTNEliminarArchivo.addActionListener(actionPerformed);
        Panelmenu.add(BTNEliminarArchivo);

        Panelmenu.setLayout(null);
        this.getContentPane().add(Panelmenu);
        Panelmenu.setVisible(true);
        Panelmenu.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        

        
        BTNCrearArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ManejoArchivos cargaArchivo = new ManejoArchivos();

                String Texto;
                String Texto2;
                Texto = "Pino Martin Vargas Marquez."+" ES172005165"+"\n";
                JtextTexto.setText("");
                JtextTexto.setText(Texto);
                Texto2 = TextNombreArchivo.getText();
                cargaArchivo.CrearFicheroNuevo(null, Texto, Texto2);
                TextNombreArchivo.setText(ManejoArchivos.ruta);
                JOptionPane.showMessageDialog(Panelmenu, "Se creo Archivo"+ ManejoArchivos.ruta);

            }

            private PopupMenu AbrirArchivo(String dOneDrive__Universidad_Abierta_y_a_Distan) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });
        
               BTNAbrirArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ManejoArchivos cargaArchivo = new ManejoArchivos();

                String Texto;
                try {
                    //Texto = "Pino Martin Vargas Marquez."+" ES172005165"+"\n"+ cargaArchivo.AbrirArchivo("C:\\prueba.txt");
                    Texto = "Pino Martin Vargas Marquez."+" ES172005165"+"\n"+cargaArchivo.LeerArchivo();
                    JtextTexto.setText("");
                    JtextTexto.setText(Texto);
                    TextNombreArchivo.setText(ManejoArchivos.ruta);
                    
                    JOptionPane.showMessageDialog(Panelmenu, "Se abrio Archivo"+ ManejoArchivos.ruta);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(EvidenciaApredizajeU1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            private PopupMenu AbrirArchivo(String dOneDrive__Universidad_Abierta_y_a_Distan) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });
               

        BTNGuardarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ManejoArchivos cargaArchivo = new ManejoArchivos();

                String Texto;
                String Texto2;
                Texto = JtextTexto.getText();
                Texto2 = TextNombreArchivo.getText();
                cargaArchivo.GuardarFichero(Texto, Texto2);
                JOptionPane.showMessageDialog(Panelmenu,"Archivo Guardado o actualizado el Archivo"+ ManejoArchivos.ruta);
            }

            private PopupMenu AbrirArchivo(String dOneDrive__Universidad_Abierta_y_a_Distan) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });              

        
        
        BTNEliminarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ManejoArchivos cargaArchivo = new ManejoArchivos();

                cargaArchivo.BorrarFichero(null);
                JOptionPane.showMessageDialog(Panelmenu,"Archivo Borrado"+ ManejoArchivos.ruta);
            }

            private PopupMenu AbrirArchivo(String dOneDrive__Universidad_Abierta_y_a_Distan) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });        
        
        
        
        
        
        
               
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BTNEliminarArchivo){
            System.out.println("Eliminar");
        }
        if (e.getSource()==BTNGuardarArchivo){
            System.out.println("Guardar ");
        }
        
        if (e.getSource()==BTNAbrirArchivo){
            System.out.println("Abrir Archivo");
        }
        if (e.getSource()==BTNCrearArchivo){
            System.out.println("Crear Archivo");
        }   
        
    }
}