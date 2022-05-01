import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class RatRod extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    RatRod(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Mark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Mark"))  
        {  
            JButton bk=new JButton("Mark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Mark"+y))  
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
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Question 1: Which of the following car is Mushtang?");  
            jb[0].setText("Chevy");jb[1].setText("Mach 1");jb[2].setText("Raptor");jb[3].setText("cobra");   
        }  
        if(current==1)  
        {  
            l.setText("Question 2: Name the creator of chrome?");  
            jb[0].setText("Lary Page");jb[1].setText("Sundip Chandra");jb[2].setText("Sundar Pichi");jb[3].setText("Colondo Ran");  
        }  
        if(current==2)  
        {  
            l.setText("Question 3: Which package is directly available to our class without importing it?");  
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");  
        }  
        if(current==3)  
        {  
            l.setText("Question 4: Who is the founder of Tesla?");  
            jb[0].setText("Elon Musk");jb[1].setText("Sundar Pichi");jb[2].setText("Tom Crusie");jb[3].setText("Bill Gate");  
        }  
        if(current==4)  
        {  
            l.setText("Question 5: Who has make Java?");  
            jb[0].setText("Ipc Of Israel");jb[1].setText("Bill Gate");jb[2].setText("James Gosling");jb[3].setText("or no ne");  
        }  
        if(current==5)  
        {  
            l.setText("Question 6: Which one among these is not a keyword?");  
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Question 7: Which car company is not Europian car company ");  
            jb[0].setText("Hyndai");jb[1].setText("Ford");jb[2].setText("Chevyrolet");jb[3].setText("Korenxig");  
        }  
        if(current==7)  
        {  
            l.setText("Question 8: World best Martial Artist?");  
            jb[0].setText("Tony Jaa");jb[1].setText("Vidyut Jammwal");jb[2].setText("Ip Man"); jb[3].setText("Bruce Lee");         
        }  
        if(current==8)  
        {  
            l.setText("Question 9: Who is the best boxer of this world?");  
            jb[0].setText("Mike Tyson");jb[1].setText("Muhummad Ali");jb[2].setText("Bogeyman");jb[3].setText("Joe Nevara");  
        }  
        if(current==9)  
        {  
            l.setText("Question 10: Who has created Jeet Kuan Do?");  
            jb[0].setText("Israel Defence team");jb[1].setText("Doug Marcaida");jb[2].setText("Bruce Lee");  
                        jb[3].setText("or non of this");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new RatRod("Online Test Of Java");  
    }  
}  