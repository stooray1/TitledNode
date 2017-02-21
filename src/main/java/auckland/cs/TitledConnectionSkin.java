package auckland.cs;

/**
 * SimpleConnectionSkin is extended to add more features   
 * @author mkha153 
 */

import java.util.List;
import java.util.Map;
import de.tesis.dynaware.grapheditor.core.skins.defaults.connection.SimpleConnectionSkin;
import de.tesis.dynaware.grapheditor.model.GConnection;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TitledConnectionSkin extends SimpleConnectionSkin {
	 private static final String STYLE_CLASS = "titled-connection";	    
	 private Popup popup;   
    /**
     * Creates a new simple connection skin instance with mouse event .
     *
     * @param connection the {@link GConnection} the skin is being created for
     */
    public TitledConnectionSkin(final GConnection connection) {

        super(connection);	              
        path.setMouseTransparent(true);
        root.setOnMousePressed(this::handleMousePressed);
        path.getStyleClass().setAll(STYLE_CLASS);
    }    
    
    @Override
    public void draw(final List<Point2D> points, final Map<GConnection, List<Point2D>> allPoints) {
        super.draw(points, allPoints);	        
    }    
  
    private void handleMousePressed(final MouseEvent event) {    	
       popup= new Popup(event.getScreenX(), event.getScreenY(), (Stage)root.getScene().getWindow(), getConnection().getId(), "Connection");     
       popup.show();   
    }	

}
