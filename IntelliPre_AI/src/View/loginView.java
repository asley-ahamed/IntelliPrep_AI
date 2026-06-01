package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;

public class loginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JButton btnLogin;
	private JLabel lblSignup;
	private JCheckBox check_showPassword;


	public loginView()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 677);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 451, 640);
		contentPane.add(panel);
        panel.setLayout(null);


        ImagePanel img_1 = new ImagePanel("/images/image_1.png");
        img_1.setForeground(Color.WHITE);
        img_1.setBackground(Color.WHITE);
        img_1.setBounds(0, 0, 449, 640);
        panel.add(img_1);
        img_1.setLayout(null);
        
        JLabel lblWelcome = new JLabel("Welcome Back!");
        lblWelcome.setForeground(new Color(108, 77, 255)); 
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 29));
        lblWelcome.setBounds(561, 21, 213, 50);
        contentPane.add(lblWelcome);
        
        JLabel lblText1 = new JLabel("Login to continue your smart learning journey");
        lblText1.setForeground(Color.GRAY);
        lblText1.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
        lblText1.setBounds(536, 62, 260, 24);
        contentPane.add(lblText1);
        
        txtPassword = new JPasswordField();
        txtPassword.setEchoChar('*');
        txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        txtPassword.setBounds(502, 444, 306, 39);
        contentPane.add(txtPassword);
        
        JLabel lblEnterUsername = new JLabel("Username");
        lblEnterUsername.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblEnterUsername.setBounds(536, 334, 119, 21);
        contentPane.add(lblEnterUsername);
        
        JLabel lblUserIcon = new JLabel("👤");
        lblUserIcon.setForeground(new Color(108, 77, 255));
        lblUserIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        lblUserIcon.setBounds(499, 335, 27, 24);
        contentPane.add(lblUserIcon);
        
        check_showPassword = new JCheckBox("Show Password");
        check_showPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
        check_showPassword.setBackground(Color.WHITE);
        check_showPassword.setBounds(697, 489, 126, 20);
        contentPane.add(check_showPassword);
        
        txtUsername = new JTextField();
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsername.setForeground(Color.BLACK);
        txtUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        txtUsername.setBounds(499, 362, 306, 39);
        contentPane.add(txtUsername);
        
        JLabel lblPassIcon = new JLabel("🔒");
        lblPassIcon.setForeground(new Color(108, 77, 255));
        lblPassIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        lblPassIcon.setBounds(499, 411, 27, 31);
        contentPane.add(lblPassIcon);
        
        JLabel lblEnterPassword = new JLabel("Password");
        lblEnterPassword.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblEnterPassword.setBounds(536, 413, 151, 21);
        contentPane.add(lblEnterPassword);
        
         btnLogin = new JButton("LOGIN");
        btnLogin.setSelected(true);
        btnLogin.setOpaque(true);
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("Poppins", Font.BOLD, 20));
        btnLogin.setFocusPainted(false);
        btnLogin.setContentAreaFilled(true);
        btnLogin.setBorderPainted(false);
        btnLogin.setBackground(new Color(108, 77, 255));
        btnLogin.setBounds(561, 520, 199, 39);
        contentPane.add(btnLogin);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Don`t have an account?");
        lblNewLabel_2_1_2.setBackground(Color.DARK_GRAY);
        lblNewLabel_2_1_2.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_2_1_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
        lblNewLabel_2_1_2.setBounds(571, 569, 138, 31);
        contentPane.add(lblNewLabel_2_1_2);
        
        lblSignup = new JLabel("SignUp");
        lblSignup.setForeground(new Color(108, 77, 255));
        lblSignup.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        lblSignup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblSignup.setBounds(707, 573, 55, 20);
        contentPane.add(lblSignup);
        
        	ImagePanel img_2 = new ImagePanel("/images/image_2.png");
               img_2.setBounds(487, 90, 343, 234);
                contentPane.add(img_2);
                img_2.setBackground(Color.WHITE);
                img_2.setLayout(null);
	}
	
	public JTextField getUsername()
	{
		return txtUsername;
	}
	public JPasswordField getPassword()
	{
		return txtPassword;
	}
	public void loginButtonListener(ActionListener listener)
	{
		btnLogin.addActionListener(listener);
	}
	public void signUpLabelListener(MouseListener listener)
	{
		lblSignup.addMouseListener(listener);
	}
	public void showPasswordListener(ActionListener listener)
	{
		check_showPassword.addActionListener(listener);
	}
	public boolean isShowPasswordSelected()
	{
	    return check_showPassword.isSelected();
	}
}
