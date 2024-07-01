package ru.novikova.complexnumbercalculator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.novikova.complexnumbercalculator.number.ComplexNumber;
import ru.novikova.complexnumbercalculator.number.DoubleNumber;

import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    private CalcService calcService;
    private Stage window;
    @FXML
    public TextField realFirstNumberTF;
    @FXML
    public TextField imaginaryFirstNumberTF;
    @FXML
    public TextField realSecondNumberTF;
    @FXML
    public TextField imaginarySecondNumberTF;
    @FXML
    public TextField realResTF;
    @FXML
    public TextField imaginaryResTF;
    @FXML
    public ComboBox<String> operationCB;
    private ObservableList<String> operationList = FXCollections.observableArrayList("+", "-", "*");


    public void calculate(ActionEvent actionEvent) {
        if (checkTF()) {
            if(Double.parseDouble(realFirstNumberTF.getText())<0.0){

            }
            ComplexNumber first = new ComplexNumber(new DoubleNumber
                    (Double.parseDouble(realFirstNumberTF.getText())))
        }
    }

    private boolean checkTF() {
        try {
            if (realFirstNumberTF.getText().isBlank() ||
                    realSecondNumberTF.getText().isBlank() ||
                    imaginarySecondNumberTF.getText().isBlank() ||
                    imaginaryFirstNumberTF.getText().isBlank()) {
                return false;
            } else {
                Double.parseDouble(realFirstNumberTF.getText());
                Double.parseDouble(imaginaryFirstNumberTF.getText());
                Double.parseDouble(realSecondNumberTF.getText());
                Double.parseDouble(imaginarySecondNumberTF.getText());
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void clear(ActionEvent actionEvent) {
        operationCB.getSelectionModel().select(0);
        realFirstNumberTF.clear();
        realResTF.clear();
        realSecondNumberTF.clear();
        imaginaryResTF.clear();
        imaginaryFirstNumberTF.clear();
        imaginarySecondNumberTF.clear();
        realFirstNumberTF.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        operationCB.getItems().addAll(operationList);
        operationCB.getSelectionModel().select(0);
        calcService = new CalcService();
    }
}