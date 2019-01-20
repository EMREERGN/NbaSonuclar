package emremedia.com.nbasonuclar.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import emremedia.com.nbasonuclar.R;

/**
 * Created by EMRE on 25.12.2018.
 */

public class NbaViewHolder extends RecyclerView.ViewHolder {

    LinearLayout subCardView;
    LinearLayout upLayout;
    TextView matchStatus;

    ImageView homeTeamImage;
    TextView homeTeamName;
    TextView homeWinLost;
    TextView homeTeamTotalScore;
    TextView homeFirstPer;
    TextView homeSecondPer;
    TextView homeThirdPer;
    TextView homeFourthPer;
    TextView homeOverTimePer;
    TextView homeTeamBestPlayer;

    ImageView awayTeamImage;
    TextView awayTeamName;
    TextView awayWinLost;
    TextView awayTeamTotalScore;
    TextView awayFirstPer;
    TextView awaySecondPer;
    TextView awayThirdPer;
    TextView awayFourthPer;
    TextView awayOverTimePer;
    TextView awayTeamBestPlayer;



    public NbaViewHolder(View itemView) {
        super(itemView);

        subCardView=(LinearLayout)itemView.findViewById(R.id.subCardViewLinearLayout);
        upLayout=(LinearLayout)itemView.findViewById(R.id.upLayout);

        matchStatus=(TextView)itemView.findViewById(R.id.matchStatus);

        homeTeamImage=(ImageView)itemView.findViewById(R.id.homeTeamImage);
        homeTeamName=(TextView)itemView.findViewById(R.id.homeTeamName);
        homeWinLost=(TextView)itemView.findViewById(R.id.homeTeamWinLost);
        homeTeamTotalScore =(TextView)itemView.findViewById(R.id.homeTeamTotalScore);
        homeFirstPer=(TextView)itemView.findViewById(R.id.homeFirstPer);
        homeSecondPer=(TextView)itemView.findViewById(R.id.homeSecondPer);
        homeThirdPer=(TextView)itemView.findViewById(R.id.homeThirdPer);
        homeFourthPer=(TextView)itemView.findViewById(R.id.homeFourthPer);
        homeOverTimePer=(TextView)itemView.findViewById(R.id.homeOverTimePer);
        homeTeamBestPlayer=(TextView)itemView.findViewById(R.id.homeTeamBestPlayer);

        awayTeamImage=(ImageView)itemView.findViewById(R.id.awayTeamImage);
        awayTeamName=(TextView)itemView.findViewById(R.id.awayTeamName);
        awayWinLost=(TextView)itemView.findViewById(R.id.awayTeamWinLost);
        awayTeamTotalScore =(TextView)itemView.findViewById(R.id.awayTeamTotalScore);
        awayFirstPer=(TextView)itemView.findViewById(R.id.awayFirstPer);
        awaySecondPer=(TextView)itemView.findViewById(R.id.awaySecondPer);
        awayThirdPer=(TextView)itemView.findViewById(R.id.awayThirdPer);
        awayFourthPer=(TextView)itemView.findViewById(R.id.awayFourthPer);
        awayOverTimePer=(TextView)itemView.findViewById(R.id.awayOverTimePer);
        awayTeamBestPlayer=(TextView)itemView.findViewById(R.id.awayTeamBestPlayer);





    }
}


