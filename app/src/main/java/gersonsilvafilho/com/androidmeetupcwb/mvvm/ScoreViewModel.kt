package gersonsilvafilho.com.androidmeetupcwb.mvvm

import android.databinding.ObservableField
import gersonsilvafilho.com.androidmeetupcwb.model.Game
import gersonsilvafilho.com.androidmeetupcwb.model.GameRepository
import gersonsilvafilho.com.androidmeetupcwb.model.IGameRepository

/**
 * Created by Gerson Silva Filho on 17.06.18.
 */

class ScoreViewModel(val repository: IGameRepository = GameRepository()) {

    var resultLabel = ObservableField("")
    var nameTeam1 = ObservableField("")
    var nameTeam2 = ObservableField("")
    var yearLabel: String = ""

    fun getGame() {
        val year = yearLabel.toIntOrNull()
        if (year == null) {
            setError("Invalid year")
        } else {
            val game = repository.getGame(year)
            if (game == null) {
                setError("No game found for the selected year.")
            } else {
                setGame(game)
            }
        }
    }

    private fun setGame(game: Game) {
        resultLabel.set("${game.score1} : ${game.score2}")
        nameTeam1.set(game.team1)
        nameTeam2.set(game.team2)
    }

    private fun setError(error: String) {
        resultLabel.set(error)
        nameTeam1.set("")
        nameTeam2.set("")
    }
}