package com.example.recyclerview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;




public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        String[] titles = null;
        int[] images = null;


        ////////////////아이템 클릭 처리를 위해 추가가 필요한 코드///////////////////////////////////////////////////////
        //OnItemClickListener 인터페이스 선언
        public interface  OnItemClickListener {
                void onItemClicked(int pos, String data);
        }
        private OnItemClickListener itemClickListener;
        public void setOnItemClickListener(OnItemClickListener lis) {
                itemClickListener = lis;
        }
        /////////////////이번트 처리와 연관된 코드 끝//////////////////////////////////////////////////////////
        public CustomAdapter(String[] titles, int[] images) {
                this.titles = titles;
                this.images = images;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
                ViewHolder viewHolder = new ViewHolder(view);

                ////////////////아이템 클릭 처리를 위해 추가가 필요한 코드///////////////////////////////////////////////////////
                view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                String selTitle = ""; //선택된 무비 타이틀
                                int pos = viewHolder.getAdapterPosition();
                                if (pos != RecyclerView.NO_POSITION) {
                                        selTitle = viewHolder.getTvTitle().getText().toString();
                                }
                                itemClickListener.onItemClicked(pos, selTitle);
                        }
                });
                /////////////////이번트 처리와 연관된 코드 끝//////////////////////////////////////////////////////////

                return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                //장르, Rating, 출시년도는 의미가 없는 데이터임
                holder.getTvTitle().setText(titles[position]);
                holder.getTvGenre().setText("판타지");
                holder.getTvRating().setText("9.0" + position);
                holder.getTvYear().setText(Integer.toString(2020 + position));
                holder.getImageView().setImageResource(R.drawable.movie1);

        }

        @Override
        public int getItemCount() {
                return titles.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
                ImageView imageView;
                TextView tvTitle;
                TextView tvRating;
                TextView tvGenre;
                TextView tvYear;
                public ViewHolder(@NonNull View itemView) {
                        super(itemView);
                        imageView = itemView.findViewById(R.id.imageView);
                        tvTitle = itemView.findViewById(R.id.tvTitle);
                        tvGenre = itemView.findViewById(R.id.tvGenre);
                        tvRating = itemView.findViewById(R.id.tvRating);
                        tvYear = itemView.findViewById(R.id.tvYear);
                }

                public ImageView getImageView() {
                        return imageView;
                }

                public TextView getTvTitle() {
                        return tvTitle;
                }

                public TextView getTvRating() {
                        return tvRating;
                }

                public TextView getTvGenre() {
                        return tvGenre;
                }

                public TextView getTvYear() {
                        return tvYear;
                }
        }
}
