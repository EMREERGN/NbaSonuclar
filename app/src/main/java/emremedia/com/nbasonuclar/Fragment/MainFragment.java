package emremedia.com.nbasonuclar.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import emremedia.com.nbasonuclar.Common.Common;
import emremedia.com.nbasonuclar.MainActivity;
import emremedia.com.nbasonuclar.Model.Days;
import emremedia.com.nbasonuclar.R;
import emremedia.com.nbasonuclar.ViewHolder.NbaViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    List<Days> oneWeekMatches;
    RecyclerView myRecyclerView;
    NbaViewAdapter adapter;
    TextView datetextView;
    Calendar cal;
    DateFormat dateFormat;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);

        oneWeekMatches=Common.oneWeekMatches;

        myRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_main);
        datetextView=(TextView)view.findViewById(R.id.nbaDateTxt);

        int pageNumber=getArguments().getInt("day");

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        cal = Calendar.getInstance();

        cal.add(Calendar.DATE, pageNumber-oneWeekMatches.size()); //19

        datetextView.setText(dateFormat.format(cal.getTime()));



        myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NbaViewAdapter(getContext(), oneWeekMatches.get(pageNumber).getMatchResults());
        if (myRecyclerView != null)
            myRecyclerView.setAdapter(adapter);

        return view;
    }

}
