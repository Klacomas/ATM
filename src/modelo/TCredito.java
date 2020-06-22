package modelo;

public class TCredito extends Producto{
	protected double saldoMax;

	public TCredito(int nroCta, double saldo, double deuda, double saldoMax) {
		super(nroCta, saldo, deuda);
		this.saldoMax = saldoMax;
	}

	public TCredito(int nroCta, double saldo, double deuda) {
		super(nroCta, saldo, deuda);
	}
	
	public TCredito() {
		super();
	}

	public double getSaldoMax() {
		return saldoMax;
	}

	public void setSaldoMax(double saldoMax) {
		this.saldoMax = saldoMax;
	}

	@Override
	public String toString() {
		String strTCredito;
		if(Servicios.getEsCliente().getTcCliente().getDeuda()==0) {
			strTCredito = "Tarjeta de credito: 01-" + Servicios.getEsCliente().getRut() + ", Saldo actual $ " + saldo + " / " + saldoMax + "\nNo tiene deuda.   \n";
		}else {
			strTCredito = "Tarjeta de credito: 01-" + Servicios.getEsCliente().getRut() + ", Saldo actual $ " + saldo + " / " + saldoMax + "\nLa deuda de su tarjeta de credito es $ " + deuda;
		}
		return strTCredito;
	}

}
