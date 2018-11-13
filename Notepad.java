import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class Notepad implements ActionListener
{
	JFrame frame;
	JMenuBar mb;
	JMenu edit, help, paste;
	JTextArea text;
	JMenuItem copy, cut, pasteHere, pasteEnd, selectAll, clear, about;
	
	public void actionPerformed(ActionEvent ae)
	{
		JFrame nFrame = new JFrame();
		if( ae.getSource() == copy )
		{
			text.copy();
			JOptionPane.showMessageDialog(nFrame, "Copied to Clipboard");
		}
		if( ae.getSource() == cut )
		{
			text.cut();
			JOptionPane.showMessageDialog(nFrame, "Cut to Clipboard");
		}
		if( ae.getSource() == pasteHere )
			text.paste();
		if( ae.getSource() == pasteEnd )
		{
			String currentText = text.getText(); // extract the text in the editor
			text.setText(""); // empty the editor
			text.paste();  // paste the content of the selected text in the editor
			String clipboardText = text.getText(); // extract the selected text
			text.setText(currentText+clipboardText); // concatenate them and display
		}
		if( ae.getSource() == selectAll )
			text.selectAll();
		if( ae.getSource() == clear )
		{
			text.setText("");
			JOptionPane.showMessageDialog(nFrame, "Editor Cleared");
		}
		if( ae.getSource() == about )
			JOptionPane.showMessageDialog(nFrame, "Rohit's Text Editor\nVerion 1.0\nRelease 2018");
	}
	
	Notepad()
	{
		frame = new JFrame("My Text Editor");
			text = new JTextArea();
			text.setBounds(20,20,440,400);
			text.setBorder(BorderFactory.createDashedBorder(Color.BLUE));
			text.setLineWrap(true);
			
			mb = new JMenuBar();
				edit = new JMenu("Edit");
					copy = new JMenuItem("Copy");
					cut = new JMenuItem("Cut");
					paste = new JMenu("Paste");
						pasteHere = new JMenuItem("Paste at Cursor");
						pasteEnd = new JMenuItem("Paste at End");
					
					paste.add(pasteHere);
					paste.add(pasteEnd);
				
					selectAll = new JMenuItem("Select All");
					clear = new JMenuItem("Clear");
					
				edit.add(copy);
				edit.add(cut);
				edit.add(paste);
				edit.add(selectAll);
				edit.add(clear);
				
				help = new JMenu("Help");
					about = new JMenuItem("About the Editor");
					
				help.add(about);
				
			mb.add(edit);
			mb.add(help);
		
		frame.add(text);
		frame.add(mb);
		frame.setJMenuBar(mb);
		
		copy.addActionListener(this);
		cut.addActionListener(this);
		pasteHere.addActionListener(this);
		pasteEnd.addActionListener(this);
		selectAll.addActionListener(this);
		clear.addActionListener(this);
		about.addActionListener(this);
		
		frame.setSize( 500, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new Notepad();
	}

}
