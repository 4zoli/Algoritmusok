package hu.u_szeged.alg.submission1;

public class Main {

    /**
     * Irj egy olyan rekurziv fuggvenyt, amely egy egesz szamokat tartalmazo
     * (csokkeno sorrendben) rendezett tombben egy elore megadott elem
     * poziciojat keresi binaris keresessel. Ha az elem nem talalhato a tombben
     * a vissza teresi ertek legyen 0.
     *
     * @param fallen Egesz szamokat tartalmazo rendezett tomb
     * @param hero A keresett szam
     * @param from A tomb vizsgalt szakaszanak kezdete. Alapertek: 0
     * (opcionalis)
     * @param to A tomb vizsgalt szakaszanak vege. Alapertek: a tomb hossza - 1
     * (opcionalis)
     * @return 0 jelentse, hogy nincs a sorban, az 1-es, hogy az elso helyen,
     * stb.
     */
	
	public static int binSearchRec(int hero, int[] fallen, int from, int to) {
    		if (from > to ) return 0;	
    		int middle = (to + from) /2;
    		if ( hero == fallen[middle] )	return middle+1;	
    			else if ( hero > fallen[middle])	to = middle - 1;
    			else if ( hero < fallen[middle])	from = middle + 1;
    				return binSearchRec(hero, fallen, from, to);    	
    }
	

    public static int binarySearchWrapper(int[] input, int key) {
        return Main.binSearchRec(key, input, 0, input.length - 1);
    }

}
