package com.example.mvvmretrofitexample.view;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.view.View;



import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mvvmretrofitexample.R;
import com.example.mvvmretrofitexample.adapter.ArticleAdapter;
import com.example.mvvmretrofitexample.model.Article;
import com.example.mvvmretrofitexample.view_model.ArticleViewModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private  static final  String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recycler_view;
    private ProgressBar progressBar;

    private LinearLayoutManager layoutManager;
    private  ArrayList<Article> articleArrayList= new ArrayList<>();
    ArticleViewModel articleViewModel;
    private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getArticles();
    }

    private void getArticles() {
        articleViewModel.getDashboardNewsResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null && articleResponse.getArticles() != null && !articleResponse.getArticles().isEmpty()) {
                progressBar.setVisibility(View.GONE);
                articleArrayList.addAll(articleResponse.getArticles());
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void init(){
        progressBar = findViewById(R.id.progress_bar);
        recycler_view = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recycler_view.setLayoutManager(layoutManager);

        recycler_view.setHasFixedSize(true);

        adapter = new ArticleAdapter(MainActivity.this, articleArrayList);
        recycler_view.setAdapter(adapter);
        articleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);

    }
}