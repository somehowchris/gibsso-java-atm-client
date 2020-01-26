import ch.bbzsogr.bi.controllers.DatabaseController;
import ch.bbzsogr.bi.exceptions.*;
import ch.bbzsogr.bi.interfaces.services.CardServiceInterface;
import ch.bbzsogr.bi.interfaces.services.PeopleServiceInterface;
import ch.bbzsogr.bi.models.Account;
import ch.bbzsogr.bi.models.Card;
import ch.bbzsogr.bi.models.Person;
import ch.bbzsogr.bi.models.enums.ApiType;
import ch.bbzsogr.bi.services.AccountService;
import ch.bbzsogr.bi.services.CardService;
import ch.bbzsogr.bi.services.PeopleService;
import ch.bbzsogr.bi.utils.Container;
import ch.bbzsogr.bi.utils.SystemUtil;
import com.google.common.collect.Lists;
import services.CardReader;
import services.NumberPadService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author daviddaniel.dubach
 */
public class Bancomat extends javax.swing.JFrame {

  CardReader cardReader = new CardReader();
  NumberPadService numberPadService = new NumberPadService();
  DatabaseController db;
  HashMap<File, Person> cards = new HashMap<>();
  Person selected;
  Account account;
  state currentState = state.SELECTED;
  CardServiceInterface cardService;

  int timesPinWrong = 0;

  // Variables declaration - do not modify
  private javax.swing.JButton btnCancel;
  private javax.swing.JButton btnClear;
  private javax.swing.JButton btnEight;
  private javax.swing.JButton btnFive;
  private javax.swing.JButton btnFour;
  private javax.swing.JButton btnNine;
  private javax.swing.JButton btnOk;
  private javax.swing.JButton btnOne;
  private javax.swing.JButton btnSeven;
  private javax.swing.JButton btnSix;
  private javax.swing.JButton btnThree;
  private javax.swing.JButton btnTwo;
  private javax.swing.JButton btnZero;
  private javax.swing.JComboBox<String> cardDropdown;
  private javax.swing.Box.Filler filler1;
  private javax.swing.Box.Filler filler2;
  private javax.swing.JButton functionBtnFour;
  private javax.swing.JButton functionBtnOne;
  private javax.swing.JButton functionBtnThree;
  private javax.swing.JButton functionBtnTwo;
  private javax.swing.JLabel label2;
  private javax.swing.JLabel label3;
  private javax.swing.JLabel label4;
  private javax.swing.JLabel label1;
  private javax.swing.JLabel labelUserInput;

  /**
   * Creates new form NewJFrame
   */
  public Bancomat() throws Exception {
    cards.putAll(cardReader.scanDirectory(SystemUtil.getHomeDirectory()));
    cards.putAll(cardReader.scanDirectory(SystemUtil.getWorkingDirectory()));
    cards.putAll(cardReader.scanDirectory("./Cards"));
    // TODO check your config
    try {
      db =  new DatabaseController();
      db.seed();
    } catch (OGMDatabaseTypeNotFoundException e) {
      e.printStackTrace();
    } catch (UrlDialectNotSupportedException e) {
      e.printStackTrace();
    } catch (AccessNotGrantedException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ConnectionRefusedException e) {
      e.printStackTrace();
    } catch (OGMNotYetSupportedException e) {
      e.printStackTrace();
    }
    cardService = Container.getService(CardServiceInterface.class, ApiType.DIRECT);
    cards.put(new File("Cards/Cards2.txt"), Container.getService(PeopleServiceInterface.class, ApiType.DIRECT).getPerson("402882026fe3945b016fe3946a0a0000"));
    initComponents();
    //134597
  }

  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
    btnOne = new javax.swing.JButton();
    btnThree = new javax.swing.JButton();
    btnFour = new javax.swing.JButton();
    btnFive = new javax.swing.JButton();
    btnSix = new javax.swing.JButton();
    btnSeven = new javax.swing.JButton();
    btnEight = new javax.swing.JButton();
    btnZero = new javax.swing.JButton();
    btnCancel = new javax.swing.JButton();
    btnClear = new javax.swing.JButton();
    btnOk = new javax.swing.JButton();
    functionBtnOne = new javax.swing.JButton();
    functionBtnTwo = new javax.swing.JButton();
    functionBtnThree = new javax.swing.JButton();
    functionBtnFour = new javax.swing.JButton();
    label1 = new javax.swing.JLabel();
    label2 = new javax.swing.JLabel();
    label3 = new javax.swing.JLabel();
    cardDropdown = new javax.swing.JComboBox<>();
    label4 = new javax.swing.JLabel();
    filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
    labelUserInput = new javax.swing.JLabel();
    btnTwo = new javax.swing.JButton();
    btnNine = new javax.swing.JButton();

    labelUserInput.setText("Choose a card from the Dropdown or open a new one");
    label1.setVisible(false);
    label2.setVisible(false);
    label3.setVisible(false);
    label4.setVisible(false);

