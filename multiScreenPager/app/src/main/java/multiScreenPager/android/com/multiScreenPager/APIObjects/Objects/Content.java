package multiScreenPager.android.com.multiScreenPager.APIObjects.Objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created by suzan on 15/07/17.
 */

public class Content implements Serializable {
    private List<Issue> issues;

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}
