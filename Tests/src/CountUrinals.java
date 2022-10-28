public class CountUrinals {

    String str = null;
    int number;

    CountUrinals(String st){
        this.str = st;
    }

    public int countUrinals(){
        try {
            number = Integer.parseInt(str);
            int count = 0;

            // Number can be valid or invalid
            // If number is valid, print and display the message and number
            for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '0') {
                        if ((j - 1 >= 0 && str.charAt(j - 1) == '0') && (j + 1 < str.length() && str.charAt(j + 1) == '0')) {
                            count += 1;
                        }
                    } else {
                        if ((j - 1 >= 0 && str.charAt(j - 1) == '1') || (j + 1 < str.length() && str.charAt(j + 1) == '1')) {
                            count = -1;
                            break;
                        }
                    }
                }
            return count;
        }

        // Catch block to handle NumberFormatException
        catch (NumberFormatException e) {

            // Print the message if exception occurred
            System.out.println("NumberFormatException occurred");
        }
        return 0;
    }
}