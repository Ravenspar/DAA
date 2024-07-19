import java.util.Random;

public class QuickSort {
static int[] a = new int[20];
static int n, i, j, temp;
public static void quickSort(int low, int high) {
int j;
if (low <= high) {
j = partition(low, high);
quickSort(low, j - 1);
quickSort(j + 1, high);
}
}
public static int partition(int low, int high) {
int i, j, key;
key = a[low];
i = low + 1;
j = high;
while (true) {
while (i < high && a[i] < key)
i++;
while (key < a[j])
j--;
if (i < j) {
temp = a[i];
a[i] = a[j];
a[j] = temp;
} else {
temp = a[low];
a[low] = a[j];
a[j] = temp;
return j;
}
}
}
public static void main(String[] args) {
long start, end;
int val;
System.out.println("\nEnter the number of elements:");
n = Integer.parseInt(System.console().readLine());
System.out.println("\nArray elements are:");
Random rand = new Random();
for (i = 0; i < n; i++) {
val = rand.nextInt(100);
a[i] = val;
System.out.print(a[i] + "\t");
}
start = System.currentTimeMillis();
quickSort(0, n - 1);
System.out.println("\nSorted elements are:");
for (i = 0; i < n; i++)
System.out.println(a[i]);
end = System.currentTimeMillis();
System.out.println("\nTime taken is: " + (end - start) + " milliseconds");
}
}