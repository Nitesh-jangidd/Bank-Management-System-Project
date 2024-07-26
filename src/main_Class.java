import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    main_Class(String pin){
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel();
        image.setBounds(0,0,1300,645);
        image.setIcon(i3);
        add(image);

        JLabel label = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,18));
        label.setBounds(353,145,400,30);
        image.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(340,210,160,27);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(556,210,160,27);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(340,246,160,27);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(556,246,160,27);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(340,281,160,27);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(556,281,160,27);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(556,317,160,27);
        b7.addActionListener(this);
        image.add(b7);



        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){
                new Deposit(pin);
                setVisible(false);
            }else if(e.getSource()==b7){
                System.exit(0);
            }else if(e.getSource()==b2){
                new Withdrawl(pin);
                setVisible(false);
            }else if(e.getSource()== b6){
                new BalanceEnquiry(pin);
                setVisible(false);
            }else if(e.getSource()==b3){
                new FastCash(pin);
                setVisible(false);
            }else if(e.getSource()==b5){
                new Pin(pin);
                setVisible(false);
            }else if(e.getSource()==b4){
                new Mini(pin);
                
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new main_Class("");
        

    }
    
}
