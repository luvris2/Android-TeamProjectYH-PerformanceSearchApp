package com.luvris2.publicperfomancedisplayapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luvris2.publicperfomancedisplayapp.R;
import com.luvris2.publicperfomancedisplayapp.adapter.PostingAdapter;
import com.luvris2.publicperfomancedisplayapp.model.Posting;
import com.luvris2.publicperfomancedisplayapp.model.Review;

import java.util.ArrayList;

public class ReviewReadActivity extends AppCompatActivity {

    ImageView imgBack;
    TextView txtTitle;
    TextView txtContent;
    TextView txtNickname;
    TextView txtReviewListPrfName;
    ImageView imgVerifiedReview;

    PostingAdapter adapter;
    ArrayList<Posting> postingList = new ArrayList<>();

    private Review review;
    int reviewId;
    String reviewTitle;
    String reviewContent;
    String reviewNickname;
    String reviewPrfName;
    int reviewVerified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_read);

        review = (Review) getIntent().getSerializableExtra("reviewId");
        reviewPrfName = review.getPrfName();
        reviewNickname = review.getNickname();
        reviewTitle = review.getTitle();
        reviewContent = review.getContent();
        reviewVerified = review.getVerified();



        imgBack = findViewById(R.id.imgMoreReview);
        txtTitle = findViewById(R.id.txtReviewListTitle);
        txtContent = findViewById(R.id.txtContent);
        txtNickname = findViewById(R.id.txtNickname);
        txtReviewListPrfName = findViewById(R.id.txtReviewListPrfName);
        imgVerifiedReview = findViewById(R.id.imgVerifiedReview);



        txtTitle.setText(reviewTitle);
        txtContent.setText(reviewContent);
        txtNickname.setText("작성자: "+reviewNickname);
        txtReviewListPrfName.setText(reviewPrfName);
        if (reviewVerified != 0){
            imgVerifiedReview.setImageResource(R.drawable.ic_review_verified_yes);
        }

        ImageView imgBackReview;

        imgBackReview = findViewById(R.id.imgMoreReview);

        imgBackReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}