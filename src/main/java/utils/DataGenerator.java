package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DataGenerator {

    private DataGenerator() {

    }


    public static String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }


    public static String getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, (int) (Math.round(364 * Math.random()) + 1));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(calendar.getTime());
    }


    public static String getPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -(int) (Math.round(364 * Math.random()) + 1));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(calendar.getTime());
    }


    public static int getRandomIntegerInRange(int min, int max) {
        return (int) (Math.round((max - min) * Math.random()) + min);
    }


    public static int getRandomIntegerInRange(int value) {
        return getRandomIntegerInRange(0, value);
    }


    public static long getRandomLongInRange(long min, long max) {
        return Math.round((max - min) * Math.random()) + min;
    }


    public static long getRandomLongInRange(long value) {
        return getRandomLongInRange(0, value);
    }


    public static double getRandomDoubleInRange(double min, double max, int... decimalPlaces) {
        assert decimalPlaces.length <= 1;
        double random = (max - min) * Math.random() + min;

        if (decimalPlaces.length > 0) {
            double roundingParameter = Math.pow(10, decimalPlaces[0]);
            return Math.round(roundingParameter * random) / roundingParameter;
        } else
            return random;
    }


    public static double getRandomDoubleInRange(double value, int... decimalPlaces) {
        assert decimalPlaces.length <= 1;
        if (decimalPlaces.length > 0)
            return getRandomDoubleInRange(0., value, decimalPlaces);
        else
            return getRandomDoubleInRange(0., value);
    }


    public static boolean getRandomBoolean() {
        return Math.random() >= 0.5;
    }


    public static String getRandomString(int size, boolean useLatin, boolean useFrench, boolean useNumbers, boolean useSpecial) {
        String prototype = "";
        if (useLatin)
            prototype += "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        if (useFrench)
            prototype += "ÉÂÊÎÔÛÀÈÙËÏÜŸÇ" + "éâêîôûàèùëïüÿç";
        if (useNumbers)
            prototype += "0123456789";
        if (useSpecial)
            prototype += "!@#$%^&*()_+-='<>/|[]{};:~`\\\"";

        StringBuilder stringBuffer = new StringBuilder(size);
        for (int index = 0; index < size; index++) {
            int charIndex = (int) (prototype.length() * Math.random());
            char character = prototype.charAt(charIndex);
            if (index == 0 && character == '0') {
                index--;
                continue;
            }
            stringBuffer.append(character);
        }
        return stringBuffer.toString();
    }


    public static String getRandomCanadaPostalCode() {
        String firstCharacters = "ABCEGHJKLMNPRSTVXY";
        String numbers = "0123456789";
        String middleCharacters = "ABCEGHJKLMNPRSTVWXYZ";

        StringBuilder stringBuffer = new StringBuilder(6);
        for (int index = 1; index < 7; index++) {
            if (index == 1) {
                int charIndex = (int) (firstCharacters.length() * Math.random());
                stringBuffer.append(firstCharacters.charAt(charIndex));
            } else {
                if (index % 2 == 0) {
                    int charIndex = (int) (numbers.length() * Math.random());
                    stringBuffer.append(numbers.charAt(charIndex));
                } else {
                    int charIndex = (int) (middleCharacters.length() * Math.random());
                    stringBuffer.append(middleCharacters.charAt(charIndex));
                }
            }
        }
        return stringBuffer.insert(3, " ").toString();
    }


    public static String getRandomString(String label) {
        boolean useLatin = false;
        if (label.toLowerCase().contains("english"))
            useLatin = true;
        boolean useFrench = false;
        if (label.toLowerCase().contains("french"))
            useFrench = true;
        boolean useNumbers = false;
        if (label.toLowerCase().contains("number"))
            useNumbers = true;
        boolean useSpecial = false;
        if (label.toLowerCase().contains("special"))
            useSpecial = true;
        boolean increaseSize = false;
        if (label.toLowerCase().contains("+"))
            increaseSize = true;
        int size = Integer.parseInt(label.replaceAll("[A-Za-z+]", ""));
        if (increaseSize)
            size++;
        return getRandomString(size, useLatin, useFrench, useNumbers, useSpecial);
    }


    public static String getRandomEmail() {
        return (getRandomString(1, true, false, false, false) +
                getRandomString(10, true, false, true, false) + "@" +
                getRandomString(5, true, false, false, false) + "." +
                getRandomString(2, true, false, false, false)).toLowerCase();
    }



    public static Object getValue(String valueLabel) {
        if (valueLabel.equals("NULL")) return null;
        else if (valueLabel.equals("EMPTY")) return "";
        else if (valueLabel.equals("SPACE")) return " ";
        else if (valueLabel.equals("SPACE_X5")) return "     ";
        else if (valueLabel.equals("HTML")) return "<input type=\"text\" value=\"Wake up, Neo...\">";
        else if (valueLabel.equals("BOOLEAN")) return getRandomBoolean();
        else if (valueLabel.equals("INTEGER")) return getRandomIntegerInRange(50, 10000);
        else if (valueLabel.equals("DOUBLE")) return getRandomDoubleInRange(10000d, 2);
        else if (valueLabel.equals("LONG")) return getRandomLongInRange(2200000000L, 9999999999L);
        else if (valueLabel.equals("NEGATIVE")) return -1 * getRandomIntegerInRange(100);
        else if (valueLabel.equals("CURRENT_DATE")) return getCurrentDate();
        else if (valueLabel.equals("FUTURE_DATE")) return getFutureDate();
        else if (valueLabel.equals("PAST_DATE")) return getPastDate();
        else if (valueLabel.equals("RANDOM_EMAIL")) return getRandomEmail();
        else if (valueLabel.contains("any")) return getRandomString(valueLabel);
        else throw new RuntimeException("\nYou are trying to use non-recognized label.\nPlease, check 'getValue' method in DataGenerator class.");
    }
}
