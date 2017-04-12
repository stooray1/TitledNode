package auckland.cs;

/**
 * Simple popup window 
 * @author mkha153
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Popup {	
	
	protected static final double WIDTH =400.0;
	protected static final double HEIGHT =200.0; 
	protected  Stage stage;	
	protected Scene scene;
	
	protected Label lblTitle;
	protected TextArea txtMsg;
	protected Button btClose;
	protected BorderPane root;
	protected VBox cntrVBox; 
	private double dragOffsetX;
	private double dragOffsetY;
	
	public Popup(double x, double y, Stage owner, String msg, String title) {
		this(x, y, owner, msg, title, StageStyle.UNDECORATED,  WIDTH, HEIGHT);
	}	
	public Popup(double x, double y, Stage owner, String msg, String title, StageStyle style) {
		this(x, y, owner, msg, title, style, WIDTH, HEIGHT);		      
	}
	public Popup(double x, double y, Stage owner, String msg, String title, StageStyle style, double width, double height) {
		  stage = new Stage();
	      stage.initOwner(owner);
	      lblTitle = new Label(title);
	      txtMsg = new TextArea(msg);
	      cntrVBox = new VBox();
	      txtMsg.setEditable(false);
	      
	      btClose = new Button("Close");
	      btClose.setOnAction(e -> stage.close()); 
	         
	      root = new BorderPane();
	      root.setTop(lblTitle);
	      cntrVBox.getChildren().add(txtMsg);
	      root.setCenter(cntrVBox);
	      root.setBottom(btClose);
	      
	      
	      BorderPane.setAlignment(lblTitle, Pos.TOP_CENTER);
	      BorderPane.setAlignment(btClose, Pos.TOP_CENTER);
	      
	      
	      scene = new Scene(root, width, height);
	      // Set mouse pressed and dragged even handlers for the scene
	      scene.setOnMousePressed(e -> handleMousePressed(e));
	      scene.setOnMouseDragged(e -> handleMouseDragged(e));
	      stage.setScene(scene);
	      
	      //Hide borders 
	      stage.initStyle(style);      
	      stage.setX(x);
	      stage.setY(y);
	      
	      dragOffsetX = dragOffsetY = 0;      
	}	
	
	public void show(){
		  stage.show();	
	}
	public VBox getCenterVBox(){
		return this.cntrVBox;
	}
	
	public Stage getStage(){
		return this.stage;
	}
	public Scene getScene(){
		return this.scene;
	}
	protected void handleMousePressed(MouseEvent e) {
		 // Store the mouse x and y coordinates with respect to the
		 // stage in the reference variables to use them in the drag event
		 this.dragOffsetX = e.getScreenX() - stage.getX();
		 this.dragOffsetY = e.getScreenY() - stage.getY();
	}
	protected void handleMouseDragged(MouseEvent e) {
		// Move the stage by the drag amount
		stage.setX(e.getScreenX() - this.dragOffsetX);
		stage.setY(e.getScreenY() - this.dragOffsetY);
		
	}
	
}
