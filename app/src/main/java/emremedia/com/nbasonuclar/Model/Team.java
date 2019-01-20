package emremedia.com.nbasonuclar.Model;

/**
 * Created by EMRE on 7.05.2018.
 */

public class Team {
    private String teamHomeImage;
    private String teamHomeName;
    private String teamHomeScore;

    private String teamAwayImage;
    private String teamAwayName;
    private String teamAwayScore;

    public Team() {
    }

    public Team(String teamHomeImage, String teamHomeName, String teamHomeScore, String teamAwayImage, String teamAwayName, String teamAwayScore) {
        this.teamHomeImage = teamHomeImage;
        this.teamHomeName = teamHomeName;
        this.teamHomeScore = teamHomeScore;
        this.teamAwayImage = teamAwayImage;
        this.teamAwayName = teamAwayName;
        this.teamAwayScore = teamAwayScore;
    }

    public String getTeamAwayImage() {
        return teamAwayImage;
    }

    public void setTeamAwayImage(String teamAwayImage) {
        this.teamAwayImage = teamAwayImage;
    }

    public String getTeamAwayName() {
        return teamAwayName;
    }

    public void setTeamAwayName(String teamAwayName) {
        this.teamAwayName = teamAwayName;
    }

    public String getTeamAwayScore() {
        return teamAwayScore;
    }

    public void setTeamAwayScore(String teamAwayScore) {
        this.teamAwayScore = teamAwayScore;
    }

    public String getTeamHomeImage() {
        return teamHomeImage;
    }

    public void setTeamHomeImage(String teamHomeImage) {
        this.teamHomeImage = teamHomeImage;
    }

    public String getTeamHomeName() {
        return teamHomeName;
    }

    public void setTeamHomeName(String teamHomeName) {
        this.teamHomeName = teamHomeName;
    }

    public String getTeamHomeScore() {
        return teamHomeScore;
    }

    public void setTeamHomeScore(String teamHomeScore) {
        this.teamHomeScore = teamHomeScore;
    }
}
