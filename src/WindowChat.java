import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowChat extends JFrame {
    private static final int WIDTH = 650;
    private static final int HEIGHT = 550;
    private static final int POSX = 600;
    private static final int POSY = 250;
    private static final int FONT_SIZE = 16;

    public WindowChat() {
        setTitle("chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocation(POSX, POSY);

        JTextArea viewMessage = new JTextArea();
        viewMessage.setFont(new Font("Font", Font.PLAIN, FONT_SIZE));
        viewMessage.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(viewMessage);

        JPanel sendBar = new JPanel();
        sendBar.setBorder(BorderFactory.createEtchedBorder());
        JTextField textMessage = new JTextField();
        sendBar.add(textMessage);
        textMessage.setPreferredSize(new Dimension(510, 40));
        textMessage.setFont(new Font("Font", Font.PLAIN, FONT_SIZE));
        textMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!textMessage.getText().equals("") && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    viewMessage.append(textMessage.getText() + "\n");
                    textMessage.setText("");
                }
            }
        });

        JButton btnSend = new JButton("Отправить");
        btnSend.setPreferredSize(new Dimension(100, 40));
        sendBar.add(btnSend);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textMessage.getText().equals("")) {
                    viewMessage.append(textMessage.getText() + "\n");
                    textMessage.setText("");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(sendBar, BorderLayout.SOUTH);
        setVisible(true);
    }
}
