public class Formatter {
    public String formatAmount(double amount) {
        int intValue = (int) amount;
        String rublesWordForm;

        if (amount - intValue == 0) {
            rublesWordForm = getRublesWordForm(intValue);
            return intValue + " " + rublesWordForm;
        } else {
            rublesWordForm = getRublesWordForm(intValue);
            return String.format("%.2f", amount) + " " + rublesWordForm;
        }
    }

    private String getRublesWordForm(int rubles) {
        if (rubles % 10 == 1 && rubles % 100 != 11) {
            return "рубль";
        } else if ((rubles % 10 >= 2 && rubles % 10 <= 4) && (rubles % 100 < 10 || rubles % 100 >= 20)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}

