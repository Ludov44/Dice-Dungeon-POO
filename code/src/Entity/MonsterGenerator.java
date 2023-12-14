package Entity;
// TODO : avoir un endroit ou les stats possibles des différents types de monstres sont décrites
public class MonsterGenerator { 

    /**
     * générateur de monstre
     * @param level Entier positif (roomNb) à ajouter aux stats aléatoires des monstres
     * @return monstre généré avec type et stats aléatoires
     */
    public static Monster generate(int level){
        Monster newMonster;
        double randomNumber = Math.random() * (1 + level * 0.2);
        int randomMonsterId = (int)(randomNumber*8+1); 
        switch (randomMonsterId) {
            case 1:
                newMonster = new ConfusedMonster(10 + (int)(randomNumber*10), 2 + (int)(randomNumber*5), (int)(randomNumber*2), "Zombie", 1 + (int)(randomNumber*3));
                break;
            case 2:
                newMonster = new AllOrNothingMonster(10 + (int)(randomNumber*15), 2 + (int)(randomNumber*3), (int)(randomNumber*5), "Fantôme", 1 + (int)(randomNumber*3));
            break;
            case 3:
                newMonster = new AutoHealingMonster(10 + (int)(randomNumber*15), 3 + (int)(randomNumber*3), (int)(randomNumber*5), "Vampire", 1 + (int)(randomNumber*3), 3);
            break;
            //case 4:
            //    newMonster = new SelfDestructMonster(10 + (int)(randomNumber*15), 1 + (int)(randomNumber*2), (int)(randomNumber*5), "Bombardier", 1 + (int)(randomNumber*3));
            //break;
            default:                // Les autres cas (1/2 de tomber sur monstre classique).
                newMonster = new Monster(10 + (int)(randomNumber*10), 2 + (int)(randomNumber*3), (int)(randomNumber*3), "Araignée", 1 + (int)(randomNumber*3));
        }

        return newMonster;
    }
}