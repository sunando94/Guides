package kiit.tguides.guides.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import kiit.tguides.guides.Models.Recomended.Place;
import kiit.tguides.guides.R;
import kiit.tguides.guides.ViewHolders.RecommendedHolder;

/**
 * Created by sunando on 04-11-2015.
 */
public class RecommendedAdapter extends RecyclerView.Adapter {

    private List<Place> hotels;

    public RecommendedAdapter() {
        super();
    }

    public RecommendedAdapter(List<Place> hotels) {
        this.hotels = hotels;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendedHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_instance, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecommendedHolder) holder).update(hotels.get(position));



    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

}
