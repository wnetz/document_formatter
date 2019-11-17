package gui;


import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ConsoleTextFlow extends TextArea {

    ConsoleTextFlow()
    {
        super();
        super.setEditable(false);
        super.setMinSize(700, 150);
    }

    public void logError(String text)
    {
        this.addMessage(text, "#4F8A10");
    }

    public void logWarning(String text)
    {
        this.addMessage(text, "#FFFFFF");
    }

    private void addMessage(String text, String hexColor)
    {
        Text log = new Text(text);
        log.setStyle("-fx-text-fill: " + hexColor);
        super.getChildren().add(log);
    }
}
