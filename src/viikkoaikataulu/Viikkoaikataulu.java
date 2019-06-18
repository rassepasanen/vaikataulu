/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viikkoaikataulu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *Pääluokka.
 * @author verab
 */
public class Viikkoaikataulu extends Application {
    
    FlowPane fp1,fp2;
    Scene scene1,scene2;
    Stage stage;
    ListView listView;

    @Override
    public void start(Stage alkuIkkuna) throws Exception {
        try {
        //theStage = alkuIkkuna;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
       
       //luokaa viikkoaikataulu-ohjelmaan resources-kansio, jonne logo-kuva siirretään
       Image icon = new Image(Viikkoaikataulu.class.getResource("/logo.png").toExternalForm(), false);  
       alkuIkkuna.getIcons().add(icon);
      
        alkuIkkuna.setTitle("Viikkojärjestys");
        alkuIkkuna.setScene(scene);
        alkuIkkuna.show();
        //turvallinen sulkeminen suoritetaan tässä
        //alkuIkkuna.setOnCloseRequest(e -> closeProgram());
        
        //scene luonti
        scene1 = new Scene(fp1,250,100);
        scene2 = new Scene(fp2,250,100);
        
        stage = new Stage();
        stage.setScene(scene2);
        stage.initModality(Modality.APPLICATION_MODAL);
      
     
    }
    catch(Exception e) {
        e.printStackTrace();
    }}
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    //private void closeProgram() {
        //ruksista suljettaessa ajetaan tämä ja tallennetaan
        //saveProgram();
        
        
        
        
    }
    //private void saveProgram(){
        /*
        tallennustiedosto "tiedosto1" tiedostona joka on aluksi käytössä oleva
        tallennustiedostona myös "tiedosto2" tiedosto joka sisältää oletusnäkymän tiedot
        tiedosto1 = tiedosto2 (kopioi tyhjän) kun painetaan uusi viikko
        kun ohjelmasta poistutaan tai siihen tehdään muutos, tallennetaan muutos "tiedosto1":seen
        */
        /*File temp;
        try {
            temp = File.createTempFile("temp1",".txt");
            boolean exists = temp.exists();
            System.out.println("Temp file exists : " + exists);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            
        }
        */
        
        
        //FileChooser fc = new FileChooser();
        //File selectedFile = fc.showOpenDialog(null);
        
        //if (selectedFile != null){
        //    listView.getItems().add(selectedFile.getAbsoluteFile());//metodin vaihtaminen
        //}else{
            
       
    
    
    

    