package hardcore.model;

import java.util.Objects;

public class CalculatorForm {
    private String numberOfInstances;
    private String series;
    private String machineType;
    private String typeOfGPU;
    private String numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;
    private String totalCost;

    public CalculatorForm (String numberOfInstances, String series, String machineType, String typeOfGPU, String numberOfGPUs,
                           String localSSD, String datacenterLocation, String committedUsage, String totalCost) {
        this.numberOfInstances = numberOfInstances;
        this.series = series;
        this.machineType = machineType;
        this.typeOfGPU= typeOfGPU;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this. committedUsage = committedUsage;
        this.totalCost = totalCost;
    }
    public String getNumberOfInstances() {
        return numberOfInstances;
    }
    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }
    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public String getMachineType() {
        return machineType;
    }
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }
    public String getTypeOfGPU() {
        return typeOfGPU;
    }
    public void setTypeOfGPU(String typeOfGPU) {
        this.typeOfGPU = typeOfGPU;
    }
    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }
    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }
    public String getLocalSSD() {
        return localSSD;
    }
    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }
    public String getDatacenterLocation() {
        return datacenterLocation;
    }
    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }
    public String getCommittedUsage() {
        return committedUsage;
    }
    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }
    public String getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "CalculatorForm{" +
                "number of instances='" + numberOfInstances + '\'' +
                ", series='" + series + '\'' +
                ", machine type='" + machineType + '\'' +
                ", type of GPU='" + typeOfGPU + '\'' +
                ", number of GPUs='" + numberOfGPUs + '\'' +
                ", local SSD='" + localSSD + '\'' +
                ", datacenter location='" + datacenterLocation + '\'' +
                ", committed usage='" + committedUsage + '\'' +
                ", total cost='" + totalCost + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculatorForm)) return false;
        CalculatorForm form = (CalculatorForm) o;
        return Objects.equals(getNumberOfInstances(), form.getNumberOfInstances()) &&
                Objects.equals(getSeries(), form.getSeries()) &&
                Objects.equals(getMachineType(), form.getMachineType()) &&
                Objects.equals(getTypeOfGPU(), form.getTypeOfGPU()) &&
                Objects.equals(getNumberOfGPUs(), form.getNumberOfGPUs()) &&
                Objects.equals(getLocalSSD(), form.getLocalSSD()) &&
                Objects.equals(getDatacenterLocation(), form.getDatacenterLocation()) &&
                Objects.equals(getCommittedUsage(), form.getCommittedUsage()) &&
                Objects.equals(getTotalCost(), form.getTotalCost());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstances(), getSeries(), getMachineType(), getTypeOfGPU(),
                getNumberOfGPUs(), getLocalSSD(), getDatacenterLocation(), getCommittedUsage(), getTotalCost());
    }
}
