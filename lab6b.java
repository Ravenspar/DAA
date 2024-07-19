import java.util.Scanner;

public class FloydWarshall {
static int[][] a = new int[10][10];
static int n;
public static void floyd() {
int i, j, k;
for (k = 1; k <= n; k++) {
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
if ((a[i][k] + a[k][j]) < a[i][j])
a[i][j] = a[i][k] + a[k][j];
}
}
}
}
public static void main(String[] args) {
int i, j;
Scanner scanner = new Scanner(System.in);
System.out.print("\nEnter the number of nodes: ");
n = scanner.nextInt();
System.out.println("\nEnter the cost adjacency matrix:");
for (i = 1; i <= n; i++)
for (j = 1; j <= n; j++)
a[i][j] = scanner.nextInt();
floyd();
System.out.println("\nThe shortest path matrix is:");
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
System.out.print(a[i][j] + "\t");
}
System.out.println();
}
scanner.close();
}
}