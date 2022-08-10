module com.example.projet_inf1163 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.projet_inf1163 to javafx.fxml;
    exports com.example.projet_inf1163;
}