package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable {

    String [] txtUserNumbers = new String[7];
    int [] userNumbers = new int[7];
    int [] winningNumbers = new int[7];
    //int [] temp = new int [userNumbers.length];
    int min = 1;
    int max = 99;
    int range = max - min + 1;

    @FXML
    private Label label1;
    @FXML
    private Label lblUserNumbers;
    @FXML
    private Label lblWinningNumbers;
    @FXML
    private Label lblPrizeResult;
    @FXML
    private TextField txtNum0;
    @FXML
    private TextField txtNum1;
    @FXML
    private TextField txtNum2;
    @FXML
    private TextField txtNum3;
    @FXML
    private TextField txtNum4;
    @FXML
    private TextField txtNum5;
    @FXML
    private TextField txtNum6;
    @FXML
    private Label lblPrizeMsg;
    @FXML
    private Button btnPrint;
    @FXML
    private Button btnRevealWinNum;


    /**
     * Method to read user numbers from text boxes.
     * @return String array with values from text boxes.
     */
    public String[] readUserNumbers() {
        String txtNum[] = new String [7];
        //String strNum0 = txtNum0.getText();
        //String strNum1 = txtNum1.getText();
        txtNum[0] = txtNum0.getText();
        txtNum[1] = txtNum1.getText();
        txtNum[2] = txtNum2.getText();
        txtNum[3] = txtNum3.getText();
        txtNum[4] = txtNum4.getText();
        txtNum[5] = txtNum5.getText();
        txtNum[6] = txtNum6.getText();

        return txtNum;
    }

    public void displayErrorMsg (String msg) {
        javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR,
                msg);
        a.showAndWait();
    }

    /**
     * Method to validate user's input numbers.
     * @param txtNum Array of string numbers read from txt boxes.
     * @return returns boolean variable true if number is valid (integer > 0 and <= 99).
     */
    public boolean validateNumbers(String txtNum[]) {
        boolean val = false;
        for (int i = 0; i < txtNum.length; i++) {
            int numConverted;

            try {
                numConverted = Integer.parseInt(txtNum[i]);

                if (numConverted > 0 && numConverted <= 99) {
                    userNumbers[i] = numConverted;
                    val = true;
                } else {
                    /*javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR,
                            "Please enter a value between 1 and 99");
                    a.showAndWait();*/
                    val = false;
                    break;
                }


            } catch(NumberFormatException nfe) {
                /*javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR,
                        "Invalid Numeric value entered");
                a.showAndWait();*/
                val = false; // set value to false if at least one of the input boxes is not valid
                break;
            }
        }

        return val;
    }
    /**
     * This method takes the user numbers array as an input and returns
     * the same numbers as a string to show on a label
     * @param uNumbers user input numbers
     * @return the user numbers in a string variable
     */
    public String displayNumbers(int [] uNumbers) {
        String userNumbersText = "";
        for (int i=0; i < uNumbers.length; i++) {
            userNumbersText+= (String) Integer.toString(uNumbers[i]);
            userNumbersText+= " ";
        }
        return userNumbersText;

    }

    /**
     * Read winning numbers from file. If file does not exist then we generate random numbers
     * @return array of random numbers.
     */
    public int[] readFileNumbers() {
        int index = 0;
        int [] winningNumbers2 = new int[7];
        try {
            Scanner sc = new Scanner(new FileReader("numbers.txt"));
            while (sc.hasNext()) {
                winningNumbers2[index] = sc.nextInt();
                index++;
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found. Generating random winning numbers");
            winningNumbers2 = generateWinningNumbers(); // calls generateWinningNumbers()
        }

        return winningNumbers2;
    }

    /**
     * Method to generate random winning numbers with no duplicates (executed if no txt file was found).
     * @return
     */
    public int[] generateWinningNumbers() {
        int [] winningNumbers2 = new int[7];
        for (int i = 0; i<=6; i++) {
            winningNumbers2[i] = (int) (Math.random() * range + min);
            //System.out.println(winningNumbers[i]);

        }
        winningNumbers2 = prepareNumbers(winningNumbers2); //remove duplicates
        return winningNumbers2;
    }


    /**
     * Method to sort array and replace duplicates with random numbers
     * @param pnumbers
     * @return
     */
    public int[] prepareNumbers(int [] pnumbers) {

        Arrays.sort(pnumbers);
        boolean duplicate;

        duplicate = duplicateNumbers(pnumbers); //true if there are no duplicates

        while (duplicate == true) { // this process repeats until there are no more duplicates
            for (int i = 0; i < pnumbers.length-1; i++) {
                if(pnumbers[i] == pnumbers[i+1]) {
                    pnumbers[i+1] = (int) (Math.random() * range + min);
                }
            }

            Arrays.sort(pnumbers);
            duplicate = duplicateNumbers(pnumbers);
        }

        return pnumbers; //array with no duplicates
    }


    /**
     * Method to look for duplicates in an array. Returns true if no duplicates or false if there are duplicates.
     * To check duplicates, it is necessary to work on a sorted array. Then we know if there is a duplicated value
     * if the value at index 'i' is the same than the value at the next number "i + 1" because is sorted.
     * @param pnumbers array with the user selected numbers.
     * @return
     */
    public boolean duplicateNumbers(int [] pnumbers) {

        for (int i = 0; i < pnumbers.length-1; i++) {
            if (pnumbers[i] == pnumbers[i+1]) {
                return true;
            }
        }
        return false;
    }

    public void lotteryResult(int [] uNumbers) {
        int result = 0;
        int counter = 0;

        for (int i=0; i<uNumbers.length;i++) {

            result = Arrays.binarySearch(winningNumbers, uNumbers[i]);
            System.out.println(result);
            if (result > -1) {
                counter++;
            }
        }
        System.out.println("You have " + counter + " matches");
        lblPrizeResult.setText("You have " + counter + " matches");

    }

    /**
     * Method to save the user numbers to a txt file when the program is closed.
     * @param uNumbers
     * @throws FileNotFoundException
     */
    public void writeUserNumbers(int [] uNumbers) throws FileNotFoundException {
        File file = new File ("numbers.txt");
        PrintWriter printWriter = new PrintWriter ("numbers.txt");

        String myNumbers = "";
        for (int i = 0; i<= uNumbers.length-1; i++) {
            myNumbers += Integer.toString(uNumbers[i]);
            myNumbers += " ";
        }
        System.out.println(myNumbers);
        printWriter.println (myNumbers);
        printWriter.close ();
    }


    /**
     * Event executed on button click
     * @param event
     * @throws FileNotFoundException
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws FileNotFoundException {
        lblPrizeResult.setText(""); // Clear result label text
        Arrays.sort(winningNumbers);
        txtUserNumbers = readUserNumbers();

        boolean validation = validateNumbers(txtUserNumbers);
        if (validation){
            prepareNumbers(userNumbers);
            lblUserNumbers.setText(displayNumbers(userNumbers));
            writeUserNumbers(userNumbers);
            lotteryResult(userNumbers);
        } else {
            displayErrorMsg("Please enter a valid number between 1 and 99");
        }
    }


    @FXML
    private void toggleNumbers(ActionEvent event) {

        lblWinningNumbers.setText(displayNumbers(winningNumbers));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        winningNumbers = readFileNumbers();
    }


}

