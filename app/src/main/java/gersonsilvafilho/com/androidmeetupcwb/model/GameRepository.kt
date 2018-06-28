package gersonsilvafilho.com.androidmeetupcwb.model

class GameRepository : IGameRepository {
    override fun getGame(year: Int): Game? {
        return when (year) {
            2002 -> Game(2, "Brazil", 0, "Germany")
            2018 -> Game(0, "Germany", 1, "Brazil")
            else -> null
        }
    }
}