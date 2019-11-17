package gui;

import javafx.scene.control.TextArea;

public class FormattedTextArea extends TextArea {

    private TextArea displayText;

    FormattedTextArea()
    {
        super();
        super.setEditable(false);
        super.setMinSize(700, 300);
    }
}
