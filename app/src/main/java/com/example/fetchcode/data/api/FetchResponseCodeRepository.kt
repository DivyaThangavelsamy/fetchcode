package com.example.fetchcode.data.api

import com.example.fetchcode.data.vo.UUIDResponse
import io.reactivex.SingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FetchResponseCodeRepository @Inject constructor(
    private val webservice: Webservice,
) {

    fun fetchUUIDCode(observer: SingleObserver<UUIDResponse>) {
        val nextPathObservable = webservice.getNextPath()
        val responseCodeObservable =
            nextPathObservable.flatMap { nextPathResponse ->
                webservice.getUUID(
                    nextPathResponse.next_path
                )
            }
        responseCodeObservable.subscribeOn(Schedulers.io())
            .subscribe(observer)
    }
}