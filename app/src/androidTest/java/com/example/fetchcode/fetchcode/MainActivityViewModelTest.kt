package com.example.fetchcode.fetchcode

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class MainActivityViewModelTest {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun init() {
        mainActivityViewModel = mock(MainActivityViewModel::class.java)
        mainActivityViewModel.counterLiveData = MutableLiveData(0)
        mainActivityViewModel.responseCodeLiveData = MutableLiveData()
    }

    @Test
    fun test_Initial_Counter_Value_Is_Zero() {
        assertTrue(
            "Counter value is 0",
            mainActivityViewModel.counterLiveData.value == 0
        )
    }

    @Test
    fun test_Initial_Response_Code_Value_Empty() {
        assertTrue(
            "Initial Response code value Empty",
            mainActivityViewModel.responseCodeLiveData.value.isNullOrEmpty()
        )
    }

    @Test
    fun test_Counter_Value_Incremented() {
        val currentCounterValue = mainActivityViewModel.counterLiveData.value
        mainActivityViewModel.incrementCounterValue()
        val incrementedValue = mainActivityViewModel.counterLiveData.value
        assertTrue(currentCounterValue != incrementedValue)
    }
}