import java.util.Random;

public class MergeSort {
static int[] a = new int[20];
public static void simpleMerge(int low, int mid, int high) {
int i, j, k;
int[] c = new int[20];
k = low;
i = low;
j = mid + 1;
while (i <= mid && j <= high) {
if (a[i] < a[j])
c[k++] = a[i++];
else
c[k++] = a[j++];
}
while (i <= mid)
c[k++] = a[i++];
while (j <= high)
c[k++] = a[j++];
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
e.printStackTrace();
}
for (i = low; i <= k - 1; i++)
a[i] = c[i];
}
public static void mergeSort(int low, int high) {
int mid;
if (low < high) {
mid = (low + high) / 2;
mergeSort(low, mid);
mergeSort(mid + 1, high);
simpleMerge(low, mid, high);
}
}
public static void main(String[] args) {
int n, i, val;
long start, end;
System.out.println("Enter value of n:");
n = Integer.parseInt(System.console().readLine());
System.out.println("\nArray values are (randomly generated):");
Random rand = new Random();
for (i = 0; i < n; i++) {
val = rand.nextInt(100);
a[i] = val;
System.out.println(a[i] + ", Thread id=" + Thread.currentThread().getId());
}
start = System.currentTimeMillis();
mergeSort(0, n - 1);
System.out.println("Sorted array is:");
for (i = 0; i < n; i++)
System.out.println(a[i]);
end = System.currentTimeMillis();
System.out.println("\nTime taken : " + (end - start) + " milliseconds");
}
}