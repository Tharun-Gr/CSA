package main.java.com.gwu.csa.model;

import main.java.com.gwu.csa.util.Utils;

public class IndexRegister {
    private String registerOne;
    private String registerTwo;
    private String registerThree;

    IndexRegister() {
        registerOne = "";
        registerTwo = "";
        registerThree = "";
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
        return "IndexRegister{" +
                "registerOne='" + registerOne + '\'' +
                ", registerTwo='" + registerTwo + '\'' +
                ", registerThree='" + registerThree + '\'' +
                '}';
    }
}
