package sinav;

/*
 * Soru 5: Bu kod ne yazdırır?
 *
 * Döngü n'yi her turda m = 2'ye böler ve kaç tur döndüğünü k'de sayar:
 * 32 -> 16 -> 8 -> 4 -> 2 -> 1. Beş bölme sonra n = 1 olur ve döngü durur: k = 5.
 * Bu, log2(32) = 5'tir: n kaç kez yarıya bölünürse 1'e iner sorusunun cevabı.
 * İkili aramanın ve dengeli ağaçların O(log n) olmasının arkasındaki sayı budur.
 *
 * Tuzaklar: p hiç kullanılmaz, yalnızca dikkat dağıtır. n bir tam sayıdır;
 * 2'nin kuvveti olmayan bir n için bölme aşağı yuvarlanır (n = 33 de k = 5 verir).
 */
public class Soru5 {

	static void soru5() {
		int k = 0;
		int p = 1;
		int n = 32;
		int m = 2;
		while (n > 1) {
			k++;
			n = n / m;
		}
		System.out.println("k: " + k);
	}

	public static void main(String[] args) {
		soru5();
	}
}

/* Beklenen cikti:
k: 5
*/
