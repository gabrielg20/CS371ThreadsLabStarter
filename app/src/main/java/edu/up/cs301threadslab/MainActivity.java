package edu.up.cs301threadslab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import static java.lang.Thread.sleep;

/**
 * This application displays several animations.  It is used for the threads lab in CS371.
 *
 * @author Andrew Nuxoll
 * @version Fall 2015
 */
public class MainActivity extends Activity
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private AnimationView myAV;
    private SecondThread secondAV;
    private Button theButton;
    private SeekBar theSeekBar;
    private boolean ANIMATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup the animation(s)
        myAV = (AnimationView)findViewById(R.id.animationArea);
        myAV.addAnimation(new StarAnimation(myAV.getMyWidth(), myAV.getMyHeight()));
        secondAV =  new SecondThread(myAV);

        //Let me know when someone taps the button
        theButton = (Button)findViewById(R.id.button);
        theButton.setOnClickListener(this);

        //Let me know when someone adjusts the seekbar
        theSeekBar = (SeekBar)findViewById(R.id.seekBar);
        secondAV.start();
        theSeekBar.setOnSeekBarChangeListener(this);
        ANIMATE = true;
        //myAV.postInvalidate();
    }//onClick

    @Override
    public void onClick(View v) {
        myAV.postInvalidate();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        myAV.progressChange(seekBar.getProgress());
        myAV.postInvalidate();
    }

    /** These two methods aren't used */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}

    /*@Override
    public void run()
    {
        while(ANIMATE)
        {
            try {
                // Sleep 0.5-1.5 seconds
                sleep(500+(int) (Math.random() * 1000));
            }
            catch(InterruptedException e)
            {
                // nothing :-D
            }
            myAV.postInvalidate();
        }
    }*/
}
