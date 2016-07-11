package ru.mydomain.raspisanieusatu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.mydomain.raspisanieusatu.fragment.ExampleFragment;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter{

    private String[] tabs;

    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[]{
                "Таб 1",
                "Напоминание",
                "Таб 2"};
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ExampleFragment.getInstanse();
            case 1:
                return ExampleFragment.getInstanse();
            case 2:
                return ExampleFragment.getInstanse();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
