import java.awt.*;
import javax.swing.*;
public class GridLayoutExample 
{
	GridLayoutExample()
	{
		JFrame frame = new JFrame("Grid Layout");
		frame.setSize(400, 400);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,3,4,4));
		
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		JButton b5 = new JButton("Button 5");
		JButton b6 = new JButton("Button 6");
		
		b1.setBorder(BorderFactory.createLineBorder(Color.red));
		b2.setBorder(BorderFactory.createLineBorder(Color.red));
		b3.setBorder(BorderFactory.createLineBorder(Color.red));
		b4.setBorder(BorderFactory.createLineBorder(Color.red));
		b5.setBorder(BorderFactory.createLineBorder(Color.red));
		b6.setBorder(BorderFactory.createLineBorder(Color.red));
		
		panel.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new GridLayoutExample();
	}

}
