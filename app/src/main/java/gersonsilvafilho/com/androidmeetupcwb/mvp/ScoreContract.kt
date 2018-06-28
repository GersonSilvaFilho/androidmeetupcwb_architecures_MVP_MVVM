package gersonsilvafilho.com.androidmeetupcwb.mvp

interface ScoreContract {
    interface View {
        fun showGame(placar: String)
        fun setTeam1(team1: String)
        fun setTeam2(team2: String)
        fun showError(error: String)
    }

    interface Presenter {
        fun getGame(yearText: String)
    }
}