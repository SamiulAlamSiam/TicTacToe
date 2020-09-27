import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class TicTacToeGameFrame extends JFrame{
	
	private int player,player1,player2;
	private String mar1,mar2,mar;
	private int move=1,Mode=0,i;
	public Random rand=new Random();
	
	private JLabel lblPlayer,lblMarks,lblWin;
	private JPanel pnlLeft,pnlRight;
	private JButton btnAll,btnReStart,btnExit;
	ArrayList<JButton> b=new ArrayList<>();
	ArrayList<JButton> d=new ArrayList<>();
	ArrayList<String> p1Sells=new ArrayList<>();
	ArrayList<String> p2Sells=new ArrayList<>();
	
	public TicTacToeGameFrame(int id, String s,int mode) {
		
		player=id;
		Mode=mode;
		
		if((s.equals("X"))&&(player==1))
		{
			mar1="X";
			mar2="O";
		}
		else if((s.equals("O"))&&(player==1))
		{
			mar1="O";
			mar2="X";
		}
		
		else if((s.equals("X"))&&(player==2)&&(Mode==2))
		{
			mar2="X";
			mar1="O";
		}
		
		else 
		{
			mar2="O";
			mar1="X";
		}
		
		this.setTitle("Game");
		this.setSize(750, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.Addcomoponent();
	}

	private void Addcomoponent() {
		pnlLeft=new JPanel();
		pnlLeft.setBorder(new LineBorder(Color.green,2));
		pnlLeft.setLayout(new GridLayout(3, 3, 10, 10));
		pnlLeft.setSize(450, 400);
		pnlLeft.setBackground(Color.BLACK);
		add(pnlLeft);
		
		this.LeftComponent();
		
		pnlRight=new JPanel();
		pnlRight.setBorder(new LineBorder(Color.RED,2));
		pnlRight.setLayout(null);
		pnlRight.setSize(730, 550);
		pnlRight.setBackground(Color.BLACK);
		add(pnlRight);
		
		this.RightComponent();
	}

	private void RightComponent() {
		lblPlayer=new JLabel("Player"+" "+player+" "+"Will Move Now");
		lblPlayer.setBounds(460, 20, 250, 50);
		lblPlayer.setFont(new Font("serif", Font.BOLD, 20));
		lblPlayer.setBackground(Color.red);
		lblPlayer.setForeground(Color.red);
		this.pnlRight.add(lblPlayer);
		
		if(player==2)
			lblMarks=new JLabel("Mark Is :"+" "+mar2);
		else
			lblMarks=new JLabel("Mark Is :"+" "+mar1);
		lblMarks.setBounds(460, 80, 250, 50);
		lblMarks.setFont(new Font("serif", Font.BOLD, 20));
		lblMarks.setBackground(Color.red);
		lblMarks.setForeground(Color.red);
		this.pnlRight.add(lblMarks);
		
		
		
		lblWin=new JLabel("Nobody Win");
		lblWin.setBounds(460, 150, 250, 35);
		lblWin.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 25));
		lblWin.setBackground(Color.gray);
		lblWin.setForeground(Color.red);
		this.pnlRight.add(lblWin);
		
		
		btnReStart=new JButton("ReStart");
		btnReStart.setBounds(460, 250, 120, 35);
		btnReStart.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 25));
		//btnStart.setBackground(Color.gray);
		//btnStart.setForeground(Color.gray);
		btnReStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				TicTacToeSingleDoubleFrame tttsdhf=new TicTacToeSingleDoubleFrame();
				tttsdhf.setVisible(true);
				setVisible(false);
				
			}
		});
		this.pnlRight.add(btnReStart);
		
		btnExit=new JButton("Exit");
		btnExit.setBounds(460, 290, 120, 35);
		btnExit.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 25));
		//btnExit.setBackground(Color.gray);
		//btnExit.setForeground(Color.gray);
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
				
			}
		});
		this.pnlRight.add(btnExit);
		
	}

	private void LeftComponent() 
	{
		for (int i=1;i<10;i++)
		{
			btnAll=new JButton(i+"");
			btnAll.setBackground(Color.lightGray);
			btnAll.setFont(new Font("Serif", Font.BOLD, 35));
			btnAll.setForeground(Color.green);
			b.add(btnAll);
			d.add(btnAll);
			
			btnAll.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					move++;
					JButton btn=(JButton)e.getSource();
					btn.setEnabled(false);
					if(player==1)
					{
						//mar=mar1;
						p1Sells.add(btn.getText());
						btn.setText(mar1);
						if(move>4)
						{
							if(checkWin())
							{
								lblWin.setText("Player 1 Win");
								for(JButton c:b)
								{
									c.setEnabled(false);
								}
								return;
							}
						}
							
						player=2;
						lblPlayer.setText("Player"+" "+player+" "+"Will Move Now");
						lblMarks.setText("Mark Is :"+" "+mar2);	
						
						if(Mode==2)
						{
							ComputerPlay();
						}
					}
					else
					{
						
						p2Sells.add(btn.getText());
						btn.setText(mar2);
						if(move>4)
						{
							if(checkWin())
							{
								lblWin.setText("Player 2 Win");
								for(JButton c:b)
								{
									c.setEnabled(false);
								}
								return;
							}
						}
						player=1;
						lblPlayer.setText("Player"+" "+player+" "+"Will Move Now");
						lblMarks.setText("Mark Is :"+" "+mar1);	
					}
					
					d.remove(btn);
				}

				
			});
			this.pnlLeft.add(btnAll);
		}
		
	}
	
	private void ComputerPlay()
	{
		i=rand.nextInt(d.size()-1);
		d.get(i).doClick();
	}
	
	private boolean checkWin() {
		ArrayList<String> list=new ArrayList<>();
		if(player==1)	
			list.addAll(p1Sells);	
		else
			list.addAll(p2Sells);
		
		if((list.contains("1")&&list.contains("2")&&list.contains("3")||list.contains("4")&&list.contains("5")&&list.contains("6")
				||list.contains("7")&&list.contains("8")&&list.contains("9")
				||list.contains("1")&&list.contains("5")&&list.contains("9")||list.contains("3")&&list.contains("5")&&list.contains("7")
				||list.contains("2")&&list.contains("5")&&list.contains("8")||list.contains("1")&&list.contains("4")&&list.contains("7")
				||list.contains("3")&&list.contains("6")&&list.contains("9")))
		{
			return true;
		}
		return false;

	}	

}
