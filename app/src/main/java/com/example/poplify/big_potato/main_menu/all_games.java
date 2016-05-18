package com.example.poplify.big_potato.main_menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

import com.example.poplify.big_potato.R;

public class all_games extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_all_games);
    }
    public void which_game(final View view)
    {
        final LinearLayout layout2;
        switch (view.getId()) {
            case R.id.bod: // doStuff
//                view.getTag();
                layout2 = (LinearLayout) findViewById(R.id.bod);
                layout2.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                if (layout2.getLayoutParams().height != 850) {
                    myanimate(layout2);
                }
                break;
            case R.id.mr_lister: // doStuff
                layout2 = (LinearLayout) findViewById(R.id.mr_lister);
                layout2.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                if (layout2.getLayoutParams().height != 850) {
                    myanimate(layout2);
                }
                break;
//            case R.id.cross_btn:

        }
    }
    public void collapse_btn(final View view)
    {
        final LinearLayout layout2;
        switch (view.getId()) {
            case R.id.bod: // doStuff
                layout2 = (LinearLayout) findViewById(R.id.bod);
                layout2.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                if (layout2.getLayoutParams().height != 850) {
                    myanimate(layout2);
                }
                break;
            case R.id.mr_lister: // doStuff
                layout2 = (LinearLayout) findViewById(R.id.mr_lister);
                layout2.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                if (layout2.getLayoutParams().height != 850) {
                    myanimate(layout2);
                }
                break;
        }
    }
    private void myanimate(final LinearLayout layout2) {
        if (layout2.getLayoutParams().height != 850) {
            layout2.getLayoutParams().height = 400;
            layout2.setVisibility(View.VISIBLE);
            Animation a2 = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    layout2.getLayoutParams().height = interpolatedTime == 1
                            ? (int) (400 + 450 * interpolatedTime)
                            : (int) (400 + 450 * interpolatedTime);
                    layout2.requestLayout();
                }

                @Override
                public boolean willChangeBounds() {
                    return true;
                }
            };
            //
            a2.setDuration((int) (400 + 450 / layout2.getContext().getResources().getDisplayMetrics().density));
            layout2.startAnimation(a2);
        }
        else{

            collapse(layout2);

        }
    }
    public void collapse(final LinearLayout layout2){
        layout2.getLayoutParams().height = 850;
//            layout2.setVisibility(View.GONE);
        Animation a2 = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                layout2.getLayoutParams().height = interpolatedTime == 1
                        ? (int) (850 - 450 * interpolatedTime)
                        : (int) (850 - 450 * interpolatedTime);
                layout2.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        //
        a2.setDuration((int) (850 - 450 / layout2.getContext().getResources().getDisplayMetrics().density));
        layout2.startAnimation(a2);

    }
}
