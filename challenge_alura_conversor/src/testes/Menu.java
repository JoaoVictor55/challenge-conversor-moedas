package testes;
import javax.swing.*; 

public class Menu {

	
	public enum menu{
		
		OP0("Converter de Reais a Dólares"), //0
		OP1("Converter de Reais a Euros"),  //1
		OP2("Converter de Reais a Libras Esterlinas"), //2 
		OP3("Converter de Reais a Peso Argentino"), 
		OP4("Converter de Reais a Peso Chileno"), //3 
		OP5("Converter de Dólar a Reais"), //4
        OP6("Converter de Euro a Reais"), //5
        OP7("Converter de Libras Esterlinas a Reais"), //6
        OP8("Converter de Peso argentino a  Reais"), //7
        OP9("Converter de Peso Chileno a Reais");
		
		private String opcaoNome;

		menu(String opcaoNome) {
			this.opcaoNome = opcaoNome;
		}
		
		public String getNome() {
			return this.opcaoNome;
		}
	}
	
	public static void main(String[] args) {
		
		Menu m = new Menu();
		
		Object p = JOptionPane.showInputDialog(null, "escolha", "escolha - menu", JOptionPane.INFORMATION_MESSAGE,
				null, Menu.menu.values(), Menu.menu.values()[0]);
		
		System.out.println(p);
	}
}
