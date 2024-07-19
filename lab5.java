import java.util.Scanner;

public class Knapsack {
public static int max(int a, int b) {
return a > b ? a : b;
}
public static void knapsack(int n, int[] w, int m, int[][] v, int[] p) {
int i, j;
for (i = 0; i <= n; i++) {
for (j = 0; j <= m; j++) {
if (i == 0 || j == 0)
v[i][j] = 0;
else if (j < w[i])
v[i][j] = v[i - 1][j];
else
v[i][j] = max(v[i - 1][j], v[i - 1][j - w[i]] + p[i]);
}
}
}
public static void main(String[] args) {
int m, i, j, n;
int[] p = new int[10];
int[] w = new int[10];
int[][] v = new int[10][10];
Scanner scanner = new Scanner(System.in);
System.out.println("Enter the number of objects:");
n = scanner.nextInt();
System.out.println("Enter the weights of n objects:");
for (i = 1; i <= n; i++)
w[i] = scanner.nextInt();
System.out.println("Enter the profits of n objects:");
for (i = 1; i <= n; i++)
p[i] = scanner.nextInt();
System.out.println("Enter the capacity of Knapsack:");
m = scanner.nextInt();
knapsack(n, w, m, v, p);


System.out.println("The output is:");
for (i = 0; i <= n; i++) {
for (j = 0; j <= m; j++)
System.out.print(v[i][j] + " ");
System.out.println();
}
scanner.close();
}
}