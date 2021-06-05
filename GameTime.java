package tictactoeGame;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class GameTime extends JFrame {

	private JPanel contentPane;
	 static String Player1="Player 1";
	 static String Player2;
	 static String player=Player1;
	 int score_1=0;
	 int score_2=0;
	 
	 //for score
	 static int count=0;
	 
	//creating labels where x and o will be displayed
		
	 		JLabel Label_00 = new JLabel("");
			JLabel Label_01 = new JLabel("");
			JLabel Label_02 = new JLabel("");
			JLabel Label_10 = new JLabel("");
			JLabel Label_11 = new JLabel("");
			JLabel Label_12 = new JLabel("");
			JLabel Label_20 = new JLabel("");
			JLabel Label_21 = new JLabel("");
			JLabel Label_22 = new JLabel("");
			
			JLabel arr[]= {Label_00,Label_01,Label_02,Label_10,Label_11,Label_12,Label_20,Label_21,Label_22};
			
			
			JLabel Player1_score;
			JLabel Player2_score;
	 //to store multiline in a string
	 String newLine = System.getProperty("line.separator");
	 
	 Computer comp=new Computer();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//thread creation for jframe
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameTime frame = new GameTime();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	  Create the frame.
	 */
	
	public GameTime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 441);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		Player's name
		
		JLabel lblPlayer = new JLabel(Player1);
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPlayer.setForeground(Color.ORANGE);
		lblPlayer.setBounds(60, 287, 239, 31);
		contentPane.add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel(Player2);
		lblPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer_1.setForeground(Color.ORANGE);
		lblPlayer_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPlayer_1.setBounds(326, 287, 239, 31);
		contentPane.add(lblPlayer_1);
		
//		scores
	   
	  
		Player1_score = new JLabel(Integer.toString(score_1));
		Player1_score.setFont(new Font("Tahoma", Font.BOLD, 24));
		Player1_score.setHorizontalAlignment(SwingConstants.CENTER);
		Player1_score.setForeground(Color.ORANGE);
		Player1_score.setBounds(111, 329, 131, 50);
		contentPane.add(Player1_score);
		
		Player2_score = new JLabel(Integer.toString(score_2));
		Player2_score.setHorizontalAlignment(SwingConstants.CENTER);
		Player2_score.setForeground(Color.ORANGE);
		Player2_score.setFont(new Font("Tahoma", Font.BOLD, 24));
		Player2_score.setBounds(377, 329, 131, 50);
		contentPane.add(Player2_score);
		
		
		
//		Structure of the board 
		
		JSeparator separator = new JSeparator();
		separator.setToolTipText("");
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.WHITE);
		separator.setBounds(142, 103, 315, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(142, 175, 315, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(241, 32, 1, 223);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(352, 32, 1, 223);
		contentPane.add(separator_3);
		
		
		
		//using local classes to check scores
//	    class check{
//	    	// calculating scores
//				   }

		//boxes where x and o will be shown
		
		Label_00.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				player=play(Label_00,player,arr);
//				checkscores();
			}
		});
		Label_00.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_00.setHorizontalAlignment(SwingConstants.CENTER);
		Label_00.setForeground(Color.WHITE);
		Label_00.setBackground(Color.BLACK);
		Label_00.setBounds(142, 32, 100, 73);
		contentPane.add(Label_00);
		
		
		Label_01.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				player=play(Label_01,player,arr);
//				checkscores();

			}
		});
		Label_01.setHorizontalAlignment(SwingConstants.CENTER);
		Label_01.setForeground(Color.WHITE);
		Label_01.setBackground(Color.BLACK);
		Label_01.setBounds(241, 32, 112, 73);
		contentPane.add(Label_01);
		
		
		Label_02.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
						player=play(Label_02,player,arr);
//					    checkscores();
			}
		});
		Label_02.setHorizontalAlignment(SwingConstants.CENTER);
		Label_02.setForeground(Color.WHITE);
		Label_02.setBackground(Color.BLACK);
		Label_02.setBounds(352, 32, 105, 73);
		contentPane.add(Label_02);
		
		
		Label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					player=play(Label_10,player,arr);
//					checkscores();
			}
		});
		Label_10.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_10.setHorizontalAlignment(SwingConstants.CENTER);
		Label_10.setForeground(Color.WHITE);
		Label_10.setBackground(Color.BLACK);
		Label_10.setBounds(142, 104, 100, 73);
		contentPane.add(Label_10);
		
		
		
		Label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					player=play(Label_11,player,arr);
//					checkscores();
			}
		});
		Label_11.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_11.setHorizontalAlignment(SwingConstants.CENTER);
		Label_11.setForeground(Color.WHITE);
		Label_11.setBackground(Color.BLACK);
		Label_11.setBounds(241, 104, 112, 73);
		contentPane.add(Label_11);
		
		
		Label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					player=play(Label_12,player,arr);
//				    checkscores();
			}
		});
		Label_12.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_12.setHorizontalAlignment(SwingConstants.CENTER);
		Label_12.setForeground(Color.WHITE);
		Label_12.setBackground(Color.BLACK);
		Label_12.setBounds(352, 103, 105, 73);
		contentPane.add(Label_12);
		
		
		Label_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					player=play(Label_20,player,arr);
