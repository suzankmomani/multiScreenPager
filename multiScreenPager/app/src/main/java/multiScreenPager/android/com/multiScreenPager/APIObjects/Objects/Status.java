package multiScreenPager.android.com.multiScreenPager.APIObjects.Objects;

import java.io.Serializable;

/**
 * Created by suzan on 15/07/17.
 */

public class Status implements Serializable{

    private long id;
    private String statusValue;
    private DangerLevel dangerLevel;
    private IssueStatus status;

    public Status(long id, String statusValue, DangerLevel dangerLevel) {
        this.id = id;
        this.statusValue = statusValue;
        this.dangerLevel = dangerLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public DangerLevel getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(DangerLevel dangerLevel) {
        this.dangerLevel = dangerLevel;
    }


    public IssueStatus getStatus() {

        if(statusValue.equals("stable")){
            status=IssueStatus.SOLVED;
        }else if(statusValue.equals("is having a problem")||statusValue.equals("is about to go down")){
            status=IssueStatus.OPEN;
        }
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public enum IssueStatus{
        OPEN,SOLVED
    }
}
