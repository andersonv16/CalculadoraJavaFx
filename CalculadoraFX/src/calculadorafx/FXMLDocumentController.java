/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorafx;

import java.net.URL;
import java.util.ResourceBundle;
import javax.script.ScriptEngine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 * FXML Controller class
 *
 * @author Ander
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button sete;
    @FXML
    private Button oito;
    @FXML
    private Button nove;
    @FXML
    private Button divisao;
    @FXML
    private Button quatro;
    @FXML
    private Button cinco;
    @FXML
    private Button seis;
    @FXML
    private Button multip;
    @FXML
    private Button um;
    @FXML
    private Button dois;
    @FXML
    private Button tres;
    @FXML
    private Button subtracao;
    @FXML
    private Button zero;
    @FXML
    private Button ponto;
    @FXML
    private Button igual;
    @FXML
    private Button soma;
    @FXML
    private Button parent1;
    @FXML
    private Button parentv2;
    @FXML
    private Button potenc;
    @FXML
    private Button clean;
    @FXML
    private TextField visor;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acaoDigitar(KeyEvent event) throws ScriptException {
       if (event.getCode() == KeyCode.NUMPAD1 || 
               event.getCode() == KeyCode.DIGIT1){
         visor.setText(visor.getText() + 1);
       }
       else if (event.getCode() == KeyCode.BACK_SPACE){
           String text = visor.getText();
           if(text!=null&&text!=""&&text.length()>0){
            text=text.substring(0,text.length()-1);
            visor.setText(text);
       }
       }
      else if (event.getCode() == KeyCode.NUMPAD2  ||
              event.getCode() == KeyCode.DIGIT2) {
         visor.setText(visor.getText() + 2);
       }
       else if (event.getCode() == KeyCode.NUMPAD3 ||
               event.getCode() == KeyCode.DIGIT3){
         visor.setText(visor.getText() + 3);
       }
       else if (event.getCode() == KeyCode.NUMPAD4 ||
               event.getCode() == KeyCode.DIGIT4){
         visor.setText(visor.getText() + 4);
       }
       else if (event.getCode() == KeyCode.NUMPAD5 || 
               event.getCode() == KeyCode.DIGIT5 ){
         visor.setText(visor.getText() + 5);
       }
        else if (event.getCode() == KeyCode.NUMPAD6 ||
                event.getCode() == KeyCode.DIGIT6){
         visor.setText(visor.getText() + 6);
       }
        else if (event.getCode() == KeyCode.NUMPAD7||
                event.getCode() == KeyCode.DIGIT7){
         visor.setText(visor.getText() + 7);
       }
        else if (event.getCode() == KeyCode.NUMPAD8 ||
                event.getCode() == KeyCode.DIGIT8){
         visor.setText(visor.getText() + 8);
       }
       else if (event.getCode() == KeyCode.NUMPAD9 ||
               event.getCode() == KeyCode.DIGIT9){
         visor.setText(visor.getText() + 9);
       }
       else if (event.getCode() == KeyCode.NUMPAD0 ||
               event.getCode() == KeyCode.DIGIT0){
         visor.setText(visor.getText() + 0);
       }
       else if (event.getCode() == KeyCode.OPEN_BRACKET){
         visor.setText(visor.getText() + '(' );
       }
        else if (event.getCode() == KeyCode.CLOSE_BRACKET){
         visor.setText(visor.getText() + ')' );
       }
         else if (event.getCode() == KeyCode.DELETE){
         visor.setText("");
       }
        else if (event.getCode() == KeyCode.PLUS ||
                event.getCode() == KeyCode.ADD){
          visor.setText(visor.getText() + '+' );
       }
        else if (event.getCode() == KeyCode.SUBTRACT ||
                event.getCode() == KeyCode.MINUS){
          visor.setText(visor.getText() + '-' );
       } 
        else if (event.getCode() == KeyCode.MULTIPLY){
          visor.setText(visor.getText() + '*' );
       } 
           else if (event.getCode() == KeyCode.DIVIDE){
          visor.setText(visor.getText() + '/' );
       }    
        else if (event.getCode() == KeyCode.EQUALS ||
                event.getCode() == KeyCode.ENTER){
          Object calc = "Error" ;
              try {
          String result = visor.getText(); 
          ScriptEngineManager manager = new ScriptEngineManager();
          ScriptEngine engine = manager.getEngineByName("js");
           calc = engine.eval(result);
              }
              catch (ScriptException e){
               visor.setText("Operação Invalida!!");
              }
          visor.setText(String.valueOf(calc));
          ponto.disableProperty().set(false);
       }
    }

    @FXML
    private void acaoBotao(ActionEvent event) throws ScriptException {
    
        String number = getButtonValue(event);
        String textResult = visor.getText();
        if(".".equals(number.trim())){
            boolean contains = textResult.contains(".");
            if(contains||isBlank(textResult)){
                return;
            }else {
                visor.setText(textResult+".");
                return;
            }
        }
        visor.setText(visor.getText()+number);

        if (event.getSource() == clean){
              visor.setText(" ");
              ponto.disableProperty().set(false);
    }
         else if (event.getSource() == soma){
          visor.setText(visor.getText());
          ponto.disableProperty().set(false);
    
       }
            else if (event.getSource() == subtracao){
          visor.setText(visor.getText());
          ponto.disableProperty().set(false);
    
       }
            else if (event.getSource() == multip){
          visor.setText(visor.getText().replace('X', '*'));
          ponto.disableProperty().set(false);
    
       }
          else if (event.getSource() == divisao){
          visor.setText(visor.getText());
          ponto.disableProperty().set(false);
    
       }
    }
    
                @FXML
          private void acaoIgual(ActionEvent event) throws ScriptException{
          Object calc = "Erro";
          try {
          ScriptEngineManager manager = new ScriptEngineManager();
          ScriptEngine engine = manager.getEngineByName("js");
          calc = engine.eval(visor.getText());  
              }
              catch (ScriptException e){
               visor.setText("Operação Invalida!!");
              }
          visor.setText(String.valueOf(calc));
          ponto.disableProperty().set(false);
          }
       
            @FXML
        void acaoPonto(MouseEvent event) {
         visor.setText(visor.getText() + ".");
         ponto.disableProperty().set(true);
    }
        
     
    private String getButtonValue(ActionEvent event){
        Button acaoBotao = (Button)event.getSource();
        return acaoBotao.getText();
    
    }
    
    private boolean isBlank(String text){
        if(text!=null&&text!=""&&text.length()>0){
            return false;
        }
        return true;
    }
 

}
