package com.example.kurs;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    ViewFlipper flipper;

    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analiz);

        flipper = (ViewFlipper) findViewById(R.id.viewflipper);

        animFlipInForward = AnimationUtils.loadAnimation(this, R.anim.flipin_reverse);
        animFlipOutForward = AnimationUtils.loadAnimation(this, R.anim.flipout_reverse);
        animFlipInBackward = AnimationUtils.loadAnimation(this,
                R.anim.flipin_reverse);
        animFlipOutBackward = AnimationUtils.loadAnimation(this,
                R.anim.flipout_reverse);

        final ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        Button button1 = (Button) findViewById(R.id.button1);
        Button buttonautoflip = (Button)  findViewById(R.id.buttonautoflip);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });


        button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });
        buttonautoflip.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, rehistrator.class);
                startActivity(intent);
            }
        });





    }





    private void SwipeLeft() {
        flipper.setInAnimation(animFlipInBackward);
        flipper.setOutAnimation(animFlipOutBackward);
        flipper.showPrevious();
    }

    private void SwipeRight() {
        flipper.setInAnimation(animFlipInForward);
        flipper.setOutAnimation(animFlipOutForward);
        flipper.showNext();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {

            float sensitvity = 50;
            if ((e1.getX() - e2.getX()) > sensitvity) {
                SwipeLeft();
            } else if ((e2.getX() - e1.getX()) > sensitvity) {
                SwipeRight();
            }
            return true;
        }
    };

    GestureDetector gestureDetector = new GestureDetector(getBaseContext(),
            simpleOnGestureListener);



}
