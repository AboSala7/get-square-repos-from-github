package githubapi.tutorial.squarepublicrepos.model;

public class RepoData {

    private String repoName ,owner ,description;
    private boolean fork ;

    public RepoData(String repoName, String owner, String description, boolean fork) {
        this.repoName = repoName;
        this.owner = owner;
        this.description = description;
        this.fork = fork;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public boolean getFork() {
        return fork;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }
}
