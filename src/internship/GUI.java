package internship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class GUI {
    //GUI with listeners
    public static void createGui (){
        JFrame frame = new JFrame("Smart People");
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        JLabel label = new JLabel("Please, enter list length");
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Enter");
        JTextArea output = new JTextArea();
        output.setEditable(false);
        JScrollPane scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.getContentPane().add(BorderLayout.PAGE_START, panel);
        frame.getContentPane().add(BorderLayout.CENTER, output);
        frame.getContentPane().add(BorderLayout.EAST, scroll);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
                if (textField.getText().equals("")) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = Integer.parseInt(textField.getText());
                output.append("=== Smart People === \n");
                for(int i = 1; i <= length; i++){
                    output.append(i + " " + Logic.smartPeople(length)[i] + "\n");
                    System.out.println(i + " " + Logic.smartPeople(length)[i]);
                }
            }
        });
    }

}
