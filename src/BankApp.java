import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class BankApp {

	private static final AccountType AccountType = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AccountType tipLlogarie = AccountType.NORMAL;
		HashMap<String, Llogaria> llogari = new HashMap<>();
		int veprimi = 0;
		boolean dil = false;
		do {
			System.out.println("Pershendetje, cfare veprimi doni te kryeni?");
			System.out.println("1- Krijoni nje llogari te re");
			System.out.println("2- Kontrollo llogarine");
			System.out.println("3- Depozito para ");
			System.out.println("4- Terhiqni para");
			System.out.println("5- Kontrolloni veprimet tuaja ");
			System.out.println("6- Nderro llojin e llogarise tuaj VIP / NORMAL ");
			System.out.println("7- Dilni");

			veprimi = sc.nextInt();

			switch (veprimi) {
			case 1:
				System.out.println("Ju lutem vendosni te dhenat tuaja");
				System.out.println("Emri: ");
				String emri = sc.next();
				System.out.println("Mbiemri: ");
				String mbiemri = sc.next();
				System.out.println("Iban: ");
				String iban = sc.next();
				if (!eshteLlogariaPrezente(llogari, iban)) {
					Llogaria person = new Llogaria(emri, mbiemri, iban, tipLlogarie);
					llogari.put(person.getIban(), person);
					System.out.println("Pershendetje " + emri + "! Llogaria juaj u krijua !");
					System.out.println("Tipi i llogarise tuaj eshte: " + tipLlogarie);

				} else {
					System.out.println("Me vjen keq ! Ibani " + iban + " ekziston!");

					System.out.println("=================================");
				}
				break;

			case 2:
				System.out.println("Ju lutem vendosni IBAN e llogarise tuaj");
				String llogariaIban = sc.next();
				Llogaria balanca = gjejLlogarineMeIban(llogari, llogariaIban);
				
				if (balanca != null) {
					System.out.println("Pershendetje " + balanca.getEmri());
					System.out.println("Gjendja juaj eshte: " + balanca.gjendja);
				} else {
					System.out.println("Me vjen keq, llogaria juaj nuk u gjet");
				}

				break;
			case 3:
				System.out.println("Ju lutem vendosni IBAN e llogarise tuaj");
				String depIban = sc.next();
				Llogaria depozito = gjejLlogarineMeIban(llogari, depIban);
				
				if (depozito != null) {
					System.out.println("Ju lutem vendosni vleren qe doni te shtoni: ");
					try {

						double shuma = sc.nextDouble();
						sc.nextLine();
						depozito.depozitoPara(shuma);
					}

					catch (InputMismatchException e) {
						System.out.println("Vendosni vleren Numra");
					}
				} else {
					System.out.println("Me vjen keq, llogaria juaj nuk u gjet");
				}

				break;
			case 4:
				System.out.println("Ju lutem vendosni IBAN e llogarise tuaj");
				String terhiqIban = sc.next();
				Llogaria terhiq = gjejLlogarineMeIban(llogari, terhiqIban);
				
				if (terhiq != null) {
					System.out.println("Ju lutem vendosni vleren qe doni te terhiqni: ");
					try {
						double vleraTerhequr = sc.nextDouble();
						sc.nextLine();
						terhiq.terhiqPara(vleraTerhequr);
					} catch (InputMismatchException e) {
						System.out.println("Vendosni vleren Numra");
					}
				} else {
					System.out.println("Me vjen keq, llogaria juaj nuk u gjet");
				}

				break;

			case 5:
				System.out.println("Ju lutem vendosni IBAN e llogarise tuaj");
				String kontrollIban = sc.next();
				Llogaria kontrollo = gjejLlogarineMeIban(llogari, kontrollIban);
			
				if (kontrollIban != null) {
					System.out.println("Veprimet qe ju keni kryer: ");

					kontrollo.shfaqVeprimet();

				} else {
					System.out.println("Me vjen keq, llogaria juaj nuk u gjet");
				}

				break;
			case 6:
				System.out.println("Ju lutem vendosni IBAN e llogarise tuaj");
				String tipiLlogariseIban = sc.next();
				Llogaria tipiLlogarise = gjejLlogarineMeIban(llogari, tipiLlogariseIban);
				if (tipiLlogarise != null) {
					System.out.println("Pershendetje " + tipiLlogarise.getEmri());
					System.out.println("Lloji i llogarise tuaj eshte: " + tipiLlogarise.llojLlogarie);
					System.out.println("Deshironi te nderroni llojin e llogarise tuaj ?");
					System.out.println("Shtypni 1 per nderrim te llojit te llogarise ose 2 per te anulluar veprimin");
					int nderrimi = sc.nextInt();
					if (nderrimi == 1) {

						if ( tipLlogarie == AccountType.NORMAL) {
							tipLlogarie = AccountType.VIP;
							tipiLlogarise.setLlojLlogarie(tipLlogarie);
							
						} else if (tipLlogarie == AccountType.VIP) {
							tipLlogarie = AccountType.NORMAL;
							tipiLlogarise.setLlojLlogarie(tipLlogarie);
						}
						System.out.println("Llogaria juaj u be: " + tipLlogarie);
					} else if ( nderrimi == 2 ) {
						System.out.println("Veprimi u Anullua");
					}
				} else {
					System.out.println("Me vjen keq, llogaria juaj nuk u gjet");
				}

				break;

			case 7:
				dil = true;
				break;
			default:
				System.out.println("Zgjedhja juaj nuk mund te procesohet. Ju lutem zgjidhni opsionet nga 1-6");
				break;
			}

		} while (veprimi != 7 && !dil);
		System.out.println("Ju sapo dolet! Faleminderit !");
	}


	public static boolean eshteLlogariaPrezente(Map<String, 
			 Llogaria> llogari, String iban) {
		Llogaria a = llogari.get(iban);
		
		if (a != null) {
			return true;
		}
		return false;
	}

	public static Llogaria gjejLlogarineMeIban(Map<String, 
			Llogaria> llogari, String iban) {
		
		return llogari.get(iban);

	}

}
