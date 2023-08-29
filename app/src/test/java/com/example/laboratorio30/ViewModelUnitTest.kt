package com.example.laboratorio30

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class ViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun viewModel_CheckInitialValue() = runTest {

        var value = viewModel.comparadorResultado.value
    }

    @Test
    fun viewModel_TestcomparadorResultado() = runTest {
        launch {
            viewModel.comparadorResultado
        }
        advanceUntilIdle()
        val value = viewModel.comparadorResultado.value

    }

    @Test
    fun viewModel_TestcomparadorTexto() = runTest {
        launch {
            advanceUntilIdle()

            val value = viewModel.comparadorTexto("123", "123")
            assertEquals(true, viewModel.comparadorResultado.value)

            viewModel.comparadorTexto("123", "1234")
            assertEquals(false, viewModel.comparadorResultado.value)
        }
    }
}

