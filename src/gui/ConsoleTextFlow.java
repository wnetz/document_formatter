package gui;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class ConsoleTextFlow extends TextFlow {

    ConsoleTextFlow()
    {
        super();
        super.setMinSize(700, 150);
    }

    public void clear()
    {
        super.getChildren().clear();
    }

    public void logError(String text)
    {
        this.addMessage(text, Color.RED);
    }

    public void logWarning(String text)
    {
        this.addMessage(text, Color.GOLD);
    }

    private void addMessage(String text, Color color)
    {
        Text log = new Text(text + "\n");
        log.setFill(color);
        super.getChildren().add(log);
    }
}
