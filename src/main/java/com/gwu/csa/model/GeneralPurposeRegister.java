package main.java.com.gwu.csa.model;

import main.java.com.gwu.csa.util.CommonUtils;

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

        this.registerZero = CommonUtils.convertHexadecimalNumberInFourDigits(registerZero);
    }

    public String getRegisterOne() {
        return registerOne;
    }

    public void setRegisterOne(String registerOne) {

        this.registerOne = CommonUtils.convertHexadecimalNumberInFourDigits(registerOne);
    }

    public String getRegisterTwo() {
        return registerTwo;
    }

    public void setRegisterTwo(String registerTwo) {

        this.registerTwo = CommonUtils.convertHexadecimalNumberInFourDigits(registerTwo);
    }

    public String getRegisterThree() {
        return registerThree;
    }

    public void setRegisterThree(String registerThree) {

        this.registerThree = CommonUtils.convertHexadecimalNumberInFourDigits(registerThree);
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
