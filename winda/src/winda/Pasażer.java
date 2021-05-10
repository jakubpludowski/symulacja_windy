package winda;

public class Pasażer
{
    int naKtóre=0;
    static int iloscpasazerow=1;
    int numer;

    public Pasażer(int cel)
    {
        this.numer = iloscpasazerow;
        iloscpasazerow++;
        this.naKtóre = cel;
    }
}
