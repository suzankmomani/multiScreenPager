package multiScreenPager.android.com.multiScreenPager.APIObjects.Objects;

import java.io.Serializable;

/**
 * Created by suzan on 15/07/17.
 */

public class DangerLevel implements Serializable {

    private long id;
    private String dangerLevelName;
    private int dangerLevelIntValue;
    private boolean actionRequired;

    public DangerLevel(long id, String dangerLevelName, int dangerLevelIntValue, boolean actionRequired) {
        this.id = id;
        this.dangerLevelName = dangerLevelName;
        this.dangerLevelIntValue = dangerLevelIntValue;
        this.actionRequired = actionRequired;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDangerLevelName() {
        return dangerLevelName;
    }

    public void setDangerLevelName(String dangerLevelName) {
        this.dangerLevelName = dangerLevelName;
    }

    public int getDangerLevelIntValue() {
        return dangerLevelIntValue;
    }

    public void setDangerLevelIntValue(int dangerLevelIntValue) {
        this.dangerLevelIntValue = dangerLevelIntValue;
    }

    public boolean isActionRequired() {
        return actionRequired;
    }

    public void setActionRequired(boolean actionRequired) {
        this.actionRequired = actionRequired;
    }
}
