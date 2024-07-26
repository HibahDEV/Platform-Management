module com.example.gestionplateforme {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.gestionplateforme to javafx.fxml;
    exports com.example.gestionplateforme;
}