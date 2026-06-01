package Main;

import Controller.loginController;
import Model.loginModel;
import View.loginView;

public class Main 
{
	public static void main(String[] args)
	{
		loginModel model=new loginModel();
		loginView view=new loginView();
		new loginController(model,view);
		view.setVisible(true);
	 
	}

}
