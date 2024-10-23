package com.example.kotomierz;

public class Gene {
    /**
     * klasa reprezentująca pojedyncze geny w genotypie kota
     */
    private String locusName;
    private String allel1;
    private String allel2;

    public Gene(String name, String a1, String a2) {
        locusName = name;
        allel1 = a1;
        allel2 = a2;
    }

    public String getAllel1() {
        /**
         * getter jednego z alleli
         */
        return allel1;
    }

    public String getAllel2() {
        /**
         * getter jednego z alleli
         */
        return allel2;
    }
    //metoda sprawdzająca obecność podanych alleli w genie
    public boolean isItSo(String a1, String a2) {
        /**
         * metoda porównująca podaną parę alleli z allelami bieżącego obiektu
         */
        return (allel1.equals(a1) && allel2.equals(a2) || allel1.equals(a2) && allel2.equals(a1));
    }
}
