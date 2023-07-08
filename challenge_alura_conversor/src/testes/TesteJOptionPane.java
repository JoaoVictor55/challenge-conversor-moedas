package testes;
import javax.swing.*; 
public class TesteJOptionPane {
	
	JFrame f, g;
	
	TesteJOptionPane(){
		
		f = new JFrame();
		 //JOptionPane.showMessageDialog(f, "Hello, Welcome to Javatpoint.","Foo",JOptionPane.WARNING_MESSAGE);
		



	}
	
	public Object mostrar() {
		Object [] possibleValues = {"Na mao", "No pe", "Na cara"};
		//argumentos: pai,mensagem, título, tipo, icone, opcoes, valor inicial
		return 	JOptionPane.showInputDialog(f,"Selecione uma porra", "entrada",  JOptionPane.INFORMATION_MESSAGE,
				null, possibleValues, possibleValues[0]);
	}
	
	public static void main(String[] args) {
		
		TesteJOptionPane p = new TesteJOptionPane();
		
		Object a = p.mostrar();
		
		System.out.println(a.toString());

	}

}
