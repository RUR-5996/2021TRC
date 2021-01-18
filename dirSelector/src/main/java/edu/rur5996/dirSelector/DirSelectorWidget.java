package edu.rur5996.dirSelector;

import edu.wpi.first.shuffleboard.api.data.types.StringType;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;

@Description(dataTypes = {StringType.class}, name = "DirectionSelector")
@ParametrizedController(value = "DirSelectorWidget.fxml")
public class DirSelectorWidget extends SimpleAnnotatedWidget<String> {

    @FXML
    protected AnchorPane _thePane;

    @FXML 
    protected ToggleGroup _imageTG;

    @FXML
    protected TextField _selected;

    public Pane getView() {

        _imageTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if(_imageTG.getSelectedToggle() != null) {
                    RadioButton selectedButton = (RadioButton) _imageTG.getSelectedToggle();
                    _selected.setText(selectedButton.getId());
                }
            }
        });

        _thePane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number old_number, Number new_number) {
               double multiplier = new_number.doubleValue()/100;
               for(Node node : _thePane.getChildren()) {
                   node.setTranslateY(node.getLayoutY() * multiplier - node.getLayoutY());
                   node.setScaleY(multiplier/2);
               }
            }
        });

        _thePane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number old_number, Number new_number) {
                double multiplier = new_number.doubleValue()/100;
                for(Node node : _thePane.getChildren()) {
                    node.setTranslateX(node.getLayoutX() * multiplier - node.getLayoutX());
                    node.setScaleX(multiplier/4);
                }
            }
        });

        this.dataProperty().bind(_selected.textProperty());
        return _thePane;
    }

}