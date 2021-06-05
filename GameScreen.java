package tictactoeGame;
//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GameScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameScreen frame = new GameScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 738, 0);
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel);
		
		JLabel lblTictactoe = new JLabel("TIC-TAC-TOE");
		lblTictactoe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTictactoe.setFont(new Font("Berlin Sans FB", Font.BOLD, 55));
		lblTictactoe.setForeground(Color.WHITE);
		lblTictactoe.setBounds(-22, 0, 725, 169);
		contentPane.add(lblTictactoe);
		
		JToggleButton tglbtnPlayWithComputer = new JToggleButton("PLAY AGAINST COMPUTER");
		tglbtnPlayWithComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
					GameTime.Player2="Computer";
					GameTime.main(null);
					
			}
			
			
		});
		tglbtnPlayWithComputer.setBackground(Color.WHITE);
		tglbtnPlayWithComputer.setFont(new Font("Tahoma", Font.BOLD, 17));
		tglbtnPlayWithComputer.setBounds(208, 180, 290, 76);
		contentPane.add(tglbtnPlayWithComputer);
		
		JToggleButton tglbtnPlayAgainstA = new JToggleButton("PLAY AGAINST A FRIEND");
		tglbtnPlayAgainstA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					GameTime.Player2="Player 2";
					GameTime.main(null);
			}
			
			
		});
		tglbtnPlayAgainstA.setFont(new Font("Tahoma", Font.BOLD, 17));
		tglbtnPlayAgainstA.setBackground(Color.WHITE);
		tglbtnPlayAgainstA.setBounds(208, 294, 290, 76);
		contentPane.add(tglbtnPlayAgainstA);
	}
}
