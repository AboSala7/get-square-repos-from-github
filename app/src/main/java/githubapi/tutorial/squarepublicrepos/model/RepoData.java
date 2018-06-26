package githubapi.tutorial.squarepublicrepos.model;

public class RepoData {

    private String repoName;
    private String owner;
    private String description;
    private String repoUrl;

    public String getOwnerUrl() {
        return ownerUrl;
    }

    public RepoData(String repoName, String owner, String description, boolean fork , String repoUrl, String ownerUrl) {
        this.repoName = repoName;
        this.owner = owner;
        this.description = description;
        this.repoUrl = repoUrl;
        this.ownerUrl = ownerUrl;
        this.fork = fork;

    }

    private String ownerUrl;
    private boolean fork ;

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public void setOwnerUrl(String ownerUrl) {
        this.ownerUrl = ownerUrl;
    }

    public String getRepoUrl() {
        return repoUrl;
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
