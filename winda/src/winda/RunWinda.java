package winda;

public class RunWinda implements Winda
{
    Dane d;

    public RunWinda(Dane d)
    {
        this.d = d;
    }

    @Override
    public void jedziemy()
    {

        if(d.gdzieMamJechac.size()==0)
        {
            try
            {
                Thread.sleep(d.czas);
                System.out.println("Czekam na zgłoszenie");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                Thread.sleep(d.czas);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if(d.jadeDoGory==true)
            {
                d.aktualne_piętro++;
                System.out.println("Winda jest na piętrze nr "+d.aktualne_piętro);
                wypusc();
                laduj();

                if(d.aktualne_piętro==d.ilość_pięter)
                {
                    d.jadeDoGory=false;
                }
            }
            if(d.jadeDoGory==false)
            {
                d.aktualne_piętro--;
                System.out.println("Winda jest na piętrze nr "+d.aktualne_piętro);
                wypusc();
                laduj();

                if(d.aktualne_piętro==0)
                {
                    d.jadeDoGory=true;
                }
            }
        }

    }
    @Override
    public void run()
    {
        while (true)
        {
            jedziemy();
        }
    }

    public void laduj()
    {
        if(!(d.piętra[d.aktualne_piętro].pasażerowie.isEmpty()))
        {
            try
            {
                for(Integer i=0;i<d.piętra[d.aktualne_piętro].pasażerowie.size() && i< d.pojemnosc-d.zajete_miejsca;i++)
                {
                    Pasażer x = d.piętra[d.aktualne_piętro].pasażerowie.take();
                    int n = x.numer;
                    d.gdzieMamJechac.add(x.naKtóre);
                    d.moiPasażerowie.add(d.zajete_miejsca, x);
                    d.zajete_miejsca++;
                    System.out.println("Winda zabiera pasażera nr "+ n + " z piętra nr "+d.aktualne_piętro);
                    System.out.println("Mam tylu pasażerów: " + d.moiPasażerowie.size());
                }

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void wypusc()
    {
        if(!d.moiPasażerowie.isEmpty())
        {
            for (Integer i = 0; i < d.moiPasażerowie.size(); i++)
            {

                Pasażer x = d.moiPasażerowie.get(i);
                int n = x.numer;
                if (x.naKtóre == d.aktualne_piętro)
                {
                    d.moiPasażerowie.remove(x);
                    d.zajete_miejsca--;
                    System.out.println("Pasażer nr "+n+ " opuścił windę na pietrze nr "+d.aktualne_piętro+".");
                    System.out.println("Mam tylu pasażerów: " + d.moiPasażerowie.size());
                }
            }
            d.gdzieMamJechac.remove(d.aktualne_piętro);

        }

    }



    private void sleeep(long t) {
        try {
            Thread.sleep((long) (t * Math.random()));
        } catch (InterruptedException ie) {
        }
    }
}
