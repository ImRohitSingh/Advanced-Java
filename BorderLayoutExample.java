import java.awt.*;
import javax.swing.*;
public class BorderLayoutExample
{
	BorderLayoutExample()
	{
		JFrame frame = new JFrame("Border Layout");
		frame.setSize(400, 400);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(2,2));
		
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		JButton b5 = new JButton("Button 5");
		
		b1.setBorder(BorderFactory.createLineBorder(Color.red));
		b2.setBorder(BorderFactory.createLineBorder(Color.red));
		b3.setBorder(BorderFactory.createLineBorder(Color.red));
		b4.setBorder(BorderFactory.createLineBorder(Color.red));
		b5.setBorder(BorderFactory.createLineBorder(Color.red));
		
		panel.add(b1, BorderLayout.NORTH);
		panel.add(b5, BorderLayout.SOUTH);
		panel.add(b2, BorderLayout.WEST);
		panel.add(b4, BorderLayout.EAST);
		panel.add(b3, BorderLayout.CENTER);
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new BorderLayoutExample();
	}

}
