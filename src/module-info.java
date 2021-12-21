module MusicPlayer {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.web;
	
	opens application to javafx.graphics, javafx.fxml;
}
