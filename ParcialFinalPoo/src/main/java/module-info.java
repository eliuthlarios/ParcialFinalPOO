module org.example.parcialfinalpoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.swing;
    requires javafx.media;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;

    exports org.example.parcialfinalpoo;
    opens org.example.parcialfinalpoo to javafx.fxml;
    exports org.example.parcialfinalpoo.views;
    opens org.example.parcialfinalpoo.views to javafx.fxml;
    exports org.example.parcialfinalpoo.controllers;
    opens org.example.parcialfinalpoo.controllers to javafx.fxml;
}