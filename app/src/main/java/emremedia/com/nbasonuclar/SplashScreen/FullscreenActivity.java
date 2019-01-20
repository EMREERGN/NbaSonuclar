package emremedia.com.nbasonuclar.SplashScreen;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import emremedia.com.nbasonuclar.Common.Common;
import emremedia.com.nbasonuclar.MainActivity;
import emremedia.com.nbasonuclar.Model.NbaResult;
import emremedia.com.nbasonuclar.Model.Team;
import emremedia.com.nbasonuclar.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    private View mContentView;
    List<NbaResult> nbaResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        windowsHideInıts();


        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2); // 1 gün önceki  veriler gelir
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        DateFormat cardDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        System.out.println(cardDateFormat.format(cal.getTime())); //2016/11/16 12:08:43

        StringBuilder sb = new StringBuilder();
        String adress = "https://www.cbssports.com/nba/scoreboard/"; // https://www.cbssports.com/nba/scoreboard/20190116/
        sb.append(adress);
        sb.append(dateFormat.format(cal.getTime())); //20190116
        sb.append("/");


        nbaResults =new ArrayList<>();

        new VeriGetir(sb.toString(), nbaResults).execute();



    }


    private void windowsHideInıts() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        mContentView=getWindow().getDecorView();
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


    public class VeriGetir extends AsyncTask<Void,Void,Void>
    {
        String url;
        List<NbaResult> nbaResults;

        public VeriGetir(String url, List<NbaResult> nbaResults) {
            this.url=url;
            this.nbaResults =nbaResults;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected Void doInBackground(Void... voids) {
            veriCek(url, nbaResults);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            Common.nbaResults= nbaResults;

            Intent intent =new Intent(FullscreenActivity.this,MainActivity.class);
            startActivity(intent);

        }


    }

    //todo verileri çekip listeye ekler
    private void veriCek(String url,List<NbaResult> nbaResults) {

        NbaResult match;
        Document document;
        // ynew variable
        String statusGame;

        String homeTeamName;
        String homeTeamWinLost;
        String homeTeamPeriotScores[];
        String homeTeamTotalScore;
        String homeTeamBesyPlayer;
        String awayTeamName;
        String awayTeamWinLost;
        String awayteamPeriotScores[];
        String awayTeamTotalScore;
        String awayTeamBesyPlayer;

        try {
            document = Jsoup.connect(url).get();

            Elements elements = document.select("div[class=live-update]");
            for (Element link : elements)
            {
                match =new NbaResult();
                awayteamPeriotScores = new String[5];
                homeTeamPeriotScores= new String[5];
                statusGame = link.select("div[class=game-status postgame]").text(); //Final or Final/OT
                match.setStatusGame(statusGame);

                Elements team = link.select("tbody").select("tr");
                int takim = 0;
                for (Element teams : team)
                {
                    String splitedStrings[] = teams.text().split(" ");

                    if (takim == 0) // home team
                    {
                        // todo Home Team Verileri atanır
                        homeTeamName = splitedStrings[0];


                        if(homeTeamName.contains("Trail"))   // trail blazers iki isimden oluştuğu için hata oluşması engellendi
                        {
                            homeTeamName=splitedStrings[0]+" "+splitedStrings[1]; // Trail Blazers
                            match.setHomeTeamName(homeTeamName);
                            homeTeamWinLost = splitedStrings[2];
                            match.setHomeTeamWinLost(homeTeamWinLost);
                            homeTeamPeriotScores[0] = splitedStrings[3]; // 1.periot
                            homeTeamPeriotScores[1] = splitedStrings[4]; // 2. periot
                            homeTeamPeriotScores[2] = splitedStrings[5]; // 3. periot
                            homeTeamPeriotScores[3] = splitedStrings[6]; // 4. periot
                            if (splitedStrings.length > 8) // overtime olmuştur
                            {
                                homeTeamPeriotScores[4] = splitedStrings[7]; // Over Time . periot
                                homeTeamTotalScore = splitedStrings[8];

                            } else // overtime olmamış ise
                            {
                                homeTeamPeriotScores[4] = " "; // 4. periot
                                homeTeamTotalScore = splitedStrings[7];
                            }
                            match.setHomeTeamTotalScore(homeTeamTotalScore);
                            match.setHomeTeamPeriotScores(homeTeamPeriotScores);
                        }
                        else
                        {
                            match.setHomeTeamName(homeTeamName);

                            homeTeamWinLost = splitedStrings[1];
                            match.setHomeTeamWinLost(homeTeamWinLost);

                            homeTeamPeriotScores[0] = splitedStrings[2]; // 1.periot
                            homeTeamPeriotScores[1] = splitedStrings[3]; // 2. periot
                            homeTeamPeriotScores[2] = splitedStrings[4]; // 3. periot
                            homeTeamPeriotScores[3] = splitedStrings[5]; // 4. periot
                            if (splitedStrings.length > 7) // overtime olmuştur
                            {
                                homeTeamPeriotScores[4] = splitedStrings[6]; // Over Time . periot
                                homeTeamTotalScore = splitedStrings[7];

                            } else // overtime olmamış ise
                            {
                                homeTeamPeriotScores[4] = " "; // 4. periot
                                homeTeamTotalScore = splitedStrings[6];

                            }
                            match.setHomeTeamTotalScore(homeTeamTotalScore);
                            match.setHomeTeamPeriotScores(homeTeamPeriotScores);
                        }
                    }


                    if (takim == 1) // away team
                    {
                        // todo Home Team Verileri atanır
                        awayTeamName = splitedStrings[0];

                        if(awayTeamName.contains("Trail"))  // trail blazers iki isimden oluştuğu için hata oluşması engellendi
                        {
                            awayTeamName=splitedStrings[0]+" "+splitedStrings[1];
                            match.setAwayTeamName(awayTeamName);

                            awayTeamWinLost = splitedStrings[2];
                            match.setAwayTeamWinLost(awayTeamWinLost);

                            awayteamPeriotScores[0] = splitedStrings[3]; // 1.periot
                            awayteamPeriotScores[1] = splitedStrings[4]; // 2. periot
                            awayteamPeriotScores[2] = splitedStrings[5]; // 3. periot
                            awayteamPeriotScores[3] = splitedStrings[6]; // 4. periot
                            if (splitedStrings.length > 8) // overtime olmuştur
                            {
                                awayteamPeriotScores[4] = splitedStrings[7]; // Overtime. periot
                                awayTeamTotalScore = splitedStrings[8];

                            } else // overtime olmamış ise
                            {
                                awayteamPeriotScores[4] = ""; // 4. periot
                                awayTeamTotalScore = splitedStrings[7];

                            }
                            match.setAwayteamPeriotScores(awayteamPeriotScores);
                            match.setAwayTeamTotalScore(awayTeamTotalScore);
                        }
                        else
                        {
                            match.setAwayTeamName(awayTeamName);

                            awayTeamWinLost = splitedStrings[1];
                            match.setAwayTeamWinLost(awayTeamWinLost);

                            awayteamPeriotScores[0] = splitedStrings[2]; // 1.periot
                            awayteamPeriotScores[1] = splitedStrings[3]; // 2. periot
                            awayteamPeriotScores[2] = splitedStrings[4]; // 3. periot
                            awayteamPeriotScores[3] = splitedStrings[5]; // 4. periot
                            if (splitedStrings.length > 7) // overtime olmuştur
                            {
                                awayteamPeriotScores[4] = splitedStrings[6]; // Overtime. periot
                                awayTeamTotalScore = splitedStrings[7];

                            } else // overtime olmamış ise
                            {
                                awayteamPeriotScores[4] = ""; // 4. periot
                                awayTeamTotalScore = splitedStrings[6];

                            }
                            match.setAwayteamPeriotScores(awayteamPeriotScores);
                            match.setAwayTeamTotalScore(awayTeamTotalScore);
                        }

                    }
                    if (takim == 2)//  home team best player
                    {
                        homeTeamBesyPlayer=teams.text();
                        match.setHomeTeamBesyPlayer(homeTeamBesyPlayer);
                    }
                    if (takim == 3) //away team best player
                    {
                        awayTeamBesyPlayer=teams.text();
                        match.setAwayTeamBesyPlayer(awayTeamBesyPlayer);
                    }

                    takim++;


                }

                nbaResults.add(match);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
