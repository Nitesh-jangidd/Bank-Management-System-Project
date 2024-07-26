import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    FastCash(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel();
        image.setBounds(0,0,1300,645);
        image.setIcon(i3);
        add(image);

        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,18));
        label.setBounds(385,145,400,30);
        image.add(label);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(340,210,160,27);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(556,210,160,27);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(340,246,160,27);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(556,246,160,27);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(340,281,160,27);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(556,281,160,27);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("BACK");
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
        if(e.getSource()==b7){
            setVisible(false);
            new main_Class(pin);
        }else{
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn c = new Conn();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }@SuppressWarnings("unused")
            String num = "17";

            if(e.getSource()!=b7 && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;

            }
            c.statement.executeUpdate("insert into bank values ('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
            JOptionPane.showMessageDialog(null, "Rs. " +amount+ " Debited Successfully");

            }catch(Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new main_Class(pin);
        }

        
    }
    
    public static void main(String[] args) {
        new FastCash("");
        
    }
    
}