    setNumPadEnabled(false);


    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        addNumber(((JButton) e.getSource()).getText());
      }
    };

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Bancomat");
    setBounds(new java.awt.Rectangle(900, 320, 0, 0));
    setResizable(false);

    btnOne.setText("1");

    btnOne.addActionListener(actionListener);

    btnThree.setText("3");
    btnThree.addActionListener(actionListener);

    btnFour.setText("4");
    btnFour.addActionListener(actionListener);

    btnFive.setText("5");
    btnFive.addActionListener(actionListener);

    btnSix.setText("6");
    btnSix.addActionListener(actionListener);

    btnSeven.setText("7");
    btnSeven.addActionListener(actionListener);

    btnEight.setText("8");
    btnEight.addActionListener(actionListener);

    btnZero.setText("0");
    btnZero.addActionListener(actionListener);

    btnCancel.setBackground(new java.awt.Color(255, 0, 51));
    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelActionPerformed(evt);
      }
    });

    functionBtnTwo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(currentState == state.OVERVIEW){
          labelUserInput.setText("Your current balance is "+account.getBalance()+" CHF");
        }
      }
    });


    btnClear.setBackground(new java.awt.Color(255, 204, 0));
    btnClear.setText("Clear");
    btnClear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        numberPadService.reset();
        if (currentState == state.SELECTED) {
          labelUserInput.setText("Pin:");
        }
      }
    });

    btnOk.setBackground(new java.awt.Color(0, 204, 0));
    btnOk.setText("OK");
    btnOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
       if(currentState == state.SELECTED){
         Card card = selected.getAccounts().get(0).getCards().get(0);
         try {
           card = cardService.authenticate(card.getCardNumber(), numberPadService.toString());
           selected = card.getAccount().getPerson();
           account = card.getAccount();
           labelUserInput.setText("Please choose your action");
           label1.setVisible(true);
           label2.setVisible(true);
           label3.setVisible(true);
           label4.setVisible(true);
           currentState = state.OVERVIEW;
         } catch (Exception e) {
           e.printStackTrace();
           timesPinWrong += 1;
           btnClear.doClick();
           if(timesPinWrong == 3){
             try {
               cardService.lockCard(card.getCardNumber());
             } catch (CardLockException ex) {
               ex.printStackTrace();
             } catch (Exception ex) {
               System.out.println("Card doesn't exist");
             } finally {
               File f = (File) cards.keySet().toArray()[cardDropdown.getSelectedIndex()-1];
               f.delete();
               cards.remove(cards.get(f));
               cardDropdown.removeItemAt(cardDropdown.getSelectedIndex());
               btnClear.doClick();
               currentState = state.SELECTED;
             }
           }
         }
       }
      }
    });


    functionBtnOne.setText("-");

    functionBtnTwo.setText("-");

    functionBtnThree.setText("-");

    functionBtnFour.setText("-");

    label1.setText("Withdraw money");

    label2.setText("Query balance");

    label3.setText("Change pincode");

    cardDropdown.addItem("");
    cards.forEach((k,v) -> {
      if (v != null && v.getAccounts().size() >= 1) cardDropdown.addItem(v.getAccounts().get(0).getIban());
    });

    cardDropdown.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        numberPadService.reset();
        setNumPadEnabled(cardDropdown.getSelectedIndex() != 0);
        labelUserInput.setText(cardDropdown.getSelectedIndex() == 0 ? "Choose a card from the Dropdown or open a new one" : "Pin:");
        selected = cardDropdown.getSelectedIndex() != 0 ? (Person) cards.values().toArray()[cardDropdown.getSelectedIndex() - 1] : null;
        timesPinWrong = 0;
      }
    });

    label4.setText("");

    btnTwo.setText("2");
    btnTwo.addActionListener(actionListener);

    btnNine.setText("9");
    btnNine.addActionListener(actionListener);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap()
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(cardDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(68, 68, 68)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnOne)
                .addGroup(layout.createSequentialGroup()
                  .addComponent(btnFour)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                      .addComponent(btnTwo)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(btnThree))
                    .addGroup(layout.createSequentialGroup()
                      .addComponent(btnFive)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(btnSix))))
                .addGroup(layout.createSequentialGroup()
                  .addComponent(btnSeven)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnZero)
                    .addGroup(layout.createSequentialGroup()
                      .addComponent(btnEight)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(btnNine)))))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(functionBtnTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(functionBtnOne))
              .addGap(23, 23, 23)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(label1)
                .addComponent(label2))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(label3)
                .addComponent(label4))
              .addGap(9, 9, 9)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(functionBtnThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(functionBtnFour)))))
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(btnCancel)
              .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(labelUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addContainerGap(93, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(16, 16, 16)
          .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(functionBtnOne, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(label1)
            .addComponent(functionBtnThree, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(label3))
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(labelUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(functionBtnTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(functionBtnFour, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(label4))
            .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING))
          .addGap(22, 22, 22)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
              .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
              .addGap(5, 5, 5)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnThree, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnOne, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnFour, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnFive, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSix, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSeven, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnEight, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnNine, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(89, 89, 89))
    );

    pack();
  }// </editor-fold>

  private void cardDropdownActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO screen "Please enter your pin"
    numberPadService.reset();
  }

  private void addNumber(String number) {
    numberPadService.append(number);
    labelUserInput.setText(labelUserInput.getText() + "*");
  }

  public void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
    cardDropdown.setSelectedIndex(0);
  }
  // End of variables declaration

  public void setNumPadEnabled(boolean state) {
    btnOne.setEnabled(state);
    btnTwo.setEnabled(state);
    btnThree.setEnabled(state);
    btnFour.setEnabled(state);
    btnFive.setEnabled(state);
    btnSix.setEnabled(state);
    btnSeven.setEnabled(state);
    btnEight.setEnabled(state);
    btnNine.setEnabled(state);
    btnZero.setEnabled(state);
    btnOk.setEnabled(state);
    btnCancel.setEnabled(state);
    btnClear.setEnabled(state);
  }
}
