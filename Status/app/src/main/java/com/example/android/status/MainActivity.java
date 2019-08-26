package com.example.android.status;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Live.OnFragmentInteractionListener,Upcoming.OnFragmentInteractionListener,Completed.OnFragmentInteractionListener,View.OnClickListener {

EditText status_type;
TabLayout tl;
ViewPager viewPager;
pageradapter adapter;
    ArrayList<String> dept_name=new ArrayList<>();
    ArrayList<String> sport_name=new ArrayList<>();
    String type;
    boolean ischange=false;
ImageView shift;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shift=findViewById(R.id.shift);
        shift.setOnClickListener(this);
        initDeptName();
        initSportName();
        tl=findViewById(R.id.tablayout);
        tl.addTab(tl.newTab().setText("Live"));
        tl.addTab(tl.newTab().setText("Upcoming"));
        tl.addTab(tl.newTab().setText("Completed"));
        tl.getTabAt(0).setIcon(R.drawable.ic_live_tv_black_24dp);
        tl.getTabAt(1).setIcon(R.drawable.ic_live_tv_black_24dp);
        tl.getTabAt(2).setIcon(R.drawable.ic_live_tv_black_24dp);
        tl.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager=findViewById(R.id.pager);
   adapter=new pageradapter(getSupportFragmentManager(),tl.getTabCount());
   viewPager.setAdapter(adapter);
   viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));
        final LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        final RecyclerView rv=findViewById(R.id.dept_recyclerview);
        rv.setLayoutManager(layoutManager);
        final int duration = 10;
        final int pixelsToMove = 30;
         final Handler mHandler = new Handler(Looper.getMainLooper());
        final Runnable SCROLLING_RUNNABLE = new Runnable() {

            @Override
            public void run() {
                rv.smoothScrollBy(pixelsToMove, 0);
                mHandler.postDelayed(this, duration);
            }
        };

        final deptlist_adapter deptlistAdapter=new deptlist_adapter(dept_name,this);
        rv.setAdapter(deptlistAdapter);
        //deptlistAdapter.setOn
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();
                if(lastItem == layoutManager.getItemCount()-1){
                    mHandler.removeCallbacks(SCROLLING_RUNNABLE);
                    Handler postHandler = new Handler();
                    postHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rv.setAdapter(null);
                            rv.setAdapter(deptlistAdapter);
                            mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);
                        }
                    }, 2000);
                }
            }
        });
        mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);

        tl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
       @Override
       public void onTabSelected(TabLayout.Tab tab) {
           viewPager.setCurrentItem(tab.getPosition());
       }

       @Override
       public void onTabUnselected(TabLayout.Tab tab) {

       }

       @Override
       public void onTabReselected(TabLayout.Tab tab) {

       }
   });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void initDeptName()
    {
        dept_name.add("ALL");
        dept_name.add("ARCHI");
        dept_name.add("CHEM");
        dept_name.add("CIVIL");
        dept_name.add("CSE");
        dept_name.add("DOMS");
        dept_name.add("ECE");
        dept_name.add("EEE");
        dept_name.add("ICE");
        dept_name.add("MECH");
        dept_name.add("META");
        dept_name.add("CA");
        dept_name.add("M.TECH");
        dept_name.add("PhD/MSc/MS");
        dept_name.add("PROD");

    }
    public void initSportName()
    {
        sport_name.add("ALL");
        sport_name.add("ATHL");
        sport_name.add("BDM(M)");
        sport_name.add("BSKT(B)");
        sport_name.add("BSKT(G)");
        sport_name.add("CARROM");
        sport_name.add("CHESS");
        sport_name.add("CKT(B)");
        sport_name.add("CKT(G)");
        sport_name.add("FTB(B)");
        sport_name.add("HNDB(B)");
        sport_name.add("HNDB(G)");
        sport_name.add("HKY(B)");
        sport_name.add("KBD");
        sport_name.add("KHOKHO(B)");
        sport_name.add("KHOKHO(G)");
        sport_name.add("MARATHON");
        sport_name.add("PWR LFTNG");
        sport_name.add("SWIMMING");
        sport_name.add("TT(M)");
        sport_name.add("TENNIS(B)");
        sport_name.add("THRB");
        sport_name.add("VLB(B)");
        sport_name.add("VLB(G)");
        sport_name.add("SPQZ");
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.shift)
        {

        }
    }
}
