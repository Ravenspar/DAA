import java.util.Scanner;

public class Dijkstra {
public static void dijkstra(int n, int v, int[][] cost, int[] dist) {
int i, u, count, w;
int[] flag = new int[10];
int min;
for (i = 1; i <= n; i++) {
flag[i] = 0;
dist[i] = cost[v][i];
}
flag[v] = 1;
dist[v] = 0;
count = 2;
while (count <= n) {
min = 999;
u = 0;
for (w = 1; w <= n; w++) {
if (dist[w] < min && flag[w] == 0) {
min = dist[w];
u = w;
}
}
flag[u] = 1;
count++;
for (w = 1; w <= n; w++) {
if ((dist[u] + cost[u][w] < dist[w]) && flag[w] == 0) {
dist[w] = dist[u] + cost[u][w];
}
}
}
}

public static void main(String[] args) {
int n, v, i, j;
int[][] cost = new int[10][10];
int[] dist = new int[10];
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of nodes: ");
n = scanner.nextInt();

System.out.println("\nEnter the cost matrix:");
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
cost[i][j] = scanner.nextInt();
if (cost[i][j] == 0) {
cost[i][j] = 999;
}
}
}
System.out.print("\nEnter the source vertex: ");
v = scanner.nextInt();
dijkstra(n, v, cost, dist);
System.out.println("Shortest paths from vertex " + v + ":");
for (j = 1; j <= n; j++) {
if (j != v) {
System.out.println(v + "->" + j + ":::::" + dist[j]);
}
}
scanner.close();
}
}