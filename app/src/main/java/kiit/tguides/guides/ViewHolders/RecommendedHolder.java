package kiit.tguides.guides.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import kiit.tguides.guides.Models.Recomended.Place;
import kiit.tguides.guides.R;

/**
 * Created by sunando on 04-11-2015.
 */
public class RecommendedHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    @Bind(R.id.hero)
    ImageView hero;
    @Bind(R.id.hotelname)
    TextView hotelname;
    @Bind(R.id.location)
    TextView location;
    private Place reference;


    public RecommendedHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }
    public void update(Place hotel)
    {
         reference = hotel;
        hotelname.setText(reference.getCity());

        String url = reference.getURL();
        Picasso.with(itemView.getContext()).load(url).fit().centerCrop().error(R.drawable.ic_launcher).into(hero);
    }
    @Override
    public void onClick(View view) {

    }
}
