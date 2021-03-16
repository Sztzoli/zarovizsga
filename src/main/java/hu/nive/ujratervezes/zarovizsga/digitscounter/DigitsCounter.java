package hu.nive.ujratervezes.zarovizsga.digitscounter;

public class DigitsCounter {

    public int getCountOfDigits(String text) {
        if (text==null || text.isBlank()) {
            return 0;
        }
        return (int) text.chars().
                filter(x -> x>47 && x<58)
                .distinct()
                .count();
    }
}
