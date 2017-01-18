package com.pj.mvp.api;

import com.pj.mvp.model.SessionRequest;
import com.pj.mvp.model.SessionResult;
import com.pj.mvp.model.base.HttpResult;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pj on 17/01/12 012.
 */

public interface HttpApiService {

    @POST("/api/mc/login")
    Observable<HttpResult<SessionResult>> getSession(@Body SessionRequest request);
}
