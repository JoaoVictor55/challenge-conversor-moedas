package challenge_alura_conversor;
import javax.swing.*; 

public class Main {
	
	final private JFrame f;
	final private Object [] menuOpcoes;
	final private Object [] moedasOpcoes;
	//final private Moeda [] moedas;
	
	private enum conversivel{
		
		DOLAR(new Dolar()),
		EURO(new Euro()),
		LIBRA_ESTERLINA(new LibraEsterlina()),
		PESO_ARGENTINO(new PesoArgentino()),
		PESO_CHILENO(new PesoChileno()),;
		
		
		
		private Moeda moeda;
		
		conversivel(Moeda moeda) {
			
			this.moeda = moeda;
		}
		
		public Moeda getMoeda() {
			return this.moeda;
		}
		
	
	}
	
	public Main() {
		
		menuOpcoes = new Object[]{"Conversor de Moeda"};
		moedasOpcoes = new Object[] {"Converter de Reais a Dólares", //0
				"Converter de Reais a Euros",  //1
				"Converter de Reais a Libras Esterlinas", //2 
				"Converter de Reais a Peso Argentino", "Converter de Reais a Peso Chileno", //3 
				"Converter de Dólar a Reais", //4
		        "Converter de Euro a Reais", //5
		        "Converter de Libras Esterlinas a Reais", //6
		        "Converter de Peso argentino a  Reais", //7
		        "Converter de Peso Chileno a Reais"}; //8
		
		/*moedas = new Moeda [] {new Dolar(), new Euro(), new LibraEsterlina(), new PesoArgentino(),
				new PesoChileno()};*/
	
		f = new JFrame();
	}
	
	/**
	 * cria um menu de opções.
	 * @param frame
	 * @param titulo
	 * @param mensagem
	 * @param ops
	 * @return
	 */
	public Object mostrarOpcoes(JFrame frame, String titulo, String mensagem, Object [] ops) {
		
		return JOptionPane.showInputDialog(frame, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE,
				null, ops, menuOpcoes[0]);
	}
	
	public Object[] getMenuOpcoes() {
		return menuOpcoes;
	}

	public Object[] getMoedasOpcoes() {
		return moedasOpcoes;
	}
	
	/**
	 * solicita a entrada até o acerto
	 * permite que o usuário digite um determinado valor, depois o retorna convertido em double
	 * @param frame
	 * @return
	 */
	public double setEntrada(JFrame frame) {

		for(;;) {
			
			try{
				
				return Double.parseDouble(JOptionPane.showInputDialog(frame, "Input", "Insira um valor", JOptionPane.INFORMATION_MESSAGE));
			}
			catch(NumberFormatException e) {
				
				showError(this.f, "Erro! Apenas caracteres numéricos e pontos são permitidos");
				continue;
			}
		}
		
	}
	
	/**
	 * exibe na tela o valor de uma conversão
	 * @param frame
	 * @param mensagem
	 */
	public void getResultado(JFrame frame, String mensagem) {
		
		JOptionPane.showMessageDialog(frame, "O valor da conversão é: "+mensagem, "Conversor - Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * exibe a mensagem de finalização
	 * @param frame
	 */
	public void showAdeus(JFrame frame) {
		
		JOptionPane.showMessageDialog(frame, "Programa Finalizado", "Conversor",JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * exibe uma mensagem de erro
	 * @param frame
	 * @param mensagem
	 */
	public void showError(JFrame frame, String mensagem) {
		
		JOptionPane.showMessageDialog(frame, mensagem, "Conversor - Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	//0 - sim, 1 - não, 2 - cancelar
	/**
	 * 
	 * @param frame
	 * @return
	 */
	public int showContinuar(JFrame frame, String titulo) {
		
		return JOptionPane.showConfirmDialog(frame, "Deseja Continuar?", titulo, JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	/**
	 * menu principal do programa que permite a escolha dos conversores disponíveis.
	 */
	public void menu() {
		
		for(;;) {
			
			Object op = mostrarOpcoes(this.f, "Conversor - Opções", "Selecione uma opção", this.menuOpcoes);
			
			if(op == this.menuOpcoes[0]) {
				subMenuConversorMoedas();
			}
			
			if(showContinuar(this.f, "Conversor") == 1) {
				break;
			}

		}
		
		showAdeus(this.f);
	}
	
	/**
	 * permite escolher uma moeda dentre as opções e convertê-la para Real ou vice-versa.
	 */
	private void subMenuConversorMoedas() {
		
		for(;;) {
			
			//pergunta qual das opções de conversão de moedas
			
			Object op = mostrarOpcoes(this.f, "Conversor de Moedas - Opções", "Selecione uma opção", this.moedasOpcoes);
			double valor = 0.0;
			
			try {
				
				valor = setEntrada(this.f);
			}
			// o usuário cancelou a entrada
			catch(NullPointerException e) {
				continue;
			}
			
			try {
			//opção de reais para dólares
			if(op == this.moedasOpcoes[0]) {
				
				valor = conversivel.DOLAR.getMoeda().converterDeReal(valor);
				
			}
			
			//opção de dólares para reais
			else if(op == this.moedasOpcoes[5]) {
				
				valor = conversivel.DOLAR.getMoeda().converterParaReal(valor);
				
			}
			
			//opção de reais para libras
			
			else if(op == this.moedasOpcoes[2]) {
				
				valor = conversivel.LIBRA_ESTERLINA.getMoeda().converterDeReal(valor);
			}
			
			//opção de libras para reais
			
			else if(op == this.moedasOpcoes[7]) {
				
				valor = conversivel.LIBRA_ESTERLINA.getMoeda().converterParaReal(valor);
			}
			
			//opção de reais para euro
			
			else if(op == this.moedasOpcoes[1]) {
				valor = conversivel.EURO.getMoeda().converterDeReal(valor);
			}
			
			//opção de euro para reais
			else if(op == this.moedasOpcoes[6]) {
				
				valor = conversivel.EURO.getMoeda().converterParaReal(valor);
			}
			
			//opção de reais para peso arg
			else if(op == this.moedasOpcoes[3]) {
				
				valor = conversivel.PESO_ARGENTINO.getMoeda().converterDeReal(valor);
			}
			
			//opção de peso arg para reais
			else if(op == this.moedasOpcoes[8]) {
				
				valor = conversivel.PESO_ARGENTINO.getMoeda().converterParaReal(valor);
			}
			
			//opção de reais para peso chi
			
			else if(op == this.moedasOpcoes[4]) {
				valor = conversivel.PESO_CHILENO.getMoeda().converterDeReal(valor);
			}
			
			//opção de peso chi para reais
			else {
				valor = conversivel.PESO_CHILENO.getMoeda().converterParaReal(valor);
			}
				getResultado(this.f, Double.toString(valor)); //exibe o resultado
			}
			
			
			catch(IllegalArgumentException e) {
				
				showError(this.f, "Erro no conversor de moedas: "+e.getMessage());
			}
			//pergunta se o usuário deseja continuar
			if(showContinuar(this.f, "Conversor Moedas") == 1) {
				return;
			}
					
		}
		
	}

	public static void main(String[] args) {
		
		Main m = new Main();
		
		m.menu();
	}

}
