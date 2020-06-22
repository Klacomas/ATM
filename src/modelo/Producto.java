package modelo;

public class Producto {
	protected int nroCta;
	protected double saldo;
	protected double deuda;
	
	public Producto(int nroCta, double saldo, double deuda) {
		super();
		this.nroCta = nroCta;
		this.saldo = saldo;
		this.deuda = deuda;
	}
	
	public Producto() {
		super();
	}
	
	public int getNroCta() {
		return nroCta;
	}
	
	public void setNroCta(int nroCta) {
		this.nroCta = nroCta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getDeuda() {
		return deuda;
	}
	
	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	
	@Override
	public String toString() {
		return "Producto [nroCta=" + nroCta + ", saldo=" + saldo + ", deuda=" + deuda + "]";
	}
	
	

}
