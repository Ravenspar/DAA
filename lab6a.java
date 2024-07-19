import java.util.Scanner;

public class TransitiveClosure {
public static void main(String[] args) {
int i, j, k, n;
int[][] cost = new int[20][20];
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of nodes: ");
n = scanner.nextInt();
System.out.println("\nEnter the adjacency matrix:");
for (i = 1; i <= n; i++)
for (j = 1; j <= n; j++)
cost[i][j] = scanner.nextInt();
for (k = 1; k <= n; k++) {
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
cost[i][j] = cost[i][j] | (cost[i][k] & cost[k][j]);
}
}
}
System.out.println("\nThe transitive closure is:");
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
System.out.print(cost[i][j] + "\t");
}
System.out.println();
}
scanner.close();
}
}