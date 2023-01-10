package ivan.silinkin.Parser.model;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class CsvToGame {
    @CsvBindByPosition(position = 0)
    private String rank;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String platform;
    @CsvBindByPosition(position = 3)
    private String year;
    @CsvBindByPosition(position = 4)
    private String Genre;
    @CsvBindByPosition(position = 5)
    private String publisher;
    @CsvBindByPosition(position = 6)
    private String NASales;
    @CsvBindByPosition(position = 7)
    private String EUSales;
    @CsvBindByPosition(position = 8)
    private String JPSales;
    @CsvBindByPosition(position = 9)
    private String otherSales;
    @CsvBindByPosition(position = 10)
    private String globalSales;


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNASales() {
        return NASales;
    }

    public void setNASales(String NASales) {
        this.NASales = NASales;
    }

    public String getEUSales() {
        return EUSales;
    }

    public void setEUSales(String EUSales) {
        this.EUSales = EUSales;
    }

    public String getJPSales() {
        return JPSales;
    }

    public void setJPSales(String JPSales) {
        this.JPSales = JPSales;
    }

    public String getOtherSales() {
        return otherSales;
    }

    public void setOtherSales(String otherSales) {
        this.otherSales = otherSales;
    }

    public String getGlobalSales() {
        return globalSales;
    }

    public void setGlobalSales(String globalSales) {
        this.globalSales = globalSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CsvToGame csvToGame = (CsvToGame) o;
        return Objects.equals(rank, csvToGame.rank) && Objects.equals(name, csvToGame.name) && Objects.equals(platform, csvToGame.platform) && Objects.equals(year, csvToGame.year) && Objects.equals(Genre, csvToGame.Genre) && Objects.equals(publisher, csvToGame.publisher) && Objects.equals(NASales, csvToGame.NASales) && Objects.equals(EUSales, csvToGame.EUSales) && Objects.equals(JPSales, csvToGame.JPSales) && Objects.equals(otherSales, csvToGame.otherSales) && Objects.equals(globalSales, csvToGame.globalSales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, name, platform, year, Genre, publisher, NASales, EUSales, JPSales, otherSales, globalSales);
    }
}
