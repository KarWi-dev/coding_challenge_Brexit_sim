package brexit_sim;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CL_gui
{
	//=====================================================================================================
	// declare static so CL_filehandler can access them:
	static JFrame frame;
	static JLabel lb_r1;
	static JLabel lb_r2;
	static JLabel lb_r3;
	static JLabel lb_r4;
	static JProgressBar pb_r1;
	static JProgressBar pb_r2;
	static JProgressBar pb_r3;
	static JProgressBar pb_r4;
	
	//=====================================================================================================
	// constructor:
	public CL_gui()
	{		
		//=====================================================================================================
		// create frame, set layout, set size:
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(425, 400);
		
		//=====================================================================================================
		// set frame icon:
		ImageIcon img = new ImageIcon("bg.png");
		frame.setIconImage(img.getImage());

		// TODO backgroud image
		
		//=====================================================================================================
		// generate fixed info labels:
		JLabel lb_newref = new JLabel("New Referendum:", SwingConstants.CENTER);
		lb_newref.setBounds(15, 55, 160, 25);
		lb_newref.setOpaque(true); // needed to show BG color
		lb_newref.setBackground(Color.LIGHT_GRAY); // set BG color

		JLabel lb_killbj = new JLabel("Kill Boris:", SwingConstants.CENTER);
		lb_killbj.setBounds(15, 85, 160, 25);
		lb_killbj.setOpaque(true); // needed to show BG color
		lb_killbj.setBackground(Color.LIGHT_GRAY); // set BG color

		JLabel lb_killbg = new JLabel("Kill Brussels guys:", SwingConstants.CENTER);
		lb_killbg.setBounds(15, 115, 160, 25);
		lb_killbg.setOpaque(true); // needed to show BG color
		lb_killbg.setBackground(Color.LIGHT_GRAY); // set BG color

		JLabel lb_part = new JLabel("Become part of Germany:", SwingConstants.CENTER);
		lb_part.setBounds(15, 145, 160, 25);
		lb_part.setOpaque(true); // needed to show BG color
		lb_part.setBackground(Color.LIGHT_GRAY); // set BG color
		
		//=====================================================================================================
		// generate dynamic labels for output
		lb_r1 = new JLabel("%", SwingConstants.CENTER);
		lb_r1.setBounds(180, 55, 50, 25);
		lb_r1.setOpaque(true); // needed to show BG color
		lb_r1.setBackground(Color.LIGHT_GRAY); // set BG color

		lb_r2 = new JLabel("%", SwingConstants.CENTER);
		lb_r2.setBounds(180, 85, 50, 25);
		lb_r2.setOpaque(true); // needed to show BG color
		lb_r2.setBackground(Color.LIGHT_GRAY); // set BG color

		lb_r3 = new JLabel("%", SwingConstants.CENTER);
		lb_r3.setBounds(180, 115, 50, 25);
		lb_r3.setOpaque(true); // needed to show BG color
		lb_r3.setBackground(Color.LIGHT_GRAY); // set BG color

		lb_r4 = new JLabel("%", SwingConstants.CENTER);
		lb_r4.setBounds(180, 145, 50, 25);
		lb_r4.setOpaque(true); // needed to show BG color
		lb_r4.setBackground(Color.LIGHT_GRAY); // set BG color
		
		//=====================================================================================================
		// create dynamic progress bars for output
		pb_r1 = new JProgressBar();
		pb_r1.setBounds(235, 55, 160, 25);
		pb_r1.setValue(50);
		
		pb_r2 = new JProgressBar();
		pb_r2.setBounds(235, 85, 160, 25);
		pb_r2.setValue(50);
		
		pb_r3 = new JProgressBar();
		pb_r3.setBounds(235, 115, 160, 25);
		pb_r3.setValue(50);
		
		pb_r4 = new JProgressBar();
		pb_r4.setBounds(235, 145, 160, 25);
		pb_r4.setValue(50);
		//=====================================================================================================
		// create the button that initializes the calculation and the rest. -> see CL_filehandler:
		JButton bt_sim = new JButton("Simulieren");
		bt_sim.setBounds(15, 15, 160, 25);
		bt_sim.addActionListener((ActionEvent e) -> CL_filehandler.init());
		
		//=====================================================================================================
		// adding elements to frame:
		frame.add(lb_newref);
		frame.add(lb_killbj);
		frame.add(lb_killbg);
		frame.add(lb_part);
		frame.add(lb_r1);
		frame.add(lb_r2);
		frame.add(lb_r3);
		frame.add(lb_r4);
		frame.add(bt_sim);
		frame.add(pb_r1);
		frame.add(pb_r2);
		frame.add(pb_r3);
		frame.add(pb_r4);
		
		//=====================================================================================================
		// final settings for frame:
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
