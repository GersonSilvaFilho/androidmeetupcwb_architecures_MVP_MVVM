package gersonsilvafilho.com.androidmeetupcwb.mvp

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import gersonsilvafilho.com.androidmeetupcwb.model.Game
import gersonsilvafilho.com.androidmeetupcwb.model.IGameRepository
import org.junit.Before
import org.junit.Test


/**
 * Created by Gerson Silva Filho on 21.06.18.
 */
class PresenterTest {

    val repositoryMock: IGameRepository = mock()
    val viewMock: ScoreContract.View = mock()
    lateinit var presenter: ScorePresenter

    @Before
    fun setup() {
        presenter = ScorePresenter(viewMock, repositoryMock)
    }


    @Test
    fun `test game found`() {
        val game = Game(1, "Brasil", 0, "Germany")
        whenever(repositoryMock.getGame(any())).thenReturn(game)
        presenter.getGame("1991")
        verify(viewMock).setTeam1(game.team1)
        verify(viewMock).setTeam2(game.team2)
        verify(viewMock).showGame("1 : 0")
    }

    @Test
    fun `tests game not Found`() {
        whenever(repositoryMock.getGame(any())).thenReturn(null)
        presenter.getGame("1992")
        verify(viewMock).setTeam1("")
        verify(viewMock).setTeam2("")
        verify(viewMock).showError("No game found for the selected year.")
    }

    @Test
    fun `tests invalid year`() {
        whenever(repositoryMock.getGame(any())).thenReturn(null)
        presenter.getGame("test not year")
        verify(viewMock).setTeam1("")
        verify(viewMock).setTeam2("")
        verify(viewMock).showError("Invalid year")
    }
}