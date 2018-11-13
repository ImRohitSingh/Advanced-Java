import javax.swing.*;
public class MenuExample 
{
	JFrame frame;
	JMenuBar mb;
	JMenu file, edit, saving;
	JMenuItem open, close, save, saveAs, cut, copy, paste; 
	MenuExample()
	{
		frame = new JFrame("Menu");
		// menu bar
		mb = new JMenuBar();
		// menus
		file = new JMenu("File");
		edit = new JMenu("Edit");
		saving = new JMenu("Save");
		
		// menu items
		open = new JMenuItem("Open");
		close = new JMenuItem("Close");
		
		file.add(open);
		file.add(close);
		
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy"); 
		paste = new JMenuItem("Paste");
		
		edit.add(copy);
		edit.add(paste);
		edit.add(cut);
		
		save = new JMenuItem("Save");
		saveAs = new JMenuItem("Save As");
		
		saving.add(save);
		saving.add(saveAs);
		
		file.add(saving);
		
		// adding componentes to menu bar
		mb.add(file);
		mb.add(edit);
		
		// adding components to frame
		frame.setJMenuBar(mb);
		
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new MenuExample(); 
	}

}
