package View;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Cursor;

public class signUpView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtConfirmPassword;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnSignUp;
	private JCheckBox check_showPassword;
	private JLabel lblLogin;

	

	public signUpView()
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
        
        ImagePanel img_2=new ImagePanel("/images/image_3.png");
        img_2.setForeground(Color.WHITE);
        img_2.setBackground(Color.WHITE);
        img_2.setBounds(699, 35, 140, 110);
        contentPane.add(img_2);
        img_2.setLayout(null);
        
        
        
        JLabel lblWelcome = new JLabel("Create Account");
        lblWelcome.setForeground(new Color(108, 77, 255));
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 29));
        lblWelcome.setBounds(475, 35, 213, 50);
        contentPane.add(lblWelcome);
        
        JLabel lblJoinIntelliprepAi = new JLabel("Join IntelliPrep AI and start\r\n");
        lblJoinIntelliprepAi.setForeground(Color.GRAY);
        lblJoinIntelliprepAi.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
        lblJoinIntelliprepAi.setBounds(485, 82, 164, 18);
        contentPane.add(lblJoinIntelliprepAi);
        
        JLabel lblYourSmartLearning = new JLabel("your smart learning journey");
        lblYourSmartLearning.setForeground(Color.GRAY);
        lblYourSmartLearning.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
        lblYourSmartLearning.setBounds(485, 99, 164, 18);
        contentPane.add(lblYourSmartLearning);
        
        btnSignUp = new JButton("SignUp");
        btnSignUp.setSelected(true);
        btnSignUp.setOpaque(true);
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setFont(new Font("Dialog", Font.BOLD, 20));
        btnSignUp.setFocusPainted(false);
        btnSignUp.setContentAreaFilled(true);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setBackground(new Color(108, 77, 255));
        btnSignUp.setBounds(562, 520, 199, 39);
        contentPane.add(btnSignUp);
        
        JLabel lblEnterUsername = new JLabel("Email Address");
        lblEnterUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblEnterUsername.setBounds(512, 174, 119, 21);
        contentPane.add(lblEnterUsername);
        
        JLabel lblEnterPassword = new JLabel("Confirm Password");
        lblEnterPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblEnterPassword.setBounds(512, 406, 151, 21);
        contentPane.add(lblEnterPassword);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Already have an account?");
        lblNewLabel_2_1_2.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_2_1_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
        lblNewLabel_2_1_2.setBackground(Color.DARK_GRAY);
        lblNewLabel_2_1_2.setBounds(572, 569, 151, 31);
        contentPane.add(lblNewLabel_2_1_2);
        
        check_showPassword = new JCheckBox("Show Password");
        check_showPassword.setForeground(Color.DARK_GRAY);
        check_showPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        check_showPassword.setBackground(Color.WHITE);
        check_showPassword.setBounds(726, 482, 113, 20);
        contentPane.add(check_showPassword);
        
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtConfirmPassword.setForeground(Color.BLACK);
        txtConfirmPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        txtConfirmPassword.setEchoChar('*');
        txtConfirmPassword.setBounds(475, 437, 361, 39);
        contentPane.add(txtConfirmPassword);
        
        txtEmail = new JTextField();
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        txtEmail.setBounds(475, 201, 364, 39);
        contentPane.add(txtEmail);
        
        JLabel lblUserIcon = new JLabel("📧");
        lblUserIcon.setForeground(new Color(108, 77, 255));
        lblUserIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        lblUserIcon.setBounds(475, 174, 27, 24);
        contentPane.add(lblUserIcon);
        
        lblLogin = new JLabel("Login");
        lblLogin.setForeground(new Color(108, 77, 255));
        lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblLogin.setBounds(721, 573, 55, 20);
        contentPane.add(lblLogin);
        
        JLabel lblPassIcon = new JLabel("🛡️");
        lblPassIcon.setForeground(new Color(108, 77, 255));
        lblPassIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        lblPassIcon.setBounds(475, 404, 27, 31);
        contentPane.add(lblPassIcon);
        
        JLabel lblEnterUsername_1 = new JLabel("Username");
        lblEnterUsername_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblEnterUsername_1.setBounds(512, 250, 119, 21);
        contentPane.add(lblEnterUsername_1);
        
        txtUsername = new JTextField();
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsername.setForeground(Color.BLACK);
        txtUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        txtUsername.setBounds(475, 277, 364, 39);
        contentPane.add(txtUsername);
        
        JLabel lblUserIcon_1 = new JLabel("👤");
        lblUserIcon_1.setForeground(new Color(108, 77, 255));
        lblUserIcon_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        lblUserIcon_1.setBounds(475, 250, 27, 24);
        contentPane.add(lblUserIcon_1);
        
        JLabel lblUserIcon_1_1 = new JLabel("🔒");
        lblUserIcon_1_1.setForeground(new Color(108, 77, 255));
        lblUserIcon_1_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        lblUserIcon_1_1.setBounds(475, 326, 27, 28);
        contentPane.add(lblUserIcon_1_1);
        
        JLabel lblEnterUsername_1_1 = new JLabel("Password");
        lblEnterUsername_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblEnterUsername_1_1.setBounds(512, 330, 119, 21);
        contentPane.add(lblEnterUsername_1_1);
        
        txtPassword = new JPasswordField();
        txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        txtPassword.setEchoChar('*');
        txtPassword.setBounds(475, 357, 361, 39);
        contentPane.add(txtPassword);

	}


	public JTextField getTxtEmail() 
	{
		return txtEmail;
	}

	public JTextField getTxtUsername() 
	{
		return txtUsername;
	}
	public JPasswordField getTxtPassword() 
	{
		return txtPassword;
	}

	public JPasswordField getTxtConfirmPassword()
	{
		return txtConfirmPassword;
	}

	public void signUpButtonListener (ActionListener istener)
	{
		btnSignUp.addActionListener(istener);
		
	}
	public void lblLoginListenener(MouseListener listener)
	{
		lblLogin.addMouseListener(listener);
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
