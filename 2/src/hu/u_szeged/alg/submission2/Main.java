package hu.u_szeged.alg.submission2;

public class Main {

    /**
     * Legolas koztudottan szeret lepcsozni es epp most is egy lepcsosor elott
     * all. Tunde szemevel n darab lepcsofokot lat. Legolas a lepcsokon
     * egyszerre csak 1 vagy 2 lepest tud megtenni es azt szeretne kiszamolni,
     * hogy ilyen modon hanyfelekeppen maszhatja meg az n lepcsofokos lepcsot.
     * Sajnos Legolas nagyon lassan szamol (gyanus, hogy dimaton megbukott),
     * segits neki gyorsan szamolni dinamikus programozast alkalmazva
     *
     * @param n, a lepcsok szama
     * @return egy egesz szam, ahanyfelekeppen Legolas megmaszhatja a lepcsosort
     */
    public static long legolasStepCounting(int n) {
    	if (n == 1) return 1;
    	if (n == 2) return 2;
    	long T[] = new long[n+1];
    	T[1] = 1;
    	T[2] = 2;
			for (int i = 3; i <= n ; i++)	{
				T[i] = T[i-1] + T[i-2];
			}
    return T[n];
    }

    public static long legolasStepCountingWrapper(int key) {
        return Main.legolasStepCounting(key);
    }

}
