module org.example.parcialfinalpoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.parcialfinalpoo to javafx.fxml;
    exports org.example.parcialfinalpoo.views;
    opens org.example.parcialfinalpoo.views to javafx.fxml;
    exports org.example.parcialfinalpoo.controllers;
    opens org.example.parcialfinalpoo.controllers to javafx.fxml;
}