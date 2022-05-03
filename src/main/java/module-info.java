module com.example.gameoflifetdd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.gameoflifetdd to javafx.fxml;
    exports com.example.gameoflifetdd;
}