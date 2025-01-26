package server;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea serverLog = new JTextArea();
    private final JTextArea messageLog = new JTextArea();
    private boolean isServerWorking = false;

    ServerWindow() {
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                System.out.println("Server started with status: " + isServerWorking + "\n");
                serverLog.setText("Сервер запущен!");
                messageLog.setText(TextFileSaver.readTextFromFile("src/main/java/server/LogFile.txt"));
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                System.out.println("Server stopped with status: " + isServerWorking + "\n");
                serverLog.setText("Сервер остановлен!");
                messageLog.setText("");
            }
        });

        JPanel panButton = new JPanel(new GridLayout(1, 2));
        panButton.add(btnStart);
        panButton.add(btnStop);

        JPanel panServerState = new JPanel(new GridLayout(1, 0));
        panServerState.add(serverLog);

        JScrollPane scrollPane = new JScrollPane(messageLog);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);

        add(panButton, BorderLayout.SOUTH);
        add(panServerState, BorderLayout.NORTH);
        add(scrollPane);


        setVisible(true);
    }
}
