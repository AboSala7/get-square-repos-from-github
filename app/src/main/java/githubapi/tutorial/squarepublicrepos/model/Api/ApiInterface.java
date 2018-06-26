package githubapi.tutorial.squarepublicrepos.model.Api;

import githubapi.tutorial.squarepublicrepos.model.Api.result.ApiResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

      String auth = "enter your access token";


    @GET("orgs/Square/repos?access_token="+ApiInterface.auth+"&type=public&per_page=10")
    Call<ApiResult[]> getRepos(@Query("page") int id);



}
