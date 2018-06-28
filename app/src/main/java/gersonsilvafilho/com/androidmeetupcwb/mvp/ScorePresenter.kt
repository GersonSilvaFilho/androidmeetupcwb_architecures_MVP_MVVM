package gersonsilvafilho.com.androidmeetupcwb.mvp

import gersonsilvafilho.com.androidmeetupcwb.model.Game
import gersonsilvafilho.com.androidmeetupcwb.model.GameRepository
import gersonsilvafilho.com.androidmeetupcwb.model.IGameRepository

class ScorePresenter(
    val view: ScoreContract.View,
    val repository: IGameRepository = GameRepository()
) : ScoreContract.Presenter {

    override fun getGame(yearText: String) {
        val year = yearText.toIntOrNull()
        if (year == null) {
            showError("Invalid year")
        } else {
            val game = repository.getGame(year)
            if (game == null) {
                showError("No game found for the selected year.")
            } else {
                setGame(game)
            }
        }
    }

    private fun showError(error: String) {
        view.showError(error)
        view.setTeam1("")
        view.setTeam2("")
    }

    private fun setGame(game: Game) {
        view.showGame("${game.score1} : ${game.score2}")
        view.setTeam1(game.team1)
        view.setTeam2(game.team2)
    }
}