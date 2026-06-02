package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import Model.dashboardModel;
import Model.forgotPasswordModel;
import Model.loginModel;
import Model.signUpModel;
import View.dashboardView;
import View.forgotPasswordView;
import View.loginView;
import View.signUpView;

public class loginController 
{
	private loginModel model;
	private loginView view;
	
	public loginController (loginModel model,loginView view)
	{
		this.model=model;
		this.view=view;
		this.view.loginButtonListener(new LoginButtonListener());
		this.view.showPasswordListener(new ShowPasswordListener());
		this.view.signUpLabelListener(new SignUpLabel());
		this.view.forgotPasswordLabelListener(new ForgetPasswordLabel() );
	}
	class LoginButtonListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent e) 
		{
			String username=view.getUsername().getText().trim();
			String password = String.valueOf(view.getPassword().getPassword()).trim();
			
			if(username.isEmpty() || password.isEmpty())
			{
				JOptionPane.showMessageDialog(view,"Please Enter Username or Password");
			}
			else 
			{
				if(model.loginUser(username, password))
				{
					JOptionPane.showMessageDialog(view, "Login Succesfull");
					view.dispose();
					
					
					dashboardModel model=new dashboardModel();
					dashboardView view=new dashboardView();
					new dashboardController(model,view);
					view.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(view, "Invalid username or password");
				}
			}
			
		
			
		}
		
	}
	
	class SignUpLabel extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			view.dispose();
			signUpModel model=new signUpModel();
			signUpView view=new signUpView();
			new signUpController(model, view);
			view.setVisible(true);
		}

	}
	
	class ForgetPasswordLabel extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			view.dispose();
			forgotPasswordModel model=new forgotPasswordModel();
			forgotPasswordView view=new forgotPasswordView();
			new forgotPasswordController(model, view);
			view.setVisible(true);
			
		}
	}
	
	class ShowPasswordListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			  if(view.isShowPasswordSelected())
		        {
		            view.getPassword().setEchoChar((char)0);
		        }
		        else
		        {
		            view.getPassword().setEchoChar('*');
		        }
		}
		
	}
	

}
