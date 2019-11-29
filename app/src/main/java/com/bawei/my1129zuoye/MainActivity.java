package com.bawei.my1129zuoye;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.my1129zuoye.fragment.HomeFragment;
import com.bawei.my1129zuoye.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);

        OtherFragment insert1 = OtherFragment.getInstance("首页");
        HomeFragment homeFragment = new HomeFragment();
        OtherFragment instance2 = OtherFragment.getInstance("我的");

        fragments.add(insert1);
        fragments.add(homeFragment);
        fragments.add(instance2);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb1:
                    vp.setCurrentItem(0);
                    break;
                case R.id.rb2:
                    vp.setCurrentItem(1);
                    break;
                case R.id.rb3:
                    vp.setCurrentItem(2);
                    break;
            }
        }
    });
    vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            rg.check(rg.getChildAt(position).getId());
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });
    }
}
