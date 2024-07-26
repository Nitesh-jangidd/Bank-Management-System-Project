













import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp2 extends JFrame implements ActionListener{
    
    String formno;
    JTextField textPan , textAadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;
    @SuppressWarnings("rawtypes")
    JComboBox comboBox,comboBox2,comboBox3,comboBox4,comboBox5;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public SignUp2(String formno){


        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel();
        image.setBounds(150,5,100,100);
        image.setIcon(i3);
        add(image);

        this.formno = formno;

        JLabel l1 = new JLabel("Page2 :- ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(300, 60, 600, 40);
        add(l2);

        JLabel l3 = new JLabel("Religion: ");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100, 120, 100, 30);
        add(l3);

        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(255,208,76));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(350, 120, 320, 30);
        add(comboBox);


        JLabel l4 = new JLabel("Category: ");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100, 160, 100, 30);
        add(l4);

        String Category[] = {"General","OBC","SC","ST", "Other"};
        
        comboBox2 = new JComboBox(Category);
        comboBox2.setBackground(new Color(255,208,76));
        comboBox2.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox2.setBounds(350, 160, 320, 30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income: ");
        l5.setFont(new Font("Raleway",Font.BOLD,18));
        l5.setBounds(100, 200, 100, 30);
        add(l5);

        String income[] = {"Null","<1,50,000","<2,50,000","5,00,000", "Upto 10,00,000","Above 10,00,000"};
       
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(255,208,76));
        comboBox3.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox3.setBounds(350, 200, 320, 30);
        add(comboBox3);

        JLabel l6 = new JLabel("Educational: ");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(100, 240, 120, 30);
        add(l6);

        String educational[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate", "Other"};
        
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(new Color(255,208,76));
        comboBox4.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox4.setBounds(350, 240, 320, 30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation: ");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100, 300, 120, 30);
        add(l7);

        String Occupation[] = {"Salaried","Self-Employed","Business","Student", "Retired","Other"};
        
        comboBox5 = new JComboBox(Occupation);
        comboBox5.setBackground(new Color(255,208,76));
        comboBox5.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox5.setBounds(350, 300, 320, 30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number: ");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100, 340, 130, 30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway",Font.BOLD,18));
        textPan.setBounds(350, 340, 320, 30);
        add(textPan);

        JLabel l9 = new JLabel("Aadhar Number: ");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100, 380, 160, 30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway",Font.BOLD,18));
        textAadhar.setBounds(350, 380, 320, 30);
        add(textAadhar);

        JLabel l10 = new JLabel("Senior Citizen: ");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100, 420, 150, 30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(255,208,76));
        r1.setBounds(350, 420, 100, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(255,208,76));
        r2.setBounds(460, 420, 100, 30);
        add(r2);

        JLabel l11 = new JLabel("Existing Account: ");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100, 460, 170, 30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway",Font.BOLD,14));
        e1.setBackground(new Color(255,208,76));
        e1.setBounds(350, 460, 100, 30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway",Font.BOLD,14));
        e2.setBackground(new Color(255,208,76));
        e2.setBounds(460, 460, 100, 30);
        add(e2);

        JLabel l12 = new JLabel("Form No: ");
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        l12.setBounds(670, 10, 170, 30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway",Font.BOLD,14));
        l13.setBounds(700, 10, 60, 30);
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570,570,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,800);
        setLocation(250,0);
        getContentPane().setBackground(new Color(252,208,76));
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String pan = textPan.getText();
        String addhar = textAadhar.getText();

        String scitizen = " ";
        if(r1.isSelected()){
            scitizen = "Yes";
        }
        else if(r2.isSelected()){
            scitizen = "No";
        }

        String eAccount = " ";
        if(r1.isSelected()){
            eAccount = "Yes";
        }
        else if(r2.isSelected()){
            eAccount = "No";
        }

        try{
            if((textPan.getText().equals("")) || (textAadhar.getText().equals(""))  ){
                JOptionPane.showMessageDialog(null,"Fill all the fields");

            }
            else{
                Conn c1 = new Conn();
                String q = "insert into signuptwo values('"+formno+"','"+rel+"','"+cate+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+addhar+"','"+scitizen+"','"+eAccount+"')";
                c1.statement.executeUpdate(q);
                
                new SignUp3(formno);
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }



        
        
    }
    public static void main(String args[]){
       new SignUp2("");
    }
    
}
