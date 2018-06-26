package githubapi.tutorial.squarepublicrepos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import githubapi.tutorial.squarepublicrepos.model.Api.Logic;
import githubapi.tutorial.squarepublicrepos.model.RepoData;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    Logic logic ;
    Context context ;
    List<RepoData> repoDataList ;
    AlertDialog alertDialog ;
    public RepoAdapter(Context context ,List<RepoData> repoDataList,Logic logic) {
        this.context = context;
        this.repoDataList = repoDataList;
        this.logic = logic ;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new RepoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        final RepoData currentRepo = repoDataList.get(position);
        holder.repoName.setText(currentRepo.getRepoName());
        holder.owner.setText(currentRepo.getOwner());
        holder.repoDesc.setText(currentRepo.getDescription());
        if (currentRepo.getFork()){
            holder.background.setBackgroundColor(0xFFFFFFFF);
        }
        else
            holder.background.setBackgroundColor(0xFF00FF00);

        holder.background.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                String[] values = {"open the Repository", "open the owner page"};
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("open web Page ");
                builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which){
                            case 0 :
                                String repoUrl = currentRepo.getRepoUrl();
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(repoUrl));
                                v.getContext().startActivity(browserIntent) ;
                                break;
                            case 1 :
                                String ownerUrl = currentRepo.getOwnerUrl();
                                Intent ownerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ownerUrl));
                                v.getContext().startActivity(ownerIntent) ;
                                break;


                        }
                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });


    }


    @Override
    public int getItemCount() {
        return repoDataList.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder{

        TextView repoName ,owner ,repoDesc;
        CardView background ;
        LinearLayout containerLayout;

        public RepoViewHolder(View itemView) {
            super(itemView);
            repoName =itemView.findViewById(R.id.R_name);
            owner = itemView.findViewById(R.id.R_owner);
            repoDesc = itemView.findViewById(R.id.R_desc);
            background = itemView.findViewById(R.id.background);
            containerLayout = itemView.findViewById(R.id.container);
        }
    }
}
