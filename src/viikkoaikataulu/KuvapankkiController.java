/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viikkoaikataulu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Rasmus Pasanen, Vera Bärlund, Jani Heiskanen
 */
public class KuvapankkiController implements Initializable, ControlledScreen {

    ScreensController myController;
    /**
     *Alustaa kontrolliluokan.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * Metodi, joka asettaa kontrollerin.
     * @param screenParent 
     */
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    
    
    
}
