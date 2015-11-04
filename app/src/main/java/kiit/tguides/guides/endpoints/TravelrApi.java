package kiit.tguides.guides.endpoints;

import kiit.tguides.guides.Models.Recomended.Recommended;
import retrofit.Call;
import retrofit.http.GET;

public interface TravelrApi{
    @GET("/api//home/getplaces")
    Call<Recommended> GetRecomended();
}