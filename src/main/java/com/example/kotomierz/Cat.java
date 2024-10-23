package com.example.kotomierz;

import java.util.*;

public class Cat {
    /**
     * klasa reprezentująca koty z pokolenia rodziców
     */
    private String phenotype;
    private boolean sex;
    private List<Gene> genotype;
    public static Cat mother = new Cat(false);
    public static Cat father = new Cat(true);

    public Cat(boolean sex) {
        /**
         * konstruktor predefiniujący domyślny genotyp kota
         */
        sex = sex;
        this.genotype = new ArrayList<>(Arrays.asList(
                new Gene("b", "dom1", "rec1"),
                new Gene("d", "dom1", "rec1"),
                new Gene("o", "dom1", "rec1"),
                new Gene("mc", "dom1", "rec1"),
                new Gene("ta", "dom1", "rec1"),
                new Gene("a", "dom1", "rec1"),
                new Gene("c", "dom1", "rec1"),
                new Gene("l", "dom1", "dom1"),
                new Gene("s", "dom1", "rec1"),
                new Gene("w", "dom1", "rec1")
        ));
        this.phenotype="";
    }

    public String getPhenotype() {
        /**
         * ta metoda zwraca tylko wygenerowany wcześniej fenotyp
         */
        return this.phenotype;
    }

    public List<Gene> getGenotype() { return this.genotype; }

    public Gene getGene(int ind) {
        /**
         * getter konkretnego genu z genotypu wskazany indeksem
         */
        return genotype.get(ind); }

    public void setSex(boolean sex) {
        /**
         * metoda zmieniająca płeć
         */
        sex = sex;
    }

    public void setGene(int ind, Gene gene) {
        /**
         * metoda ustawiająca dany gen na danym miejscu
         */
        if (ind < genotype.size())
            genotype.set(ind, gene);
    }

    public void setPhenotype() {
        /**
         * setter tłumaczący genotyp na fenotyp
         */
        String A = "dom1";
        String a = "rec1";
        String a2 = "rec1";
        String phenotype = "";

        //wykluczenie albinosa (locus C)
        if (wA(6, 1, a, this) && wA(6, 2, a, this)){
            phenotype += "albinos(ka), ";
        }
        //wykluczenie białego (locus W)
        else if (wA(9, 1, A, this) || wA(9, 1, A, this)) {
            phenotype += "biały/a, ";
        }
        //wykluczenie szylkretki
        else if ((sex == false
                && wA(2, 1, A, this) || wA(2, 2, A, this) )
                && (wA(0, 1, A, this) || wA(0, 2, A, this))) {
            phenotype += "szylkretowa";
        }
        else {
            //brak rozjasnienia (locus D)
            if (wA(1, 1, A, this) && wA(1, 2, A, this)) {
                //rudy? nie
                if (wA(2, 1, a, this) && wA(2, 2, a, this)) {
                    if (wA(0, 1, A, this) || wA(0, 2, A, this)) {
                        phenotype += "czarny/a, ";
                    } else if (wA(0, 1, a, this) && wA(0, 2, a, this)) {
                        phenotype += "czekoladowy/a, ";
                    } else if (wA(0, 1, a2, this) && wA(0, 2, a2, this)) {
                        phenotype += "cynamonowy/a, ";
                    }
                } else if (wA(2, 1, A, this) || wA(2, 2, A, this)) {
                    phenotype += "rudy/a, ";
                }
            }
            //rozjasnienie
            else if (wA(1, 1, a, this) || wA(1, 2, a, this)) {
                if (wA(2, 1, a, this) && wA(2, 2, a, this)) {
                    if (wA(0, 1, A, this) ||
                            wA(0, 2, a, this)) {
                        phenotype += "niebieski/a, ";
                    } else if (wA(0, 1, a, this) && wA(0, 2, a, this)) {
                        phenotype += "liliowy/a, ";
                    } else if (wA(0, 1, a2, this) && wA(0, 2, a2, this)) {
                        phenotype += "płowy/a, ";
                    }
                } else if (wA(2, 1, A, this) || wA(2, 2, a, this)) {
                    phenotype += "kremowy/a, ";
                }
            }
            //widocznosc cetkowania, aguoti, locus A
            if (wA(5, 1, A, this) || wA(5, 2, A, this)) {
                //ticked (locus Ta)
                if (wA(4, 1, A, this) || wA(4, 2, A, this)) {
                    phenotype += "ticked, ";
                } else if (wA(4, 1, a, this) && wA(4, 2, a, this)) {
                    if (wA(3, 1, a, this) && wA(3, 2, a, this))
                        phenotype += "pręgowany/a klasycznie, ";
                    else if (wA(3, 1, A, this) || wA(3, 2, A, this))
                        phenotype += "pręgowany/a tygrysio, ";
                }
            }
        }
        //długość sierści
        if (wA(7, 1, a, this) && wA(7, 2, a, this))
            phenotype += "o długich włosach";
        else if (wA(7, 1, A, this) || wA(7, 2, A, this))
            phenotype += "o krótkich włosach";

        this.phenotype = phenotype;
    }

