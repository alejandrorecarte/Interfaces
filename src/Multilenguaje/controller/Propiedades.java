package Multilenguaje.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propiedades extends Properties{

    public final String ESP = "spanish.properties";
    public final String ENG = "english.properties";
    public final String ITA = "italian.properties";

    public static Properties seleccionarIdioma(String idiomaPath) {

        Properties propiedades = new Properties();
        try (InputStream input = new FileInputStream("src/Multilenguaje/properties/"+idiomaPath)) {
            propiedades.load(input);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return propiedades;
    }
}
