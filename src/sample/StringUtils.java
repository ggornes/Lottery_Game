package sample;

/* String Utility methods to be tested using JUnit5
 * Source: https://github.com/howtoprogram/junit5-examples
 */
public class StringUtils {

    public static Double convertToDouble(String str) {

        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }


    // my string utility
    public static Integer convertToInt(String str) {

        if (str == null) {
            return null;
        }
        return Integer.valueOf(str);
    }


    public static boolean isNullOrBlank(String st) {

        return st == null || st.trim().length() == 0;

    }


    public static String getDefaultIfNull(final String st, final String defaultSt) {

        return st == null ? defaultSt : st;

    }


    public static String concat(String... sts) {

        String retVal = null;

        if (sts != null && sts.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String st : sts) {
                if (st != null) {
                    sb.append(st);
                }
            }
            retVal = sb.toString();
        }

        return retVal;

    }


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
}
