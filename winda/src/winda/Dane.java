package winda;

import java.util.HashSet;
import java.util.LinkedList;

public class Dane
{
    double prawdopodobienstwo;
    int czas;
    int ilość_pięter;
    Piętro[] piętra;
    int aktualne_piętro = 0;
    int zajete_miejsca=0;
    int pojemnosc = 10;
    String imie;
    LinkedList<Pasażer> moiPasażerowie = new LinkedList<Pasażer>();
    HashSet<Integer> gdzieMamJechac = new HashSet<Integer>(ilość_pięter);
    boolean jadeDoGory = true;

    public Dane(int F, int t, double praw)
    {
        this.prawdopodobienstwo = praw;
        this.czas = t*100;
        this.ilość_pięter = F;
        piętra = new Piętro[F+1];
        System.out.println("Tyle jest pięter: " +ilość_pięter);
        for(int i=0; i<F+1;i++)
        {
            piętra[i] = new Piętro(i);
        }
    }
}
