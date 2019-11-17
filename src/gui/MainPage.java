package gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import format.TextProcessor;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class MainPage extends VBox {

    private FileChooser fileChooser;
    private FormattedTextArea formattedTextArea;
    private ConsoleTextFlow console;

    public MainPage()
    {
        fileChooser = new FileChooser();

        Label title = new Label("Document Formatter");
        title.setFont(Font.font("Ariel", FontWeight.BOLD, 24));
        title.setTranslateX(super.getWidth()/2);

        formattedTextArea = new FormattedTextArea();
        console = new ConsoleTextFlow();

        Menu files = new Menu("File");
        MenuItem openFile = new MenuItem("Load");
        openFile.setOnAction(new LoadHandler());
        MenuItem saveFile = new MenuItem("Save As");
        saveFile.setOnAction(new SaveHandler());
        files.getItems().addAll(openFile, saveFile);

        Menu help = new Menu("Help");

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(files, help);

        super.getChildren().addAll(menuBar, title, formattedTextArea, console);
    }

    private static boolean isTextFile(File file)
    {
        return file != null && file.getPath().contains(".txt");
    }

    private class LoadHandler implements EventHandler
    {
        @Override
        public void handle(Event event) {
            File file = fileChooser.showOpenDialog(new Stage());
            if(isTextFile(file) && file.canRead()) {
                formattedTextArea.clear();
                console.clear();
                try {
                    ArrayList<String> outputDoc = TextProcessor.processInputFile(file);
                    for(String line : outputDoc) {
                        formattedTextArea.appendText(line);
                    }
                } catch (IOException ex) {
                    console.logError(ex.toString());
                }
            } else {
                console.logError("The file selected is not a valid text file.");
            }
        }
    }

    private class SaveHandler implements EventHandler
    {
        @Override
        public void handle(Event event) {
            File file = fileChooser.showSaveDialog(new Stage());
            if(isTextFile(file) && file.canWrite()) {
                System.out.println(file);
            } else {
                console.logError("The path could not be written to. Please use a valid .txt file.");
            }
        }
    }
}
