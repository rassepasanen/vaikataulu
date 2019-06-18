/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viikkoaikataulu;

/**
 *
 * @author Rasmus Pasanen, Vera Bärlund, Jani Heiskanen
 */
public interface ControlledScreen {
    
    /**
     * Metodi näytön hallitsemiseen.
     * @param screenPage 
     */
    public void setScreenParent(ScreensController screenPage);
    
}
