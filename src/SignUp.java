import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;




public class SignUp extends JFrame implements ActionListener{
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);
    JLabel label1 , label2 , label3 , labelName , labelfName , DOB , labelG , labelEmail , labelMs , labelAdd ,labelCity , labelpin ,lablestate;
    JTextField textname , textFname , textEmail , textMs , textAdd , textCity , textpin , textstate;
    JDateChooser dateChooser;
    JRadioButton r1,r2,r3,r4;
    JButton next;


    SignUp(){
    
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel();
        image.setBounds(25,10,100,100);
        image.setIcon(i3);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330,70,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(290,90,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(100,150,100,28);
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelName);

         textname = new JTextField();
         textname.setFont(new Font("Raleway",Font.BOLD,14));
         textname.setBounds(300,150,400,25);
         add(textname);

        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setBounds(100,190,200,28);
        labelfName.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelfName);

         textFname = new JTextField();
         textFname.setFont(new Font("Raleway",Font.BOLD,14));
         textFname.setBounds(300,190,400,25);
         add(textFname);

        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setBounds(100,230,200,28);
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,230,400,25);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setBounds(100,270,200,28);
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(167,186,102));
        r1.setBounds(300,270,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(167,186,102));
        r2.setBounds(450,270,90,30);
        add(r2);


        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(r1);
        buttongroup.add(r2);
        buttongroup.add(r3);
        buttongroup.add(r4);

        JLabel labelEmail = new JLabel("Email Address: ");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,310,200,28);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,310,400,25);
        add( textEmail);


        JLabel labelMs = new JLabel("Marital Status: ");
        labelMs.setFont(new Font("Raleway",Font.BOLD,20));
        labelMs.setBounds(100,350,200,28);
        add(labelMs);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(new Color(167,186,102));
        r3.setBounds(300,350,100,25);
        add(r3);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(new Color(167,186,102));
        r4.setBounds(450,350,150,25);
        add(r4);
        

        JLabel labelAdd = new JLabel("Address: ");
        labelAdd.setFont(new Font("Raleway",Font.BOLD,20));
        labelAdd.setBounds(100,390,200,28);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,390,400,25);
        add( textAdd);

        JLabel labelCity = new JLabel("City: ");
        labelCity.setFont(new Font("Raleway",Font.BOLD,20));
        labelCity.setBounds(100,430,200,28);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,430,400,25);
        add(textCity);

        JLabel labelpin = new JLabel("Pin Code: ");
        labelpin.setFont(new Font("Raleway",Font.BOLD,20));
        labelpin.setBounds(100,470,200,28);
        add(labelpin);

        textpin = new JTextField();
        textpin.setFont(new Font("Raleway",Font.BOLD,14));
        textpin.setBounds(300,470,400,25);
        add(textpin);

        JLabel labelstate = new JLabel("State: ");
        labelstate.setFont(new Font("Raleway",Font.BOLD,20));
        labelstate.setBounds(100,510,200,28);
        add(labelstate);

        textstate = new JTextField();
        textstate.setFont(new Font("Raleway",Font.BOLD,14));
        textstate.setBounds(300,510,400,25);
        add(textstate);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,580,80,30);
        next.addActionListener(this);
        add(next);


     getContentPane().setBackground(new Color(167, 186, 102));
     setLayout(null);
     setSize(850,800);
     setLocation(250,0);
     setUndecorated(true);
     setVisible(true);

    

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textname.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }
        else if(r2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital = null;
        if(r3.isSelected()){
            marital = "Married";
        }
        else if(r4.isSelected()){
            marital = "Unmarried";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String state = textstate.getText();
        String pincode = textpin.getText();
        
        try{
            if(textname.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else{
                Conn conn1 = new Conn();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                conn1.statement.executeUpdate(q);
                new SignUp2(first);
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }

        
    }




public static void main(String[] args){
    new SignUp();
    
    
}
}

