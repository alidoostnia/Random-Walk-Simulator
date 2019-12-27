/*
 * rape.java
 *
 * Created on May 27, 2009, 5:05 AM
 */

package rape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

//import java.util.Random;

/**
 *
 * @author  Mehran Alidoost Nia
 */
public class rape extends javax.swing.JFrame {
    
	JTextPane resultText = null;
	
    /** Creates new form project */
    public rape() {
    	initComponents(); 	      
       
    }
    
    
    // for making operation NEW ** Javaher
    /**
     * 
     * @param writeInFile : true -> yes write in file  , false : no !
     */
    private void doOperation(boolean writeInFile) { 
		

    	
    	//xx YOU NEED TO MAKE THIS PROGRAM MULTI THREAD FOR DYNAMIC RESPONS xx ** Javaher

        SetReader s=new SetReader();
        s.OpenFile();
        int aa[]=s.ReadFile();
        s.CloseFile();
        jLabel8.setText(String.valueOf(aa[0]));
        jLabel11.setText(String.valueOf(aa[1]));
        jLabel13.setText(String.valueOf(aa[2]));
        jLabel14.setText(String.valueOf(aa[3]));
        jLabel16.setText(String.valueOf(aa[4]));
        
        //initialization process
        int plain=aa[0];
        int flow=aa[1];
        int rf=aa[2];
        int rt=aa[3];
        int sarw=aa[4];
        int dim=aa[5]+2;
        int type[]={aa[6],aa[7],aa[8],aa[9]};
        
        
        //int l=d.Crypt_Dispersion(aa, WIDTH, WIDTH);
        
        /*Assign a=new Assign();
        int b[]=a.Assign_Pack(3);
        for(int i=0;i<8;i++)
        System.out.println(b[i]);*/
        
        /*Random rand=new Random();
        for(int i=0;i<20;i++)
        System.out.println(rand.nextInt(6)); //select random index of pack*/
        
        /*int t[]={163,263,503,88,132,251,128,256};
        RandomWalk r=new RandomWalk();
        r.SRW(3, t, 2000);*/
        /*System.out.println("plain\t"+plain);
        System.out.println("flow\t"+flow);
        System.out.println("rf\t"+rf);
        System.out.println("rt\t"+rt);
        System.out.println("sarw\t"+sarw);
        System.out.println("dim\t"+dim);
        System.out.println("type\t"+aa[6]+"type\t"+aa[7]+"type\t"+aa[8]+"type\t"+aa[9]);

        */

        String result="";
        
        if(writeInFile==false){ // usual job
        	
	        Assign asn=new Assign();
	        int pack[]=asn.Assign_Pack(dim);
	        //System.out.println("packet sequence:"+"\t"+pack[0]+"\t"+pack[1]+"\t"+pack[2]+"\t"+pack[3]+"\t"+pack[4]+"\t"+pack[5]+"\t"+pack[6]+"\t"+pack[7]);
	        result+=("\t"+"packet sequence:"+"\t"+pack[0]+"\t"+pack[1]+"\t"+pack[2]+"\t"+pack[3]+"\t"+pack[4]+"\t"+pack[5]+"\t"+pack[6]+"\t"+pack[7]+"\n\n");
	        RandomWalk r=new RandomWalk();
	        Dispersion dsp=new Dispersion();
	        int CT=dsp.Crypt_Dispersion(type, 4, plain);
	        Object[] obj=new Object[2];
	        if(sarw==1)
	        obj=r.SARW(dim, pack, CT);
	        else
	            obj=r.SRW(dim, pack, CT);
	        int g[][]=(int[][]) obj[0];
	        int step[]=(int[]) obj[1];
	       
	        
	        try {
	        	
	            for(int i=0;i<g.length;i++){ // iterate set to length of array ** JavaHer
	            	//System.out.println(g[i][0]+"\t"+g[i][1]+"\t"+g[i][2]+"\t"+g[i][3]+"\t"+step[i]);
	            	result+=("\t"+g[i][0]+"\t"+g[i][1]+"\t"+g[i][2]+"\t"+g[i][3]+"\t"+step[i]+"\n\n");
	
	            }
	
	        	
	        	
			} catch (IndexOutOfBoundsException e) {
					
				System.err.print("Ran out off indexes !");
				// handled exception ** JavaHer
			}
	        
	        
	        resultText.setText(result);
	        
        }else{ // usual job with file writer ** JavaHer
	        
        	File output=new File("Save/output.txt");

        	try{
        		
            	output.getParentFile().mkdirs(); 
            	output.createNewFile();
            	
        		
    			PrintStream save = new PrintStream(output);		
    			
    			
            	Assign asn=new Assign();
    	        int pack[]=asn.Assign_Pack(dim);

    	        result+=("packet sequence:"+"\t"+pack[0]+"\t"+pack[1]+"\t"+pack[2]+"\t"+pack[3]+"\t"+pack[4]+"\t"+pack[5]+"\t"+pack[6]+"\t"+pack[7]);
    	        RandomWalk r=new RandomWalk();
    	        Dispersion dsp=new Dispersion();
    	        int CT=dsp.Crypt_Dispersion(type, 4, plain);
    	        Object[] obj=new Object[2];
    	        if(sarw==1)
    	        obj=r.SARW(dim, pack, CT);
    	        else
    	            obj=r.SRW(dim, pack, CT);
    	        int g[][]=(int[][]) obj[0];
    	        int step[]=(int[]) obj[1];
    	       
    	        
    	        try {
    	        	
    	            for(int i=0;i<g.length;i++){ //iterate set to length of array ** JavaHer
    	            	//System.out.println(g[i][0]+"\t"+g[i][1]+"\t"+g[i][2]+"\t"+g[i][3]+"\t"+step[i]);
    	            	 result+=("\t"+g[i][0]+"\t"+g[i][1]+"\t"+g[i][2]+"\t"+g[i][3]+"\t"+step[i]+"\n\n");
    	
    	            }
    	
    	        	
    	        	
    			} catch (IndexOutOfBoundsException e) {
    					
    				System.err.print("Ran out off indexes !");
    				// handled exception ** JavaHer
    			}
    			
    	        
    	        save.print(result);
    			save.close();// always close streams !!
    			resultText.setText(result);
    			
    		} catch (Exception e) {
    			
    			System.err.print("Error in output !");
    			e.printStackTrace();
    		}
        	
        	
        	
        	
        }
        
        
        
        
        // reset scroll position to top ** JavaHer
         
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                    scrollPane.getViewport().setViewPosition(new java.awt.Point(0, 0));
            }
        });
		
	}

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random walk-based Anonymous Pattern Emulator (rape)");
        setBackground(new java.awt.Color(204, 204, 255));
        setBounds(300, 200, 0, 0);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(204, 204, 255));
        setResizable(false); // disable resize
        //setMinimumSize(new java.awt.Dimension(100, 100));

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        
        scrollPane = new JScrollPane();
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        resultText = new JTextPane();  // result text object 
        scrollPane.setViewportView(resultText);
        resultText.setEditable(false);
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));
        jLabel1.setText("Simulation Result");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Current Setting");

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 2, 1, new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Size of Data");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("Value");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Number of Flows");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Random Generation");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Value");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Random Type Selection");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 102));
        jLabel13.setText("Value");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 102));
        jLabel14.setText("Value");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("non-intersection");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Value");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        					.addContainerGap())
        				.addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel10))
        							.addGap(0, 2, Short.MAX_VALUE)))
        					.addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jMenu3.setBackground(new java.awt.Color(204, 204, 255));
        jMenu3.setText("Exit");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1.setText("Build");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu1MouseReleased(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        // add item and handler ** JavaHer
        
        jMenu4.setBackground(new java.awt.Color(204, 204, 255));
        jMenu4.setText("Output");
        JMenuItem[] menuItem ={ new JMenuItem("Run Operation "),new JMenuItem("Run and Save output ") };
        
        menuItem[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				

		    	Thread waitJob= new Thread( new Runnable() {
					
					@Override
					public void run() {
				    	resultText.setText(" Please Wait  . . . ");
				    	resultText.validate();
						
					}
				});


		    	Thread calJob= new Thread( new Runnable() {
					
					@Override
					public void run() {
						
						doOperation(false); // only writes on UI 
						
					}
				});
		    	

		    	waitJob.start();
		    	calJob.start();

				scrollPane.repaint();
				resultText.invalidate();
				jPanel1.invalidate();
				jPanel1.revalidate();
				jPanel2.invalidate();
				jPanel2.revalidate();
				
			}
		});

        menuItem[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
		    	Thread waitJob= new Thread( new Runnable() {
					
					@Override
					public void run() {
				    	resultText.setText(" Please Wait  . . . ");
				    	resultText.validate();
						
					}
				});


		    	Thread calJob= new Thread( new Runnable() {
					
					@Override
					public void run() {
						
						doOperation(true); // only writes on UI 
						
					}
				});
		    	

		    	waitJob.start();
		    	calJob.start();

				scrollPane.repaint();
				resultText.invalidate();
				jPanel1.invalidate();
				jPanel1.revalidate();
				jPanel2.invalidate();
				jPanel2.revalidate();
				
			}
		});
        
        
        for(int j=0 ; j<menuItem.length ;  j++)
        	jMenu4.add(menuItem[j]);
        jMenuBar1.add(jMenu4);

        jMenu2.setBackground(new java.awt.Color(204, 204, 255));
        jMenu2.setText("Setting");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu2MouseReleased(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(35)
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(269))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(jLabel1))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
     this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseReleased
       this.dispose();
       //new chart().setVisible(true);
       


        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseReleased

    private void jMenu2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseReleased
        this.dispose();
        new Setting().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseReleased

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       this.dispose();
        new Setting().setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        this.dispose();
        new Setting().setVisible(true);
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MousePressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new rape().setVisible(true);
            }
        });
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JScrollPane scrollPane;
}
