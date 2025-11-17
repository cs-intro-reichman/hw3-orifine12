public class testing {
public static void main(String[] args) {



private static double endBalance(double loan, double rate, int n, double payment) {
for (int i=0; i<n; i++)
{
    loan = (loan - payment) * rate;
}
return loan;

}
}
}