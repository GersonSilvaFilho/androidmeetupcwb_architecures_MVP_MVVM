package gersonsilvafilho.com.androidmeetupcwb.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import gersonsilvafilho.com.androidmeetupcwb.R
import kotlinx.android.synthetic.main.activity_score_mvp.*

class ScoreActivityMvp : AppCompatActivity(), ScoreContract.View {

    lateinit var presenter: ScoreContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_mvp)

        //Should be injected
        presenter = ScorePresenter(this)
        setButtonClick()
    }

    private fun setButtonClick() {
        buttonGetGame.setOnClickListener { presenter.getGame(editTextYear.text.toString()) }
    }

    override fun showGame(placar: String) {
        textViewResult.text = placar
    }

    override fun setTeam1(team1: String) {
        textViewTeam1.text = team1
    }

    override fun setTeam2(team2: String) {
        textViewTeam2.text = team2
    }

    override fun showError(error: String) {
        textViewResult.text = error
    }


}
