package kiit.tguides.guides.Models.Recomended;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sunando Bhattacharya on 23-09-2015.
 */
public class Place {
    @SerializedName("City")
    @Expose
    private String City;
    @SerializedName("URL")
    @Expose
    private String URL;
    @SerializedName("Description")
    @Expose
    private String Description;
    @SerializedName("id")
    @Expose
    private long id;

    /**
     *
     * @return
     * The City
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @param City
     * The City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * @return
     * The URL
     */
    public String getURL() {
        return URL;
    }

    /**
     *
     * @param URL
     * The URL
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     *
     * @return
     * The Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     *
     * @param Description
     * The Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     *
     * @return
     * The id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(long id) {
        this.id = id;
    }

}
