package kiit.tguides.guides.Models.Recomended;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import kiit.tguides.guides.Models.Recomended.Place;

/**
 * Created by Sunando Bhattacharya on 23-09-2015.
 */
public class Recommended {
    @SerializedName("Places")
    @Expose
    private List<Place> Places = new ArrayList<Place>();

    /**
     *
     * @return
     * The Places
     */
    public List<Place> getPlaces() {
        return Places;
    }

    /**
     *
     * @param Places
     * The Places
     */
    public void setPlaces(List<Place> Places) {
        this.Places = Places;
    }

}
