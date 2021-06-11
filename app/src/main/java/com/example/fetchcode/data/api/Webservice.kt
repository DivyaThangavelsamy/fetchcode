package com.example.fetchcode.data.api

import com.example.fetchcode.data.vo.NextPathResponse
import com.example.fetchcode.data.vo.UUIDResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface Webservice {

    @GET(Constants.BASE_URL)
    fun getNextPath(): Single<NextPathResponse>

    @GET
    fun getUUID(@Url nextPathUrl: String): Single<UUIDResponse>

}