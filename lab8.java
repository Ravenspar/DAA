import java.util.Scanner;

public class PrimsAlgorithm {
static int a, b, u, v, n, i, j, ne = 1;
static int min, mincost = 0;
static int[] visited = new int[10];
static int[][] cost = new int[10][10];
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("\nEnter the number of nodes: ");
n = scanner.nextInt();
System.out.println("\nEnter the adjacency matrix:");
for (i = 1; i <= n; i++)
for (j = 1; j <= n; j++) {
cost[i][j] = scanner.nextInt();
if (cost[i][j] == 0)
cost[i][j] = 999;
}
visited[1] = 1;
System.out.println();
while (ne < n) {
for (i = 1, min = 999; i <= n; i++)
for (j = 1; j <= n; j++)
if (cost[i][j] < min)
if (visited[i] != 0) {
min = cost[i][j];
a = u = i;
b = v = j;
}
if (visited[u] == 0 || visited[v] == 0) {
System.out.printf("\nEdge %d: (%d %d) cost: %d", ne++, a, b, min);
mincost += min;
visited[b] = 1;
}
cost[a][b] = cost[b][a] = 999;
}
System.out.println("\nMinimum cost = " + mincost);
scanner.close();
}
}