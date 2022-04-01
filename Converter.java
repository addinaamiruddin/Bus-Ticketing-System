import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.DecimalFormat;

public class Converter extends JFrame implements ActionListener 
{
    //variables declaration 
    private JLabel text1,text2,text3,text4,text5,img;
    private JComboBox input,output;
    private JTextField inAmount,outAmount;
    private JButton btn1,btn2;
    private JPanel p1,p2,p3,p4,p5,p6,p7,p8;
    
    ImageIcon icon = new ImageIcon(getClass().getResource("calculator.png"));
    
    public static void main(String []args)
    {
        Converter cvt = new Converter("Currency Converter");
        cvt.setSize(350,450);
        cvt.setVisible(true);
        cvt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public Converter(String t)
    {
        setTitle(t);
        setLayout(new FlowLayout());
        
        //title
        text1 = new JLabel("Currency converter");
        text1.setFont(new Font("Lucida Handwriting",Font.BOLD,18));
        
        text2 = new JLabel("Select the input currency:");
        text2.setFont(new Font("Kanit",Font.PLAIN,14));
        //there are 6 currencies that can be converted
        String []inputCurrency = {"Malaysia (MYR)", "Singapore Dollar", "Indonesia (Rupiah)", "Thailand (Bhat)", 
                                  "India (Rupee)", "Vietnam"};
        input = new JComboBox(inputCurrency);
        input.setSelectedIndex(0);
        input.setFont(new Font("Kanit",Font.PLAIN,14));
        input.setBackground(Color.WHITE);
        
        text3 = new JLabel("Enter the amount:");
        text3.setFont(new Font("Kanit",Font.PLAIN,14));
        //insert amount to be converted
        inAmount = new JTextField(10);
        inAmount.setFont(new Font("Kanit",Font.PLAIN,14));
        
        text4 = new JLabel("Select the output currency:");
        text4.setFont(new Font("Kanit",Font.PLAIN,14));
       //can be converted into 8 different currencies
        String []outputCurrency = {"USD (US Dollar)", "British Pound", "Euro", "Australian Dollar", "China (RMB)", 
                                   "Japan (Yen)", "Korea (Won)", "Taiwan Dollar"};
        output = new JComboBox(outputCurrency);
        output.setSelectedIndex(1);
        output.setFont(new Font("Kanit",Font.PLAIN,14));
        output.setBackground(Color.WHITE);
        
        btn1 = new JButton("Convert");
        btn1.setFont(new Font("Kanit",Font.PLAIN,14));
        btn1.setBackground(Color.cyan);
        text5 = new JLabel("Converted amount:");
        text5.setFont(new Font("Kanit",Font.PLAIN,14));
        text5.setForeground(Color.blue);
        //display the converted amount
        outAmount = new JTextField(10);
        outAmount.setEditable(false);
        outAmount.setFont(new Font("Kanit",Font.PLAIN,14));
        
        //button to clear the "outAmount" textfield
        btn2 = new JButton("Clear");
        btn2.setFont(new Font("Kanit",Font.PLAIN,14));
        btn2.setBackground(Color.cyan);
        
        img = new JLabel(icon);
        
        p1 = new JPanel();
        p1.add(text1);
        
        p2 = new JPanel();
        p2.add(text2);
        p2.add(input);
        
        p3 = new JPanel();
        p3.add(text3);
        p3.add(inAmount);
        
        p4 = new JPanel();
        p4.add(text4);
        p4.add(output);
        
        p5 = new JPanel();
        p5.add(btn1);
        
        p6 = new JPanel();
        p6.add(text5);
        p6.add(outAmount);
        
        p7 = new JPanel();
        p7.add(btn2);
        
        p8 = new JPanel();
        p8.add(img);
        
        add(p8);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        
        input.addActionListener(this);
        inAmount.addActionListener(this);
        output.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        outAmount.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        double total = 0;
        double b = Double.parseDouble(inAmount.getText()); 
        
        //Malaysia (MYR) --> USD (US Dollar)
        if(input.getSelectedIndex()==0 && output.getSelectedIndex()==0)
            total = b * 0.24;
        //Malaysia (MYR) --> British Pound
        else if(input.getSelectedIndex()==0 && output.getSelectedIndex()==1)
            total = b * 0.18;
        //Malaysia (MYR) --> Euro
        else if(input.getSelectedIndex()==0 && output.getSelectedIndex()==2)
            total = b * 0.22;
        //Malaysia (MYR) --> Australian Dollar
        else if(input.getSelectedIndex()==0 && output.getSelectedIndex()==3)
            total = b * 0.32;
        //Malaysia (MYR) --> China (RMB)
        else if(input.getSelectedIndex()==0 && output.getSelectedIndex()==4)
            total = b * 1.51;
        //Malaysia (MYR) --> Japan (Yen)
        else if(input.getSelectedIndex()==0 && output.getSelectedIndex()==5)
            total = b * 28.83;
        //Malaysia (MYR) --> Korea (Won)
        else if(input.getSelectedIndex()==0 && output.getSelectedIndex()==6)
            total = b * 289.31;
        //Malaysia (MYR) --> Taiwan Dollar
        else if(input.getSelectedIndex()==0 && output.getSelectedIndex()==7)
            total = b * 6.80;
        //Singapore Dollar --> USD (US Dollar)
        else if(input.getSelectedIndex()==1 && output.getSelectedIndex()==0)
            total = b * 0.7374; 
        //Singapore Dollar --> British Pound
        else if(input.getSelectedIndex()==1 && output.getSelectedIndex()==1)
            total = b * 0.5583; 
        //Singapore Dollar --> Euro
        else if(input.getSelectedIndex()==1 && output.getSelectedIndex()==2)
            total = b * 0.6691; 
        //Singapore Dollar --> Australian Dollar
        else if(input.getSelectedIndex()==1 && output.getSelectedIndex()==3)
            total = b * 0.97; 
        //Singapore Dollar --> China (RMB)
        else if(input.getSelectedIndex()==1 && output.getSelectedIndex()==4)
            total = b * 4.69; 
        //Singapore Dollar --> Japan (Yen)
        else if(input.getSelectedIndex()==1 && output.getSelectedIndex()==5)
            total = b * 89.87; 
        //Singapore Dollar --> Korea (Won)
        else if(input.getSelectedIndex()==1 && output.getSelectedIndex()==6)
            total = b * 899.296; 
        //Singapore Dollar --> Taiwan Dollar
        else if(input.getSelectedIndex()==1 && output.getSelectedIndex()==7)
            total = b * 21.11;
        //Indonesia (Rupiah) --> USD (US Dollar)
        else if(input.getSelectedIndex()==2 && output.getSelectedIndex()==0)
            total = b * 0.000069; 
        //Indonesia (Rupiah) --> British Pound
        else if(input.getSelectedIndex()==2 && output.getSelectedIndex()==1)
            total = b * 0.00005; 
        //Indonesia (Rupiah) --> Euro
        else if(input.getSelectedIndex()==2 && output.getSelectedIndex()==2)
            total = b * 0.00006; 
        //Indonesia (Rupiah) --> Australian Dollar
        else if(input.getSelectedIndex()==2 && output.getSelectedIndex()==3)
            total = b * 0.00009; 
        //Indonesia (Rupiah) --> China (RMB)
        else if(input.getSelectedIndex()==2 && output.getSelectedIndex()==4)
            total = b * 0.0004; 
        //Indonesia (Rupiah) --> Japan (Yen)
        else if(input.getSelectedIndex()==2 && output.getSelectedIndex()==5)
            total = b * 0.008; 
        //Indonesia (Rupiah) --> Korea (Won)
        else if(input.getSelectedIndex()==2 && output.getSelectedIndex()==6)
            total = b * 0.085; 
        //Indonesia (Rupiah) --> Taiwan Dollar
        else if(input.getSelectedIndex()==2 && output.getSelectedIndex()==7)
            total = b * 0.002; 
        //Thailand (Bhat) --> USD (US Dollar)
        else if(input.getSelectedIndex()==3 && output.getSelectedIndex()==0)
            total = b * 0.0298; 
        //Thailand (Bhat) --> British Pound
        else if(input.getSelectedIndex()==3 && output.getSelectedIndex()==1)
            total = b * 0.0226; 
        //Thailand (Bhat) --> Euro
        else if(input.getSelectedIndex()==3 && output.getSelectedIndex()==2)
            total = b * 0.027; 
        //Thailand (Bhat) --> Australian Dollar
        else if(input.getSelectedIndex()==3 && output.getSelectedIndex()==3)
            total = b * 0.0396; 
        //Thailand (Bhat) --> China (RMB)
        else if(input.getSelectedIndex()==3 && output.getSelectedIndex()==4)
            total = b * 0.18; 
        //Thailand (Bhat) --> Japan (Yen)
        else if(input.getSelectedIndex()==3 && output.getSelectedIndex()==5)
            total = b * 3.632; 
        //Thailand (Bhat) --> Korea (Won)
        else if(input.getSelectedIndex()==3 && output.getSelectedIndex()==6)
            total = b * 36.37; 
        //Thailand (Bhat) --> Taiwan Dollar
        else if(input.getSelectedIndex()==3 && output.getSelectedIndex()==7)
            total = b * 0.8537; 
        //India (Rupee) --> USD (US Dollar)
        else if(input.getSelectedIndex()==4 && output.getSelectedIndex()==0)
            total = b * 0.013; 
        //India (Rupee) --> British Pound
        else if(input.getSelectedIndex()==4 && output.getSelectedIndex()==1)
            total = b * 0.001; 
        //India (Rupee) --> Euro
        else if(input.getSelectedIndex()==4 && output.getSelectedIndex()==2)
            total = b * 0.01; 
        //India (Rupee) --> Australian Dollar
        else if(input.getSelectedIndex()==4 && output.getSelectedIndex()==3)
            total = b * 0.017; 
        //India (Rupee) --> China (RMB)
        else if(input.getSelectedIndex()==4 && output.getSelectedIndex()==4)
            total = b * 0.083; 
        //India (Rupee) --> Japan (Yen)
        else if(input.getSelectedIndex()==4 && output.getSelectedIndex()==5)
            total = b * 1.59; 
        //India (Rupee) --> Korea (Won)
        else if(input.getSelectedIndex()==4 && output.getSelectedIndex()==6)
            total = b * 16.006; 
        //India (Rupee) --> Taiwan Dollar
        else if(input.getSelectedIndex()==4 && output.getSelectedIndex()==7)
            total = b * 0.3757; 
        //Vietnam --> USD (US Dollar)
        else if(input.getSelectedIndex()==5 && output.getSelectedIndex()==0)
            total = b * 0.00004; 
        //Vietnam --> British Pound
        else if(input.getSelectedIndex()==5 && output.getSelectedIndex()==1)
            total = b * 0.00003; 
        //Vietnam --> Euro
        else if(input.getSelectedIndex()==5 && output.getSelectedIndex()==2)
            total = b * 0.000033; 
        //Vietnam --> Australian Dollar
        else if(input.getSelectedIndex()==5 && output.getSelectedIndex()==3)
            total = b * 0.00005; 
        //Vietnam --> China (RMB)
        else if(input.getSelectedIndex()==5 && output.getSelectedIndex()==4)
            total = b * 0.0002; 
        //Vietnam --> Japan (Yen)
        else if(input.getSelectedIndex()==5 && output.getSelectedIndex()==5)
            total = b * 0.005; 
        //Vietnam --> Korea (Won)
        else if(input.getSelectedIndex()==5 && output.getSelectedIndex()==6)
            total = b * 0.054; 
        //Vietnam --> Taiwan Dollar
        else if(input.getSelectedIndex()==5 && output.getSelectedIndex()==7)
            total = b * 0.001; 
        
        DecimalFormat df = new DecimalFormat("0.00000");
        //set total amount to textfield
        outAmount.setText(String.valueOf(df.format(total)));
        
        if(e.getSource()==btn2)
        {
            inAmount.setText("");
            outAmount.setText("");
        }
    }
}
