import javax.swing.*;
import java.util.ArrayList;

public class CardReader {
    public boolean readCard(JComboBox dropDown, ArrayList<String> userInput) {
        String selectedCard = String.valueOf(dropDown.getSelectedItem());
        String pinCode = "";
        if (selectedCard.length() > 6) {
            pinCode = selectedCard.substring(selectedCard.length() - 6);
        } else {
            selectedCard = pinCode;
        }
        if (userInput.equals(pinCode)) {
            return true;
        } else {
            return false;
        }
    }

    public void ejectCard() {

    }

    public void collectCard() {

    }
}
