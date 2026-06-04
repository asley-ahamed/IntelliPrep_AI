package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class forgotPasswordView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JPanel rightPanel;
    private JPanel panelEmail;
    private JPanel panelOtp;
    private JPanel panelNewPassword;
    private JPanel panelSuccess;

    private JTextField txtEmail;
    private JTextField txtOtp;
    private JPasswordField txtNewPassword;
    private JPasswordField txtConfirmPassword;

    private JButton btnSendOtp;
    private JButton btnVerifyOtp;
    private JButton btnUpdatePassword;
    private JButton btnGoToLogin;

    private JLabel lblBackToLoginEmail;
    private JLabel lblBackToEmail;
    private JLabel lblBackToLoginPassword;
    private JLabel lblOtpEmail;

    private int currentUserId;

    public forgotPasswordView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 876, 677);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        ImagePanel img_1 = new ImagePanel("/images/image_1.png");
        img_1.setBackground(Color.WHITE);
        img_1.setBounds(0, 0, 451, 640);
        contentPane.add(img_1);
        img_1.setLayout(null);

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(451, 0, 411, 640);
        contentPane.add(rightPanel);
        rightPanel.setLayout(null);

        createEmailPanel();
        createOtpPanel();
        createNewPasswordPanel();
        createSuccessPanel();

        showEmailPanel();
    }

    private void createEmailPanel() {
        panelEmail = new JPanel();
        panelEmail.setBackground(Color.WHITE);
        panelEmail.setBounds(0, 0, 411, 640);
        panelEmail.setLayout(null);
        rightPanel.add(panelEmail);

        JLabel lblTitle = new JLabel("Reset Your Password");
        lblTitle.setForeground(new Color(108, 77, 255));
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 29));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(45, 55, 320, 39);
        panelEmail.add(lblTitle);

        JLabel lblSubTitle = new JLabel("Enter your registered email to receive OTP");
        lblSubTitle.setForeground(Color.GRAY);
        lblSubTitle.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
        lblSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubTitle.setBounds(40, 95, 330, 24);
        panelEmail.add(lblSubTitle);

        ImagePanel imgEmail = new ImagePanel("/images/image_4.png");
        imgEmail.setBackground(Color.WHITE);
        imgEmail.setBounds(118, 145, 180, 145);
        panelEmail.add(imgEmail);

        JLabel lblIcon = new JLabel("📧");
        lblIcon.setForeground(new Color(108, 77, 255));
        lblIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        lblIcon.setBounds(47, 334, 30, 24);
        panelEmail.add(lblIcon);

        JLabel lblEmail = new JLabel("Email Address");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblEmail.setBounds(80, 333, 140, 24);
        panelEmail.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        txtEmail.setBounds(47, 365, 320, 42);
        panelEmail.add(txtEmail);

        btnSendOtp = new JButton("SEND OTP");
        btnSendOtp.setSelected(true);
        btnSendOtp.setOpaque(true);
        btnSendOtp.setForeground(Color.WHITE);
        btnSendOtp.setFont(new Font("Dialog", Font.BOLD, 20));
        btnSendOtp.setFocusPainted(false);
        btnSendOtp.setContentAreaFilled(true);
        btnSendOtp.setBorderPainted(false);
        btnSendOtp.setBackground(new Color(108, 77, 255));
        btnSendOtp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSendOtp.setBounds(86, 435, 240, 43);
        panelEmail.add(btnSendOtp);

        lblBackToLoginEmail = new JLabel("← Back to Login");
        lblBackToLoginEmail.setForeground(new Color(108, 77, 255));
        lblBackToLoginEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblBackToLoginEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBackToLoginEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblBackToLoginEmail.setBounds(135, 496, 140, 24);
        panelEmail.add(lblBackToLoginEmail);
    }

    private void createOtpPanel() {
        panelOtp = new JPanel();
        panelOtp.setBackground(Color.WHITE);
        panelOtp.setBounds(0, 0, 411, 640);
        panelOtp.setLayout(null);
        rightPanel.add(panelOtp);

        JLabel lblTitle = new JLabel("Verify OTP");
        lblTitle.setForeground(new Color(108, 77, 255));
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(90, 55, 230, 39);
        panelOtp.add(lblTitle);

        JLabel lblInfo = new JLabel("OTP sent to");
        lblInfo.setForeground(Color.GRAY);
        lblInfo.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(70, 100, 270, 24);
        panelOtp.add(lblInfo);

        lblOtpEmail = new JLabel("your email address");
        lblOtpEmail.setForeground(new Color(108, 77, 255));
        lblOtpEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblOtpEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblOtpEmail.setBounds(45, 125, 320, 24);
        panelOtp.add(lblOtpEmail);

        ImagePanel imgOtp = new ImagePanel("/images/image_5.png");
        imgOtp.setBackground(Color.WHITE);
        imgOtp.setBounds(132, 170, 150, 130);
        panelOtp.add(imgOtp);

        JLabel lblOtp = new JLabel("OTP Code");
        lblOtp.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblOtp.setBounds(47, 333, 140, 24);
        panelOtp.add(lblOtp);

        txtOtp = new JTextField();
        txtOtp.setHorizontalAlignment(SwingConstants.CENTER);
        txtOtp.setForeground(Color.BLACK);
        txtOtp.setFont(new Font("Segoe UI", Font.BOLD, 18));
        txtOtp.setBounds(47, 365, 320, 42);
        panelOtp.add(txtOtp);

        btnVerifyOtp = new JButton("VERIFY OTP");
        btnVerifyOtp.setSelected(true);
        btnVerifyOtp.setOpaque(true);
        btnVerifyOtp.setForeground(Color.WHITE);
        btnVerifyOtp.setFont(new Font("Dialog", Font.BOLD, 20));
        btnVerifyOtp.setFocusPainted(false);
        btnVerifyOtp.setContentAreaFilled(true);
        btnVerifyOtp.setBorderPainted(false);
        btnVerifyOtp.setBackground(new Color(108, 77, 255));
        btnVerifyOtp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVerifyOtp.setBounds(86, 435, 240, 43);
        panelOtp.add(btnVerifyOtp);

        lblBackToEmail = new JLabel("← Back to Email");
        lblBackToEmail.setForeground(new Color(108, 77, 255));
        lblBackToEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblBackToEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBackToEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblBackToEmail.setBounds(135, 496, 140, 24);
        panelOtp.add(lblBackToEmail);
    }

    private void createNewPasswordPanel() {
        panelNewPassword = new JPanel();
        panelNewPassword.setBackground(Color.WHITE);
        panelNewPassword.setBounds(0, 0, 411, 640);
        panelNewPassword.setLayout(null);
        rightPanel.add(panelNewPassword);

        JLabel lblTitle = new JLabel("Create New Password");
        lblTitle.setForeground(new Color(108, 77, 255));
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(35, 75, 340, 39);
        panelNewPassword.add(lblTitle);

        JLabel lblSubTitle = new JLabel("Enter your new password");
        lblSubTitle.setForeground(Color.GRAY);
        lblSubTitle.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
        lblSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubTitle.setBounds(105, 118, 200, 24);
        panelNewPassword.add(lblSubTitle);

        JLabel lblNew = new JLabel("New Password");
        lblNew.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNew.setBounds(47, 190, 150, 24);
        panelNewPassword.add(lblNew);

        txtNewPassword = new JPasswordField();
        txtNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtNewPassword.setForeground(Color.BLACK);
        txtNewPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        txtNewPassword.setEchoChar('*');
        txtNewPassword.setBounds(47, 222, 320, 42);
        panelNewPassword.add(txtNewPassword);

        JLabel lblConfirm = new JLabel("Confirm Password");
        lblConfirm.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblConfirm.setBounds(47, 285, 170, 24);
        panelNewPassword.add(lblConfirm);

        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtConfirmPassword.setForeground(Color.BLACK);
        txtConfirmPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        txtConfirmPassword.setEchoChar('*');
        txtConfirmPassword.setBounds(47, 317, 320, 42);
        panelNewPassword.add(txtConfirmPassword);

        btnUpdatePassword = new JButton("UPDATE PASSWORD");
        btnUpdatePassword.setSelected(true);
        btnUpdatePassword.setOpaque(true);
        btnUpdatePassword.setForeground(Color.WHITE);
        btnUpdatePassword.setFont(new Font("Dialog", Font.BOLD, 18));
        btnUpdatePassword.setFocusPainted(false);
        btnUpdatePassword.setContentAreaFilled(true);
        btnUpdatePassword.setBorderPainted(false);
        btnUpdatePassword.setBackground(new Color(108, 77, 255));
        btnUpdatePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdatePassword.setBounds(47, 395, 320, 43);
        panelNewPassword.add(btnUpdatePassword);

        lblBackToLoginPassword = new JLabel("← Back to Login");
        lblBackToLoginPassword.setForeground(new Color(108, 77, 255));
        lblBackToLoginPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblBackToLoginPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBackToLoginPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblBackToLoginPassword.setBounds(135, 465, 140, 24);
        panelNewPassword.add(lblBackToLoginPassword);
    }

    private void createSuccessPanel() {
        panelSuccess = new JPanel();
        panelSuccess.setBackground(Color.WHITE);
        panelSuccess.setBounds(0, 0, 411, 640);
        panelSuccess.setLayout(null);
        rightPanel.add(panelSuccess);

        ImagePanel imgSuccess = new ImagePanel("/images/image_6.png");
        imgSuccess.setBackground(Color.WHITE);
        imgSuccess.setBounds(126, 120, 160, 150);
        panelSuccess.add(imgSuccess);

        JLabel lblTitle = new JLabel("Password Reset Successful!");
        lblTitle.setForeground(new Color(108, 77, 255));
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 27));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(15, 290, 380, 39);
        panelSuccess.add(lblTitle);

        JLabel lbl1 = new JLabel("Your password has been updated successfully.");
        lbl1.setForeground(new Color(20, 20, 35));
        lbl1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setBounds(55, 340, 300, 18);
        panelSuccess.add(lbl1);

        JLabel lbl2 = new JLabel("You can now login with your new password.");
        lbl2.setForeground(new Color(20, 20, 35));
        lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setBounds(55, 363, 300, 18);
        panelSuccess.add(lbl2);

        btnGoToLogin = new JButton("GO TO LOGIN");
        btnGoToLogin.setSelected(true);
        btnGoToLogin.setOpaque(true);
        btnGoToLogin.setForeground(Color.WHITE);
        btnGoToLogin.setFont(new Font("Dialog", Font.BOLD, 18));
        btnGoToLogin.setFocusPainted(false);
        btnGoToLogin.setContentAreaFilled(true);
        btnGoToLogin.setBorderPainted(false);
        btnGoToLogin.setBackground(new Color(108, 77, 255));
        btnGoToLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnGoToLogin.setBounds(80, 430, 250, 43);
        panelSuccess.add(btnGoToLogin);
    }

    public void showEmailPanel() 
	{
        panelEmail.setVisible(true);
        panelOtp.setVisible(false);
        panelNewPassword.setVisible(false);
        panelSuccess.setVisible(false);
    }

    public void showOtpPanel() {
        panelEmail.setVisible(false);
        panelOtp.setVisible(true);
        panelNewPassword.setVisible(false);
        panelSuccess.setVisible(false);
    }

    public void showNewPasswordPanel() {
        panelEmail.setVisible(false);
        panelOtp.setVisible(false);
        panelNewPassword.setVisible(true);
        panelSuccess.setVisible(false);
    }

    public void showSuccessPanel() {
        panelEmail.setVisible(false);
        panelOtp.setVisible(false);
        panelNewPassword.setVisible(false);
        panelSuccess.setVisible(true);
    }

    public JTextField getEmail() {
        return txtEmail;
    }

    public JTextField getOtp() {
        return txtOtp;
    }

    public JPasswordField getNewPassword() {
        return txtNewPassword;
    }

    public JPasswordField getConfirmPassword() {
        return txtConfirmPassword;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }

    public void setOtpEmailText(String email) {
        lblOtpEmail.setText(email);
    }

    public void sendOtpButtonListener(ActionListener listener) {
        btnSendOtp.addActionListener(listener);
    }

    public void verifyOtpButtonListener(ActionListener listener) {
        btnVerifyOtp.addActionListener(listener);
    }

    public void updatePasswordButtonListener(ActionListener listener) {
        btnUpdatePassword.addActionListener(listener);
    }

    public void goToLoginButtonListener(ActionListener listener) {
        btnGoToLogin.addActionListener(listener);
    }

    public void backToLoginEmailListener(MouseListener listener) {
        lblBackToLoginEmail.addMouseListener(listener);
    }

    public void backToEmailListener(MouseListener listener) {
        lblBackToEmail.addMouseListener(listener);
    }

    public void backToLoginPasswordListener(MouseListener listener) {
        lblBackToLoginPassword.addMouseListener(listener);
    }
}
