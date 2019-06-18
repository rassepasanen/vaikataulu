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
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;
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
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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
import javafx.stage.Window;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *Kontrolliluokka
 * @author Vera Bärlund, Jani Heiskanen, Rasmus Pasanen
 */
public class FXMLDocumentController implements Initializable{

   @FXML public Button otaKuva;
   @FXML private SplitPane viikkonakyma;
   @FXML private AnchorPane manakyma;
   @FXML private AnchorPane tinakyma;
   @FXML private AnchorPane kenakyma;
   @FXML private AnchorPane tonakyma;
   @FXML private AnchorPane penakyma;
   @FXML private AnchorPane lanakyma;
   @FXML private AnchorPane sunakyma;
    @FXML public Button uusiViikko, maButton, tiButton, keButton, closeButton,
    toButton, peButton, laButton, suButton, tallennaPoistu;
    
    @FXML private ImageView img11, img12, img13, img14, img15, img16, img17, img18, img19,
                            img21, img22, img23, img24, img25, img26, img27, img28, img29,
                            img31, img32, img33, img34, img35, img36, img37, img38, img39,
                            img41, img42, img43, img44, img45, img46, img47, img48, img49,
                            img51, img52, img53, img54, img55, img56, img57, img58, img59,
                            img61, img62, img63, img64, img65, img66, img67, img68, img69,
                            img71, img72, img73, img74, img75, img76, img77, img78, img79;
    @FXML private ImageView ma1, ma2, ma3, ma4, ma5, ma6, ma7, ma8, ma9, ma10,
            ma11, ma12, ma13, ma14, ma15, ma16, ma17, ma18, ma19, ma20, ma21,
            ma22, ma23, ma24, ma25, ma26, ma27;
    @FXML private ImageView ti1, ti2, ti3, ti4, ti5, ti6, ti7, ti8, ti9, ti10,
            ti11, ti12, ti13, ti14, ti15, ti16, ti17, ti18, ti19, ti20, ti21,
            ti22, ti23, ti24, ti25, ti26, ti27;
    @FXML private ImageView ke1, ke2, ke3, ke4, ke5, ke6, ke7, ke8, ke9, ke10,
            ke11, ke12, ke13, ke14, ke15, ke16, ke17, ke18, ke19, ke20, ke21,
            ke22, ke23, ke24, ke25, ke26, ke27;
    @FXML private ImageView to1, to2, to3, to4, to5, to6, to7, to8, to9, to10,
            to11, to12, to13, to14, to15, to16, to17, to18, to19, to20, to21,
            to22, to23, to24, to25, to26, to27;
    @FXML private ImageView pe1, pe2, pe3, pe4, pe5, pe6, pe7, pe8, pe9, pe10,
            pe11, pe12, pe13, pe14, pe15, pe16, pe17, pe18, pe19, pe20, pe21,
            pe22, pe23, pe24, pe25, pe26, pe27;
    @FXML private ImageView la1, la2, la3, la4, la5, la6, la7, la8, la9, la10,
            la11, la12, la13, la14, la15, la16, la17, la18, la19, la20, la21,
            la22, la23, la24, la25, la26, la27;
    @FXML private ImageView su1, su2, su3, su4, su5, su6, su7, su8, su9, su10,
            su11, su12, su13, su14, su15, su16, su17, su18, su19, su20, su21,
            su22, su23, su24, su25, su26, su27;
    
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
    
    
    /**
    *Viikkonäkymän maanantai-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listMaanantaiLisaa(MouseEvent mouseEvent) throws IOException{
       if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        else if (listMaanantai.size()==5){
            listMaanantai.add(5,image);
            img16.setImage(image);
        }
        else if (listMaanantai.size()==6){
            listMaanantai.add(6,image);
            img17.setImage(image);
        }
        else if (listMaanantai.size()==7){
            listMaanantai.add(7,image);
            img18.setImage(image);
        }
        else if (listMaanantai.size()==8){
            listMaanantai.add(8,image);
            img19.setImage(image);
        }
         }
    }
        /**
    *Viikkonäkymän tiistai-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listTiistaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        }
          else if (listTiistai.size()==5){
            listTiistai.add(5,image);
            img26.setImage(image);
        }
        else if (listTiistai.size()==6){
            listTiistai.add(6,image);
            img27.setImage(image);
        }
        else if (listTiistai.size()==7){
            listTiistai.add(7,image);
            img28.setImage(image);
        }
        else if (listTiistai.size()==8){
            listTiistai.add(8,image);
            img29.setImage(image);
        }}
    }
        /**
    *Viikkonäkymän keskiviikko-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listKeskiviikkoLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        } 
         else if (listKeskiviikko.size()==5){
            listKeskiviikko.add(5,image);
            img36.setImage(image);
        }
        else if (listKeskiviikko.size()==6){
            listKeskiviikko.add(6,image);
            img37.setImage(image);
        }
        else if (listKeskiviikko.size()==7){
            listKeskiviikko.add(7,image);
            img38.setImage(image);
        }
        else if (listKeskiviikko.size()==8){
            listKeskiviikko.add(8,image);
            img39.setImage(image);
        }
        }
    }
    /**
    *Viikkonäkymän torstai-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listTorstaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        }
         else if (listTorstai.size()==5){
            listTorstai.add(5,image);
            img46.setImage(image);
        }
        else if (listTorstai.size()==6){
            listTorstai.add(6,image);
            img47.setImage(image);
        }
        else if (listTorstai.size()==7){
            listTorstai.add(7,image);
            img48.setImage(image);
        }
        else if (listTorstai.size()==8){
            listTorstai.add(8,image);
            img49.setImage(image);
        }}
    }
    /**
    *Viikkonäkymän perjantai-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listPerjantaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
         else if (listPerjantai.size()==5){
            listPerjantai.add(5,image);
            img56.setImage(image);
        }
        else if (listPerjantai.size()==6){
            listPerjantai.add(6,image);
            img57.setImage(image);
        }
        else if (listPerjantai.size()==7){
            listPerjantai.add(7,image);
            img58.setImage(image);
        }
        else if (listPerjantai.size()==8){
            listPerjantai.add(8,image);
            img59.setImage(image);
        }
    }}
     /**
    *Viikkonäkymän lauantai-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listLauantaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        }
        else if (listLauantai.size()==5){
            listLauantai.add(5,image);
            img66.setImage(image);
        }
        else if (listLauantai.size()==6){
            listLauantai.add(6,image);
            img67.setImage(image);
        }
        else if (listLauantai.size()==7){
            listLauantai.add(7,image);
            img68.setImage(image);
        }
        else if (listLauantai.size()==8){
            listLauantai.add(8,image);
            img69.setImage(image);
        }}
    }
    /**
    *Viikkonäkymän sunnuntai-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listSunnuntaiLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
          else if (listSunnuntai.size()==5){
            listSunnuntai.add(5,image);
            img76.setImage(image);
        }
        else if (listSunnuntai.size()==6){
            listSunnuntai.add(6,image);
            img77.setImage(image);
        }
        else if (listSunnuntai.size()==7){
            listSunnuntai.add(7,image);
            img78.setImage(image);
        }
        else if (listSunnuntai.size()==8){
            listSunnuntai.add(8,image);
            img79.setImage(image);
        }
    }}
    /**
    *Päivänäkymän maanantain aamu-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listMaAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        else if (listMaAamu.size()==5){
            listMaAamu.add(5,image);
            ma6.setImage(image);
        }
        else if (listMaAamu.size()==6){
            listMaAamu.add(6,image);
            ma7.setImage(image);
        }
        else if (listMaAamu.size()==7){
            listMaAamu.add(7,image);
            ma8.setImage(image);
        }
        else if (listMaAamu.size()==8){
            listMaAamu.add(8,image);
            ma9.setImage(image);
        }
       
    }}
     /**
    *Päivänäkymän maanantain päivä-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listMaPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listMaPaiva.isEmpty()){
            listMaPaiva.add(0,image);
            ma10.setImage(image);
        }
        else if (listMaPaiva.size()==1){
            listMaPaiva.add(1,image);
            ma11.setImage(image);
        }
        else if (listMaPaiva.size()==2){
            listMaPaiva.add(2,image);
            ma12.setImage(image);
        }
        else if (listMaPaiva.size()==3){
            listMaPaiva.add(3,image);
            ma13.setImage(image);
        }
        else if (listMaPaiva.size()==4){
            listMaPaiva.add(4,image);
            ma14.setImage(image);
        }
        else if (listMaPaiva.size()==5){
            listMaPaiva.add(5,image);
            ma15.setImage(image);
        }
        else if (listMaPaiva.size()==6){
            listMaPaiva.add(6,image);
            ma16.setImage(image);
        }
        else if (listMaPaiva.size()==7){
            listMaPaiva.add(7,image);
            ma17.setImage(image);
        }
        else if (listMaPaiva.size()==8){
            listMaPaiva.add(8,image);
            ma18.setImage(image);
        }
    }}
     /**
    *Päivänäkymän maanantain ilta-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listMaIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listMaIlta.isEmpty()){
            listMaIlta.add(0,image);
            ma19.setImage(image);
        }
        else if (listMaIlta.size()==1){
            listMaIlta.add(1,image);
            ma20.setImage(image);
        }
        else if (listMaIlta.size()==2){
            listMaIlta.add(2,image);
            ma21.setImage(image);
        }
        else if (listMaIlta.size()==3){
            listMaIlta.add(3,image);
            ma22.setImage(image);
        }
        else if (listMaIlta.size()==4){
            listMaIlta.add(4,image);
            ma23.setImage(image);
        }
        else if (listMaIlta.size()==5){
            listMaIlta.add(5,image);
            ma24.setImage(image);
        }
        else if (listMaIlta.size()==6){
            listMaIlta.add(6,image);
            ma25.setImage(image);
        }
        else if (listMaIlta.size()==7){
            listMaIlta.add(7,image);
            ma26.setImage(image);
        }
        else if (listMaIlta.size()==8){
            listMaIlta.add(8,image);
            ma27.setImage(image);
        }
    }}
     /**
    *Päivänäkymän tiistain aamu-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listTiAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        else if (listTiAamu.size()==5){
            listTiAamu.add(5,image);
            ti6.setImage(image);
        }
        else if (listTiAamu.size()==6){
            listTiAamu.add(6,image);
            ti7.setImage(image);
        }
        else if (listTiAamu.size()==7){
            listTiAamu.add(7,image);
            ti8.setImage(image);
        }
        else if (listTiAamu.size()==8){
            listTiAamu.add(8,image);
            ti9.setImage(image);
        }
    }}
     /**
    *Päivänäkymän tiistain päivä-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listTiPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listTiPaiva.isEmpty()){
            listTiPaiva.add(0,image);
            ti10.setImage(image);
        }
        else if (listTiPaiva.size()==1){
            listTiPaiva.add(1,image);
            ti11.setImage(image);
        }
        else if (listTiPaiva.size()==2){
            listTiPaiva.add(2,image);
            ti12.setImage(image);
        }
        else if (listTiPaiva.size()==3){
            listTiPaiva.add(3,image);
            ti13.setImage(image);
        }
        else if (listTiPaiva.size()==4){
            listTiPaiva.add(4,image);
            ti14.setImage(image);
        }
        else if (listTiPaiva.size()==5){
            listTiPaiva.add(5,image);
            ti15.setImage(image);
        }
        else if (listTiPaiva.size()==6){
            listTiPaiva.add(6,image);
            ti16.setImage(image);
        }
        else if (listTiPaiva.size()==7){
            listTiPaiva.add(7,image);
            ti17.setImage(image);
        }
        else if (listTiPaiva.size()==8){
            listTiPaiva.add(8,image);
            ti18.setImage(image);
        }
    }}
     /**
    *Päivänäkymän tiistain ilta-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listTiIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listTiIlta.isEmpty()){
            listTiIlta.add(0,image);
            ti19.setImage(image);
        }
        else if (listTiIlta.size()==1){
            listTiIlta.add(1,image);
            ti20.setImage(image);
        }
        else if (listTiIlta.size()==2){
            listTiIlta.add(2,image);
            ti21.setImage(image);
        }
        else if (listTiIlta.size()==3){
            listTiIlta.add(3,image);
            ti22.setImage(image);
        }
        else if (listTiIlta.size()==4){
            listTiIlta.add(4,image);
            ti23.setImage(image);
        }
        else if (listTiIlta.size()==5){
            listTiIlta.add(5,image);
            ti24.setImage(image);
        }
        else if (listTiIlta.size()==6){
            listTiIlta.add(6,image);
            ti25.setImage(image);
        }
        else if (listTiIlta.size()==7){
            listTiIlta.add(7,image);
            ti26.setImage(image);
        }
        else if (listTiIlta.size()==8){
            listTiIlta.add(8,image);
            ti27.setImage(image);
        }
    }}
    /**
    *Päivänäkymän keskiviikko aamu-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listKeAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
            listKeAamu.add(4,image);
            ke5.setImage(image);
        }
        else if (listKeAamu.size()==5){
            listKeAamu.add(5,image);
            ke6.setImage(image);
        }
        else if (listKeAamu.size()==6){
            listKeAamu.add(6,image);
            ke7.setImage(image);
        }
        else if (listKeAamu.size()==7){
            listKeAamu.add(7,image);
            ke8.setImage(image);
        }
        else if (listKeAamu.size()==8){
            listKeAamu.add(8,image);
            ke9.setImage(image);
        }
    }}
     /**
    *Päivänäkymän keskiviikon päivä-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listKePaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listKePaiva.isEmpty()){
            listKePaiva.add(0,image);
            ke10.setImage(image);
        }
        else if (listKePaiva.size()==1){
            listKePaiva.add(1,image);
            ke11.setImage(image);
        }
        else if (listKePaiva.size()==2){
            listKePaiva.add(2,image);
            ke12.setImage(image);
        }
        else if (listKePaiva.size()==3){
            listKePaiva.add(3,image);
            ke13.setImage(image);
        }
        else if (listKePaiva.size()==4){
            listKePaiva.add(4,image);
            ke14.setImage(image);
        }
        else if (listKePaiva.size()==5){
            listKePaiva.add(5,image);
            ke15.setImage(image);
        }
        else if (listKePaiva.size()==6){
            listKePaiva.add(6,image);
            ke16.setImage(image);
        }
        else if (listKePaiva.size()==7){
            listKePaiva.add(7,image);
            ke17.setImage(image);
        }
        else if (listKePaiva.size()==8){
            listKePaiva.add(8,image);
            ke18.setImage(image);
        }
    }}
     /**
    *Päivänäkymän keskiviikon ilta-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listKeIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listKeIlta.isEmpty()){
            listKeIlta.add(0,image);
            ke19.setImage(image);
        }
        else if (listKeIlta.size()==1){
            listKeIlta.add(1,image);
            ke20.setImage(image);
        }
        else if (listKeIlta.size()==2){
            listKeIlta.add(2,image);
            ke21.setImage(image);
        }
        else if (listKeIlta.size()==3){
            listKeIlta.add(3,image);
            ke22.setImage(image);
        }
        else if (listKeIlta.size()==4){
            listKeIlta.add(4,image);
            ke23.setImage(image);
        }
        else if (listKeIlta.size()==5){
            listKeIlta.add(5,image);
            ke24.setImage(image);
        }
        else if (listKeIlta.size()==6){
            listKeIlta.add(6,image);
            ke25.setImage(image);
        }
        else if (listKeIlta.size()==7){
            listKeIlta.add(7,image);
            ke26.setImage(image);
        }
        else if (listKeIlta.size()==8){
            listKeIlta.add(8,image);
            ke27.setImage(image);
        }
    }}
     /**
    *Päivänäkymän torstain aamu-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listToAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        else if (listToAamu.size()==5){
            listToAamu.add(5,image);
            to6.setImage(image);
        }
        else if (listToAamu.size()==6){
            listToAamu.add(6,image);
            to7.setImage(image);
        }
        else if (listToAamu.size()==7){
            listToAamu.add(7,image);
            to8.setImage(image);
        }
        else if (listToAamu.size()==8){
            listToAamu.add(8,image);
            to9.setImage(image);
        }
    }}
     /**
    *Päivänäkymän torstain päivä-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listToPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listToPaiva.isEmpty()){
            listToPaiva.add(0,image);
            to10.setImage(image);
        }
        else if (listToPaiva.size()==1){
            listToPaiva.add(1,image);
            to11.setImage(image);
        }
        else if (listToPaiva.size()==2){
            listToPaiva.add(2,image);
            to12.setImage(image);
        }
        else if (listToPaiva.size()==3){
            listToPaiva.add(3,image);
            to13.setImage(image);
        }
        else if (listToPaiva.size()==4){
            listToPaiva.add(4,image);
            to14.setImage(image);
        }
        else if (listToPaiva.size()==5){
            listToPaiva.add(5,image);
            to15.setImage(image);
        }
        else if (listToPaiva.size()==6){
            listToPaiva.add(6,image);
            to16.setImage(image);
        }
        else if (listToPaiva.size()==7){
            listToPaiva.add(7,image);
            to17.setImage(image);
        }
        else if (listToPaiva.size()==8){
            listToPaiva.add(8,image);
            to18.setImage(image);
        }
    }}
     /**
    *Päivänäkymän torstain ilta-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listToIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listToIlta.isEmpty()){
            listToIlta.add(0,image);
            to19.setImage(image);
        }
        else if (listToIlta.size()==1){
            listToIlta.add(1,image);
            to20.setImage(image);
        }
        else if (listToIlta.size()==2){
            listToIlta.add(2,image);
            to21.setImage(image);
        }
        else if (listToIlta.size()==3){
            listToIlta.add(3,image);
            to22.setImage(image);
        }
        else if (listToIlta.size()==4){
            listToIlta.add(4,image);
            to23.setImage(image);
        }
        else if (listToIlta.size()==5){
            listToIlta.add(5,image);
            to24.setImage(image);
        }
        else if (listToIlta.size()==6){
            listToIlta.add(6,image);
            to25.setImage(image);
        }
        else if (listToIlta.size()==7){
            listToIlta.add(7,image);
            to26.setImage(image);
        }
        else if (listToIlta.size()==8){
            listToIlta.add(8,image);
            to27.setImage(image);
        }
    }}
     /**
    *Päivänäkymän perjantain aamu-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listPeAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        else if (listPeAamu.size()==5){
            listPeAamu.add(5,image);
            pe6.setImage(image);
        }
        else if (listPeAamu.size()==6){
            listPeAamu.add(6,image);
            pe7.setImage(image);
        }
        else if (listPeAamu.size()==7){
            listPeAamu.add(7,image);
            pe8.setImage(image);
        }
        else if (listPeAamu.size()==8){
            listPeAamu.add(8,image);
            pe9.setImage(image);
        }
    }}
     /**
    *Päivänäkymän perjantain päivä-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listPePaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listPePaiva.isEmpty()){
            listPePaiva.add(0,image);
            pe10.setImage(image);
        }
        else if (listPePaiva.size()==1){
            listPePaiva.add(1,image);
            pe11.setImage(image);
        }
        else if (listPePaiva.size()==2){
            listPePaiva.add(2,image);
            pe12.setImage(image);
        }
        else if (listPePaiva.size()==3){
            listPePaiva.add(3,image);
            pe13.setImage(image);
        }
        else if (listPePaiva.size()==4){
            listPePaiva.add(4,image);
            pe14.setImage(image);
        }
        else if (listPePaiva.size()==5){
            listPePaiva.add(5,image);
            pe15.setImage(image);
        }
        else if (listPePaiva.size()==6){
            listPePaiva.add(6,image);
            pe16.setImage(image);
        }
        else if (listPePaiva.size()==7){
            listPePaiva.add(7,image);
            pe17.setImage(image);
        }
        else if (listPePaiva.size()==8){
            listPePaiva.add(8,image);
            pe18.setImage(image);
        }
    }}
     /**
    *Päivänäkymän perjantain ilta-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listPeIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listPeIlta.isEmpty()){
            listPeIlta.add(0,image);
            pe10.setImage(image);
        }
        else if (listPeIlta.size()==1){
            listPeIlta.add(1,image);
            pe11.setImage(image);
        }
        else if (listPeIlta.size()==2){
            listPeIlta.add(2,image);
            pe12.setImage(image);
        }
        else if (listPeIlta.size()==3){
            listPeIlta.add(3,image);
            pe13.setImage(image);
        }
        else if (listPeIlta.size()==4){
            listPeIlta.add(4,image);
            pe14.setImage(image);
        }
        else if (listPeIlta.size()==5){
            listPeIlta.add(5,image);
            pe15.setImage(image);
        }
        else if (listPeIlta.size()==6){
            listPeIlta.add(6,image);
            pe16.setImage(image);
        }
        else if (listPeIlta.size()==7){
            listPeIlta.add(7,image);
            pe17.setImage(image);
        }
        else if (listPeIlta.size()==8){
            listPeIlta.add(8,image);
            pe18.setImage(image);
        }
    }}
     /**
    *Päivänäkymän lauantain aamu-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listLaAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        else if (listLaAamu.size()==5){
            listLaAamu.add(5,image);
            la6.setImage(image);
        }
        else if (listLaAamu.size()==6){
            listLaAamu.add(6,image);
            la7.setImage(image);
        }
        else if (listLaAamu.size()==7){
            listLaAamu.add(7,image);
            la8.setImage(image);
        }
        else if (listLaAamu.size()==8){
            listLaAamu.add(8,image);
            la9.setImage(image);
        }
    }}
     /**
    *Päivänäkymän launtain päivä-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listLaPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listLaPaiva.isEmpty()){
            listLaPaiva.add(0,image);
            la10.setImage(image);
        }
        else if (listLaPaiva.size()==1){
            listLaPaiva.add(1,image);
            la11.setImage(image);
        }
        else if (listLaPaiva.size()==2){
            listLaPaiva.add(2,image);
            la12.setImage(image);
        }
        else if (listLaPaiva.size()==3){
            listLaPaiva.add(3,image);
            la13.setImage(image);
        }
        else if (listLaPaiva.size()==4){
            listLaPaiva.add(4,image);
            la14.setImage(image);
        }
        else if (listLaPaiva.size()==5){
            listLaPaiva.add(5,image);
            la15.setImage(image);
        }
        else if (listLaPaiva.size()==6){
            listLaPaiva.add(6,image);
            la16.setImage(image);
        }
        else if (listLaPaiva.size()==7){
            listLaPaiva.add(7,image);
            la17.setImage(image);
        }
        else if (listLaPaiva.size()==8){
            listLaPaiva.add(8,image);
            la18.setImage(image);
        }
    }}
     /**
    *Päivänäkymän lauantain ilta-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listLaIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listLaIlta.isEmpty()){
            listLaIlta.add(0,image);
            la19.setImage(image);
        }
        else if (listLaIlta.size()==1){
            listLaIlta.add(1,image);
            la20.setImage(image);
        }
        else if (listLaIlta.size()==2){
            listLaIlta.add(2,image);
            la21.setImage(image);
        }
        else if (listLaIlta.size()==3){
            listLaIlta.add(3,image);
            la22.setImage(image);
        }
        else if (listLaIlta.size()==4){
            listLaIlta.add(4,image);
            la23.setImage(image);
        }
        else if (listLaIlta.size()==5){
            listLaIlta.add(5,image);
            la24.setImage(image);
        }
        else if (listLaIlta.size()==6){
            listLaIlta.add(6,image);
            la25.setImage(image);
        }
        else if (listLaIlta.size()==7){
            listLaIlta.add(7,image);
            la26.setImage(image);
        }
        else if (listLaIlta.size()==8){
            listLaIlta.add(8,image);
            la27.setImage(image);
        }
    }}
     /**
    *Päivänäkymän sunnuntain aamu-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    * @throws IOException 
    */
    public void listSuAamuLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
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
        else if (listSuAamu.size()==5){
            listSuAamu.add(5,image);
            su6.setImage(image);
        }
        else if (listSuAamu.size()==6){
            listSuAamu.add(6,image);
            su7.setImage(image);
        }
        else if (listSuAamu.size()==7){
            listSuAamu.add(7,image);
            su8.setImage(image);
        }
        else if (listSuAamu.size()==8){
            listSuAamu.add(8,image);
            su9.setImage(image);
        }
    }}
  /**
   * Päivänäkymän sunnuntain päivä-kuvanlisays.
   * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
   * halutulle paikalle.
   * @param mouseEvent Hiiren klikkaus
   * @throws IOException 
   */
    public void listSuPaivaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listSuPaiva.isEmpty()){
            listSuPaiva.add(0,image);
            su10.setImage(image);
        }
        else if (listSuPaiva.size()==1){
            listSuPaiva.add(1,image);
            su11.setImage(image);
        }
        else if (listSuPaiva.size()==2){
            listSuPaiva.add(2,image);
            su12.setImage(image);
        }
        else if (listSuPaiva.size()==3){
            listSuPaiva.add(3,image);
            su13.setImage(image);
        }
        else if (listSuPaiva.size()==4){
            listSuPaiva.add(4,image);
            su14.setImage(image);
        }
        else if (listSuPaiva.size()==5){
            listSuPaiva.add(5,image);
            su15.setImage(image);
        }
        else if (listSuPaiva.size()==6){
            listSuPaiva.add(6,image);
            su16.setImage(image);
        }
        else if (listSuPaiva.size()==7){
            listSuPaiva.add(7,image);
            su17.setImage(image);
        }
        else if (listSuPaiva.size()==8){
            listSuPaiva.add(8,image);
            su18.setImage(image);
        }
    }}
     /**
    *Päivänäkymän sunnuntain ilta-kuvanlisäys.
    * Kun paneelia on klikattu x2, aukeaa FileChooser, josta vedetään kuva
    * halutulle paikalle.
    * @param mouseEvent Hiiren klikkaus
    *@throws IOException 
    */
    public void listSuIltaLisaa(MouseEvent mouseEvent) throws IOException{
        if(mouseEvent.getClickCount() == 2){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage img = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(img, null);
        if (listSuIlta.isEmpty()){
            listSuIlta.add(0,image);
            su19.setImage(image);
        }
        else if (listSuIlta.size()==1){
            listSuIlta.add(1,image);
            su20.setImage(image);
        }
        else if (listSuIlta.size()==2){
            listSuIlta.add(2,image);
            su21.setImage(image);
        }
        else if (listSuIlta.size()==3){
            listSuIlta.add(3,image);
            su22.setImage(image);
        }
        else if (listSuIlta.size()==4){
            listSuIlta.add(4,image);
            su23.setImage(image);
        }
        else if (listSuIlta.size()==5){
            listSuIlta.add(5,image);
            su24.setImage(image);
        }
        else if (listSuIlta.size()==6){
            listSuIlta.add(6,image);
            su25.setImage(image);
        }
        else if (listSuIlta.size()==7){
            listSuIlta.add(7,image);
            su26.setImage(image);
        }
        else if (listSuIlta.size()==8){
            listSuIlta.add(8,image);
            su27.setImage(image);
        }
    }}
    
    /**
     * Uuden viikon luonti ja viikonpäivien avaus painikkeilla.
     * Metodi, joka tyhjentää viikkonäkymän painettaessa "Luo uusi viikko" 
     * -painiketta. Painettaessa viikonpäivän painiketta avaa kyseisen päivä-
     * näkymän.
     * @param event Painikkeen painallus
     * @throws IOException 
     */
    @FXML
    void handleButtonAction(ActionEvent event) throws IOException{
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
        img16.setImage(null);
        img17.setImage(null);
        img18.setImage(null);
        img19.setImage(null);
        listTiistai.clear();
        img21.setImage(null);
        img22.setImage(null);
        img23.setImage(null);
        img24.setImage(null);
        img25.setImage(null);
        img26.setImage(null);
        img27.setImage(null);
        img28.setImage(null);
        img29.setImage(null);
        listKeskiviikko.clear();
        img31.setImage(null);
        img32.setImage(null);
        img33.setImage(null);
        img34.setImage(null);
        img35.setImage(null);
        img36.setImage(null);
        img37.setImage(null);
        img38.setImage(null);
        img39.setImage(null);
        listTorstai.clear();
        img41.setImage(null);
        img42.setImage(null);
        img43.setImage(null);
        img44.setImage(null);
        img45.setImage(null);
        img46.setImage(null);
        img47.setImage(null);
        img48.setImage(null);
        img49.setImage(null);
        listPerjantai.clear();
        img51.setImage(null);
        img52.setImage(null);
        img53.setImage(null);
        img54.setImage(null);
        img55.setImage(null);
        img56.setImage(null);
        img57.setImage(null);
        img58.setImage(null);
        img59.setImage(null);
        listLauantai.clear();
        img61.setImage(null);
        img62.setImage(null);
        img63.setImage(null);
        img64.setImage(null);
        img65.setImage(null);
        img66.setImage(null);
        img67.setImage(null);
        img68.setImage(null);
        img69.setImage(null);
        listSunnuntai.clear();
        img71.setImage(null);
        img72.setImage(null);
        img73.setImage(null);
        img74.setImage(null);
        img75.setImage(null);
        img76.setImage(null);
        img77.setImage(null);
        img78.setImage(null);
        img79.setImage(null);
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
    
    /**
     * Maanantain päivänäkymän tyhjennys.
     * @param event Painettaessa "Luo uusi päivä" -painiketta tyhjentää
     * näkymän.
     * @throws IOException 
     */
    @FXML
    public void uusiMaanantai(ActionEvent event) throws IOException{
        
        //uuden päivän luonti
        if(event.getSource()==uusiViikko){ 
        listMaAamu.clear();
        ma1.setImage(null);
        ma2.setImage(null);
        ma3.setImage(null);
        ma4.setImage(null);
        ma5.setImage(null);
        ma6.setImage(null);
        ma7.setImage(null);
        ma8.setImage(null);
        ma9.setImage(null);
        listMaPaiva.clear();
        ma10.setImage(null);
        ma11.setImage(null);
        ma12.setImage(null);
        ma13.setImage(null);
        ma14.setImage(null);
        ma15.setImage(null);
        ma16.setImage(null);
        ma17.setImage(null);
        ma18.setImage(null);
        listMaIlta.clear();
        ma19.setImage(null);
        ma20.setImage(null);
        ma21.setImage(null);
        ma22.setImage(null);
        ma23.setImage(null);
        ma24.setImage(null);
        ma25.setImage(null);
        ma26.setImage(null);
        ma27.setImage(null);
        } 
        else{}
     }
    /**
     * Tiistain päivänäkymän tyhjennys.
     * @param event Painettaessa "Luo uusi päivä" -painiketta tyhjentää
     * näkymän.
     * @throws IOException 
     */
     @FXML
    public void uusiTiistai(ActionEvent event) throws IOException{
       
        //uuden päivän luonti
        if(event.getSource()==uusiViikko){ 
        listTiAamu.clear();
        ti1.setImage(null);
        ti2.setImage(null);
        ti3.setImage(null);
        ti4.setImage(null);
        ti5.setImage(null);
        ti6.setImage(null);
        ti7.setImage(null);
        ti8.setImage(null);
        ti9.setImage(null);
        listTiPaiva.clear();
        ti10.setImage(null);
        ti11.setImage(null);
        ti12.setImage(null);
        ti13.setImage(null);
        ti14.setImage(null);
        ti15.setImage(null);
        ti16.setImage(null);
        ti17.setImage(null);
        ti18.setImage(null);
        listTiIlta.clear();
        ti19.setImage(null);
        ti20.setImage(null);
        ti21.setImage(null);
        ti22.setImage(null);
        ti23.setImage(null);
        ti24.setImage(null);
        ti25.setImage(null);
        ti26.setImage(null);
        ti27.setImage(null);
        }
        else{}}
    
    /**
     * Keskiviikon päivänäkymän tyhjennys.
     * @param event Painettaessa "Luo uusi päivä" -painiketta tyhjentää
     * näkymän.
     * @throws IOException 
     */
      @FXML
    public void uusiKeskiviikko(ActionEvent event) throws IOException{
      
        //uuden päivän luonti
        if(event.getSource()==uusiViikko){ 
        listKeAamu.clear();
        ke1.setImage(null);
        ke2.setImage(null);
        ke3.setImage(null);
        ke4.setImage(null);
        ke5.setImage(null);
        ke6.setImage(null);
        ke7.setImage(null);
        ke8.setImage(null);
        ke9.setImage(null);
        listKePaiva.clear();
        ke10.setImage(null);
        ke11.setImage(null);
        ke12.setImage(null);
        ke13.setImage(null);
        ke14.setImage(null);
        ke15.setImage(null);
        ke16.setImage(null);
        ke17.setImage(null);
        ke18.setImage(null);
        listKeIlta.clear();
        ke19.setImage(null);
        ke20.setImage(null);
        ke21.setImage(null);
        ke22.setImage(null);
        ke23.setImage(null);
        ke24.setImage(null);
        ke25.setImage(null);
        ke26.setImage(null);
        ke27.setImage(null);
    }
        else{}
    }
    
    /**
     * Torstain päivänäkymän tyhjennys.
     * @param event Painettaessa "Luo uusi päivä" -painiketta tyhjentää
     * näkymän.
     * @throws IOException 
     */
     @FXML
    public void uusiTorstai(ActionEvent event) throws IOException{
      
        //uuden päivän luonti
        if(event.getSource()==uusiViikko){ 
        listToAamu.clear();
        to1.setImage(null);
        to2.setImage(null);
        to3.setImage(null);
        to4.setImage(null);
        to5.setImage(null);
        to6.setImage(null);
        to7.setImage(null);
        to8.setImage(null);
        to9.setImage(null);
        listToPaiva.clear();
        to10.setImage(null);
        to11.setImage(null);
        to12.setImage(null);
        to13.setImage(null);
        to14.setImage(null);
        to15.setImage(null);
        to16.setImage(null);
        to17.setImage(null);
        to18.setImage(null);
        listToIlta.clear();
        to19.setImage(null);
        to20.setImage(null);
        to21.setImage(null);
        to22.setImage(null);
        to23.setImage(null);
        to24.setImage(null);
        to25.setImage(null);
        to26.setImage(null);
        to27.setImage(null);
        }
        else{}
    }
    
    /**
     * Perjantain päivänäkymän tyhjennys.
     * @param event Painettaessa "Luo uusi päivä" -painiketta tyhjentää
     * näkymän.
     * @throws IOException 
     */
     @FXML
    public void uusiPerjantai(ActionEvent event) throws IOException{
       
         //uuden päivän luonti
        if(event.getSource()==uusiViikko){
        listPeAamu.clear();
        pe1.setImage(null);
        pe2.setImage(null);
        pe3.setImage(null);
        pe4.setImage(null);
        pe5.setImage(null);
        pe6.setImage(null);
        pe7.setImage(null);
        pe8.setImage(null);
        pe9.setImage(null);
        listPePaiva.clear();
        pe10.setImage(null);
        pe11.setImage(null);
        pe12.setImage(null);
        pe13.setImage(null);
        pe14.setImage(null);
        pe15.setImage(null);
        pe16.setImage(null);
        pe17.setImage(null);
        pe18.setImage(null);
        listPeIlta.clear();
        pe19.setImage(null);
        pe20.setImage(null);
        pe21.setImage(null);
        pe22.setImage(null);
        pe23.setImage(null);
        pe24.setImage(null);
        pe25.setImage(null);
        pe26.setImage(null);
        pe27.setImage(null);
        }
        else{}
    }
    
    /**
     * Lauantain päivänäkymän tyhjennys.
     * @param event Painettaessa "Luo uusi päivä" -painiketta tyhjentää
     * näkymän.
     * @throws IOException 
     */
     @FXML
    public void uusiLauantai(ActionEvent event) throws IOException{
         
         //uuden päivän luonti
        if(event.getSource()==uusiViikko){
        listLaAamu.clear();
        la1.setImage(null);
        la2.setImage(null);
        la3.setImage(null);
        la4.setImage(null);
        la5.setImage(null);
        la6.setImage(null);
        la7.setImage(null);
        la8.setImage(null);
        la9.setImage(null);
        listLaPaiva.clear();
        la10.setImage(null);
        la11.setImage(null);
        la12.setImage(null);
        la13.setImage(null);
        la14.setImage(null);
        la15.setImage(null);
        la16.setImage(null);
        la17.setImage(null);
        la18.setImage(null);
        listLaIlta.clear();
        la19.setImage(null);
        la20.setImage(null);
        la21.setImage(null);
        la22.setImage(null);
        la23.setImage(null);
        la24.setImage(null);
        la25.setImage(null);
        la26.setImage(null);
        la27.setImage(null);
        }
        else{}
    }
    
    /**
     * Sunnuntain päivänäkymän tyhjennys.
     * @param event Painettaessa "Luo uusi päivä" -painiketta tyhjentää
     * näkymän.
     * @throws IOException 
     */
     @FXML
    public void uusiSunnuntai(ActionEvent event) throws IOException{
      
         //uuden päivän luonti
        if(event.getSource()==uusiViikko){
        listSuAamu.clear();
        su1.setImage(null);
        su2.setImage(null);
        su3.setImage(null);
        su4.setImage(null);
        su5.setImage(null);
        su6.setImage(null);
        su7.setImage(null);
        su8.setImage(null);
        su9.setImage(null);
        listSuPaiva.clear();
        su10.setImage(null);
        su11.setImage(null);
        su12.setImage(null);
        su13.setImage(null);
        su14.setImage(null);
        su15.setImage(null);
        su16.setImage(null);
        su17.setImage(null);
        su18.setImage(null);
        listSuIlta.clear();
        su19.setImage(null);
        su20.setImage(null);
        su21.setImage(null);
        su22.setImage(null);
        su23.setImage(null);
        su24.setImage(null);
        su25.setImage(null);
        su26.setImage(null);
        su27.setImage(null);
        }
        else{}
    }
    
    /**
     * Maanantai-päivänäkymän yksittäisten kuvien poisto.
     * Klikkaamalla kuvaa se poistuu.
     * @param mev Hiiren klikkaus
     * @throws FileNotFoundException 
     */
    @FXML
    public void MaanantaiPoisto(MouseEvent mev)throws FileNotFoundException{
        
   if(ma1.isPressed()){
        if (ma1.getImage() != null){
            ma1.setImage(null); 
    }}
  else if(ma2.isPressed()){
        if (ma2.getImage() != null){
            ma2.setImage(null); 
    }}
  else if(ma3.isPressed()){
        if (ma3.getImage() != null){
            ma3.setImage(null); 
    }}
  else if(ma4.isPressed()){
        if (ma4.getImage() != null){
            ma4.setImage(null); 
    }}
  else if(ma5.isPressed()){
        if (ma5.getImage() != null){
            ma5.setImage(null); 
    }}
  else if(ma6.isPressed()){
        if (ma6.getImage() != null){
            ma6.setImage(null); 
    }}
  else if(ma7.isPressed()){
        if (ma7.getImage() != null){
            ma7.setImage(null); 
    }}
  else if(ma8.isPressed()){
        if (ma8.getImage() != null){
            ma8.setImage(null); 
    }}
  else if(ma9.isPressed()){
        if (ma9.getImage() != null){
            ma9.setImage(null); 
    }}
  else if(ma10.isPressed()){
        if (ma10.getImage() != null){
            ma10.setImage(null); 
    }}
  else if(ma11.isPressed()){
        if (ma11.getImage() != null){
            ma11.setImage(null); 
    }}
  else if(ma12.isPressed()){
        if (ma12.getImage() != null){
            ma12.setImage(null); 
    }}
  else if(ma13.isPressed()){
        if (ma13.getImage() != null){
            ma13.setImage(null); 
    }}
  else if(ma14.isPressed()){
        if (ma14.getImage() != null){
            ma14.setImage(null); 
    }}
  else if(ma15.isPressed()){
        if (ma15.getImage() != null){
            ma15.setImage(null); 
    }
  }
   else if(ma16.isPressed()){
        if (ma16.getImage() != null){
            ma16.setImage(null); 
    }
  }
   else if(ma17.isPressed()){
        if (ma17.getImage() != null){
            ma17.setImage(null); 
    }
  }
   else if(ma18.isPressed()){
        if (ma18.getImage() != null){
            ma18.setImage(null); 
    }
  }
   else if(ma19.isPressed()){
        if (ma19.getImage() != null){
            ma19.setImage(null); 
    }
  }
   else if(ma20.isPressed()){
        if (ma20.getImage() != null){
            ma20.setImage(null); 
    }
  }
   else if(ma21.isPressed()){
        if (ma21.getImage() != null){
            ma21.setImage(null); 
    }
  }
   else if(ma22.isPressed()){
        if (ma22.getImage() != null){
            ma22.setImage(null); 
    }
  }
   else if(ma23.isPressed()){
        if (ma23.getImage() != null){
            ma23.setImage(null); 
    }
  }
   else if(ma24.isPressed()){
        if (ma24.getImage() != null){
            ma24.setImage(null); 
    }
  }
   else if(ma25.isPressed()){
        if (ma25.getImage() != null){
            ma25.setImage(null); 
    }
  }
   else if(ma26.isPressed()){
        if (ma26.getImage() != null){
            ma26.setImage(null); 
    }
  }
   else if(ma27.isPressed()){
        if (ma27.getImage() != null){
            ma27.setImage(null); 
    }
  }
 
    }
    
    
    /**
     * Tiistai-päivänäkymän yksittäisten kuvien poisto.
     * Klikkaamalla kuvaa se poistuu.
     * @param mev Hiiren klikkaus
     * @throws FileNotFoundException 
     */
    @FXML
    public void TiistaiPoisto(MouseEvent mev)throws FileNotFoundException{
   if(ti1.isPressed()){
        if (ti1.getImage() != null){
            ti1.setImage(null); 
    }}
  else if(ti2.isPressed()){
        if (ti2.getImage() != null){
            ti2.setImage(null); 
    }}
  else if(ti3.isPressed()){
        if (ti3.getImage() != null){
            ti3.setImage(null); 
    }}
  else if(ti4.isPressed()){
        if (ti4.getImage() != null){
            ti4.setImage(null); 
    }}
  else if(ti5.isPressed()){
        if (ti5.getImage() != null){
            ti5.setImage(null); 
    }}
  else if(ti6.isPressed()){
        if (ti6.getImage() != null){
            ti6.setImage(null); 
    }}
  else if(ti7.isPressed()){
        if (ti7.getImage() != null){
            ti7.setImage(null); 
    }}
  else if(ti8.isPressed()){
        if (ti8.getImage() != null){
            ti8.setImage(null); 
    }}
  else if(ti9.isPressed()){
        if (ti9.getImage() != null){
            ti9.setImage(null); 
    }}
  else if(ti10.isPressed()){
        if (ti10.getImage() != null){
            ti10.setImage(null); 
    }}
  else if(ti11.isPressed()){
        if (ti11.getImage() != null){
            ti11.setImage(null); 
    }}
  else if(ti12.isPressed()){
        if (ti12.getImage() != null){
            ti12.setImage(null); 
    }}
  else if(ti13.isPressed()){
        if (ti13.getImage() != null){
            ti13.setImage(null); 
    }}
  else if(ti14.isPressed()){
        if (ti14.getImage() != null){
            ti14.setImage(null); 
    }}
  else if(ti15.isPressed()){
        if (ti15.getImage() != null){
            ti15.setImage(null); 
    }}
   else if(ti16.isPressed()){
        if (ti16.getImage() != null){
            ti16.setImage(null); 
    }}
   else if(ti17.isPressed()){
        if (ti17.getImage() != null){
            ti17.setImage(null); 
    }}
   else if(ti18.isPressed()){
        if (ti18.getImage() != null){
            ti18.setImage(null); 
    }}
   else if(ti19.isPressed()){
        if (ti19.getImage() != null){
            ti19.setImage(null); 
    }}
   else if(ti20.isPressed()){
        if (ti20.getImage() != null){
            ti20.setImage(null); 
    }}
   else if(ti21.isPressed()){
        if (ti21.getImage() != null){
            ti21.setImage(null); 
    }}
   else if(ti22.isPressed()){
        if (ti22.getImage() != null){
            ti22.setImage(null); 
    }}
   else if(ti23.isPressed()){
        if (ti23.getImage() != null){
            ti23.setImage(null); 
    }}
   else if(ti24.isPressed()){
        if (ti24.getImage() != null){
            ti24.setImage(null); 
    }}
   else if(ti25.isPressed()){
        if (ti25.getImage() != null){
            ti25.setImage(null); 
    }}
   else if(ti26.isPressed()){
        if (ti26.getImage() != null){
            ti26.setImage(null); 
    }}
   else if(ti27.isPressed()){
        if (ti27.getImage() != null){
            ti27.setImage(null); 
    }}
    }
    
    
    /**
     * Keskiviikko-päivänäkymän yksittäisten kuvien poisto.
     * Klikkaamalla kuvaa se poistuu.
     * @param mev Hiiren klikkaus
     * @throws FileNotFoundException 
     */
    @FXML
    public void KeskiviikkoPoisto(MouseEvent mev)throws FileNotFoundException{
  if(ke1.isPressed()){
        if (ke1.getImage() != null){
            ke1.setImage(null); 
    }}
  else if(ke2.isPressed()){
        if (ke2.getImage() != null){
            ke2.setImage(null); 
    }}
  else if(ke3.isPressed()){
        if (ke3.getImage() != null){
            ke3.setImage(null); 
    }}
  else if(ke4.isPressed()){
        if (ke4.getImage() != null){
            ke4.setImage(null); 
    }}
  else if(ke5.isPressed()){
        if (ke5.getImage() != null){
            ke5.setImage(null); 
    }}
  else if(ke6.isPressed()){
        if (ke6.getImage() != null){
            ke6.setImage(null); 
    }}
  else if(ke7.isPressed()){
        if (ke7.getImage() != null){
            ke7.setImage(null); 
    }}
  else if(ke8.isPressed()){
        if (ke8.getImage() != null){
            ke8.setImage(null); 
    }}
  else if(ke9.isPressed()){
        if (ke9.getImage() != null){
            ke9.setImage(null); 
    }}
  else if(ke10.isPressed()){
        if (ke10.getImage() != null){
            ke10.setImage(null); 
    }}
  else if(ke11.isPressed()){
        if (ke11.getImage() != null){
            ke11.setImage(null); 
    }}
  else if(ke12.isPressed()){
        if (ke12.getImage() != null){
            ke12.setImage(null); 
    }}
  else if(ke13.isPressed()){
        if (ke13.getImage() != null){
            ke13.setImage(null); 
    }}
  else if(ke14.isPressed()){
        if (ke14.getImage() != null){
            ke14.setImage(null); 
    }}
  else if(ke15.isPressed()){
        if (ke15.getImage() != null){
            ke15.setImage(null); 
    }}
  else if(ke16.isPressed()){
        if (ke16.getImage() != null){
            ke16.setImage(null); 
    }}
   else if(ke17.isPressed()){
        if (ke17.getImage() != null){
            ke17.setImage(null); 
    }}
   else if(ke18.isPressed()){
        if (ke18.getImage() != null){
            ke18.setImage(null); 
    }}
   else if(ke19.isPressed()){
        if (ke19.getImage() != null){
            ke19.setImage(null); 
    }}
   else if(ke20.isPressed()){
        if (ke20.getImage() != null){
            ke20.setImage(null); 
    }}
   else if(ke21.isPressed()){
        if (ke21.getImage() != null){
            ke21.setImage(null); 
    }}
   else if(ke22.isPressed()){
        if (ke22.getImage() != null){
            ke22.setImage(null); 
    }}
   else if(ke23.isPressed()){
        if (ke23.getImage() != null){
            ke23.setImage(null); 
    }}
   else if(ke24.isPressed()){
        if (ke24.getImage() != null){
            ke24.setImage(null); 
    }}
   else if(ke25.isPressed()){
        if (ke25.getImage() != null){
            ke25.setImage(null); 
    }}
   else if(ke26.isPressed()){
        if (ke26.getImage() != null){
            ke26.setImage(null); 
    }}
   else if(ke27.isPressed()){
        if (ke27.getImage() != null){
            ke27.setImage(null); 
    }}
  
    }

    
    /**
     * Torstai-päivänäkymän yksittäisten kuvien poisto.
     * Klikkaamalla kuvaa se poistuu.
     * @param mev Hiiren klikkaus
     * @throws FileNotFoundException 
     */
    @FXML
    public void TorstaiPoisto(MouseEvent mev)throws FileNotFoundException {
        
  if(to1.isPressed()){
        if (to1.getImage() != null){
            to1.setImage(null); 
    }}
  else if(to2.isPressed()){
        if (to2.getImage() != null){
            to2.setImage(null); 
    }}
  else if(to3.isPressed()){
        if (to3.getImage() != null){
            to3.setImage(null); 
    }}
  else if(to4.isPressed()){
        if (to4.getImage() != null){
            to4.setImage(null); 
    }}
  else if(to5.isPressed()){
        if (to5.getImage() != null){
            to5.setImage(null); 
    }}
  else if(to6.isPressed()){
        if (to6.getImage() != null){
            to6.setImage(null); 
    }}
  else if(to7.isPressed()){
        if (to7.getImage() != null){
            to7.setImage(null); 
    }}
  else if(to8.isPressed()){
        if (to8.getImage() != null){
            to8.setImage(null); 
    }}
  else if(to9.isPressed()){
        if (to9.getImage() != null){
            to9.setImage(null); 
    }}
  else if(to10.isPressed()){
        if (to10.getImage() != null){
            to10.setImage(null); 
    }}
  else if(to11.isPressed()){
        if (to11.getImage() != null){
            to11.setImage(null); 
    }}
  else if(to12.isPressed()){
        if (to12.getImage() != null){
            to12.setImage(null); 
    }}
  else if(to13.isPressed()){
        if (to13.getImage() != null){
            to13.setImage(null); 
    }}
  else if(to14.isPressed()){
        if (to14.getImage() != null){
            to14.setImage(null); 
    }}
  else if(to15.isPressed()){
        if (to15.getImage() != null){
            to15.setImage(null); 
    }}
  else if(to16.isPressed()){
        if (to16.getImage() != null){
            to16.setImage(null); 
    }}
   else if(to17.isPressed()){
        if (to17.getImage() != null){
            to17.setImage(null); 
    }}
   else if(to18.isPressed()){
        if (to18.getImage() != null){
            to18.setImage(null); 
    }}
   else if(to19.isPressed()){
        if (to19.getImage() != null){
            to19.setImage(null); 
    }}
   else if(to20.isPressed()){
        if (to20.getImage() != null){
            to20.setImage(null); 
    }}
   else if(to21.isPressed()){
        if (to21.getImage() != null){
            to21.setImage(null); 
    }}
   else if(to22.isPressed()){
        if (to22.getImage() != null){
            to22.setImage(null); 
    }}
   else if(to23.isPressed()){
        if (to23.getImage() != null){
            to23.setImage(null); 
    }}
   else if(to24.isPressed()){
        if (to24.getImage() != null){
            to24.setImage(null); 
    }}
   else if(to25.isPressed()){
        if (to25.getImage() != null){
            to25.setImage(null); 
    }}
   else if(to26.isPressed()){
        if (to26.getImage() != null){
            to26.setImage(null); 
    }}
   else if(to27.isPressed()){
        if (to27.getImage() != null){
            to27.setImage(null); 
    }}
    }
    
    
    /**
     * Perjantai-päivänäkymän yksittäisten kuvien poisto.
     * Klikkaamalla kuvaa se poistuu.
     * @param mev Hiiren klikkaus
     * @throws FileNotFoundException 
     */
    @FXML
    public void PerjantaiPoisto(MouseEvent mev)throws FileNotFoundException {
          
  if(pe1.isPressed()){
        if (pe1.getImage() != null){
            pe1.setImage(null); 
    }}
  else if(pe2.isPressed()){
        if (pe2.getImage() != null){
            pe2.setImage(null); 
    }}
  else if(pe3.isPressed()){
        if (pe3.getImage() != null){
            pe3.setImage(null); 
    }}
  else if(pe4.isPressed()){
        if (pe4.getImage() != null){
            pe4.setImage(null); 
    }}
  else if(pe5.isPressed()){
        if (pe5.getImage() != null){
            pe5.setImage(null); 
    }}
  else if(pe6.isPressed()){
        if (pe6.getImage() != null){
            pe6.setImage(null); 
    }}
  else if(pe7.isPressed()){
        if (pe7.getImage() != null){
            pe7.setImage(null); 
    }}
  else if(pe8.isPressed()){
        if (pe8.getImage() != null){
            pe8.setImage(null); 
    }}
  else if(pe9.isPressed()){
        if (pe9.getImage() != null){
            pe9.setImage(null); 
    }}
  else if(pe10.isPressed()){
        if (pe10.getImage() != null){
            pe10.setImage(null); 
    }}
  else if(pe11.isPressed()){
        if (pe11.getImage() != null){
            pe11.setImage(null); 
    }}
  else if(pe12.isPressed()){
        if (pe12.getImage() != null){
            pe12.setImage(null); 
    }}
  else if(pe13.isPressed()){
        if (pe13.getImage() != null){
            pe13.setImage(null); 
    }}
  else if(pe14.isPressed()){
        if (pe14.getImage() != null){
            pe14.setImage(null); 
    }}
  else if(pe15.isPressed()){
        if (pe15.getImage() != null){
            pe15.setImage(null); 
    }}
  else if(pe16.isPressed()){
        if (pe16.getImage() != null){
            pe16.setImage(null); 
    }}
   else if(pe17.isPressed()){
        if (pe17.getImage() != null){
            pe17.setImage(null); 
    }}
   else if(pe18.isPressed()){
        if (pe18.getImage() != null){
            pe18.setImage(null); 
    }}
   else if(pe19.isPressed()){
        if (pe19.getImage() != null){
            pe19.setImage(null); 
    }}
   else if(pe20.isPressed()){
        if (pe20.getImage() != null){
            pe20.setImage(null); 
    }}
   else if(pe21.isPressed()){
        if (pe21.getImage() != null){
            pe21.setImage(null); 
    }}
   else if(pe22.isPressed()){
        if (pe22.getImage() != null){
            pe22.setImage(null); 
    }}
   else if(pe23.isPressed()){
        if (pe23.getImage() != null){
            pe23.setImage(null); 
    }}
   else if(pe24.isPressed()){
        if (pe24.getImage() != null){
            pe24.setImage(null); 
    }}
   else if(pe25.isPressed()){
        if (pe25.getImage() != null){
            pe25.setImage(null); 
    }}
   else if(pe26.isPressed()){
        if (pe26.getImage() != null){
            pe26.setImage(null); 
    }}
   else if(pe27.isPressed()){
        if (pe27.getImage() != null){
            pe27.setImage(null); 
    }}
    }
    
    
    /**
     * Lauantai-päivänäkymän yksittäisten kuvien poisto.
     * Klikkaamalla kuvaa se poistuu.
     * @param mev Hiiren klikkaus
     * @throws FileNotFoundException 
     */
    @FXML
    public void LauantaiPoisto(MouseEvent mev)throws FileNotFoundException {
  if(la1.isPressed()){
        if (la1.getImage() != null){
            la1.setImage(null); 
    }}
  else if(la2.isPressed()){
        if (la2.getImage() != null){
            la2.setImage(null); 
    }}
  else if(la3.isPressed()){
        if (la3.getImage() != null){
            la3.setImage(null); 
    }}
  else if(la4.isPressed()){
        if (la4.getImage() != null){
            la4.setImage(null); 
    }}
  else if(la5.isPressed()){
        if (la5.getImage() != null){
            la5.setImage(null); 
    }}
  else if(la6.isPressed()){
        if (la6.getImage() != null){
            la6.setImage(null); 
    }}
  else if(la7.isPressed()){
        if (la7.getImage() != null){
            la7.setImage(null); 
    }}
  else if(la8.isPressed()){
        if (la8.getImage() != null){
            la8.setImage(null); 
    }}
  else if(la9.isPressed()){
        if (la9.getImage() != null){
            la9.setImage(null); 
    }}
  else if(la10.isPressed()){
        if (la10.getImage() != null){
            la10.setImage(null); 
    }}
  else if(la11.isPressed()){
        if (la11.getImage() != null){
            la11.setImage(null); 
    }}
  else if(la12.isPressed()){
        if (la12.getImage() != null){
            la12.setImage(null); 
    }}
  else if(la13.isPressed()){
        if (la13.getImage() != null){
            la13.setImage(null); 
    }}
  else if(la14.isPressed()){
        if (la14.getImage() != null){
            la14.setImage(null); 
    }}
  else if(la15.isPressed()){
        if (la15.getImage() != null){
            la15.setImage(null); 
    }}   
  else if(la16.isPressed()){
        if (la16.getImage() != null){
            la16.setImage(null); 
    }}
   else if(la17.isPressed()){
        if (la17.getImage() != null){
            la17.setImage(null); 
    }}
   else if(la18.isPressed()){
        if (la18.getImage() != null){
            la18.setImage(null); 
    }}
   else if(la19.isPressed()){
        if (la19.getImage() != null){
            la19.setImage(null); 
    }}
   else if(la20.isPressed()){
        if (la20.getImage() != null){
            la20.setImage(null); 
    }}
   else if(la21.isPressed()){
        if (la21.getImage() != null){
            la21.setImage(null); 
    }}
   else if(la22.isPressed()){
        if (la22.getImage() != null){
            la22.setImage(null); 
    }}
   else if(la23.isPressed()){
        if (la23.getImage() != null){
            la23.setImage(null); 
    }}
   else if(la24.isPressed()){
        if (la24.getImage() != null){
            la24.setImage(null); 
    }}
   else if(la25.isPressed()){
        if (la25.getImage() != null){
            la25.setImage(null); 
    }}
   else if(la26.isPressed()){
        if (la26.getImage() != null){
            la26.setImage(null); 
    }}
   else if(la27.isPressed()){
        if (la27.getImage() != null){
            la27.setImage(null); 
    }}
    }
    
    
    /**
     * Sunnuntai-päivänäkymän yksittäisten kuvien poisto.
     * Klikkaamalla kuvaa se poistuu.
     * @param mev Hiiren klikkaus
     * @throws FileNotFoundException 
     */
    @FXML
    public void SunnuntaiPoisto(MouseEvent mev)throws FileNotFoundException {
        
   if(su1.isPressed()){
        if (su1.getImage() != null){
            su1.setImage(null); 
    }}
  else if(su2.isPressed()){
        if (su2.getImage() != null){
            su2.setImage(null); 
    }}
  else if(su3.isPressed()){
        if (su3.getImage() != null){
            su3.setImage(null); 
    }}
  else if(su4.isPressed()){
        if (su4.getImage() != null){
            su4.setImage(null); 
    }}
  else if(su5.isPressed()){
        if (su5.getImage() != null){
            su5.setImage(null); 
    }}
  else if(su6.isPressed()){
        if (su6.getImage() != null){
            su6.setImage(null); 
    }}
  else if(su7.isPressed()){
        if (su7.getImage() != null){
            su7.setImage(null); 
    }}
  else if(su8.isPressed()){
        if (su8.getImage() != null){
            su8.setImage(null); 
    }}
  else if(su9.isPressed()){
        if (su9.getImage() != null){
            su9.setImage(null); 
    }}
  else if(su10.isPressed()){
        if (su10.getImage() != null){
            su10.setImage(null); 
    }}
  else if(su11.isPressed()){
        if (su11.getImage() != null){
            su11.setImage(null); 
    }}
  else if(su12.isPressed()){
        if (su12.getImage() != null){
            su12.setImage(null); 
    }}
  else if(su13.isPressed()){
        if (su13.getImage() != null){
            su13.setImage(null); 
    }}
  else if(su14.isPressed()){
        if (su14.getImage() != null){
            su14.setImage(null); 
    }}
  else if(su15.isPressed()){
        if (su15.getImage() != null){
            su15.setImage(null); 
    }}
   else if(su16.isPressed()){
        if (su16.getImage() != null){
            su16.setImage(null); 
    }}
   else if(su17.isPressed()){
        if (su17.getImage() != null){
            su17.setImage(null); 
    }}
   else if(su18.isPressed()){
        if (su18.getImage() != null){
            su18.setImage(null); 
    }}
   else if(su19.isPressed()){
        if (su19.getImage() != null){
            su19.setImage(null); 
    }}
   else if(su20.isPressed()){
        if (su20.getImage() != null){
            su20.setImage(null); 
    }}
   else if(su21.isPressed()){
        if (su21.getImage() != null){
            su21.setImage(null); 
    }}
   else if(su22.isPressed()){
        if (su22.getImage() != null){
            su22.setImage(null); 
    }}
   else if(su23.isPressed()){
        if (su23.getImage() != null){
            su23.setImage(null); 
    }}
   else if(su24.isPressed()){
        if (su24.getImage() != null){
            su24.setImage(null); 
    }}
   else if(su25.isPressed()){
        if (su25.getImage() != null){
            su25.setImage(null); 
    }}
   else if(su26.isPressed()){
        if (su26.getImage() != null){
            su26.setImage(null); 
    }}
   else if(su27.isPressed()){
        if (su27.getImage() != null){
            su27.setImage(null); 
    }}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }
  
        
    /**
     * Metodi, joka tunnistaa, kun kuva on vedetty kohdalle.
     * @param event Kuvan raahaus
     */
    @FXML
    public void handleOver(DragEvent event){
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }
        
        
    }
    /**
     * Metodi, joka asettaa kuvan valitulle paikalle.
     * @param event Raahaus
     * @throws FileNotFoundException 
     */
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
        else if (event.getTarget()==img16){
            img16.setImage(img);
        }
        else if (event.getTarget()==img17){
            img17.setImage(img);
        }
        else if (event.getTarget()==img18){
            img18.setImage(img);
        }
        else if (event.getTarget()==img19){
            img19.setImage(img);
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
        else if (event.getTarget()==img26){
            img26.setImage(img);
        }
        else if (event.getTarget()==img27){
            img27.setImage(img);
        }
        else if (event.getTarget()==img28){
            img28.setImage(img);
        }
        else if (event.getTarget()==img29){
            img29.setImage(img);
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
          else if (event.getTarget()==img36){
            img36.setImage(img);
        }
        else if (event.getTarget()==img37){
            img37.setImage(img);
        }
        else if (event.getTarget()==img38){
            img38.setImage(img);
        }
        else if (event.getTarget()==img39){
            img39.setImage(img);
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
          else if (event.getTarget()==img46){
            img46.setImage(img);
        }
        else if (event.getTarget()==img47){
            img47.setImage(img);
        }
        else if (event.getTarget()==img48){
            img48.setImage(img);
        }
        else if (event.getTarget()==img49){
            img49.setImage(img);
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
          else if (event.getTarget()==img56){
            img56.setImage(img);
        }
        else if (event.getTarget()==img57){
            img57.setImage(img);
        }
        else if (event.getTarget()==img58){
            img58.setImage(img);
        }
        else if (event.getTarget()==img59){
            img59.setImage(img);
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
        else if (event.getTarget()==img66){
            img66.setImage(img);
        }
        else if (event.getTarget()==img67){
            img67.setImage(img);
        }
        else if (event.getTarget()==img68){
            img68.setImage(img);
        }
        else if (event.getTarget()==img69){
            img69.setImage(img);
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
          else if (event.getTarget()==img76){
            img76.setImage(img);
        }
        else if (event.getTarget()==img77){
            img77.setImage(img);
        }
        else if (event.getTarget()==img78){
            img78.setImage(img);
        }
        else if (event.getTarget()==img79){
            img79.setImage(img);
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
        else if (event.getTarget()==ma16){
            ma16.setImage(img);
        }
        else if (event.getTarget()==ma17){
            ma17.setImage(img);
        }
        else if (event.getTarget()==ma18){
            ma18.setImage(img);
        }
        else if (event.getTarget()==ma19){
            ma19.setImage(img);
        }
        else if (event.getTarget()==ma20){
            ma20.setImage(img);
        }
        else if (event.getTarget()==ma21){
            ma21.setImage(img);
        }
        else if (event.getTarget()==ma22){
            ma22.setImage(img);
        }
        else if (event.getTarget()==ma23){
            ma23.setImage(img);
        }
        else if (event.getTarget()==ma24){
            ma24.setImage(img);
        }
        else if (event.getTarget()==ma25){
            ma25.setImage(img);
        }
        else if (event.getTarget()==ma26){
            ma26.setImage(img);
        }
        else if (event.getTarget()==ma27){
            ma27.setImage(img);
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
        else if (event.getTarget()==ti16){
            ti16.setImage(img);
        }
        else if (event.getTarget()==ti17){
            ti17.setImage(img);
        }
        else if (event.getTarget()==ti18){
            ti18.setImage(img);
        }
        else if (event.getTarget()==ti19){
            ti19.setImage(img);
        }
        else if (event.getTarget()==ti20){
            ti20.setImage(img);
        }
        else if (event.getTarget()==ti21){
            ti21.setImage(img);
        }
        else if (event.getTarget()==ti22){
            ti22.setImage(img);
        }
        else if (event.getTarget()==ti23){
            ti23.setImage(img);
        }
        else if (event.getTarget()==ti24){
            ti24.setImage(img);
        }
        else if (event.getTarget()==ti25){
            ti25.setImage(img);
        }
        else if (event.getTarget()==ti26){
            ti26.setImage(img);
        }
        else if (event.getTarget()==ti27){
            ti27.setImage(img);
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
        else if (event.getTarget()==ke7){
            ke7.setImage(img);
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
        else if (event.getTarget()==ke16){
            ke16.setImage(img);
        }
        else if (event.getTarget()==ke17){
            ke17.setImage(img);
        }
        else if (event.getTarget()==ke18){
            ke18.setImage(img);
        }
        else if (event.getTarget()==ke19){
            ke19.setImage(img);
        }
        else if (event.getTarget()==ke20){
            ke20.setImage(img);
        }
        else if (event.getTarget()==ke21){
            ke21.setImage(img);
        }
        else if (event.getTarget()==ke22){
            ke22.setImage(img);
        }
        else if (event.getTarget()==ke23){
            ke23.setImage(img);
        }
        else if (event.getTarget()==ke24){
            ke24.setImage(img);
        }
        else if (event.getTarget()==ke25){
            ke25.setImage(img);
        }
        else if (event.getTarget()==ke26){
            ke26.setImage(img);
        }
        else if (event.getTarget()==ke27){
            ke27.setImage(img);
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
        else if (event.getTarget()==to16){
            to16.setImage(img);
        }
        else if (event.getTarget()==to17){
            to17.setImage(img);
        }
        else if (event.getTarget()==to18){
            to18.setImage(img);
        }
        else if (event.getTarget()==to19){
            to19.setImage(img);
        }
        else if (event.getTarget()==to20){
            to20.setImage(img);
        }
        else if (event.getTarget()==to21){
            to21.setImage(img);
        }
        else if (event.getTarget()==to22){
            to22.setImage(img);
        }
        else if (event.getTarget()==to23){
            to23.setImage(img);
        }
        else if (event.getTarget()==to24){
            to24.setImage(img);
        }
        else if (event.getTarget()==to25){
            to25.setImage(img);
        }
        else if (event.getTarget()==to26){
            to26.setImage(img);
        }
        else if (event.getTarget()==to27){
            to27.setImage(img);
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
        else if (event.getTarget()==pe16){
            pe16.setImage(img);
        }
        else if (event.getTarget()==pe17){
            pe17.setImage(img);
        }
        else if (event.getTarget()==pe18){
            pe18.setImage(img);
        }
        else if (event.getTarget()==pe19){
            pe19.setImage(img);
        }
        else if (event.getTarget()==pe20){
            pe20.setImage(img);
        }
        else if (event.getTarget()==pe21){
            pe21.setImage(img);
        }
        else if (event.getTarget()==pe22){
            pe22.setImage(img);
        }
        else if (event.getTarget()==pe23){
            pe23.setImage(img);
        }
        else if (event.getTarget()==pe24){
            pe24.setImage(img);
        }
        else if (event.getTarget()==pe25){
            pe25.setImage(img);
        }
        else if (event.getTarget()==pe26){
            pe26.setImage(img);
        }
        else if (event.getTarget()==pe27){
            pe27.setImage(img);
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
        else if (event.getTarget()==la16){
            la16.setImage(img);
        }
        else if (event.getTarget()==la17){
            la17.setImage(img);
        }
        else if (event.getTarget()==la18){
            la18.setImage(img);
        }
        else if (event.getTarget()==la19){
            la19.setImage(img);
        }
        else if (event.getTarget()==la20){
            la20.setImage(img);
        }
        else if (event.getTarget()==la21){
            la21.setImage(img);
        }
        else if (event.getTarget()==la22){
            la22.setImage(img);
        }
        else if (event.getTarget()==la23){
            la23.setImage(img);
        }
        else if (event.getTarget()==la24){
            la24.setImage(img);
        }
        else if (event.getTarget()==la25){
            la25.setImage(img);
        }
        else if (event.getTarget()==la26){
            la26.setImage(img);
        }
        else if (event.getTarget()==la27){
            la27.setImage(img);
        }
        //sunnuntain päivänäkymän imaget
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
        else if (event.getTarget()==su16){
            su16.setImage(img);
        }
        else if (event.getTarget()==su17){
            su17.setImage(img);
        }
        else if (event.getTarget()==su18){
            su18.setImage(img);
        }
        else if (event.getTarget()==su19){
            su19.setImage(img);
        }
        else if (event.getTarget()==su20){
            su20.setImage(img);
        }
        else if (event.getTarget()==su21){
            su21.setImage(img);
        }
        else if (event.getTarget()==su22){
            su22.setImage(img);
        }
        else if (event.getTarget()==su23){
            su23.setImage(img);
        }
        else if (event.getTarget()==su24){
            su24.setImage(img);
        }
        else if (event.getTarget()==su25){
            su25.setImage(img);
        }
        else if (event.getTarget()==su26){
            su26.setImage(img);
        }
        else if (event.getTarget()==su27){
            su27.setImage(img);
        }
        else{}
    }

    /**
     * Viikkonäkymän yksittäisten kuvien poisto.
     * Kun kuvaa klikataan, se poistuu.
     * @param mouseEvent Hiiren klikkaus
     * @throws FileNotFoundException 
     */
    @FXML
    public void onMousePressed(MouseEvent mouseEvent)throws FileNotFoundException{
      
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
       else if(img16.isPressed()){
      if (img16.getImage() != null){
            img16.setImage(null); 
    }}
       else if(img17.isPressed()){
       if (img17.getImage() != null){
            img17.setImage(null); 
    }}
       else if(img18.isPressed()){
     if (img18.getImage() != null){
            img18.setImage(null); 
    }}
       else if(img19.isPressed()){
       if (img19.getImage() != null){
            img19.setImage(null); 
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
         else if(img26.isPressed()){
      if (img26.getImage() != null){
            img26.setImage(null); 
    }}
       else if(img27.isPressed()){
       if (img27.getImage() != null){
            img27.setImage(null); 
    }}
       else if(img28.isPressed()){
     if (img28.getImage() != null){
            img28.setImage(null); 
    }}
       else if(img29.isPressed()){
       if (img29.getImage() != null){
            img29.setImage(null); 
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
       else if(img36.isPressed()){
      if (img36.getImage() != null){
            img36.setImage(null); 
    }}
       else if(img37.isPressed()){
       if (img37.getImage() != null){
            img37.setImage(null); 
    }}
       else if(img38.isPressed()){
     if (img38.getImage() != null){
            img38.setImage(null); 
    }}
       else if(img39.isPressed()){
       if (img39.getImage() != null){
            img39.setImage(null); 
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
       else if(img46.isPressed()){
      if (img46.getImage() != null){
            img46.setImage(null); 
    }}
       else if(img47.isPressed()){
       if (img47.getImage() != null){
            img47.setImage(null); 
    }}
       else if(img48.isPressed()){
     if (img48.getImage() != null){
            img48.setImage(null); 
    }}
       else if(img49.isPressed()){
       if (img49.getImage() != null){
            img49.setImage(null); 
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
       else if(img56.isPressed()){
      if (img56.getImage() != null){
            img56.setImage(null); 
    }}
       else if(img57.isPressed()){
       if (img57.getImage() != null){
            img57.setImage(null); 
    }}
       else if(img58.isPressed()){
     if (img58.getImage() != null){
            img58.setImage(null); 
    }}
       else if(img59.isPressed()){
       if (img59.getImage() != null){
            img59.setImage(null); 
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
       else if(img66.isPressed()){
      if (img66.getImage() != null){
            img66.setImage(null); 
    }}
       else if(img67.isPressed()){
       if (img67.getImage() != null){
            img67.setImage(null); 
    }}
       else if(img68.isPressed()){
     if (img68.getImage() != null){
            img68.setImage(null); 
    }}
       else if(img69.isPressed()){
       if (img69.getImage() != null){
            img69.setImage(null); 
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
   else if(img76.isPressed()){
      if (img76.getImage() != null){
            img76.setImage(null); 
    }}
       else if(img77.isPressed()){
       if (img77.getImage() != null){
            img77.setImage(null); 
    }}
       else if(img78.isPressed()){
     if (img78.getImage() != null){
            img78.setImage(null); 
    }}
       else if(img79.isPressed()){
       if (img79.getImage() != null){
            img79.setImage(null); 
    }}
 
  }
    
    
    /**
     * Takaisin-painike.
     * Painettaessa Takaisin-painiketta ohjelma sulkee päivänäkymä-ikkunan.
     */
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        //saveProgram();
        stage.close();
}
    //Ikkunan sulkemisen yhteyteen voidaan yhdistää tallennus
    //ja toiminto joka mahdollistaa turvallisen sulkemisen myös "ruksista"
    
    //Tässä tallennettaisiin ohjelma
    @FXML
    private void saveButtonAction(){
        //saveProgram();
        
    }
    
    /**
     * Viikkonäkymän kuvakaappaus-metodi.
     * Painettaessa "Tallenna kuva" -painiketta, ohjelma avaa FileChooserin,
     * jonka avulla tallennetaan kuvakaappaus työpöydälle.
     */
    @FXML
public void saveAsPng() {
    
    WritableImage image = viikkonakyma.snapshot(new SnapshotParameters(), null);
    FileChooser fc = new FileChooser();
    String defaultSaveName = "viikko.png";
    fc.setInitialFileName(defaultSaveName); 
   
    fc.setTitle("Tallenna kuva");
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG", "png");
    fc.getExtensionFilters().add(filter);
    fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
    File kuva = fc.showSaveDialog(null);

try
    {
       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", kuva);
        }
     catch (Exception ex)
    {

    }

}
 /**
     * Maanantain kuvakaappaus-metodi.
     * Painettaessa "Tallenna kuva" -painiketta, ohjelma avaa FileChooserin,
     * jonka avulla tallennetaan kuvakaappaus työpöydälle.
     */
    @FXML
public void saveAsPngMa(){
    WritableImage image = manakyma.snapshot(new SnapshotParameters(), null);
    FileChooser fc = new FileChooser();
    String defaultSaveName="maanantai.png";
    fc.setInitialFileName(defaultSaveName);
    
    fc.setTitle("Tallenna kuva");
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG", "png");
    fc.getExtensionFilters().add(filter);
    fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
    File kuva = fc.showSaveDialog(null);
    
    try
    {
       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", kuva);
        }
     catch (Exception ex)
    {

    }
}
 /**
     * Tiistain kuvakaappaus-metodi.
     * Painettaessa "Tallenna kuva" -painiketta, ohjelma avaa FileChooserin,
     * jonka avulla tallennetaan kuvakaappaus työpöydälle.
     */
    @FXML
public void saveAsPngTi(){
    WritableImage image = tinakyma.snapshot(new SnapshotParameters(), null);
    FileChooser fc = new FileChooser();
    String defaultSaveName="tiistai.png";
    fc.setInitialFileName(defaultSaveName);
    
    fc.setTitle("Tallenna kuva");
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG", "png");
    fc.getExtensionFilters().add(filter);
    fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
    File kuva = fc.showSaveDialog(null);
    
    try
    {
       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", kuva);
        }
     catch (Exception ex)
    {

    }
}
 /**
     * Keskiviikon kuvakaappaus-metodi.
     * Painettaessa "Tallenna kuva" -painiketta, ohjelma avaa FileChooserin,
     * jonka avulla tallennetaan kuvakaappaus työpöydälle.
     */
    @FXML
public void saveAsPngKe(){
    WritableImage image = kenakyma.snapshot(new SnapshotParameters(), null);
    FileChooser fc = new FileChooser();
    String defaultSaveName="keskiviikko.png";
    fc.setInitialFileName(defaultSaveName);
    
    fc.setTitle("Tallenna kuva");
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG", "png");
    fc.getExtensionFilters().add(filter);
    fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
    File kuva = fc.showSaveDialog(null);
    
    try
    {
       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", kuva);
        }
     catch (Exception ex)
    {

    }
}
 /**
     * Torstain kuvakaappaus-metodi.
     * Painettaessa "Tallenna kuva" -painiketta, ohjelma avaa FileChooserin,
     * jonka avulla tallennetaan kuvakaappaus työpöydälle.
     */
    @FXML
public void saveAsPngTo(){
    WritableImage image = tonakyma.snapshot(new SnapshotParameters(), null);
    FileChooser fc = new FileChooser();
    String defaultSaveName="torstai.png";
    fc.setInitialFileName(defaultSaveName);
    
    fc.setTitle("Tallenna kuva");
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG", "png");
    fc.getExtensionFilters().add(filter);
    fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
    File kuva = fc.showSaveDialog(null);
    
    try
    {
       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", kuva);
        }
     catch (Exception ex)
    {

    }
}
 /**
     * Perjantain kuvakaappaus-metodi.
     * Painettaessa "Tallenna kuva" -painiketta, ohjelma avaa FileChooserin,
     * jonka avulla tallennetaan kuvakaappaus työpöydälle.
     */
    @FXML
public void saveAsPngPe(){
    WritableImage image = penakyma.snapshot(new SnapshotParameters(), null);
    FileChooser fc = new FileChooser();
    String defaultSaveName="perjantai.png";
    fc.setInitialFileName(defaultSaveName);
    
    fc.setTitle("Tallenna kuva");
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG", "png");
    fc.getExtensionFilters().add(filter);
    fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
    File kuva = fc.showSaveDialog(null);
    
    try
    {
       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", kuva);
        }
     catch (Exception ex)
    {

    }
}
 /**
     * Lauantain kuvakaappaus-metodi.
     * Painettaessa "Tallenna kuva" -painiketta, ohjelma avaa FileChooserin,
     * jonka avulla tallennetaan kuvakaappaus työpöydälle.
     */
    @FXML
public void saveAsPngLa(){
    WritableImage image = lanakyma.snapshot(new SnapshotParameters(), null);
    FileChooser fc = new FileChooser();
    String defaultSaveName="lauantai.png";
    fc.setInitialFileName(defaultSaveName);
    
    fc.setTitle("Tallenna kuva");
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG", "png");
    fc.getExtensionFilters().add(filter);
    fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
    File kuva = fc.showSaveDialog(null);
    
    try
    {
       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", kuva);
        }
     catch (Exception ex)
    {

    }
}
 /**
     * Sunnuntain kuvakaappaus-metodi.
     * Painettaessa "Tallenna kuva" -painiketta, ohjelma avaa FileChooserin,
     * jonka avulla tallennetaan kuvakaappaus työpöydälle.
     */
    @FXML
public void saveAsPngSu(){
    WritableImage image = sunakyma.snapshot(new SnapshotParameters(), null);
    FileChooser fc = new FileChooser();
    String defaultSaveName="sunnuntai.png";
    fc.setInitialFileName(defaultSaveName);
    
    fc.setTitle("Tallenna kuva");
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PNG", "png");
    fc.getExtensionFilters().add(filter);
    fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
    File kuva = fc.showSaveDialog(null);
    
    try
    {
       ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", kuva);
        }
     catch (Exception ex)
    {

    }
}


}

