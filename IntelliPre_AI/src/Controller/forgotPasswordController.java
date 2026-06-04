package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Model.forgotPasswordModel;
import Model.loginModel;

import View.forgotPasswordView;
import View.loginView;
import utility.EmailSender;
import utility.OTPGenerator;

public class forgotPasswordController
{
    private forgotPasswordModel model;
    private forgotPasswordView view;

    public forgotPasswordController(forgotPasswordModel model, forgotPasswordView view)
    {
        this.model = model;
        this.view = view;

        this.view.sendOtpButtonListener(new SendOtpButtonListener());
        this.view.verifyOtpButtonListener(new VerifyOtpButtonListener());
        this.view.updatePasswordButtonListener(new UpdatePasswordButtonListener());
        this.view.goToLoginButtonListener(new GoToLoginButtonListener());
        this.view.backToLoginEmailListener(new BackToLoginListener());
        this.view.backToLoginPasswordListener(new BackToLoginListener());
        this.view.backToEmailListener(new BackToEmailListener());
    }

    class SendOtpButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String email = view.getEmail().getText().trim();

            if(email.isEmpty())
            {
                JOptionPane.showMessageDialog(view, "Please Enter Email");
                return;
            }

            int userId = model.getUserIdByEmail(email);

            if(userId == 0)
            {
                JOptionPane.showMessageDialog(view, "Email Not Found");
                return;
            }

            String otp = OTPGenerator.generateOTP();

            if(model.saveOtp(userId, otp))
            {
                boolean sent = EmailSender.sendOTP(email, otp);

                if(sent)
                {
                    view.setCurrentUserId(userId);
                    view.setOtpEmailText(email);
                    view.showOtpPanel();
                    JOptionPane.showMessageDialog(view, "OTP Sent Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(view, "OTP Saved, But Email Sending Failed");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(view, "OTP Save Failed");
            }
        }
    }

    class VerifyOtpButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String otp = view.getOtp().getText().trim();

            if(otp.isEmpty())
            {
                JOptionPane.showMessageDialog(view, "Please Enter OTP");
                return;
            }

            if(model.verifyOtp(view.getCurrentUserId(), otp))
            {
                view.showNewPasswordPanel();
            }
            else
            {
                JOptionPane.showMessageDialog(view, "Invalid Or Expired OTP");
            }
        }
    }

    class UpdatePasswordButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String newPassword = String.valueOf(view.getNewPassword().getPassword()).trim();
            String confirmPassword = String.valueOf(view.getConfirmPassword().getPassword()).trim();

            if(newPassword.isEmpty() || confirmPassword.isEmpty())
            {
                JOptionPane.showMessageDialog(view, "Please Fill All Fields");
                return;
            }

            if(!newPassword.equals(confirmPassword))
            {
                JOptionPane.showMessageDialog(view, "Passwords Do Not Match");
                return;
            }

            if(model.updatePassword(view.getCurrentUserId(), newPassword))
            {
                view.showSuccessPanel();
            }
            else
            {
                JOptionPane.showMessageDialog(view, "Password Update Failed");
            }
        }
    }

    class GoToLoginButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            openLogin();
        }
    }

    class BackToLoginListener extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            openLogin();
        }
    }

    class BackToEmailListener extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            view.showEmailPanel();
        }
    }

    private void openLogin()
    {
        view.dispose();
        loginModel model = new loginModel();
        loginView view = new loginView();
        new loginController(model, view);
        view.setVisible(true);
    }
}
