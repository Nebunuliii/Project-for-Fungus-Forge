import INTERFACE.src.*;

import javax.swing.*;
import java.io.File;

public class Meniu extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }

        InterfataActiv frameActiva = new InterfataActiv();
        frameActiva.setVisible(true);
        frameActiva.setResizable(false);

        frameActiva.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frameActiva,
                        "Datele introduse si nearhivate se vor pierde!", "Doriti sa inchideti?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    File f = new File("activa.csv");
                    f.delete();
                    System.exit(0);
                }
            }
        });
    }
}