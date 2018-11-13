import java.awt.event.*;
import javax.swing.*;
public class MouseListenerExample implements MouseListener
// extends MouseAdapter
{
	JFrame frame;
	JPanel panel;
	JLabel label;
	
	public void mouseClicked(MouseEvent e)
	{
		label.setText("Mouse Clicked!");
	}
	public void mousePressed(MouseEvent e)
	{
		label.setText("Mouse Pressed!");
	}
	public void mouseReleased(MouseEvent e)
	{
		label.setText("Mouse Released!");
	}
	public void mouseEntered(MouseEvent e)
	{
		label.setText("Mouse Entered!");
	}
	public void mouseExited(MouseEvent e)
	{
		label.setText("Mouse Exited!");
	}
	MouseListenerExample()
	{
		frame = new JFrame("MouseListenerExample");
		
		panel = new JPanel();
		panel.setLayout(null);
		
		label = new JLabel();
		label.setBounds(200,200,200,50);
		
		panel.add(label);
		
		panel.addMouseListener(this);
		
		frame.add(panel);
		
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new MouseListenerExample();
	}

}
