package sinav;

/*
 * Soru 1: Bu kod klavyeden okunan bir satırı ve sonra ne yazdırır?
 *
 * Sınavdaki kod Sinav.soru1()'dir; satırı Scanner ile okur. Burada aynı döngü
 * sabit bir girdiyle çalışır ki program klavye beklemesin.
 *
 * Döngü i. karakteri dizinin sondan i. yerine koyar: backup metnin tersidir.
 *
 * Tuzak: System.out.println(backup) bir char[] yazdırır. PrintStream'in
 * println(char[]) yüklemesi dizinin karakterlerini metin olarak basar, bu yüzden
 * ekranda ters metin görünür. Aynı dizi bir String ile birleştirilseydi
 * ("Ters: " + backup) dizinin kendisi değil adresi basılırdı: Ters: [C@1b6d3586 gibi.
 * Doğrusu new String(backup) ya da String.valueOf(backup) yazmaktır.
 */
public class Soru1 {

	static void soru1(String s) {
		char[] backup = new char[s.length()];
		System.out.println(s);
		for (int i = 0; i < s.length(); i++)
			backup[s.length() - i - 1] = s.charAt(i);
		System.out.println(backup);
	}

	public static void main(String[] args) {
		soru1("sinav");
		soru1("Java 2016");
	}
}

/* Beklenen cikti:
sinav
vanis
Java 2016
6102 avaJ
*/