    private static boolean wA(int ind, int alNum, String allel, Cat cat) {
        /**
         * metoda sprawdzająca czy w genie genotype(ind) występuje podany allel w danym porządku
         */
        if (cat.genotype != null && ind < mother.genotype.size()) {
            if (alNum == 1)
                return cat.genotype.get(ind).getAllel1().equals(allel);

            else return cat.genotype.get(ind).getAllel2().equals(allel);
        }
        else return false;
    }

    private static boolean zigChk(int ind, String a, String b, String c, String d){
        /**
         * metoda sprawdzająca allele podanego genu matki i ojca
         */
        if (mother.genotype != null && ind < mother.genotype.size())
            return mother.genotype.get(ind).isItSo(a,b) && father.getGene(ind).isItSo(c,d);
        else return false;
    }

    public static List<Map<String, Integer>> intercourse() {
        /**
         * metoda zwracająca daną ceche i jej prawdopodobieństwo
         */
        String a = "rec1";
        String A = "dom1";
        String a2 = "rec2";

        int left = 100;
        int prob;

        List<Map<String, Integer>> spawnList;
        spawnList = new ArrayList<Map<String, Integer>>();
        Map<String, Integer> spawn;
        spawn = new LinkedHashMap<String, Integer>();

        //ustalenie rozkładu kolorów

        //albinos

        if (zigChk(6, a, a, a, a)) {
            prob = left;
            spawn.put("albinos", prob);
            System.out.println("albinos " + prob);
            left -= prob;
        } else if (zigChk(6, A, a, a, a) ||
                zigChk(6, a, a, A, a)) {
            prob = left;
            prob /= 2;
            spawn.put("albinos", prob);
            System.out.println("albinos " + prob);
            left -= prob;
        }

        //biały

        if (zigChk(9, A, a, A, a)) {
            prob = left;
            prob *= 3;
            prob /= 4;
            spawn.put("biały/a", prob);
            System.out.println("bialy " + prob);
            left -= prob;
        }

        else if (zigChk(9, a, a, A, a) ||
                zigChk(9, A, a, a, a)) {
            prob = left;
            prob /= 2;
            spawn.put("biały/a", prob);
            System.out.println("bialy " + prob);
            left -= prob;
        }

        //rudy
        //ignoruje rozjaśnienie

        if (zigChk(2, A, a, A, a)) {
            prob = left;
            prob *= 3;
            prob /= 4;
            spawn.put("rudy/a", prob);
            System.out.println("ustalono rudy (przed szylkretem) " + prob);
            left -= prob;
        } else if (zigChk(2, a, a, A, a) ||
                zigChk(2, A, a, a, a)) {
            prob = left;
            prob /= 2;
            spawn.put("rudy/a", prob);
            System.out.println("rudy " + prob);
            left -= prob;
        }

        //locus B - czarny, cynamonowy, czekoladowy
        //ignoruje rozjaśnienie

        if (zigChk(0, A, a, A, a)){
            prob = left;
            prob /= 4;
            spawn.put("czekoladowy/a", prob);
            System.out.println("czekoladowy " + prob);
            left -= prob;
            spawn.put("czarny/a", left);
            System.out.println("czarny " + prob);
        } else if (zigChk(0, A, a, a, a) || zigChk(0, a, a, A, a) ||
                zigChk(0, A, a, a2, a2) || zigChk(0, a2, a2, A, a)) {
            prob = left;
            prob /= 2;
            spawn.put("czekoladowy/a", prob);
            System.out.println("czekoladowy " + prob);
            left -= prob;
            spawn.put("czarny/a", left);
            System.out.println("czarny " + prob);
        } else if (zigChk(0, a, a, a2, a2) || zigChk(0, a2, a2, a, a) || zigChk(0, a, a, a, a)) {
            prob = left;
            spawn.put("czekoladowy/a", prob);
            System.out.printf("czekoladowy " + prob);
            left -= prob;
        } else if (zigChk(0, a2, a2, a2, a2)) {
            prob = left;
            spawn.put("cynamonowy/a", prob);
            System.out.println("cynamonowy " + prob);
            left -= prob;
        }

        //szylkret
        if (wA(2, 1, A, mother) || wA(2, 1, A, father)) {
            int redProb = 0, blackProb = 0, tortProb = 0;
            int albiProb = 0, whiteProb = 0, colProb;

            if (spawn.containsKey("rudy/a"))
                redProb = spawn.get("rudy/a");

            if (spawn.containsKey("czarny/a"))
                blackProb = spawn.get("czarny/a");

            if (spawn.containsKey("biały/a")) {
                whiteProb = spawn.get("biały/a");
            }
            if (spawn.containsKey("albinos")) {
                albiProb = spawn.get("albinos");

            //prawdopodobieństwo zachodzenia na siebie barwy czarnej i rudej
            //podzielone na 2 bo samiec nie może być szylkretowy

            tortProb = redProb * blackProb / 100 / 2;
            blackProb = blackProb - (tortProb * blackProb / 100);
            redProb = redProb - (tortProb * redProb / 100);
            }
            colProb = 100 - albiProb - whiteProb;

            spawn.put("czarny/a", blackProb * colProb / 100);
            System.out.println("czarny " + blackProb + " * " + colProb + " / 100");
            spawn.put("rudy/a", redProb * colProb / 100);
            System.out.println("ustalono rudy (po szylkrecie) " + redProb + " * " + colProb + " / 100");
            spawn.put("szylkretowa", tortProb * colProb / 100);
            System.out.println("szylkretowa " + tortProb + " * " + colProb + " / 100");
        }

        //rozjaśnienie

        int lightProb = 0;

        if (zigChk(1, A, a, A, a)) {
            lightProb = 25;
        } else if (zigChk(1, A, a, a, a) || zigChk(1, a, a, A, a)) {
            lightProb = 50;
        } else if (zigChk(1, a, a, a, a)) {
            lightProb = 100;
        }

        int brightProb;
        if (spawn.containsKey("rudy/a")) {
            brightProb = spawn.get("rudy/a");
            spawn.put("rudy/a", spawn.get("rudy/a") * (100-lightProb) / 100);
            System.out.println("rudy " + spawn.get("rudy/a"));
            spawn.put("kremowy/a", brightProb - spawn.get("rudy/a"));
            System.out.println("kremowy " + spawn.get("kremowy/a"));
        }
        if (spawn.containsKey("czarny/a")) {
            brightProb = spawn.get("czarny/a");
            spawn.put("czarny/a", spawn.get("czarny/a") * (100-lightProb) / 100);
            System.out.println("czarny " + spawn.get("czarny/a"));
            spawn.put("niebieski/a", brightProb - spawn.get("czarny/a"));
            System.out.println("niebieski " + spawn.get("niebieski/a"));
        }
        if (spawn.containsKey("czekoladowy/a")) {
            brightProb = spawn.get("czekoladowy/a");
            spawn.put("czekoladowy/a", spawn.get("czekoladowy/a") * (100-lightProb) / 100);
            System.out.println("czekoladowy " + spawn.get("czekoladowy/a"));
            spawn.put("liliowy/a", brightProb - spawn.get("czekoladowy/a"));
            System.out.println("liliowy " + spawn.get("liliowy/a"));
        }
        if (spawn.containsKey("cynamonowy/a")) {
            brightProb = spawn.get("cynamonowy/a");
            spawn.put("cynamonowy/a", spawn.get("cynamonowy/a") * (100-lightProb) / 100);
            System.out.println("cynamonowy " + spawn.get("cynamonowy/a"));
            spawn.put("płowy/a", brightProb - spawn.get("cynamonowy/a"));
            System.out.println("płowy " + spawn.get("płowy/a"));
        } //nie jestem pewien dlaczego rozjaśnione barwy trzeba mnożyć razy dwa

        spawnList.add(spawn);
        spawn = new LinkedHashMap<String, Integer>();

        //ustalenie pręgowania

        prob = 0;
        left = 100;

        if (!zigChk(5, a, a, a, a)) {
            if (zigChk(5, A, a, a, a) || zigChk(5, a, a, A, a)) {
                left = 75;
            } else if (zigChk(5, A, a, A, a)) {
                left = 100;
            }

            if (zigChk(4, A, a, A, a)) {
                spawn.put("pręgowanie tabby", prob);
            } else if (zigChk(4, a, a, A, a) || zigChk(4, A, a, a, a)) {
                prob = left;
                prob /= 2;
                spawn.put("pręgowanie tabby", prob);
                left -= prob;
            }

            if (zigChk(3,  A, a, a, a) || zigChk(3, a, a, A, a)) {
                prob = left;
                prob /= 2;
                spawn.put("pręgowanie tygrysie", prob);
                left -= prob;
                spawn.put("pręgowanie klasyczne", left);
            }
            else if (zigChk(3, A, a, A, a)) {
                prob = left;
                prob /= 4;
                spawn.put("pręgowanie klasyczne", prob);
                prob *= 3;
                spawn.put("pręgowanie tygrysie", prob);
            }
        }

        spawnList.add(spawn);
        spawn = new LinkedHashMap<String, Integer>();

        //długość sierści

        left = 100;

        if (zigChk(7, a, a, a, a)) {
            prob = left;
            spawn.put("długa sierść", prob);
        } else if (zigChk(7, A, A, a, a) || zigChk(7, a, a, A, A) || zigChk(7, A, A, A, A)) {
            prob = left;
            spawn.put("krótka sierść", prob);
        }

        spawnList.add(spawn);
        spawn = new LinkedHashMap<String, Integer>();

        //łaty

        if (zigChk(8, a, a, a, a)) {
            spawn.put("brak łat", 100);
        }
        if (zigChk(8, A, a, a, a) || zigChk(8, a, a, A, a)) {
            spawn.put("brak łat", 50);
            spawn.put("lekkie łaty", 50);
        }
        if (zigChk(8, A, a, A, a)) {
            spawn.put("brak łat", 25);
            spawn.put("lekkie łaty", 50);
            spawn.put("mocne łaty", 25);
        }

        spawnList.add(spawn);

        return spawnList;
    }
}
