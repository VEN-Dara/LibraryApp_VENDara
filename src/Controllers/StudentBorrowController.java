package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Config.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class StudentBorrowController implements Initializable{

    @FXML
    private TableColumn<Book, String> authorCartCol;

    @FXML
    private TableColumn<Book,String > authorCol;

    @FXML
    private TextField authorField;

    @FXML
    private Button borrowBtn;

    @FXML
    private TextField borrowField;

    @FXML
    private Button cartBtn;
    
    @FXML
    private TextField studentIdField;

    @FXML
    private TableColumn<Book, String> idCardCol;

    @FXML
    private TableColumn<Book, String> idCol;

    @FXML
    private TextField idFeild;

    @FXML
    private TableView<Book> tableView;

    @FXML
    private TableColumn<Book, String> titleCartCol;

    @FXML
    private TableColumn<Book, String> titleCol;

    @FXML
    private TextField titleField;

    @FXML
    void getItem(MouseEvent event) {
        Integer index = tableView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        idFeild.setText(idCol.getCellData(index).toString());
        titleField.setText(titleCol.getCellData(index).toString());
        authorField.setText(authorCol.getCellData(index).toString());
        
    }
    public ObservableList<Book> getBookList() throws SQLException {
        ObservableList<Book> bookList = FXCollections.observableArrayList();
        try {
            Connection conn = DatabaseConnection.conn();
            String sql = "SELECT * FROM testbook2";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Book book;
            while (resultSet.next()) {
                book = new Book(resultSet.getString("bookId"), resultSet.getString("title"),
                        resultSet.getString("author"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;

    }

    public void showBook() throws SQLException {
        ObservableList<Book> list = getBookList();
        idCol.setCellValueFactory(new PropertyValueFactory<Book, String>("bookId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        tableView.setItems(list);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showBook();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cart> cartList = new ArrayList<>();
      @FXML
    void addToCart(ActionEvent event) {
        int length = cartList.size(); 
        String bookId = idFeild.getText();
        String studentId = studentIdField.getText();
        //System.out.println(length);
        if(length<=5) {
            cartList.add(new Cart(bookId, studentId));
        }else{
            System.out.println(" error you carts is fulled!");
        }
    }

    
    @FXML
    void handleBorrow(ActionEvent event) {
        String sql = "insert into testborrow2 (studentId, bookId) values ";
        for(Cart c : cartList){
            String studentId = c.getStudentId();
            String bookId = c.getBookId();
            sql += "('" +studentId+"','" + bookId +"'),"; 
        }
        sql = sql.substring(0, sql.length()-1);
        Connection conn = DatabaseConnection.conn();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            int a = stmt.executeUpdate();
            if(a==0) {
                System.out.println("Error");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
