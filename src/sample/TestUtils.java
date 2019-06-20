package sample;

import java.util.Arrays;

/* String Utility methods to be tested using JUnit4
 */
public class TestUtils {




    public static boolean validateNumbers(String txtNum[]) {
        boolean val = false;
        for (int i = 0; i < txtNum.length; i++) {
            int numConverted;

            try {
                numConverted = Integer.parseInt(txtNum[i]);

                if (numConverted > 0 && numConverted <= 99) {
                    //userNumbers[i] = numConverted;
                    val = true;
                } else {
                    /*javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR,
                            "Please enter a value between 1 and 99");
                    a.showAndWait();*/
                    val = false;
                    break;
                }

            } catch(Exception nfe) {
                /*javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR,
                        "Invalid Numeric value entered");
                a.showAndWait();*/
                val = false; // set value to false if at least one of the input boxes is not valid
                break;
            }
        } return val;
    }


    public static boolean duplicateNumbers(int [] pnumbers) {

        for (int i = 0; i < pnumbers.length-1; i++) {
            if (pnumbers[i] == pnumbers[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static int lotteryResult(int [] uNumbers, int [] winningNumbers) {
        int result = 0;
        int counter = 0;

        for (int i=0; i<uNumbers.length;i++) {

            result = Arrays.binarySearch(winningNumbers, uNumbers[i]);
            System.out.println(result);
            if (result > -1) {
                counter++;
            }
        }
        return counter;

    }



}
