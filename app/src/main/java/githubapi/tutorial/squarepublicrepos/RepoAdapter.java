package githubapi.tutorial.squarepublicrepos;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import githubapi.tutorial.squarepublicrepos.model.RepoData;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    Context context ;
    List<RepoData> repoDataList ;
    public RepoAdapter(Context context ,List<RepoData> repoDataList) {
        this.context = context;
        this.repoDataList = repoDataList;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new RepoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        RepoData currentRepo = repoDataList.get(position);
        holder.repoName.setText(currentRepo.getRepoName());
        holder.owner.setText(currentRepo.getOwner());
        holder.repoDesc.setText(currentRepo.getDescription());
        if (currentRepo.getFork()){
            holder.background.setBackgroundColor(0xFFFFFFFF);
        }
        else
            holder.background.setBackgroundColor(0xFF00FF00);

    }

    @Override
    public int getItemCount() {
        return repoDataList.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder{

        TextView repoName ,owner ,repoDesc;
        LinearLayout background ;

        public RepoViewHolder(View itemView) {
            super(itemView);
            repoName =itemView.findViewById(R.id.R_name);
            owner = itemView.findViewById(R.id.R_owner);
            repoDesc = itemView.findViewById(R.id.R_desc);
            background = itemView.findViewById(R.id.background);
        }
    }
}
