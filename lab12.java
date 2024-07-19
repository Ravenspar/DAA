import java.util.Scanner;

public class NQueens {
static int[][] s = new int[100][100];
static void display(int[] m, int n) {
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
s[i][j] = 0;
}
}
for (int i = 0; i < n; i++) {
s[i][m[i]] = 1;
}
System.out.println();
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
System.out.print(s[i][j] + " ");
}
System.out.println();
}
}
static int place(int[] m, int k) {
for (int i = 0; i < k; i++)
if (m[i] == m[k] || (Math.abs(m[i] - m[k]) == Math.abs(i - k)))
return 0;
return 1;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int[] m = new int[25];
int n, k;
System.out.println("\nENTER THE NO OF QUEENS:");
n = scanner.nextInt();
System.out.println("\nTHE SOLUTION TO QUEENS PROBLEM IS\n");
n--;
for (m[0] = 0, k = 0; k >= 0; m[k] = m[k] + 1) {
while (m[k] <= n && !(place(m, k) == 1))
m[k] = m[k] + 1;
if (m[k] <= n)
if (k == n)
display(m, n + 1);
else {
k++;
m[k] = -1;
}
else
k--;
}
}
}