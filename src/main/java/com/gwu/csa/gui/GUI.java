package main.java.com.gwu.csa.gui;

import main.java.com.gwu.csa.service.SimulationService;
import main.java.com.gwu.csa.util.CommonUtils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.Map;

public class GUI extends JFrame {

    private SimulationService service;
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
    private JButton fr0LoadButton;
    private JButton fr1LoadButton;

    private JButton storeButton;
    private JButton storePlusButton;
    private JButton mainLoadButton;
    private JButton initButton;
    private JButton singleStepButton;
    private JButton runButton;
    private JButton showMemoryButton;
    private JButton programOneButton;
    private JButton programTwoButton;
    private JButton controlInputButton;
    private JTextField opcodeTextField;
    private JTextField programControlTextField;
    private JTextField marTextField;
    private JTextField mbrTextField;
    private JTextField irTextField;
    private JTextField mfrTextField;
//    private JTextField privilegedTextField;
    private JTextField floatingRegister0;
    private JTextField floatingRegister1;

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
    private JTextArea cacheTextArea;
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
//    private JLabel privilegedLabel;
    private JLabel operationsOpcodeLabel;
    private JLabel gprOpcodeLabel;
    private JLabel ixrOpcodeLabel;
    private JLabel indirectModeOpcodeLabel;
    private JLabel addressOpcodeLabel;
    private JLabel haltLabel;
    private JLabel runLabel;
    private JLabel opcodeLabel;
    private JLabel consoleLabel;
    private JLabel cacheLabel;
    private JLabel floatingRegister0Label;
    private JLabel floatingRegister1Label;
    private int programOneInputCounter = 0;
    private String programOneMemoryStart = "0022";
    private String programOneSearchLocation = "0036";
    private String searchedWord = "";
    private int wordNumber = 0;
    private int lineNumber = 0;

    /**
     * GUI component initialization
     */
    public GUI() {
        this.service = new SimulationService();
        createGUIComponents();
        applyStylesGUIComponents();
        addGUIComponentsInFrame();
        applyFrameStyle();
        updateOrSetAllTextFieldValues();
        addComponentListeners();
    }


    /**
     * Create GUI components
     */
    private void createGUIComponents() {
        createButtons();
        createTextFields();
        createLabels();
    }

    /**
     * Applying styles to GUI components
     */
    private void applyStylesGUIComponents() {
        applyButtonStyles();
        applyStylesTextFields();
        applyStylesLabel();
    }

    /**
     * Add GUI components to JFrame
     */
    private void addGUIComponentsInFrame() {
        addButtons();
        addTextFields();
        addLabels();
    }

    /**
     * Applying GUI JFrame styles
     */
    private void applyFrameStyle() {
        setSize(300,400);
        setLayout(null);
        setVisible(true);
    }

    /**
     * Create GUI button components
     */
    private void createButtons() {
        this.pcLoadButton = new JButton("LOAD");
        this.marLoadButton = new JButton("LOAD");
        this.mbrLoadButton = new JButton("LOAD");
        this.fr0LoadButton = new JButton("LOAD");
        this.fr1LoadButton = new JButton("LOAD");
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
        this.programTwoButton = new JButton("Program 2");
        this.controlInputButton = new JButton("Load Input");
    }

    /**
     * Apply styles to GUI button components
     */
    private void applyButtonStyles() {
        this.pcLoadButton.setBounds(650,30,70, 40);
        this.marLoadButton.setBounds(650,100,70, 40);
        this.mbrLoadButton.setBounds(650,170,70, 40);
        this.fr0LoadButton.setBounds(650,380,70, 40);
        this.fr1LoadButton.setBounds(650,450,70, 40);
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
        this.programTwoButton.setBounds(1000,30,100, 40);
        this.controlInputButton.setBounds(1070,125,100,40);
    }

    /**
     * Adding GUI button components
     */
    private void addButtons() {
        add(pcLoadButton);
        add(marLoadButton);
        add(mbrLoadButton);
        add(fr0LoadButton);
        add(fr1LoadButton);
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
        add(programTwoButton);
        add(controlInputButton);
    }

    /**
     * Creating GUI button components
     */
    private void createTextFields() {
        this.opcodeTextField = new JTextField();
        this.programControlTextField = new JTextField();
        this.marTextField = new JTextField();
        this.mbrTextField = new JTextField();
        this.irTextField = new JTextField();
        this.mfrTextField = new JTextField();
//        this.privilegedTextField = new JTextField();
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
        this.cacheTextArea = new JTextArea(18,18);
        this.floatingRegister0 = new JTextField();
        this.floatingRegister1 = new JTextField();
    }

    /**
     * Adding styles to GUI text field components
     */
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

//        this.privilegedTextField.setBounds(500,380,100,40);
//        this.privilegedTextField.setEditable(false);

