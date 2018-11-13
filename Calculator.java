import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator implements ActionListener
{
	JFrame frame;
	JPanel panel;
	JButton b1, b2;
	JTextArea inp1, inp2, result;
	
	public void actionPerformed(ActionEvent e)
	{
		String s1 = inp1.getText();
		String s2 = inp2.getText();
		
		try
		{
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			double res = 0.0;
			if( e.getSource() == b1)
				res = d1 + d2;
			else if( e.getSource() == b2)
				res = d1 - d2;
			
			result.setText(res+"");
		}	
		catch(NumberFormatException nfe)
		{
			JFrame newFrame = new JFrame();
			JOptionPane.showMessageDialog(newFrame, "Please enter numeric values only!");
		}
	}
	
	Calculator()
	{
		frame = new JFrame("Basic Calculator");
		
		panel = new JPanel();
		panel.setLayout(null);
		
		inp1 = new JTextArea("");
		inp2 = new JTextArea("");
		
		result = new JTextArea("");
		result.setEditable(false);
		
		b1 = new JButton(new ImageIcon("F:\\Heritage\\5th Sem Edu\\Advanced Java\\Lab Solutions\\Swing\\plus.png"));
		b2 = new JButton(new ImageIcon("F:\\Heritage\\5th Sem Edu\\Advanced Java\\Lab Solutions\\Swing\\minus.png"));
		
		inp1.setBounds(30, 50, 430, 20);
		inp2.setBounds(30, 100, 430, 20);
		result.setBounds(30, 150, 430, 20);
		b1.setBounds(110, 180, 60, 60);
		b2.setBounds(270, 180, 60, 60);
		
		inp1.setBorder(BorderFactory.createLineBorder(Color.RED));
		inp2.setBorder(BorderFactory.createLineBorder(Color.RED));
		result.setBorder(BorderFactory.createDashedBorder(Color.BLUE));
		
		panel.add(inp1);
		panel.add(inp2);
		panel.add(result);
		panel.add(b1);
		panel.add(b2);
		
		frame.add(panel);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
