package hu.u_szeged.alg.submission4;
import java.util.Arrays;
import java.util.HashSet;


public class Main {
	/**
	 * Bimba Professzor gyogynovenytan oran azt a feladatot adja Harry Potternek, hogy mandragora
	 * gyokereket ultessen el cserepekbe. A cserepek egy sorban helyezkednek el a Roxfort falanak
	 * toveben (1-tol sorszamozva). Mivel tini mandragorakrol van szo, igy eletbe lep a "fiatal 
	 * mandragorak torvenye", miszerint azokat nem lehet egymas kozelebe ulteni - minden mandragora
	 * kozt legalabb 2 ures cserep kell, hogy legyen. Tovabba egy cserepbe legfeljebb egy
	 * fiatal mandragora kerulhet.

	 * Harrynek muszaj Bimba Professzor utasitasait kovetnie, aki mindig megmondja, hogy hanyadik
	 * cserepbe kell a kovetkezo mandragorat ultetni. A tanarno azonban nagyon cseles es
	 * neha olyan utasitasokat is mond, amiket Harry nem tud teljesiteni, mert megsertene a "fiatal
	 * mandragorak torvenyet". Ekkor Harrynek egyszeruen nem szabad beultetnie a szoban forgo
	 * mandragora gyokeret. Az esemenyek soran elofordulhat, hogy nehany mar elultetett mandrago-
	 * ra erette valik, ekkor a novenyt el kell tavolitani a cserepjebol. Ilyenkor Bimba Professzor 
	 * mindig jelzi Harrynek, hogy az adott cserepben levo mandragorat el kell tavolitani, 
	 * de itt is ravasz, ugyanis neha olyan cserepek tartalmanak eltavolitasat is utasithatja,
	 * amelyekben nincs is mandragora. Ekkor termeszetesen Harrynek nincs semmi dolga.
	
	 * Feladatunk meghatarozni, hogy Bimba Professzor utasitasainak vegeztevel mely
	 * cserepeket foglaljak el tinedzser mandragorak.
	
	 * @param commands
	 * 		utasitasokat (Command osztaly) tartalmazo tomb, mely idorendi sorrendben tartalmazza
	 * 		a tanarno utasitasait az ultetesrol es az eltavolitasrol. Minden utasitas tartalmazza
	 * 		a cserep sorszamat (number) es az elvegzendo munkat (job).
	 * 
	 * @return a mandragorak altal elfoglalt cserepek sorszama novekvo sorrendben felsorolva.
	
	**/

	public static long[] HarryThePotter(Command[] commands) {
		HashSet<Long> cserepek = new HashSet<Long>();
		
		for(int i=0; i<commands.length; i++)	{
			if(commands[i].job.equals("pot"))	{
				if(!cserepek.contains(commands[i].number) &&
				!cserepek.contains(commands[i].number -1) && 
				!cserepek.contains(commands[i].number -2) && 
				!cserepek.contains(commands[i].number+1) && 
				!cserepek.contains(commands[i].number+2))	{
					cserepek.add(commands[i].number);
				}	else continue;
			}
			if(commands[i].job.equals("remove"))	{
				if(cserepek.contains(commands[i].number))	{
					cserepek.remove(commands[i].number);
				}	else continue;
			}
		}
		
		long[] output = new long[cserepek.size()];
		int i = 0;
		for (Long elem: cserepek) {
			output[i] = elem;
			i++;
		}
		Arrays.sort(output);		
		return output ;
	}

}

class Command {
	String job;
	long number;

	public Command(String job, long number) {
		this.job = job;
		this.number = number;
	}
}
