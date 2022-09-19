package com.luvris2.publicperfomancedisplayapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.luvris2.publicperfomancedisplayapp.R;
import com.luvris2.publicperfomancedisplayapp.model.Review;
import com.luvris2.publicperfomancedisplayapp.ui.ReviewReadActivity;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    Context context;
    List<Review> reviewList;

    int reviewVerified;

    public ReviewAdapter(Context context, List<Review> reviewList) {
        this.context = context;
        this.reviewList = reviewList;
    }

    // layout 임시 list_row
    // 테스트가 끝나면 posting_row로 수정할것!!
    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // posting_row
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.posting_row, parent, false);

        // list_row
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_list_row, parent, false);
        return new ReviewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {
        Review review = reviewList.get(position);
        //review_list_row
        holder.txtReviewListTitle.setText(review.getTitle());
        holder.txtReviewListContent.setText(review.getContent());
        holder.txtReviewListName.setText(review.getNickname());
        reviewVerified = review.getVerified();
        if (reviewVerified != 0) {
            holder.imgReviewListVerified.setImageResource(R.drawable.ic_review_verified_yes);
        }
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //list_row
        CardView cardView;
        TextView txtReviewListTitle;
        TextView txtReviewListContent;
        TextView txtReviewListName;
        ImageView imgReviewListVerified;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //list_row
            cardView = itemView.findViewById(R.id.cardView);
            txtReviewListTitle = itemView.findViewById(R.id.txtReviewListTitle);
            txtReviewListContent = itemView.findViewById(R.id.txtReviewListContent);
            txtReviewListName = itemView.findViewById(R.id.txtReviewListName);
            imgReviewListVerified = itemView.findViewById(R.id.imgReviewListVerified);

            // 카드뷰를 클릭하면 글의 위치 정보를 넘겨준다.
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 전체 글 중 선택한 글의 위치 정보를 가져온다
                    int index = getAdapterPosition();
                    Review reviewId = reviewList.get(index);

                    // 전체 글 상세보기의 액티비티에 정보를 넘겨준다.
                    Intent intent = new Intent(context, ReviewReadActivity.class);
                    intent.putExtra("reviewId" ,  reviewId);

                    context.startActivity(intent);

                }
            });
        }
    }
}
