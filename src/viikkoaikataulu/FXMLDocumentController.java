/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viikkoaikataulu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *Kontrolliluokka
 * @author verab
 */
public class FXMLDocumentController implements Initializable{

   @FXML private Button lisaaKuvia;

    @FXML private Button uusiViikko, maButton, tiButton, keButton, closeButton,
    toButton, peButton, laButton, suButton, tallennaPoistu;
    @FXML private ImageView img11;
    @FXML private ImageView img12, img13, img14, img15,
                            img21, img22, img23, img24, img25,
                            img31, img32, img33, img34, img35,
                            img41, img42, img43, img44, img45,
                            img51, img52, img53, img54, img55,
                            img61, img62, img63, img64, img65,
                            img71, img72, img73, img74, img75;
    @FXML private ImageView ma1, ma2, ma3, ma4, ma5, ma6, ma7, ma8, ma9, ma10,
            ma11, ma12, ma13, ma14, ma15;
    @FXML private ImageView ti1, ti2, ti3, ti4, ti5, ti6, ti7, ti8, ti9, ti10,
            ti11, ti12, ti13, ti14, ti15;
    @FXML private ImageView ke1, ke2, ke3, ke4, ke5, ke6, ke7, ke8, ke9, ke10,
            ke11, ke12, ke13, ke14, ke15;
    @FXML private ImageView to1, to2, to3, to4, to5, to6, to7, to8, to9, to10,
            to11, to12, to13, to14, to15;
    @FXML private ImageView pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10,
            pe11, pe12, pe13, pe14, pe15;
    @FXML private ImageView la1, la2, la3, la4, la5, la6, la7, la8, la9, la10,
            la11, la12, la13, la14, la15;
    @FXML private ImageView su1, su2, su3, su4, su5, su6, su7, su8, su9, su10,
            su11, su12, su13, su14, su15;
    //listat kaikista päivistä viikkonäkymässä sekä päivänäkymien aamu/päivä/ilta
private LinkedList listMaanantai = new LinkedList();
    private LinkedList listTiistai = new LinkedList();
    private LinkedList listKeskiviikko = new LinkedList();
    private LinkedList listTorstai = new LinkedList();
    private LinkedList listPerjantai = new LinkedList();
    private LinkedList listLauantai = new LinkedList();
    private LinkedList listSunnuntai = new LinkedList();
    private LinkedList listMaAamu = new LinkedList();
    private LinkedList listMaPaiva = new LinkedList();
    private LinkedList listMaIlta = new LinkedList();
    private LinkedList listTiAamu = new LinkedList();
    private LinkedList listTiPaiva = new LinkedList();
    private LinkedList listTiIlta = new LinkedList();
    private LinkedList listKeAamu = new LinkedList();
    private LinkedList listKePaiva = new LinkedList();
    private LinkedList listKeIlta = new LinkedList();
    private LinkedList listToAamu = new LinkedList();
    private LinkedList listToPaiva = new LinkedList();
    private LinkedList listToIlta = new LinkedList();
    private LinkedList listPeAamu = new LinkedList();
    private LinkedList listPePaiva = new LinkedList();
    private LinkedList listPeIlta = new LinkedList();
    private LinkedList listLaAamu = new LinkedList();
    private LinkedList listLaPaiva = new LinkedList();
    private LinkedList listLaIlta = new LinkedList();
    private LinkedList listSuAamu = new LinkedList();
    private LinkedList listSuPaiva = new LinkedList();
    private LinkedList listSuIlta = new LinkedList();
    
    
    
