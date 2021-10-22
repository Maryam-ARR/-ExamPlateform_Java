package classes;
import java.sql.SQLException;
import java.util.Timer;
	import java.util.TimerTask;

import javax.swing.JLabel;

import Application.Application;


public class TimerDown {
	
	public static void main(String[] args) throws SQLException {
		TimerDown T=new TimerDown();
		//T.runTimer(300);
	}
		
	
	
	
	public void runTimer(int i,JLabel lbl){
		Timer timer = new Timer();
		TimerTask task = null;
	
		task= new TimerTask(){
			int k=i;
		public void run(){
			if(k>0) {
			String time = getTime(k);
			lbl.setText(time);
			}
			else {
				lbl.setText("00:00:00");
			}
			k--;
			
			}
	};
		timer.schedule(task, 0, 1000 );
	}


	String getTime(int sec)
	{
	    int hours = 0;
	    int remainderOfHours = 0;
	    int minutes = 0;
	    int seconds = 0;

	    if (sec >= 3600)    
	    {
	        hours = sec / 3600;               
	        remainderOfHours = sec % 3600;  

	        if (remainderOfHours >= 60)  
	        {
	            minutes = remainderOfHours / 60;
	            seconds = remainderOfHours % 60;
	        }
	        else
	        {                    
	            seconds = remainderOfHours;
	        }
	    }
	   
	    else if (sec >= 60)                
	    {      //62
	        minutes = sec / 60;
	        seconds = sec % 60;
	    }
	    else if (sec < 60)
	    {
	        hours = 0;
	        minutes = 0;
	        seconds = sec;
	    } 
	    String strHours;
	    String strMins; 
	    String strSecs; 

	    if(seconds < 10)
	    	strSecs = "0" + Integer.toString(seconds);
	    else
	    	strSecs = Integer.toString(seconds);
	   
	    if(minutes < 10)
	   	 strMins = "0" + Integer.toString(minutes);
	   else
		   strMins = Integer.toString(minutes);
	    
	    if(hours < 10)
	    	strHours = "0" + Integer.toString(hours);
	      else
	    	  strHours = Integer.toString(hours);
	    	
	        
	    String time = strHours + ":" + strMins + ":" + strSecs;
	    return time;
	}



	

	
}
