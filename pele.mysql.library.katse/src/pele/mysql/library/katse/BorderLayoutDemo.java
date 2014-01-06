package pele.mysql.library.katse;

/*
 * BorderLayoutDemo.java is a 1.4 application that requires no other files.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutDemo {
    public static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container contentPane) {
//    	Use BorderLayout. Default empty constructor with no horizontal and vertical
//    	gaps
    	contentPane.setLayout(new BorderLayout(0,0)); // siin valin horisontaal- ja vertikaalvahe nuppudele
        if (!(contentPane.getLayout() instanceof BorderLayout)) {
            contentPane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }

        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(
                java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton jbnSampleButtons = new JButton("Button 1 (PAGE_START)");
        contentPane.add(jbnSampleButtons, BorderLayout.PAGE_START);

        
        ImageIcon Kaart1 = new ImageIcon(
        		"D:/temp/kaardid/2/joker/jokerb.png");
        ImageIcon Kaart2 = new ImageIcon(
                "D:/temp/kaardid/2/servad/b1fv.png");
        ImageIcon Kaart3 = new ImageIcon(
        		"D:/temp/kaardid/2/c/c10.png");
        ImageIcon Kaart4 = new ImageIcon(
        		"D:/temp/kaardid/2/c/cQ.png");
        ImageIcon Kaart5 = new ImageIcon(
        		"D:/temp/kaardid/2/c/cK.png");
        ImageIcon Kaart6 = new ImageIcon(
        		"D:/temp/kaardid/2/c/cA.png");
        jbnSampleButtons.setSize(0, 0);
        GridLayout ruudustik = new GridLayout(5,45,0,0); //GridLayout ruudustik = new GridLayout(5,65,0,0);
        ruudustik.equals(Kaart2);
        JPanel kaardikesed = new JPanel();
        kaardikesed.setSize(0, 0);
        kaardikesed.setLayout(ruudustik);
        JButton nuppudeformaat= new JButton("nuppudeformaat");
        nuppudeformaat.setPreferredSize(new Dimension(0, 0));
        int i=0;
        String str="";
      
        	while (i<45){   //while (i<65){ 
        		i++;
        		str=(""+i);
        		if((i==45)||(i==14)||(i==22)||(i==24)||(i==32)){
        			nuppudeformaat=new JButton(Kaart1);
        			if(i==14){
        				nuppudeformaat=new JButton(Kaart3);  
        			}
        			if(i==22){
        				nuppudeformaat=new JButton(Kaart4);
        			}
        			if(i==24){
        				nuppudeformaat=new JButton(Kaart5);
        			}
        			if(i==32){
        				nuppudeformaat=new JButton(Kaart6);
        			}
        			if(i==45){
        				nuppudeformaat=new JButton(Kaart2);
        			}
        			nuppudeformaat.setMargin (new Insets (0, 0, 0, 0));
        			nuppudeformaat.setBorder (null);

        			kaardikesed.add(nuppudeformaat);
        		}else{
        			nuppudeformaat=new JButton(str);
        			nuppudeformaat.setBackground(Color.GRAY);
        			nuppudeformaat.setForeground(Color.GRAY);
        			nuppudeformaat.setMargin (new Insets (0, 0, 0, 0));
        			nuppudeformaat.setBorder (null);
        			nuppudeformaat.setEnabled(false);
        			kaardikesed.add(nuppudeformaat);
        		}
          
          
          
        	}
      jbnSampleButtons.setPreferredSize(new Dimension(40, 40));
      contentPane.add(kaardikesed, BorderLayout.CENTER);
         
        
      jbnSampleButtons = new JButton("Button 3 (LINE_START)");
      jbnSampleButtons.setPreferredSize(new Dimension(80, 80));
      contentPane.add(jbnSampleButtons, BorderLayout.LINE_START);
        
        
      jbnSampleButtons.setSize(40, 100);
      jbnSampleButtons = new JButton( Kaart1); 
        
        
      jbnSampleButtons.setPreferredSize(new Dimension(10, 100));
      contentPane.add(jbnSampleButtons, BorderLayout.PAGE_END);

      jbnSampleButtons = new JButton("5 (LINE_END)");
      jbnSampleButtons.setPreferredSize(new Dimension(80, 80));
      contentPane.add(jbnSampleButtons, BorderLayout.LINE_END);
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("BorderLayout Source Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane and add swing components to it
        addComponentsToPane(frame.getContentPane());

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void start(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    
}
