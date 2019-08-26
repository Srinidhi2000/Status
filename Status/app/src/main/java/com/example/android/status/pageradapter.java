package com.example.android.status;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class pageradapter extends FragmentPagerAdapter {

    int noTabs;

    public pageradapter(FragmentManager fm,int noTabs) {
        super(fm);
        this.noTabs=noTabs;
    }

    @Override
    public Fragment getItem(int i) {
      switch(i)
      {
          case 0:
              Live live=new Live();
              return live;
          case 1:
              Upcoming upcoming=new Upcoming();
              return upcoming;
          case 2:
              Completed completed=new Completed();
              return completed;
              default:
                  return null;
      }

    }

    @Override
    public int getCount() {
        return noTabs;
    }
}
