
public class Time {
	private int hora=2;
	private int minuto=10;
	 private int Segundos=0;
	
	

	public int getHora() {
		return hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public int getSegundos() {
		return Segundos;
	}
	
	public void exibirHoraUniversal() {
		System.out.println("Hora universal: " 
							+ (formatNumber(this.hora))
							+ ":" + (formatNumber(this.minuto))
							+ ":" + (formatNumber(this.Segundos)));
	}
	
	public void exibirHoraPadrao() {
		if(this.hora<12) {
			System.out.println("Hora Padrão: " 
					+ (getHora() < 10 ? "0" + getHora() : getHora())
					+ ":" + (getMinuto() < 10 ? "0" + getMinuto() : getMinuto())
					+ ":" + (getSegundos() < 10 ? "0" + getSegundos() : getSegundos())
					+ " AM");
		}
		
		else if(hora == 24) {
			System.out.println("Hora Padrão: " 
					+ (formatNumber(0))
					+ ":" + (formatNumber(this.minuto))
					+ ":" + (formatNumber(this.Segundos))
					+ " AM");
		}
		
		else {
			System.out.println("Hora Padrão: " 
					+ (formatNumber(this.hora)) 
					+ ":" + (formatNumber(this.minuto))
					+ ":" + (formatNumber(this.Segundos))
					+ " PM");
		}
	}
	
	private String formatNumber(int numero) {
		return(numero < 10 ? "0" + numero : String.valueOf(numero));
	}
	
}
