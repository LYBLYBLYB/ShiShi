package com.example.administrator.buju;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    private static final String TAG="MainActivity";
    private ViewFlipper viewFlipper;
    private GestureDetector detector;//手势检测

    Animation leftInAnimation;
    Animation leftOutAnimation;
    Animation rightInAnimation;
    Animation rightOutAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper= (ViewFlipper) findViewById(R.id.viewFlipper);
        detector=new GestureDetector(this);

        //动画效果
        leftInAnimation= AnimationUtils.loadAnimation(this,R.anim.left_in);
        leftOutAnimation=AnimationUtils.loadAnimation(this,R.anim.left_out);
        rightInAnimation=AnimationUtils.loadAnimation(this,R.anim.right_in);
        rightOutAnimation=AnimationUtils.loadAnimation(this,R.anim.right_out);
    }
   /* private ImageView getImageView(int id){
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(id);
        return imageView;
    }
    */

    public boolean onTouchEvent(MotionEvent event) {

        return this.detector.onTouchEvent(event); //touch事件交给手势处理。
    }
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float x, float y) {
        Log.d(TAG,"e1="+e1.getX()+"e2="+e2.getX()+"e1-e2="+(e1.getX()-e2.getX()));
        if (e1.getX()-e2.getX()>120){
            viewFlipper.setInAnimation(leftInAnimation);
            viewFlipper.setOutAnimation(leftOutAnimation);
            viewFlipper.showNext();//向右滑动
            return  true;
        }else if (e1.getX()-e2.getX()<-120){
            viewFlipper.setInAnimation(rightInAnimation);
            viewFlipper.setOutAnimation(rightOutAnimation);
            viewFlipper.showNext();
            return true;
        }
        return false;
    }
}
