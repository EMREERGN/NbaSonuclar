package emremedia.com.nbasonuclar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import emremedia.com.nbasonuclar.Common.Common;
import emremedia.com.nbasonuclar.Model.NbaResult;
import emremedia.com.nbasonuclar.ViewHolder.NbaViewAdapter;

public class MainActivity extends AppCompatActivity {

    List<NbaResult> nbaResults;
    RecyclerView myRecyclerView;
    NbaViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        nbaResults = new ArrayList<>();
        nbaResults = Common.nbaResults;

        adapter = new NbaViewAdapter(getBaseContext(), nbaResults);
        if (myRecyclerView != null)
            myRecyclerView.setAdapter(adapter);

    }
}




