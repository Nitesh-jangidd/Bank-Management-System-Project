import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Deposit extends JFrame implements ActionListener{
    TextField textField;
    JButton b1,b2;
    String pin;
    Deposit(String pin){
        super("Bank Management System");
        this.pin = pin;

        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel();
        image.setBounds(0,0,1300,645);
        image.setIcon(i3);
        add(image);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(365,135,400,30);
        image.add(label1);


        textField = new TextField();
        textField.setForeground(Color.WHITE);
        textField.setBackground(new Color(65,125,128));
        textField.setFont(new Font("Raleway",Font.BOLD,20));
        textField.setBounds(365,170,320,25);
        image.add(textField);


        b1 = new JButton("DEPOSIT");
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
        try{
        String amount = textField.getText();
        Date date = new Date();
        if(e.getSource()== b1){
            if(textField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER THE AMOUNT YOU WANT TO DEPOSIT");
            }else{
                Conn c = new Conn();
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Depostied Successfully");
                setVisible(false);
                new main_Class(pin);
            }
        }else if(e.getSource()==b2){
            setVisible(false);
            new main_Class(pin);
            

        }
        }
        catch(Exception E){
            E.printStackTrace();

        }

    }
    public static void main(String[] args) {
        new Deposit("");
        
    }
    
}
