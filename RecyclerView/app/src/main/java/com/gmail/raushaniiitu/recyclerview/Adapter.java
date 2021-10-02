package com.gmail.raushaniiitu.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final List<ModelClass> userLists;

    public Adapter(List<ModelClass> userLists) {
        this.userLists = userLists;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource = userLists.get(position).getImageView();
        String userName = userLists.get(position).getUserNameTextView();
        String userMsg = userLists.get(position).getUserMsgTextView();
        String userTime = userLists.get(position).getUserTimeTextView();
        holder.setData(resource, userName, userMsg, userTime);

    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewId;
        private final TextView UserNameTextViewId;
        private final TextView UserMsgTextViewId;
        private final TextView UserTimeTextViewId;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewId = itemView.findViewById(R.id.image_view_id);
            UserNameTextViewId = itemView.findViewById(R.id.user1name_text_view_id);
            UserMsgTextViewId = itemView.findViewById(R.id.user1_msg_view_id);
            UserTimeTextViewId = itemView.findViewById(R.id.user1_time_view_id);
        }


        public void setData(int resource, String userName, String userMsg, String userTime) {
            imageViewId.setImageResource(resource);
            UserNameTextViewId.setText(userName);
            UserMsgTextViewId.setText(userMsg);
            UserTimeTextViewId.setText(userTime);
        }
    }
}
