package githubapi.tutorial.squarepublicrepos.model.Api;

import githubapi.tutorial.squarepublicrepos.model.Api.result.ApiResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

      String auth = "41c089245cf74273a1f3a80c9b7295d4151187a5";


    @GET("orgs/Square/repos?access_token="+ApiInterface.auth+"&type=public&per_page=10")
    Call<ApiResult[]> getRepos(@Query("page") int id);



}
