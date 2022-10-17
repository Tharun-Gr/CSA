package main.java.com.gwu.csa.model;

import main.java.com.gwu.csa.util.Utils;

public class GeneralPurposeRegister {
    private String registerZero;
    private String registerOne;
    private String registerTwo;
    private String registerThree;

    GeneralPurposeRegister() {
        registerZero = "";
        registerOne = "";
        registerTwo = "";
        registerThree = "";
    }
    public String getRegisterZero() {
        return registerZero;
    }

    public void setRegisterZero(String registerZero) {

        this.registerZero = Utils.convertHexadecimalNumberInFourDigits(registerZero);
    }

    public String getRegisterOne() {
        return registerOne;
    }

    public void setRegisterOne(String registerOne) {

        this.registerOne = Utils.convertHexadecimalNumberInFourDigits(registerOne);
    }

    public String getRegisterTwo() {
        return registerTwo;
    }

    public void setRegisterTwo(String registerTwo) {

        this.registerTwo = Utils.convertHexadecimalNumberInFourDigits(registerTwo);
    }

    public String getRegisterThree() {
        return registerThree;
    }

    public void setRegisterThree(String registerThree) {

        this.registerThree = Utils.convertHexadecimalNumberInFourDigits(registerThree);
    }

    @Override
    public String toString() {
        return "GeneralPurposeRegister{" +
                "registerZero='" + registerZero + '\'' +
                ", registerOne='" + registerOne + '\'' +
                ", registerTwo='" + registerTwo + '\'' +
                ", registerThree='" + registerThree + '\'' +
                '}';
    }
}
