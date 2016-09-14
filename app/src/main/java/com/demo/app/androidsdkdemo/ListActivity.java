package com.demo.app.androidsdkdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "ListActivity";
    @Bind(R.id.recycler_demo)
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new SimpleItemHolder(getLayoutInflater().inflate(R.layout.simle_item, parent, false), new ClickHandler());
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((SimpleItemHolder) holder).update(position);
            }

            @Override
            public int getItemCount() {
                return 35;
            }
        });
    }

    private class ClickHandler {
        void onImageClick(SimpleItemHolder holder) {
            Log.i(TAG, "onImageClick: " + holder.getAdapterPosition());
            new AlertDialog.Builder(ListActivity.this).setTitle("Growing " + holder.getAdapterPosition())
                    .setPositiveButton("IO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i(TAG, "onClick: " + which);
                        }
                    }).create().show();
        }

        void onIconClick(SimpleItemHolder holder) {
            Log.i(TAG, "onIconClick: " + holder.getAdapterPosition());
            new AlertDialog.Builder(ListActivity.this).setTitle("Drop " + holder.getAdapterPosition())
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i(TAG, "onClick: " + which);
                        }
                    }).show();
        }
    }

    private class SimpleItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView like;
        ImageView icon;
        CardView card;
        long createTime;
        ClickHandler handler;

        public SimpleItemHolder(View itemView, ClickHandler clickHandler) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.card_image);
            like = (TextView) itemView.findViewById(R.id.card_text);
            icon = (ImageView) itemView.findViewById(R.id.card_icon);
            card = (CardView) itemView.findViewById(R.id.cardView);
            createTime = SystemClock.elapsedRealtime() % 1000;
            card.setOnClickListener(this);
            icon.setOnClickListener(this);
            handler = clickHandler;
        }

        void update(int position) {
            card.setBackgroundColor(Color.HSVToColor(new float[]{((460 / 9) * (position % 9) + (35 / 9)), 0.4f, 0.3f}));
            like.setText(String.format(Locale.US, "%d™", position * 100 + createTime));
        }

        @Override
        public void onClick(View v) {
            if (v == card) {
                handler.onImageClick(this);
            } else if (v == icon) {
                handler.onIconClick(this);
            }
        }
    }
}
