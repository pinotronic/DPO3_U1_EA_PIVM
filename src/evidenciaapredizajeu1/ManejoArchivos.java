package evidenciaapredizajeu1;

import java.io.*;
import java.security.Principal;
import javax.swing.JFileChooser;
import java.util.Scanner;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ManejoArchivos {

    private JFileChooser accion = null;
    public static String ruta = "";
    private File archivo = null;
    private EvidenciaApredizajeU1 evidenciaApredizajeU1;


    public String LeerArchivo() throws FileNotFoundException {
        String texto = "";
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Texto (.txt)", "txt");
        fileChooser.setFileFilter(filtro);
        
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println(ruta);

            try {

                String temp = "";
                File f = new File(ruta);
                entrada = new Scanner(f);

                while (entrada.hasNext()) {
                    temp = temp + entrada.nextLine() + "\n";

                    System.out.println(temp);
                }
                texto = temp;
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
        }

        return texto;
    }

    public void CrearFicheroNuevo(EvidenciaApredizajeU1 evidenciaapredizajeu1, String SCadena, String nombre) {
        this.evidenciaApredizajeU1 = evidenciaApredizajeU1;

        accion = new JFileChooser();
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("TXT", "txt");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Guardar archivo " + nombre);
        accion.setSelectedFile(new File(nombre));
        if (accion.showSaveDialog(evidenciaApredizajeU1) == JFileChooser.APPROVE_OPTION) {
            ruta = accion.getSelectedFile().toString();
            archivo = new File(ruta);
            String NombreRuta;
            NombreRuta = archivo.getName();

            try {

                if (archivo.exists()) {
                    archivo.delete();
                }
                BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
                FileWriter escribirArchivo = new FileWriter(archivo, true);
                BufferedWriter buffer = new BufferedWriter(escribirArchivo);
                buffer.write(SCadena);
                buffer.newLine();
                buffer.close();
                wr.close();
                escribirArchivo.close();

                this.evidenciaApredizajeU1.abrioArchivo = true;
                this.evidenciaApredizajeU1.creoNuevo = false;
            } catch (Exception ex) {
            }
        }
    }

    public void GuardarFichero(String SCadena, String nombre) {

        System.out.println(ruta);
        archivo = new File(ruta);
        try {

            if (archivo.exists()) {
                archivo.delete();
            }
            BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
            FileWriter escribirArchivo = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(SCadena);
            buffer.newLine();
            buffer.close();
            wr.close();
            escribirArchivo.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void BorrarFichero(Principal principal) {
        this.evidenciaApredizajeU1 = evidenciaApredizajeU1;
        archivo = new File(ruta);
        try {

            if (archivo.exists()) {

                archivo.delete();

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
