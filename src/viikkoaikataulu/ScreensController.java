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
 * @author rasmuspasanen
 */
class ScreensController extends StackPane{
    
    private HashMap<String, Node> screens =new HashMap<>();
    
    public ScreensController(){
        super();
    }
    
    public void addScreen(String name, Node screen){
        screens.put(name, screen);
    }
    public Node getScreen(String name){
        return screens.get(name);
    }
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
    public boolean setScreen(final String name) {       
        if (screens.get(name) != null) {   //screen loaded
            final DoubleProperty opacity = opacityProperty();

            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }
    }

    //This method will remove the screen with the given name from the collection of screens
    public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
}
