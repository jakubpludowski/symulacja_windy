package winda;


import java.util.Random;

public class RunLosowanie implements Losowanie
{
    Dane d;

    RunLosowanie(Dane d)
    {
        this.d=d;
    }


    @Override
    public void run()
    {
        while (true)
        {
           losuj();
        }
    }
    @Override
    public void losuj()
    {
        try
        {
            Thread.sleep(d.czas);
            //System.out.println("Spię");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        int granica =(int)( this.d.prawdopodobienstwo*(100.0));

        Random r = new Random();
        int low = 1;
        int high = 100;
        int result = r.nextInt(high-low) + low;

        int cellow = 0;
        int celhigh = d.ilość_pięter;
        int celresult = r.nextInt(celhigh-cellow) + cellow;


        int skadlow = 0;
        int skadhigh = d.ilość_pięter;
        int skadresult = r.nextInt(skadhigh-skadlow) + skadlow;

        while (celresult==skadresult)
        {
            skadresult = r.nextInt(skadhigh-skadlow) + skadlow;
        }

        if(result<granica)
        {
            Pasażer x = new Pasażer(celresult);
            System.out.println("Pasażer nr "+x.numer+" oczekuje na piętrze nr "+ skadresult + " i chce jechać na piętro nr "+ celresult + ".");
            this.d.piętra[skadresult].pasażerowie.add(x);
            this.d.gdzieMamJechac.add(celresult);

        }
    }



}
