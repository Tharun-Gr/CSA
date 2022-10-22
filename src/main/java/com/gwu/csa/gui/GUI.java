package main.java.com.gwu.csa.gui;

import main.java.com.gwu.csa.service.SimulationService;
import main.java.com.gwu.csa.util.CommonUtils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class GUI extends JFrame {

    private final SimulationService service;
    private JButton pcLoadButton;
    private JButton marLoadButton;
    private JButton mbrLoadButton;
    private JButton gprZeroLoadButton;
    private JButton gprOneLoadButton;
    private JButton gprTwoLoadButton;
    private JButton gprThreeLoadButton;
    private JButton ixrOneLoadButton;
    private JButton ixrTwoLoadButton;
    private JButton ixrThreeLoadButton;
    private JButton storeButton;
    private JButton storePlusButton;
    private JButton mainLoadButton;
    private JButton initButton;
    private JButton singleStepButton;
    private JButton runButton;
    private JButton showMemoryButton;
    private JButton programOneButton;
    private JButton controlInputButton;
    private JTextField opcodeTextField;
    private JTextField programControlTextField;
    private JTextField marTextField;
    private JTextField mbrTextField;
    private JTextField irTextField;
    private JTextField mfrTextField;
    private JTextField privilegedTextField;
    private JTextField gprZeroTextField;
    private JTextField gprOneTextField;
    private JTextField gprTwoTextField;
    private JTextField gprThreeTextField;
    private JTextField ixrOneTextField;
    private JTextField ixrTwoTextField;
    private JTextField ixrThreeTextField;
    private JTextField haltTextField;
    private JTextField runTextField;
    private JTextField consoleInputTextField;
    private JTextArea consoleOutputTextField;
    private JLabel gprZeroLabel;
    private JLabel gprOneLabel;
    private JLabel gprTwoLabel;
    private JLabel gprThreeLabel;
    private JLabel ixrOneLabel;
    private JLabel ixrTwoLabel;
    private JLabel ixrThreeLabel;
    private JLabel programControlLabel;
    private JLabel marLabel;
    private JLabel mbrLabel;
    private JLabel irLabel;
    private JLabel mfrLabel;
    private JLabel privilegedLabel;
    private JLabel operationsOpcodeLabel;
    private JLabel gprOpcodeLabel;
    private JLabel ixrOpcodeLabel;
    private JLabel indirectModeOpcodeLabel;
    private JLabel addressOpcodeLabel;
    private JLabel haltLabel;
    private JLabel runLabel;
    private JLabel opcodeLabel;
    private JLabel consoleLabel;
    private int programOneInputCounter = 0;
    private String programOneMemoryStart = "0022";
    private String programOneSearchLocation = "0036";

    public GUI() {
        this.service = new SimulationService();
        createGUIComponents();
        applyStylesGUIComponents();
        addGUIComponentsInFrame();
        applyFrameStyle();
        updateOrSetAllTextFieldValues();
        addComponentListeners();
        System.out.println(service.simulator);
    }

    private void createGUIComponents() {
        createButtons();
        createTextFields();
        createLabels();
    }

    private void applyStylesGUIComponents() {
        applyButtonStyles();
        applyStylesTextFields();
        applyStylesLabel();
    }

    private void addGUIComponentsInFrame() {
        addButtons();
        addTextFields();
        addLabels();
    }

    private void applyFrameStyle() {
        setSize(300,400);
        setLayout(null);
        setVisible(true);
    }

    private void createButtons() {
        this.pcLoadButton = new JButton("LOAD");
        this.marLoadButton = new JButton("LOAD");
        this.mbrLoadButton = new JButton("LOAD");
        this.gprZeroLoadButton = new JButton("LOAD");
        this.gprOneLoadButton = new JButton("LOAD");
        this.gprTwoLoadButton = new JButton("LOAD");
        this.gprThreeLoadButton = new JButton("LOAD");
        this.ixrOneLoadButton = new JButton("LOAD");
        this.ixrTwoLoadButton = new JButton("LOAD");
        this.ixrThreeLoadButton = new JButton("LOAD");
        this.storeButton = new JButton("STORE");
        this.storePlusButton = new JButton("STORE +");
        this.mainLoadButton = new JButton("LOAD");
        this.initButton = new JButton("INIT");
        this.singleStepButton = new JButton("SS");
        this.runButton = new JButton("RUN");
        this.showMemoryButton = new JButton("Show memory");
        this.programOneButton = new JButton("Program 1");
        this.controlInputButton = new JButton("Load Input");
    }

    private void applyButtonStyles() {
        this.pcLoadButton.setBounds(650,30,70, 40);
        this.marLoadButton.setBounds(650,100,70, 40);
        this.mbrLoadButton.setBounds(650,170,70, 40);
        this.gprZeroLoadButton.setBounds(230,30,70, 40);
        this.gprOneLoadButton.setBounds(230,100,70, 40);
        this.gprTwoLoadButton.setBounds(230,170,70, 40);
        this.gprThreeLoadButton.setBounds(230,240,70, 40);
        this.ixrOneLoadButton.setBounds(230,310,70, 40);
        this.ixrTwoLoadButton.setBounds(230,380,70, 40);
        this.ixrThreeLoadButton.setBounds(230,450,70, 40);
        this.showMemoryButton.setBounds(30,560,100,40);
        this.storeButton.setBounds(160,560,70,40);
        this.storePlusButton.setBounds(260,560,70,40);
        this.mainLoadButton.setBounds(360,560,70,40);
        this.initButton.setBounds(460,560,70,40);
        this.singleStepButton.setBounds(400,650,50,100);
        this.runButton.setBounds(500,650,50,100);
        this.programOneButton.setBounds(900,30,100, 40);
        this.controlInputButton.setBounds(1070,125,100,40);
    }

    private void addButtons() {
        add(pcLoadButton);
        add(marLoadButton);
        add(mbrLoadButton);
        add(gprZeroLoadButton);
        add(gprOneLoadButton);
        add(gprTwoLoadButton);
        add(gprThreeLoadButton);
        add(ixrOneLoadButton);
        add(ixrTwoLoadButton);
        add(ixrThreeLoadButton);
        add(showMemoryButton);
        add(storeButton);
        add(storePlusButton);
        add(mainLoadButton);
        add(initButton);
        add(singleStepButton);
        add(runButton);
        add(programOneButton);
        add(controlInputButton);
    }

    private void createTextFields() {
        this.opcodeTextField = new JTextField();
        this.programControlTextField = new JTextField();
        this.marTextField = new JTextField();
        this.mbrTextField = new JTextField();
        this.irTextField = new JTextField();
        this.mfrTextField = new JTextField();
        this.privilegedTextField = new JTextField();
        this.gprZeroTextField = new JTextField();
        this.gprOneTextField = new JTextField();
        this.gprTwoTextField = new JTextField();
        this.gprThreeTextField = new JTextField();
        this.ixrOneTextField= new JTextField();
        this.ixrTwoTextField= new JTextField();
        this.ixrThreeTextField= new JTextField();
        this.haltTextField = new JTextField();
        this.runTextField = new JTextField();
        this.consoleInputTextField = new JTextField();
        this.consoleOutputTextField = new JTextArea(5,5);
    }

    private void applyStylesTextFields() {
        this.programControlTextField.setBounds(500,30,100,40);
        this.programControlTextField.setEditable(false);

        this.marTextField.setBounds(500,100,100,40);
        this.marTextField.setEditable(false);

        this.mbrTextField.setBounds(500,170,100,40);
        this.mbrTextField.setEditable(false);

        this.irTextField.setBounds(500,240,100,40);
        this.irTextField.setEditable(false);

        this.mfrTextField.setBounds(500,310,100,40);
        this.mfrTextField.setEditable(false);

        this.privilegedTextField.setBounds(500,380,100,40);
        this.privilegedTextField.setEditable(false);

        this.gprZeroTextField.setBounds(100,30,100,40);
        this.gprZeroTextField.setEditable(false);

        this.gprOneTextField.setBounds(100,100,100,40);
        this.gprOneTextField.setEditable(false);

        this.gprTwoTextField.setBounds(100,170,100,40);
        this.gprTwoTextField.setEditable(false);

        this.gprThreeTextField.setBounds(100,240,100,40);
        this.gprThreeTextField.setEditable(false);

        this.ixrOneTextField.setBounds(100,310,100,40);
        this.ixrOneTextField.setEditable(false);

        this.ixrTwoTextField.setBounds(100,380,100,40);
        this.ixrTwoTextField.setEditable(false);

        this.ixrThreeTextField.setBounds(100,450,100,40);
        this.ixrThreeTextField.setEditable(false);

        this.haltTextField.setBounds(650,650,75,40);
        this.haltTextField.setEditable(false);

        this.runTextField.setBounds(650,710,75,40);
        this.runTextField.setEditable(false);

        this.opcodeTextField.setBounds(150,675,200,50);
        this.consoleInputTextField.setBounds(900,125,150,40);
        this.consoleOutputTextField.setBounds(900, 200, 350, 100);
        this.consoleOutputTextField.setEditable(false);
        this.consoleOutputTextField.setText("Click the program 1 button to execute...");
    }

    private void addTextFields() {
        add(opcodeTextField);
        add(programControlTextField);
        add(marTextField);
        add(mbrTextField);
        add(irTextField);
        add(mfrTextField);
        add(privilegedTextField);
        add(gprZeroTextField);
        add(gprOneTextField);
        add(gprTwoTextField);
        add(gprThreeTextField);
        add(ixrOneTextField);
        add(ixrTwoTextField);
        add(ixrThreeTextField);
        add(haltTextField);
        add(runTextField);
        add(consoleInputTextField);
        add(consoleOutputTextField);
    }

    private void createLabels() {
        this.gprZeroLabel = new JLabel("GPR  0");
        this.gprOneLabel = new JLabel("GPR  1");
        this.gprTwoLabel = new JLabel("GPR  2");
        this.gprThreeLabel = new JLabel("GPR  3");
        this.ixrOneLabel = new JLabel("IXR  1");
        this.ixrTwoLabel = new JLabel("IXR  2");
        this.ixrThreeLabel = new JLabel("IXR  3");
        this.programControlLabel = new JLabel("PC");
        this.marLabel = new JLabel("MAR");
        this.mbrLabel = new JLabel("MBR");
        this.irLabel = new JLabel("IR");
        this.mfrLabel = new JLabel("MFR");
        this.privilegedLabel = new JLabel("PRIVILEGED");
        this.operationsOpcodeLabel = new JLabel("OPERATIONS");
        this.gprOpcodeLabel = new JLabel("GPR");
        this.ixrOpcodeLabel = new JLabel("IXR");
        this.indirectModeOpcodeLabel = new JLabel("I");
        this.addressOpcodeLabel = new JLabel("ADDRESS");
        this.haltLabel =  new JLabel("HALT");
        this.runLabel = new JLabel("RUN");
        this.opcodeLabel = new JLabel("OPCODE (in hexa)");
        this.consoleLabel = new JLabel("Console Input (in decimal)");
    }

    private void applyStylesLabel() {
        this.gprZeroLabel.setBounds(30,30,200,40);
        this.gprOneLabel.setBounds(30,100,200,40);
        this.gprTwoLabel.setBounds(30,170,200,40);
        this.gprThreeLabel.setBounds(30,240,200,40);
        this.ixrOneLabel.setBounds(30,310,200,40);
        this.ixrTwoLabel.setBounds(30,380,200,40);
        this.ixrThreeLabel.setBounds(30,450,200,40);
        this.programControlLabel.setBounds(400,30,200,40);
        this.marLabel.setBounds(400,100,200,40);
        this.mbrLabel.setBounds(400,170,200,40);
        this.irLabel.setBounds(400,240,200,40);
        this.mfrLabel.setBounds(400,310,200,40);
        this.privilegedLabel.setBounds(400,380,200,40);
        this.operationsOpcodeLabel.setBounds(170,750,200,40);
        this.gprOpcodeLabel.setBounds(490,750,200,40);
        this.ixrOpcodeLabel.setBounds(650,750,200,40);
        this.indirectModeOpcodeLabel.setBounds(792,750,200,40);
        this.addressOpcodeLabel.setBounds(990,750,200,40);
        this.haltLabel.setBounds(600,650,200,40);
        this.runLabel.setBounds(600,710,200,40);
        this.opcodeLabel.setBounds(30,675,200,40);
        this.consoleLabel.setBounds(900,80,200,40);
    }

    private void addLabels() {
        add(gprZeroLabel);
        add(gprOneLabel);
        add(gprTwoLabel);
        add(gprThreeLabel);
        add(ixrOneLabel);
        add(ixrTwoLabel);
        add(ixrThreeLabel);
        add(programControlLabel);
        add(marLabel);
        add(mbrLabel);
        add(irLabel);
        add(mfrLabel);
        add(privilegedLabel);
        add(operationsOpcodeLabel);
        add(gprOpcodeLabel);
        add(ixrOpcodeLabel);
        add(indirectModeOpcodeLabel);
        add(addressOpcodeLabel);
        add(haltLabel);
        add(runLabel);
        add(opcodeLabel);
        add(consoleLabel);
    }

    private void updateOrSetAllTextFieldValues() {
//        String opcode = service.simulator.getOpcode().getOperations() + " "
//                + service.simulator.getOpcode().getGeneralPurposeRegister() + " "
//                + service.simulator.getOpcode().getIndexRegister() + " "
//                + service.simulator.getOpcode().getIndirectMode() + " "
//                + service.simulator.getOpcode().getAddress();
//        setComponentValue(this.opcodeTextField, opcode);

        setComponentValue(this.programControlTextField, service.simulator.getProgramControl());
        setComponentValue(this.marTextField, service.simulator.getMemoryAddressRegister());
        setComponentValue(this.mbrTextField, service.simulator.getMemoryBufferRegister());
        setComponentValue(this.irTextField, service.simulator.getInstructionRegister());
        setComponentValue(this.mfrTextField, service.simulator.getMemoryFaultRegister());
        setComponentValue(this.privilegedTextField, service.simulator.getPrivileged());

        setComponentValue(this.gprZeroTextField,
                service.simulator.getGeneralPurposeRegister().getRegisterZero());
        setComponentValue(this.gprOneTextField,
                service.simulator.getGeneralPurposeRegister().getRegisterOne());
        setComponentValue(this.gprTwoTextField,
                service.simulator.getGeneralPurposeRegister().getRegisterTwo());
        setComponentValue(this.gprThreeTextField,
                service.simulator.getGeneralPurposeRegister().getRegisterThree());

        setComponentValue(this.ixrOneTextField,
                service.simulator.getIndexRegister().getRegisterOne());
        setComponentValue(this.ixrTwoTextField,
                service.simulator.getIndexRegister().getRegisterTwo());
        setComponentValue(this.ixrThreeTextField,
                service.simulator.getIndexRegister().getRegisterThree());

        setComponentValue(this.haltTextField, service.simulator.getHalt());
        setComponentValue(this.runTextField, service.simulator.getRun());
    }

    private void setComponentValue(JTextField textFieldComponent, String value) {
        if (!isValidValue(value)) {
            value = "";
        }
        textFieldComponent.setText(value);
    }

    /**
     * Check whether the value string contains some value
     * @param value String to be validate
     * @return True only if the value string contains the non-null values
     */
    private boolean isValidValue(String value) {
        if (value == null || value.isBlank() || value.isEmpty()) {
            return false;
        }
        return true;
    }
    private void addComponentListeners() {
        pcLoadButton.addActionListener(event -> {
            //Exits listener if the value from opcode text field is empty or invalid.
            if (!isValidValue(opcodeTextField.getText())) return;
            service.programControlListener(opcodeTextField.getText());
            setComponentValue(programControlTextField, service.simulator.getProgramControl());
        });

        marLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.memoryAddressRegisterListener(opcodeTextField.getText());
            setComponentValue(marTextField, service.simulator.getMemoryAddressRegister());
        });

        mbrLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.memoryBufferRegisterListener(opcodeTextField.getText());
            setComponentValue(mbrTextField, service.simulator.getMemoryBufferRegister());
        });

        gprZeroLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.gprZeroListener(opcodeTextField.getText());
            setComponentValue(gprZeroTextField,
                    service.simulator.getGeneralPurposeRegister().getRegisterZero());
        });

        gprOneLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.gprOneListener(opcodeTextField.getText());
            setComponentValue(gprOneTextField,
                    service.simulator.getGeneralPurposeRegister().getRegisterOne());
        });

        gprTwoLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.gprTwoListener(opcodeTextField.getText());
            setComponentValue(gprTwoTextField,
                    service.simulator.getGeneralPurposeRegister().getRegisterTwo());
        });

        gprThreeLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.gprThreeListener(opcodeTextField.getText());
            setComponentValue(gprThreeTextField,
                    service.simulator.getGeneralPurposeRegister().getRegisterThree());
        });

        ixrOneLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.ixrOneListener(opcodeTextField.getText());
            setComponentValue(ixrOneTextField,
                    service.simulator.getIndexRegister().getRegisterOne());
        });

        ixrTwoLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.ixrTwoListener(opcodeTextField.getText());
            setComponentValue(ixrTwoTextField,
                    service.simulator.getIndexRegister().getRegisterTwo());
        });

        ixrThreeLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.ixrThreeListener(opcodeTextField.getText());
            setComponentValue(ixrThreeTextField,
                    service.simulator.getIndexRegister().getRegisterThree());
        });

        mainLoadButton.addActionListener(event -> {
            if (!isValidValue(service.simulator.getMemoryAddressRegister())) return;
            service.mainLoadButtonListener();
            setComponentValue(mbrTextField, service.simulator.getMemoryBufferRegister());
        });

        showMemoryButton.addActionListener(event -> {
            JDialog memoryDialog = new JDialog(this, "Main Memory");
            JTextArea textArea = new JTextArea(5,5);
            if ((service.mainMemory == null) || (service.mainMemory.size() == 0)) {
                textArea.setText("No data in memory. Please upload the IPL.txt file.\n" +
                        "To get updated value, close the dialog and open again.");
            } else {
                int index = 0;
                String memoryData = "";
                for (String content : service.mainMemory) {
                    String memoryString = index + " ( " +
                            CommonUtils.convertDecimalToHexadecimal(CommonUtils.convertIntegerToString(index))
                            + " ) " + " - " + content + " ( " +
                            CommonUtils.convertDecimalToHexadecimal(content) +  " )" + "\n";
                    memoryData += memoryString;
                    index++;
                }
                textArea.setText(memoryData+"To get updated value, close the dialog and open again.");
            }
            textArea.setEditable(false);
            JScrollPane scroll = new JScrollPane (textArea,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            add(scroll);
            setVisible(true);
            memoryDialog.add(scroll);
            memoryDialog.setSize(500, 500);
            memoryDialog.setVisible(true);
        });

        storeButton.addActionListener(event -> {
            if (!isValidValue(service.simulator.getMemoryBufferRegister())) return;
            if (!isValidValue(service.simulator.getMemoryAddressRegister())) return;
            service.mainStoreButtonListener();
        });

        storePlusButton.addActionListener(event -> {

        });

        singleStepButton.addActionListener(event -> {
            if (!isValidValue(service.simulator.getProgramControl())) return;
            service.singleStepListener();
            updateOrSetAllTextFieldValues();
        });

        runButton.addActionListener(event -> {
            service.runListener();
            updateOrSetAllTextFieldValues();
        });

        initButton.addActionListener(event -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = fileChooser.showOpenDialog(null);
            System.out.println(returnValue);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                service.readInputFile(selectedFile.getAbsolutePath());
            }
            updateOrSetAllTextFieldValues();
        });

        programOneButton.addActionListener(event -> {
            service.simulator.setProgramControl("001D");
            service.singleStepListener();
            updateOrSetAllTextFieldValues();
            programOneControl();
        });

        controlInputButton.addActionListener(event -> {
            String instructionCode = CommonUtils.convertBinaryToOctalNumber(
                    service.simulator.getOpcode().getOperations());
            String consoleInputText = "";
            if (instructionCode.equals("61")) {
                consoleInputText = CommonUtils.convertDecimalToHexadecimal(
                        consoleInputTextField.getText());
                service.setDataInMainMemoryByLocation(consoleInputText,
                        CommonUtils.incrementHexadecimal(programOneMemoryStart, programOneInputCounter));
                consoleInputTextField.setText("");
                programOneInputCounter++;
                service.singleStepListener();
                updateOrSetAllTextFieldValues();
                programOneControl();
            }
        });
    }

    private void programOneControl() {
        String instructionCode = CommonUtils.convertBinaryToOctalNumber(
                service.simulator.getOpcode().getOperations());
        while(!instructionCode.equals("61") && !instructionCode.equals("62")) {
            service.singleStepListener();
            updateOrSetAllTextFieldValues();
            instructionCode = CommonUtils.convertBinaryToOctalNumber(
                    service.simulator.getOpcode().getOperations());
        }
        if (instructionCode.equals("61")) {
            consoleInputHandler();
        }

        if (instructionCode.equals("62")) {
            consoleOutputHandler();
        }
        updateOrSetAllTextFieldValues();
    }

    private void consoleInputHandler() {
        String instructionCode = CommonUtils.convertBinaryToOctalNumber(
                service.simulator.getOpcode().getOperations());
        if (programOneInputCounter < 20) {
            this.consoleOutputTextField.setText("Please enter the input " + (programOneInputCounter+1) +
                    " and load it");
        } else {
            String consoleText = "The numbers you've entered are ...\n";
            for (int i=0; i<20; i++) {
                consoleText += CommonUtils.convertHexadecimalToDecimal(service.getDataFromMainMemoryByLocation(
                        CommonUtils.incrementHexadecimal(programOneMemoryStart, i))) + " ";
            }
            consoleText += "\n";
            this.consoleOutputTextField.setText(consoleText +
                    "Please enter the exact or closest \nnumber to search and load it");
        }
    }

    private void consoleOutputHandler() {
        int globalDifference = 0;
        int minValue = 0;
        int searchValue = CommonUtils.convertHexadecimalToDecimal(
                service.getDataFromMainMemoryByLocation(programOneSearchLocation));

        String consoleText = "The numbers you've entered are ...\n";
        for (int i=0; i<20; i++) {
            String userInputHexadecimal = service.getDataFromMainMemoryByLocation(
                    CommonUtils.incrementHexadecimal(programOneMemoryStart, i));
            int userInputDecimal = CommonUtils.convertHexadecimalToDecimal(userInputHexadecimal);
            int difference = Math.abs(userInputDecimal - searchValue);

            if (i == 0) {
                globalDifference = difference;
                minValue = userInputDecimal;
                consoleText += userInputDecimal + " ";
                continue;
            }

            if (difference < globalDifference) {
                globalDifference = difference;
                minValue = userInputDecimal;
            }
            consoleText += userInputDecimal + " ";
        }
        consoleText += "\n";
        this.consoleOutputTextField.setText(consoleText + "The closest number is "+minValue);
    }
}
