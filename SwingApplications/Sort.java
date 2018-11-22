import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.StringTokenizer;

public class Sort implements ActionListener 
{
	JFrame frame;
	JPanel panel;
	JButton add, sort;
	JLabel labelSet, labelEntry;
	JTextArea dataSet, entrySet;
	String textStr = "Data set empty!", toWork;
	
	Sort()
	{
		frame = new JFrame("Sorting App");
		frame.setSize(400, 400);
		frame.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		labelSet = new JLabel();
		labelSet.setText("DATA SET: ");
		labelSet.setBounds(40, 100, 100, 50);
		
		dataSet = new JTextArea(textStr);
		dataSet.setEditable(false);
		dataSet.setBounds(110, 100, 250, 50);
		
		labelEntry = new JLabel();
		labelEntry.setText("Enter number to add: ");
		labelEntry.setBounds(40, 180, 150, 50);
		
		entrySet = new JTextArea("");
		entrySet.setBounds(200, 190, 80, 40);
		entrySet.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		add = new JButton("ADD");
		add.setBounds(80, 280, 100, 40);
		sort = new JButton("SORT");
		sort.setBounds(200, 280, 100, 40);
		
		add.addActionListener(this);
		sort.addActionListener(this);
		
		panel.add(dataSet);
		panel.add(labelSet);
		panel.add(labelEntry);
		panel.add(entrySet);
		panel.add(add);
		panel.add(sort);
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if ( ae.getSource() == add)
		{
			int entered;
			toWork = entrySet.getText();
			try
			{
				entered = Integer.parseInt(toWork);
				if( dataSet.getText().equals(textStr) )
					dataSet.setText(entered+" ");
				else
					dataSet.setText(dataSet.getText()+entered+" ");
				JOptionPane.showMessageDialog(new JFrame(),entered+" successfully added!");
			}
			catch(NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(new JFrame(),"Please enter integer values only!");
			}
		
		}
		if ( ae.getSource() == sort)
		{
			int num[], count = 0, i, j, temp;
			String etc = "";
			toWork = dataSet.getText();
			if( ! (toWork.equals(textStr)) )
			{
				StringTokenizer st = new StringTokenizer(toWork," ");
				while(st.hasMoreTokens())
				{
					etc = st.nextToken();
					++count;
				}
			
				num = new int[count];
				count = 0;
				st = new StringTokenizer(toWork, " ");
				while(st.hasMoreTokens())
				{
					try
					{
						num[count] = Integer.parseInt(st.nextToken());
						++count;
					}
					catch(NumberFormatException nfe)
					{
						
					}
				}
				for( i = 1; i < num.length; ++i )
				{
					temp = num[i];
					for( j = i-1; j>=0 && num[j]>temp; --j )
						num[j+1] = num[j];
					num[j+1] = temp;
				}
				toWork = "";
				for( i = 0; i < num.length; ++i )
					toWork = toWork + num[i]+ " ";
				
				dataSet.setText(toWork);
				
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Data Set Empty!");
		}
	}
}