//				checkscores();
			}
		});
		Label_20.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_20.setHorizontalAlignment(SwingConstants.CENTER);
		Label_20.setForeground(Color.WHITE);
		Label_20.setBackground(Color.BLACK);
		Label_20.setBounds(142, 175, 100, 80);
		contentPane.add(Label_20);
		
		
		Label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					player=play(Label_21,player,arr);
//				    checkscores();
			}
		});
		Label_21.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_21.setHorizontalAlignment(SwingConstants.CENTER);
		Label_21.setForeground(Color.WHITE);
		Label_21.setBackground(Color.BLACK);
		Label_21.setBounds(241, 175, 112, 80);
		contentPane.add(Label_21);
		
		
		Label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					player=play(Label_22,player,arr);
//					checkscores();
			}
		});
		Label_22.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label_22.setHorizontalAlignment(SwingConstants.CENTER);
		Label_22.setForeground(Color.WHITE);
		Label_22.setBackground(Color.BLACK);
		Label_22.setBounds(352, 175, 105, 80);
		contentPane.add(Label_22);	    
		

		
		
	}
	
//	   *************************************************************************************************************************/
  
	
	//displaying x and o
	
		String play(JLabel Label,String player,JLabel arr[]){
			if(Label.getText()=="") {
				if(player=="Player 1") {
					Label.setText("X");
					count++;
					player=Player2;
					player=checkscores(player);
					if(Player2=="Computer" && count>=1) {
						try {
							Computer.Computerplays(arr);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						count++;
						player=Player1;
						player=checkscores(player);
						
						}
				}
				else {
					Label.setText("O");
					count++;
					player=Player1;
					player=checkscores(player);				
				}
			}
			
			return player;
		}
		
		
		String checkscores(String playertochck) {
			int choice;
			
			if(count>=5) {
				ImageIcon icon;
				
				//checking if the 3 labels have the same value
				boolean aligned_r0=(Label_00.getText().equals(Label_01.getText())) && (Label_00.getText().equals(Label_02.getText()));
				boolean aligned_r1=(Label_10.getText().equals(Label_11.getText())) && (Label_10.getText().equals(Label_12.getText()));
				boolean aligned_r2=(Label_20.getText().equals(Label_21.getText())) && (Label_20.getText().equals(Label_22.getText()));
				boolean aligned_c0=(Label_00.getText().equals(Label_10.getText())) && (Label_00.getText().equals(Label_20.getText()));
				boolean aligned_c1=(Label_01.getText().equals(Label_11.getText())) && (Label_01.getText().equals(Label_21.getText()));
				boolean aligned_c2=(Label_02.getText().equals(Label_12.getText())) && (Label_02.getText().equals(Label_22.getText()));
				boolean aligned_d1=(Label_00.getText().equals(Label_11.getText())) && (Label_00.getText().equals(Label_22.getText()));
				boolean aligned_d2=(Label_02.getText().equals(Label_11.getText())) && (Label_02.getText().equals(Label_20.getText()));
				
				
				//there are chances that after 5 times all three labels can be empty so taking care of that condition
				boolean condition1= (aligned_r0 || aligned_c0 || aligned_d1) && (!Label_00.getText().equals(""));
				boolean condition2= (aligned_r1 || aligned_c1 || aligned_d2) && (!Label_11.getText().equals(""));
				boolean condition3= (aligned_r2|| aligned_c2) && (!Label_22.getText().equals(""));
				
				
				if( condition1 || condition2|| condition3) {
					if(playertochck=="Player 1") {
						playertochck=Player2;
						
					}
					else {
						playertochck=Player1;
					}
					
					icon=new ImageIcon("src\\tictactoeGame\\confetti.png");
					String message="Congratulations "+newLine+playertochck+"!!!!!"+newLine+"Wanna play again?";
					choice=JOptionPane.showConfirmDialog(null,message, "Result", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon);
					switch(choice) {
						case JOptionPane.NO_OPTION:if(playertochck==Player1)score_1++;
							   else score_2++;
							   System.exit(0);
							   break;
						case JOptionPane.YES_OPTION:for(int i=0;i<arr.length;i++) arr[i].setText("");
							if(playertochck==Player1) {Player1_score.setText(Integer.toString(++score_1));}
						   	else {Player2_score.setText(Integer.toString(++score_2));}
							count=0;
							playertochck="Player 1";
							break;
								
					}
				}
				boolean checkfor_draw=!Label_00.getText().equals("") && !Label_01.getText().equals("") && !Label_02.getText().equals("")
										&& !Label_10.getText().equals("") && !Label_11.getText().equals("") && !Label_12.getText().equals("")
										&& !Label_20.getText().equals("") && !Label_21.getText().equals("") && !Label_22.getText().equals("");
				if(checkfor_draw) {
					icon=new ImageIcon("src\\tictactoeGame\\handshake.png");
					String message="It's a Draw!!!"+newLine+"Wanna play again?";
					choice=JOptionPane.showConfirmDialog(null,message, "Result", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, icon);
					switch(choice) {
						case JOptionPane.NO_OPTION:System.exit(0);
							   						break;
						case JOptionPane.YES_OPTION:for(int i=0;i<arr.length;i++) arr[i].setText("");
													count=0;
													playertochck="Player 1";
							                        break;
								
					}
				}
				
				}
			return playertochck;
       }
}
