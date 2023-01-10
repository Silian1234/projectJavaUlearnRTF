package ivan.silinkin.dao.dto;


import java.util.Objects;

public class Game {
    private int rank;
    private String name;
    private String year;

    public Game(int rank, String name, String year) {
        this.rank = rank;
        this.name = name;
        this.year = year;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return rank == game.rank && Objects.equals(name, game.name) && Objects.equals(year, game.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, name, year);
    }
}
