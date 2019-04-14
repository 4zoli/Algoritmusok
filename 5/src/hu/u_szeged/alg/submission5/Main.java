package hu.u_szeged.alg.submission5;
import java.util.Comparator;
import java.util.Arrays;

class Dwarf {
    String name;
    int beardLength;
    int fightingSkill;
    int footballSkill;

    public Dwarf(String name, int beardLength, int fightingSkill, int footballSkill) {
        this.name = name;
        this.beardLength = beardLength;
        this.fightingSkill = fightingSkill;
        this.footballSkill = footballSkill;
    }

    public String toString() {
        return this.name + " (" + this.beardLength + ", " + this.fightingSkill + ", " + this.footballSkill + ")";
    }
}

class Compare implements Comparator<Dwarf>	{
	public int eredm;
	
	@Override
	public int compare(Dwarf torp1, Dwarf torp2) {
		eredm = Integer.compare(torp2.beardLength, torp1.beardLength);
		if(eredm == 0)	{
			eredm = Integer.compare(torp2.fightingSkill, torp1.fightingSkill);
			if(eredm == 0)	{
				eredm = Integer.compare(torp2.footballSkill, torp1.footballSkill);
				return eredm;
			}
			return eredm;
		}
		return eredm;
	}
}

public class Main {
    private static String[] buildTeam(Dwarf[] dwarfs, int[] teamMembers) {
       String[] output = new String[teamMembers.length];
    	Arrays.sort(dwarfs, new Compare());
    	
    	for(int i=0; i<teamMembers.length; i++)	{
    		output[i] = dwarfs[teamMembers[i]-1].name;
    	}
    	
    	return output;
    	
    }

    
    
    
    
    public static String[] buildTeamWrapper(Dwarf[] dwarfs, int[] teamMembers) {
        return buildTeam(dwarfs, teamMembers);
    }

}
