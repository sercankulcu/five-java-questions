# Five Java Questions

In 2016 I sat an academic exam that included five short Java questions. The exam went well, and I won it. The questions stayed with me: each one is only a few lines long, yet each tests something a programmer has to see clearly — how an `if`/`else if` chain really runs, where a loop stops, what `println` does with an array.

This repository keeps the original exam code and the five questions as small runnable programs, with their answers and the trap in each one. The story behind them is on my site: [Five Java Questions](https://sercankulcu.github.io/memory/2016-01-01-five-java-questions/).

## Try them first

Each question asks the same thing: **what does this code print?** Read the code, write down your answer, then open the answer.

### Question 1

```java
Scanner scanner = new Scanner(System.in);
String s = scanner.nextLine();
char[] backup = new char[s.length()];
System.out.println(s);
for (int i = 0; i < s.length(); i++)
    backup[s.length() - i - 1] = s.charAt(i);
System.out.println(backup);
```

<details><summary>Answer</summary>

The line that was read, then the same line reversed: for `sinav` it prints `sinav` and `vanis`.

The loop puts character *i* at position *length − 1 − i*, so `backup` holds the reversed text. The trap is the last line: `System.out.println(backup)` prints a `char[]`, and `PrintStream` has a dedicated `println(char[])` overload that prints the characters. Concatenate the same array with a string — `"Reversed: " + backup` — and Java prints the array's identity instead, something like `[C@1b6d3586`. Use `new String(backup)`.
</details>

### Question 2

```java
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
```

<details><summary>Answer</summary>

`9900`. `param = 30` fails the first condition, so neither statement in the first block runs. The `else if` holds: `result = 330`, `param` stays 30, and 330 × 30 = 9900. Reading the code top to bottom and also executing `param = param + 7` gives 12210, which is the trap: at most one branch of an `if`/`else if` chain runs.
</details>

### Question 3

```java
int toplam = 0;
for (int i = 0; i < 1000; i++) {
    toplam += i;
}
System.out.println("toplam:" + toplam);
```

<details><summary>Answer</summary>

`toplam:499500`. The loop runs for *i* = 0 … 999; `i < 1000` leaves 1000 out. 0 + 1 + … + 999 = 999 · 1000 / 2 = 499500. Applying Gauss's formula from 1 to 1000 gives 500500 — one number off at the boundary.
</details>

### Question 4

```java
int toplam = 0;
int i = 0;
while (i < 1000) {
    toplam += i;
    i++;
}
System.out.println("toplam:" + toplam);
```

<details><summary>Answer</summary>

`toplam:499500` again. This is Question 3 written with `while`: the initialisation moves before the loop, the condition stays, and the increment goes to the end of the body. Every `for (init; cond; step) body` can be rewritten as `init; while (cond) { body; step; }`. The one difference is scope: here `i` still exists after the loop, with the value 1000.
</details>

### Question 5

```java
int k = 0;
int p = 1;
int n = 32;
int m = 2;
while (n > 1) {
    k++;
    n = n / m;
}
System.out.println("k: " + k);
```

<details><summary>Answer</summary>

`k: 5`. The loop halves *n* and counts the halvings: 32 → 16 → 8 → 4 → 2 → 1. Five halvings bring 32 down to 1, so *k* = log₂ 32 = 5 — the same number behind binary search and every O(log *n*) bound. `p` is never used; it is there to distract. With integer division the count rounds down for other values: *n* = 33 also gives 5.
</details>

## The code

| File | What it is |
|---|---|
| `src/sinav/Sinav.java` | The exam code as it was: the five questions as methods of one class. Question 1 reads a line from the keyboard. |
| `src/sinav/Soru1.java` … `Soru5.java` | Each question as its own program, with the explanation and the expected output at the end. Question 1 runs on fixed input, so no program waits for the keyboard. |

Comments and identifiers are in Turkish, as in the exam. To run a question:

```bash
javac -d bin src/sinav/*.java
java -cp bin sinav.Soru2
```

The project opens in Eclipse as is and is set up for Java 21.