    //Kuvan lisääminen FileChooserin avulla, kun klikattu hiirellä x2
    public void listMaanantaiLisaa(MouseEvent mouseEvent) throws IOException{
       if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listMaanantai.isEmpty()){
            listMaanantai.add(0,image);
            img11.setImage(image);
        }
        else if (listMaanantai.size()==1){
            listMaanantai.add(1,image);
            img12.setImage(image);
        }
        else if (listMaanantai.size()==2){
            listMaanantai.add(2,image);
            img13.setImage(image);
        }
        else if (listMaanantai.size()==3){
            listMaanantai.add(3,image);
            img14.setImage(image);
        }
        else if (listMaanantai.size()==4){
            listMaanantai.add(4,image);
            img15.setImage(image);
        }
         }
    }
    public void listTiistaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listTiistai.isEmpty()){
            listTiistai.add(0,image);
            img21.setImage(image);
        }
        else if (listTiistai.size()==1){
            listTiistai.add(1,image);
            img22.setImage(image);
        }
        else if (listTiistai.size()==2){
            listTiistai.add(2,image);
            img23.setImage(image);
        }
        else if (listTiistai.size()==3){
            listTiistai.add(3,image);
            img24.setImage(image);
        }
        else if (listTiistai.size()==4){
            listTiistai.add(4,image);
            img25.setImage(image);
        }}
    }
    public void listKeskiviikkoLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listKeskiviikko.isEmpty()){
            listKeskiviikko.add(0,image);
            img31.setImage(image);
        }
        else if (listKeskiviikko.size()==1){
            listKeskiviikko.add(1,image);
            img32.setImage(image);
        }
        else if (listKeskiviikko.size()==2){
            listKeskiviikko.add(2,image);
            img33.setImage(image);
        }
        else if (listKeskiviikko.size()==3){
            listKeskiviikko.add(3,image);
            img34.setImage(image);
        }
        else if (listKeskiviikko.size()==4){
            listKeskiviikko.add(4,image);
            img35.setImage(image);
        }  }
    }
    public void listTorstaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listTorstai.isEmpty()){
            listTorstai.add(0,image);
            img41.setImage(image);
            System.out.println("testi");
        }
        else if (listTorstai.size()==1){
            listTorstai.add(1,image);
            img42.setImage(image);
        }
        else if (listTorstai.size()==2){
            listTorstai.add(2,image);
            img43.setImage(image);
        }
        else if (listTorstai.size()==3){
            listTorstai.add(3,image);
            img44.setImage(image);
        }
        else if (listTorstai.size()==4){
            listTorstai.add(4,image);
            img45.setImage(image);
        }  }
    }
    public void listPerjantaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listPerjantai.isEmpty()){
            listPerjantai.add(0,image);
            img51.setImage(image);
        }
        else if (listPerjantai.size()==1){
            listPerjantai.add(1,image);
            img52.setImage(image);
        }
        else if (listPerjantai.size()==2){
            listPerjantai.add(2,image);
            img53.setImage(image);
        }
        else if (listPerjantai.size()==3){
            listPerjantai.add(3,image);
            img54.setImage(image);
        }
        else if (listPerjantai.size()==4){
            listPerjantai.add(4,image);
            img55.setImage(image);
        }  
    }}
    public void listLauantaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listLauantai.isEmpty()){
            listLauantai.add(0,image);
            img61.setImage(image);
        }
        else if (listLauantai.size()==1){
            listLauantai.add(1,image);
            img62.setImage(image);
        }
        else if (listLauantai.size()==2){
            listLauantai.add(2,image);
            img63.setImage(image);
        }
        else if (listLauantai.size()==3){
            listLauantai.add(3,image);
            img64.setImage(image);
        }
        else if (listLauantai.size()==4){
            listLauantai.add(4,image);
            img65.setImage(image);
        }  }
    }
    public void listSunnuntaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listSunnuntai.isEmpty()){
            listSunnuntai.add(0,image);
            img71.setImage(image);
        }
        else if (listSunnuntai.size()==1){
            listSunnuntai.add(1,image);
            img72.setImage(image);
        }
        else if (listSunnuntai.size()==2){
            listSunnuntai.add(2,image);
            img73.setImage(image);
        }
        else if (listSunnuntai.size()==3){
            listSunnuntai.add(3,image);
            img74.setImage(image);
        }
        else if (listSunnuntai.size()==4){
            listSunnuntai.add(4,image);
            img75.setImage(image);
        }  
    }}
    //Maanantain päivänäkymän kuvalisäys
    public void listMaAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listMaAamu.isEmpty()){
            listMaAamu.add(0,image);
            ma1.setImage(image);
        }
        else if (listMaAamu.size()==1){
            listMaAamu.add(1,image);
            ma2.setImage(image);
        }
        else if (listMaAamu.size()==2){
            listMaAamu.add(2,image);
            ma3.setImage(image);
        }
        else if (listMaAamu.size()==3){
            listMaAamu.add(3,image);
            ma4.setImage(image);
        }
        else if (listMaAamu.size()==4){
            listMaAamu.add(4,image);
            ma5.setImage(image);
        }
    }}
    public void listMaPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listMaPaiva.isEmpty()){
            listMaPaiva.add(0,image);
            ma6.setImage(image);
        }
        else if (listMaPaiva.size()==1){
            listMaPaiva.add(1,image);
            ma7.setImage(image);
        }
        else if (listMaPaiva.size()==2){
            listMaPaiva.add(2,image);
            ma8.setImage(image);
        }
        else if (listMaPaiva.size()==3){
            listMaPaiva.add(3,image);
            ma9.setImage(image);
        }
        else if (listMaPaiva.size()==4){
            listMaPaiva.add(4,image);
            ma10.setImage(image);
        }
    }}
    public void listMaIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listMaIlta.isEmpty()){
            listMaIlta.add(0,image);
            ma11.setImage(image);
        }
        else if (listMaIlta.size()==1){
            listMaIlta.add(1,image);
            ma12.setImage(image);
        }
        else if (listMaIlta.size()==2){
            listMaIlta.add(2,image);
            ma13.setImage(image);
        }
        else if (listMaIlta.size()==3){
            listMaIlta.add(3,image);
            ma14.setImage(image);
        }
        else if (listMaIlta.size()==4){
            listMaIlta.add(4,image);
            ma15.setImage(image);
        }
    }}
    //Tiistain päivänäkymän kuvalisäys
    public void listTiAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listTiAamu.isEmpty()){
            listTiAamu.add(0,image);
            ti1.setImage(image);
        }
        else if (listTiAamu.size()==1){
            listTiAamu.add(1,image);
            ti2.setImage(image);
        }
        else if (listTiAamu.size()==2){
            listTiAamu.add(2,image);
            ti3.setImage(image);
        }
        else if (listTiAamu.size()==3){
            listTiAamu.add(3,image);
            ti4.setImage(image);
        }
        else if (listTiAamu.size()==4){
            listTiAamu.add(4,image);
            ti5.setImage(image);
        }
    }}
    public void listTiPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listTiPaiva.isEmpty()){
            listTiPaiva.add(0,image);
            ti6.setImage(image);
        }
        else if (listTiPaiva.size()==1){
            listTiPaiva.add(1,image);
            ti7.setImage(image);
        }
        else if (listTiPaiva.size()==2){
            listTiPaiva.add(2,image);
            ti8.setImage(image);
        }
        else if (listTiPaiva.size()==3){
            listTiPaiva.add(3,image);
            ti9.setImage(image);
        }
        else if (listTiPaiva.size()==4){
            listTiPaiva.add(4,image);
            ti10.setImage(image);
        }
    }}
    public void listTiIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listTiIlta.isEmpty()){
            listTiIlta.add(0,image);
            ti11.setImage(image);
        }
        else if (listTiIlta.size()==1){
            listTiIlta.add(1,image);
            ti12.setImage(image);
        }
        else if (listTiIlta.size()==2){
            listTiIlta.add(2,image);
            ti13.setImage(image);
        }
        else if (listTiIlta.size()==3){
            listTiIlta.add(3,image);
            ti14.setImage(image);
        }
        else if (listTiIlta.size()==4){
            listTiIlta.add(4,image);
            ti15.setImage(image);
        }
    }}
    //Keskiviikon päivänäkymän kuvalisäys
    public void listKeAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listKeAamu.isEmpty()){
            listKeAamu.add(0,image);
            ke1.setImage(image);
        }
        else if (listKeAamu.size()==1){
            listKeAamu.add(1,image);
            ke2.setImage(image);
        }
        else if (listKeAamu.size()==2){
            listKeAamu.add(2,image);
            ke3.setImage(image);
        }
        else if (listKeAamu.size()==3){
            listKeAamu.add(3,image);
            ke4.setImage(image);
        }
        else if (listKeAamu.size()==4){
            listTiAamu.add(4,image);
            ke5.setImage(image);
        }
    }}
    public void listKePaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listKePaiva.isEmpty()){
            listKePaiva.add(0,image);
            ke6.setImage(image);
        }
        else if (listKePaiva.size()==1){
            listKePaiva.add(1,image);
            ke7.setImage(image);
        }
        else if (listKePaiva.size()==2){
            listKePaiva.add(2,image);
            ke8.setImage(image);
        }
        else if (listKePaiva.size()==3){
            listKePaiva.add(3,image);
            ke9.setImage(image);
        }
        else if (listKePaiva.size()==4){
            listKePaiva.add(4,image);
            ke10.setImage(image);
        }
    }}
    public void listKeIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listKeIlta.isEmpty()){
            listKeIlta.add(0,image);
            ke11.setImage(image);
        }
        else if (listKeIlta.size()==1){
            listKeIlta.add(1,image);
            ke12.setImage(image);
        }
        else if (listKeIlta.size()==2){
            listKeIlta.add(2,image);
            ke13.setImage(image);
        }
        else if (listKeIlta.size()==3){
            listKeIlta.add(3,image);
            ke14.setImage(image);
        }
        else if (listKeIlta.size()==4){
            listKeIlta.add(4,image);
            ke15.setImage(image);
        }
    }}
    //Torstain päivänäkymän kuvalisäys
    public void listToAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listToAamu.isEmpty()){
            listToAamu.add(0,image);
            to1.setImage(image);
        }
        else if (listToAamu.size()==1){
            listToAamu.add(1,image);
            to2.setImage(image);
        }
        else if (listToAamu.size()==2){
            listToAamu.add(2,image);
            to3.setImage(image);
        }
        else if (listToAamu.size()==3){
            listToAamu.add(3,image);
            to4.setImage(image);
        }
        else if (listToAamu.size()==4){
            listToAamu.add(4,image);
            to5.setImage(image);
        }
    }}
    public void listToPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listToPaiva.isEmpty()){
            listToPaiva.add(0,image);
            to6.setImage(image);
        }
        else if (listToPaiva.size()==1){
            listToPaiva.add(1,image);
            to7.setImage(image);
        }
        else if (listToPaiva.size()==2){
            listToPaiva.add(2,image);
            to8.setImage(image);
        }
        else if (listToPaiva.size()==3){
            listToPaiva.add(3,image);
            to9.setImage(image);
        }
        else if (listToPaiva.size()==4){
            listToPaiva.add(4,image);
            to10.setImage(image);
        }
    }}
    public void listToIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listToIlta.isEmpty()){
            listToIlta.add(0,image);
            to11.setImage(image);
        }
        else if (listToIlta.size()==1){
            listToIlta.add(1,image);
            to12.setImage(image);
        }
        else if (listToIlta.size()==2){
            listToIlta.add(2,image);
            to13.setImage(image);
        }
        else if (listToIlta.size()==3){
            listToIlta.add(3,image);
            to14.setImage(image);
        }
        else if (listToIlta.size()==4){
            listToIlta.add(4,image);
            to15.setImage(image);
        }
    }}
    //Perjantain päivänäkymän kuvalisäys
    public void listPeAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listPeAamu.isEmpty()){
            listPeAamu.add(0,image);
            pe1.setImage(image);
        }
        else if (listPeAamu.size()==1){
            listPeAamu.add(1,image);
            pe2.setImage(image);
        }
        else if (listPeAamu.size()==2){
            listPeAamu.add(2,image);
            pe3.setImage(image);
        }
        else if (listPeAamu.size()==3){
            listPeAamu.add(3,image);
            pe4.setImage(image);
        }
        else if (listPeAamu.size()==4){
            listPeAamu.add(4,image);
            pe5.setImage(image);
        }
    }}
    public void listPePaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listPePaiva.isEmpty()){
            listPePaiva.add(0,image);
            pe6.setImage(image);
        }
        else if (listPePaiva.size()==1){
            listPePaiva.add(1,image);
            pe7.setImage(image);
        }
        else if (listPePaiva.size()==2){
            listPePaiva.add(2,image);
            pe8.setImage(image);
        }
        else if (listPePaiva.size()==3){
            listPePaiva.add(3,image);
            pe9.setImage(image);
        }
        else if (listPePaiva.size()==4){
            listPePaiva.add(4,image);
            pe10.setImage(image);
        }
    }}
    public void listPeIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listPeIlta.isEmpty()){
            listPeIlta.add(0,image);
            pe11.setImage(image);
        }
        else if (listPeIlta.size()==1){
            listPeIlta.add(1,image);
            pe12.setImage(image);
        }
        else if (listPeIlta.size()==2){
            listPeIlta.add(2,image);
            pe13.setImage(image);
        }
        else if (listPeIlta.size()==3){
            listPeIlta.add(3,image);
            pe14.setImage(image);
        }
        else if (listPeIlta.size()==4){
            listPeIlta.add(4,image);
            pe15.setImage(image);
        }
    }}
    //Lauantain päivänäkymän kuvalisäys
    public void listLaAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listLaAamu.isEmpty()){
            listLaAamu.add(0,image);
            la1.setImage(image);
        }
        else if (listLaAamu.size()==1){
            listLaAamu.add(1,image);
            la2.setImage(image);
        }
        else if (listLaAamu.size()==2){
            listLaAamu.add(2,image);
            la3.setImage(image);
        }
        else if (listLaAamu.size()==3){
            listLaAamu.add(3,image);
            la4.setImage(image);
        }
        else if (listLaAamu.size()==4){
            listLaAamu.add(4,image);
            la5.setImage(image);
        }
    }}
    public void listLaPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listLaPaiva.isEmpty()){
            listLaPaiva.add(0,image);
            la6.setImage(image);
        }
        else if (listLaPaiva.size()==1){
            listLaPaiva.add(1,image);
            la7.setImage(image);
        }
        else if (listLaPaiva.size()==2){
            listLaPaiva.add(2,image);
            la8.setImage(image);
        }
        else if (listLaPaiva.size()==3){
            listLaPaiva.add(3,image);
            la9.setImage(image);
        }
        else if (listLaPaiva.size()==4){
            listLaPaiva.add(4,image);
            la10.setImage(image);
        }
    }}
    public void listLaIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listLaIlta.isEmpty()){
            listLaIlta.add(0,image);
            la11.setImage(image);
        }
        else if (listLaIlta.size()==1){
            listLaIlta.add(1,image);
            la12.setImage(image);
        }
        else if (listLaIlta.size()==2){
            listLaIlta.add(2,image);
            la13.setImage(image);
        }
        else if (listLaIlta.size()==3){
            listLaIlta.add(3,image);
            la14.setImage(image);
        }
        else if (listLaIlta.size()==4){
            listLaIlta.add(4,image);
            la15.setImage(image);
        }
    }}
    //Lauantain päivänäkymän kuvalisäys
    public void listSuAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listSuAamu.isEmpty()){
            listSuAamu.add(0,image);
            su1.setImage(image);
        }
        else if (listSuAamu.size()==1){
            listSuAamu.add(1,image);
            su2.setImage(image);
        }
        else if (listSuAamu.size()==2){
            listSuAamu.add(2,image);
            su3.setImage(image);
        }
        else if (listSuAamu.size()==3){
            listSuAamu.add(3,image);
            su4.setImage(image);
        }
        else if (listSuAamu.size()==4){
            listSuAamu.add(4,image);
            su5.setImage(image);
        }
    }}
    public void listSuPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listSuPaiva.isEmpty()){
            listSuPaiva.add(0,image);
            su6.setImage(image);
        }
        else if (listSuPaiva.size()==1){
            listSuPaiva.add(1,image);
            su7.setImage(image);
        }
        else if (listSuPaiva.size()==2){
            listSuPaiva.add(2,image);
            su8.setImage(image);
        }
        else if (listSuPaiva.size()==3){
            listSuPaiva.add(3,image);
            su9.setImage(image);
        }
        else if (listSuPaiva.size()==4){
            listSuPaiva.add(4,image);
            su10.setImage(image);
        }
    }}
    public void listSuIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("resources/Kuvat"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listSuIlta.isEmpty()){
            listSuIlta.add(0,image);
            su11.setImage(image);
        }
        else if (listSuIlta.size()==1){
            listSuIlta.add(1,image);
            su12.setImage(image);
        }
        else if (listSuIlta.size()==2){
            listSuIlta.add(2,image);
            su13.setImage(image);
        }
        else if (listSuIlta.size()==3){
            listSuIlta.add(3,image);
            su14.setImage(image);
        }
        else if (listSuIlta.size()==4){
            listSuIlta.add(4,image);
            su15.setImage(image);
        }
    }}
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
      
        //uuden viikon luonti
        if(event.getSource()==uusiViikko){  
        //tyhjennetään listat ja asetetaan imageview:ien arvoksi null
        //tähän voi myös asettaa ennaltamäärättyjä kuvia null-arvon tilalle
        listMaanantai.clear();
        img11.setImage(null);
        img12.setImage(null);
        img13.setImage(null);
        img14.setImage(null);
        img15.setImage(null);
        listTiistai.clear();
        img21.setImage(null);
        img22.setImage(null);
        img23.setImage(null);
        img24.setImage(null);
        img25.setImage(null);
        listKeskiviikko.clear();
        img31.setImage(null);
        img32.setImage(null);
        img33.setImage(null);
        img34.setImage(null);
        img35.setImage(null);
        listTorstai.clear();
        img41.setImage(null);
        img42.setImage(null);
        img43.setImage(null);
        img44.setImage(null);
        img45.setImage(null);
        listPerjantai.clear();
        img51.setImage(null);
        img52.setImage(null);
        img53.setImage(null);
        img54.setImage(null);
        img55.setImage(null);
        listLauantai.clear();
        img61.setImage(null);
        img62.setImage(null);
        img63.setImage(null);
        img64.setImage(null);
        img65.setImage(null);
        listSunnuntai.clear();
        img71.setImage(null);
        img72.setImage(null);
        img73.setImage(null);
        img74.setImage(null);
        img75.setImage(null);
        listMaAamu.clear();
        ma1.setImage(null);
        ma2.setImage(null);
        ma3.setImage(null);
        ma4.setImage(null);
        ma5.setImage(null);
        listMaPaiva.clear();
        ma6.setImage(null);
        ma7.setImage(null);
        ma8.setImage(null);
        ma9.setImage(null);
        ma10.setImage(null);
        listMaIlta.clear();
        ma11.setImage(null);
        ma12.setImage(null);
        ma13.setImage(null);
        ma14.setImage(null);
        ma15.setImage(null);
        listTiAamu.clear();
        ti1.setImage(null);
        ti2.setImage(null);
        ti3.setImage(null);
        ti4.setImage(null);
        ti5.setImage(null);
        listTiPaiva.clear();
        ti6.setImage(null);
        ti7.setImage(null);
        ti8.setImage(null);
        ti9.setImage(null);
        ti10.setImage(null);
        listTiIlta.clear();
        ti11.setImage(null);
        ti12.setImage(null);
        ti13.setImage(null);
        ti14.setImage(null);
        ti15.setImage(null);
        listKeAamu.clear();
        ke1.setImage(null);
        ke2.setImage(null);
        ke3.setImage(null);
        ke4.setImage(null);
        ke5.setImage(null);
        listKePaiva.clear();
        ke6.setImage(null);
        ke7.setImage(null);
        ke8.setImage(null);
        ke9.setImage(null);
        ke10.setImage(null);
        listKeIlta.clear();
        ke11.setImage(null);
        ke12.setImage(null);
        ke13.setImage(null);
        ke14.setImage(null);
        ke15.setImage(null);
        listToAamu.clear();
        to1.setImage(null);
        to2.setImage(null);
        to3.setImage(null);
        to4.setImage(null);
        to5.setImage(null);
        listToPaiva.clear();
        to6.setImage(null);
        to7.setImage(null);
        to8.setImage(null);
        to9.setImage(null);
        to10.setImage(null);
        listToIlta.clear();
        to11.setImage(null);
        to12.setImage(null);
        to13.setImage(null);
        to14.setImage(null);
        to15.setImage(null);
        listPeAamu.clear();
        pe1.setImage(null);
        pe2.setImage(null);
        pe3.setImage(null);
        pe4.setImage(null);
        pe5.setImage(null);
        listPePaiva.clear();
        pe6.setImage(null);
        pe7.setImage(null);
        pe8.setImage(null);
        pe9.setImage(null);
        pe10.setImage(null);
        listPeIlta.clear();
        pe11.setImage(null);
        pe12.setImage(null);
        pe13.setImage(null);
        pe14.setImage(null);
        pe15.setImage(null);
        listLaAamu.clear();
        la1.setImage(null);
        la2.setImage(null);
        la3.setImage(null);
        la4.setImage(null);
        la5.setImage(null);
        listLaPaiva.clear();
        la6.setImage(null);
        la7.setImage(null);
        la8.setImage(null);
        la9.setImage(null);
        la10.setImage(null);
        listLaIlta.clear();
        la11.setImage(null);
        la12.setImage(null);
        la13.setImage(null);
        la14.setImage(null);
        la15.setImage(null);
        listSuAamu.clear();
        su1.setImage(null);
        su2.setImage(null);
        su3.setImage(null);
        su4.setImage(null);
        su5.setImage(null);
        listSuPaiva.clear();
        su6.setImage(null);
        su7.setImage(null);
        su8.setImage(null);
        su9.setImage(null);
        su10.setImage(null);
        listSuIlta.clear();
        su11.setImage(null);
        su12.setImage(null);
        su13.setImage(null);
        su14.setImage(null);
        su15.setImage(null);
        }
        
        //Avaa kuvatiedoston (Vaihtakaa oikea polku)
        else if (event.getSource()==lisaaKuvia){
          //listMaanantaiLisaa();
          //tämän painikkeen voisi vaihtaa esimerkiksi "Tallenna"-painikkeeksi
        }
        //maanantain muokkaus
        else if (event.getSource()==maButton){
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("ScreenMaanantai.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(maButton.getScene().getWindow());
            stage.showAndWait();
            
        }
        //tiistain muokkaus
        else if (event.getSource()==tiButton){
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("ScreenTiistai.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(tiButton.getScene().getWindow());
            stage.showAndWait();
        }
        //keskiviikon muokkaus
        else if (event.getSource()==keButton){
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("ScreenKeskiviikko.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(keButton.getScene().getWindow());
            stage.showAndWait();
        }
        //torstain muokkaus
        else if (event.getSource()==toButton){
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("ScreenTorstai.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(toButton.getScene().getWindow());
            stage.showAndWait();
        }
        //perjantain muokkaus
        else if (event.getSource()==peButton){
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("ScreenPerjantai.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(peButton.getScene().getWindow());
            stage.showAndWait();
        }
        //lauantain muokkaus
        else if (event.getSource()==laButton){
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("ScreenLauantai.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(laButton.getScene().getWindow());
            stage.showAndWait();
        }
        //sunnuntain muokkaus
        else if (event.getSource()==suButton){
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("ScreenSunnuntai.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(suButton.getScene().getWindow());
            stage.showAndWait();
        }

        else {
            //DO NOTHING - poistuminen hoidetaan muualla
        }
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }
  
   /*
    private double startDragX;
    private double startDragY;
    
    //tässä tehtäisiin kuvien siirto paikasta toiseen
    //nyt vaan räjähtää käsiin
    @FXML
    public void dragImages(DragEvent event){
           img12.setOnMousePressed(e -> {
            startDragX = e.getSceneX();
            startDragY = e.getSceneY();
        });

        img12.setOnMouseDragged(e -> {
            img12.setTranslateX(e.getSceneX() - startDragX);
            img12.setTranslateY(e.getSceneY() - startDragY);
        });
        
    }
    **/
    

        
    // Metodi jolla tunnistetaan milloin kuva on vedetty kohdalle 
    @FXML
    public void handleOver(DragEvent event){
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }
        
        
    }
    // Metodi 
    @FXML
    public void handleDrop(DragEvent event) throws FileNotFoundException{
        
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        //Viikkonäkymän imaget
        if (event.getTarget()==img11){
            img11.setImage(img);
        }
        else if (event.getTarget()==img12){
            img12.setImage(img);
        }
        else if (event.getTarget()==img13){
            img13.setImage(img);
        }
        else if (event.getTarget()==img14){
            img14.setImage(img);
        }
        else if (event.getTarget()==img15){
            img15.setImage(img);
        }
        else if (event.getTarget()==img21){
            img21.setImage(img);
        }
        else if (event.getTarget()==img22){
            img22.setImage(img);
        }
        else if (event.getTarget()==img23){
            img23.setImage(img);
        }
        else if (event.getTarget()==img24){
            img24.setImage(img);
        }
        else if (event.getTarget()==img25){
            img25.setImage(img);
        }
        else if (event.getTarget()==img31){
            img31.setImage(img);
        }
        else if (event.getTarget()==img32){
            img32.setImage(img);
        }
        else if (event.getTarget()==img33){
            img33.setImage(img);
        }
        else if (event.getTarget()==img34){
            img34.setImage(img);
        }
        else if (event.getTarget()==img35){
            img35.setImage(img);
        }
        else if (event.getTarget()==img41){
            img41.setImage(img);
        }
        else if (event.getTarget()==img42){
            img42.setImage(img);
        }
        else if (event.getTarget()==img43){
            img43.setImage(img);
        }
        else if (event.getTarget()==img44){
            img44.setImage(img);
        }
        else if (event.getTarget()==img45){
            img45.setImage(img);
        }
        else if (event.getTarget()==img51){
            img51.setImage(img);
        }
        else if (event.getTarget()==img52){
            img52.setImage(img);
        }
        else if (event.getTarget()==img53){
            img53.setImage(img);
        }
        else if (event.getTarget()==img54){
            img54.setImage(img);
        }
        else if (event.getTarget()==img55){
            img55.setImage(img);
        }
        else if (event.getTarget()==img61){
            img61.setImage(img);
        }
        else if (event.getTarget()==img62){
            img62.setImage(img);
        }
        else if (event.getTarget()==img63){
            img63.setImage(img);
        }
        else if (event.getTarget()==img64){
            img64.setImage(img);
        }
        else if (event.getTarget()==img65){
            img65.setImage(img);
        }
        else if (event.getTarget()==img71){
            img71.setImage(img);
        }
        else if (event.getTarget()==img72){
            img72.setImage(img);
        }
        else if (event.getTarget()==img73){
            img73.setImage(img);
        }
        else if (event.getTarget()==img74){
            img74.setImage(img);
        }
        else if (event.getTarget()==img75){
            img75.setImage(img);
        }
        // Maanantain päivänäkymän imaget
        else if (event.getTarget()==ma1){
            ma1.setImage(img);
        }
        else if (event.getTarget()==ma2){
            ma2.setImage(img);
        }
        else if (event.getTarget()==ma3){
            ma3.setImage(img);
        }
        else if (event.getTarget()==ma4){
            ma4.setImage(img);
        }
        else if (event.getTarget()==ma5){
            ma5.setImage(img);
        }
        else if (event.getTarget()==ma6){
            ma6.setImage(img);
        }
        else if (event.getTarget()==ma7){
            ma7.setImage(img);
        }
        else if (event.getTarget()==ma8){
            ma8.setImage(img);
        }
        else if (event.getTarget()==ma9){
            ma9.setImage(img);
        }
        else if (event.getTarget()==ma10){
            ma10.setImage(img);
        }
        else if (event.getTarget()==ma11){
            ma11.setImage(img);
        }
        else if (event.getTarget()==ma12){
            ma12.setImage(img);
        }
        else if (event.getTarget()==ma13){
            ma13.setImage(img);
        }
        else if (event.getTarget()==ma14){
            ma14.setImage(img);
        }
        else if (event.getTarget()==ma15){
            ma15.setImage(img);
        }
        // Tiistain päivänäkymän imaget
        else if (event.getTarget()==ti1){
            ti1.setImage(img);
        }
        else if (event.getTarget()==ti2){
            ti2.setImage(img);
        }
        else if (event.getTarget()==ti3){
            ti3.setImage(img);
        }
        else if (event.getTarget()==ti4){
            ti4.setImage(img);
        }
        else if (event.getTarget()==ti5){
            ti5.setImage(img);
        }
        else if (event.getTarget()==ti6){
            ti6.setImage(img);
        }
        else if (event.getTarget()==ti7){
            ti7.setImage(img);
        }
        else if (event.getTarget()==ti8){
            ti8.setImage(img);
        }
        else if (event.getTarget()==ti9){
            ti9.setImage(img);
        }
        else if (event.getTarget()==ti10){
            ti10.setImage(img);
        }
        else if (event.getTarget()==ti11){
            ti11.setImage(img);
        }
        else if (event.getTarget()==ti12){
            ti12.setImage(img);
        }
        else if (event.getTarget()==ti13){
            ti13.setImage(img);
        }
        else if (event.getTarget()==ti14){
            ti14.setImage(img);
        }
        else if (event.getTarget()==ti15){
            ti15.setImage(img);
        }
        // Keskiviikon päivänäkymän imaget
        else if (event.getTarget()==ke1){
            ke1.setImage(img);
        }
        else if (event.getTarget()==ke2){
            ke2.setImage(img);
        }
        else if (event.getTarget()==ke3){
            ke3.setImage(img);
        }
        else if (event.getTarget()==ke4){
            ke4.setImage(img);
        }
        else if (event.getTarget()==ke5){
            ke5.setImage(img);
        }
        else if (event.getTarget()==ke6){
            ke6.setImage(img);
        }
        else if (event.getTarget()==ti7){
            ti7.setImage(img);
        }
        else if (event.getTarget()==ke8){
            ke8.setImage(img);
        }
        else if (event.getTarget()==ke9){
            ke9.setImage(img);
        }
        else if (event.getTarget()==ke10){
            ke10.setImage(img);
        }
        else if (event.getTarget()==ke11){
            ke11.setImage(img);
        }
        else if (event.getTarget()==ke12){
            ke12.setImage(img);
        }
        else if (event.getTarget()==ke13){
            ke13.setImage(img);
        }
        else if (event.getTarget()==ke14){
            ke14.setImage(img);
        }
        else if (event.getTarget()==ke15){
            ke15.setImage(img);
        }
        // Torstain päivänäkymän imaget
        else if (event.getTarget()==to1){
            to1.setImage(img);
        }
        else if (event.getTarget()==to2){
            to2.setImage(img);
        }
        else if (event.getTarget()==to3){
            to3.setImage(img);
        }
        else if (event.getTarget()==to4){
            to4.setImage(img);
        }
        else if (event.getTarget()==to5){
            to5.setImage(img);
        }
        else if (event.getTarget()==to6){
            to6.setImage(img);
        }
        else if (event.getTarget()==to7){
            to7.setImage(img);
        }
        else if (event.getTarget()==to8){
            to8.setImage(img);
        }
        else if (event.getTarget()==to9){
            to9.setImage(img);
        }
        else if (event.getTarget()==to10){
            to10.setImage(img);
        }
        else if (event.getTarget()==to11){
            to11.setImage(img);
        }
        else if (event.getTarget()==to12){
            to12.setImage(img);
        }
        else if (event.getTarget()==to13){
            to13.setImage(img);
        }
        else if (event.getTarget()==to14){
            to14.setImage(img);
        }
        else if (event.getTarget()==to15){
            to15.setImage(img);
        }
        // Perjantai päivänäkymän imaget
        else if (event.getTarget()==pe1){
            pe1.setImage(img);
        }
        else if (event.getTarget()==pe2){
            pe2.setImage(img);
        }
        else if (event.getTarget()==pe3){
            pe3.setImage(img);
        }
        else if (event.getTarget()==pe4){
            pe4.setImage(img);
        }
        else if (event.getTarget()==pe5){
            pe5.setImage(img);
        }
        else if (event.getTarget()==pe6){
            pe6.setImage(img);
        }
        else if (event.getTarget()==pe7){
            pe7.setImage(img);
        }
        else if (event.getTarget()==pe8){
            pe8.setImage(img);
        }
        else if (event.getTarget()==pe9){
            pe9.setImage(img);
        }
        else if (event.getTarget()==pe10){
            pe10.setImage(img);
        }
        else if (event.getTarget()==pe11){
            pe11.setImage(img);
        }
        else if (event.getTarget()==pe12){
            pe12.setImage(img);
        }
        else if (event.getTarget()==pe13){
            pe13.setImage(img);
        }
        else if (event.getTarget()==pe14){
            pe14.setImage(img);
        }
        else if (event.getTarget()==pe15){
            pe15.setImage(img);
        }
        // Lauantai päivänäkymän imaget
        else if (event.getTarget()==la1){
            la1.setImage(img);
        }
        else if (event.getTarget()==la2){
            la2.setImage(img);
        }
        else if (event.getTarget()==la3){
            la3.setImage(img);
        }
        else if (event.getTarget()==la4){
            la4.setImage(img);
        }
        else if (event.getTarget()==la5){
            la5.setImage(img);
        }
        else if (event.getTarget()==la6){
            la6.setImage(img);
        }
        else if (event.getTarget()==la7){
            la7.setImage(img);
        }
        else if (event.getTarget()==la8){
            la8.setImage(img);
        }
        else if (event.getTarget()==la9){
            la9.setImage(img);
        }
        else if (event.getTarget()==la10){
            la10.setImage(img);
        }
        else if (event.getTarget()==la11){
            la11.setImage(img);
        }
        else if (event.getTarget()==la12){
            la12.setImage(img);
        }
        else if (event.getTarget()==la13){
            la13.setImage(img);
        }
        else if (event.getTarget()==la14){
            la14.setImage(img);
        }
        else if (event.getTarget()==la15){
            la15.setImage(img);
        }
        // Lauantai päivänäkymän imaget
        else if (event.getTarget()==su1){
            su1.setImage(img);
        }
        else if (event.getTarget()==su2){
            su2.setImage(img);
        }
        else if (event.getTarget()==su3){
            su3.setImage(img);
        }
        else if (event.getTarget()==su4){
            su4.setImage(img);
        }
        else if (event.getTarget()==su5){
            su5.setImage(img);
        }
        else if (event.getTarget()==su6){
            su6.setImage(img);
        }
        else if (event.getTarget()==su7){
            su7.setImage(img);
        }
        else if (event.getTarget()==su8){
            su8.setImage(img);
        }
        else if (event.getTarget()==su9){
            su9.setImage(img);
        }
        else if (event.getTarget()==su10){
            su10.setImage(img);
        }
        else if (event.getTarget()==su11){
            su11.setImage(img);
        }
        else if (event.getTarget()==su12){
            su12.setImage(img);
        }
        else if (event.getTarget()==su13){
            su13.setImage(img);
        }
        else if (event.getTarget()==su14){
            su14.setImage(img);
        }
        else if (event.getTarget()==su15){
            su15.setImage(img);
        }
        else{}
        //Asettaa vedetyn kuvan img11 paikalle.
        /*
        
        voisiko tähän rakentaa metodin joka tunnistaa oikean imageviewn
        johon kuva pudotetaan?
        */
     
       

    }
    @FXML
    private void onMousePressed(MouseEvent mouseEvent)throws FileNotFoundException{
      
        if(img11.isPressed()){
            if (img11.getImage() != null){
            img11.setImage(null); 
    }}
       else if(img12.isPressed()){
      if (img12.getImage() != null){
            img12.setImage(null); 
    }}
       else if(img13.isPressed()){
       if (img13.getImage() != null){
            img13.setImage(null); 
    }}
       else if(img14.isPressed()){
     if (img14.getImage() != null){
            img14.setImage(null); 
    }}
       else if(img15.isPressed()){
       if (img15.getImage() != null){
            img15.setImage(null); 
    }}
      else if(img21.isPressed()){
      if (img21.getImage() != null){
            img21.setImage(null); 
    }}
       else if(img22.isPressed()){
       if (img22.getImage() != null){
            img22.setImage(null); 
    }}
      else if(img23.isPressed()){
       if (img23.getImage() != null){
            img23.setImage(null); 
    }}
     else if(img24.isPressed()){
      if (img24.getImage() != null){
            img24.setImage(null); 
    }}
    else if(img25.isPressed()){
       if (img25.getImage() != null){
            img25.setImage(null); 
    }}
    else if(img31.isPressed()){
       if (img31.getImage() != null){
            img31.setImage(null); 
    }}
    else  if(img32.isPressed()){
       if (img32.getImage() != null){
            img32.setImage(null); 
    }}
   else if(img33.isPressed()){
        if (img33.getImage() != null){
            img33.setImage(null); 
    }}
  else if(img34.isPressed()){
        if (img34.getImage() != null){
            img34.setImage(null); 
    }}
  else if(img35.isPressed()){
         if (img35.getImage() != null){
            img35.setImage(null); 
    }}
  else if(img41.isPressed()){
         if (img41.getImage() != null){
            img41.setImage(null); 
    }}
  else if(img42.isPressed()){
         if (img42.getImage() != null){
            img42.setImage(null); 
    }}
  else if(img43.isPressed()){
         if (img43.getImage() != null){
            img43.setImage(null); 
    }}
  else if(img44.isPressed()){
        if (img44.getImage() != null){
            img44.setImage(null); 
    }}
  else if(img45.isPressed()){
        if (img45.getImage() != null){
            img45.setImage(null); 
    }}
  else if(img51.isPressed()){
        if (img51.getImage() != null){
            img51.setImage(null); 
    }}
  else if(img52.isPressed()){
        if (img52.getImage() != null){
            img52.setImage(null); 
    }}
  else if(img53.isPressed()){
        if (img53.getImage() != null){
            img53.setImage(null); 
    }}
  else if(img54.isPressed()){
        if (img54.getImage() != null){
            img54.setImage(null); 
    }}
  else if(img55.isPressed()){
        if (img55.getImage() != null){
            img55.setImage(null); 
    }}
  else if(img61.isPressed()){
        if (img61.getImage() != null){
            img61.setImage(null); 
    }}
  else if(img62.isPressed()){
        if (img62.getImage() != null){
            img62.setImage(null); 
    }}
  else if(img63.isPressed()){
        if (img63.getImage() != null){
            img63.setImage(null); 
    }}
  else if(img64.isPressed()){
        if (img64.getImage() != null){
            img64.setImage(null); 
    }}
  else if(img65.isPressed()){
        if (img65.getImage() != null){
            img65.setImage(null); 
    }}
  else if(img71.isPressed()){
        if (img71.getImage() != null){
            img71.setImage(null); 
    }}
  else if(img72.isPressed()){
        if (img72.getImage() != null){
            img72.setImage(null); 
    }}
  else if(img73.isPressed()){
        if (img73.getImage() != null){
            img73.setImage(null); 
    }}
  else if(img74.isPressed()){
        if (img74.getImage() != null){
            img74.setImage(null); 
    }}
  else if(img75.isPressed()){
        if (img75.getImage() != null){
            img75.setImage(null); 
    }}
    }
      
    
    /*
    Ikkunan sulkemisen yhteyteen voidaan yhdistää tallennus
    ja toiminto joka mahdollistaa turvallisen sulkemisen myös "ruksista"
    */
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        //saveProgram();
        stage.close();
}
    @FXML
    private void saveButtonAction(){
        //saveProgram();
        
    }
    
}

    


