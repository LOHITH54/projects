import NetflixCoverPage.NetflixCoverPage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class SignUp extends JFrame{
    JTextField t1,t2;
    JButton b1;
    SignUp()
    {
        setLayout(null);

        t1=new JTextField(60);
        t2=new JPasswordField(60);=
        
        b1=new JButton("Submit");

            t1.setBounds(100,20,80,30);
            t2.setBounds(100,60,80,30);
            b1.setBounds(100,100,80,30);

            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae)
                {
                    try{
                    FileWriter fw=new FileWriter("Login.text",true);
                    fw.write(t1.getText()+"\t"+t2.getText()+"\n");
                    fw.close();
                    JFrame f=new JFrame();
                    JOptionPane.showMessageDialog(f,"Registration Completed");
                        dispose();
                    }catch(Exception e){}
                    
                }
            });

        add(t1);
        add(t2);
        add(b1);

    }
}

class Login extends JFrame{
    JTextField t1,t2;
    JButton b1,b2;
    JLabel l1,l2;
    Login(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1=new JLabel("Login");
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(120,10,300,30);
        add(l1);
        t1=new JTextField(60);
        t2=new JPasswordField(60);
        b1=new JButton("Signin");
        b2=new JButton("Signup");

        t1.setBounds(100,60,120,30);
        t2.setBounds(100,100,120,30);
        b1.setBounds(120,140,80,30);
        b2.setBounds(120,170,80,30);

        l2=new JLabel("");
        l2.setBounds(250,80,300,30);
        add(l2);

        add(t1);
        add(t2);
        add(b1);
        add(b2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                boolean matched=false;
                String uname=t1.getText().toString();
                String pwd=t2.getText().toString();

                try{
                FileReader fr=new FileReader("Login.text");
                BufferedReader br=new BufferedReader(fr);
                String line;
                while((line=br.readLine())!=null){
                    if(line.equals(uname+"\t"+pwd)){
                        matched=true;
                        break;
                
                    }
                }
                fr.close();
            }catch(Exception e){}
                if(matched){
                    l2.setText("Welcome");
                    dispose();
                    NetflixCoverPage net=new NetflixCoverPage();
                    net.NetflixCoverPage();
                }
                else
                    l2.setText("Invalid Username or Password");
                /*if(t1.getText().toString().equals("hemanth") && t2.getText().toString().equals("121971"))
                   l2.setText("Welcome");
                else
                   l2.setText("Invalid Username or Password");*/
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                SignUp s=new SignUp();
                s.setVisible(true);
                s.setBounds(200,200,500,300);
                
            }
        });
    }
}
class LoginDemo{
    public static void main(String args[])
    {
        Login l=new Login();
        l.setBounds(400,200,500,300);
        l.setVisible(true);
    }
}