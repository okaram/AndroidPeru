package com.example.animation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	class ImgFactory implements ViewFactory {
	      @Override
	      public View makeView() {
	            ImageView iView = new ImageView(getApplicationContext());
	            iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
	            iView.setLayoutParams(new
	                        ImageSwitcher.LayoutParams(
	                                    ImageSwitcher.LayoutParams.MATCH_PARENT,ImageSwitcher.LayoutParams.MATCH_PARENT));
	            iView.setBackgroundColor(0xAABBCC);
	            return iView;
	      }		
	}

	class PlaceState {
		public Animation inAnim, whackedAnim;
		public int state;
		public int row,col;
	}
	
	ImageSwitcher is;
	Animation inAnim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		is=(ImageSwitcher) findViewById(R.id.imageSwitcher);
		
		is.setFactory(new ImgFactory());
		inAnim=AnimationUtils.loadAnimation(this, R.animator.push_up_in);
		
		inAnim.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				is.setImageDrawable(null);
			}

			@Override	public void onAnimationRepeat(Animation animation) { }

			@Override public void onAnimationStart(Animation animation) {}			
		});
        is.setInAnimation(inAnim);
//		is.setInAnimation(null);
//        is.setOutAnimation(AnimationUtils.loadAnimation(this, R.animator.push_up_out));	
        is.setImageResource(R.drawable.all_blue);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void animateRed(View v)
	{
		Log.d("test","animating");
		is.setImageResource(R.drawable.all_red);
	}

	public void animateGreen(View v)
	{
		Log.d("test","animating");
		is.setImageResource(R.drawable.all_green);
	}

	public void animatePlatypus(View v)
	{
		Log.d("test","animating");
		is.setImageResource(R.drawable.platypus);
	}
	
	public void whacked(View v)
	{
		Log.d("test","Whacked, clearing animation 2");
		//is.clearAnimation();
		inAnim.cancel();
	}
	
}
