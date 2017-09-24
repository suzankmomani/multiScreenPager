package multiScreenPager.android.com.multiScreenPager.Interface;

import multiScreenPager.android.com.multiScreenPager.APIObjects.APIResponse.ContentResponse;
import retrofit.Call;
import retrofit.http.GET;


public interface API {


    String END_POINT = "http://dummyEndPoint";

    @GET("/getContent")
    Call<ContentResponse> getContent();

}

