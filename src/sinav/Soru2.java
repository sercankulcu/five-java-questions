package sinav;

/*
 * Soru 2: Bu kod ne yazdırır?
 *
 * param = 30 ilk koşulu (param > 45) sağlamaz, bu yüzden ilk bloktaki iki atama
 * hiç çalışmaz. else if (param > 18) sağlanır: result = 300 + 30 = 330.
 * param 30 olarak kalır. Çıktı 330 * 30 = 9900.
 *
 * Tuzak: Kodu yukarıdan aşağıya okuyup ilk bloktaki "param = param + 7" satırını
 * da çalıştırmak (330 * 37 = 12210). else if, yalnızca önceki koşul yanlışsa
 * denenir ve iki bloktan en çok biri çalışır.
 */
public class Soru2 {

	static void soru2() {
		int param = 30;
		int result = 300;

		if (param > 45) {
			result = result - param;
			param = param + 7;
		}

		else if (param > 18) {
			result = result + param;
		}

		System.out.println(result * param);
	}

	public static void main(String[] args) {
		soru2();
	}
}

/* Beklenen cikti:
9900
*/
