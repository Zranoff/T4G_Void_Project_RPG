/*import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    
    public Fenetre() {
        
        setTitle("Example of Split Pane");
        setSize(150, 150);
        
        JPanel jsp1 = new JPanel();
        JPanel jsp2 = new JPanel();
        JLabel j1 = new JLabel("Area 1");
        JLabel j2 = new JLabel("Area 2");
        
        jsp1.add(j1);
        jsp2.add(j2);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
                true, jsp1, jsp2);
        
        //splitPane.setOneTouchExpandable(true);
        getContentPane().add(splitPane);
        
    }
    public static void main(String[] args) {
        
    	Fenetre sp = new Fenetre();
        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setVisible(true);
    	/*JFrame myFrame = new JFrame("SingSong");
    	myFrame.setLocation(100, 100);
    	myFrame.setSize(new Dimension(1024, 800));

    	GridLayout layout = new GridLayout(20, 1);
    	myFrame.setLayout(layout);

    	JPanel jp = new JPanel();
    	jp.setBackground(new Color(0x00FF00FF));

    	JPanel jp2 = new JPanel(new BorderLayout());
    	jp2.setBackground(new Color(0x00000000));

    	myFrame.add(jp);
    	myFrame.add(jp2);

    	myFrame.setVisible(true);
        
    }
}*/

import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Fenetre extends JFrame{
 
        private Background pan;
        private Background panBarre;
        public JPanel jp_content = new JPanel(new FlowLayout());
    	public JPanel jp_barre_detat = new JPanel(new BorderLayout());
    	public JPanel jp_ecran_map = new JPanel(new BorderLayout());
    	private int window_height = 600;
    	private int window_length = 800;
        private KeyboardInput keyboard = new KeyboardInput();
        private JTextField tf_posX;
        private JTextField tf_posY;
        
        public Fenetre(){
                
                this.setTitle("Prototype");
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocation(200, 100);
                this.add(jp_content, BorderLayout.CENTER);
                this.setVisible(true);
                
                //disposition des elements à l'arrache
                pan = new Background(Color.white, window_length/2-25, (window_height-50)/2-25);
                panBarre = new Background(Color.black, 0, 0);
                GridLayout usefulDataGrid = new GridLayout(0,8);
                jp_content.setPreferredSize(new Dimension(window_length, window_height));
                jp_barre_detat.setPreferredSize(new Dimension(window_length, 40));
                pan.setPreferredSize(new Dimension(window_length, window_height-50));
                panBarre.setPreferredSize(new Dimension(window_length, 40));
                panBarre.setLayout(usefulDataGrid);
                
                //affichage de variables
                tf_posX = new JTextField();
                tf_posY = new JTextField();
                panBarre.add(tf_posX);
                panBarre.add(tf_posY);
                
                jp_ecran_map.add(pan,BorderLayout.CENTER);
        		jp_content.add(panBarre,BorderLayout.NORTH);
        		jp_content.add(jp_ecran_map,BorderLayout.SOUTH);
        		pack();
        		
        		
        		addKeyListener( keyboard );
                go();
        }
        
        private void go(){
            
            //Les coordonnées de départ de notre rond
            int x = pan.getPosX(), y = pan.getPosY();
            //Le booléen pour savoir si on recule ou non sur l'axe X
            boolean backXleft = false;
            //Le booléen pour savoir si on recule ou non sur l'axe Y
            boolean backYtop = false;
            boolean backXright = false;
            boolean backYbot = false;
            
            //Pour cet exemple, j'utilise une boucle while
            //Vous verrez qu'elle fonctionne très bien
            while(true){
                    
            		keyboard.poll();
            		if( keyboard.keyDownOnce( KeyEvent.VK_ESCAPE ) )
            			break;
            	
                    //Si la coordonnée x est inférieure à 1
                    backXleft = x < 1;
                    //Si la coordonnée x est supérieure à la taille du Panneau
                    //moins la taille du rond
                    backXright = x > pan.getWidth()-50;
                    
                    //idem pour l'axe Y
                    backYtop = y < 1;
                    backYbot = y > pan.getHeight()-50;
                    
                    //Si on avance, on incrémente la coordonnée
                    if(!backXright && keyboard.keyDown( KeyEvent.VK_RIGHT ))
                            pan.setPosX(++x);
                    //Sinon, on décrémente
                    if(!backXleft && keyboard.keyDown( KeyEvent.VK_LEFT ))
                            pan.setPosX(--x);
                    
                    //Idem pour l'axe Y
                    if(!backYbot && keyboard.keyDown( KeyEvent.VK_DOWN ))
                            pan.setPosY(++y);
                    if(!backYtop && keyboard.keyDown( KeyEvent.VK_UP ))
                            pan.setPosY(--y);
                    
                    //mise a jour de l'affichage des variables
                    tf_posX.setText(Integer.toString(x));
                    tf_posY.setText(Integer.toString(y));     
                    //On redessine notre Panneau
                    pan.repaint();
                    
                    //Comme on dit : la pause s'impose ! Ici, 3 millièmes de secondes
                    try {
                            Thread.sleep(3);
                    } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
            }
            
    }
}