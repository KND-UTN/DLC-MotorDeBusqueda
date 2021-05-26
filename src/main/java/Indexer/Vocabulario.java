package Indexer;

import jdk.internal.jimage.ImageReaderFactory;

import javax.persistence.IdClass;
import java.util.*;


public class Vocabulario {
    private String palabra; //una palabra del documento
    public int maxTf=0;  //es la mayor cantidad de veces que apareció la palabra en un documento
    private int nr = 1; //longitud de la lista de posteo,que me ayuda a identificar si se trata de una stop

    public Vocabulario(String palabra) {
        this.palabra = palabra;
    }


    public void setMaxTf(int maxTf) {
        this.maxTf = maxTf;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    @Override
    public String toString() {
        return "{maxTf=" + maxTf +
                ", nr=" + nr +
                '}';
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getMaxTf() {
        return maxTf;
    }

    public int getNr() {
        return nr;
    }
}