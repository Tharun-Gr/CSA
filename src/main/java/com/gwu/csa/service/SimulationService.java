package main.java.com.gwu.csa.service;

import main.java.com.gwu.csa.model.GeneralPurposeRegister;
import main.java.com.gwu.csa.model.IndexRegister;
import main.java.com.gwu.csa.model.Opcode;
import main.java.com.gwu.csa.model.Simulator;
import main.java.com.gwu.csa.util.CommonUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SimulationService {
    public List<String> mainMemory;
    public Simulator simulator;
    public Map<Integer, Map<String, String>> cache;

    public SimulationService() {
        this.mainMemory = CommonUtils.initializeMainMemory();
        this.simulator = CommonUtils.setDefaultValuesSimulator();
        this.cache = new TreeMap<>(Collections.reverseOrder());
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
     * Listens the fr0 register load button and once clicked setting the value from switches
     * to fr0 register.
     * @param value It's in the type of hexadecimal
     */
    public void fr0LoadListener(String value) {
        simulator.setFR0(value);
    }

    /**
     * Listens the fr1 register load button and once clicked setting the value from switches
     * to fr1 register.
     * @param value It's in the type of hexadecimal
     */
    public void fr1LoadListener(String value) {
        simulator.setFR1(value);
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
    public void setDataInMainMemoryByLocation(String memoryData, String memoryLocation) {
//        if (isMFR()) {
//            return;
//        }
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
    private void setDataInMainMemoryByLocationForRoutine(String memoryData, String memoryLocation) {
        int memoryDataInDecimal = CommonUtils.convertHexadecimalToDecimal(memoryData);
        String memoryDataInDecimalString = CommonUtils.convertIntegerToString(memoryDataInDecimal);
        int memoryLocationInDecimal = CommonUtils.convertHexadecimalToDecimal(memoryLocation);
        mainMemory.set(memoryLocationInDecimal,memoryDataInDecimalString);
    }

    private boolean isMFR() {
        String memoryLocation = CommonUtils.convertHexadecimalNumberInFourDigits(
                simulator.getOpcode().getEffectiveAddress());
        int memoryLocationInDecimal = CommonUtils.convertHexadecimalToDecimal(simulator.getProgramControl());
        String nextMemoryLocationInHexadecimal = CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(
                memoryLocationInDecimal+1));

        if (memoryLocation.equals("0000") ||
                memoryLocation.equals("0001") ||
                memoryLocation.equals("0002") ||
                memoryLocation.equals("0003") ||
                memoryLocation.equals("0004") ||
                memoryLocation.equals("0005")) {
            setDataInMainMemoryByLocationForRoutine(nextMemoryLocationInHexadecimal, "0004");
            simulator.setProgramControl("0001");
            singleStepListener();
            singleStepListener();
            simulator.setProgramControl(getDataFromMainMemoryByLocation("0004"));
            simulator.getOpcode().setShouldIncrementPC(false);
            return true;
        }
        return false;
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
        simulator.setMemoryBufferRegister(getDataFromMainMemoryByLocation(
                simulator.getMemoryAddressRegister()));
        simulator.setInstructionRegister(simulator.getMemoryBufferRegister());

        decodeOpcode(simulator.getInstructionRegister());
        performOperations();

        if (simulator.getOpcode().getShouldIncrementPC()) {
            incrementProgramControl();
        }
    }

    /**
     * Increment the program counter after instruction executed.
     */
    private void incrementProgramControl() {
        int programControlValueInDecimal = CommonUtils.convertHexadecimalToDecimal(
                simulator.getProgramControl())+1;
        String programControlValueInHexadecimal = CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(programControlValueInDecimal));
        simulator.setProgramControl(programControlValueInHexadecimal);
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
//            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Reading the program 2 file
     * @param fileLocation File path of program two
     */
    public void readInputFileForProgramTwo(String fileLocation) {
        try {
            File inputFile = new File(fileLocation);
            Scanner myReader = new Scanner(inputFile);
            int lineCount = 0;
            while (myReader.hasNextLine()) {
                lineCount++;
                String data = myReader.nextLine();
                simulator.setParagraphString(simulator.getParagraphString() + data + "\n");
                String[] words = data.split(" ");
                int wordCount = 0;
                for (String word : words) {
                    wordCount++;
                    String memoryWord = lineCount + "#" + wordCount + "@" + word;
                    mainMemory.add(memoryWord);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Reading data from the file
     * @param data current line
     */
    private void readDataFromFile(String data) {
        String memoryLocation = data.substring(0,4);
        String memoryData = "";
        if (data.length() == 13) {
            memoryData = data.substring(5,13);
        } else {
            memoryData = data.substring(5,9);
        }
        addDataInMainMemoryByLocation(memoryData, memoryLocation);
    }

    /**
     * Getting data from the memory location
     * @param value main memory location
     * @return data from the specific main memory location
     */
    public String getDataFromMainMemoryByLocation(String value) {
        int memoryLocation = CommonUtils.convertHexadecimalToDecimal(value);
        return CommonUtils.convertDecimalToHexadecimal(mainMemory.get(memoryLocation));
    }

    /**
     * Decoding opcode
     * @param value opcode value
     */
    private void decodeOpcode(String value) {
        String binaryValue = CommonUtils.convertHexadecimalToBinary(value);
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
        opcode.setShouldIncrementPC(true);
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
        setCache();
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
            case "10":
                performJumpIfZeroOperation();
                break;
            case "11":
                performJumpIfNotEqualOperation();
                break;
            case "12":
                performJumpIfConditionCodeOperation();
                break;
            case "13":
                performUnconditionalJumpToAddressOperation();
                break;
            case "14":
                performJumpAndSaveReturnAddressOperation();
                break;
            case "15":
                performReturnFromSubRoutineOperation();
                break;
            case "16":
                performSubtractOneAndBranchOperation();
                break;
            case "17":
                performJumpGreaterThanOrEqualToOperation();
                break;
            case "04":
                performAddMemoryToRegisterOperation();
                break;
            case "05":
                performSubtractMemoryToRegisterOperation();
                break;
            case "06":
                performAddImmediateToRegisterOperation();
                break;
            case "07":
                performSubtractImmediateToRegisterOperation();
                break;
            case "20":
                performMultiplicationRegisterToRegisterOperation();
                break;
            case "21":
                performDivisionRegisterToRegisterOperation();
                break;
            case "22":
                performTestForEqualityOperation();
                break;
            case "23":
                performAndRegisterToRegisterOperation();
                break;
            case "24":
                performLogicalOrOfRegisterAndRegisterOperation();
                break;
            case "25":
                performLogicalNotOfRegisterOperation();
                break;
            case "31":
                performShiftRegisterByCount();
                break;
            case "32":
                performRotateRegisterByCount();
                break;
            case "00":
                performHaltOperation();
                break;
            case "30":
                performTrapOperation();
                break;
            case "33":
                performFloatingAddOperation();
                break;
            case "34":
                performFloatingSubOperation();
                break;
            case "35":
                performVectorAddOperation();
                break;
            case "36":
                performVectorSubOperation();
                break;
            case "50":
                performLoadFloatingOperation();
                break;
            case "51":
                performStoreFloatingOperation();
                break;
            case "37":
                performConvertFloatingOperation();
                break;
            default:
//                System.out.println("Invalid operations");
        }
    }

    private void performTrapOperation() {
//        System.out.println("Trap operation");

        int memoryLocationInDecimal = CommonUtils.convertHexadecimalToDecimal(simulator.getProgramControl());
        String nextMemoryLocationInHexadecimal = CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(
                        memoryLocationInDecimal+1));

        setDataInMainMemoryByLocationForRoutine(nextMemoryLocationInHexadecimal, "0002");
        simulator.setProgramControl("0000");
        singleStepListener();
        singleStepListener();
        simulator.setProgramControl(getDataFromMainMemoryByLocation("0002"));
        simulator.getOpcode().setShouldIncrementPC(false);
    }

    private void performHaltOperation() {
//        System.out.println("Halt operation");
    }

    /**
     * Set data on cache vector
     */
    private void setCache() {
        String tagValue = simulator.getProgramControl();
        String dataValue = simulator.getMemoryBufferRegister();

        int index = cache.size();
        Map<String, String> map = new HashMap<>();
        map.put(tagValue, dataValue);
        cache.put(index, map);
    }

    /**
     * Calculating effective address
     */
    private void calculateEffectiveAddress() {
        String addressInHexadecimal = CommonUtils.convertBinaryToHexadecimal(
                simulator.getOpcode().getAddress());
        if (simulator.getOpcode().getIndexRegister().equals("00")) {
            if (simulator.getOpcode().getIndirectMode().equals("0")) {
                simulator.getOpcode().setEffectiveAddress(addressInHexadecimal);
                return;
            }
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

        String addressInHexadecimal = CommonUtils.convertBinaryToHexadecimal(
                simulator.getOpcode().getAddress());
        String dataFromMainMemory = getDataFromMainMemoryByLocation(addressInHexadecimal);
        int dataFromMainMemoryInDecimal = CommonUtils.convertHexadecimalToDecimal(dataFromMainMemory);

        int calculatedEffectiveAddressInDecimal = indexRegisterDataInDecimal +
                dataFromMainMemoryInDecimal;

        String calculatedEffectiveAddressInDecimalString = CommonUtils.convertIntegerToString(
                calculatedEffectiveAddressInDecimal);
        String calculatedEffectiveAddressInHexadecimal = CommonUtils.convertDecimalToHexadecimal(
                calculatedEffectiveAddressInDecimalString);
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

    /**
     * If the register value is equal to zero. Then, set PC as EA.
     * Otherwise, increment PC by 1.
     */
    private void performJumpIfZeroOperation() {
        String dataFromGPRByOpcodeInHexadecimal = getDataFromGPRByOpcode();
        //TODO: Need to know the default value of register. Is it 0 or empty?
        if (dataFromGPRByOpcodeInHexadecimal.equals("") || dataFromGPRByOpcodeInHexadecimal.equals("0000")) {
            simulator.setProgramControl(simulator.getOpcode().getEffectiveAddress());
            simulator.getOpcode().setShouldIncrementPC(false);
        }
    }

    /**
     * If the register value is not equal to zero. Then, set PC as EA.
     * Otherwise, increment PC by 1.
     */
    private void performJumpIfNotEqualOperation() {
        String dataFromGPRByOpcodeInHexadecimal = getDataFromGPRByOpcode();
        if (!dataFromGPRByOpcodeInHexadecimal.equals("") && !dataFromGPRByOpcodeInHexadecimal.equals("0000")) {
            simulator.setProgramControl(simulator.getOpcode().getEffectiveAddress());
            simulator.getOpcode().setShouldIncrementPC(false);
        }
    }

    /**
     * If the register is equal to 1. Then, set PC as EA.
     * Otherwise, increment PC by 1.
     */
    private void performJumpIfConditionCodeOperation() {
        String gprRegisterSelect = simulator.getOpcode().getGeneralPurposeRegister();
        int[] cc = simulator.getConditionCode();
        if (gprRegisterSelect.equals("11") && (cc[3] == 1)) {
            simulator.setProgramControl(simulator.getOpcode().getEffectiveAddress());
            simulator.getOpcode().setShouldIncrementPC(false);
        }
    }

    /**
     * Sets EA to PC as default
     */
    private void performUnconditionalJumpToAddressOperation() {
        simulator.setProgramControl(simulator.getOpcode().getEffectiveAddress());
        simulator.getOpcode().setShouldIncrementPC(false);
    }

    /**
     * sets incremented by 1 value of pc to gpr3 and EA to PC.
     */
    private void performJumpAndSaveReturnAddressOperation() {
        int programControlValueInDecimal = CommonUtils.convertHexadecimalToDecimal(
                simulator.getProgramControl())+1;
        String programControlValueInHexadecimal = CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(programControlValueInDecimal));
        loadGPRFromOpcode(programControlValueInHexadecimal);
        simulator.setProgramControl(simulator.getOpcode().getEffectiveAddress());
        simulator.getOpcode().setShouldIncrementPC(false);
    }

    /**
     * sets gpr3 value to pc.
     */
    private void performReturnFromSubRoutineOperation() {
        String dataFromGPRByOpcodeInHexadecimal = getDataFromGPRByOpcode();
        simulator.setProgramControl(dataFromGPRByOpcodeInHexadecimal);
        simulator.getOpcode().setShouldIncrementPC(false);
    }

    /**
     * Subtract the gpr by 1. If the value is greater than 0, sets EA to PC
     * Otherwise, increment PC by 1.
     */
    private void performSubtractOneAndBranchOperation() {
        String dataFromGPRByOpcodeInHexadecimal = getDataFromGPRByOpcode();
        int subtractedValue = CommonUtils.convertHexadecimalToDecimal(dataFromGPRByOpcodeInHexadecimal) - 1;
        String subtractedValueInString = CommonUtils.convertIntegerToString(subtractedValue);
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(subtractedValueInString));

        String updatedDataFromGPRByOpcodeInHexadecimal = getDataFromGPRByOpcode();
        int updatedDataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(updatedDataFromGPRByOpcodeInHexadecimal);
        if (!(updatedDataFromGPRByOpcodeInDecimal > 0)) {
            return;
        }
        simulator.setProgramControl(simulator.getOpcode().getEffectiveAddress());
        simulator.getOpcode().setShouldIncrementPC(false);
    }

    /**
     * If the value of GPR is greater than or equal to zero, sets ea to pc.
     * Otherwise, increment PC by 1.
     */
    private void performJumpGreaterThanOrEqualToOperation() {
        String dataFromGPRByOpcodeInHexadecimal = getDataFromGPRByOpcode();
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                dataFromGPRByOpcodeInHexadecimal);

        if (dataFromGPRByOpcodeInDecimal < 0) {
            return;
        }
        simulator.setProgramControl(simulator.getOpcode().getEffectiveAddress());
        simulator.getOpcode().setShouldIncrementPC(false);
    }

    /**
     * Sums the register value to EA. Stores the result to the register.
     */
    private void performAddMemoryToRegisterOperation() {
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcode());
        int effectiveAddressValue = CommonUtils.convertHexadecimalToDecimal(
                simulator.getOpcode().getEffectiveAddress());
        int sumValue = dataFromGPRByOpcodeInDecimal + effectiveAddressValue;
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(sumValue)));
    }

    /**
     * Subtracts the register value to EA. Stores the result to the register.
     */
    private void performSubtractMemoryToRegisterOperation() {
        //TODO: Handle subtraction 0-1
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcode());
        int effectiveAddressValue = CommonUtils.convertHexadecimalToDecimal(
                simulator.getOpcode().getEffectiveAddress());
        int subtractedValue = 0;
        if (dataFromGPRByOpcodeInDecimal > effectiveAddressValue) {
            subtractedValue = dataFromGPRByOpcodeInDecimal - effectiveAddressValue;
        } else {
            subtractedValue = effectiveAddressValue - dataFromGPRByOpcodeInDecimal;
        }
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(subtractedValue)));
    }

    /**
     * add the immediate and gpr0.
     */
    private void performAddImmediateToRegisterOperation() {
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcode());
        int immediate = CommonUtils.convertHexadecimalToDecimal(
                simulator.getOpcode().getEffectiveAddress());

        int sumValue = dataFromGPRByOpcodeInDecimal + immediate;
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(sumValue)));
    }

    /**
     * subtract the immediate and gpr0.
     */
    private void performSubtractImmediateToRegisterOperation() {
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcode());
        int immediate = CommonUtils.convertHexadecimalToDecimal(
                simulator.getOpcode().getEffectiveAddress());

        int subtractedValue = dataFromGPRByOpcodeInDecimal - immediate;
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(subtractedValue)));
    }

    /**
     * Getting data from GPR for multiplication and division operations
     * @return Data from the GPR specific register
     */
    public String getDataFromGPRByOpcodeForMultiplyAndDivision() {
        String gprRegisterSelect = simulator.getOpcode().getGeneralPurposeRegister();
        GeneralPurposeRegister generalPurposeRegister = simulator.getGeneralPurposeRegister();
        String result = "";
        if (gprRegisterSelect.equals("00")) {
            result = generalPurposeRegister.getRegisterZero();
        }
        if (gprRegisterSelect.equals("01")) {
//            System.out.println("ERROR: Invalid register selection");
        }
        if (gprRegisterSelect.equals("10")) {
            result = generalPurposeRegister.getRegisterTwo();
        }
        return result;
    }

    /**
     * Getting data from IXR for multiplication and division operations
     * @return Data from the IXR specific register
     */
    public String getDataFromIXRByOpcodeForMultiplyAndDivision() {
        String ixrRegisterSelect = simulator.getOpcode().getIndexRegister();
        IndexRegister indexRegister = simulator.getIndexRegister();
        String result = "";
        if (ixrRegisterSelect.equals("01")) {
//            System.out.println("ERROR: Invalid register selection");
        }
        if (ixrRegisterSelect.equals("10")) {
            result = indexRegister.getRegisterTwo();
        }
        return result;
    }

    /**
     * Perform multiplication operation between two registers
     */
    private void performMultiplicationRegisterToRegisterOperation() {
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcodeForMultiplyAndDivision());
        int dataFromIXRByOpcode = CommonUtils.convertHexadecimalToDecimal(
                getDataFromIXRByOpcodeForMultiplyAndDivision());
        int[] cc = simulator.getConditionCode();
        int multipliedValue = dataFromGPRByOpcodeInDecimal * dataFromIXRByOpcode;
        if (multipliedValue > 4095) {
            multipliedValue = multipliedValue % 4095;
            cc[0] = 1; // This bit indicates overflow
            simulator.setConditionCode(cc);
        } else {
            cc[0] = 0; // This bit indicates overflow
            simulator.setConditionCode(cc);
        }

        String multipliedValueInBinary = CommonUtils.convertHexadecimalToBinary(
                CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(multipliedValue)));

        String gprLoadValue = CommonUtils.convertBinaryToHexadecimal(multipliedValueInBinary.substring(0,8));  // save in register 0 or 2
        String ixrLoadValue = CommonUtils.convertBinaryToHexadecimal(multipliedValueInBinary.substring(8,16)); // save in register 1 or 3

        loadGPRFromOpcode(gprLoadValue);
        loadIndexRegisterFromOpcode(ixrLoadValue);
    }

    /**
     * Perform division operation between two registers
     */
    private void performDivisionRegisterToRegisterOperation() {
        int dividend = CommonUtils.convertHexadecimalToDecimal(getDataFromGPRByOpcodeForMultiplyAndDivision());
        int divisor = CommonUtils.convertHexadecimalToDecimal(getDataFromIXRByOpcodeForMultiplyAndDivision());
        int[] cc = simulator.getConditionCode();
        if (divisor == 0) {
//            System.out.println("ERROR: Invalid divisor");
            cc[3] = 1;
            simulator.setConditionCode(cc);
        } else {
            cc[3] = 0;
            simulator.setConditionCode(cc);
        }
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(quotient)));
        loadIndexRegisterFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(remainder)));
    }

    /**
     * Perform equality test between two registers
     */
    private void performTestForEqualityOperation(){
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcodeForMultiplyAndDivision());
        int dataFromIXRByOpcode = CommonUtils.convertHexadecimalToDecimal(
                getDataFromIXRByOpcodeForMultiplyAndDivision());
        int[] cc = simulator.getConditionCode();
        if(dataFromGPRByOpcodeInDecimal==dataFromIXRByOpcode){
            cc[3]=1;
        }
        cc[3]=0;
    }

    /**
     * Performing register to register logical AND operation.
     */
    private void performAndRegisterToRegisterOperation(){
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcodeForMultiplyAndDivision());
        int dataFromIXRByOpcode = CommonUtils.convertHexadecimalToDecimal(
                getDataFromIXRByOpcodeForMultiplyAndDivision());
        int rx = dataFromGPRByOpcodeInDecimal & dataFromIXRByOpcode;
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(rx)));
    }

    /**
     * Perform logical OR operation for gpr0 and ixr1 registers and store the result on gpr0.
     */
    private void performLogicalOrOfRegisterAndRegisterOperation() {
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcode());
        int dataFromIXRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromIXRByOpcode());

        int orValue = dataFromGPRByOpcodeInDecimal | dataFromIXRByOpcodeInDecimal;
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(orValue)));
    }

    /**
     * Perform logical NOT operation for gpr0 register and store the result on gpr0.
     */
    private void performLogicalNotOfRegisterOperation() {
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcode());

        int notValue = ~dataFromGPRByOpcodeInDecimal;
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(notValue)));
    }

    /**
     * Shift register by count
     */
    private void performShiftRegisterByCount() {
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcode());
        String ixrRegisterSelect = simulator.getOpcode().getIndexRegister();
        int AL = CommonUtils.convertStringToInteger(ixrRegisterSelect.substring(0,1));
        int LR = CommonUtils.convertStringToInteger(ixrRegisterSelect.substring(1,2));
        int count = CommonUtils.convertHexadecimalToDecimal(simulator.getOpcode().getEffectiveAddress());
        int Shift;
        if (AL==1 && LR==1)
        {
            Shift = dataFromGPRByOpcodeInDecimal<<count;
        }
        else if (AL==1 && LR==0)
        {
            Shift = dataFromGPRByOpcodeInDecimal>>>count;
        }
        else if (AL==0 && LR==1)
        {
            Shift = dataFromGPRByOpcodeInDecimal<<count;
        }
        else
        {
            Shift = dataFromGPRByOpcodeInDecimal>>count;
        }
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(Shift)));
    }

    /**
     * Rotate register by count
     */
    private void performRotateRegisterByCount() {
        int dataFromGPRByOpcodeInDecimal = CommonUtils.convertHexadecimalToDecimal(
                getDataFromGPRByOpcode());
        String ixrRegisterSelect = simulator.getOpcode().getIndexRegister();
        int AL = CommonUtils.convertStringToInteger(ixrRegisterSelect.substring(0,1));
        int LR = CommonUtils.convertStringToInteger(ixrRegisterSelect.substring(1,2));
        int count = CommonUtils.convertHexadecimalToDecimal(simulator.getOpcode().getEffectiveAddress());
        int Rotate = 0;
        if (AL==1 && LR==1)
        {
            Rotate = (dataFromGPRByOpcodeInDecimal << count) | (dataFromGPRByOpcodeInDecimal >> (32 - count));
        }
        else if (AL==1 && LR==0)
        {
            Rotate = (dataFromGPRByOpcodeInDecimal >> count) | (dataFromGPRByOpcodeInDecimal << (32 - count));
        }
        loadGPRFromOpcode(CommonUtils.convertDecimalToHexadecimal(
                CommonUtils.convertIntegerToString(Rotate)));
    }

    /**
     * Get data from the floating point register
     * @return Data in the register
     */
    private String getDataFromFR() {
        String frSelect = simulator.getOpcode().getGeneralPurposeRegister();
        if (frSelect.equals("01")) {
            return simulator.getFR1();
        }
        return simulator.getFR0();
    }

    /**
     * Adding two floating point numbers
     */
    private void performFloatingAddOperation() {
        String frSelectDataInBinaryFloat = getDataFromFR();

        int intBits = Float.floatToIntBits(Float.parseFloat(frSelectDataInBinaryFloat));
        String binary = Integer.toBinaryString(intBits);
        int binaryToBitsConversionFR = Integer.parseInt(binary, 2);
        float calculatedFloatFromFR = Float.intBitsToFloat(binaryToBitsConversionFR);

        String memory1Hexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        String memory2Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(),1));
        String memoryBinary = CommonUtils.convertFullHexadecimalToBinary(memory1Hexadecimal+memory2Hexadecimal);
        int binaryToBitsConversion = Integer.parseInt(memoryBinary, 2);
        float calculatedFloatFromMemory = Float.intBitsToFloat(binaryToBitsConversion);

        float sum = calculatedFloatFromFR + calculatedFloatFromMemory;
        simulator.setFR0(String.valueOf(sum));
    }

    /**
     * Calculating the floating or encoding from the binary values
     * @param floatNumberInBinary binary value to encode
     * @return Returns the floating number
     */
    private float calculateFloatFromBinary(String floatNumberInBinary) {
        int intBits = Float.floatToIntBits(Float.parseFloat(floatNumberInBinary));
        String binary = Integer.toBinaryString(intBits);

        int binaryToBitsConversion = Integer.parseInt(binary, 2);
        float calculatedFloat = Float.intBitsToFloat(binaryToBitsConversion);
        return calculatedFloat;
    }

    /**
     * Subtracting two floating point numbers
     */
    private void performFloatingSubOperation() {
        String frSelectDataInBinaryFloat = getDataFromFR();

        int intBits = Float.floatToIntBits(Float.parseFloat(frSelectDataInBinaryFloat));
        String binary = Integer.toBinaryString(intBits);
        int binaryToBitsConversionFR = Integer.parseInt(binary, 2);
        float calculatedFloatFromFR = Float.intBitsToFloat(binaryToBitsConversionFR);

        String memory1Hexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        String memory2Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(),1));
        String memoryBinary = CommonUtils.convertFullHexadecimalToBinary(memory1Hexadecimal+memory2Hexadecimal);
        int binaryToBitsConversion = Integer.parseInt(memoryBinary, 2);
        float calculatedFloatFromMemory = Float.intBitsToFloat(binaryToBitsConversion);

        float diff = calculatedFloatFromFR - calculatedFloatFromMemory;
        simulator.setFR0(String.valueOf(diff));
    }

    /**
     * Adding two vectors
     */
    private void performVectorAddOperation() {
        String memory1Hexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        String memory3Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(),2));
        String memoryBinary = CommonUtils.convertFullHexadecimalToBinary(memory1Hexadecimal+memory3Hexadecimal);
        int binaryToBitsConversion = Integer.parseInt(memoryBinary, 2);
        float calculatedFloatFromMemory1 = Float.intBitsToFloat(binaryToBitsConversion);

        String memory2Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(), 1));
        String memory4Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(), 3));
        String memory2Binary = CommonUtils.convertFullHexadecimalToBinary(memory2Hexadecimal+memory4Hexadecimal);
        int binaryToBitsConversion2 = Integer.parseInt(memory2Binary, 2);
        float calculatedFloatFromMemory2 = Float.intBitsToFloat(binaryToBitsConversion2);

        float sum = calculatedFloatFromMemory1 + calculatedFloatFromMemory2;
        simulator.setFR0(String.valueOf(sum));
    }

    /**
     * Subtracting two vectors
     */
    private void performVectorSubOperation() {
        String memory1Hexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        String memory3Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(),2));
        String memoryBinary = CommonUtils.convertFullHexadecimalToBinary(memory1Hexadecimal+memory3Hexadecimal);
        int binaryToBitsConversion = Integer.parseInt(memoryBinary, 2);
        float calculatedFloatFromMemory1 = Float.intBitsToFloat(binaryToBitsConversion);

        String memory2Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(), 1));
        String memory4Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(), 3));
        String memory2Binary = CommonUtils.convertFullHexadecimalToBinary(memory2Hexadecimal+memory4Hexadecimal);
        int binaryToBitsConversion2 = Integer.parseInt(memory2Binary, 2);
        float calculatedFloatFromMemory2 = Float.intBitsToFloat(binaryToBitsConversion2);

        float diff = calculatedFloatFromMemory1 - calculatedFloatFromMemory2;
        simulator.setFR0(String.valueOf(diff));
    }

    /**
     * Loading the floating point number in the register
     */
    private void performLoadFloatingOperation() {
        String memory1Hexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        String memory2Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(),1));
        String memoryBinary = CommonUtils.convertFullHexadecimalToBinary(
                memory1Hexadecimal+memory2Hexadecimal);
        int binaryToBitsConversion = Integer.parseInt(memoryBinary, 2);
        float calculatedFloatFromMemory = Float.intBitsToFloat(binaryToBitsConversion);

        simulator.setFR0(String.valueOf(calculatedFloatFromMemory));
    }

    /**
     * Storing the floating point number to the memory
     */
    private void performStoreFloatingOperation() {
        String frSelectDataInBinaryFloat = getDataFromFR();

        int intBits = Float.floatToIntBits(Float.parseFloat(frSelectDataInBinaryFloat));
        String binary = Integer.toBinaryString(intBits);

        String hexadecimal = CommonUtils.convertBinaryToHexadecimal(binary);
        setDataInMainMemoryByLocation(hexadecimal.substring(0,4), simulator.getOpcode().getEffectiveAddress());
        setDataInMainMemoryByLocation(hexadecimal.substring(4,8), simulator.getOpcode().getEffectiveAddress()+1);
    }

    /**
     * Converting the data from the memory to the fixed/floating point number.
     */
    private void performConvertFloatingOperation() {
        String memory1Hexadecimal = getDataFromMainMemoryByLocation(
                simulator.getOpcode().getEffectiveAddress());
        String memory2Hexadecimal = getDataFromMainMemoryByLocation(CommonUtils.incrementHexadecimal(
                simulator.getOpcode().getEffectiveAddress(),1));
        String memoryBinary = CommonUtils.convertFullHexadecimalToBinary(
                memory1Hexadecimal+memory2Hexadecimal);
        int binaryToBitsConversion = Integer.parseInt(memoryBinary, 2);
        float calculatedFloatFromMemory = Float.intBitsToFloat(binaryToBitsConversion);

        simulator.setFR0(String.valueOf(calculatedFloatFromMemory));
    }
}