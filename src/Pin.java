import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Color;

public class Pin extends JFrame implements ActionListener{
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;

    Pin(String pin){
        this.pin = pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel();
        image.setBounds(0,0,1300,645);
        image.setIcon(i3);
        add(image);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,20));
        label1.setBounds(440,125,400,30);
        image.add(label1);

        JLabel label2 = new JLabel("NEW PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(350,165,400,30);
        image.add(label2);

        p1 = new JPasswordField();
        p1.setForeground(Color.WHITE);
        p1.setBackground(new Color(65,125,128));
        p1.setFont(new Font("Raleway",Font.BOLD,20));
        p1.setBounds(500,170,200,25);
        image.add(p1);

        JLabel label3 = new JLabel("Re-Enter NEW PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setBounds(350,195,200,30);
        image.add(label3);

        p2 = new JPasswordField();
        p2.setForeground(Color.WHITE);
        p2.setBackground(new Color(65,125,128));
        p2.setFont(new Font("Raleway",Font.BOLD,20));
        p2.setBounds(500,200,200,25);
        image.add(p2);

        b1 = new JButton("CHANGE");
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
        setVisible(true);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            
            String pin1 = p1.getText();
            
            String pin2 = p1.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"PINs do not match");
                return;
            }
            if(e.getSource()==b1){
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                    

                }
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                Conn c = new Conn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);



                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new main_Class(pin);

            }else if(e.getSource()==b2){
                new main_Class(pin);
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new Pin("");
        
    }
    
}
