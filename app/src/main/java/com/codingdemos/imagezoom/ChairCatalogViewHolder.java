package com.codingdemos.imagezoom;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class ChairCatalogViewHolder extends GroupViewHolder{

        private TextView mTextView;
        private ImageView arrow;
        private ImageView photo;

        public ChairCatalogViewHolder(View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.textView);
            arrow = itemView.findViewById(R.id.arrow);
            photo = itemView.findViewById(R.id.image_catalog);
        }

        public void bind(ChairCatalog chairCatalog) {
            mTextView.setText(chairCatalog.getTitle());
            photo.setImageResource(chairCatalog.getItems().get(0).photo);
            //holder.image.setImageResource(chairImages.get(position));
        }

        @Override
        public void expand() {
            animateExpand();
        }

        @Override
        public void collapse() {
            animateCollapse();
        }

        private void animateExpand() {
            RotateAnimation rotate =
                    new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }

        private void animateCollapse() {
            RotateAnimation rotate =
                    new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }
    }

