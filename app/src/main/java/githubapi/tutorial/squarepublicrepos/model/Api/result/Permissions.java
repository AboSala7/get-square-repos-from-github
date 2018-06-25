package githubapi.tutorial.squarepublicrepos.model.Api.result;

import com.squareup.moshi.Json;

public class Permissions {
    @Json(name = "admin")
    private Boolean admin;
    @Json(name = "push")
    private Boolean push;
    @Json(name = "pull")
    private Boolean pull;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getPush() {
        return push;
    }

    public void setPush(Boolean push) {
        this.push = push;
    }

    public Boolean getPull() {
        return pull;
    }

    public void setPull(Boolean pull) {
        this.pull = pull;
    }

}

