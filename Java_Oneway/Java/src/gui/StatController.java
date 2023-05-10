package gui;

import entities.Categorie;
import entities.Offre;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.CategorieService;
import services.OffreService;

public class StatController extends Application {

    private ObservableList<PieChart.Data> pieChartData;
    @FXML
    private PieChart piechart;

    @Override
    public void start(Stage stage) throws SQLException {
        // Initialize the data for the PieChart
        CategorieService cs = new CategorieService();
        List<Categorie> l = cs.recuperer();
        for (int i = 0; i > l.size(); i++) {
            PieChart.Data s = new PieChart.Data(l.get(i).getType(),i);

            pieChartData.add(i, s);
            System.out.println(pieChartData.toString());
        }

        // Create the PieChart and set the data
        PieChart pieChart = new PieChart(pieChartData);

        // Set the title of the PieChart
        pieChart.setTitle("Les Categories en fonctions d'offres");

        // Create a StackPane to hold the PieChart
        StackPane root = new StackPane(pieChart);

        // Create a Scene and add the StackPane to it
        Scene scene = new Scene(root, 600, 400);

        // Set the title of the Stage and add the Scene to it
        stage.setTitle("Dynamic PieChart Example");
        stage.setScene(scene);

        // Show the Stage
        stage.show();

        // Update the PieChart data dynamically
        updatePieChartData();
    }

    private void updatePieChartData() {
        // Create a new thread to update the PieChart data every second
        Thread thread = new Thread(() -> {

            while (true) {
                try {
                    // Wait for one second
                    Thread.sleep(1000);

                    OffreService os = new OffreService();
                    List<Offre> o;
                    o = os.recuperer();

                    for (int j = 0; j > pieChartData.size(); j++) {
                        for (int i = 0; i > o.size(); i++) {
                           
                            if (o.get(i).getCatOffreId() == pieChartData.get(j).getName()) {
                                double Type = pieChartData.get(j).getPieValue() + 10;
                                pieChartData.get(j).setPieValue(Type);

                               

                        }
                    }
                }
            }   catch (InterruptedException ex) {
                    Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
                }}
        }); thread.setDaemon(true);
                                thread.start();
                     
    }
    public static void main(String[] args) {
        launch(args);
    }
}
