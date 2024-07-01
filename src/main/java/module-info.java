module ru.novikova.complexnumbercalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens ru.novikova.complexnumbercalculator to javafx.fxml;
    exports ru.novikova.complexnumbercalculator;
}