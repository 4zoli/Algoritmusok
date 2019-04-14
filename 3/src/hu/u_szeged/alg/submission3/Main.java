package hu.u_szeged.alg.submission3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Date;

public class Main {

    /**
     * Az Abszol uton talalhato Gringotts bankban a zsugori koboldok igen
     * mostohan bannak a fizeteshalasztasi kerelmek feldolgozasaval. Ket fiokba
     * erkeznek egyesevel a kervenyek, mindig a stoc tetejere. Ha a
     * nyomtatvanysorszam harommal osztva 1-et ad maradekul, akkor a level a
     * "nyIltan elutasItando" feliratu 1. fiokba kerul, 2 maradek eseten pedig a
     * "hadd remenykedjen meg" megnevezesube. Ellenben a harommal oszthato
     * sorszamuak utja valasz nelkul egyenesen az iratmegsemmisItobe visz.
     * Kozben az ugyeletes kobold idonkent feldolgoz egy darab kerelmet,
     * konkretan az elso fiok legfelso dokumentumat es postazza az elutasIto
     * valaszt. Ha azonban az eppen ures volt, akkor helyette a masodik fiok
     * tetejen levore valaszol (mar ha van). Technikailag az input tombben
     * pozitIv nyomtatvanysorszamok szerepelnek beerkezesi sorrendben, illetve
     * kozejuk ekelodve az egy-egy feldolgozasi esemenyt jelolo negatIv szam.
     * Irj eljarast, ami a megvalaszolt kerelmek nyomtatvanysorszamait
     * (megvalaszolasi sorrendben) egy tombben adja vissza.
     *
     * @param applications
     * @return
     */
    public static int[] rejectionOrder(int[] applications) {
    	Stack<Integer> remainedOne = new Stack<>();
    	Stack<Integer> remainedTwo = new Stack<>();
    	List<Integer> solution = new ArrayList<>();    

    	for(int i = 0; i < applications.length; i++)	{
    		if (applications[i] < 0)	{
    			if (!remainedOne.isEmpty())	{
    				solution.add(remainedOne.pop());
    				continue;
    			}
    			if (!remainedTwo.isEmpty())	{
    				solution.add(remainedTwo.pop());
    				continue;
    			}
    			else continue;
    		}
    		if (applications[i]%3 == 1)	{
    			remainedOne.push(applications[i]);
    		}
    		if (applications[i]%3 == 2)	{
    			remainedTwo.push(applications[i]);
    		}
    	}
    	
    	int[] output = new int[solution.size()];
    	for(int i = 0; i<solution.size(); i++) {
    		output[i] = solution.get(i);
    	}
    	
    	return(output);
    }    
}