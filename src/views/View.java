package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ctrl.IControllerForView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Rarete;

/**
 * Code behind qui gère la logique de vue uniquement.
 */
public class View implements IViewForController, Initializable {

    private final IControllerForView controller;

    @FXML
    private Button btnImporter;

    @FXML
    private Button btnIndexer;

    @FXML
    private Button btnRapido0;

    @FXML
    private Button btnRapido1;

    @FXML
    private Button btnRapido2;

    @FXML
    private Button btnRapido3;

    @FXML
    private Button btnRapido4;

    @FXML
    private Button btnRapido5;

    @FXML
    private ComboBox<Rarete> cbxRapido4;

    @FXML
    private ProgressIndicator piImportation;

    @FXML
    private TextArea txtAreaRapports;

    /**
     * Constructeur de la vue
     * 
     * @param controller Le controller qui gère l'application et qui a créé cette
     *                   vue
     */
    public View(IControllerForView controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        Platform.startup(() -> {
            try {
                Stage mainStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
                fxmlLoader.setControllerFactory(type -> {
                    return this;
                });
                Parent root = (Parent) fxmlLoader.load();
                Scene principalScene = new Scene(root);
                mainStage.setScene(principalScene);
                mainStage.setTitle("Brawlstar Database");
                mainStage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
                Platform.exit();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void onImporter(ActionEvent event) {
        controller.importation();
        btnIndexer.setDisable(false);
    }

    @FXML
    void onIndexer(ActionEvent event) {
        controller.indexer();
        btnRapido0.setDisable(false);
        btnRapido1.setDisable(false);
        btnRapido2.setDisable(false);
        btnRapido3.setDisable(false);
        cbxRapido4.setDisable(false);
        btnRapido4.setDisable(false);
        btnRapido5.setDisable(false);

        cbxRapido4.getItems().addAll(controller.getRapido4List());
        cbxRapido4.getSelectionModel().selectFirst();

    }

    @FXML
    void onRapido0(ActionEvent event) {
        controller.onRapido0Click();
    }

    @FXML
    void onRapido1(ActionEvent event) {
        controller.onRapido1Click();
    }

    @FXML
    void onRapido2(ActionEvent event) {
        controller.onRapido2Click();
    }

    @FXML
    void onRapido3(ActionEvent event) {
        controller.onRapido3Click();
    }

    @FXML
    void onRapido4(ActionEvent event) {
        controller.onRapido4Click(cbxRapido4.getSelectionModel().getSelectedItem());
    }

    @FXML
    void onRapido5(ActionEvent event) {
        controller.onRapido5Click();
    }

    // @Override
    // public void messageInfo(String message) {
    // Platform.runLater(() -> {
    // Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
    // alert.setHeaderText(null);
    // alert.showAndWait();
    // });
    // }

    // @Override
    // public void messageErreur(String message) {
    // Platform.runLater(() -> {
    // Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
    // alert.setHeaderText(null);
    // alert.showAndWait();
    // });
    // }

    @Override
    public void afficheRapport(String rapport) {
        Platform.runLater(() -> {
            txtAreaRapports.clear();
            txtAreaRapports.setText(rapport);
        });
    }

}
