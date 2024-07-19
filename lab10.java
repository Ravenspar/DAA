import java.util.Scanner;
public class KnapsackProblem {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
float[] weight = new float[50];
float[] profit = new float[50];
float[] ratio = new float[50];
float totalValue = 0, temp, capacity;
System.out.print("Enter the number of items: ");
int n = scanner.nextInt();
for (int i = 0; i < n; i++) {
System.out.printf("Enter Weight and Profit for item[%d]:\n", i);
weight[i] = scanner.nextFloat();
profit[i] = scanner.nextFloat();
}
System.out.print("Enter the capacity of knapsack: ");
capacity = scanner.nextFloat();
for (int i = 0; i < n; i++)
ratio[i] = profit[i] / weight[i];
for (int i = 0; i < n; i++) {
for (int j = i + 1; j < n; j++) {
if (ratio[i] < ratio[j]) {
temp = ratio[j];
ratio[j] = ratio[i];
ratio[i] = temp;
temp = weight[j];
weight[j] = weight[i];
weight[i] = temp;
temp = profit[j];
profit[j] = profit[i];
profit[i] = temp;
}
}
}
System.out.println("Knapsack problems using Greedy Algorithm:");
int i;
for (i = 0; i < n; i++) {
if (weight[i] > capacity)

break;
else {
totalValue += profit[i];
capacity -= weight[i];
}
}
if (i < n)
totalValue += ratio[i] * capacity;
System.out.println("\nThe maximum value is: " + totalValue);
scanner.close();
}
}