package rw.awesomity.covi_tracker.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import rw.awesomity.covi_tracker.R;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TextView text = (TextView)findViewById(R.id.text_anim);
        Animation animations = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        text.startAnimation(animations);

        animations.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(HomePageActivity.this, MainActivity.class));
            }
        });
    }
}
