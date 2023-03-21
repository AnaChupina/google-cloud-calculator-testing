package hardcore.service;

import hardcore.model.CalculatorForm;

public class CalculatorFormCreator {
    public static final String TESTDATA_CALCULATOR_NUMBER_OF_INSTANCES = "testdata.calculator.numberOfInstances";
    public static final String TESTDATA_CALCULATOR_SERIES = "testdata.calculator.series";
    public static final String TESTDATA_CALCULATOR_MACHINE_TYPE = "testdata.calculator.machineType";
    public static final String TESTDATA_CALCULATOR_TYPE_OF_GPU = "testdata.calculator.typeOfGPU";
    public static final String TESTDATA_CALCULATOR_NUMBER_OF_GPUS = "testdata.calculator.numberOfGPUs";
    public static final String TESTDATA_CALCULATOR_LOCAL_SSD = "testdata.calculator.localSSD";
    public static final String TESTDATA_CALCULATOR_DATACENTER_LOCATION = "testdata.calculator.datacenterLocation";
    public static final String TESTDATA_CALCULATOR_COMMITTED_USAGE= "testdata.calculator.committedUsage";
    public static final String TESTDATA_CALCULATOR_TOTAL_COST= "testdata.calculator.totalCost";


    public static CalculatorForm withCredentialsFromProperty(){
        return new CalculatorForm(TestDataReader.getTestData(TESTDATA_CALCULATOR_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_SERIES),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_TYPE_OF_GPU),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_COMMITTED_USAGE),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_TOTAL_COST));
    }
}
