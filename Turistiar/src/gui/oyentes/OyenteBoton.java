package gui.oyentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import java.util.ArrayList;

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
				FIS fis = FIS.load("src/fuzzy/turistear.fcl", true);
				
				/// Set inputs
		        fis.setVariable("presupuesto", Double.parseDouble(T1.getText()));
		        fis.setVariable("clima", Double.parseDouble(T2.getText()));
		        fis.setVariable("dias_de_estadia", Double.parseDouble(T3.getText()));
		        fis.setVariable("costo_vida", Double.parseDouble(T4.getText()));
		        
		        // Evaluate
				fis.evaluate(); 

				// Show
		        JFuzzyChart.get().chart(fis.getFunctionBlock("turistear"));
		        
		        Double x = fis.getVariable("hotel").getLatestDefuzzifiedValue();
		        Double y = fis.getVariable("lugar").getLatestDefuzzifiedValue();
		        System.err.println("Para los valores de salida el grado de pertenencia para hotel es: " + x);
		        System.err.println("Para los valores de salida el grado de pertenencia para luagar es: " + y);
		        
		        ArrayList<Double> array_tipo =  new ArrayList<Double>();
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo1"));
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo2"));
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo3"));
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo4"));
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo5"));
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo6"));
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo7"));
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo8"));
		        array_tipo.add(fis.getVariable("lugar").getMembership("tipo9"));
		        
		        String tipo = get_tipo(array_tipo);
		        System.out.println(tipo);
		        
		        ArrayList<String> array_ciudades =  new ArrayList<String>();
		        array_ciudades = get_ciudades(tipo);
		        		        
		        ArrayList<Double> array_hotel =  new ArrayList<Double>();
		        array_hotel.add(fis.getVariable("hotel").getMembership("D"));
		        array_hotel.add(fis.getVariable("hotel").getMembership("E"));
		        array_hotel.add(fis.getVariable("hotel").getMembership("B"));
		        array_hotel.add(fis.getVariable("hotel").getMembership("A"));
		        array_hotel.add(fis.getVariable("hotel").getMembership("AA"));
		        
		        
		        String hotel = get_hotel(array_hotel);
		        // Show output variable
		        /**
		        TA1.setText(sostenibilidad.getVariable("isa").toString());
		        */
		        TA1.setText(TA1.getText() + "Según tus preferencias se te recomienda: \n \n - Optar por un hotel de tipo:\n          " + hotel);
		        TA1.setText(TA1.getText() + "\n \n - En alguno de los siguientes lugares \n          " 
		        			+ array_ciudades.get(0) + "\n          " + array_ciudades.get(1) + "\n          "+ array_ciudades.get(2));
			}
		}
	}
	
	public String get_tipo(ArrayList<Double> array_tipo) {
		double max = Collections.max(array_tipo);
		int indice = array_tipo.indexOf(max) + 1;
		return "tipo"+ String.valueOf(indice);
	}
	
	public String get_hotel(ArrayList<Double> array_hotel) {
		double max = Collections.max(array_hotel);
		int indice = array_hotel.indexOf(max) + 1;
		
		switch(indice) {
		case 1:
			return "D- ☆  Estrellas";
		case 2:
			return "E- ☆☆ Estrellas";
		case 3:
			return "B- ☆☆☆  Estrellas";
		case 4:
			return "A- ☆☆☆☆ Estrellas";
		case 5:
			return "AA- ☆☆☆☆☆  Estrellas";
		default:
			return "";
		}
	}
	
	public ArrayList<String> get_ciudades (String tipo) {
			
			ArrayList<String> paises = new ArrayList<String>();
			
			switch(tipo){
			case "tipo1":
				paises.add("Moscú (Rusia)");
				paises.add("Kiev (Ucrania)");
				paises.add("Patagonia (Argentina)");
				return paises;
			case "tipo2":
				paises.add("Niza (Francia)");
				paises.add("Berlín (Alemania)");
				paises.add("Milán (Italia)");
				return paises;
			case "tipo3":
				paises.add("Auckland (Nueva Zelanda)");
				paises.add("Toronto (Canada)");
				paises.add("New York (Estados Unidos)");
				return paises;
			case "tipo4":
				paises.add("Medellín (Colombia)");
				paises.add("São Paulo (Brasil)");
				paises.add("Ciudad de México (México)");
				return paises;
			case "tipo5":
				paises.add("SanJose (Costa Rica)");
				paises.add("Valencia (España)");
				paises.add("New Orleans (Estados Unidos)");
				return paises;
			case "tipo6":
				paises.add("Abu Dabi (Emiratos Árabes Unidos)");
				paises.add("Sídney (Australia)");
				paises.add("Hamilton (Bermuda)");
				return paises;
			case "tipo7":
				paises.add("Cairo (Egipto)");
				paises.add("Barranquilla (Colombia)");
				paises.add("Maracaibo (Venezuela)");
				return paises;
			case "tipo8":
				paises.add("Bangkok (Tailandia)");
				paises.add("Tel Aviv (Israel)");
				paises.add("Las Vegas (Estados Unidos)");
				return paises;
			case "tipo9":
				paises.add("Doha (Qatar)");
				paises.add("Hawaii (Estados Unidos)");
				paises.add("Hong Kong (China)");
				return paises;
			default:
				return paises;
			}
		}
}
