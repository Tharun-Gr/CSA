package main.java.com.gwu.csa.service;

import main.java.com.gwu.csa.model.GeneralPurposeRegister;
import main.java.com.gwu.csa.model.IndexRegister;
import main.java.com.gwu.csa.model.Opcode;
import main.java.com.gwu.csa.model.Simulator;
import main.java.com.gwu.csa.util.CommonUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class SimulationService {
    public List<String> mainMemory;
    public Simulator simulator;

    public SimulationService() {
        this.mainMemory = CommonUtils.initializeMainMemory();
        this.simulator = CommonUtils.setDefaultValuesSimulator();
    }

    /**
     * Listens the program control load button and once clicked setting the value from switches
     * to program control register.
     * @param value It's in the type of hexadecimal
     */
    public void programControlListener(String value) {
        simulator.setProgramControl(value);
    }

    /**
     * Listens the memory address register load button and once clicked setting the value from switches
     * to memory address register.
     * @param value It's in the type of hexadecimal
     */
    public void memoryAddressRegisterListener(String value) {
        simulator.setMemoryAddressRegister(value);
    }

    /**
     * Listens the memory buffer register load button and once clicked setting the value from switches
     * to memory buffer register.
     * @param value It's in the type of hexadecimal
     */
    public void memoryBufferRegisterListener(String value) {
        simulator.setMemoryBufferRegister(value);
    }

    /**
     * Listens the general purpose register zero load button and
     * once clicked setting the value from switches to general purpose register zero.
     * @param value It's in the type of hexadecimal
     */
    public void gprZeroListener(String value) {
        simulator.getGeneralPurposeRegister().setRegisterZero(value);
    }

    /**
     * Listens the general purpose register one load button and
     * once clicked setting the value from switches to general purpose register one.
     * @param value It's in the type of hexadecimal
     */
    public void gprOneListener(String value) {
        simulator.getGeneralPurposeRegister().setRegisterOne(value);
    }

    /**
     * Listens the general purpose register two load button and
     * once clicked setting the value from switches to general purpose register two.
     * @param value It's in the type of hexadecimal
     */
    public void gprTwoListener(String value) {
        simulator.getGeneralPurposeRegister().setRegisterTwo(value);
    }

    /**
     * Listens the general purpose register three load button and
     * once clicked setting the value from switches to general purpose register three.
     * @param value It's in the type of hexadecimal
     */
    public void gprThreeListener(String value) {
        simulator.getGeneralPurposeRegister().setRegisterThree(value);
    }

    /**
     * Listens the index register one load button and
     * once clicked setting the value from switches to index register one.
     * @param value It's in the type of hexadecimal
     */
    public void ixrOneListener(String value) {
        simulator.getIndexRegister().setRegisterOne(value);
    }

    /**
     * Listens the index register two load button and
     * once clicked setting the value from switches to index register two.
     * @param value It's in the type of hexadecimal
     */
    public void ixrTwoListener(String value) {
        simulator.getIndexRegister().setRegisterTwo(value);
    }

    /**
     * Listens the index register two load button and
     * once clicked setting the value from switches to index register three.
     * @param value It's in the type of hexadecimal
     */
    public void ixrThreeListener(String value) {
        simulator.getIndexRegister().setRegisterThree(value);
    }

    /**
     * Listens main load button and
     * once clicked loading the value from main memory to memory buffer register.
     */
    public void mainLoadButtonListener() {
        String memoryData = getDataFromMainMemoryByLocation(simulator.getMemoryAddressRegister());
        simulator.setMemoryBufferRegister(memoryData);
    }

    /**
     * Listens main load button and
     * once clicked loading the value from main memory to memory buffer register.
     */
    public void mainStoreButtonListener() {
        setDataInMainMemoryByLocation(simulator.getMemoryBufferRegister(),
                simulator.getMemoryAddressRegister());
    }

    /**
     * Listens main store button and
     * once clicked storing the value to main memory from memory buffer register data and
     * memory address register as a location of main memory.
     * @param memoryData Memory content to be stored in main memory
     * @param memoryLocation Memory location of main memory
     */
    private void setDataInMainMemoryByLocation(String memoryData, String memoryLocation) {
        int memoryDataInDecimal = CommonUtils.convertHexadecimalToDecimal(memoryData);
        String memoryDataInDecimalString = CommonUtils.convertIntegerToString(memoryDataInDecimal);
        int memoryLocationInDecimal = CommonUtils.convertHexadecimalToDecimal(memoryLocation);
        mainMemory.set(memoryLocationInDecimal,memoryDataInDecimalString);
    }

    /**
     * Listens main store button and
     * once clicked storing the value to main memory from memory buffer register data and
     * memory address register as a location of main memory.
     * @param memoryData Memory content to be stored in main memory
     * @param memoryLocation Memory location of main memory
     */
    private void addDataInMainMemoryByLocation(String memoryData, String memoryLocation) {
        int memoryDataInDecimal = CommonUtils.convertHexadecimalToDecimal(memoryData);
        String memoryDataInDecimalString = CommonUtils.convertIntegerToString(memoryDataInDecimal);
        int memoryLocationInDecimal = CommonUtils.convertHexadecimalToDecimal(memoryLocation);
        mainMemory.add(memoryLocationInDecimal,memoryDataInDecimalString);
    }

    /**
     * Performing single step operation for the current program control value
     */
    public void singleStepListener() {
        simulator.setMemoryAddressRegister(simulator.getProgramControl());
        int programControlValueInDecimal = CommonUtils.convertHexadecimalToDecimal(
                simulator.getProgramControl())+1;
        String programControlValueInHexadecimal = CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(programControlValueInDecimal));
        simulator.setProgramControl(programControlValueInHexadecimal);
        simulator.setMemoryBufferRegister(getDataFromMainMemoryByLocation(
                simulator.getMemoryAddressRegister()));
        simulator.setInstructionRegister(simulator.getMemoryBufferRegister());

        decodeOpcode(simulator.getInstructionRegister());
        performOperations();
    }

    /**
     * Performing run operation from current program control value
     */
    public void runListener() {
        int mainMemoryLength = mainMemory.size();
        int i = CommonUtils.convertHexadecimalToDecimal(simulator.getProgramControl());
        while (i < mainMemoryLength) {
            singleStepListener();
            i++;
        }
    }

    /**
     * Reading the input file
     * @param inputFilePath File path
     */
    public void readInputFile(String inputFilePath) {
        try {
            File inputFile = new File(inputFilePath);
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readDataFromFile(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Reading data from the file
     * @param data current line
     */
    private void readDataFromFile(String data) {
        String memoryLocation = data.substring(0,4);
        String memoryData = data.substring(5,9);
        addDataInMainMemoryByLocation(memoryData, memoryLocation);
    }

    /**
     * Getting data from the memory location
     * @param value main memory location
     * @return data from the specific main memory location
     */
    private String getDataFromMainMemoryByLocation(String value) {
        int memoryLocation = CommonUtils.convertHexadecimalToDecimal(value);
        return CommonUtils.convertDecimalToHexadecimal(mainMemory.get(memoryLocation));
    }

    /**
     * Decoding opcode
     * @param value opcode value
     */
    private void decodeOpcode(String value) {
        System.out.println("value "+value);
        String binaryValue = CommonUtils.convertHexadecimalToBinary(value);
        System.out.println("binaryValue "+binaryValue);
        assignOpcodeValue(binaryValue);
    }

    /**
     * Assigning opcode values to specific fields
     * @param value opcode value
     */
    private void assignOpcodeValue(String value) {
        Opcode opcode = simulator.getOpcode();
        opcode.setOperations(value.substring(0,6));
        opcode.setGeneralPurposeRegister(value.substring(6,8));
        opcode.setIndexRegister(value.substring(8,10));
        opcode.setIndirectMode(value.substring(10,11));
        opcode.setAddress(value.substring(11,16));
        simulator.setOpcode(opcode);
    }

    /**
     * perform operations from decoded opcode
     */
    private void performOperations() {
        String operationsCodeInOctal = CommonUtils.convertBinaryToOctalNumber(
                simulator.getOpcode().getOperations());
        String octalInProperForm = CommonUtils.convertOctalToProperTwoDigitOctalNumber(operationsCodeInOctal);
        calculateEffectiveAddress();
        switch (octalInProperForm) {
            case "01":
                performLoadRegisterFromMemoryOperation();
                break;
            case "02":
                performStoreRegisterToMemoryOperation();
                break;
            case "03":
                performLoadRegisterWithAddressOperation();
                break;
            case "41":
                performLoadIndexRegisterFromMemoryOperation();
                break;
            case "42":
                performStoreIndexRegisterToMemoryOperation();
                break;
            default:
                System.out.println("Invalid operations");
        }
    }

    /**
     * Calculating effective address
     */
    private void calculateEffectiveAddress() {
        if (simulator.getOpcode().getIndexRegister().equals("00")) {
            if (simulator.getOpcode().getIndirectMode().equals("0")) {
                String effectiveAddressInHexadecimal = CommonUtils.convertBinaryToHexadecimal(
                        simulator.getOpcode().getAddress());
                simulator.getOpcode().setEffectiveAddress(effectiveAddressInHexadecimal);
                return;
            }
            String addressInHexadecimal = CommonUtils.convertBinaryToHexadecimal(
                    simulator.getOpcode().getAddress());
            String dataFromMainMemory = getDataFromMainMemoryByLocation(addressInHexadecimal);
            simulator.getOpcode().setEffectiveAddress(dataFromMainMemory);
            return;
        }
        if (simulator.getOpcode().getIndirectMode().equals("0")) {
            calculateEffectiveAddressForFalseIndirectMode();
            return;
        }
        calculateEffectiveAddressForTrueIndirectMode();
    }

    /**
     * Calculating effective address for zero bit indirect mode
     */
    private void calculateEffectiveAddressForFalseIndirectMode() {
        int effectiveAddressInDecimal = CommonUtils.convertBinaryToDecimal(
                simulator.getOpcode().getAddress());
        int indexRegisterDataInDecimalInteger = CommonUtils.convertHexadecimalToDecimal(
                getDataFromIndexRegisterByAddress());
        int calculatedEffectiveAddressInDecimal = effectiveAddressInDecimal +
                indexRegisterDataInDecimalInteger;
        String calculatedEffectiveAddressInDecimalString = CommonUtils.convertIntegerToString(
                calculatedEffectiveAddressInDecimal);
        String calculatedEffectiveAddressInHexadecimal = CommonUtils.convertDecimalToHexadecimal(
                calculatedEffectiveAddressInDecimalString);
        simulator.getOpcode().setEffectiveAddress(calculatedEffectiveAddressInHexadecimal);
    }

    /**
     * Calculating effective address for indirect mode
     */
    private void calculateEffectiveAddressForTrueIndirectMode() {
        int indexRegisterDataInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromIndexRegisterByAddress());
        int addressInOpcodeInDecimalInteger = CommonUtils.convertBinaryToDecimal(
                simulator.getOpcode().getAddress());
        String addressInOpcodeInDecimalString = CommonUtils.convertIntegerToString(addressInOpcodeInDecimalInteger);
        String addressInOpcodeInHexadecimalString = CommonUtils.convertDecimalToHexadecimal(addressInOpcodeInDecimalString);
        String effectiveAddressDataFromMemoryInHexadecimal = getDataFromMainMemoryByLocation(
                addressInOpcodeInHexadecimalString);
        int effectiveAddressDataFromMemoryInDecimalInteger = CommonUtils.convertHexadecimalToDecimal(
                effectiveAddressDataFromMemoryInHexadecimal);
        int preCalculatedEffectiveAddressInDecimalInteger = indexRegisterDataInDecimal +
                effectiveAddressDataFromMemoryInDecimalInteger;
        String preCalculatedEffectiveAddressInDecimalString = CommonUtils.convertIntegerToString(
                preCalculatedEffectiveAddressInDecimalInteger);
        String preCalculatedEffectiveAddressInHexadecimalString = CommonUtils.convertDecimalToHexadecimal(
                preCalculatedEffectiveAddressInDecimalString);
        String calculatedEffectiveAddressInHexadecimal = getDataFromMainMemoryByLocation(
                preCalculatedEffectiveAddressInHexadecimalString);
        simulator.getOpcode().setEffectiveAddress(calculatedEffectiveAddressInHexadecimal);
    }

    /**
     * getting data from index register
     * @return
     */
    private String getDataFromIndexRegisterByAddress() {
        int indexRegisterInDecimal = CommonUtils.convertBinaryToDecimal(
                simulator.getOpcode().getIndexRegister());
        String indexRegisterDataInHexadecimalString;
        if (indexRegisterInDecimal == 1) {
            indexRegisterDataInHexadecimalString = simulator.getIndexRegister().getRegisterOne();
        } else if (indexRegisterInDecimal == 2) {
            indexRegisterDataInHexadecimalString = simulator.getIndexRegister().getRegisterTwo();
        } else {
            indexRegisterDataInHexadecimalString = simulator.getIndexRegister().getRegisterThree();
        }
        if (indexRegisterDataInHexadecimalString.equals("")) {
            return "0000";
        }
        return indexRegisterDataInHexadecimalString;
    }

    /**
     * Performing load operation from memory
     */
    private void performLoadRegisterFromMemoryOperation() {
        String getValueFromMainMemoryInHexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        loadGPRFromOpcode(getValueFromMainMemoryInHexadecimal);
    }

    /**
     * perform store register to memory operation
     */
    private void performStoreRegisterToMemoryOperation() {
        String dataFromGPRByOpcodeInHexadecimal = getDataFromGPRByOpcode();
        setDataInMainMemoryByLocation(dataFromGPRByOpcodeInHexadecimal,
                simulator.getOpcode().getEffectiveAddress());
    }

    /**
     * Getting the data from the particular general purpose register by the opcode switch value
     * @return Hexadecimal data value of specific general purpose register
     */
    private String getDataFromGPRByOpcode() {
        String gprRegisterSelect = simulator.getOpcode().getGeneralPurposeRegister();
        GeneralPurposeRegister generalPurposeRegister = simulator.getGeneralPurposeRegister();
        if (gprRegisterSelect.equals("00")) {
            return generalPurposeRegister.getRegisterZero();
        }
        if (gprRegisterSelect.equals("01")) {
            return generalPurposeRegister.getRegisterOne();
        }
        if (gprRegisterSelect.equals("10")) {
            return generalPurposeRegister.getRegisterTwo();
        }
        return generalPurposeRegister.getRegisterThree();
    }

    /**
     * Getting the data from the particular index register by the opcode switch value
     * @return Hexadecimal data value of specific index register
     */
    private String getDataFromIXRByOpcode() {
        String ixrRegisterSelect = simulator.getOpcode().getIndexRegister();
        IndexRegister indexRegister = simulator.getIndexRegister();
        if (ixrRegisterSelect.equals("01")) {
            return indexRegister.getRegisterOne();
        }
        if (ixrRegisterSelect.equals("10")) {
            return indexRegister.getRegisterTwo();
        }
        return indexRegister.getRegisterThree();
    }

    /**
     * perform load register with address operation
     */
    private void performLoadRegisterWithAddressOperation() {
        loadGPRFromOpcode(simulator.getOpcode().getEffectiveAddress());
    }

    /**
     * performing load index register from memory
     */
    private void performLoadIndexRegisterFromMemoryOperation() {
        String getValueFromMainMemoryInHexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        loadIndexRegisterFromOpcode(getValueFromMainMemoryInHexadecimal);
    }

    /**
     * performing store index register to memory
     */
    private void performStoreIndexRegisterToMemoryOperation() {
        String dataFromIXRByOpcodeInHexadecimal = getDataFromIXRByOpcode();
        setDataInMainMemoryByLocation(dataFromIXRByOpcodeInHexadecimal,
                simulator.getOpcode().getEffectiveAddress());
    }

    /**
     * load gpr from the opcode value
     * @param data value to be load
     */
    private void loadGPRFromOpcode(String data) {
        String gprRegisterSelect = simulator.getOpcode().getGeneralPurposeRegister();
        GeneralPurposeRegister generalPurposeRegister = simulator.getGeneralPurposeRegister();
        if (gprRegisterSelect.equals("00")) {
            generalPurposeRegister.setRegisterZero(data);
            return;
        }
        if (gprRegisterSelect.equals("01")) {
            generalPurposeRegister.setRegisterOne(data);
            return;
        }
        if (gprRegisterSelect.equals("10")) {
            generalPurposeRegister.setRegisterTwo(data);
            return;
        }
        generalPurposeRegister.setRegisterThree(data);
    }

    /**
     * loading index register from opcode
     * @param data value to be load
     */
    private void loadIndexRegisterFromOpcode(String data) {
        String ixrRegisterSelect = simulator.getOpcode().getIndexRegister();
        IndexRegister indexRegister = simulator.getIndexRegister();
        if (ixrRegisterSelect.equals("01")) {
            indexRegister.setRegisterOne(data);
            return;
        }
        if (ixrRegisterSelect.equals("10")) {
            indexRegister.setRegisterTwo(data);
            return;
        }
        indexRegister.setRegisterThree(data);
    }
}