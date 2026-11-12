package sinav;

/*
 * Soru 4: Bu kod ne yazdırır? Soru 3'ten farkı nedir?
 *
 * Aynı toplam, bu kez while ile: başlangıç (i = 0) döngüden önce, koşul (i < 1000)
 * while'ın içinde, artırma (i++) gövdenin sonunda. Çıktı yine 499500'dür.
 *
 * Bir for döngüsü "for (başlangıç; koşul; artırma) gövde" her zaman
 * "başlangıç; while (koşul) { gövde; artırma; }" biçimine çevrilebilir.
 * Tek fark kapsamdır: for'daki i döngüden sonra yoktur, buradaki i hâlâ vardır
 * ve değeri 1000'dir.
 */
public class Soru4 {

	static void soru4() {
		int toplam = 0;
		int i = 0;
		while (i < 1000) {
			toplam += i;
			i++;
		}
		System.out.println("toplam:" + toplam);
	}

	public static void main(String[] args) {
		soru4();
	}
}

/* Beklenen cikti:
toplam:499500
*/
