package GUI;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FormatPage extends BorderPane {

    private Label title = new Label("Document Formatter");
    private Text displayText;

    FormatPage()
    {
        super();

        title.setFont(Font.font("Ariel", FontWeight.BOLD, 24));
        displayText = new Text();

        super.setTop(title);
        super.setCenter(displayText);
    }

    public void setText(String text)
    {
        this.displayText.setText(text);
    }

}
