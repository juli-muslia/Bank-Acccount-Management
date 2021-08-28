import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Llogaria {
	private String emri;
	private String mbiemri;
	private String iban;
	double gjendja;
	AccountType llojLlogarie = AccountType.NORMAL;
	
	ArrayList<String> veprimet = new ArrayList<>();
	

	public Llogaria(String emer, String mbiemer, String iban, AccountType llojiLlogarise ) {
		this.emri = emer;
		this.mbiemri = mbiemer;
		this.iban = iban;
		this.llojLlogarie = llojiLlogarise;
	}

	
	public double getGjendja() {
		return gjendja;
	}


	public void setGjendja(double gjendja) {
		this.gjendja = gjendja;
	}


	public AccountType getLlojLlogarie() {
		return llojLlogarie;
	}


	public void setLlojLlogarie(AccountType llojLlogarie) {
		this.llojLlogarie = llojLlogarie;
	}


	public ArrayList<String> getVeprimet() {
		return veprimet;
	}


	public void setVeprimet(ArrayList<String> veprimet) {
		this.veprimet = veprimet;
	}


	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public String getMbiemri() {
		return mbiemri;
	}

	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void depozitoPara(double vleraShtuar) {
		if (vleraShtuar != 0) {
			gjendja = gjendja + vleraShtuar;

			shtoVeprimin("Depozitim: " + vleraShtuar); /// Ben Shtimin e veprimit ne array

		}
	}

	public void terhiqPara(double vleraTerhequr) {

		if (vleraTerhequr != 0) {
			gjendja = gjendja - vleraTerhequr;
			shtoVeprimin("Terheqje:  " + vleraTerhequr);

		}
	}
	


	public void shfaqVeprimet() {
		for (String o : veprimet) {
			System.out.println("====" + o + "====");
		}
	}

	// Kjo metode ben te mundur shtimin e veprimit ne ArrayList
	public void shtoVeprimin(String veprimIRi) {
		if (veprimet == null) {
			veprimet = new ArrayList<>();
		}

		if (veprimet != null) {
			veprimet.add(veprimIRi);
		}
	}



}
