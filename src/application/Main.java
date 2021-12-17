package application;
import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Main extends Application {
	private File fileDir;
	private File[] files;
	private ArrayList<File> songs;
	private Media media;
	private MediaPlayer songPlayer;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			songs = new ArrayList<File>();
			fileDir = new File("Songs");
			files = fileDir.listFiles();	//store the files from Songs directory in the files array
			
			for(File file : files) {
				songs.add(file);
				System.out.println(file);
			}
			
			media = new Media(songs.get(0).toURI().toString());
			songPlayer = new MediaPlayer(media);
			
			//create image for logo
			Image lambdaLogo = new Image("lambdalogo.png");
			ImageView viewLambda = new ImageView(lambdaLogo);
			
			//creating a menu item
			Menu menu1 = new Menu("", viewLambda);
			//menu1.setStyle("-fx-font-size: 20px;");
			
			//an image to use for the play button
			Image playIcon = new Image("play.png");
			ImageView playView = new ImageView(playIcon);
			
			//an image to use for the pause button
			Image pauseIcon = new Image("pause.png");
			ImageView pauseView = new ImageView(pauseIcon);
			
			//backing of buttons
			Image backing = new Image("backing.png");
			ImageView backingView = new ImageView(backing);
			
			//creating the button to add a file
			Button playButton = new Button("", playView);
			playButton.setLayoutX(400);
			playButton.setLayoutY(445);
			playButton.setStyle("-fx-border-color: #E22B2B;");
			playButton.setStyle("-fx-background-color: none;");
			
			//creating the button to add a file
			Button pauseButton = new Button("", pauseView);
			pauseButton.setLayoutX(300);
			pauseButton.setLayoutY(445);
			pauseButton.setStyle("-fx-border-color: #E22B2B;");
			pauseButton.setStyle("-fx-background-color: none;");
			
			//invoke songplayer method on button press
			playButton.setOnAction(value ->  {
		           songPlayer();
		        });
			
			pauseButton.setOnAction(value ->  {
		           songPause();
		        });
			
			
			
			//creating a menu bar
			MenuBar menuBar = new MenuBar();
			menuBar.setMinWidth(800);
			menuBar.setMinHeight(50);
			menuBar.setStyle("-fx-background-color: #E22B2B;");
			
			//add menu items to the menu bar
			menuBar.getMenus().add(menu1);
			
			//create the root object which objects can be added upon
			Group rootObj = new Group(backingView, menuBar, playButton, pauseButton);
			
			//define a color object to use throughout the GUI
			Color c = Color.web("#1F1F1F");
			
			//define the scene, pass in the root object and the color object
			Scene scene = new Scene(rootObj, c);
			
			//an image to use as the application icon
			Image icon = new Image("Untitled-1.png");
			
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Lambda Player");
			primaryStage.setWidth(800);
			primaryStage.setHeight(800);
			primaryStage.setResizable(false);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void songPlayer() {
		songPlayer.play();
	}
	
	void songPause() {
		songPlayer.pause();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}