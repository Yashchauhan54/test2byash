module org.example.test2yash {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens org.example.test2yash to javafx.fxml;
    exports org.example.test2yash;
}