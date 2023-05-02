import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Contactapp extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("contact app.fxml"));//extracts the reference file 
        Scene scene = new Scene(root);
        primaryStage.setTitle("Contact App");// set the title of the app to the name given 
        primaryStage.setScene(scene);
        primaryStage.show();// displays the gui
    }
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
