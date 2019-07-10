package com.codingdemos.imagezoom;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ChairViewHolder extends ChildViewHolder {

        private TextView mTextView;
        private ImageView mImageView;

        public ChairViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
            mImageView = itemView.findViewById(R.id.image_chair);
        }

        public void bind(Chair chair) {
            mTextView.setText(chair.name);
            mImageView.setImageResource(chair.photo);
        }





    }

