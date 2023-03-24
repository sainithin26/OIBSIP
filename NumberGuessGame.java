package guessingnumber;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class MyFrame extends JFrame implements ActionListener
{
    JLabel title,str,str2,cou,hint,score1,score2;
    TextField tf;
    JButton click;
    int i,count=10;
    
    public MyFrame()
    {
        super("Number Guessing Game");
        
        setLayout(null);
        
        Random r=new Random();
        
        i=r.nextInt(100);
        
        title=new JLabel("NUMBER GUESSING GAME");
        title.setBounds(400, 50, 800,50);
        Font f=new Font("Serif",Font.BOLD,40);
        title.setFont(f);
        
        str=new JLabel("Enter Any Number");
        str.setBounds(350, 350,270,50);
        Font f1=new Font("Serif",Font.BOLD,30);
        str.setFont(f1);
        
        str2=new JLabel("(0-100)");
        str2.setBounds(400, 380,200,50);
        str2.setFont(f1);
        
        tf=new TextField();
        tf.setBounds(630,360,150,50);
        Font f2=new Font("Serif",Font.BOLD,30);
        tf.setFont(f2);
        
        cou=new JLabel("You have "+count+" attempts");
        cou.setBounds(450, 200,500,50);
        cou.setFont(f1);
        
        hint=new JLabel("");
        hint.setBounds(550,500,500,50);
        hint.setFont(f1);
        
        click=new JButton("Check");
        click.setBounds(820, 360,150,50);
        click.setFont(f1);
        click.addActionListener(this);
        
        add(title);
        add(str);
        add(tf);
        add(str2);
        add(cou);
        add(click);
        add(hint);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String load=tf.getText();
        if(load.isEmpty())
            JOptionPane.showMessageDialog(null, "enter anything to check", "warning", JOptionPane.INFORMATION_MESSAGE);
        else
        {
            int z=1;
            try
            {
                String load1=tf.getText();
                int k=Integer.valueOf(load1);
        
                if(k>100 || k<0)
                {
                    JOptionPane.showMessageDialog(null, "Enter between 0 to 100");
                    z=0;
                }
            }  
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Enter a valid input");
                z=0;
            }
            if(z==1)
                cal();
        }
        tf.setText("");
    }
    public void cal()
    {
        String load1=tf.getText();
        int k=Integer.valueOf(load1);
        if(count>0)
        {
            if(i>k)
            {
                hint.setText("Hint:Entered number is LOWER");
                count--;
                cou.setText("You have "+count+" attempts left");
                if(count==0)
                    JOptionPane.showMessageDialog(null, "No.of attempts = "+(10-count)+"\n\nScore = "+count);
            }
            else if(i<k)
            {
                hint.setText("Hint:Entered number is HIGHER");
                count--;
                cou.setText("You have "+count+" attempts left");
                if(count==0)
                    JOptionPane.showMessageDialog(null, "No.of attempts = "+(10-count)+"\n\nScore = "+count);
            }
            else
            {
                if(i==k)
                {
                    hint.setText("S U C C E S S!");
                    JOptionPane.showMessageDialog(null, "No.of attempts = "+(10-count)+"\n\nScore = "+count);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You are Out of Chances");
        }
    }
}

public class GuessingNumber {

    public static void main(String[] args) {
        MyFrame f=new MyFrame();
        
        f.setVisible(true);
        f.setSize(4000, 4000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
