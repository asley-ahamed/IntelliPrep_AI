package View;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	private Image image;
	
	public ImagePanel(String imagePath)
	{
		try
		{
			image=new ImageIcon(getClass().getResource(imagePath)
					).getImage();
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		setOpaque(false);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(image!=null)
		{
			  Graphics2D g2 = (Graphics2D) g;

	            g2.setRenderingHint(
	                    RenderingHints.KEY_INTERPOLATION,
	                    RenderingHints.VALUE_INTERPOLATION_BICUBIC
	            );

	            g2.drawImage(
	                    image,
	                    0,
	                    0,
	                    getWidth(),
	                    getHeight(),
	                    this
	            );
		}
	}

}
