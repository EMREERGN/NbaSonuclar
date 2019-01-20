package emremedia.com.nbasonuclar.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import emremedia.com.nbasonuclar.GetIcon;
import emremedia.com.nbasonuclar.Model.MatchResult;
import emremedia.com.nbasonuclar.R;

public class NbaViewAdapter extends RecyclerView.Adapter<NbaViewHolder>{

    private Context context;
    private List<MatchResult> thisMatch;

    public NbaViewAdapter(Context context, List<MatchResult> thisMatch) {
        this.context = context;
        this.thisMatch = thisMatch;
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

        holder.matchStatus.setText(thisMatch.get(position).getStatusGame());

        holder.homeTeamImage.setImageResource(icon.GetIcon(thisMatch.get(position).getHomeTeamName())); //Heat -> image name olso team name
        holder.homeTeamName.setText(thisMatch.get(position).getHomeTeamName());
        holder.homeWinLost.setText(thisMatch.get(position).getHomeTeamWinLost());
        holder.homeTeamTotalScore.setText(thisMatch.get(position).getHomeTeamTotalScore());
        holder.homeFirstPer.setText(thisMatch.get(position).getHomeTeamPeriotScores()[0]);
        holder.homeSecondPer.setText(thisMatch.get(position).getHomeTeamPeriotScores()[1]);
        holder.homeThirdPer.setText(thisMatch.get(position).getHomeTeamPeriotScores()[2]);
        holder.homeFourthPer.setText(thisMatch.get(position).getHomeTeamPeriotScores()[3]);
        holder.homeOverTimePer.setText(thisMatch.get(position).getHomeTeamPeriotScores()[4]);
        holder.homeTeamTotalScore.setText(thisMatch.get(position).getHomeTeamTotalScore());
        holder.homeTeamBestPlayer.setText(thisMatch.get(position).getHomeTeamBesyPlayer());

        holder.awayTeamImage.setImageResource(icon.GetIcon(thisMatch.get(position).getAwayTeamName())); //Bulls -> image name olso team name
        holder.awayTeamName.setText(thisMatch.get(position).getAwayTeamName());
        holder.awayWinLost.setText(thisMatch.get(position).getAwayTeamWinLost());
        holder.awayTeamTotalScore.setText(thisMatch.get(position).getAwayTeamTotalScore());
        holder.awayFirstPer.setText(thisMatch.get(position).getAwayteamPeriotScores()[0]);
        holder.awaySecondPer.setText(thisMatch.get(position).getAwayteamPeriotScores()[1]);
        holder.awayThirdPer.setText(thisMatch.get(position).getAwayteamPeriotScores()[2]);
        holder.awayFourthPer.setText(thisMatch.get(position).getAwayteamPeriotScores()[3]);
        holder.awayOverTimePer.setText(thisMatch.get(position).getAwayteamPeriotScores()[4]);
        holder.awayTeamTotalScore.setText(thisMatch.get(position).getAwayTeamTotalScore());
        holder.awayTeamBestPlayer.setText(thisMatch.get(position).getAwayTeamBesyPlayer());


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

        return thisMatch.size();
    }
}
