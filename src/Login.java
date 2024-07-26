
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    JLabel label1 , label2, label3;
    JTextField textfield2;
    JPasswordField passfield3;
    JButton button1,button2,button3;
    Login(){
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel();
        image.setBounds(350,10,100,100);
        image.setIcon(i3);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel();
        iimage.setBounds(700,350,100,100);
        iimage.setIcon(ii3);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 36));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No: ");
        label2.setFont(new Font("Ralway",Font.BOLD,24));
        label2.setForeground(Color.white);
        label2.setBounds(150,190,375,30);
        add(label2);

        textfield2 = new JTextField(15);
        textfield2.setBounds(325,190,230,30);
        textfield2.setFont(new Font("Arial",Font.BOLD,14));
        add(textfield2);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD,24));
        label3.setForeground(Color.white);
        label3.setBounds(150,250,375,30);
        add(label3);

        passfield3 = new JPasswordField(15);
        passfield3.setBounds(325,250,230,30);
        passfield3.setFont(new Font("Arial",Font.BOLD,14));
        add(passfield3);


        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.white);
        button1.setBackground(Color.black);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.white);
        button3.setBackground(Color.black);
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel();
        iiimage.setBounds(0,0,850,480);
        iiimage.setIcon(iii3);
        add(iiimage);
        

        setLayout(null);
        setSize(850,480);
        setLocation(200,150);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1){
                Conn c = new Conn();
                String cardno  = textfield2.getText();
                @SuppressWarnings("deprecation")
                String pin = passfield3.getText();
                String q = "Select * from login where card_number = '"+cardno+"' and  pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new main_Class(pin);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Card Number or Pin");
                }

            }
            else if(e.getSource() == button2){
                textfield2.setText("");
                passfield3.setText("");
            }
            else if(e.getSource() == button3){
                new SignUp();
                setVisible(false);
                
            }

        }catch(Exception E){
            E.printStackTrace();
        }
        
        
    }
    public static void main(String[] args) {
        new Login();

        

        
    }
    
}

