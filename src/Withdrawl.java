import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.Font;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    
    Withdrawl(String pin){


         this.pin = pin;

        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel();
        image.setBounds(0,0,1300,645);
        image.setIcon(i3);
        add(image);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWL IS RS. 10000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(370,135,400,30);
        image.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(387,165,400,30);
        image.add(label2);


        textField = new TextField();
        textField.setForeground(Color.WHITE);
        textField.setBackground(new Color(65,125,128));
        textField.setFont(new Font("Raleway",Font.BOLD,20));
        textField.setBounds(365,200,300,25);
        image.add(textField);


        b1 = new JButton("WITHDRAW");
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(590,282,125,27);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("BACK");
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(590,318,125,27);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        image.add(b2);













        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);

        

        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
        try{
            String amount = textField.getText();
            Date date = new Date();
            if(textField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else{
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance = balance + Integer.parseInt(resultSet.getString("amount"));

                    }else{
                        balance = balance - Integer.parseInt(resultSet.getString("amount"));
                    }

                }
                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;

                }
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs."+amount+"Debited Successfully");
                setVisible(false);
                new main_Class(pin);
                
            }
            


            
        }catch(Exception E){
            E.printStackTrace();
        }
    }else if(e.getSource()==b2){
        setVisible(false);
        new main_Class(pin);
    }

    }

    public static void main(String[] args) {
        new Withdrawl("");
        
    }
    
}
