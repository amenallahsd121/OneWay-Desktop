/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.nio.CharBuffer;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class PaiementController implements Initializable {

    @FXML
    private TextField card;
    @FXML
    private TextField m_exp;
    @FXML
    private TextField y_exp;
    @FXML
    private TextField cvc;
    @FXML
    private Button pay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Pay(ActionEvent event) throws Exception {
        
         System.out.println(isNum(m_exp.getText()));
          if ((isValidVisaCardNo(card.getText()) && (!card.getText().isEmpty()) && (isNum(card.getText())))
                && (!m_exp.getText().isEmpty()) && (isNum(m_exp.getText()))
                && (parseInt(y_exp.getText()) >= LocalDate.now().getYear()) && (!y_exp.getText().isEmpty()) && (isNum(y_exp.getText())) && (isNum(cvc.getText()))) {
             float f = (float) 600.5;
             int k =floatToInt(f);
             
            PaymentApi.pay(k);
           
            String mail="amenallah.bensmida@esprit.tn";
            MailSender.sendMail(mail);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Paiement");
            alert.setContentText("Paiement effectué avec succès. Un mail a été envoyé qui contient vos informations\nRedirection vers l'athentification.");
            alert.show();
            
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Paiement");
            alert.setContentText("Remplir les champs convenablement.");
            alert.show();
        }
    }
    private boolean isValidVisaCardNo(String text) {
       // Regex to check valid.
        // Visa Card number
        String regex = "^4[0-9]{12}(?:[0-9]{3})?$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // Convert the string to CharSequence
        CharSequence cs = CharBuffer.wrap(text);

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(cs);

        // Return if the string
        // matched the ReGex
        return m.matches();
}
    public static boolean isNum(String str) {
        String expression = "\\d+";
        return str.matches(expression);
    }
    public static int floatToInt(float value) {
    return (int) value;
}
    
    
    
}
