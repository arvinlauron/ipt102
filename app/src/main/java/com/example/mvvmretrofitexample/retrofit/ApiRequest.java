package com.example.mvvmretrofitexample.retrofit;

import static com.example.mvvmretrofitexample.constants.AppConstant.API_KEY;
import com.example.mvvmretrofitexample.response.ArticleResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("top-headlines?sources=techcrunch&apiKey="+API_KEY)
    Call<ArticleResponse> getTopHeadlines();
}
