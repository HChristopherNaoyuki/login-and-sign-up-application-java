package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginSignUpApp extends JFrame
{
    // Declare components for the login page
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel appTitleLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JButton loginButton;
    private JLabel signUpPromptLabel;
    private JLabel githubLabel;

    // Declare components for the sign-up page
    private JPanel signUpPanel;
    private JPanel signUpRightPanel;
    private JLabel signUpTitleLabel;
    private JLabel fullNameLabel;
    private JLabel signUpEmailLabel;
    private JLabel signUpPasswordLabel;
    private JTextField fullNameTextField;
    private JTextField signUpEmailTextField;
    private JPasswordField signUpPasswordField;
    private JButton submitSignUpButton;
    private JButton backToLoginButton;

    private boolean isSignUpPage = false;

    public LoginSignUpApp()
    {
        initComponents();
    }

    private void initComponents()
    {
        // Initialize main window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login and Sign Up");
        setPreferredSize(new Dimension(800, 500));
        setLayout(new BorderLayout());

        // Create left panel (Login Form)
        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(255, 255, 255));
        leftPanel.setPreferredSize(new Dimension(400, 500));
        leftPanel.setLayout(null);

        // Create right panel for login (light brown color)
        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(181, 101, 29));  // Light brown color
        rightPanel.setPreferredSize(new Dimension(400, 500));
        rightPanel.setLayout(new BorderLayout());

        githubLabel = new JLabel("GitHub: HChristopherNaoyuki", JLabel.CENTER);
        githubLabel.setFont(new Font("Yu Mincho", Font.ITALIC, 18));
        githubLabel.setForeground(Color.WHITE);
        rightPanel.add(githubLabel, BorderLayout.CENTER);

        leftPanel.add(rightPanel);
        rightPanel.setBounds(0, 0, 400, 500);

        // Title Label (Login)
        appTitleLabel = new JLabel("LOGIN");
        appTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        appTitleLabel.setBounds(540, 30, 140, 60);
        leftPanel.add(appTitleLabel);

        // Email Label and Text Field
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailLabel.setBounds(430, 110, 70, 20);
        leftPanel.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailTextField.setBounds(430, 140, 340, 30);
        leftPanel.add(emailTextField);

        // Password Label and Password Field
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordLabel.setBounds(430, 190, 70, 20);
        leftPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBounds(430, 220, 340, 30);
        leftPanel.add(passwordField);

        // Sign-up Prompt Label
        signUpPromptLabel = new JLabel("I don't have an account");
        signUpPromptLabel.setBounds(430, 350, 180, 30);
        leftPanel.add(signUpPromptLabel);

        // Sign-Up Button (with a distance from the Login button)
        signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(new Color(128, 128, 0));
        signUpButton.setBounds(570, 420, 140, 30);
        signUpButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                openSignUpPage();
            }
        });
        leftPanel.add(signUpButton);

        // Login Button (with additional vertical space)
        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(128, 128, 0));
        loginButton.setBounds(430, 270, 140, 30);  // Increased vertical distance
        loginButton.addActionListener((ActionEvent evt) ->
        {
            handleLogin();
        });
        leftPanel.add(loginButton);

        // Add everything to the frame
        getContentPane().add(leftPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void openSignUpPage()
    {
        // Switch to the Sign-Up page
        isSignUpPage = true;
        remove(leftPanel);

        signUpPanel = new JPanel();
        signUpPanel.setLayout(null);
        signUpPanel.setPreferredSize(new Dimension(800, 500));

        // Create right panel for sign-up (light brown color)
        signUpRightPanel = new JPanel();
        signUpRightPanel.setBackground(new Color(181, 101, 29));  // Light brown color for sign-up
        signUpRightPanel.setPreferredSize(new Dimension(400, 500));
        signUpRightPanel.setLayout(new BorderLayout());

        signUpTitleLabel = new JLabel("SIGN UP");
        signUpTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        signUpTitleLabel.setBounds(540, 30, 140, 60);
        signUpPanel.add(signUpTitleLabel);

        // Full Name Label and Text Field
        fullNameLabel = new JLabel("Full Name");
        fullNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fullNameLabel.setBounds(430, 110, 70, 20);
        signUpPanel.add(fullNameLabel);

        fullNameTextField = new JTextField();
        fullNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fullNameTextField.setBounds(430, 140, 340, 30);
        signUpPanel.add(fullNameTextField);

        // Sign-Up Email Label and Text Field
        signUpEmailLabel = new JLabel("Email");
        signUpEmailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        signUpEmailLabel.setBounds(430, 190, 70, 20);
        signUpPanel.add(signUpEmailLabel);

        signUpEmailTextField = new JTextField();
        signUpEmailTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        signUpEmailTextField.setBounds(430, 220, 340, 30);
        signUpPanel.add(signUpEmailTextField);

        // Sign-Up Password Label and Password Field
        signUpPasswordLabel = new JLabel("Password");
        signUpPasswordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        signUpPasswordLabel.setBounds(430, 270, 70, 20);
        signUpPanel.add(signUpPasswordLabel);

        signUpPasswordField = new JPasswordField();
        signUpPasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        signUpPasswordField.setBounds(430, 300, 340, 30);
        signUpPanel.add(signUpPasswordField);

        // Submit Button
        submitSignUpButton = new JButton("Sign Up");
        submitSignUpButton.setBackground(new Color(128, 128, 0));
        submitSignUpButton.setBounds(570, 420, 140, 30);
        submitSignUpButton.addActionListener((ActionEvent evt) ->
        {
            handleSignUp();
        });
        signUpPanel.add(submitSignUpButton);

        // Back to Login Button
        backToLoginButton = new JButton("Back to Login");
        backToLoginButton.setBackground(new Color(128, 128, 0));
        backToLoginButton.setBounds(430, 420, 140, 30);
        backToLoginButton.addActionListener((ActionEvent evt) ->
        {
            openLoginPage();
        });
        signUpPanel.add(backToLoginButton);

        // Add the light brown right panel for sign-up to the sign-up form
        signUpPanel.add(signUpRightPanel);
        signUpRightPanel.setBounds(0, 0, 400, 500);

        // Add the sign-up panel to the frame
        getContentPane().add(signUpPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void handleSignUp()
    {
        String fullName = fullNameTextField.getText();
        String email = signUpEmailTextField.getText();
        String password = new String(signUpPasswordField.getPassword());

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "All fields must be filled.");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Sign Up Successful!");
            openLoginPage();
        }
    }

    private void openLoginPage()
    {
        // Switch back to the Login page
        isSignUpPage = false;
        remove(signUpPanel);

        // Reinitialize the login page
        initComponents();

        getContentPane().add(leftPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void handleLogin()
    {
        String email = emailTextField.getText();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Email and Password cannot be empty.");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Logging in with:\nEmail: " + email + "\nPassword: " + password);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            LoginSignUpApp loginSignUpApp = new LoginSignUpApp();
            loginSignUpApp.setVisible(true);
        });
    }
}
