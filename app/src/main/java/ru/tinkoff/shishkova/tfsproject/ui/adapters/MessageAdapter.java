package ru.tinkoff.shishkova.tfsproject.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.tinkoff.shishkova.tfsproject.ui.items.MessageItem;
import ru.tinkoff.shishkova.tfsproject.R;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MessageItem> dataset;

    public MessageAdapter(List<MessageItem> dataset) {
        this.dataset = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_from_me, parent, false);
            return new FromMeViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_to_me, parent, false);
            return new ToMeViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_to_me_chat, parent, false);
            return new ChatViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MessageItem message = dataset.get(position);
        if (message.getType() == 0) {
            ((FromMeViewHolder) holder).message.setText(message.getMes());
        } else if (message.getType() == 1) {
            ((ToMeViewHolder) holder).message.setText(message.getMes());
        } else {
            ((ChatViewHolder) holder).message.setText(message.getMes());
            ((ChatViewHolder) holder).nick.setText(message.getNick());
        }
    }

    @Override
    public int getItemViewType(int position) {
        MessageItem message = dataset.get(position);
        return message.getType();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class FromMeViewHolder extends RecyclerView.ViewHolder {

        public TextView message;

        public FromMeViewHolder(View view) {
            super(view);
            message = (TextView) view.findViewById(R.id.tv_message_from_me);
        }
    }

    public static class ToMeViewHolder extends RecyclerView.ViewHolder {

        public TextView message;

        public ToMeViewHolder(View view) {
            super(view);
            message = (TextView) view.findViewById(R.id.tv_message_to_me);
        }
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {

        public TextView message;
        public TextView nick;

        public ChatViewHolder(View view) {
            super(view);
            message = (TextView) view.findViewById(R.id.tv_message_to_me_chat);
            nick = (TextView) view.findViewById(R.id.tv_message_to_me_nick);
        }
    }
}
