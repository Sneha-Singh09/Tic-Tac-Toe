package tictactoeGame;
import java.util.Random;

import javax.swing.JLabel;

public class Computer {
	 public static void Computerplays(JLabel arr[]) throws InterruptedException {
		
		 GameTime.player=GameTime.Player1;
//		first move
//		 Thread.sleep(1000);
     	if(GameTime.count==1) {
	        	Random rnd=new Random();
	        	int firstmove=rnd.nextInt(9);
	        	if(arr[firstmove].getText()=="X") {
	        		firstmove=rnd.nextInt(9);
                  
	        		arr[firstmove].setText("O");
	        	}
	        	else {
	        		 
	        		arr[firstmove].setText("O");
	        	}
	        	
         }
     	else {
     		int move=0;
     		int i;
//     		move to win 
     		for(i=0;i<=6;i++) {
     			move=SetXorO(arr,i,"O");
     		    if(move==1) break;	
     		}
     		if(move==0) {
	     		for(i=0;i<=6;i++) {
	     			move=SetXorO(arr,i,"X");
	     		    if(move==1) break;		
	     		}
	     	}
	     	if(move==0) {
	     		for(i=0;i<arr.length;i++) {
	     			move=SetO(arr,i);
	     			if(move==1) break;
	     		}
     		}
//	     	when only 2 labels are left and the game is almost drawn as nothing can be done now
	     	if(move==0) {
	     		for(i=0;i<arr.length;i++) {
	     			if(arr[i].getText().equals("")){
	     				arr[i].setText("O");
	     				break;
	     			}
	     		}
	     	}
	     	
     	}
	 }
	 public static int SetO(JLabel arr[],int index){
		int sign;
  		if(arr[index].getText().equals("O")) {
	  		if(index==0 || index==8) {
	  			if (index==0) sign=1;
					else sign=-1;
	  			if(arr[index+(1*sign)].getText().equals("") && arr[index+(2*sign)].getText().equals("")) {
	  				arr[index+(1*sign)].setText("O");
	  				return 1;
	  			}
	  			else if(arr[index+(3*sign)].getText().equals("") && arr[index+(6*sign)].getText().equals("")) {
	  				if(arr[index+(sign*2)].getText().equals("") || arr[index+(sign*8)].getText().equals("")) {
	  					arr[index+(6*sign)].setText("O");
	  					return 1;
	  				}
	  				else { arr[index+(3*sign)].setText("O");
	  				       return 1;
	  				}
	  			}
	  			else {
	  				if(arr[index+(4*sign)].getText().equals("") && arr[index+(8*sign)].getText().equals("")){
	  					arr[index+(4*sign)].setText("O");
	  					return 1;
	  				}
	  			}
	  		}
	  		else if(index==2 || index==6) {
     			if (index==2) sign=1;		
				else sign=-1;
     			if(arr[index-(1*sign)].getText().equals("") && arr[index-(2*sign)].getText().equals("")) {
     				arr[index-(2*sign)].setText("O");
     				return 1;
     			}
     			else if(arr[index+(3*sign)].getText().equals("") && arr[index+(6*sign)].getText().equals("")) {
     				if(arr[index-(sign*2)].getText().equals("") || arr[index+(sign*4)].getText().equals("")) {
     					arr[index+(6*sign)].setText("O");
     					return 1;
     				}
     				else { arr[index+(3*sign)].setText("O");
     				       return 1;
     				}
     			}
     			else {
     				if(arr[index+(2*sign)].getText().equals("") && arr[index+(4*sign)].getText().equals("")){
     					arr[index+(2*sign)].setText("O");
     					return 1;
     				}
     			}
     		}
	  		//
//     		for label 1 and 7
	  		else if(index==1 || index==7) {
     			if (index==1) sign=1;
				else 	sign=-1;
     			if(arr[index-(1*sign)].getText().equals("") && arr[index+(1*sign)].getText().equals("")) {
     				arr[index-(1*sign)].setText("O");
     				return 1;
     			}
     			else {             
     				if(arr[index+(3*sign)].getText().equals("") && arr[index+(6*sign)].getText().equals("")) {
	     				if(arr[index-(sign*1)].getText().equals("") || arr[index+(sign*1)].getText().equals("")) {
	     					arr[index+(3*sign)].setText("O");
	     					return 1;
	     				}
	     				else { arr[index+(6*sign)].setText("O");
	     				       return 1;
	     				}
     			    }
     			}
     		}
//     		for label 3 and 5
	  		else if(index==3 || index==5) {
     			if (index==3) sign=1;
				else sign=-1;
     			if(arr[index-(3*sign)].getText().equals("") && arr[index+(3*sign)].getText().equals("")) {
     				arr[index-(3*sign)].setText("O");
     				return 1;
     			}
     			else {             
     				if(arr[index+(1*sign)].getText().equals("") && arr[index+(2*sign)].getText().equals("")) {
	     				if(arr[index-(sign*3)].getText().equals("") || arr[index+(sign*5)].getText().equals("")) {
	     					arr[index+(1*sign)].setText("O");
	     					return 1;
	     				}
	     				else { arr[index+(2*sign)].setText("O");
	     				       return 1;
	     				}
     			    }
     			}
     		}
//	  		if 0 is already there at label 11 then the comp can add 0 and try to win 
//	  		the combinations are 00,11,22 || 01,11,21 || 02,11,20 || 10,11,12 
//	  		now in the array label 11 is at 4th index so we can -4&+4 || -3&+3 || -2&+2|| -1&+1 to the index
	  		else if(index==4){
	  			for(int num=1;num<=4;num++)
	  			if(arr[(index-num)].getText().equals("")&& arr[(index+num)].getText().equals("")){
	  				arr[(index-num)].setText("O");
	  				return 1;
	  			}
	  		}
	  	}
  		return 0;
  		}
	
