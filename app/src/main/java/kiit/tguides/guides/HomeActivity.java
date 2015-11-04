package kiit.tguides.guides;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;


import kiit.tguides.guides.Adapters.RecommendedAdapter;
import kiit.tguides.guides.Models.Recomended.Recommended;
import kiit.tguides.guides.endpoints.TravelrApi;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class HomeActivity extends AppCompatActivity  {

//    declarations
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.slider)
     SliderLayout sliderLayout;
    @Bind(R.id.recomended)
    RecyclerView recommended;
    @Bind(R.id.suggested)
    RecyclerView suggested;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setTitle("Guides");

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");


        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);



            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()

                    .putString("extra",name);
            String str="hello";

            sliderLayout.addSlider(textSliderView);
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Fade);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setDuration(4000);
            sliderLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            sliderLayout.startAutoCycle();


        }
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recommended.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());

        suggested.setLayoutManager(layoutManager1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.load) {
            setProgressBarIndeterminateVisibility(true);
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://travelr.cubisyssoftware.com")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            TravelrApi apiService =
                    retrofit.create(TravelrApi.class);
            Call<Recommended> call = apiService.GetRecomended();
            call.enqueue(new Callback<Recommended>() {
                @Override
                public void onResponse(Response<Recommended> response, Retrofit retrofit) {
                    int statusCode=response.code();
                    Recommended r=response.body();
                    Log.i("hey",statusCode+"");
                    Log.i("LIST",r.getPlaces().get(1).getDescription());
                    recommended.setAdapter(new RecommendedAdapter(r.getPlaces()));
                    suggested.setMinimumHeight(120*r.getPlaces().size());

                    suggested.setAdapter(new RecommendedAdapter(r.getPlaces()));

                }

                @Override
                public void onFailure(Throwable t) {
                    Snackbar.make(findViewById(R.id.coordinator_layout), "Please check your Internet connection", Snackbar.LENGTH_SHORT).show();
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }


}
