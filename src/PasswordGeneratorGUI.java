// render the GUI Components (frontend)
// this class will inherit from the JFrame class

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PasswordGeneratorGUI extends JFrame{

    public PasswordGeneratorGUI(){
        // render frame and add a title
        super("Password Generator");

        setSize(540, 570);

        setResizable(false);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        addGuiComponents();
    }

    private void addGuiComponents(){
        // create title text
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 540, 39);

        add(titleLabel);

        // create result text area
        JTextArea passwordOutput = new JTextArea();

        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        // add scrollability in case output becomes too big
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);

        // create a black border around the text area
        passwordOutputPane.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        // create password length label
        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        add(passwordLengthLabel);

        // create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 215, 192, 39);
        add(passwordLengthInputArea);

        // create toggle buttons
        // uppercase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25, 302, 225, 56);
        uppercaseToggle.setFocusable(false);
        add(uppercaseToggle);

        // lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        lowercaseToggle.setFocusable(false);
        add(lowercaseToggle);

        // number toggle
        JToggleButton numberToggle = new JToggleButton("Numbers");
        numberToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numberToggle.setBounds(25, 373, 225, 56);
        numberToggle.setFocusable(false);
        add(numberToggle);

        // symbol toggle
        JToggleButton symbolToggle = new JToggleButton("Symbols");
        symbolToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolToggle.setBounds(282, 373, 225, 56);
        symbolToggle.setFocusable(false);
        add(symbolToggle);

        // create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.setFocusable(false);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the password length
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());

                // get the toggle states
                boolean includeUppercase = uppercaseToggle.isSelected();
                boolean includeLowercase = lowercaseToggle.isSelected();
                boolean includeNumbers = numberToggle.isSelected();
                boolean includeSpecialSymbols = symbolToggle.isSelected();

                // generate the password
                PasswordGenerator passwordGenerator = new PasswordGenerator();
                String password = passwordGenerator.generatePassword(passwordLength, includeUppercase, includeLowercase, includeNumbers, includeSpecialSymbols);

                // set the password to the text area
                passwordOutput.setText(password);
            }
        });
        add(generateButton);

    }
    
}
