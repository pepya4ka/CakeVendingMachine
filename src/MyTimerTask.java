import javax.swing.*;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private volatile int time = -1;
    private volatile int week = -1;

    private Runnable refresher = new Runnable() {
        @Override
        public void run() {
            int t = time;
            AppearanceMachine.jLabelForTime.setText(String.format("%02d:%02d", t / 60, t % 60));
        }
    };

    public void minus() {
        AppearanceMachine.jCosts1 += 5;
        AppearanceMachine.incomeAmount1 = AppearanceMachine.jProfit1 - AppearanceMachine.jCosts1;
        AppearanceMachine.costs1.setText("Расходы: " + AppearanceMachine.jCosts1 + " р.");
        AppearanceMachine.income1.setText("Прибыль: " + AppearanceMachine.incomeAmount1 + " р.");

        AppearanceMachine.jCosts2 += 5;
        AppearanceMachine.incomeAmount2 = AppearanceMachine.jProfit2 - AppearanceMachine.jCosts2;
        AppearanceMachine.costs2.setText("Расходы: " + AppearanceMachine.jCosts2 + " р.");
        AppearanceMachine.income2.setText("Прибыль: " + AppearanceMachine.incomeAmount2 + " р.");

        AppearanceMachine.jCosts3 += 5;
        AppearanceMachine.incomeAmount3 -= AppearanceMachine.jProfit3 - AppearanceMachine.jCosts3;
        AppearanceMachine.costs3.setText("Расходы: " + AppearanceMachine.jCosts3 + " р.");
        AppearanceMachine.income3.setText("Прибыль: " + AppearanceMachine.incomeAmount3 + " р.");
    }

    @Override
    public void run() {
        time += 1;
        SwingUtilities.invokeLater(refresher);
        if (time > 1438) {
            minus();
            week++;
            time = 0;
            if (week > 6) {
                AppearanceMachine.dailyButtonFill = true;
                AppearanceMachine.jButtonFillDailyNewspaper.setEnabled(AppearanceMachine.dailyButtonFill);
                JOptionPane.showMessageDialog(null, "Ого, прошла одна неделя, замените напитки:)");
                week = 0;
            }
        }
    }
}