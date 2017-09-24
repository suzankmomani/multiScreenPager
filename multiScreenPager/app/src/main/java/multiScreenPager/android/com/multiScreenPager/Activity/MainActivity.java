package multiScreenPager.android.com.multiScreenPager.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import multiScreenPager.android.com.multiScreenPager.APIObjects.APIResponse.ContentResponse;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.City;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Content;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Country;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.DangerLevel;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Issue;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Location;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Model;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Status;
import multiScreenPager.android.com.multiScreenPager.APIObjects.Objects.Type;
import multiScreenPager.android.com.multiScreenPager.Fragment.EmptyFragment;
import multiScreenPager.android.com.multiScreenPager.Fragment.MainFragment;
import multiScreenPager.android.com.multiScreenPager.Fragment.MasterFragment;
import multiScreenPager.android.com.multiScreenPager.Interface.API;
import multiScreenPager.android.com.multiScreenPager.R;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements MasterFragment.OnListMainInteractionListener {

    private final int MENU_ITEM_1 = 0;
    private final int MENU_ITEM_2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            return;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showMainFragment();
    }


    @Override
    public void onFragmentInteraction(int position) {
        if (position == MENU_ITEM_1) {
            showMainFragment();
        } else {
            if (position == MENU_ITEM_2) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, EmptyFragment.newInstance()).commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void openCloseSlider() {
        android.support.v4.widget.SlidingPaneLayout mySlider = (android.support.v4.widget.SlidingPaneLayout) findViewById(R.id.slider);

        if (!mySlider.isOpen())
            mySlider.openPane();
        else mySlider.closePane();
    }


    private void showMainFragment() {

        /* in normal case, call getContent to get the content from the API response, but for testing purposes only I will use a dummy object */
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, MainFragment.newInstance(getTestingObject())).commitAllowingStateLoss();

    }

    private void getContent() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.END_POINT)
                .build();

        API service = retrofit.create(API.class);

        final Call<ContentResponse> call = service.getContent();
        call.enqueue(new Callback<ContentResponse>() {
                         @Override
                         public void onResponse(Response<ContentResponse> response, Retrofit retrofit) {

                             if (response.body() != null) {

                             }
                         }

                         @Override
                         public void onFailure(Throwable t) {

                         }
                     }


        );
    }


    private Content getTestingObject() {

        Content content = new Content();
        Issue issue = new Issue(1, "CISCO-Server", "10.10.10.1", "10.10.10.1",
                new Model(1, "name", 1486549907000L, 1486549907000L), new Location(1, "Jordan",
                new City(1, "Amman", new Country(1, "Jordan")), 0, 0),
                new Status(1, "stable", new DangerLevel(1, "low", 0, false)), new Type(1, "ROUTER"), "UFFNEV");

        Issue issue2 = new Issue(2, "CISCO-Server", "10.10.10.2", "10.10.10.2",
                new Model(1, "name", 1486549907000L, 1486549907000L), new Location(1, "Jordan",
                new City(1, "Amman", new Country(1, "Jordan")), 0, 0),
                new Status(1, "is having a problem", new DangerLevel(1, "low", 0, false)), new Type(1, "ROUTER"), "UWWFFNEV");

        List<Issue> issues = new ArrayList<>();
        issues.add(issue);
        issues.add(issue2);
        content.setIssues(issues);

        return content;

    }
}
