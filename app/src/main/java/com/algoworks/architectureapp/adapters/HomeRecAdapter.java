
package com.algoworks.architectureapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algoworks.architectureapp.R;
import com.algoworks.architectureapp.requests.responses.homeresponse.HomeResponse;

import java.util.List;


public class HomeRecAdapter extends RecyclerView.Adapter<HomeRecAdapter.ViewHolder> {

    private List<HomeResponse> myItems;
    private ItemListener myListener;

    public HomeRecAdapter(List<HomeResponse> items, ItemListener listener) {
        myItems = items;
        myListener = listener;
    }

    public void setListener(ItemListener listener) {
        myListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_category_list_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(myItems.get(position));
    }

    public interface ItemListener {
        void onItemClick(HomeResponse item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // TODO - Your view members
        public HomeResponse item;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            // TODO instantiate/assign view members
        }

        public void setData(HomeResponse item) {
            this.item = item;
            // TODO set data to view
        }

        @Override
        public void onClick(View v) {
            if (myListener != null) {
                myListener.onItemClick(item);
            }
        }
    }


}
                                