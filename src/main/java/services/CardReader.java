package services;

import ch.bbzsogr.bi.models.Account;
import ch.bbzsogr.bi.models.Card;
import ch.bbzsogr.bi.models.Person;
import ch.bbzsogr.bi.utils.SystemUtil;
import com.google.common.collect.Lists;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    public Person readCard(File file) throws IOException {
      List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
      String line = lines.get(0);

      if(line.length()<116+5) return null;

      String name = line.substring(0, 18);
      String firstName = line.substring(19, 31);
      String iban = line.substring(57, 81);
      String cardNr = line.substring(107, 114);

      Person person = new Person();
      person.setFirstName(firstName);
      person.setLastName(name);

      Account account = new Account();
      account.setIban(iban);

      Card card = new Card();
      card.setCardNumber(cardNr);

      account.setCards(Lists.newArrayList(card));
      person.setAccounts(Lists.newArrayList(account));

      return person;
    }

    public HashMap<File, Person> scanDirectory(String dir){
      File directory = new File(dir);

      if(directory.isFile()) return new HashMap<>();
      if(!directory.canRead()) return new HashMap<>();

      FilenameFilter filenameFilter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
          return name.toLowerCase().endsWith(".card");
        }
      };

      HashMap hashMap = new HashMap();

      Lists.newArrayList(directory.listFiles(filenameFilter)).forEach(el -> {
        try {
          hashMap.put(el, readCard(el));
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      return hashMap;
    }

    public void ejectCard() {

    }

    public void collectCard() {

    }
}