	 public static int SetXorO(JLabel arr[],int index,String XorO) {
			boolean cond1=arr[index].getText().equals(arr[index+1].getText());
			boolean	cond2= arr[index].getText().equals(arr[index+2].getText());
			boolean	cond3=arr[index+1].getText().equals(arr[index+2].getText());
				if(index==0|| index==3||index==6){
					 if(cond1 || cond2 || cond3) {
						 if(arr[index].getText().equals(XorO)) {
								if(arr[index+1].getText().equals(XorO) && arr[index+2].getText().equals("")) {
									arr[index+2].setText("O");
									return 1;
								}
								else if(arr[index+2].getText().equals(XorO) && arr[index+1].getText().equals("")) {
									arr[index+1].setText("O");	
									return 1;
								}
							}
						 else if(arr[index+1].getText().equals(XorO)){
						    	if(arr[index+2].getText().equals(XorO) && arr[index].getText().equals("")) {
						    		arr[index].setText("O");  
						    		return 1;
						    	}
						   }
					 }
				 }
// 			for label 00,01,02
	 			if(index==0|| index==1||index==2){
	 				boolean cond4=arr[index].getText().equals(arr[index+3].getText());
	     			boolean cond5=arr[index].getText().equals(arr[index+6].getText());
	     			boolean cond6=arr[index+6].getText().equals(arr[index+3].getText());
	 				if( cond4 || cond5 || cond6 ) {
	 					if(arr[index].getText().equals(XorO) ) {
	 						if(arr[index+3].getText().equals(XorO) && arr[index+6].getText().equals("")) {
	 							arr[index+6].setText("O");
	 							return 1;
	 						}
	 						else if(arr[index+6].getText().equals(XorO) && arr[index+3].getText().equals("")) {
	 							arr[index+3].setText("O");
	 							return 1;
	 						}
	 					}
	 					else if(arr[index+3].getText().equals(XorO)){
	 				    	if(arr[index+6].getText().equals(XorO) && arr[index].getText().equals("")) {
 				    		arr[index].setText("O");
 				    		return 1;
	 				    	}
	 					}
	 				}
	 			}
	 			if(index==0) {
	     			if(arr[index].getText().equals(arr[index+4].getText()) || arr[index].getText().equals(arr[index+8].getText()) || arr[index+4].getText().equals(arr[index+8].getText())) {
	     				if(arr[index].getText().equals(XorO)) {
	 						if(arr[index+4].getText().equals(XorO) && arr[index+8].getText().equals("")) {
	 							arr[index+8].setText("O");
	 							return 1;
	 						}
	 						else if(arr[index+8].getText().equals(XorO) && arr[index+4].getText().equals("")) {
	 							arr[index+4].setText("O");
	 							return 1;
	 						}
	 					}
	     				else if(arr[index+4].getText().equals(XorO)){
	 				    	if(arr[index+8].getText().equals(XorO) && arr[index].getText().equals("")) {
	 				    		arr[index].setText("O");
	 				    		return 1;
	 				    	}
	 				    }
	     			}
	     		}
 			//
	 			if(index==2) {
	     			if(arr[index].getText().equals(arr[index+4].getText()) || cond2 || arr[index+2].getText().equals(arr[index+4].getText())) {
	     				if(arr[index].getText().equals(XorO)) {
	 						if(arr[index+2].getText().equals(XorO) && arr[index+4].getText().equals("")) {
	 							arr[index+4].setText("O");
	 							return 1;
	 						}
	 						else if(arr[index+4].getText().equals(XorO) && arr[index+2].getText().equals("")) {
	 							arr[index+2].setText("O");
	 							return 1;
	 						}
	 					}
	     				else if(arr[index+4].getText().equals(XorO)){
	 				    	if(arr[index+2].getText().equals(XorO) && arr[index].getText().equals("")) {
	 				    		arr[index].setText("O");
	 				    		return 1;
	 				    	}
	 				    }	    
	     			}
	     		}
			return 0;
	 }
}