package controlador;

import Modelo.Operaciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Control implements Initializable {
    @FXML
    private RadioButton rdSuma;

    @FXML
    private RadioButton rdMultiplicacion;

    @FXML
    private RadioButton rdDivision;

    @FXML
    private RadioButton rdResta;

    @FXML
    private Button btnOperaciones;

    @FXML
    private TextField txtOperando1;

    @FXML
    private TextField txtOperando2;
    @FXML
    private TextField txtResultado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup tg=new ToggleGroup();
        this.rdSuma.setToggleGroup(tg);
        this.rdResta.setToggleGroup(tg);
        this.rdMultiplicacion.setToggleGroup(tg);
        this.rdDivision.setToggleGroup(tg);
    }
    @FXML
    public void onOperaciones(ActionEvent event) {
        try{
            int op1=Integer.parseInt(this.txtOperando1.getText());
            int op2=Integer.parseInt(this.txtOperando2.getText());
            Operaciones opera=new Operaciones(op1,op2);
            if (this.rdSuma.isSelected()){
                this.txtResultado.setText(opera.sumar()+"");
            }
            else if(this.rdResta.isSelected())
            {
                this.txtResultado.setText(opera.restar()+"");
            }
            else if(this.rdMultiplicacion.isSelected())
            {
                this.txtResultado.setText(opera.multiplicar()+"");
            }
            else if(this.rdDivision.isSelected())
            {
                this.txtResultado.setText(opera.dividir()+"");
            }
        }
        catch (NumberFormatException e){
            Alert Alerta = new Alert(Alert.AlertType.ERROR);
            Alerta.setHeaderText(null);
            Alerta.setTitle("Error");
            Alerta.setContentText("Formato de Error");
            Alerta.showAndWait();

        }

    }
}