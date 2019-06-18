/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viikkoaikataulu;

import java.util.HashMap;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Rasmus Pasanen, Vera Bärlund, Jani Heiskanen
 */
class ScreensController extends StackPane{
    
    private HashMap<String, Node> screens =new HashMap<>();
    
    /**
     * Näyttöjen kontrolloija.
     */
    public ScreensController(){
        super();
    }
    
    /**
     * Metodi, joka lisää näytön.
     * @param name Näytön nimi
     * @param screen Näyttö
     */
    public void addScreen(String name, Node screen){
        screens.put(name, screen);
    }
    
    /**
     * Metodi, joka hakee näytön.
     * @param name Näytön nimi
     * @return 
     */
    public Node getScreen(String name){
        return screens.get(name);
    }
    
    /**
     * Metodi, joka lataa näytön.
     * @param name Näytön nimi
     * @param resources
     * @return 
     */
    public boolean loadScreen(String name, String resources){
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resources));
            Parent loadScreen = (Parent) myLoader.load();
             ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * Metodi, joka asettaa näytön.
     * @param name Näytön nimi
     * @return Totuusarvo
     */
    public boolean setScreen(final String name) {       
        if (screens.get(name) != null) {   //screen loaded
            final DoubleProperty opacity = opacityProperty();

            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }
    }

    /**
     * Metodi, joka poistaa näytön näyttöjen kokoelmasta.
     * @param name Näytön nimi
     * @return Totuusarvo
     */
    public boolean unloadScreen(String name) {
        //This method will remove the screen with the given name from the collection of screens
        if (screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
}
