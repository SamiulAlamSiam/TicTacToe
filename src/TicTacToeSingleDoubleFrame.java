import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TicTacToeSingleDoubleFrame extends JFrame{
	
	private JButton btnSingle,btnDouble;
	private JLabel lblTitle;
	public TicTacToeSingleDoubleFrame()
	{
		this.setTitle("Tic Tac Toe");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.AddComponent();
	}

	private void AddComponent() {
		
		lblTitle=new JLabel("Choose Your Desire Mode");
		lblTitle.setBounds(70, 50, 400, 100);
		lblTitle.setFont(new Font("serif", Font.BOLD, 30));
		lblTitle.setForeground(Color.red);
		this.add(lblTitle);
		
		btnSingle=new JButton("Single");
		btnSingle.setBounds(100, 160, 150, 100);
		btnSingle.setFont(new Font("serif", Font.BOLD, 20));
		btnSingle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				TicTacToeHomeFrame ttthf=new TicTacToeHomeFrame(2);
				ttthf.setVisible(true);
				setVisible(false);
				
			}
		});
		this.add(btnSingle);
		
		btnDouble=new JButton("Double");
		btnDouble.setBounds(260, 160, 150, 100);
		btnDouble.setFont(new Font("serif", Font.BOLD, 20));
		btnDouble.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				TicTacToeHomeFrame ttthf=new TicTacToeHomeFrame(0);
				ttthf.setVisible(true);
				setVisible(false);
			}
		});
		this.add(btnDouble);
		
	}

}
