package com.example.mvvmretrofitexample.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmretrofitexample.repository.ArticleRepository;
import com.example.mvvmretrofitexample.response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    //constructor
    public ArticleViewModel(@NonNull Application application) {
        super(application);
        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashBoardNews();
    }

    //method
    public LiveData<ArticleResponse> getDashboardNewsResponseLiveData(){
        return articleResponseLiveData;
    }
}
