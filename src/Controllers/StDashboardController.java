package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StDashboardController {

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TableColumn<?, ?> bookIdColumn;

    @FXML
    private TableColumn<?, ?> borrowDateColumn;

    @FXML
    private TableColumn<?, ?> categoryColumn;

    @FXML
    private Button clearSearchBtn;

    @FXML
    private Button dashBoardBtn;
    
    @FXML
    private Button borrowHistoryBtn;

    @FXML
    private Button editeInfoBtn;

    @FXML
    private Button exploreBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Button returnBtn;

    @FXML
    private TableColumn<?, ?> returnDateColumn;

    @FXML
    private TextField searchField;

    @FXML
    private Text studentName;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private TableColumn<?, ?> yearColumn;

    @FXML
    void handleClearSearch(ActionEvent event) {

    }

    @FXML
    void handleDashboardBtn(ActionEvent event) {

    }
    
    @FXML
    void handleBorrowHistoryBtn(ActionEvent event) {

    }

    @FXML
    void handleEditeBtn(ActionEvent event) {

    }

    @FXML
    void handleExploreBtn(ActionEvent event) {

    }

    @FXML
    void handleLogOut(ActionEvent event) {

    }

    @FXML
    void handleReturnBtn(ActionEvent event) {

    }

    @FXML
    void handleSearchField(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        studentName.setText("VEN Dara");
    }

}