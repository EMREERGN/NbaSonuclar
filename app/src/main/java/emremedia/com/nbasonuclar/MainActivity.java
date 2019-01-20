package emremedia.com.nbasonuclar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import emremedia.com.nbasonuclar.Common.Common;
import emremedia.com.nbasonuclar.Model.Days;
import emremedia.com.nbasonuclar.Model.MatchResult;
import emremedia.com.nbasonuclar.ViewHolder.NbaViewAdapter;

public class MainActivity extends AppCompatActivity {

    List<Days> oneWeekMatches;
    RecyclerView myRecyclerView;
    NbaViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneWeekMatches=Common.oneWeekMatches;

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        adapter = new NbaViewAdapter(getBaseContext(), oneWeekMatches.get(0).getMatchResults());
        if (myRecyclerView != null)
            myRecyclerView.setAdapter(adapter);

    }
}




