package winda;

public class DzialanieWindy
{
    Dane d;

    public DzialanieWindy(int F, int t, double praw)
    {
        d= new Dane(F,t,praw);      // F - ilosc pieter, t - czas pomiędzy pojawianiem się nowych pasażerów, praw - prawdopodobienstwo pojawienia sie nowego pasazera

        Winda w = new RunWinda(d);
        Thread thwinda = new Thread(w, "Winda1");
        thwinda.start();


        Losowanie l = new RunLosowanie(d);
        Thread thlos = new Thread(l, "Losowanie");
        thlos.start();
    }
    public static void main(String[] args) {
        new DzialanieWindy(12,5,0.69);
    }
}
