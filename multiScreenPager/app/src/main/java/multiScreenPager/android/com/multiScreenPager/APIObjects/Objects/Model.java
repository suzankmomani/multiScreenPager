package multiScreenPager.android.com.multiScreenPager.APIObjects.Objects;

import java.io.Serializable;

/**
 * Created by suzan on 15/07/17.
 */

public class Model implements Serializable {
    private long id;
    private String name;
    private long creationDate;
    private long expiryDate;

    public Model(long id, String name, long creationDate, long expiryDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.expiryDate = expiryDate;
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

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }
}
