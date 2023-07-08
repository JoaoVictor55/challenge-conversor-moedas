package challenge_alura_conversor;

public class Moeda{

	private double valor;
	final private String nome;
	
	@Override
	public String toString() {
		return nome;
	}

	Moeda(double valor, String nome){
		
		this.nome = nome;
		atualizarCambio(valor);
	}
	
	//retorna o valor da moeda em reais
	public double getValorReal()
	{
		return this.valor;
	}
	
	//retorna o "valor" da moeda em reais
	public double converterParaReal(double valor) {
		
		if(valor < 0) {
			throw new IllegalArgumentException("Não é possível converter valor negativo");
		}
		
		return this.valor * valor;
	}
	
	public double converterDeReal(double valor) {
		
		if(valor < 0) {
			throw new IllegalArgumentException("Não é possível converter valor negativo");
		}
		
		return (1/this.valor) * valor;
	}

	//atualiza o valor da moeda em relação ao real
	public void atualizarCambio(double valor) {
		
		if(valor <= 0) {
			
			throw new IllegalArgumentException("Cambio da moeda em relacao ao real nao pode ser zero"
					+ "ou negativo!");
		}
		
		this.valor = valor;

	}
}
