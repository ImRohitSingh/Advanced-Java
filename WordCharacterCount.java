import java.awt.event.*;
import javax.swing.*;

public class WordCharacterCount implements ActionListener 
{
	JTextArea text;
	
	public void actionPerformed(ActionEvent e)
	{
		text.setText("");
	}
	
	WordCharacterCount()
	{
		JFrame frame = new JFrame("Word and Character Count"); // creating reference to a frame
		frame.setSize(500, 500); // set size
		frame.setResizable(false); // don't allow user to resize the frame
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("Number of Word(s): ");
		JLabel label2 = new JLabel("Number of Character(s): ");
		label1.setBounds(20,50,150,20);
		label2.setBounds(260,50,180,20);
		
		text = new JTextArea("");
		text.setBounds(20,80,450,250);
		
		JButton button = new JButton("COUNT");
		button.setBounds(100,360,100,30);
		
		JButton cButton = new JButton("CLEAR");
		cButton.setBounds(300,360,100,30);
		//text.setEditable(true); // by default this statement is here
		
		button.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String enteredText = text.getText();
						String linesInText[] = enteredText.split("\n");
						String wordsInText[];
						int wordCount = 0;
						// count words
						for(String temp : linesInText)
						{
							wordsInText = temp.split(" ");
							for(String word: wordsInText)
								if(word.length() > 0)
									++wordCount;
						}
						label1.setText("Number of Word(s): "+wordCount);
						label2.setText("Number of Character(s): "+enteredText.length());
					}
				}
		);
		
		cButton.addActionListener(this);
		
		// add components to the panel
		panel.add(label1);
		panel.add(label2);
		panel.add(text);
		panel.add(button);
		panel.add(cButton);
		
		// add components to the frame
		frame.add(panel);
		
		frame.setVisible(true); // make the frame visible when the program gets executed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate the program on closing the frame
	}
}
