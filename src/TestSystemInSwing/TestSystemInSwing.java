package TestSystemInSwing;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

public class TestSystemInSwing extends JFrame implements ActionListener{

	JLabel label;
    JRadioButton rdButtons[] = new JRadioButton[5];  
    JButton button1, button2;  
    ButtonGroup btGroup;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    
    TestSystemInSwing(String prgName)  
    {  
        super(prgName);  
        label = new JLabel();  
        add(label);  
        btGroup=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            rdButtons[i]=new JRadioButton();     
            add(rdButtons[i]);  
            btGroup.add(rdButtons[i]);  
        }  
        button1=new JButton("Next");  
        button2=new JButton("Bookmark");  
        button1.addActionListener(this);  
        button2.addActionListener(this);  
        add(button1);add(button2);  
        set();  
        label.setBounds(30,40,450,20);  
        rdButtons[0].setBounds(50,80,100,20);  
        rdButtons[1].setBounds(50,110,100,20);  
        rdButtons[2].setBounds(50,140,100,20);  
        rdButtons[3].setBounds(50,170,100,20);  
        button1.setBounds(100,240,100,30);  
        button2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==button1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                button1.setEnabled(false);  
                button2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                button2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    
    void set()  
    {  
        rdButtons[4].setSelected(true);  
        if(current==0)  
        {  
            label.setText("Que1: Which one among these is not a primitive datatype?");  
            rdButtons[0].setText("int");rdButtons[1].setText("Float");rdButtons[2].setText("boolean");rdButtons[3].setText("char");   
        }  
        if(current==1)  
        {  
            label.setText("Que2: Which class is available to all the class automatically?");  
            rdButtons[0].setText("Swing");rdButtons[1].setText("Applet");rdButtons[2].setText("Object");rdButtons[3].setText("ActionEvent");  
        }  
        if(current==2)  
        {  
            label.setText("Que3: Which package is directly available to our class without importing it?");  
            rdButtons[0].setText("swing");rdButtons[1].setText("applet");rdButtons[2].setText("net");rdButtons[3].setText("lang");  
        }  
        if(current==3)  
        {  
            label.setText("Que4: String class is defined in which package?");  
            rdButtons[0].setText("lang");rdButtons[1].setText("Swing");rdButtons[2].setText("Applet");rdButtons[3].setText("awt");  
        }  
        if(current==4)  
        {  
            label.setText("Que5: Which institute is best for java coaching?");  
            rdButtons[0].setText("Utek");rdButtons[1].setText("Aptech");rdButtons[2].setText("SSS IT");rdButtons[3].setText("jtek");  
        }  
        if(current==5)  
        {  
            label.setText("Que6: Which one among these is not a keyword?");  
            rdButtons[0].setText("class");rdButtons[1].setText("int");rdButtons[2].setText("get");rdButtons[3].setText("if");  
        }  
        if(current==6)  
        {  
            label.setText("Que7: Which one among these is not a class? ");  
            rdButtons[0].setText("Swing");rdButtons[1].setText("Actionperformed");rdButtons[2].setText("ActionEvent");  
                        rdButtons[3].setText("Button");  
        }  
        if(current==7)  
        {  
            label.setText("Que8: which one among these is not a function of Object class?");  
            rdButtons[0].setText("toString");rdButtons[1].setText("finalize");rdButtons[2].setText("equals");  
                        rdButtons[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            label.setText("Que9: which function is not present in Applet class?");  
            rdButtons[0].setText("init");rdButtons[1].setText("main");rdButtons[2].setText("start");rdButtons[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            label.setText("Que10: Which one among these is not a valid component?");  
            rdButtons[0].setText("JButton");rdButtons[1].setText("JList");rdButtons[2].setText("JButtonGroup");  
                        rdButtons[3].setText("JTextArea");  
        }  
        label.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            rdButtons[j].setBounds(50,80+i,200,20);  
    }  
    
    boolean check()  
    {  
        if(current==0)  
            return(rdButtons[1].isSelected());  
        if(current==1)  
            return(rdButtons[2].isSelected());  
        if(current==2)  
            return(rdButtons[3].isSelected());  
        if(current==3)  
            return(rdButtons[0].isSelected());  
        if(current==4)  
            return(rdButtons[2].isSelected());  
        if(current==5)  
            return(rdButtons[2].isSelected());  
        if(current==6)  
            return(rdButtons[1].isSelected());  
        if(current==7)  
            return(rdButtons[3].isSelected());  
        if(current==8)  
            return(rdButtons[1].isSelected());  
        if(current==9)  
            return(rdButtons[2].isSelected());  
        return false;  
    }  
    
    public static void main(String args[]) {
		new TestSystemInSwing("Online Test Of Java");  
	}

}
