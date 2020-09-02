package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gui.oyentes.OyenteBoton;
import gui.oyentes.OyenteMenu;

@SuppressWarnings("serial")
public class InterfazDeUsuario extends JFrame {

	public InterfazDeUsuario() {
		// Asignar nombre a la ventana
		super("Turistiar");

		// Asignar aspectos basicos de la ventana
		this.setMinimumSize(new Dimension(450, 650));
		this.setSize(450, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		// Labels
		JLabel bienvenida = new JLabel(
				"<html><center><font size=6><center>Bienvenidos a</center></font><font size=7><center>TURISTIAR 8====D</center></font></center></html>");
		JLabel L1 = new JLabel("Presupuesto: ");
		L1.setToolTipText("<html>Es tu presupuesto en dolares [2000,30000]</html>");
		JLabel L2 = new JLabel("Clima: ");
		L2.setToolTipText("<html>Es la calificación de que tan propenso <br> es el estatus a cambiar. [0,1]</html>");
		JLabel L3 = new JLabel("Numero de dias: ");
		L3.setToolTipText("<html>Es la cantidad de dias que piensas hacer turismo, [0,30] </html>");
		JLabel L4 = new JLabel("Costo de vida: ");
		L4.setToolTipText("<html>Es el indice de costos del lugar que te gustaria ir, [49,279] </html>");
		

		// Campo de texto
		JTextField T1 = new JTextField(9);
		JTextField T2 = new JTextField(9);
		JTextField T3 = new JTextField(9);
		JTextField T4 = new JTextField(9);

		// Area de texto
		JTextArea TA1 = new JTextArea(18, 38);

		// Botones
		JButton B1 = new JButton("Enviar");
		B1.setActionCommand("Enviar");
		B1.addActionListener(new OyenteBoton(T1, T2, T3,T4, TA1));

		// Panel scroll
		JScrollPane JS1 = new JScrollPane(TA1);
		JS1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Paneles
		JPanel P1 = new JPanel();

		JPanel P1_1 = new JPanel();

		JPanel P2 = new JPanel();
		P2.setLayout(new BorderLayout());

		JPanel P2_0 = new JPanel();
		P2_0.setLayout(new BorderLayout());

		JPanel P2_1 = new JPanel();
		P2_1.setLayout(new GridLayout(4, 1));

		JPanel P2_2 = new JPanel();
		P2_2.setLayout(new BorderLayout());

		JPanel P2_1_1 = new JPanel();
		JPanel P2_1_2 = new JPanel();
		JPanel P2_1_3 = new JPanel();
		JPanel P2_1_4 = new JPanel();
		JPanel P2_1_5 = new JPanel();
		JPanel P2_1_6 = new JPanel();
		JPanel P2_1_7 = new JPanel();
		JPanel P2_1_8 = new JPanel();

		JPanel P2_2_1 = new JPanel();
		JPanel P2_2_2 = new JPanel();
		JPanel P2_2_3 = new JPanel();

		JPanel P3 = new JPanel();

		JPanel P3_1 = new JPanel();

		// Menu
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu archivo = new JMenu("Archivo");
		JMenu ayuda = new JMenu("Ayuda");

		JMenuItem salir = new JMenuItem("Salir");
		JMenuItem ver_ayuda = new JMenuItem("Ver ayuda");
		JMenuItem info = new JMenuItem("Acerca de nosotros");

		salir.setActionCommand("Salir");
		salir.addActionListener(new OyenteMenu());

		ver_ayuda.setActionCommand("Ayuda");
		ver_ayuda.addActionListener(new OyenteMenu());

		info.setActionCommand("Info");
		info.addActionListener(new OyenteMenu());

		menuBar.add(archivo);
		menuBar.add(ayuda);

		archivo.add(salir);

		ayuda.add(ver_ayuda);
		ayuda.add(info);

		// Asignacion de paneles
		this.add(P1, BorderLayout.NORTH);
		this.add(P2, BorderLayout.CENTER);
		this.add(P3, BorderLayout.SOUTH);

		P1.add(P1_1);
		P1.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));

		P1_1.add(bienvenida);

		P2.add(P2_0, BorderLayout.CENTER);

		P2_0.add(P2_1, BorderLayout.CENTER);
		P2_0.add(P2_2, BorderLayout.SOUTH);
		P2_0.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 15));

		P2_1.add(P2_1_4);
		P2_1.add(P2_1_1);
		P2_1.add(P2_1_5);
		P2_1.add(P2_1_2);
		P2_1.add(P2_1_6);
		P2_1.add(P2_1_3);
		P2_1.add(P2_1_7);
		P2_1.add(P2_1_8);
		
		// P2_1.setBorder(BorderFactory.createEmptyBorder(5,15,15,15));

		P2_1_1.add(T1);
		P2_1_2.add(T2);
		P2_1_3.add(T3);
		P2_1_8.add(T4);
		P2_1_4.add(L1);
		P2_1_5.add(L2);
		P2_1_6.add(L3);
		P2_1_7.add(L4);

		P2_2.add(P2_2_1, BorderLayout.EAST);
		P2_2.add(P2_2_2, BorderLayout.CENTER);
		P2_2.add(P2_2_3, BorderLayout.WEST);

		P2_2_2.add(B1);

		P3.add(P3_1);

		P3_1.add(JS1);
	}
}
