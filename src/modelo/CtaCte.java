package modelo;

public class CtaCte extends Producto{
	
	public CtaCte(int nroCta, double saldo, double deuda) {
		super(nroCta, saldo, deuda);
	}
	
	public CtaCte() {
		super();
	}

	@Override
	public String toString() {
		String texto;
		if(Servicios.getEsCliente().getCtaCliente().getDeuda()==0) {
			texto = "Cuenta Corriente: 00-" + Servicios.getEsCliente().getRut() + "\n Saldo Actual $ " + saldo + "\n No tienes deuda.  \n";
		}else {
			texto = "Cuenta Corriente: 00-" + Servicios.getEsCliente().getRut() + "\n Saldo Actual $ " + saldo + "\n La deuda de su cuenta es:" + deuda + "\n";
		}
		return texto;
	}
	
	
	

}
