package main.java.com.gwu.csa.model;

import main.java.com.gwu.csa.util.CommonUtils;

import java.util.Arrays;

public class Simulator {
    private String programControl;
    private String memoryAddressRegister;
    private String memoryBufferRegister;
    private String memoryFaultRegister;
    private String instructionRegister;
    private String privileged;
    private GeneralPurposeRegister generalPurposeRegister;
    private IndexRegister indexRegister;
    private Opcode opcode;
    private String halt;
    private String run;
    private int[] ConditionCode;
    private String paragraphString;
    private String FR0;
    private String FR1;

    public String getFR0() {
        return FR0;
    }

    public void setFR0(String FR0) {
        this.FR0 = FR0;
    }

    public String getFR1() {
        return FR1;
    }

    public void setFR1(String FR1) {
        this.FR1 = FR1;
    }

    public Simulator() {
        programControl = "";
        memoryAddressRegister = "";
        memoryBufferRegister = "";
        memoryFaultRegister = "";
        instructionRegister = "";
        privileged = "";
        generalPurposeRegister = new GeneralPurposeRegister();
        indexRegister = new IndexRegister();
        opcode = new Opcode();
        halt = "";
        run = "";
        ConditionCode = new int[4];
        paragraphString = "";
    }
    public String getProgramControl() {
        return programControl;
    }

    public void setProgramControl(String programControl) {
        this.programControl = CommonUtils.convertHexadecimalNumberInFourDigits(programControl);
    }

    public String getMemoryAddressRegister() {
        return memoryAddressRegister;
    }

    public void setMemoryAddressRegister(String memoryAddressRegister) {
        this.memoryAddressRegister = CommonUtils.convertHexadecimalNumberInFourDigits(memoryAddressRegister);
    }

    public String getMemoryBufferRegister() {
        return memoryBufferRegister;
    }

    public void setMemoryBufferRegister(String memoryBufferRegister) {
        this.memoryBufferRegister = CommonUtils.convertHexadecimalNumberInFourDigits(memoryBufferRegister);
    }

    public String getMemoryFaultRegister() {
        return memoryFaultRegister;
    }

    public void setMemoryFaultRegister(String memoryFaultRegister) {
        this.memoryFaultRegister = memoryFaultRegister;
    }

    public String getInstructionRegister() {
        return instructionRegister;
    }

    public void setInstructionRegister(String instructionRegister) {
        this.instructionRegister = CommonUtils.convertHexadecimalNumberInFourDigits(instructionRegister);
    }

    public String getPrivileged() {
        return privileged;
    }

    public void setPrivileged(String privileged) {
        this.privileged = privileged;
    }

    public GeneralPurposeRegister getGeneralPurposeRegister() {
        return generalPurposeRegister;
    }

    public void setGeneralPurposeRegister(GeneralPurposeRegister generalPurposeRegister) {
        this.generalPurposeRegister = generalPurposeRegister;
    }

    public IndexRegister getIndexRegister() {
        return indexRegister;
    }

    public void setIndexRegister(IndexRegister indexRegister) {
        this.indexRegister = indexRegister;
    }

    public Opcode getOpcode() {
        return opcode;
    }

    public void setOpcode(Opcode opcode) {
        this.opcode = opcode;
    }

    public String getHalt() {
        return halt;
    }

    public void setHalt(String halt) {
        this.halt = halt;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public int[] getConditionCode() {
        return ConditionCode;
    }

    public void setConditionCode(int[] conditionCode) {
        ConditionCode = conditionCode;
    }

    public String getParagraphString() {
        return paragraphString;
    }

    public void setParagraphString(String paragraphString) {
        this.paragraphString = paragraphString;
    }

    @Override
    public String toString() {
        return "Simulator{" +
                "programControl='" + programControl + '\'' +
                ", memoryAddressRegister='" + memoryAddressRegister + '\'' +
                ", memoryBufferRegister='" + memoryBufferRegister + '\'' +
                ", memoryFaultRegister='" + memoryFaultRegister + '\'' +
                ", instructionRegister='" + instructionRegister + '\'' +
                ", privileged='" + privileged + '\'' +
                ", generalPurposeRegister=" + generalPurposeRegister +
                ", indexRegister=" + indexRegister +
                ", opcode=" + opcode +
                ", halt='" + halt + '\'' +
                ", run='" + run + '\'' +
                ", ConditionCode=" + Arrays.toString(ConditionCode) +
                ", paragraphString='" + paragraphString + '\'' +
                ", FR0='" + FR0 + '\'' +
                ", FR1='" + FR1 + '\'' +
                '}';
    }
}
