package gui;

import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class CaptchaController {

    @FXML
    private WebView webView;

    private static final String SITE_KEY = "6Lf2eNwkAAAAAOt01Emw26bCJWDn_z604_ykK4eH";
    private static final String SECRET_KEY = "6Lf2eNwkAAAAAKoltk8pHUXvr0lIdXKnDrc4usSa";

    private void initialize() {
        // Load the reCAPTCHA widget with your site key included
        webView.getEngine().load("https://www.google.com/recaptcha/api.js?onload=initialize&render=explicit");

        // Add a JavaScript interface to handle the reCAPTCHA callback
        webView.getEngine().getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (Worker.State.SUCCEEDED.equals(newValue)) {
                JSObject window = (JSObject) webView.getEngine().executeScript("window");
                window.setMember("app", this);
                webView.getEngine().executeScript("function initialize() { grecaptcha.render('captcha', { sitekey: '" + SITE_KEY + "', callback: app.verifyCallback }); }");
            }
        });
    }

    // Callback function for reCAPTCHA verification
    public void verifyCallback(String response) {
        // Send a request to the Google reCAPTCHA API to verify the response
        try {
            String url = "https://www.google.com/recaptcha/api/siteverify?secret=" + SECRET_KEY + "&response=" + URLEncoder.encode(response, "UTF-8");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                reader.close();

                // Parse the response JSON and extract the "success" field
                boolean success = responseBuilder.toString().contains("\"success\": true");
                if (success) {
                    // Allow the user to proceed
                    System.out.println("reCAPTCHA verification successful");
                } else {
                    // Display an error message indicating that the user failed the reCAPTCHA challenge
                    Alert alert = new Alert(AlertType.ERROR, "You failed the reCAPTCHA challenge. Please try again.");
                    alert.showAndWait();
                }
            } else {
                // Handle HTTP error
                Alert alert = new Alert(AlertType.ERROR, "An error occurred while verifying the reCAPTCHA challenge.");
                alert.showAndWait();
            }
        } catch (IOException e) {
            // Handle exception
            Alert alert = new Alert(AlertType.ERROR, "An error occurred while verifying the reCAPTCHA challenge.");
            alert.showAndWait();
        }
    }
}
