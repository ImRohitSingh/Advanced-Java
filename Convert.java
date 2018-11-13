import java.awt.event.*;
import javax.swing.*;
public class Convert 
{
	Convert()
	{
		// Frame
		JFrame frame = new JFrame("Temperature Convertor"); // create reference of the frame
		frame.setSize(400, 400); // set size of the frame
		frame.setResizable(false); // size of the frame cannot be changed
		// Panel
		JPanel panel = new JPanel(); // create reference of the panel
		panel.setLayout(null); 
		
		JLabel label1 = new JLabel("Enter Temperature: ");
		label1.setBounds(70, 30, 150, 50);
		
		JTextArea text = new JTextArea("");
		text.setBounds(220, 30, 100, 50);
		
		JLabel label2 = new JLabel("Convert into: ");
		label2.setBounds(150, 130, 120, 30);
		
		JRadioButton radio1 = new JRadioButton("Farenheit",true); // choose Farenheit by default
		JRadioButton radio2 = new JRadioButton("Celsius");
		radio1.setBounds(150, 160, 100, 20);
		radio2.setBounds(150, 180, 100, 20);
		
		ButtonGroup bg = new ButtonGroup(); // to enable choosing only one radio button
		
		JButton button = new JButton("CONVERT");
		button.setBounds(150, 230, 100, 20);
		
		JLabel label3 = new JLabel("");
		label3.setBounds(70, 280, 250,50);
		
		// the anonymous event
		button.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							double temp = Double.parseDouble(text.getText());
							double result;
							if(radio1.isSelected())
							{
								result = 9.0/5*temp + 32;
								label3.setText("The temperature in Farenheit = "+result);
							}
							else if(radio2.isSelected())
							{
								result = 5.0/9 * (temp - 32);
								label3.setText("The temperature in Farenheit = "+result);
							}
						}
						catch(NumberFormatException nfe)
						{
							JFrame newFrame = new JFrame();
							JOptionPane.showMessageDialog(newFrame, "Please enter a number!");
						}
					}
				}
		);
		
		
		// adding components to the button group
		bg.add(radio1);
		bg.add(radio2);
		
		// adding components to the panel
		panel.add(label1);
		panel.add(text);
		panel.add(label2);
		panel.add(radio1);
		panel.add(radio2);
		panel.add(button);
		panel.add(label3);
		
		// adding component(s) to the frame
		frame.add(panel); // add the panel to the frame
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to terminate the program on closing the frame
		frame.setVisible(true); // to make the frame visible
	}
}
