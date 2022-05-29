package com.example.tp4_rpg;

import java.util.*;

public class TUnitaire {
    public static List<Hero> team;
    public static List<enemy> fight_enemy;
    public static int Boss;


    public static void main(String[] args){
    Création_perso();
    Combat();
    Combat_healer();
    }
    public static void Combat(){
        System.out.println("------Création de combat-----\n1 Warrior 1 Hunter 1 Mage 1 Healer");

        team = new ArrayList();
        team.add(new warior());
        team.add(new hunter());
        team.add(new mage());
        team.add(new healer());
        int nbenemy = team.size();

        fight_enemy = new ArrayList();
        for (int i = 1; i <= nbenemy; i++) {
            fight_enemy.add(new basicenemy());
        }
        while(team.size()!=0 && fight_enemy.size()!=0) {
            System.out.println(team);
            System.out.println(fight_enemy);
            Collections.shuffle(team);
            Collections.shuffle(fight_enemy);
            int tour_hero = team.size();
            int tour_enemy = fight_enemy.size();
            int tour = tour_enemy + tour_hero;
            while (tour != 0) {
                System.out.println("Tour: "+tour);
                Random random = new Random();
                int alea = random.nextInt(10) + 1;
                if (alea >= 1 && alea <= 5 && tour_enemy != 0 || tour_hero == 0) {
                    int vari = random.nextInt(team.size());
                    enemy enemy = fight_enemy.get(tour_enemy - 1);
                    Hero cible = team.get(vari);
                    int dégats = enemy.weapondamage - cible.armor;
                    if (dégats > 0) {
                        cible.lifepoints = cible.lifepoints - dégats;
                    }
                    if (cible.lifepoints <= 0) {
                        team.remove(cible);
                        System.out.println("Hero as been slain");
                        tour = 1;
                    }
                    tour_enemy = tour_enemy - 1;
                } else {
                    int vari = random.nextInt(fight_enemy.size());
                    Hero hero = team.get(tour_hero - 1);
                    enemy cible = fight_enemy.get(vari);
                    int dégats = hero.weapondamage - cible.armor;
                    if (hero instanceof hunter) {
                        if (hero.arrow > 0) {
                            if (dégats > 0) {
                                cible.lifepoints = cible.lifepoints - dégats;
                            }
                            if (cible.lifepoints <= 0) {
                                fight_enemy.remove(cible);
                                System.out.println("Enemy as been slain");
                                tour = 1;
                            }
                            hero.arrow = hero.arrow - 1;
                        }
                    }
                    if (hero instanceof spellcaster) {
                        if (hero.manapoints > 0) {
                            if (hero instanceof mage) {
                                if (dégats > 0) {
                                    cible.lifepoints = cible.lifepoints - dégats;
                                }
                                if (cible.lifepoints <= 0) {
                                    fight_enemy.remove(cible);
                                    System.out.println("Enemy as been slain");
                                    tour = 1;
                                }
                            }
                            if (hero instanceof healer) {
                                int heal = random.nextInt(team.size());
                                Hero giveheal = team.get(heal);
                                giveheal.lifepoints += hero.weapondamage;
                            }
                            hero.manapoints = hero.manapoints - 1;
                        }
                    }
                    if (hero instanceof warior) {
                        if (dégats > 0) {
                            cible.lifepoints = cible.lifepoints - dégats;
                        }
                        if (cible.lifepoints <= 0) {
                            fight_enemy.remove(cible);
                            System.out.println("Enemy as been slain");
                            tour = 1;
                        }
                    }
                    tour_hero = tour_hero - 1;
                }
                tour = tour - 1;
            }
        }
        System.out.println(team);
        System.out.println(fight_enemy);
        System.out.println("-----Fin Création Combat -----");
    }
    public static void Combat_healer(){
        System.out.println("------Création de combat-----\n4 Healer");

        team = new ArrayList();
        team.add(new healer());
        team.add(new healer());
        team.add(new healer());
        team.add(new healer());
        int nbenemy = team.size();

        fight_enemy = new ArrayList();
        for (int i = 1; i <= nbenemy; i++) {
            fight_enemy.add(new basicenemy());
        }
        while(team.size()!=0 && fight_enemy.size()!=0) {
            System.out.println(team);
            System.out.println(fight_enemy);
            Collections.shuffle(team);
            Collections.shuffle(fight_enemy);
            int tour_hero = team.size();
            int tour_enemy = fight_enemy.size();
            int tour = tour_enemy + tour_hero;
            while (tour != 0) {
                System.out.println("Tour: "+tour);
                Random random = new Random();
                int alea = random.nextInt(10) + 1;
                if (alea >= 1 && alea <= 5 && tour_enemy != 0 || tour_hero == 0) {
                    int vari = random.nextInt(team.size());
                    enemy enemy = fight_enemy.get(tour_enemy - 1);
                    Hero cible = team.get(vari);
                    int dégats = enemy.weapondamage - cible.armor;
                    if (dégats > 0) {
                        cible.lifepoints = cible.lifepoints - dégats;
                    }
                    if (cible.lifepoints <= 0) {
                        team.remove(cible);
                        System.out.println("Hero as been slain");
                        tour = 1;
                    }
                    tour_enemy = tour_enemy - 1;
                } else {
                    int vari = random.nextInt(fight_enemy.size());
                    Hero hero = team.get(tour_hero - 1);
                    enemy cible = fight_enemy.get(vari);
                    int dégats = hero.weapondamage - cible.armor;
                    if (hero instanceof hunter) {
                        if (hero.arrow > 0) {
                            if (dégats > 0) {
                                cible.lifepoints = cible.lifepoints - dégats;
                            }
                            if (cible.lifepoints <= 0) {
                                fight_enemy.remove(cible);
                                System.out.println("Enemy as been slain");
                                tour = 1;
                            }
                            hero.arrow = hero.arrow - 1;
                        }
                    }
                    if (hero instanceof spellcaster) {
                        if (hero.manapoints > 0) {
                            if (hero instanceof mage) {
                                if (dégats > 0) {
                                    cible.lifepoints = cible.lifepoints - dégats;
                                }
                                if (cible.lifepoints <= 0) {
                                    fight_enemy.remove(cible);
                                    System.out.println("Enemy as been slain");
                                    tour = 1;
                                }
                            }
                            if (hero instanceof healer) {
                                int heal = random.nextInt(team.size());
                                Hero giveheal = team.get(heal);
                                giveheal.lifepoints += hero.weapondamage;
                            }
                            hero.manapoints = hero.manapoints - 1;
                        }
                    }
                    if (hero instanceof warior) {
                        if (dégats > 0) {
                            cible.lifepoints = cible.lifepoints - dégats;
                        }
                        if (cible.lifepoints <= 0) {
                            fight_enemy.remove(cible);
                            System.out.println("Enemy as been slain");
                            tour = 1;
                        }
                    }
                    tour_hero = tour_hero - 1;
                }
                tour = tour - 1;
            }
        }
        System.out.println(team);
        System.out.println(fight_enemy);
        System.out.println("-----Fin Création Combat -----");
    }
    public static void Création_perso(){
        System.out.println("-----Création Perso-----");
        List<Hero> nbhero;
        List<consumable> consumables;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Warior choisi 1");
        int nbwarior = 1;
        System.out.println("Hunter choisi 1");
        int nbhunter = 1;
        System.out.println("Healer choisi 1");
        int nbhealer = 1;
        System.out.println("Mage choisi 1");
        int nbmage = 1;
        System.out.println("Vous avez "+ nbwarior +" warior(s), " + nbhunter + " hunter(s), "+ nbhealer +" healer(s), "+ nbmage + " mage(s)");

        consumables = new ArrayList();
        nbhero = new ArrayList();

        for (int i=1;i<= nbwarior;i++){
            nbhero.add(new warior());
            consumables.add(new food());
            consumables.add(new potion());
        }
        for (int i=1;i<= nbhunter;i++){
            nbhero.add(new hunter());
            consumables.add(new food());
            consumables.add(new potion());
        }
        for (int i=1;i<= nbhealer;i++){
            nbhero.add(new healer());
            consumables.add(new food());
            consumables.add(new potion());
        }
        for (int i=1;i<= nbmage;i++){
            nbhero.add(new mage());
            consumables.add(new food());
            consumables.add(new potion());
        }
        System.out.println(nbhero);
        System.out.println(consumables);
        System.out.println("-----Fin Création Perso-----");
    }

}
