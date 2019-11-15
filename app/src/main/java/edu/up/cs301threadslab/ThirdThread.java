package edu.up.cs301threadslab;

public class ThirdThread extends Thread{
    private StarAnimation starAnime;

    public ThirdThread(StarAnimation newAnime){
        starAnime = newAnime;
    }

    @Override
    public synchronized void run()
    {
        while (true) {
            try {
                sleep(40);
            } catch (InterruptedException e) {
            }
            int randVal = (int) (Math.random() * 1);
            if (randVal == 1) {
                starAnime.addStar();
            } else {
                starAnime.removeStar();
            }
            //ourAV.postInvalidate();
        }
    }

}
