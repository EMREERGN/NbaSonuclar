package emremedia.com.nbasonuclar;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import emremedia.com.nbasonuclar.Common.Common;
import emremedia.com.nbasonuclar.Fragment.MainFragmentPagerAdapter;
import emremedia.com.nbasonuclar.Model.Days;
import emremedia.com.nbasonuclar.Model.MatchResult;
import emremedia.com.nbasonuclar.ViewHolder.NbaViewAdapter;
import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MainFragmentPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Collections.reverse(Common.oneWeekMatches);

        viewPager=findViewById(R.id.myViewPager);

        adapter=new MainFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(Common.oneWeekMatches.size()-1);


    }
}




