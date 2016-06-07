package com.example.poplify.big_potato.viewpager_training;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.SaveData;
import com.example.poplify.big_potato.rainbow_rage.RainbowRage;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment_training extends Fragment {
    private ViewPager _mViewPager;
    private ImageViewPagerAdapter_training _adapter;
    private ImageView _btn1, _btn2, _btn3,_btn4,_btn5,_btn6, _btn7, _btn8,_btn9,_btn10,cross;

    public MainActivityFragment_training() {
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpView();
        setTab();
        onCircleButtonClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main_training, container, false);
    }

    private void onCircleButtonClick() {

        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(0);
            }
        });

        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(1);
            }
        });
        _btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(2);
            }
        });
        _btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(3);
            }
        });
        _btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(4);
            }
        });
        _btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(5);
            }
        });
        _btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(6);
            }
        });
        _btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(7);
            }
        });
        _btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(8);
            }
        });
        _btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(9);
            }
        });
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent13 = new Intent(getActivity(), RainbowRage.class);
                startActivity(menuIntent13);
                getActivity().overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

            }
        });

    }

    private void setUpView() {
        _mViewPager = (ViewPager) getView().findViewById(R.id.imageviewPager_traning);
        _adapter = new ImageViewPagerAdapter_training(getActivity(), getFragmentManager());
        _mViewPager.setAdapter(_adapter);
        _mViewPager.setCurrentItem(0);
        initButton();
    }

    private void setTab() {
        _mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            int savePosition;
            @Override
            public void onPageScrollStateChanged(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                _btn1.setImageResource(R.drawable.less_white_dot);
                _btn2.setImageResource(R.drawable.less_white_dot);
                _btn3.setImageResource(R.drawable.less_white_dot);
                _btn4.setImageResource(R.drawable.less_white_dot);
                _btn5.setImageResource(R.drawable.less_white_dot);
                _btn6.setImageResource(R.drawable.less_white_dot);
                _btn7.setImageResource(R.drawable.less_white_dot);
                _btn8.setImageResource(R.drawable.less_white_dot);
                _btn9.setImageResource(R.drawable.less_white_dot);
                _btn10.setImageResource(R.drawable.less_white_dot);
                    btnAction(position);


            }

        });

    }

    private void btnAction(int action) {
        switch (action) {
            case 0:
                _btn1.setImageResource(R.drawable.full_whitedot);

                break;

            case 1:
                _btn2.setImageResource(R.drawable.full_whitedot);

                break;
            case 2:
                _btn3.setImageResource(R.drawable.full_whitedot);

                break;
            case 3:
                _btn4.setImageResource(R.drawable.full_whitedot);

                break;
            case 4:
                _btn5.setImageResource(R.drawable.full_whitedot);

                break;
            case 5:
                _btn6.setImageResource(R.drawable.full_whitedot);

                break;

            case 6:
                _btn7.setImageResource(R.drawable.full_whitedot);

                break;
            case 7:
                _btn8.setImageResource(R.drawable.full_whitedot);

                break;
            case 8:
                _btn9.setImageResource(R.drawable.full_whitedot);

                break;
            case 9:
                _btn10.setImageResource(R.drawable.full_whitedot);

                break;

        }
    }

    private void initButton() {
        _btn1 = (ImageView) getView().findViewById(R.id.btn1);
        _btn1.setImageResource(R.drawable.full_whitedot);
        _btn2 = (ImageView) getView().findViewById(R.id.btn2);
        _btn3 = (ImageView) getView().findViewById(R.id.btn3);
        _btn4 = (ImageView) getView().findViewById(R.id.btn4);
        _btn5 = (ImageView) getView().findViewById(R.id.btn5);
        _btn6 = (ImageView) getView().findViewById(R.id.btn6);
        _btn7 = (ImageView) getView().findViewById(R.id.btn7);
        _btn8 = (ImageView) getView().findViewById(R.id.btn8);
        _btn9 = (ImageView) getView().findViewById(R.id.btn9);
        _btn10 = (ImageView) getView().findViewById(R.id.btn10);
        cross = (ImageView) getView().findViewById(R.id.imageView7_cross_training);





    }

    private void setButton(Button btn, String text, int h, int w) {
        btn.setWidth(w);
        btn.setHeight(h);
        btn.setText(text);
    }
}
