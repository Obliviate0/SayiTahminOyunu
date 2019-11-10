package com.example.sayitahminoyunu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;




public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {

    private Context mContext;
    private List<ExpenseModel> itemList;

    public MyListAdapter(Context mContext, List<ExpenseModel> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyListAdapter.MyViewHolder holder,
                                 final int position) {
        final ExpenseModel item = itemList.get(position);

        holder.itemscore.setText(String.valueOf(item.getScore()));
        holder.itemdate.setText(item.getDate());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemdate, itemscore;
        RelativeLayout layout;

        public MyViewHolder(View view) {
            super(view);
            itemdate = view.findViewById(R.id.item_date);
            itemscore = view.findViewById(R.id.item_score);
            layout = view.findViewById(R.id.item_layout);
        }
    }
}
