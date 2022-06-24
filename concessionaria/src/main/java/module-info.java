module projeto.concessionaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens projeto.concessionaria to javafx.fxml;
    exports projeto.concessionaria;
}