import java.awt.event.*;
import javax.swing.*;
public class RadioButtons implements ActionListener 
{
	JRadioButton r1,r2;
	JFrame newFrame = new JFrame();
	
	public void actionPerformed(ActionEvent e)
	{
		if( e.getSource() == r1)
			JOptionPane.showMessageDialog(newFrame, "You are a male!");
		if( e.getSource() == r2)
			JOptionPane.showMessageDialog(newFrame, "You are a female!");
	}
	
	RadioButtons()
	{
		JFrame frame = new JFrame("Choose your gender");
		frame.setSize(400,400);
		frame.setResizable(false);
		frame.setLayout(null);
		
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		r1.setBounds(90,100,100,20);
		r2.setBounds(90,150,100,20);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		r1.addActionListener(this);
		r2.addActionListener(this);
		
		frame.add(r1);
		frame.add(r2);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new RadioButtons();
	}

}
