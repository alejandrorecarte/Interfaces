package JButtonImagen;

import java.awt.*;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class JButtonImagen extends JButton implements Serializable {

    private String rutaImagen;

    public JButtonImagen() {
        this.setBorder(new LineBorder(Color.RED));
        this.setBackground(Color.RED);
        this.setSize(200,200);
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
