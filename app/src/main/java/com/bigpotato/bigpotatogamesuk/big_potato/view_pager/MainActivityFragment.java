package com.bigpotato.bigpotatogamesuk.big_potato.view_pager;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bigpotato.bigpotatogamesuk.big_potato.R;
import com.bigpotato.bigpotatogamesuk.big_potato.adapters.SaveData;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ViewPager _mViewPager;
    private ImageViewPagerAdapter _adapter;
    private ImageView _btn1, _btn2, _btn3,_btn4,_btn5,_btn6,cross_pic;
    LinearLayout cross;
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
                _mViewPager.setCurrentItem(1);
            }
        });

        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(2);
            }
        });
        _btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(3);
            }
        });
        _btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(4);
            }
        });
        _btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(5);
            }
        });
        _btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mViewPager.setCurrentItem(6);
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                managerOfSound();
                getActivity().finish();

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
                if(save.getString("current_game").equals("SCRAWL"))
                {
                    _btn1.setImageResource(R.mipmap.grey_dot);
                    _btn2.setImageResource(R.mipmap.grey_dot);
                    _btn3.setImageResource(R.mipmap.grey_dot);
                    _btn4.setImageResource(R.mipmap.grey_dot);
                    _btn5.setImageResource(R.mipmap.grey_dot);
                    _btn6.setImageResource(R.mipmap.grey_dot);
                    btnAction(position);
                }else {
                    _btn1.setImageResource(R.mipmap.less_white_dot);
                    _btn2.setImageResource(R.mipmap.less_white_dot);
                    _btn3.setImageResource(R.mipmap.less_white_dot);
                    _btn4.setImageResource(R.mipmap.less_white_dot);
                    _btn5.setImageResource(R.mipmap.less_white_dot);
                    _btn6.setImageResource(R.mipmap.less_white_dot);
                    btnAction(position);
                }


            }

        });

    }

    private void btnAction(int action) {




        switch (save.getString("current_game"))
        {
            case "CHAMELEON":

                switch (action) {
                    case 0:
                        _btn1.setVisibility(View.GONE);
                        _btn2.setVisibility(View.GONE);
                        _btn3.setVisibility(View.GONE);
                        _btn4.setVisibility(View.GONE);
                        _btn5.setVisibility(View.GONE);
                        _btn6.setVisibility(View.GONE);
                        break;
                    case 1:
                        _btn1.setVisibility(View.VISIBLE);
                        _btn2.setVisibility(View.VISIBLE);
                        _btn3.setVisibility(View.VISIBLE);
                        _btn4.setVisibility(View.VISIBLE);
                        _btn5.setVisibility(View.VISIBLE);
                        _btn6.setVisibility(View.VISIBLE);
                        _btn1.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 2:
                        _btn2.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 3:
                        _btn3.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 4:
                        _btn4.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 5:
                        _btn5.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 6:
                        _btn6.setImageResource(R.mipmap.qwordie_dot);
                        break;

                }
                break;
            case "RAINBOW":
                switch (action) {
                    case 0:
                        _btn1.setVisibility(View.GONE);
                        _btn2.setVisibility(View.GONE);
                        _btn3.setVisibility(View.GONE);
                        _btn4.setVisibility(View.GONE);
                        _btn5.setVisibility(View.GONE);
                        break;
                    case 1:
                        _btn1.setVisibility(View.VISIBLE);
                        _btn2.setVisibility(View.VISIBLE);
                        _btn3.setVisibility(View.VISIBLE);
                        _btn4.setVisibility(View.VISIBLE);
                        _btn5.setVisibility(View.VISIBLE);
                        _btn1.setImageResource(R.mipmap.full_whitedot);
                        break;
                    case 2:
                        _btn2.setImageResource(R.mipmap.full_whitedot);
                        break;
                    case 3:
                        _btn3.setImageResource(R.mipmap.full_whitedot);
                        break;
                    case 4:
                        _btn4.setImageResource(R.mipmap.full_whitedot);
                        break;
                    case 5:
                        _btn5.setImageResource(R.mipmap.full_whitedot);
                        break;

                }
                break;
            case "BUCKET OF DOOM":
                _btn5.setVisibility(View.GONE);
                switch (action) {
                    case 0:
                        _btn1.setVisibility(View.GONE);
                        _btn2.setVisibility(View.GONE);
                        _btn3.setVisibility(View.GONE);
                        _btn4.setVisibility(View.GONE);
                        _btn5.setVisibility(View.GONE);
                        break;
                    case 1:
                        _btn1.setVisibility(View.VISIBLE);
                        _btn2.setVisibility(View.VISIBLE);
                        _btn3.setVisibility(View.VISIBLE);
                        _btn4.setVisibility(View.VISIBLE);

                        _btn1.setImageResource(R.mipmap.bod_dot);
                        break;
                    case 2:
                        _btn2.setImageResource(R.mipmap.bod_dot);
                        break;
                    case 3:
                        _btn3.setImageResource(R.mipmap.bod_dot);
                        break;
                    case 4:
                        _btn4.setImageResource(R.mipmap.bod_dot);
                        break;
                    case 5:
                        _btn5.setImageResource(R.mipmap.bod_dot);
                        break;

                }
                break;
            case "QWORDIE":
                _btn5.setVisibility(View.GONE);
                switch (action) {
                    case 0:
                        _btn1.setVisibility(View.GONE);
                        _btn2.setVisibility(View.GONE);
                        _btn3.setVisibility(View.GONE);
                        _btn4.setVisibility(View.GONE);
                        _btn5.setVisibility(View.GONE);
                        break;
                    case 1:
                        _btn1.setVisibility(View.VISIBLE);
                        _btn2.setVisibility(View.VISIBLE);
                        _btn3.setVisibility(View.VISIBLE);
                        _btn4.setVisibility(View.VISIBLE);

                        _btn1.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 2:
                        _btn2.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 3:
                        _btn3.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 4:
                        _btn4.setImageResource(R.mipmap.qwordie_dot);
                        break;
                    case 5:
                        _btn5.setImageResource(R.mipmap.qwordie_dot);
                        break;

                }
                break;
            case "MR LISTERS":
                _btn5.setVisibility(View.GONE);
                switch (action) {
                    case 0:
                        _btn1.setVisibility(View.GONE);
                        _btn2.setVisibility(View.GONE);
                        _btn3.setVisibility(View.GONE);
                        _btn4.setVisibility(View.GONE);
                        _btn5.setVisibility(View.GONE);
                        break;
                    case 1:
                        _btn1.setVisibility(View.VISIBLE);
                        _btn2.setVisibility(View.VISIBLE);
                        _btn3.setVisibility(View.VISIBLE);
                        _btn4.setVisibility(View.VISIBLE);

                        _btn1.setImageResource(R.mipmap.mr_dot);
                        break;
                    case 2:
                        _btn2.setImageResource(R.mipmap.mr_dot);
                        break;
                    case 3:
                        _btn3.setImageResource(R.mipmap.mr_dot);
                        break;
                    case 4:
                        _btn4.setImageResource(R.mipmap.mr_dot);
                        break;
                    case 5:
                        _btn5.setImageResource(R.mipmap.mr_dot);
                        break;

                }
                break;
            case "OKPLAY":
                _btn5.setVisibility(View.GONE);
                switch (action) {
                    case 0:
                        _btn1.setVisibility(View.GONE);
                        _btn2.setVisibility(View.GONE);
                        _btn3.setVisibility(View.GONE);
                        _btn4.setVisibility(View.GONE);
                        _btn5.setVisibility(View.GONE);
                        break;
                    case 1:
                        _btn1.setVisibility(View.VISIBLE);
                        _btn2.setVisibility(View.VISIBLE);
                        _btn3.setVisibility(View.VISIBLE);
                        _btn4.setVisibility(View.VISIBLE);

                        _btn1.setImageResource(R.mipmap.okplay_dot);
                        break;
                    case 2:
                        _btn2.setImageResource(R.mipmap.okplay_dot);
                        break;
                    case 3:
                        _btn3.setImageResource(R.mipmap.okplay_dot);
                        break;
                    case 4:
                        _btn4.setImageResource(R.mipmap.okplay_dot);
                        break;
                    case 5:
                        _btn5.setImageResource(R.mipmap.okplay_dot);
                        break;

                }
                break;

            case "SCRAWL":
                _btn5.setVisibility(View.GONE);
                switch (action) {
                    case 0:
                        _btn1.setVisibility(View.GONE);
                        _btn2.setVisibility(View.GONE);
                        _btn3.setVisibility(View.GONE);
                        _btn4.setVisibility(View.GONE);
                        _btn5.setVisibility(View.GONE);
                        break;
                    case 1:
                        _btn1.setVisibility(View.VISIBLE);
                        _btn2.setVisibility(View.VISIBLE);
                        _btn3.setVisibility(View.VISIBLE);
                        _btn4.setVisibility(View.VISIBLE);

                        _btn1.setImageResource(R.mipmap.okplay_dot);
                        break;
                    case 2:
                        _btn2.setImageResource(R.mipmap.okplay_dot);
                        break;
                    case 3:
                        _btn3.setImageResource(R.mipmap.okplay_dot);
                        break;
                    case 4:
                        _btn4.setImageResource(R.mipmap.okplay_dot);
                        break;
                    case 5:
                        _btn5.setImageResource(R.mipmap.okplay_dot);
                        break;

                }
                break;

            case "OBLA":
                _btn5.setVisibility(View.VISIBLE);
                switch (action) {
                    case 0:
                        _btn1.setVisibility(View.GONE);
                        _btn2.setVisibility(View.GONE);
                        _btn3.setVisibility(View.GONE);
                        _btn4.setVisibility(View.GONE);
                        _btn5.setVisibility(View.GONE);
                        break;
                    case 1:
                        _btn1.setVisibility(View.VISIBLE);
                        _btn2.setVisibility(View.VISIBLE);
                        _btn3.setVisibility(View.VISIBLE);
                        _btn4.setVisibility(View.VISIBLE);
                        _btn5.setVisibility(View.VISIBLE);
                        _btn1.setImageResource(R.mipmap.full_whitedot);
                        break;
                    case 2:
                        _btn2.setImageResource(R.mipmap.full_whitedot);
                        break;
                    case 3:
                        _btn3.setImageResource(R.mipmap.full_whitedot);
                        break;
                    case 4:
                        _btn4.setImageResource(R.mipmap.full_whitedot);
                        break;
                    case 5:

                        _btn5.setImageResource(R.mipmap.full_whitedot);
                        break;

                }


        }


    }

    private void initButton() {
        _btn1 = (ImageView) getView().findViewById(R.id.btn1);
        _btn2 = (ImageView) getView().findViewById(R.id.btn2);
        _btn3 = (ImageView) getView().findViewById(R.id.btn3);
        _btn4 = (ImageView) getView().findViewById(R.id.btn4);
        _btn5 = (ImageView) getView().findViewById(R.id.btn5);
        _btn6 = (ImageView) getView().findViewById(R.id.btn6);
        cross = (LinearLayout) getView().findViewById(R.id.back_play);
        cross_pic = (ImageView) getView().findViewById(R.id.back_arrooow);
        _btn1.setVisibility(View.GONE);
        _btn2.setVisibility(View.GONE);
        _btn3.setVisibility(View.GONE);
        _btn4.setVisibility(View.GONE);
        _btn5.setVisibility(View.GONE);
        _btn6.setVisibility(View.GONE);

        switch (save.getString("current_game")) {
            case "SCRAWL":
                cross_pic.setImageResource(R.mipmap.black_back);
                break;
        }




    }



    private void managerOfSound() {

        MediaPlayer mp= MediaPlayer.create(getActivity(), R.raw.back_button);
        if (!mp.isPlaying()) {
            mp.start();
        } else {

            mp.stop();


        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mp.reset();
                mp.release();


            }
        });
    }
}
