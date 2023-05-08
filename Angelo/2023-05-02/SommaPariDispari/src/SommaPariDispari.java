public class SommaPariDispari {
    public static void main(String[] args) {
        int[] numeri = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int sommaDiPari = 0;
        int sommaDiDispari = 0;
        for (int i = 0; i < numeri.length; i++) {
            if (i % 2 == 0) {
                sommaDiPari += numeri[i];
            } else {
                sommaDiDispari += numeri[i];
            }

        }
        if (sommaDiPari == sommaDiDispari) {
            System.out.print("pari e dispari uguali");
        } else {
            System.out.print("pari e dispari diversi");
        }
    }
}