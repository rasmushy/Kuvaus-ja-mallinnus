package org.laskin;

public class Laskin {
    private double tulos;  	// Muuttuja tulokselle

    public void nollaa() {  // Nollaa tulosmuuttuja
        tulos = 0;
    }

    public double annaTulos() {
        return tulos;
    }

    public void lisaa(double n) {
        tulos = tulos + n;
    }

    public void vahenna(double n) {
        tulos = tulos - n;
    }

    public void kerro(double n) {
        tulos = tulos * n;
    }

    public void jaa(double n) {
        if (n==0)
            throw new ArithmeticException("Nollalla ei voi jakaa");
        else
            tulos = tulos / n;
    }

    public void nelio(double n) {
        tulos = n * n;
    }

    public void neliojuuri(double n) {
        if (n<0)
            throw new IllegalArgumentException("Negatiivisella luvulla ei ole neliöjuurta");
        else
            tulos = Math.sqrt(n);
    }

    public void virtaON() {
        // T�h�n voisi laittaa muutkin alkutoimet
        tulos = 0;
    }

    public void virtaOFF() {
        // T�h�nn voisi laittaa lopputoimet
    }
}


