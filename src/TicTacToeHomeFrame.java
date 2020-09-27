import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TicTacToeHomeFrame extends JFrame{
	
	private int player,Mode=0;
	private String mar;
	private JLabel lblTitle,lblPlayerChoose,lblMarkChoose;
	private JPanel pnlAll;
	JRadioButton rbtnSingle,rbtnDouble;
	ButtonGroup bg;
	
	String[] marks= {"X","O"};
	private JComboBox btnMarks;
	
	private JButton btnStart,btnExit;
	
	public TicTacToeHomeFrame(int mode)
	{
		Mode=mode;
		this.setTitle("Tic Tac Toe");
		this.setSize(620, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		this.AddComponent();
		
	}
	
	public void AddComponent()
	{
		pnlAll= new JPanel();
		pnlAll.setBounds(0, 0, 600, 400);
		pnlAll.setLayout(null);
		pnlAll.setBackground(Color.BLACK);
		add(pnlAll);
		
		this.UpperComponent();
	}
	
	public void UpperComponent()
	{
		lblTitle=new JLabel("Tic Tac Toe");
		lblTitle.setBounds(220, 65, 150, 35);
		lblTitle.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 30));
		lblTitle.setForeground(Color.blue);
		
		this.pnlAll.add(lblTitle);
		
		
		lblPlayerChoose=new JLabel("Which Player Are You?");
		lblPlayerChoose.setBounds(150, 115, 300, 45);
		lblPlayerChoose.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 30));
		lblPlayerChoose.setForeground(Color.gray);
		this.pnlAll.add(lblPlayerChoose);
		
		
		rbtnSingle=new JRadioButton("Player 1");
		rbtnSingle.setBounds(120, 175, 120, 20);
		rbtnSingle.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 20));
		rbtnSingle.setForeground(Color.red);
		this.pnlAll.add(rbtnSingle);
		
		rbtnDouble=new JRadioButton("Player 2");
		rbtnDouble.setBounds(350, 175, 120, 20);
		rbtnDouble.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 20));
		rbtnDouble.setForeground(Color.green);
		this.pnlAll.add(rbtnDouble);
		
		bg=new ButtonGroup();
		bg.add(rbtnSingle);
		bg.add(rbtnDouble);
		
		lblMarkChoose=new JLabel("Choose Your Mark : ");
		lblMarkChoose.setBounds(180, 205, 210, 35);
		lblMarkChoose.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 20));
		lblMarkChoose.setForeground(Color.blue);
		this.pnlAll.add(lblMarkChoose);
		
		btnMarks=new JComboBox(marks);
		btnMarks.setBounds(390, 210, 50, 30);
		btnMarks.setFont(new Font("Serif", Font.BOLD, 15));
		this.pnlAll.add(btnMarks);
		
		
		btnStart=new JButton("Start");
		btnStart.setBounds(180, 290, 120, 35);
		btnStart.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 25));
		//btnStart.setBackground(Color.gray);
		//btnStart.setForeground(Color.gray);
		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rbtnSingle.isSelected())
					player = 1;
				
				else if(rbtnDouble.isSelected())
					player = 2;
				
				else
				{
					JOptionPane.showMessageDialog(null, "Select Your Player ");
					return;
				}
				
				mar=btnMarks.getSelectedItem().toString();
				
				TicTacToeGameFrame tttgf=new TicTacToeGameFrame(player,mar,Mode);
				tttgf.setVisible(true);
				setVisible(false);
				
			}
		});
		this.pnlAll.add(btnStart);
		
		btnExit=new JButton("Exit");
		btnExit.setBounds(320, 290, 120, 35);
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
		this.pnlAll.add(btnExit);
	}

}
