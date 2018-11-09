package com.laioffer.tinnews.retrofit;

import com.laioffer.tinnews.retrofit.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsRequestApi {
    @GET("top-headlines")
    //ovservable is
    Observable<BaseResponse> getNewsByCountry(@Query("country") String country);
}
