package auckland.cs;

/**
 * SimpleConnectionSkin is extended to add more features   
 * @author mkha153 
 */

import java.util.List;
import java.util.Map;

import de.tesis.dynaware.grapheditor.core.skins.defaults.DefaultConnectionSkin;
import de.tesis.dynaware.grapheditor.model.GConnection;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import auckland.cs.Popup;

public class TitledConnectionSkin extends DefaultConnectionSkin {
	 private static final String STYLE_CLASS = "titled-connection";	 
	 private static double normal_strok_width;
	 private static double higlighted_strok_width;
	 
	 private int  dependencyIndex;
    /**
     * Creates a new simple connection skin instance with mouse event .
     *
     * @param connection the {@link GConnection} the skin is being created for
     */
    public TitledConnectionSkin(final GConnection connection) {

        super(connection);	              
        path.setMouseTransparent(true);
        root.setOnMouseClicked(this::handleMouseClicked);
        root.setOnMouseEntered(this::handleMouseEntered);
        root.setOnMouseExited(this::handleMouseExited); 
        
        path.getStyleClass().setAll(STYLE_CLASS);
        
        normal_strok_width = path.getStrokeWidth(); 
        higlighted_strok_width = normal_strok_width + 2.0;        
    }          
    
    @Override
    public void draw(final List<Point2D> points, final Map<GConnection, List<Point2D>> allPoints) {
        super.draw(points, allPoints);	        
    }    
  
    public void handleMouseClicked(final MouseEvent event) {
        if(event.getButton()== MouseButton.SECONDARY){
     	   Popup popup= new Popup(event.getScreenX(), event.getScreenY(), (Stage)root.getScene().getWindow(), 
     			                  getConnection().getId(), "Connection",  StageStyle.DECORATED);     
     	   popup.show();
     	  
        }
     }
    
    public void handleMouseEntered(final MouseEvent event){
    	this.path.setStrokeWidth(higlighted_strok_width);   	
    }
    
    public void handleMouseExited(final MouseEvent event){
    	this.path.setStrokeWidth(normal_strok_width);    	
    }

	public int getDependencyIndex() {
		return dependencyIndex;
	}

	public void setDependencyIndex(int dependencyIndex) {
		this.dependencyIndex = dependencyIndex;
	}
    
	public Group getRoot(){
		return root;
	}
	public Path getPath(){
		return path;
	}

}
