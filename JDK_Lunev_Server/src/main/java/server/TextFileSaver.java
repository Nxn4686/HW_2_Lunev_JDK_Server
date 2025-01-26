package server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextFileSaver extends JFrame {


    // Метод для сохранения текста в файл
    public static void saveTextToFile(String text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения текста из файла
    public static String readTextFromFile(String filePath) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

//    // Пример использования в GUI с JTextArea
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Text File Saver");
//        JTextArea textArea = new JTextArea(20, 40);
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        JButton saveButton = new JButton("Save Text");
//        JButton loadButton = new JButton("Load Text");
//
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
//        frame.add(scrollPane);
//        frame.add(saveButton);
//        frame.add(loadButton);
//
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String textToSave = textArea.getText();
//                saveTextToFile(textToSave, "output.txt");
//            }
//        });
//
//        loadButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String textFromFile = readTextFromFile("output.txt");
//                textArea.setText(textFromFile);
//            }
//        });
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
