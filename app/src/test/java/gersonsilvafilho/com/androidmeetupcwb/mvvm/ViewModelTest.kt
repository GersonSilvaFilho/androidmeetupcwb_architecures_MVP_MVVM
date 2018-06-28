package gersonsilvafilho.com.androidmeetupcwb.mvvm

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import gersonsilvafilho.com.androidmeetupcwb.model.Game
import gersonsilvafilho.com.androidmeetupcwb.model.IGameRepository
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test


/**
 * Created by Gerson Silva Filho on 21.06.18.
 */
class ViewModelTest {

    val repositoryMock: IGameRepository = mock()
    lateinit var viewModel: ScoreViewModel

    @Before
    fun setup() {
        viewModel = ScoreViewModel(repositoryMock)
    }


    @Test
    fun `test game found`() {
        val game = Game(1, "Brasil", 0, "Germany")
        whenever(repositoryMock.getGame(any())).thenReturn(game)
        viewModel.yearLabel = "1991"
        viewModel.getGame()

        assertEquals(viewModel.nameTeam1.get(), game.team1)
        assertEquals(viewModel.nameTeam2.get(), game.team2)
        assertEquals(viewModel.resultLabel.get(), "1 : 0")
    }

    @Test
    fun `tests game not Found`() {
        whenever(repositoryMock.getGame(any())).thenReturn(null)
        viewModel.yearLabel = "1991"
        viewModel.getGame()

        assertEquals(viewModel.nameTeam1.get(), "")
        assertEquals(viewModel.nameTeam2.get(), "")
        assertEquals(viewModel.resultLabel.get(), "No game found for the selected year.")
    }

    @Test
    fun `tests invalid year`() {
        whenever(repositoryMock.getGame(any())).thenReturn(null)
        viewModel.yearLabel = "test not year"
        viewModel.getGame()
        assertEquals(viewModel.nameTeam1.get(), "")
        assertEquals(viewModel.nameTeam2.get(), "")
        assertEquals(viewModel.resultLabel.get(), "Invalid year")
    }
}