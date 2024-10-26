package Database;

import java.io.Serializable;

public class Movies implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    private String title;

    public Movies(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
