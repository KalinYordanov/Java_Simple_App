import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;

    //Format second , minutes and hours 00:00:00 Just like that
    String second_String = String.format("%02d", seconds);
    String minutes_String = String.format("%02d", minutes);
    String hours_String = String.format("%02d", hours);


    /*create timer */
    Timer timer = new Timer(1000, new ActionListener() {
        //timer have 1000 milliseconds , and define what to do timer every 1000 millisecond
        @Override
        public void actionPerformed(ActionEvent e) {

            elapsedTime += 1000;
            //One Hour
            hours = (elapsedTime / 3600000);
            //minutes and we do not want to display 61 minutes our else (%60)
            minutes = (elapsedTime / 60000) % 60;
            //second
            seconds = (elapsedTime / 1000) % 60;

            //Format second , minutes and hours 00:00:00 Just like that and add
            formatTheStopWatch();


        }
    }); //


    StopWatch() {

        //Size of the numbers in window
        timeLabel.setText(hours_String + ":" + minutes_String + ":" + second_String);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);


        //set The window size
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        //set the button size for start the watch
        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        //set the reset button size
        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        formatTheStopWatch();
    }

    private void formatTheStopWatch() {
        second_String = String.format("%02d", seconds);
        minutes_String = String.format("%02d", minutes);
        hours_String = String.format("%02d", hours);
        timeLabel.setText(hours_String + ":" + minutes_String + ":" + second_String);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {

            if (started == false) {
                started = true;
                startButton.setText("Stop");
                start();
            } else {
                started = false;
                startButton.setText("Start");
                stop();
            }
        }
        if (e.getSource() == resetButton) {
            started = false;
            startButton.setText("Start");
            reset();
        }

    }
}
