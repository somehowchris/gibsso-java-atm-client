/**
 * @author daviddaniel.dubach
 */
public class WithdrawedMoney extends javax.swing.JFrame {

    /**
     * Creates new form WithdrawedMoney
     */
    public WithdrawedMoney() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        withdrawedAmountText10 = new javax.swing.JLabel();
        withdrawedAmountText20 = new javax.swing.JLabel();
        withdrawedAmountText50 = new javax.swing.JLabel();
        withdrawedAmountText100 = new javax.swing.JLabel();
        withdrawedAmountText200 = new javax.swing.JLabel();
        withdrawedAmountText1000 = new javax.swing.JLabel();
        withdrawedAmountValue10 = new javax.swing.JLabel();
        withdrawedAmountValue20 = new javax.swing.JLabel();
        withdrawedAmountValue50 = new javax.swing.JLabel();
        withdrawedAmountValue100 = new javax.swing.JLabel();
        withdrawedAmountValue200 = new javax.swing.JLabel();
        withdrawedAmountValue1000 = new javax.swing.JLabel();
        btnCloseWithdrawedMoney = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Withdrawed money");
        setBounds(new java.awt.Rectangle(900, 320, 0, 0));

        withdrawedAmountText10.setText("10 CHF:");

        withdrawedAmountText20.setText("20 CHF:");

        withdrawedAmountText50.setText("50 CHF:");

        withdrawedAmountText100.setText("100 CHF:");

        withdrawedAmountText200.setText("200 CHF:");

        withdrawedAmountText1000.setText("1000 CHF:");

        withdrawedAmountValue10.setText("jLabel1");

        withdrawedAmountValue20.setText("jLabel1");

        withdrawedAmountValue50.setText("jLabel1");

        withdrawedAmountValue100.setText("jLabel1");

        withdrawedAmountValue200.setText("jLabel1");

        withdrawedAmountValue1000.setText("jLabel1");

        btnCloseWithdrawedMoney.setText("Close");
        btnCloseWithdrawedMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseWithdrawedMoneyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(withdrawedAmountText10)
                                        .addComponent(withdrawedAmountText20)
                                        .addComponent(withdrawedAmountText50)
                                        .addComponent(withdrawedAmountText100)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(withdrawedAmountText1000)
                                                .addComponent(withdrawedAmountText200, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCloseWithdrawedMoney)
                                        .addComponent(withdrawedAmountValue10)
                                        .addComponent(withdrawedAmountValue20)
                                        .addComponent(withdrawedAmountValue50)
                                        .addComponent(withdrawedAmountValue100)
                                        .addComponent(withdrawedAmountValue200)
                                        .addComponent(withdrawedAmountValue1000))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(withdrawedAmountText10)
                                        .addComponent(withdrawedAmountValue10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(withdrawedAmountText20)
                                        .addComponent(withdrawedAmountValue20))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(withdrawedAmountText50)
                                        .addComponent(withdrawedAmountValue50))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(withdrawedAmountText100)
                                        .addComponent(withdrawedAmountValue100))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(withdrawedAmountText200)
                                        .addComponent(withdrawedAmountValue200))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(withdrawedAmountText1000)
                                        .addComponent(withdrawedAmountValue1000))
                                .addGap(18, 18, 18)
                                .addComponent(btnCloseWithdrawedMoney)
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnCloseWithdrawedMoneyActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnCloseWithdrawedMoney;
    private javax.swing.JLabel withdrawedAmountText10;
    private javax.swing.JLabel withdrawedAmountText100;
    private javax.swing.JLabel withdrawedAmountText1000;
    private javax.swing.JLabel withdrawedAmountText20;
    private javax.swing.JLabel withdrawedAmountText200;
    private javax.swing.JLabel withdrawedAmountText50;
    private javax.swing.JLabel withdrawedAmountValue10;
    private javax.swing.JLabel withdrawedAmountValue100;
    private javax.swing.JLabel withdrawedAmountValue1000;
    private javax.swing.JLabel withdrawedAmountValue20;
    private javax.swing.JLabel withdrawedAmountValue200;
    private javax.swing.JLabel withdrawedAmountValue50;
    // End of variables declaration
}
