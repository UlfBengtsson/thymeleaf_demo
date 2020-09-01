package com.example.thymeleaf_demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DtoCar {

    private int id;

    @NotNull
    @Size(min=2, max=30)
    private String brand;

    @NotBlank
    private String modelName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DtoCar dtoCar = (DtoCar) o;

        if (getId() != dtoCar.getId()) return false;
        if (getBrand() != null ? !getBrand().equals(dtoCar.getBrand()) : dtoCar.getBrand() != null) return false;
        return getModelName() != null ? getModelName().equals(dtoCar.getModelName()) : dtoCar.getModelName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        result = 31 * result + (getModelName() != null ? getModelName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DtoCar{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
