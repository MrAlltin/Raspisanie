package ru.mydomain.raspisanieusatu.adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.mydomain.raspisanieusatu.R;
import ru.mydomain.raspisanieusatu.dto.RemindDTO;

public class RemindListAdapter extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder>{

    private List<RemindDTO> data;

    public RemindListAdapter(List<RemindDTO> data) {
        this.data = data;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remind_item, parent, false);

        return new RemindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        RemindDTO item = data.get(position);
        holder.title.setText(item.getTitle());
        holder.room.setText(item.getRooms());
        holder.prepod.setText( item.getPrepods() );

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView title;
        TextView room;
        TextView prepod;


            public RemindViewHolder(View itemView) {
            super(itemView);
                cardView = (CardView)  itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
            room = (TextView) itemView.findViewById(R.id.room);
            prepod = (TextView) itemView.findViewById(R.id.prepod);
        }
    }
}
