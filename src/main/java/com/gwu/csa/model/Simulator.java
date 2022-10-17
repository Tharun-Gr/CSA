package main.java.com.gwu.csa.model;

import main.java.com.gwu.csa.util.Utils;

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
    }
    public String getProgramControl() {
        return programControl;
    }

    public void setProgramControl(String programControl) {
        this.programControl = Utils.convertHexadecimalNumberInFourDigits(programControl);
    }

    public String getMemoryAddressRegister() {
        return memoryAddressRegister;
    }

    public void setMemoryAddressRegister(String memoryAddressRegister) {
        this.memoryAddressRegister = Utils.convertHexadecimalNumberInFourDigits(memoryAddressRegister);
    }

    public String getMemoryBufferRegister() {
        return memoryBufferRegister;
    }

    public void setMemoryBufferRegister(String memoryBufferRegister) {
        this.memoryBufferRegister = Utils.convertHexadecimalNumberInFourDigits(memoryBufferRegister);
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
        this.instructionRegister = Utils.convertHexadecimalNumberInFourDigits(instructionRegister);
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
                '}';
    }
}
