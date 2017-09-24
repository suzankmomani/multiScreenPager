package multiScreenPager.android.com.multiScreenPager.APIObjects.Objects;

import java.io.Serializable;

/**
 * Created by suzan on 15/07/17.
 */

public class Issue implements Serializable {
    private long id;
    private String name;
    private String idAddress;
    private String deviceIPSubnetMask;
    private Model model;
    private Location location;
    private Status status;
    private Type type;
    private String serialNum;

    public Issue(long id, String name, String idAddress, String deviceIPSubnetMask, Model model,
                 Location location, Status status, Type type, String serialNum) {
        this.id = id;
        this.name = name;
        this.idAddress = idAddress;
        this.deviceIPSubnetMask = deviceIPSubnetMask;
        this.model = model;
        this.location = location;
        this.status = status;
        this.type = type;
        this.serialNum = serialNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getDeviceIPSubnetMask() {
        return deviceIPSubnetMask;
    }

    public void setDeviceIPSubnetMask(String deviceIPSubnetMask) {
        this.deviceIPSubnetMask = deviceIPSubnetMask;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }
}
