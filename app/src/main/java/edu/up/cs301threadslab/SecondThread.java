package edu.up.cs301threadslab;

public class SecondThread extends Thread{
    private AnimationView ourAV;

    public SecondThread(AnimationView newAV){
        ourAV = newAV;
    }
    @Override
    public  void run()
    {
        while(true) {
            try {
                sleep(50);
            } catch (InterruptedException e) {

            }
            ourAV.postInvalidate();
        }
    }
}
