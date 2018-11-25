package stringcompare;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**
 *
 * @author Rohit
 */
public class Comparison implements ActionListener
{
    JFrame frame;
    JPanel panel;
    JLabel label1, label2, label3, result;
    JTextArea str1, str2;
    JButton cmp, swap;
    @SuppressWarnings("LeakingThisInConstructor")
    Comparison()
    {
        frame = new JFrame("String Matcher");
        frame.setSize(400, 400);
        frame.setResizable(false);
        
        panel = new JPanel();
        panel.setLayout(null);
        
        label1 = new JLabel("STRING COMPARISON");
        label1.setBounds(140, 50, 150, 50);
        
        label2 = new JLabel("Enter 1st String: ");
        label2.setBounds(30, 120, 100, 20);
        
        str1 = new JTextArea();
        str1.setBorder(BorderFactory.createLineBorder(Color.blue));
        str1.setBounds(140, 120, 200, 25);
        
        label3 = new JLabel("Enter 2nd String: ");
        label3.setBounds(30, 160, 100, 20);
        
        str2 = new JTextArea();
        str2.setBorder(BorderFactory.createLineBorder(Color.blue));
        str2.setBounds(140, 160, 200, 25);
        
        cmp = new JButton("COMPARE");
        cmp.setBounds(100, 230, 100, 30);
        
        swap = new JButton("SWAP");
        swap.setBounds(210, 230, 100, 30);
        
        result = new JLabel();
        result.setBounds(30, 270, 350, 50);
        
        cmp.addActionListener(this);
        
        swap.addActionListener
        ((ActionEvent e) -> {
            String a, b;
            a = str1.getText();
            b = str2.getText();
            str1.setText(b);
            str2.setText(a);
        });
        
        panel.add(label1);
        panel.add(label2);
        panel.add(str1);
        panel.add(label3);
        panel.add(str2);
        panel.add(cmp);
        panel.add(swap);
        panel.add(result);
        
        frame.add(panel);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if( ae.getSource() == cmp )
        {
            String one, two;
            one = str1.getText();
            two = str2.getText();
            if( one.trim().equals("") && two.trim().equals(""))
            {
                result.setText("Please enter something!");
            }
            else
            {
                if(one.equalsIgnoreCase(two))
                {
                    result.setText("The strings are identical!");
                }
                else
                {
                    if ( one.contains(two) )
                    {
                        result.setText("Second string is a substring of first string!");
                    }
                    else if ( two.contains(one))
                    {
                        result.setText("First string is a substring of second string!");
                    } 
                    else
                    {
                        int i;
                        for( i = 0; i < one.length() && i < two.length(); ++i)
                            if( one.charAt(i) != two.charAt(i))
                                break;
                        result.setText("First index of difference found at position "+i+".");
                    }
                }
            }
        }
    }
}
