package ivan.silinkin.dao.dto;

import java.util.Objects;

public class Platform {
    private int id;
    private String name;

    public Platform(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Platform(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return Objects.equals(name, platform.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
