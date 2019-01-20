package emremedia.com.nbasonuclar.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import emremedia.com.nbasonuclar.GetIcon;
import emremedia.com.nbasonuclar.Model.NbaResult;
import emremedia.com.nbasonuclar.Model.Team;
import emremedia.com.nbasonuclar.R;

public class NbaViewAdapter extends RecyclerView.Adapter<NbaViewHolder>{

    private Context context;
    private List<NbaResult> nbateam;

    public NbaViewAdapter(Context context, List<NbaResult> nbateam) {
        this.context = context;
        this.nbateam = nbateam;
    }

    @Override
    public NbaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        view=layoutInflater.inflate(R.layout.match_results_card_item,parent,false);
        return new NbaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final NbaViewHolder holder, int position) {
        GetIcon icon =new GetIcon();

        holder.matchStatus.setText(nbateam.get(position).getStatusGame());

        holder.homeTeamImage.setImageResource(icon.GetIcon(nbateam.get(position).getHomeTeamName())); //Heat -> image name olso team name
        holder.homeTeamName.setText(nbateam.get(position).getHomeTeamName());
        holder.homeWinLost.setText(nbateam.get(position).getHomeTeamWinLost());
        holder.homeTeamTotalScore.setText(nbateam.get(position).getHomeTeamTotalScore());
        holder.homeFirstPer.setText(nbateam.get(position).getHomeTeamPeriotScores()[0]);
        holder.homeSecondPer.setText(nbateam.get(position).getHomeTeamPeriotScores()[1]);
        holder.homeThirdPer.setText(nbateam.get(position).getHomeTeamPeriotScores()[2]);
        holder.homeFourthPer.setText(nbateam.get(position).getHomeTeamPeriotScores()[3]);
        holder.homeOverTimePer.setText(nbateam.get(position).getHomeTeamPeriotScores()[4]);
        holder.homeTeamTotalScore.setText(nbateam.get(position).getHomeTeamTotalScore());
        holder.homeTeamBestPlayer.setText(nbateam.get(position).getHomeTeamBesyPlayer());

        holder.awayTeamImage.setImageResource(icon.GetIcon(nbateam.get(position).getAwayTeamName())); //Bulls -> image name olso team name
        holder.awayTeamName.setText(nbateam.get(position).getAwayTeamName());
        holder.awayWinLost.setText(nbateam.get(position).getAwayTeamWinLost());
        holder.awayTeamTotalScore.setText(nbateam.get(position).getAwayTeamTotalScore());
        holder.awayFirstPer.setText(nbateam.get(position).getAwayteamPeriotScores()[0]);
        holder.awaySecondPer.setText(nbateam.get(position).getAwayteamPeriotScores()[1]);
        holder.awayThirdPer.setText(nbateam.get(position).getAwayteamPeriotScores()[2]);
        holder.awayFourthPer.setText(nbateam.get(position).getAwayteamPeriotScores()[3]);
        holder.awayOverTimePer.setText(nbateam.get(position).getAwayteamPeriotScores()[4]);
        holder.awayTeamTotalScore.setText(nbateam.get(position).getAwayTeamTotalScore());
        holder.awayTeamBestPlayer.setText(nbateam.get(position).getAwayTeamBesyPlayer());


        holder.upLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.subCardView.getVisibility()==View.VISIBLE)
                    holder.subCardView.setVisibility(View.GONE);
                else
                    holder.subCardView.setVisibility(View.VISIBLE);

            }
        });





    }

    @Override
    public int getItemCount() {

        return nbateam.size();
    }
}
