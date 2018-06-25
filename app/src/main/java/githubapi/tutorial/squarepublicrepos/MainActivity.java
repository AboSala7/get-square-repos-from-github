package githubapi.tutorial.squarepublicrepos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import githubapi.tutorial.squarepublicrepos.model.Api.ApiClient;
import githubapi.tutorial.squarepublicrepos.model.Api.ApiInterface;
import githubapi.tutorial.squarepublicrepos.model.Api.result.ApiResult;
import githubapi.tutorial.squarepublicrepos.model.EndlessRecyclerViewScrollListener;
import githubapi.tutorial.squarepublicrepos.model.RepoData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reposRecycler ;
    private EndlessRecyclerViewScrollListener scrollListener ;

    private List<RepoData> repoDataList = new ArrayList<>();
    private ArrayList fullData ;
    private RepoAdapter repoAdapter ;

    ApiInterface apiService;
    Call<ApiResult[]> call ;

    boolean flag =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reposRecycler = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        reposRecycler.setLayoutManager(layoutManager);
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                flag =true ;
                callApi(page+1);
            }
        };
        reposRecycler.addOnScrollListener(scrollListener);

        apiService =
                ApiClient.getClient().create(ApiInterface.class);

        callApi(1);

    }

    public void callApi(int page){
        call = apiService.getRepos(page);
        call.enqueue(new Callback<ApiResult[]>() {
            @Override
            public void onResponse(Call<ApiResult[]> call, Response<ApiResult[]> response) {
                Toast.makeText(getApplicationContext(),"Loading more Data",Toast.LENGTH_SHORT).show();
                ApiResult[] apiResults = response.body() ;
                Log.i("size results ===",response.body().length +"");
                updateUi(apiResults);
            }

            @Override
            public void onFailure(Call<ApiResult[]> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"failer", Toast.LENGTH_LONG).show();

                Log.i("error ===",t.toString());
            }
        });
    }

    public void updateUi(ApiResult[] apiResults){
        for(ApiResult apiResult : apiResults){
            String repoName =apiResult.getName();
            String owner = apiResult.getOwner().getLogin();
            String description = apiResult.getDescription();
            boolean fork = apiResult.getFork();
            RepoData repoData =new RepoData(repoName,owner,description,fork);
            repoDataList.add(repoData);
        }
        if(flag){
            repoAdapter.notifyDataSetChanged();
        }
        else
        repoAdapter = new RepoAdapter(getApplicationContext(),repoDataList);
        reposRecycler.setAdapter(repoAdapter);}



}