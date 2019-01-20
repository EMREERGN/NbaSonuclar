package emremedia.com.nbasonuclar.Model;

public class NbaResult {

    private String statusGame;
    private String homeTeamName;
    private String homeTeamWinLost;
    private String homeTeamPeriotScores[] = new String[5];
    private String homeTeamTotalScore;
    private String homeTeamBesyPlayer;

    private String awayTeamName;
    private String awayTeamWinLost;
    private String awayteamPeriotScores[] = new String[5];
    private String awayTeamTotalScore;
    private String awayTeamBesyPlayer;

    public NbaResult() {
    }

    public NbaResult(String statusGame, String homeTeamName, String homeTeamWinLost, String[] homeTeamPeriotScores, String homeTeamTotalScore, String homeTeamBesyPlayer, String awayTeamName, String awayTeamWinLost, String[] awayteamPeriotScores, String awayTeamTotalScore, String awayTeamBesyPlayer) {
        this.statusGame = statusGame;
        this.homeTeamName = homeTeamName;
        this.homeTeamWinLost = homeTeamWinLost;
        this.homeTeamPeriotScores = homeTeamPeriotScores;
        this.homeTeamTotalScore = homeTeamTotalScore;
        this.homeTeamBesyPlayer = homeTeamBesyPlayer;
        this.awayTeamName = awayTeamName;
        this.awayTeamWinLost = awayTeamWinLost;
        this.awayteamPeriotScores = awayteamPeriotScores;
        this.awayTeamTotalScore = awayTeamTotalScore;
        this.awayTeamBesyPlayer = awayTeamBesyPlayer;
    }

    public String getStatusGame() {
        return statusGame;
    }

    public void setStatusGame(String statusGame) {
        this.statusGame = statusGame;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getHomeTeamWinLost() {
        return homeTeamWinLost;
    }

    public void setHomeTeamWinLost(String homeTeamWinLost) {
        this.homeTeamWinLost = homeTeamWinLost;
    }

    public String[] getHomeTeamPeriotScores() {
        return homeTeamPeriotScores;
    }

    public void setHomeTeamPeriotScores(String[] homeTeamPeriotScores) {
        this.homeTeamPeriotScores = homeTeamPeriotScores;
    }

    public String getHomeTeamTotalScore() {
        return homeTeamTotalScore;
    }

    public void setHomeTeamTotalScore(String homeTeamTotalScore) {
        this.homeTeamTotalScore = homeTeamTotalScore;
    }

    public String getHomeTeamBesyPlayer() {
        return homeTeamBesyPlayer;
    }

    public void setHomeTeamBesyPlayer(String homeTeamBesyPlayer) {
        this.homeTeamBesyPlayer = homeTeamBesyPlayer;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getAwayTeamWinLost() {
        return awayTeamWinLost;
    }

    public void setAwayTeamWinLost(String awayTeamWinLost) {
        this.awayTeamWinLost = awayTeamWinLost;
    }

    public String[] getAwayteamPeriotScores() {
        return awayteamPeriotScores;
    }

    public void setAwayteamPeriotScores(String[] awayteamPeriotScores) {
        this.awayteamPeriotScores = awayteamPeriotScores;
    }

    public String getAwayTeamTotalScore() {
        return awayTeamTotalScore;
    }

    public void setAwayTeamTotalScore(String awayTeamTotalScore) {
        this.awayTeamTotalScore = awayTeamTotalScore;
    }

    public String getAwayTeamBesyPlayer() {
        return awayTeamBesyPlayer;
    }

    public void setAwayTeamBesyPlayer(String awayTeamBesyPlayer) {
        this.awayTeamBesyPlayer = awayTeamBesyPlayer;
    }
}
