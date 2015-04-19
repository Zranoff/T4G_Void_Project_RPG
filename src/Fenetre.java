
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

public class Fenetre extends JFrame {

	private Background pan;
	private Background panBarre;
	private JPanel jp_content = new JPanel(new FlowLayout());
	private JPanel jp_barre_detat = new JPanel(new BorderLayout());
	private JPanel jp_ecran_map = new JPanel(new BorderLayout());
	private int window_height = 600;
	private int window_length = 800;
	private KeyboardInput keyboard = new KeyboardInput();
	private JTextField tf_posX;
	private JTextField tf_posY;

	public Fenetre() {

		this.setTitle("Prototype");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 100);
		this.add(jp_content, BorderLayout.CENTER);
		this.setVisible(true);

		// disposition des elements à l'arrache
		pan = new Background(Color.white, window_length / 2 - 25,
				(window_height - 50) / 2 - 25);
		panBarre = new Background(Color.black, 0, 0);
		GridLayout usefulDataGrid = new GridLayout(0, 8);
		jp_content
				.setPreferredSize(new Dimension(window_length, window_height));
		jp_barre_detat.setPreferredSize(new Dimension(window_length, 40));
		pan.setPreferredSize(new Dimension(window_length, window_height - 50));
		panBarre.setPreferredSize(new Dimension(window_length, 40));
		panBarre.setLayout(usefulDataGrid);

		// affichage de variables
		tf_posX = new JTextField();
		tf_posY = new JTextField();
		panBarre.add(tf_posX);
		panBarre.add(tf_posY);

		// insertion des elements
		jp_ecran_map.add(pan, BorderLayout.CENTER);
		jp_content.add(panBarre, BorderLayout.NORTH);
		jp_content.add(jp_ecran_map, BorderLayout.SOUTH);

		// generation de l'ensemble des composants de l'interface
		pack();

		addKeyListener(keyboard);
		go();
	}

	private void go() {

		// Les coordonnées de départ de notre rond
		// Le booléen pour savoir si on recule ou non sur l'axe X
		boolean backXleft = false;
		// Le booléen pour savoir si on recule ou non sur l'axe Y
		boolean backYtop = false;
		boolean backXright = false;
		boolean backYbot = false;
		Displacement mouvement = new Displacement(pan.getPosX(), pan.getPosY());

		while (true) {

			keyboard.poll();

			if (keyboard.keyDownOnce(KeyEvent.VK_ESCAPE))
				break;

			mouvement.input_treatment(keyboard, pan);

			// mise a jour de l'affichage des variables
			tf_posX.setText(Integer.toString(mouvement.getNewX()));
			tf_posY.setText(Integer.toString(mouvement.getNewY()));
			
			// On redessine notre Panneau
			pan.repaint();

			try {
				Thread.sleep(10);// 100fps
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}