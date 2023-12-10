package Entity;
// TODO : avoir un endroit ou les stats possibles des != types de monstres sont décrites
public class MonsterGenerator { // TODO : intégrer les monstres spéciaux au générateur

    /**
     * générateur de monstre
     * @return monstre généré avec type et stats aléatoires
     */
    public static Monster generate(){
        Monster newMonster;
        double randomNumber = Math.random();
        int randomMonsterId = (int)(randomNumber*3+1); 
        switch (randomMonsterId) {
            case 1:
                newMonster = new Monster(10 + (int)(randomNumber*15), 1 + (int)(randomNumber*8),(int)(randomNumber*2), "Squelette", 1 + (int)(randomNumber*3));
                break;
            case 2:
                newMonster = new Monster(10 + (int)(randomNumber*30), 1 + (int)(randomNumber*4),(int)(randomNumber*5), "Zombie", 1 + (int)(randomNumber*3));
            break;
            default:                // Le cas 3.
                newMonster = new Monster(10 + (int)(randomNumber*20), 1 + (int)(randomNumber*6),(int)(randomNumber*3), "Araignée", 1 + (int)(randomNumber*3));
        }

        return newMonster;
    }
}
