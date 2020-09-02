package gui.oyentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class OyenteBoton implements ActionListener{

	JTextField T1;
	JTextField T2;
	JTextField T3;
	JTextField T4;
	JTextArea TA1;
	
	public OyenteBoton(JTextField t1, JTextField t2, JTextField t3,JTextField t4, JTextArea ta1) {
		// TODO Auto-generated constructor stub
		T1 = t1;
		T2 = t2;
		T3 = t3;
		T4 = t4;
		TA1 = ta1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (e.getSource() instanceof JButton) {
			if("Enviar".equals(actionCommand)) {
				FIS sostenibilidad = FIS.load("src/fuzzy/fine-e.fcl", true);
				
				// Set inputs
				sostenibilidad.setVariable("estatus", Double.parseDouble(T1.getText()));
				sostenibilidad.setVariable("presion", Double.parseDouble(T2.getText()));
				sostenibilidad.setVariable("respuesta", Double.parseDouble(T3.getText()));
		        
		        // Evaluate
				sostenibilidad.evaluate(); 

		        //Graficas de conjuntos difusos
		        JFuzzyChart.get().chart(sostenibilidad.getFunctionBlock("sostenibilidad"));

		        // Show output variable
		        /**
		        TA1.setText(sostenibilidad.getVariable("isa").toString());
		        */
		        TA1.setText(TA1.getText() + "El Indicador de Sostenibilidad Ambiental (ISA) es: " + sostenibilidad.getVariable("isa").defuzzify());		        
		        TA1.setText(TA1.getText() + "\n \n" + "El metodo usado para 'defuzzificar' el ISA fue: " + sostenibilidad.getVariable("isa").getDefuzzifier());
		        TA1.setText(TA1.getText() + "\n \n" + "El grado de pertenencia a los conjuntos difusos es: ");
		        TA1.setText(TA1.getText() + "\n" + "	'muy bajo': " + sostenibilidad.getVariable("isa").getMembership("muy_bajo"));
		        TA1.setText(TA1.getText() + "\n" + "	'bajo': " + sostenibilidad.getVariable("isa").getMembership("bajo"));
		        TA1.setText(TA1.getText() + "\n" + "	'intermedio': " + sostenibilidad.getVariable("isa").getMembership("intermedio"));
		        TA1.setText(TA1.getText() + "\n" + "	'alto': " + sostenibilidad.getVariable("isa").getMembership("alto"));
		        TA1.setText(TA1.getText() + "\n" + "	'muy alto': " + sostenibilidad.getVariable("isa").getMembership("muy_alto"));
		        TA1.setText(TA1.getText() + "\n \n" + "El Indicador de Sostenibilidad Ambiental (ISA) es una medida de 0 a 1, \n"
		        									+ "que dice aproximadamente que tan sostenible puede llegar a ser un\n "
		        									+ "proyecto ambientalmente.\n"
		        									+ "Siendo 0 poco sostenible y 1 muy sostenible.");
		        TA1.setEditable(false);
			}
		}
	}
}
