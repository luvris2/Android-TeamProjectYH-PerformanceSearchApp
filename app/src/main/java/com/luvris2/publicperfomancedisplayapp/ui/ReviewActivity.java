package com.luvris2.publicperfomancedisplayapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luvris2.publicperfomancedisplayapp.R;
import com.luvris2.publicperfomancedisplayapp.adapter.ReviewAdapter;
import com.luvris2.publicperfomancedisplayapp.api.NetworkClient;
import com.luvris2.publicperfomancedisplayapp.api.ReviewApi;
import com.luvris2.publicperfomancedisplayapp.model.Review;
import com.luvris2.publicperfomancedisplayapp.model.Review;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ReviewActivity extends AppCompatActivity {

    ImageView imgBoardPosting;
    ImageView imgBack;
    TextView txtEventTitle;
    RecyclerView recyclerView;

    // 어댑터, 리스트
    ReviewAdapter adapter;
    ArrayList<Review> reviewList = new ArrayList<>();

    // 페이징에 필요한 멤버변수
    int offset = 0;
    int limit = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        imgBoardPosting = findViewById(R.id.imgBoardPosting);
        imgBack = findViewById(R.id.imgMoreReview);
        txtEventTitle = findViewById(R.id.txtEventTitle);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ReviewActivity.this));

        imgBoardPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewActivity.this, MyReviewWriteActivity.class);
                startActivity(intent);
                finish();
            }
        });


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 네트워크로 부터 데이터 가져온다.
        getNetworkData();

    }

    private void getNetworkData() {
        reviewList.clear();
        offset = 0;
        limit = 25;

        Retrofit retrofit = NetworkClient.getRetrofitClient(ReviewActivity.this);
        ReviewApi api = retrofit.create(ReviewApi.class);

        Call<Review> call = api.getReviewAll(offset, limit);

        call.enqueue(new Callback<Review>() {
            @Override
            public void onResponse(Call<Review> call, Response<Review> response) {

                if(response.isSuccessful()){

                    reviewList.addAll( response.body().getResultList() );

                    adapter = new ReviewAdapter(ReviewActivity.this, reviewList);

                    adapter.notifyDataSetChanged();

                    recyclerView.setAdapter(adapter);

                }else{

                }

            }

            @Override
            public void onFailure(Call<Review> call, Throwable t) {
            }
        });

    }
}

