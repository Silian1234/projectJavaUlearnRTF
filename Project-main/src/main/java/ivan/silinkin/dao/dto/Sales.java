package ivan.silinkin.dao.dto;


import java.util.Objects;

public class Sales {

    private float NASales;

    private float EUSales;

    private float JPSales;

    private float otherSales;

    private float globalSales;

    public Sales(float NASales, float EUSales, float JPSales, float otherSales, float globalSales) {
        this.NASales = NASales;
        this.EUSales = EUSales;
        this.JPSales = JPSales;
        this.otherSales = otherSales;
        this.globalSales = globalSales;
    }

    public float getNASales() {
        return NASales;
    }


    public void setNASales(float NASales) {
        this.NASales = NASales;
    }


    public float getEUSales() {
        return EUSales;
    }


    public void setEUSales(float EUSales) {
        this.EUSales = EUSales;
    }


    public float getJPSales() {
        return JPSales;
    }


    public void setJPSales(float JPSales) {
        this.JPSales = JPSales;
    }


    public float getOtherSales() {
        return otherSales;
    }


    public void setOtherSales(float otherSales) {
        this.otherSales = otherSales;
    }


    public float getGlobalSales() {
        return globalSales;
    }


    public void setGlobalSales(float globalSales) {
        this.globalSales = globalSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return Objects.equals(NASales, sales.NASales) && Objects.equals(EUSales, sales.EUSales) && Objects.equals(JPSales, sales.JPSales) && Objects.equals(otherSales, sales.otherSales) && Objects.equals(globalSales, sales.globalSales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NASales, EUSales, JPSales, otherSales, globalSales);
    }
}
