import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class lockClass extends JFrame implements ActionListener{
    private JButton[] numberBtns;
    private JButton enterBtn, clearBtn;
    private JLabel statusLbl;
    private JPasswordField passwordField;
    private String savedPassword = null;

    public lockClass() {
        setTitle("Lock Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,200);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(3, 3));
        numberBtns = new JButton[9];

        for (int i = 0; i < 9; i++) {
            numberBtns[i] = new JButton(String.valueOf(i + 1));
            numberBtns[i].addActionListener(this);
            mainPanel.add(numberBtns[i]);
        }

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 30));
        passwordField.setEditable(false);

        enterBtn = new JButton("Enter");
        enterBtn.addActionListener(this);

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(this);

        statusLbl = new JLabel("Enter Password");
        statusLbl.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.add(clearBtn);
        inputPanel.add(passwordField);
        inputPanel.add(enterBtn);
        inputPanel.add(statusLbl);

        add(mainPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterBtn) {
            String enteredPassword = new String (passwordField.getPassword());
            if (savedPassword == null) {
                savedPassword = enteredPassword;
                statusLbl.setText("Password Set");
            } else {
                if (enteredPassword.equals(savedPassword)) {
                    statusLbl.setText("Correct Password");
                } else {
                    statusLbl.setText("Incorrect Password");
                }
            }
            passwordField.setText("");
        } else if (e.getSource() == clearBtn) {
            passwordField.setText("");
            statusLbl.setText("Enter Password");
        } else {
            for (int i = 0 ; i < 9; i++) {
                if (e.getSource() == numberBtns[i]) {
                    passwordField.setText(passwordField.getText() + (i + 1));
                }
            }
        }
    }
}
