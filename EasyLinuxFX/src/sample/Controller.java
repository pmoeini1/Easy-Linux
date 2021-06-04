package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;

public class Controller {
    @FXML
    private TextField text;
    @FXML
    private Label out;

    // show present working directory
    public void presentDirectory() {
        out.setText("Present Working Directory: " + System.getProperty("user.dir"));
    }
    // change current directory completely
    public void currentDirectory(){
        System.setProperty("user.dir", text.getText());
        out.setText("Present Working Directory: " + System.getProperty("user.dir"));
    }
    // change to a path in current folder
    public void currentInFolder() {
        String path = System.getProperty("user.dir") + "\\" + text.getText();
        System.setProperty("user.dir", path);
        out.setText("Present Working Directory: " + System.getProperty("user.dir"));
    }
    // make folder
    public void makeDir() {
        File f = new File(System.getProperty("user.dir"));
        if (f.mkdir()) {
            out.setText("Folder created");
        } else {
            out.setText("Folder creation failed");
        }
    }

    // list all paths "below" current folder
    public void list() {
        File f = new File(System.getProperty("user.dir"));
        String[] list = f.list();
        StringBuilder sb = new StringBuilder();
        if (list.length < 1) {
            out.setText("Empty folder");
            return;
        }
        for (int i = 0; i < list.length; i++) {
            sb.append("\n" + list[i]);
            if (i > 9) {
                sb.append("\n ...");
                break;
            }
        }
        out.setText(sb.toString());
    }

}
