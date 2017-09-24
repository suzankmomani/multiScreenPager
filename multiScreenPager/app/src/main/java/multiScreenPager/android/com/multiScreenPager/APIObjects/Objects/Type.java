package multiScreenPager.android.com.multiScreenPager.APIObjects.Objects;

import java.io.Serializable;

/**
 * Created by suzan on 15/07/17.
 */

public class Type implements Serializable {


    private long id;
    private String machineTypeName;

    public Type(long id, String machineTypeName) {
        this.id = id;
        this.machineTypeName = machineTypeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName;
    }
}
