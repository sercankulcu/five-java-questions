package sinav;

/*
 * Soru 3: Bu kod ne yazdırır?
 *
 * Döngü i = 0'dan i = 999'a kadar döner: i < 1000 koşulu 1000'i dışarıda bırakır.
 * 0 + 1 + ... + 999 = 999 * 1000 / 2 = 499500.
 *
 * Tuzak: Gauss'un formülünü 1'den 1000'e kadar uygulayıp 500500 bulmak. Sınır
 * koşulu (< mı, <= mü) ve başlangıç değeri (0 mı, 1 mi) sonucu doğrudan değiştirir.
 */
public class Soru3 {

	static void soru3() {
		int toplam = 0;
		for (int i = 0; i < 1000; i++) {
			toplam += i;
		}
		System.out.println("toplam:" + toplam);
	}

	public static void main(String[] args) {
		soru3();
	}
}

/* Beklenen cikti:
toplam:499500
*/