        this.floatingRegister0.setBounds(500,380,100,40);
        this.floatingRegister0.setEditable(false);

        this.floatingRegister1.setBounds(500,450,100,40);
        this.floatingRegister1.setEditable(false);

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

        this.consoleOutputTextField.setBounds(900, 200, 450, 100);
        this.consoleOutputTextField.setEditable(false);
        this.consoleOutputTextField.setText("***Load the IPL.txt file before any execution of instructions***\n" +
                "To execute the programs, please make sure you've loaded\n" +
                "IPL.txt for program one or \n" +
                "Program_two_instructions.txt for program two \n" +
                "Then click the Program buttons to execute.");

        this.cacheTextArea.setBounds(1000, 400, 200, 300);
        this.cacheTextArea.setEditable(false);
        this.cacheTextArea.setText("             Tag  -  Value");
    }

    /**
     * Adding GUI text field components
     */
    private void addTextFields() {
        add(opcodeTextField);
        add(programControlTextField);
        add(marTextField);
        add(mbrTextField);
        add(irTextField);
        add(mfrTextField);
//        add(privilegedTextField);
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
        add(cacheTextArea);
        add(floatingRegister0);
        add(floatingRegister1);
    }

    /**
     * Creating GUI label components
     */
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
//        this.privilegedLabel = new JLabel("PRIVILEGED");
        this.operationsOpcodeLabel = new JLabel("OPERATIONS");
        this.operationsOpcodeLabel = new JLabel("OPERATIONS");
        this.gprOpcodeLabel = new JLabel("GPR");
        this.ixrOpcodeLabel = new JLabel("IXR");
        this.indirectModeOpcodeLabel = new JLabel("I");
        this.addressOpcodeLabel = new JLabel("ADDRESS");
        this.haltLabel =  new JLabel("HALT");
        this.runLabel = new JLabel("RUN");
        this.opcodeLabel = new JLabel("OPCODE (in hexa)");
        this.consoleLabel = new JLabel("Console Input (in decimal)");
        this.cacheLabel = new JLabel("Cache");
        this.floatingRegister0Label = new JLabel("FR0");
        this.floatingRegister1Label = new JLabel("FR1");
    }

    /**
     * Adding styles to GUI label components
     */
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
//        this.privilegedLabel.setBounds(400,380,200,40);
        this.operationsOpcodeLabel.setBounds(170,750,200,40);
        this.gprOpcodeLabel.setBounds(490,750,200,40);
        this.ixrOpcodeLabel.setBounds(650,750,200,40);
        this.indirectModeOpcodeLabel.setBounds(792,750,200,40);
        this.addressOpcodeLabel.setBounds(990,750,200,40);
        this.haltLabel.setBounds(600,650,200,40);
        this.runLabel.setBounds(600,710,200,40);
        this.opcodeLabel.setBounds(30,675,200,40);
        this.consoleLabel.setBounds(900,80,200,40);
        this.cacheLabel.setBounds(1000, 220, 200, 300);
        this.floatingRegister0Label.setBounds(400,380,200,40);
        this.floatingRegister1Label.setBounds(400,450,200,40);
    }

    /**
     * Adding GUI label components
     */
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
//        add(privilegedLabel);
        add(operationsOpcodeLabel);
        add(gprOpcodeLabel);
        add(ixrOpcodeLabel);
        add(indirectModeOpcodeLabel);
        add(addressOpcodeLabel);
        add(haltLabel);
        add(runLabel);
        add(opcodeLabel);
        add(consoleLabel);
        add(cacheLabel);
        add(floatingRegister0Label);
        add(floatingRegister1Label);
    }

    private void haltOperation() {
        if (service.simulator.getProgramControl().equals("0007")) {
            service.simulator.setHalt("1");
            service.simulator.setRun("0");
        } else {
            service.simulator.setHalt("0");
            service.simulator.setRun("1");
        }
    }

    private void mfrOperations() {
        String memoryLocation = service.simulator.getProgramControl();
        if (memoryLocation.equals("000b")) {
            service.simulator.setMemoryFaultRegister("0001");
            return;
        }

        if (memoryLocation.equals("000c")) {
            service.simulator.setMemoryFaultRegister("0010");
            return;
        }

        if (memoryLocation.equals("000d")) {
            service.simulator.setMemoryFaultRegister("0100");
            return;
        }

        if (memoryLocation.equals("000e")) {
            service.simulator.setMemoryFaultRegister("1000");
            return;
        }

        service.simulator.setMemoryFaultRegister("");
    }

    /**
     * Update all the text field values
     */
    public void updateOrSetAllTextFieldValues() {
        System.out.println("Update" + service.simulator.getFR0());
        haltOperation();
        mfrOperations();
        setComponentValue(this.programControlTextField, service.simulator.getProgramControl());
        setComponentValue(this.marTextField, service.simulator.getMemoryAddressRegister());
        setComponentValue(this.mbrTextField, service.simulator.getMemoryBufferRegister());
        setComponentValue(this.irTextField, service.simulator.getInstructionRegister());
        setComponentValue(this.mfrTextField, service.simulator.getMemoryFaultRegister());
        setComponentValue(this.floatingRegister0, service.simulator.getFR0());
        setComponentValue(this.floatingRegister1, service.simulator.getFR1());
//        setComponentValue(this.privilegedTextField, service.simulator.getPrivileged());

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

        cacheUpdate();
    }

    /**
     * Update cache data text field
     */
    private void cacheUpdate() {
        String cacheText = "";

        int counter = 16;
        for (int key : service.cache.keySet())
        {
            if (counter <= 0) {
                break;
            }
            Map<String, String> map = service.cache.get(key);
            for (String mapKey : map.keySet()) {
                cacheText += mapKey + "   " + map.get(mapKey) + "\n";
            }
            counter--;
        }
        this.cacheTextArea.setText(cacheText);
    }

    /**
     * Set the specific component value
     */
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

    /**
     * Listeners for all the buttons in the GUI
     */
    private void addComponentListeners() {

        // Program control load button listener.
        pcLoadButton.addActionListener(event -> {
            //Exits listener if the value from opcode text field is empty or invalid.
            if (!isValidValue(opcodeTextField.getText())) return;
            service.programControlListener(opcodeTextField.getText());
            setComponentValue(programControlTextField, service.simulator.getProgramControl());
        });

        // MAR load button listener.
        marLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.memoryAddressRegisterListener(opcodeTextField.getText());
            setComponentValue(marTextField, service.simulator.getMemoryAddressRegister());
        });

        // MBR load button listener.
        mbrLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.memoryBufferRegisterListener(opcodeTextField.getText());
            setComponentValue(mbrTextField, service.simulator.getMemoryBufferRegister());
        });

        fr0LoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.fr0LoadListener(opcodeTextField.getText());
            setComponentValue(floatingRegister0, service.simulator.getFR0());
        });

        fr1LoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.fr1LoadListener(opcodeTextField.getText());
            setComponentValue(floatingRegister1, service.simulator.getFR1());
        });

        // GPR Zero load button listener.
        gprZeroLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.gprZeroListener(opcodeTextField.getText());
            setComponentValue(gprZeroTextField,
                    service.simulator.getGeneralPurposeRegister().getRegisterZero());
        });

        // GPR One load button listener.
        gprOneLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.gprOneListener(opcodeTextField.getText());
            setComponentValue(gprOneTextField,
                    service.simulator.getGeneralPurposeRegister().getRegisterOne());
        });

        // GPR Two load button listener.
        gprTwoLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.gprTwoListener(opcodeTextField.getText());
            setComponentValue(gprTwoTextField,
                    service.simulator.getGeneralPurposeRegister().getRegisterTwo());
        });

        // GPR Three load button listener.
        gprThreeLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.gprThreeListener(opcodeTextField.getText());
            setComponentValue(gprThreeTextField,
                    service.simulator.getGeneralPurposeRegister().getRegisterThree());
        });

        // IXR One load button listener.
        ixrOneLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.ixrOneListener(opcodeTextField.getText());
            setComponentValue(ixrOneTextField,
                    service.simulator.getIndexRegister().getRegisterOne());
        });

        // IXR two load button listener.
        ixrTwoLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.ixrTwoListener(opcodeTextField.getText());
            setComponentValue(ixrTwoTextField,
                    service.simulator.getIndexRegister().getRegisterTwo());
        });

        // IXR three load button listener.
        ixrThreeLoadButton.addActionListener(event -> {
            if (!isValidValue(opcodeTextField.getText())) return;
            service.ixrThreeListener(opcodeTextField.getText());
            setComponentValue(ixrThreeTextField,
                    service.simulator.getIndexRegister().getRegisterThree());
        });

        // Main load button listener.
        mainLoadButton.addActionListener(event -> {
            if (!isValidValue(service.simulator.getMemoryAddressRegister())) return;
            service.mainLoadButtonListener();
            setComponentValue(mbrTextField, service.simulator.getMemoryBufferRegister());
        });

        // Show memory button listener.
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

        // Main store button listener.
        storeButton.addActionListener(event -> {
            if (!isValidValue(service.simulator.getMemoryBufferRegister())) return;
            if (!isValidValue(service.simulator.getMemoryAddressRegister())) return;
            service.mainStoreButtonListener();
        });

        // Main store plus button listener.
        storePlusButton.addActionListener(event -> {

        });

        // Single step button listener.
        singleStepButton.addActionListener(event -> {
            if (!isValidValue(service.simulator.getProgramControl())) return;
            service.singleStepListener();
            updateOrSetAllTextFieldValues();
        });

        // Run button listener.
        runButton.addActionListener(event -> {
            service.runListener();
            updateOrSetAllTextFieldValues();
        });

        // Init button listener.
        initButton.addActionListener(event -> {
            String fileLocation = getFileLocationFromUser();
            this.service = new SimulationService();
            if (!fileLocation.equals("")) {
                service.readInputFile(fileLocation);
            }
            updateOrSetAllTextFieldValues();
        });

        // Program one button listener.
        programOneButton.addActionListener(event -> {
            service.simulator.setProgramControl("001D");
            service.singleStepListener();
            updateOrSetAllTextFieldValues();
            programOneControl();
        });

        // Console input button listener.
        controlInputButton.addActionListener(event -> {
            int programSelect = CommonUtils.convertBinaryToDecimal(
                    service.simulator.getOpcode().getGeneralPurposeRegister());
            if (programSelect == 0) {
                consoleInputForProgramOne();
                return;
            }
            consoleInputHandlerForProgramTwo();
        });

        // Program two button listener.
        programTwoButton.addActionListener(event -> {
            String fileLocation = getFileLocationFromUser();
            if (!fileLocation.equals("")) {
                service.readInputFileForProgramTwo(fileLocation);
            }
            service.simulator.setProgramControl("000F");
            service.singleStepListener();
            programTwoControl();
            updateOrSetAllTextFieldValues();
        });
    }

    /**
     * Program one instruction execution.
     */
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

    /**
     * Handles all the logics need to perform for program onw.
     */
    private void consoleInputForProgramOne() {
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
    }

    /**
     * Console input handler.
     */
    private void consoleInputHandler() {
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

    /**
     * Console outputs handler.
     */
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

    /**
     * Input for program two.
     */
    private void programTwoControl() {
        String inputInstruction = "\n***Please enter the word to be search in console input***";
        this.consoleOutputTextField.setText(service.simulator.getParagraphString() + inputInstruction);
    }

    /**
     * Handles all the logics need to perform for program two.
     */
    private void consoleInputHandlerForProgramTwo() {
        String inputFromConsole = consoleInputTextField.getText();
        service.mainMemory.add(28, "0");
        service.mainMemory.add(29, inputFromConsole);
        String instructionCode = CommonUtils.convertBinaryToOctalNumber(
                service.simulator.getOpcode().getOperations());
        while(CommonUtils.convertHexadecimalToDecimal(
                service.simulator.getGeneralPurposeRegister().getRegisterTwo()) <
                service.mainMemory.size()) {
            if (instructionCode.equals("62")) {
                String success ="Found the word " + searchedWord + "\n"
                        + "Sentence number is " + lineNumber + "\n"
                        + "word number in sentence " + wordNumber;
                consoleOutputTextField.setText(success);
                return;
            }
            if (instructionCode.equals("22")) {
                compareValues();
            }
            if (instructionCode.equals("2")) {
                service.simulator.getIndexRegister().setRegisterTwo("0000");
            }
            service.singleStepListener();
            instructionCode = CommonUtils.convertBinaryToOctalNumber(
                    service.simulator.getOpcode().getOperations());
        }
        String failure ="Word not found!!";
        consoleOutputTextField.setText(failure);
        updateOrSetAllTextFieldValues();
    }

    /**
     * Comparing the GPR0 and IXR2 values for word searching.
     */
    private void compareValues() {
        String dataFromGPRByOpcodeInDecimal = service.getDataFromGPRByOpcodeForMultiplyAndDivision();
        String contentFromGPR = service.mainMemory.get(
                CommonUtils.convertHexadecimalToDecimal(
                        dataFromGPRByOpcodeInDecimal));

        String dataFromIXRByOpcode = service.getDataFromIXRByOpcodeForMultiplyAndDivision();
        String contentFromIXR = service.mainMemory.get(
                CommonUtils.convertHexadecimalToDecimal(
                        dataFromIXRByOpcode));
        int[] cc = service.simulator.getConditionCode();
        if (contentFromGPR.equals(contentFromIXR.substring(4))) {
            searchedWord = contentFromIXR.substring(4);
            lineNumber = CommonUtils.convertStringToInteger(contentFromIXR.substring(0,1));
            wordNumber = CommonUtils.convertStringToInteger(contentFromIXR.substring(2,3));
            cc[3] = 1;
            service.simulator.setConditionCode(cc);
            return;
        }
        cc[3] = 0;
        service.simulator.setConditionCode(cc);
    }

    /**
     * Get the file location from the user
     * @return File location
     */
    private String getFileLocationFromUser() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showOpenDialog(null);
        String fileLocation = "";
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fileLocation = selectedFile.getAbsolutePath();
        }
        return fileLocation;
    }
}
