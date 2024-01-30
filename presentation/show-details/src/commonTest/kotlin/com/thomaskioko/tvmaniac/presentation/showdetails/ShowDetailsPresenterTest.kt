package com.thomaskioko.tvmaniac.presentation.showdetails

import com.thomaskioko.tvmaniac.presentation.showdetails.ShowDetailsState.Companion.EMPTY_DETAIL_STATE
import com.thomaskioko.tvmaniac.seasons.testing.FakeSeasonsRepository
import com.thomaskioko.tvmaniac.similar.testing.FakeSimilarShowsRepository
import com.thomaskioko.tvmaniac.trailers.testing.FakeTrailerRepository
import com.thomaskioko.tvmaniac.trailers.testing.trailers
import com.thomaskioko.tvmaniac.util.model.Either
import com.thomaskioko.tvmaniac.util.model.ServerError
import com.thomaskioko.tvmaniac.watchlist.testing.FakeLibraryRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Ignore
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
@Ignore
internal class ShowDetailsPresenterTest {

    private val seasonsRepository = FakeSeasonsRepository()
    private val trailerRepository = FakeTrailerRepository()
    private val similarShowsRepository = FakeSimilarShowsRepository()
    private val fakeLibraryRepository = FakeLibraryRepository()
    private val testDispatcher = StandardTestDispatcher()

    private lateinit var presenter: ShowDetailsPresenter

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        /*     presenter = ShowDetailsPresenter(
                 traktShowId = 84958,
                 discoverRepository = discoverRepository,
                 trailerRepository = trailerRepository,
                 seasonsRepository = seasonsRepository,
                 similarShowsRepository = similarShowsRepository,
                 libraryRepository = fakeLibraryRepository,
             )*/
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun initial_state_emits_expected_result() = runTest {
        presenter.value shouldBe EMPTY_DETAIL_STATE.copy(
            showDetails = similarShow,
        )
    }

    @Test
    fun loadingData_state_emits_expected_result() = runTest {
        seasonsRepository.setSeasonsResult(Either.Right(seasons))
        similarShowsRepository.setSimilarShowsResult(Either.Right(similarShowResult))
        trailerRepository.setTrailerResult(Either.Right(trailers))

        presenter.value shouldBe EMPTY_DETAIL_STATE
        presenter.value shouldBe showDetailsLoaded
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
        )
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
            trailersList = trailerPersistentList,
        )
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
            trailersList = trailerPersistentList,
            similarShows = similarShowList,
        )
    }

    @Test
    fun error_loading_similarShows_emits_expected_result() = runTest {
        val errorMessage = "Something went wrong"
        seasonsRepository.setSeasonsResult(Either.Right(seasons))
        trailerRepository.setTrailerResult(Either.Right(trailers))
        similarShowsRepository.setSimilarShowsResult(Either.Left(ServerError(errorMessage)))

        presenter.value shouldBe EMPTY_DETAIL_STATE
        presenter.value shouldBe showDetailsLoaded
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
        )
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
            trailersList = trailerPersistentList,
        )
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
            trailersList = trailerPersistentList,
            errorMessage = errorMessage,
        )
    }

    @Test
    fun error_loading_trailers_emits_expected_result() = runTest {
        val errorMessage = "Something went wrong"
        seasonsRepository.setSeasonsResult(Either.Right(seasons))
        similarShowsRepository.setSimilarShowsResult(Either.Right(similarShowResult))
        trailerRepository.setTrailerResult(Either.Left(ServerError(errorMessage)))

        presenter.value shouldBe EMPTY_DETAIL_STATE
        presenter.value shouldBe showDetailsLoaded
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
        )
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
            errorMessage = errorMessage,
        )
        presenter.value shouldBe showDetailsLoaded.copy(
            seasonsList = seasonPersistentList,
            similarShows = similarShowList,
            errorMessage = errorMessage,
        )
    }

    @Test
    fun error_loading_seasons_emits_expected_result() = runTest {
        val errorMessage = "Something went wrong"
        similarShowsRepository.setSimilarShowsResult(Either.Right(similarShowResult))
        trailerRepository.setTrailerResult(Either.Right(trailers))

        presenter.value shouldBe EMPTY_DETAIL_STATE
        /*   presenter.state shouldBe showDetailsLoaded.copy(
               seasonsContent = EMPTY_SEASONS.copy(
                   errorMessage = errorMessage,
               ),
           )
           presenter.state shouldBe showDetailsLoaded.copy(
               seasonsContent = EMPTY_SEASONS.copy(
                   errorMessage = errorMessage,
               ),
               trailersContent = trailerShowDetailsLoaded,
           )
           presenter.state shouldBe showDetailsLoaded.copy(
               seasonsContent = EMPTY_SEASONS.copy(
                   errorMessage = errorMessage,
               ),
               trailersContent = trailerShowDetailsLoaded,
               similarShowsContent = similarShowLoaded,
           )*/
    }

    @Test
    fun error_state_emits_expected_result() = runTest {
        val errorMessage = "Something went wrong"
        similarShowsRepository.setSimilarShowsResult(Either.Right(similarShowResult))
        trailerRepository.setTrailerResult(Either.Right(trailers))
        seasonsRepository.setSeasonsResult(Either.Right(seasons))

        presenter.value shouldBe EMPTY_DETAIL_STATE
        presenter.value shouldBe EMPTY_DETAIL_STATE.copy(
            errorMessage = errorMessage,
        )
    }
}
