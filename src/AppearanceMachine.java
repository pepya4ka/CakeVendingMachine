import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;

public class AppearanceMachine implements ActionListener {

    private static JFrame jFrame;


    private JPanel jPanelForMachine;
    JLabel jLabelForMachine1;
    JLabel jLabelAmounNewspaper1;
    JLabel jLabelAmountOperation1;
    JLabel amountPromotional1;
    JLabel amountEntertaining1;
    JLabel amountDaily1;
    JLabel amountWeekly1;
    JLabel income1;
    static JTextArea jTextAreaForMachine1;

    JLabel jLabelForMachine2;
    JLabel jLabelAmounNewspaper2;
    JLabel jLabelAmountOperation2;
    JLabel amountPromotional2;
    JLabel amountEntertaining2;
    JLabel amountDaily2;
    JLabel amountWeekly2;
    JLabel income2;
    static JTextArea jTextAreaForMachine2;

    JLabel jLabelForMachine3;
    JLabel jLabelAmounNewspaper3;
    JLabel jLabelAmountOperation3;
    JLabel amountPromotional3;
    JLabel amountEntertaining3;
    JLabel amountDaily3;
    JLabel amountWeekly3;
    JLabel income3;
    static JTextArea jTextAreaForMachine3;

    private JPanel jPanelForButton;
    static JButton jButtonTechnicalSupportForMachine1;//кнопка вызова технической поддержки
    static JButton jButtonTechnicalSupportForMachine2;//кнопка вызова технической поддержки
    static JButton jButtonTechnicalSupportForMachine3;//кнопка вызова технической поддержки
    static JButton jButtonFillMachine;//кнопка наполнения газетами автомат
    static JButton jButtonFillDailyNewspaper;//кнопка наполнения ежедневными газетами

    private JPanel jPanelForButtonBeginAndEnd;

    static JButton jButtonBeginAndEnd;//кнопка начать/закончить
    public static JLabel jLabelForTime;
    private static Timer timer;
    private static MyTimerTask myTimerTask;

    static Runnable textArea1;
    static Thread thread1;
    static Runnable textArea2;
    static Thread thread2;
    static Runnable textArea3;
    static Thread thread3;


    static boolean fl = false;//работа программы, по умолчанию - не работает
    static boolean runMachine1 = true;//работа машины
    static boolean runMachine2 = true;//работа машины
    static boolean runMachine3 = true;//работа машины

    static boolean buttonTechnicalSupport1 = false;//по умолчанию не активна, пока не потребуется тех.поддержка
    static boolean buttonTechnicalSupport2 = false;//по умолчанию не активна, пока не потребуется тех.поддержка
    static boolean buttonTechnicalSupport3 = false;//по умолчанию не активна, пока не потребуется тех.поддержка

    static NewspaperMachine newspaperMachine1;
    static NewspaperMachine newspaperMachine2;
    static NewspaperMachine newspaperMachine3;

    static MyDrawPanel drawPanel;
    Color xColor = Color.RED;
    static Runnable runnableCircle;
    static Thread threadCircle;

    static int flError1 = 0;//если 1, не выдает товар; если 2, не выдает сдачу
    static int flError2 = 0;//если 1, не выдает товар; если 2, не выдает сдачу
    static int flError3 = 0;//если 1, не выдает товар; если 2, не выдает сдачу

    public static boolean dailyButtonFill = false;

    static int incomeAmount1;
    static int incomeAmount2;
    static int incomeAmount3;


