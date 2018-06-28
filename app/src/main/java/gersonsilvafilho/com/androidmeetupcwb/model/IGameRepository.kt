package gersonsilvafilho.com.androidmeetupcwb.model

interface IGameRepository {
    fun getGame(year: Int): Game?
}
