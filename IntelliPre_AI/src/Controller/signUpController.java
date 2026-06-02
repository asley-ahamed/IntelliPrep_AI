package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JOptionPane;

import Model.loginModel;
import Model.signUpModel;
import View.loginView;
import View.signUpView;

public class signUpController
{
	private signUpModel model;
	private signUpView view;
	
	public signUpController(signUpModel model,signUpView view)
	{
		this.model=model;
		this.view=view;
		this.view.signUpButtonListener(new SignUpButtonListener());
		this.view.lblLoginListenener(new lblLoginListenener() );
		this.view.showPasswordListener(new ShowPasswordListener());
	}
	
	class SignUpButtonListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				String email = view.getTxtEmail().getText().trim();
				String username = view.getTxtUsername().getText().trim();
				String password = String.valueOf(view.getTxtPassword().getPassword()).trim();
				String confirmPassword = String.valueOf(view.getTxtConfirmPassword().getPassword()).trim();
	 			
	 			if(email.isEmpty() || username.isEmpty()|| password.isEmpty()|| confirmPassword.isEmpty())
	 			{
	 				JOptionPane.showMessageDialog(view,"Please Field All fields Before SignUp");
	 			}
	 			else if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
	 			{
	 			    JOptionPane.showMessageDialog(view,"Please enter a valid email address");
	 			    
	 			}
	 			else if(!password.equals(confirmPassword))
	 			{
	 				JOptionPane.showMessageDialog(view,"Passwords do not match. Please try again");
	 			}
	 			else 
	 			{
	 				  model.setEmail(email);
	                    model.setUsername(username);
	                    model.setPassword(password);
					
					if(model.addUser())
					{
						JOptionPane.showMessageDialog(view, "Account Create Succesfully");
						view.dispose();
						loginView view=new loginView();
						loginModel model=new loginModel();
						new loginController(model, view);
					}
					else
					{
						JOptionPane.showMessageDialog(view,"Duplicate Username or Email");
					}
				}
				
			} catch (Exception e2) 
			{
				JOptionPane.showMessageDialog(view, e2);
			}
 			
 			

			
		}
	}
	class lblLoginListenener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{

			view.dispose();
			loginView view=new loginView();
			loginModel model=new loginModel();
			new loginController(model, view);
			
			view.setVisible(true);
			
			
		}
	}
	
	class ShowPasswordListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(view.isShowPasswordSelected())
			{
				view.getTxtPassword().setEchoChar((char)0);
				view.getTxtConfirmPassword().setEchoChar((char)0);
			}
			else 
			{
				view.getTxtPassword().setEchoChar('*');
				view.getTxtConfirmPassword().setEchoChar('*');
				
				
			}
		}
		
	}
	

}
