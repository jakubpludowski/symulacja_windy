package winda;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Piętro
{
    BlockingQueue<Pasażer> pasażerowie = new ArrayBlockingQueue<>(10);
    int nr_piętra=0;

    public Piętro(int i)
    {
        this.nr_piętra = i;
    }

}
