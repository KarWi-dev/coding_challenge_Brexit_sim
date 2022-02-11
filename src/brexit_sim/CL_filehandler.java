package brexit_sim;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;

public class CL_filehandler
{
	//=====================================================================================================
	// init is called by the button it initializes the rest:
	public static void init()
	{
		//=====================================================================================================
		// set / reset the element colors for new output
		CL_gui.lb_r1.setBackground(Color.lightGray);
		CL_gui.lb_r2.setBackground(Color.lightGray);
		CL_gui.lb_r3.setBackground(Color.lightGray);
		CL_gui.lb_r4.setBackground(Color.lightGray);
		
		CL_gui.pb_r1.setForeground(Color.lightGray);
		CL_gui.pb_r2.setForeground(Color.lightGray);
		CL_gui.pb_r3.setForeground(Color.lightGray);
		CL_gui.pb_r4.setForeground(Color.lightGray);
		
		//=====================================================================================================
		// doing stuff here:
		calc();
		fill();
		
		try {save();} catch (IOException e){e.printStackTrace();}
		
		// TODO if result = 1 or 2 start CL_gui_msg.order() or CL_gui_msg.putin()	
	}

	//=====================================================================================================
	//here the calculation takes part and also the single results get saved in CL_main.result[]:
	public static void calc()
	{
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		
		//=====================================================================================================
		// doing 650 votes with math.random() gives int value between 0 and 1:
		int i = 650;
		
		while (i > 0)
		{
			double x = Math.random();
			
			if (x <= 0.25) {a += 1;}
			else if (x > 0.25 && x <= 0.5) {b += 1;}
			else if (x > 0.5 && x <= 0.75) {c += 1;}
			else if (x > 0.75 ) {d += 1;}
			i -= 1;
		}
		
		//=====================================================================================================
		// result get calculated from the random votes and saved in the respective spot in CL_main.result[]:
		CL_main.result[1] = (a * 100) / 650;
		CL_main.result[2] = (b * 100) / 650;
		CL_main.result[3] = (c * 100) / 650;
		CL_main.result[4] = (d * 100) / 650;
		
		}
	
	//=====================================================================================================
	//fills label and prograss bars with values:
	public static void fill()
	{
		//=====================================================================================================
		//label and prograssbar of winner change color to green:
		if(CL_main.result[1] > CL_main.result[2] && CL_main.result[1] > CL_main.result[3] && CL_main.result[1] > CL_main.result[4]) {CL_main.result[0] = 1; CL_gui.lb_r1.setBackground(Color.GREEN); CL_gui.pb_r1.setForeground(Color.green);;}
		else if(CL_main.result[2] > CL_main.result[1] && CL_main.result[2] > CL_main.result[3] && CL_main.result[2] > CL_main.result[4]) {CL_main.result[0] = 2; CL_gui.lb_r2.setBackground(Color.GREEN); CL_gui.pb_r2.setForeground(Color.green);}
		else if(CL_main.result[3] > CL_main.result[1] && CL_main.result[3] > CL_main.result[2] && CL_main.result[3] > CL_main.result[4]) {CL_main.result[0] = 3; CL_gui.lb_r3.setBackground(Color.GREEN); CL_gui.pb_r3.setForeground(Color.green);}
		else if(CL_main.result[4] > CL_main.result[2] && CL_main.result[4] > CL_main.result[3] && CL_main.result[4] > CL_main.result[1]) {CL_main.result[0] = 4; CL_gui.lb_r4.setBackground(Color.GREEN); CL_gui.pb_r4.setForeground(Color.green);}
	
		//=====================================================================================================
		// sets label and prograss bar value to respective spot in result[] limiting decimal to 2 behind point:
		String s = Double.toString(CL_main.result[0]);
		
		CL_gui.lb_r1.setText(String.format("%.2f", CL_main.result[1]) + "%");
		CL_gui.pb_r1.setValue((int) CL_main.result[1]);
		
		s = Double.toString(CL_main.result[2]);
		CL_gui.lb_r2.setText(String.format("%.2f", CL_main.result[2]) + "%");
		CL_gui.pb_r2.setValue((int) CL_main.result[2]);
		
		s = Double.toString(CL_main.result[3]);
		CL_gui.lb_r3.setText(String.format("%.2f", CL_main.result[3]) + "%");
		CL_gui.pb_r3.setValue((int) CL_main.result[3]);
		
		s = Double.toString(CL_main.result[4]);
		CL_gui.lb_r4.setText(String.format("%.2f", CL_main.result[4]) + "%");
		CL_gui.pb_r4.setValue((int) CL_main.result[4]);
		
	}
	
	//=====================================================================================================
	// here the result gets formatted into a string and is saved in a txt file:
	public static void save() throws IOException
	{
		// TODO string builder
		String tosave = String.format("%.0f", CL_main.result[0]) + " | " + String.format("%.2f", CL_main.result[1]) + " | " + String.format("%.2f", CL_main.result[1])
						+ " | " + String.format("%.2f", CL_main.result[1]) + " | " + String.format("%.2f", CL_main.result[1]);
		
		FileWriter fw_schreiben = new FileWriter("voting_results.txt", true);
		
		fw_schreiben.write(tosave + "\n");
		fw_schreiben.close();
	}	
}
