package com.example.fetchcode.fetchcode

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fetchcode.data.api.FetchResponseCodeRepository
import com.example.fetchcode.data.vo.UUIDResponse
import com.example.fetchcode.utils.SharedPreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
open class MainActivityViewModel @Inject constructor(
    private val responseCodeRepository: FetchResponseCodeRepository,
    private val sharedPreferenceManager: SharedPreferenceManager
) :
    ViewModel(), SingleObserver<UUIDResponse> {

    var responseCodeLiveData = MutableLiveData<String>()
    var counterLiveData = MutableLiveData(0)

    fun fetchCode() {
        responseCodeRepository.fetchUUIDCode(this)
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onSuccess(t: UUIDResponse) {
        setResponseCode(t.response_code)
        incrementCounterValue()
        counterLiveData.value?.let {
            sharedPreferenceManager.saveInt(
                SharedPreferenceManager.COUNTER_KEY,
                it
            )
        }
    }

    override fun onError(e: Throwable) {
        //TODO Add toast for network error
    }

    fun setResponseCode(responseCode: String) {
        responseCodeLiveData.postValue(responseCode)
    }

    fun incrementCounterValue() {
        counterLiveData.postValue(counterLiveData.value?.plus(1))
    }

    fun setCounterValue(counterValue: Int) {
        counterLiveData.value = counterValue
    }

    fun initCounterValue() {
        val counterValue = sharedPreferenceManager.getInt(SharedPreferenceManager.COUNTER_KEY)
        setCounterValue(counterValue)
    }
}