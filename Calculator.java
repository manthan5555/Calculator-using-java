import java.awt.*;
import java.awt.Color;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame implements ActionListener
{
	JFrame f=new JFrame("Calculator");
	JTextField t1;
	JLabel l1,l2;
	JButton bn,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bd,ba,bm,bdiv,be,bs,bans,bdel,bsq,bsqr,binv,bmod;
	Container c;
	double num1,num2,ans;
	int ch,ans1;
	
	Calculator()
	{
		c=f.getContentPane();
		c.setLayout(null);
		f.setLayout(null);
		f.setResizable(false);
		f.setBounds(1400,100,420,550);
		Font font = new  Font("Ariel",Font.BOLD,45);
		Font font1 = new  Font("Ariel",Font.BOLD,20);
		Font font2 = new  Font("Ariel",Font.PLAIN,15);
		l1=new JLabel("Standard");
		l1.setBounds(10,0,100,50);
		c.add(l1);
		l1.setFont(font1);
		l2=new JLabel();
		l2.setBounds(10,50,200,50);
		c.add(l2);		
		t1=new JTextField();
		t1.setBounds(50,100,350,80);
		t1.setFont(font);		
		c.add(t1);
		bsq=new JButton("x^2");
		bsq.setBounds(100,250,100,50);
		bsq.setFont(font2);
		c.add(bsq);
		bmod=new JButton("%");
		bmod.setBounds(3,250,100,50);
		bmod.setFont(font2);
		c.add(bmod);
		bmod.addActionListener(this);
		bsq.addActionListener(this);		
		binv=new JButton("1/x");
		binv.setBounds(3,250,100,50);
		binv.setFont(font2);
		c.add(binv);
		binv.addActionListener(this);		
		bsqr=new JButton("_/`x");
		bsqr.setBounds(200,250,100,50);
		bsqr.setFont(font2);
		c.add(bsqr);
		bsqr.addActionListener(this);		
		bn=new JButton("+/-");
		bn.setBounds(3,450,100,50);
		bn.setFont(font2);
		c.add(bn);
		bn.addActionListener(this);		
		b0=new JButton("0");
		b0.setBounds(100,450,100,50);
		b0.setFont(font1);
		c.add(b0);
		b0.addActionListener(this);		
		b1=new JButton("1");
		b1.setBounds(3,400,100,50);
		b1.setFont(font1);
		c.add(b1);
		b1.addActionListener(this);		
		b2=new JButton("2");
		b2.setBounds(100,400,100,50);
		b2.setFont(font1);
		c.add(b2);
		b2.addActionListener(this);		
		b3=new JButton("3");
		b3.setBounds(200,400,100,50);
		b3.setFont(font1);
		c.add(b3);
		b3.addActionListener(this);		
		b4=new JButton("4");
		b4.setBounds(3,350,100,50);
		b4.setFont(font1);
		c.add(b4);
		b4.addActionListener(this);		
		b5=new JButton("5");
		b5.setBounds(100,350,100,50);
		b5.setFont(font1);
		c.add(b5);
		b5.addActionListener(this);		
		b6=new JButton("6");
		b6.setBounds(200,350,100,50);
		b6.setFont(font1);
		c.add(b6);
		b6.addActionListener(this);		
		b7=new JButton("7");
		b7.setBounds(3,300,100,50);
		b7.setFont(font1);
		c.add(b7);
		b7.addActionListener(this);		
		b8=new JButton("8");
		b8.setBounds(100,300,100,50);
		b8.setFont(font1);
		c.add(b8);
		b8.addActionListener(this);		
		b9=new JButton("9");
		b9.setBounds(200,300,100,50);
		b9.setFont(font1);
		c.add(b9);
		b9.addActionListener(this);	
		ba=new JButton("+");
		ba.setBounds(300,400,100,50);
		ba.setFont(font2);
		c.add(ba);
		ba.addActionListener(this);		
		bs=new JButton("-");
		bs.setBounds(300,350,100,50);
		bs.setFont(font2);
		c.add(bs);
		bs.addActionListener(this);		
		bm=new JButton("x");
		bm.setBounds(300,300,100,50);
		bm.setFont(font2);
		c.add(bm);
		bm.addActionListener(this);		
		bans=new JButton("=");
		bans.setBounds(300,450,100,50);
		bans.setFont(font2);
		Color c1=new Color(51,170,255);
		bans.setBackground(c1);
		c.add(bans);
		bans.addActionListener(this);		
		bdiv=new JButton("/");
		bdiv.setBounds(300,250,100,50);
		bdiv.setFont(font2);
		c.add(bdiv);
		bdiv.addActionListener(this);	
		be=new JButton("<x|");
		be.setBounds(300,200,100,50);
		be.setFont(font2);
		c.add(be);
		be.addActionListener(this);		
		bd=new JButton(".");
		bd.setBounds(200,450,100,50);
		bd.setFont(font2);
		c.add(bd);
		bd.addActionListener(this);		
		bdel=new JButton("C");
		bdel.setBounds(200,200,100,50);
		bdel.setFont(font2);
		c.add(bdel);
		bdel.addActionListener(this);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bn)
		{
			String st;
			String s=t1.getText();
			if(s.contains("-"))
			{	
				st=s.substring(1,s.length());
			}
			else
				st="-"+s;
			t1.setText(st);
			l2.setText("");
		}
		if(e.getSource()==b0)
		{
			String s=t1.getText();
			String st=s+"0";
			t1.setText(st);
			l2.setText("");
		}	
		if(e.getSource()==b1)
		{
			String s=t1.getText();
			String st=s+"1";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}

		}		
		if(e.getSource()==b2)
		{
			String s=t1.getText();
			String st=s+"2";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}
		}		
		if(e.getSource()==b3)
		{
			String s=t1.getText();
			String st=s+"3";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}
		}		
		if(e.getSource()==b4)
		{
			String s=t1.getText();
			String st=s+"4";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}
		}		
		if(e.getSource()==b5)
		{
			String s=t1.getText();
			String st=s+"5";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}

		}		
		if(e.getSource()==b6)
		{
			String s=t1.getText();
			String st=s+"6";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}
		}		
		if(e.getSource()==b7)
		{
			String s=t1.getText();
			String st=s+"7";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}
		}		
		if(e.getSource()==b8)
		{
			String s=t1.getText();
			String st=s+"8";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}
		}		
		if(e.getSource()==b9)
		{
			String s=t1.getText();
			String st=s+"9";
			if(st.length()>=14)
			{
				l2.setText("max capacity reached");
			}
			else{
			t1.setText(st);
			l2.setText("");
			}
		}		
		if(e.getSource()==ba)
		{
			try{
			num1=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("invalid format");
				return;
			}
			l2.setText("");
			t1.setText("");
			t1.requestFocus();
			ch=1;
		}		
		if(e.getSource()==bs)
		{
			try{
			num1=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("invalid format");
				return;
			}
			l2.setText("");
			t1.setText("");
			t1.requestFocus();
			ch=2;
		}		
		if(e.getSource()==bm)
		{
			try{
			num1=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("invalid format");
				return;
			}
			l2.setText("");
			t1.setText("");
			t1.requestFocus();
			ch=3;
		}		
		if(e.getSource()==bdiv)
		{
			try{
			num1=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("invalid format");
				return;
			}
			l2.setText("");
			t1.setText("");
			t1.requestFocus();
			ch=4;
		}		
		if(e.getSource()==bd)
		{
			int flag=0;
			String st=t1.getText();
			if(st.contains("."))
			{
				flag=1;	
			}
			if(flag==1)
			{
				l2.setText("invalid option");
			}
			else
			{
				String s=t1.getText();
				st=s+".";
				t1.setText(st);
				l2.setText("");
			}			
		}		
		if(e.getSource()==bdel)
		{
			t1.requestFocus();
			t1.setText("");
		}	
		if(e.getSource()==be)
		{
			String s=t1.getText();
			String st;
			try{
				st=s.substring(0,s.length()-1);
			}catch(StringIndexOutOfBoundsException f)
			{
				return;
			}
			t1.setText(st);
		}
		
		if(e.getSource()==bmod)
		{
			double x;
			try{
			x=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("invalid format");
				return;
			}
			x=x/100;
			t1.setText(String.valueOf(x));
			l2.setText("");
		}		
		if(e.getSource()==bsq)
		{
			double sq;
			try{
			sq=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("invalid format");
				return;
			}
			sq=sq*sq;
			String t=String.valueOf(sq);
			if(t.length()>=7)
			{
				t1.setText(t.substring(0,6));
			}
			else
			{
			t1.setText(t);
			}
		}		
		if(e.getSource()==binv)
		{
			double sq;
			try{
			sq=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("invalid format");
				return;
			}
			sq=1/sq;
			String t=String.valueOf(sq);
			if(t.length()>=7)
			{
				t1.setText(t.substring(0,6));
			}
			else
			{
			t1.setText(t);
			}
		}		
		if(e.getSource()==bsqr)
		{
			double sq;
			try{
			sq=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("invalid format");
				return;
			}
			sq=Math.sqrt(sq);
			String t=String.valueOf(sq);
			if(t.length()>=7)
			{
				t1.setText(t.substring(0,6));
			}
			else
			{
			t1.setText(t);
			}
		}
		if(e.getSource()==bans)
		{
			try{
			num2=Double.parseDouble(t1.getText());
			}catch(NumberFormatException f){
				l2.setText("Enter no first");
				return;
			}
			l2.setText("");
			if(ch==1)
			{
				ans=num1+num2;
				t1.setText(String.valueOf(ans));
			}
			if(ch==2)
			{
				ans=num1-num2;
				t1.setText(String.valueOf(ans));
			}
			if(ch==3)
			{
				ans=num1*num2;
				t1.setText(String.valueOf(ans));
			}
			if(ch==4)
			{
				ans=num1/num2;
				String t=String.valueOf(ans);
				if(t.length()>=8)
				{
					t1.setText(t.substring(0,6));
				}
				else
				{
					t1.setText(t);
				}
			}
		}
	}
	public static void main(String s[])
	{
		new Calculator();
	}
}