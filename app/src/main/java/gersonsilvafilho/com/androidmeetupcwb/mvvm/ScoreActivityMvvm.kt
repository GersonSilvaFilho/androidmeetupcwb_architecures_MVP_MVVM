package gersonsilvafilho.com.androidmeetupcwb.mvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import gersonsilvafilho.com.androidmeetupcwb.R
import gersonsilvafilho.com.androidmeetupcwb.databinding.ActivityScoreMvvmBinding

class ScoreActivityMvvm : AppCompatActivity() {

    lateinit var binding: ActivityScoreMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_score_mvvm
        )

        //To be injected
        binding.vm = ScoreViewModel()
    }

}
