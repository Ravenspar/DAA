 import java.util.Scanner;

public class SubsetSum {
public static void subset(int n, int d, int[] w) {
int[] x = new int[10];
int i, k, s;
for (i = 1; i < n; i++)
x[i] = 0;
s = 0;
k = 1;
x[k] = 1;
while (true) {
if (k <= n && x[k] == 1) {
if (s + w[k] == d) {
System.out.println("\nSolution is:");
for (i = 1; i <= n; i++) {
if (x[i] == 1)
System.out.print(w[i] + " ");
}
System.out.println();
x[k] = 0;
} else if (s + w[k] < d)
s += w[k];
else
x[k] = 0;
} else {
k--;
while (k > 0 && x[k] == 0)
k--;
if (k == 0)
break;
s = s - w[k];
x[k] = 0;
}
k = k + 1;
x[k] = 1;
}
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int n, d, i;

int[] w = new int[20];
System.out.println("\nEnter the value of n:");
n = scanner.nextInt();
System.out.println("Enter the set values in increasing order:");
for (i = 1; i <= n; i++)
w[i] = scanner.nextInt();
System.out.println("\nEnter the maximum value:");
d = scanner.nextInt();
subset(n, d, w);
scanner.close();
}
}