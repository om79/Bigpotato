package com.example.poplify.big_potato.view_pager;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.poplify.big_potato.R;
import com.example.poplify.big_potato.adapters.SaveData;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ViewPager _mViewPager;
    private ImageViewPagerAdapter _adapter;
    private ImageView _btn1, _btn2, _btn3,_btn4,_btn5;
    SaveData save;
    public MainActivityFragment() {
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        save= new SaveData(getActivity());
        setUpView();
        setTab();
        onCircleButtonClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
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
    }

    private void setUpView() {
        _mViewPager = (ViewPager) getView().findViewById(R.id.imageviewPager);
        _adapter = new ImageViewPagerAdapter(getActivity(), getFragmentManager());
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

        }
    }

    private void initButton() {
        _btn1 = (ImageView) getView().findViewById(R.id.btn1);
        _btn1.setImageResource(R.drawable.full_whitedot);
        _btn2 = (ImageView) getView().findViewById(R.id.btn2);
        _btn3 = (ImageView) getView().findViewById(R.id.btn3);
        _btn4 = (ImageView) getView().findViewById(R.id.btn4);
        _btn5 = (ImageView) getView().findViewById(R.id.btn5);

        if(save.getString("current_game").equals("RAINBOW")){
            _btn5.setVisibility(View.VISIBLE);
        }else {
            _btn5.setVisibility(View.GONE);
        }

    }

    private void setButton(Button btn, String text, int h, int w) {
        btn.setWidth(w);
        btn.setHeight(h);
        btn.setText(text);
    }
}
