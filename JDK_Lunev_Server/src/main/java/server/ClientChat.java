package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientChat extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JPanel panelTop = new JPanel(new BorderLayout());
    private final JTextArea log = new JTextArea();
    private final JButton btnSend = new JButton("Send");
    private final JTextField tfMessage = new JTextField();


    ClientChat(){
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat Client");

        panelTop.add(tfMessage);
        panelTop.add(btnSend, BorderLayout.EAST);
        add(panelTop, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextFileSaver.saveTextToFile(ClientGUI.tfLogin.getText() + ": " + tfMessage.getText(), "src/main/java/server/LogFile.txt");
                log.setText(TextFileSaver.readTextFromFile("src/main/java/server/LogFile.txt"));
                tfMessage.setText("");
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextFileSaver.saveTextToFile(ClientGUI.tfLogin.getText() + ": " + tfMessage.getText(), "src/main/java/server/LogFile.txt");
                log.setText(TextFileSaver.readTextFromFile("src/main/java/server/LogFile.txt"));
                tfMessage.setText("");

            }
        });

        setVisible(false);

    }

    public void isConnected() {
        TextFileSaver.saveTextToFile("Вы успешно подключились!" + "\n", "src/main/java/server/LogFile.txt");
        log.setText(TextFileSaver.readTextFromFile("src/main/java/server/LogFile.txt"));
    };

}