    public void go() {
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        incomeAmount1 = 0;
        incomeAmount2 = 0;
        incomeAmount3 = 0;
        jFrame = new JFrame("Сеть автоматов по продаже напитков");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jLabelForMachine1 = new JLabel("Автомат 1");
        jLabelAmountOperation1 = new JLabel("Кол-во завершенных операций: ");
        amountPromotional1 = new JLabel("Бутылок воды: ");//
        amountEntertaining1 = new JLabel("Бутылок газировки: ");//
        amountDaily1 = new JLabel("Бутылок сока: ");//
        amountWeekly1 = new JLabel("Бутылок содовой: ");//
        income1 = new JLabel("Прибыль: 0 .р");
        jLabelAmounNewspaper1 = new JLabel("0 0 0 0");
        jTextAreaForMachine1 = new JTextArea(2, 3);
        JScrollPane scrollPane1 = new JScrollPane(jTextAreaForMachine1);
        jTextAreaForMachine1.setLineWrap(true);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextAreaForMachine1.setEditable(false);

        jLabelForMachine2 = new JLabel("Автомат 2");
        jLabelAmountOperation2 = new JLabel("Кол-во завершенных операций: ");
        amountPromotional2 = new JLabel("Бутылок воды: ");
        amountEntertaining2 = new JLabel("Бутылок газировки: ");
        amountDaily2 = new JLabel("Бутылок сока: ");
        amountWeekly2 = new JLabel("Бутылок содовой : ");
        income2 = new JLabel("Прибыль: 0 .р");
        jLabelAmounNewspaper2 = new JLabel("0 0 0 0");
        jTextAreaForMachine2 = new JTextArea(2, 3);
        JScrollPane scrollPane2 = new JScrollPane(jTextAreaForMachine2);
        jTextAreaForMachine2.setLineWrap(true);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextAreaForMachine2.setEditable(false);

        jLabelForMachine3 = new JLabel("Автомат 3");
        jLabelAmountOperation3 = new JLabel("Кол-во завершенных операций: ");
        amountPromotional3 = new JLabel("Бутылок воды: ");
        amountEntertaining3 = new JLabel("Бутылок газировки: ");
        amountDaily3 = new JLabel("Бутылок сока: ");
        amountWeekly3 = new JLabel("Бутылок содовой: ");
        income3 = new JLabel("Прибыль: 0 .р");
        jLabelAmounNewspaper3 = new JLabel("0 0 0 0");
        jTextAreaForMachine3 = new JTextArea(2, 3);
        JScrollPane scrollPane3 = new JScrollPane(jTextAreaForMachine3);
        jTextAreaForMachine3.setLineWrap(true);
        scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextAreaForMachine3.setEditable(false);


        int ipadx = 183;
        jPanelForMachine = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        jPanelForMachine.setLayout(gridBagLayout);
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 0, 0, 548);
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 0.1;
        gridBagLayout.setConstraints(jLabelForMachine1, c);
        jPanelForMachine.add(jLabelForMachine1);

        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(jLabelAmountOperation1, c);
        jPanelForMachine.add(jLabelAmountOperation1);

        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountPromotional1, c);
        jPanelForMachine.add(amountPromotional1);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountEntertaining1, c);
        jPanelForMachine.add(amountEntertaining1);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountDaily1, c);
        jPanelForMachine.add(amountDaily1);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountWeekly1, c);
        jPanelForMachine.add(amountWeekly1);
        gridBagLayout.setConstraints(income1, c);
        jPanelForMachine.add(income1);


        c.fill = GridBagConstraints.VERTICAL;
        c.weighty = 1.0;
        c.weightx = 0.3333;
        c.ipadx = ipadx;
        c.gridheight = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(scrollPane1, c);
        jPanelForMachine.add(scrollPane1);


        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 0, 0, 0);
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 0.1;
        gridBagLayout.setConstraints(jLabelForMachine2, c);
        jPanelForMachine.add(jLabelForMachine2);

        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(jLabelAmountOperation2, c);
        jPanelForMachine.add(jLabelAmountOperation2);

        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountPromotional2, c);
        jPanelForMachine.add(amountPromotional2);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountEntertaining2, c);
        jPanelForMachine.add(amountEntertaining2);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountDaily2, c);
        jPanelForMachine.add(amountDaily2);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountWeekly2, c);
        jPanelForMachine.add(amountWeekly2);
        gridBagLayout.setConstraints(income2, c);
        jPanelForMachine.add(income2);


        c.fill = GridBagConstraints.VERTICAL;
        c.weighty = 1.0;
        c.weightx = 0.3333;
        c.ipadx = ipadx;
        c.gridheight = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(scrollPane2, c);
        jPanelForMachine.add(scrollPane2);


        c.fill = GridBagConstraints.NONE;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 548, 0, 0);
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 0.1;
        gridBagLayout.setConstraints(jLabelForMachine3, c);
        jPanelForMachine.add(jLabelForMachine3);

        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(jLabelAmountOperation3, c);
        jPanelForMachine.add(jLabelAmountOperation3);

        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountPromotional3, c);
        jPanelForMachine.add(amountPromotional3);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountEntertaining3, c);
        jPanelForMachine.add(amountEntertaining3);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountDaily3, c);
        jPanelForMachine.add(amountDaily3);
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(amountWeekly3, c);
        jPanelForMachine.add(amountWeekly3);
        gridBagLayout.setConstraints(income3, c);
        jPanelForMachine.add(income3);

        c.fill = GridBagConstraints.VERTICAL;
        c.weighty = 1.0;
        c.weightx = 0.3333;
        c.ipadx = ipadx;
        c.gridheight = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        gridBagLayout.setConstraints(scrollPane3, c);
        jPanelForMachine.add(scrollPane3);


        jButtonBeginAndEnd = new JButton("Начать работу");
        jButtonFillMachine = new JButton("Пополнить напитки в автоматах");
        jButtonFillDailyNewspaper = new JButton("Обновить напитки в автоматах");
        jButtonFillDailyNewspaper.setEnabled(false);
        jButtonFillMachine.setEnabled(false);//пока автоматы не работают, кнопка не активна
        jButtonFillDailyNewspaper.addActionListener(this);
        jButtonFillMachine.addActionListener(this);
        jButtonBeginAndEnd.addActionListener(this);

        jButtonTechnicalSupportForMachine1 = new JButton("Вызвать тех.поддержку для автомата 1");
        jButtonTechnicalSupportForMachine1.addActionListener(this);
        jButtonTechnicalSupportForMachine1.setEnabled(buttonTechnicalSupport1);//кнопка активна, если машина не сломалась

        jButtonTechnicalSupportForMachine2 = new JButton("Вызвать тех.поддержку для автомата 2");
        jButtonTechnicalSupportForMachine2.addActionListener(this);
        jButtonTechnicalSupportForMachine2.setEnabled(buttonTechnicalSupport2);//кнопка активна, если машина не сломалась

        jButtonTechnicalSupportForMachine3 = new JButton("Вызвать тех.поддержку для автомата 3");
        jButtonTechnicalSupportForMachine3.addActionListener(this);
        jButtonTechnicalSupportForMachine3.setEnabled(buttonTechnicalSupport3);//кнопка активна, если машина не сломалась

        jPanelForButton = new JPanel();
        jPanelForButton.setLayout(new GridLayout(1, 3));
        jPanelForButton.add(jButtonTechnicalSupportForMachine1);
        jPanelForButton.add(jButtonTechnicalSupportForMachine2);
        jPanelForButton.add(jButtonTechnicalSupportForMachine3);


        drawPanel = new MyDrawPanel();
        jPanelForButtonBeginAndEnd = new JPanel();
        jLabelForTime = new JLabel("00:00");
        jPanelForButtonBeginAndEnd.add(drawPanel);
        jPanelForButtonBeginAndEnd.add(jButtonBeginAndEnd);
        jPanelForButtonBeginAndEnd.add(jButtonFillMachine);
        jPanelForButtonBeginAndEnd.add(jButtonFillDailyNewspaper);
        jPanelForButtonBeginAndEnd.add(jLabelForTime);


        jPanelForButtonBeginAndEnd.setBackground(Color.WHITE);
        jPanelForMachine.setBackground(Color.orange);
        jButtonTechnicalSupportForMachine1.setBackground(Color.orange);
        jButtonTechnicalSupportForMachine2.setBackground(Color.orange);
        jButtonTechnicalSupportForMachine3.setBackground(Color.orange);
        jFrame.getContentPane().add(BorderLayout.CENTER, jPanelForMachine);
        jFrame.getContentPane().add(BorderLayout.SOUTH, jPanelForButton);
        jFrame.getContentPane().add(BorderLayout.NORTH, jPanelForButtonBeginAndEnd);

        jFrame.setSize(800, 500);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setLocation(600, 300);
    }

    public static void main(String[] args) {
        newspaperMachine1 = new NewspaperMachine(150);
        newspaperMachine2 = new NewspaperMachine(200);
        newspaperMachine3 = new NewspaperMachine(50);

        new AppearanceMachine().go();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Начать работу":
                JOptionPane.showMessageDialog(jFrame, "Автоматы начали свою работу", "Сообщение", 1);
//                jLabelForMachine1.setText("Автомат 1 (" + newspaperMachine1.getAmountsOperations() + ")");
                jLabelAmountOperation1.setText("Кол-во завершенных операций: " + newspaperMachine1.getAmountsOperations());
                jLabelAmountOperation2.setText("Кол-во завершенных операций: " + newspaperMachine2.getAmountsOperations());
                jLabelAmountOperation3.setText("Кол-во завершенных операций: " + newspaperMachine3.getAmountsOperations());
                fl = true;
                jButtonBeginAndEnd.setText("Закончить работу");

                amountPromotional1.setText("Бутылок воды: " + newspaperMachine1.newspaper1);
                amountEntertaining1.setText("Бутылок газировки: " + newspaperMachine1.newspaper2);
                amountDaily1.setText("Бутылок сока: " + newspaperMachine1.newspaper3);
                amountWeekly1.setText("Бутылок содовой: " + newspaperMachine1.newspaper4);

                amountPromotional2.setText("Бутылок воды: " + newspaperMachine2.newspaper1);
                amountEntertaining2.setText("Бутылок газировки: " + newspaperMachine2.newspaper2);
                amountDaily2.setText("Бутылок сока: " + newspaperMachine2.newspaper3);
                amountWeekly2.setText("Бутылок содовой: " + newspaperMachine2.newspaper4);

                amountPromotional3.setText("Бутылок воды: " + newspaperMachine3.newspaper1);
                amountEntertaining3.setText("Бутылок газировки: " + newspaperMachine3.newspaper2);
                amountDaily3.setText("Бутылок сока: " + newspaperMachine3.newspaper3);
                amountWeekly3.setText("Бутылок содовой: " + newspaperMachine3.newspaper4);

                jButtonFillMachine.setEnabled(true);

                timer = new Timer();
                myTimerTask = new MyTimerTask();
                timer.scheduleAtFixedRate(myTimerTask, 0, 100);//(long) 62.5!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                runnableCircle = new RunnableForCircle();
                textArea1 = new textArea1();
                textArea2 = new textArea2();
                textArea3 = new textArea3();

                threadCircle = new Thread(runnableCircle);
                thread1 = new Thread(textArea1);
                thread2 = new Thread(textArea2);
                thread3 = new Thread(textArea3);

                threadCircle.start();
                try {
                    thread1.start();
                    Random random = new Random();
                    int randomForSleep = random.nextInt(20);
                    thread1.sleep(randomForSleep);

                    thread2.start();
                    randomForSleep = random.nextInt(20);
                    thread2.sleep(randomForSleep);

                    thread3.start();
                    randomForSleep = random.nextInt(20);
                    thread3.sleep(randomForSleep);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Закончить работу":
                jButtonBeginAndEnd.setText("Начать работу");
                JOptionPane.showMessageDialog(jFrame, "Автоматы закончили свою работу", "Сообщение", 1);

                jLabelForMachine1.setText("Автомат 1");
                jLabelForMachine2.setText("Автомат 2");
                jLabelForMachine3.setText("Автомат 3");

                myTimerTask.cancel();
                myTimerTask = null;

                threadCircle.stop();
                thread1.stop();
                thread2.stop();
                thread3.stop();

                xColor = Color.red;
                jFrame.repaint();
                fl = false;
                break;
            case "Вызвать тех.поддержку для автомата 1":
                runMachine1 = true;
                buttonTechnicalSupport1 = false;
                jButtonTechnicalSupportForMachine1.setEnabled(buttonTechnicalSupport1);
                JOptionPane.showMessageDialog(jFrame, "Тех.поддержка исправила неисправность в работе автомата 1", "Сообщение", 1);
                break;
            case "Вызвать тех.поддержку для автомата 2":
                runMachine2 = true;
                buttonTechnicalSupport2 = false;
                jButtonTechnicalSupportForMachine2.setEnabled(buttonTechnicalSupport2);
                JOptionPane.showMessageDialog(jFrame, "Тех.поддержка исправила неисправность в работе автомата 2", "Сообщение", 1);
                break;
            case "Вызвать тех.поддержку для автомата 3":
                runMachine3 = true;
                buttonTechnicalSupport3 = false;
                jButtonTechnicalSupportForMachine3.setEnabled(buttonTechnicalSupport3);
                JOptionPane.showMessageDialog(jFrame, "Тех.поддержка исправила неисправность в работе автомата 3", "Сообщение", 1);
                break;
            case "Пополнить напитки в автоматах":
                newspaperMachine1.setNewspaperAmount(5, 5, 5, 5);
                newspaperMachine2.setNewspaperAmount(5, 5, 5, 5);
                newspaperMachine3.setNewspaperAmount(5, 5, 5, 5);
                amountPromotional1.setText("Бутылок воды: " + newspaperMachine1.newspaper1);
                amountEntertaining1.setText("Бутылок газировки: " + newspaperMachine1.newspaper2);
                amountDaily1.setText("Бутылок сока: " + newspaperMachine1.newspaper3);
                amountWeekly1.setText("Бутылок содовой: " + newspaperMachine1.newspaper4);

                amountPromotional2.setText("Бутылок воды: " + newspaperMachine2.newspaper1);
                amountEntertaining2.setText("Бутылок газировки: " + newspaperMachine2.newspaper2);
                amountDaily2.setText("Бутылок сока: " + newspaperMachine2.newspaper3);
                amountWeekly2.setText("Бутылок содовой: " + newspaperMachine2.newspaper4);

                amountPromotional3.setText("Бутылок воды: " + newspaperMachine3.newspaper1);
                amountEntertaining3.setText("Бутылок газировки: " + newspaperMachine3.newspaper2);
                amountDaily3.setText("Бутылок сока: " + newspaperMachine3.newspaper3);
                amountWeekly3.setText("Бутылок содовой: " + newspaperMachine3.newspaper4);
                break;
            case "Обновить напитки в автоматах":
                newspaperMachine1.setNewspaperAmount(10, 10, 10, 10);
                newspaperMachine2.setNewspaperAmount(10, 10, 10, 10);
                newspaperMachine3.setNewspaperAmount(10, 10, 10, 10);
                amountPromotional1.setText("Бутылок воды: " + newspaperMachine1.newspaper1);
                amountEntertaining1.setText("Бутылок газировки: " + newspaperMachine1.newspaper2);
                amountDaily1.setText("Бутылок сока: " + newspaperMachine1.newspaper3);
                amountWeekly1.setText("Бутылок содовой: " + newspaperMachine1.newspaper4);

                amountPromotional2.setText("Бутылок воды: " + newspaperMachine2.newspaper1);
                amountEntertaining2.setText("Бутылок газировки: " + newspaperMachine2.newspaper2);
                amountDaily2.setText("Бутылок сока: " + newspaperMachine2.newspaper3);
                amountWeekly2.setText("Бутылок содовой: " + newspaperMachine2.newspaper4);

                amountPromotional3.setText("Бутылок воды: " + newspaperMachine3.newspaper1);
                amountEntertaining3.setText("Бутылок газировки: " + newspaperMachine3.newspaper2);
                amountDaily3.setText("Бутылок сока: " + newspaperMachine3.newspaper3);
                amountWeekly3.setText("Бутылок содовой: " + newspaperMachine3.newspaper4);
                dailyButtonFill = false;
                jButtonFillDailyNewspaper.setEnabled(dailyButtonFill);

        }
    }


    public class textArea1 implements Runnable {

        @Override
        public void run() {
            chooseNewspaper1();//метод выполняющий выбор газеты и т.д.;
        }
    }

    private void chooseNewspaper1() {
        while (fl && runMachine1) {
            int number = new Random().nextInt(Newspaper.values().length) + 1;
            switch (number) {
                case 1:
                    if (newspaperMachine1.newspaper1 >= 1)
                        runMachineWithNumber1(Newspaper.PROMOTIONAL_AND_INFORMATIONAL);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 1 закончились бутылки с водой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 2:
                    if (newspaperMachine1.newspaper2 >= 1)
                        runMachineWithNumber1(Newspaper.ENTERTAINING);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 1 закончились бутылки с газировкой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3:
                    if (newspaperMachine1.newspaper3 >= 1)
                        runMachineWithNumber1(Newspaper.DAILY);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 1 закончились бутылки с соком\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 4:
                    if (newspaperMachine1.newspaper4 >= 1)
                        runMachineWithNumber1(Newspaper.WEEKLY);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 1 закончились бутылки с содовой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    private void runMachineWithNumber1(Newspaper newspaper) {
        Random random = new Random();
        int randomForSleep;
        jTextAreaForMachine1.append("Ожидает заказа...\n");
        try {
            randomForSleep = random.nextInt(5000) + 5000;
            thread1.sleep(randomForSleep);
            StringBuffer order = new StringBuffer(newspaper.getTitle());
            jTextAreaForMachine1.append(order.toString() + "\n");
            newspaperMachine1.amountsOperations++;
            jLabelAmountOperation1.setText("Кол-во завершенных операций: " + newspaperMachine1.getAmountsOperations());
//            jLabelForMachine1.setText("Автомат 1 (" + newspaperMachine1.getAmountsOperations() + ")");
            randomForSleep = random.nextInt(2000) + 2000;
            thread1.sleep(randomForSleep);
            int randomSum = ((new Random().nextInt(newspaper.getPrice() / 10) * 2) + newspaper.getPrice() / 10) * 10;
            jTextAreaForMachine1.append("Внесено " + String.valueOf(randomSum) + " руб.\n");
            newspaperMachine1.amountsOperations++;
//            jLabelForMachine1.setText("Автомат 1 (" + newspaperMachine1.getAmountsOperations() + ")");
            jLabelAmountOperation1.setText("Кол-во завершенных операций: " + newspaperMachine1.getAmountsOperations());
            randomForSleep = random.nextInt(2000) + 2000;
            thread1.sleep(randomForSleep);
            newspaperMachine1.setMoney(newspaperMachine1.getMoney() + randomSum);
            randomForSleep = random.nextInt(2000) + 2000;
            thread1.sleep(randomForSleep);
            int randNumber = new Random().nextInt(45);
            if (randNumber < 20) {
                JOptionPane.showMessageDialog(jFrame, "Автомат 1 не выдает напиток\n" +
                        "Пожалуйста, вызовете тех.поддержку для автомата 1", "Ошибка", JOptionPane.ERROR_MESSAGE);
                flError1 = 1;
                runMachine1 = false;
                buttonTechnicalSupport1 = true;
                jButtonTechnicalSupportForMachine1.setEnabled(buttonTechnicalSupport1);
                while (buttonTechnicalSupport1) {
                    randomForSleep = random.nextInt(2000) + 2000;
                    thread1.sleep(randomForSleep);
                }
            }
            jTextAreaForMachine1.append("Напиток выдан\n");
            incomeAmount1 += newspaper.getPrice();
            income1.setText("Прибыль: " + incomeAmount1 + " р.");
            switch (order.toString()) {
                case "Вода":
                    newspaperMachine1.newspaper1--;
                    break;
                case "Газировка":
                    newspaperMachine1.newspaper2--;
                    break;
                case "Сок":
                    newspaperMachine1.newspaper3--;
                    break;
                case "Содовая":
                    newspaperMachine1.newspaper4--;
                    break;
            }
            amountPromotional1.setText("Бутылок воды: " + newspaperMachine1.newspaper1);
            amountEntertaining1.setText("Бутылок газировки: " + newspaperMachine1.newspaper2);
            amountDaily1.setText("Бутылок сока: " + newspaperMachine1.newspaper3);
            amountWeekly1.setText("Бутылок содовой: " + newspaperMachine1.newspaper4);
            newspaperMachine1.amountsOperations++;
//            jLabelForMachine1.setText("Автомат 1 (" + newspaperMachine1.getAmountsOperations() + ")");
            jLabelAmountOperation1.setText("Кол-во завершенных операций: " + newspaperMachine1.getAmountsOperations());
            randomForSleep = random.nextInt(2000) + 2000;
            thread1.sleep(randomForSleep);
            if (randomSum > newspaper.getPrice()) {
                errorGiveChange1();
                newspaperMachine1.setMoney(newspaperMachine1.getMoney() - (randomSum - newspaper.getPrice()));
                newspaperMachine1.amountsOperations++;
//                jLabelForMachine1.setText("Автомат 1 (" + newspaperMachine1.getAmountsOperations() + ")");
                jLabelAmountOperation1.setText("Кол-во завершенных операций: " + newspaperMachine1.getAmountsOperations());
                jTextAreaForMachine1.append("Выдана сдача " + (randomSum - newspaper.getPrice()) + " руб.\n");
                randomForSleep = random.nextInt(2000) + 2000;
                thread1.sleep(randomForSleep);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void errorGiveChange1() {
        int numberErrorGiveChange = new Random().nextInt(38);
        if (numberErrorGiveChange < 19) {
            JOptionPane.showMessageDialog(jFrame, "Автомат 1 не выдает сдачу\n" +
                    "Пожалуйста, вызовете тех.поддержку для автомата 1", "Ошибка", JOptionPane.ERROR_MESSAGE);
            flError1 = 2;
            runMachine1 = false;
            buttonTechnicalSupport1 = true;
            jButtonTechnicalSupportForMachine1.setEnabled(buttonTechnicalSupport1);
            while (buttonTechnicalSupport1) {
                try {
                    thread2.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    public class textArea2 implements Runnable {

        @Override
        public void run() {
            //метод выполняющий выбор газеты и т.д.;
            chooseNewspaper2();
        }
    }

    private void chooseNewspaper2() {
        while (fl && runMachine2) {
            int number = new Random().nextInt(Newspaper.values().length) + 1;
            switch (number) {
                case 1:
                    if (newspaperMachine2.newspaper1 >= 1)
                        runMachineWithNumber2(Newspaper.PROMOTIONAL_AND_INFORMATIONAL);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 2 закончились бутылки с водой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 2:
                    if (newspaperMachine2.newspaper2 >= 1)
                        runMachineWithNumber2(Newspaper.ENTERTAINING);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 2 закончились бутылки с газировкой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3:
                    if (newspaperMachine2.newspaper3 >= 1)
                        runMachineWithNumber2(Newspaper.DAILY);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 2 закончились бутылки с соком\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 4:
                    if (newspaperMachine2.newspaper4 >= 1)
                        runMachineWithNumber2(Newspaper.WEEKLY);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 2 закончились бытулки с содовой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    private void runMachineWithNumber2(Newspaper newspaper) {
        Random random = new Random();
        int randomForSleep;
        jTextAreaForMachine2.append("Ожидает заказа...\n");
        try {
            randomForSleep = random.nextInt(5000) + 5000;
            thread2.sleep(randomForSleep);
            StringBuffer order = new StringBuffer(newspaper.getTitle());
            jTextAreaForMachine2.append(order.toString() + "\n");
            newspaperMachine2.amountsOperations++;
            jLabelAmountOperation2.setText("Кол-во завершенных операций: " + newspaperMachine2.getAmountsOperations());
//            jLabelForMachine2.setText("Автомат 2 (" + newspaperMachine2.getAmountsOperations() + ")");
            randomForSleep = random.nextInt(2000) + 2000;
            thread2.sleep(randomForSleep);
            int randomSum = ((new Random().nextInt(newspaper.getPrice() / 10) * 2) + newspaper.getPrice() / 10) * 10;
            jTextAreaForMachine2.append("Внесено " + String.valueOf(randomSum) + " руб.\n");
            newspaperMachine2.amountsOperations++;
            jLabelAmountOperation2.setText("Кол-во завершенных операций: " + newspaperMachine2.getAmountsOperations());
//            jLabelForMachine2.setText("Автомат 2 (" + newspaperMachine2.getAmountsOperations() + ")");
            randomForSleep = random.nextInt(2000) + 2000;
            thread2.sleep(randomForSleep);
            newspaperMachine2.setMoney(newspaperMachine2.getMoney() + randomSum);
            randomForSleep = random.nextInt(2000) + 2000;
            thread2.sleep(randomForSleep);
            int randNumber = new Random().nextInt(45);
            if (randNumber < 20) {
                JOptionPane.showMessageDialog(jFrame, "Автомат 2 не выдает напиток\n" +
                        "Пожалуйста, вызовете тех.поддержку для автомата 2", "Ошибка", JOptionPane.ERROR_MESSAGE);
                flError2 = 1;
                runMachine2 = false;
                buttonTechnicalSupport2 = true;
                jButtonTechnicalSupportForMachine2.setEnabled(buttonTechnicalSupport2);
                while (buttonTechnicalSupport2) {
                    randomForSleep = random.nextInt(2000) + 2000;
                    thread2.sleep(randomForSleep);
                }
            }
            jTextAreaForMachine2.append("Напиток выдан\n");
            incomeAmount2 += newspaper.getPrice();
            income2.setText("Прибыль: " + incomeAmount2 + " р.");
            newspaperMachine2.amountsOperations++;
            switch (order.toString()) {
                case "Вода":
                    newspaperMachine2.newspaper1--;
                    break;
                case "Газировка":
                    newspaperMachine2.newspaper2--;
                    break;
                case "Сок":
                    newspaperMachine2.newspaper3--;
                    break;
                case "Содовая":
                    newspaperMachine2.newspaper4--;
                    break;
            }
            amountPromotional2.setText("Бутылок воды: " + newspaperMachine2.newspaper1);
            amountEntertaining2.setText("Бутылок газировки: " + newspaperMachine2.newspaper2);
            amountDaily2.setText("Бутылок сока: " + newspaperMachine2.newspaper3);
            amountWeekly2.setText("Бутылок содовой: " + newspaperMachine2.newspaper4);
            jLabelAmountOperation2.setText("Кол-во завершенных операций: " + newspaperMachine2.getAmountsOperations());
//            jLabelForMachine2.setText("Автомат 2 (" + newspaperMachine2.getAmountsOperations() + ")");
            randomForSleep = random.nextInt(2000) + 2000;
            thread2.sleep(randomForSleep);
            if (randomSum > newspaper.getPrice()) {
                errorGiveChange2();
                newspaperMachine2.setMoney(newspaperMachine2.getMoney() - (randomSum - newspaper.getPrice()));
                newspaperMachine2.amountsOperations++;
                jLabelAmountOperation2.setText("Кол-во завершенных операций: " + newspaperMachine2.getAmountsOperations());
//                jLabelForMachine2.setText("Автомат 2 (" + newspaperMachine2.getAmountsOperations() + ")");
                jTextAreaForMachine2.append("Выдана сдача " + (randomSum - newspaper.getPrice()) + " руб.\n");
                randomForSleep = random.nextInt(2000) + 2000;
                thread2.sleep(randomForSleep);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void errorGiveChange2() {
        int numberErrorGiveChange = new Random().nextInt(38);
        if (numberErrorGiveChange < 19) {
            JOptionPane.showMessageDialog(jFrame, "Автомат 2 не выдает сдачу\n" +
                    "Пожалуйста, вызовете тех.поддержку для автомата 2", "Ошибка", JOptionPane.ERROR_MESSAGE);
            flError2 = 2;
            runMachine2 = false;
            buttonTechnicalSupport2 = true;
            jButtonTechnicalSupportForMachine2.setEnabled(buttonTechnicalSupport2);
            while (buttonTechnicalSupport2) {
                try {
                    thread2.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    public class textArea3 implements Runnable {

        @Override
        public void run() {
            //метод выполняющий выбор газеты и т.д.;
            chooseNewspaper3();
        }
    }

    private void chooseNewspaper3() {
        while (fl && runMachine3) {
            int number = new Random().nextInt(Newspaper.values().length) + 1;
            switch (number) {
                case 1:
                    if (newspaperMachine3.newspaper1 >= 1)
                        runMachineWithNumber3(Newspaper.PROMOTIONAL_AND_INFORMATIONAL);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 3 закончились бутылки с водой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 2:
                    if (newspaperMachine3.newspaper2 >= 1)
                        runMachineWithNumber3(Newspaper.ENTERTAINING);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 3 закончились бутылки с газировкой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3:
                    if (newspaperMachine3.newspaper3 >= 1)
                        runMachineWithNumber3(Newspaper.DAILY);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 3 закончились бутылки с соком\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
                case 4:
                    if (newspaperMachine3.newspaper4 >= 1)
                        runMachineWithNumber3(Newspaper.WEEKLY);
                    else
                        JOptionPane.showMessageDialog(jFrame, "В автомате 3 закончились бутылки с содовой\n" +
                                "Пожалуйста, пополните автомат напитками", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    private void runMachineWithNumber3(Newspaper newspaper) {
        Random random = new Random();
        int randomForSleep;
        jTextAreaForMachine3.append("Ожидает заказа...\n");
        try {
            randomForSleep = random.nextInt(5000) + 5000;
            thread3.sleep(randomForSleep);
            StringBuffer order = new StringBuffer(newspaper.getTitle());
            jTextAreaForMachine3.append(order.toString() + "\n");
            newspaperMachine3.amountsOperations++;
            jLabelAmountOperation3.setText("Кол-во завершенных операций: " + newspaperMachine3.getAmountsOperations());
//            jLabelForMachine3.setText("Автомат 3 (" + newspaperMachine3.getAmountsOperations() + ")");
            randomForSleep = random.nextInt(2000) + 2000;
            thread3.sleep(randomForSleep);
            int randomSum = ((new Random().nextInt(newspaper.getPrice() / 10) * 2) + newspaper.getPrice() / 10) * 10;
            jTextAreaForMachine3.append("Внесено " + String.valueOf(randomSum) + " руб.\n");
            newspaperMachine3.amountsOperations++;
            jLabelAmountOperation3.setText("Кол-во завершенных операций: " + newspaperMachine3.getAmountsOperations());
//            jLabelForMachine3.setText("Автомат 3 (" + newspaperMachine3.getAmountsOperations() + ")");
            randomForSleep = random.nextInt(2000) + 2000;
            thread3.sleep(randomForSleep);
            newspaperMachine3.setMoney(newspaperMachine3.getMoney() + randomSum);
            randomForSleep = random.nextInt(2000) + 2000;
            thread3.sleep(randomForSleep);
            int randNumber = new Random().nextInt(45);
            if (randNumber < 20) {
                JOptionPane.showMessageDialog(jFrame, "Автомат 3 не выдает напиток\n" +
                        "Пожалуйста, вызовете тех.поддержку для автомата 3", "Ошибка", JOptionPane.ERROR_MESSAGE);
                flError3 = 1;
                runMachine3 = false;
                buttonTechnicalSupport3 = true;
                jButtonTechnicalSupportForMachine3.setEnabled(buttonTechnicalSupport3);
                while (buttonTechnicalSupport3) {
                    randomForSleep = random.nextInt(2000) + 2000;
                    thread3.sleep(randomForSleep);
                }
            }
            jTextAreaForMachine3.append("Напиток выдан\n");
            incomeAmount3 += newspaper.getPrice();
            income3.setText("Прибыль: " + incomeAmount3 + " р.");
            newspaperMachine3.amountsOperations++;
            switch (order.toString()) {
                case "Вода":
                    newspaperMachine3.newspaper1--;
                    break;
                case "Газировка":
                    newspaperMachine3.newspaper2--;
                    break;
                case "Сок":
                    newspaperMachine3.newspaper3--;
                    break;
                case "Содовая":
                    newspaperMachine3.newspaper4--;
                    break;
            }
            amountPromotional3.setText("Бутылок воды: " + newspaperMachine3.newspaper1);
            amountEntertaining3.setText("Бутылок газировки: " + newspaperMachine3.newspaper2);
            amountDaily3.setText("Бутылок сока: " + newspaperMachine3.newspaper3);
            amountWeekly3.setText("Бутылок содовой: " + newspaperMachine3.newspaper4);
            jLabelAmountOperation3.setText("Кол-во завершенных операций: " + newspaperMachine3.getAmountsOperations());
//            jLabelForMachine3.setText("Автомат 3 (" + newspaperMachine3.getAmountsOperations() + ")");
            randomForSleep = random.nextInt(2000) + 2000;
            thread3.sleep(randomForSleep);
            if (randomSum > newspaper.getPrice()) {
                errorGiveChange3();
                newspaperMachine3.setMoney(newspaperMachine3.getMoney() - (randomSum - newspaper.getPrice()));
                newspaperMachine3.amountsOperations++;
                jLabelAmountOperation3.setText("Кол-во завершенных операций: " + newspaperMachine3.getAmountsOperations());
//                jLabelForMachine3.setText("Автомат 3 (" + newspaperMachine3.getAmountsOperations() + ")");
                jTextAreaForMachine3.append("Выдана сдача " + (randomSum - newspaper.getPrice()) + " руб.\n");
                randomForSleep = random.nextInt(2000) + 2000;
                thread3.sleep(randomForSleep);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void errorGiveChange3() {
        int numberErrorGiveChange = new Random().nextInt(38);
        if (numberErrorGiveChange < 19) {
            JOptionPane.showMessageDialog(jFrame, "Автомат 3 не выдает сдачу\n" +
                    "Пожалуйста, вызовете тех.поддержку для автомата 3", "Ошибка", JOptionPane.ERROR_MESSAGE);
            flError3 = 2;
            runMachine3 = false;
            buttonTechnicalSupport3 = true;
            jButtonTechnicalSupportForMachine3.setEnabled(buttonTechnicalSupport3);
            while (buttonTechnicalSupport3) {
                try {
                    thread3.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public class RunnableForCircle implements Runnable {

        @Override
        public void run() {
            try {
                circle();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(xColor);
            g.fillOval(1, 1, 8, 8);
        }
    }

    public void circle() throws InterruptedException {
        for (; ; ) {
            xColor = Color.gray;
            jFrame.repaint();
            Thread.sleep(200);
            xColor = Color.green;
            jFrame.repaint();
            Thread.sleep(1700);
        }
    }

}
