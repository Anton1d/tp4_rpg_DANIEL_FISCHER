package com.example.tp4_rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Game{
    private static final int List = 0;
    private int playerTurn;
    protected static List<Hero> nbhero;
    public static List<consumable> consumables;


    public void playGame(){
        System.out.println("Bonjour et bienvenue sur le jeu Mini RPG Lite 3000");
        System.out.println("Les règles sont simple, vous devez battre le boss du donjon.");
        System.out.println("Pour commencer le jeu, veuillez choisir le nombre de héro avec les classes suivantes: Warior, Hunter, Healer, Mage");
        System.out.println("Veuillez entrer le nombre de héro que vous voulez faire combatre");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Warior:");
        int nbwarior = scanner.nextInt();
        System.out.println("Hunter:");
        int nbhunter = scanner.nextInt();
        System.out.println("Healer:");
        int nbhealer = scanner.nextInt();
        System.out.println("Mage");
        int nbmage = scanner.nextInt();
        System.out.println("Vous avez choisis "+ nbwarior +" warior(s), " + nbhunter + " hunter(s), "+ nbhealer +" healer(s), "+ nbmage + " mage(s)");
        
        this.consumables = new ArrayList();
        this.nbhero = new ArrayList();
        
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


    }
    public static List<Hero> team(){
        List<Hero> team = nbhero;
        return team;
    }

    public void récompense(){
        if(nbhero.size()!=0){
            System.out.println("Vous avez gagné ce combat ! ");
            System.out.println("Veuillez chiosir votre récompense:");
            for(int i=1;i<=nbhero.size();i++){
                Hero hero = nbhero.get(i-1);
                Scanner scanner = new Scanner(System.in);
                if(hero instanceof warior){
                    System.out.println("Voici un warior. Voici ces stats après son combat:");
                    System.out.println("Vie: "+hero.lifepoints);
                    System.out.println("Dégats: "+hero.weapondamage);
                    System.out.println("Armure: "+hero.armor);
                    int choix =1;
                    while(choix!=0){
                        System.out.println("Vous avez le choix entre:");
                        System.out.println("-Améliorer la vie (tapez 1)");
                        System.out.println("-Améliorer les dégats (tapez 2)");
                        System.out.println("-Améliorer l'armure (tapez 3)");
                        System.out.println("-Améliorer l'effi du pain et potions (tapez 4)");
                        System.out.println("-Ajouter du pain et des potions (tapez 5)");
                        int amelio = scanner.nextInt();
                        if(amelio==1){
                            hero.lifepoints= hero.lifepoints + 4;
                            System.out.println("La vie du personnage a été amélioré");
                            System.out.println("vie: "+hero.lifepoints);
                            choix =0;
                        }
                        if(amelio==2){
                            hero.weapondamage +=2;
                            System.out.println("L'attaque du personnage a été amélioré");
                            System.out.println("dégats: "+hero.weapondamage);
                            choix =0;
                        }
                        if(amelio==3){
                            hero.armor +=1;
                            System.out.println("L'armure du personnage a été amélioré");
                            System.out.println("armure: "+hero.armor);
                            choix =0;
                        }
                        if(amelio==4){
                            if(consumables.size()==0){
                                System.out.println("Vous avez aucune potion ni de pain à améliorer");
                            }
                            else{
                                for(int f=1;f<=consumables.size();f++){
                                    consumable conso = consumables.get(f-1);
                                    if(conso instanceof food){
                                        conso.vie+=1;
                                    }
                                    if(consumables instanceof potion){
                                        conso.givemana+=1;
                                    }
                                }
                                System.out.println("Tous les consomables ont été améliorés.");
                                choix=0;
                            }
                        }
                        if(amelio==5){
                            consumables.add(new food());
                            consumables.add(new potion());
                            System.out.println("1 potion et 1 pain ont été ajoutés à votre sac");
                            choix=0;
                        }
                    }
                }
                if(hero instanceof hunter){
                    System.out.println("Voici un hunter. Voici ces stats après son combat:");
                    System.out.println("Vie: "+hero.lifepoints);
                    System.out.println("Dégats: "+hero.weapondamage);
                    System.out.println("Armure: "+hero.armor);
                    System.out.println("Flèches: "+hero.arrow);
                    int choix =1;
                    while(choix!=0){
                        System.out.println("Vous avez le choix entre:");
                        System.out.println("-Améliorer la vie (tapez 1)");
                        System.out.println("-Améliorer les dégats (tapez 2)");
                        System.out.println("-Améliorer l'armure (tapez 3)");
                        System.out.println("-Ajouter des flèches (tapez 4)");
                        System.out.println("-Améliorer l'effi du pain et potions (tapez 5)");
                        System.out.println("-Ajouter du pain et des potions (tapez 6)");
                        int amelio = scanner.nextInt();
                        if(amelio==1){
                            hero.lifepoints= hero.lifepoints + 4;
                            System.out.println("La vie du personnage a été amélioré");
                            System.out.println("vie: "+hero.lifepoints);
                            choix =0;
                        }
                        if(amelio==2){
                            hero.weapondamage +=2;
                            System.out.println("L'attaque du personnage a été amélioré");
                            System.out.println("dégats: "+hero.weapondamage);
                            choix =0;                         
                        }
                        if(amelio==3){
                            hero.armor +=1;
                            System.out.println("L'armure du personnage a été amélioré");
                            System.out.println("armure: "+hero.armor);
                            choix =0;
                            
                        }
                        if(amelio==5){
                            if(consumables.size()==0){
                                System.out.println("Vous avez aucune potion ni de pain à améliorer");
                            }
                            else{
                                for(int f=1;f<=consumables.size();f++){
                                    consumable conso = consumables.get(f-1);
                                    if(conso instanceof food){
                                        conso.vie+=1;
                                    }
                                    if(consumables instanceof potion){
                                        conso.givemana+=1;
                                    }
                                }
                                System.out.println("Tous les consomables ont été améliorés.");
                                choix=0;
                            }
                            
                        }
                        if(amelio==6){
                            consumables.add(new food());
                            consumables.add(new potion());
                            System.out.println("1 potion et 1 pain ont été ajoutés à votre sac");
                            choix=0;
                            
                        }
                        if(amelio==4){
                            hero.arrow+=5;
                            System.out.println("5 flèches ont été ajoutées");
                            choix=0;
                        }
                    }
                }
                
                if(hero instanceof healer){
                    System.out.println("Voici un healer. Voici ces stats après son combat:");
                    System.out.println("Vie: "+hero.lifepoints);
                    System.out.println("Dégats: "+hero.weapondamage);
                    System.out.println("Armure: "+hero.armor);
                    System.out.println("Mana: "+hero.manapoints);
                    int choix =1;
                    while(choix!=0){
                        System.out.println("Vous avez le choix entre:");
                        System.out.println("-Améliorer la vie (tapez 1)");
                        System.out.println("-Améliorer le heal (tapez 2)");
                        System.out.println("-Améliorer l'armure (tapez 3)");
                        System.out.println("-Ajouter du mana (tapez 4");
                        System.out.println("-Améliorer l'effi du pain et potions (tapez 5)");
                        System.out.println("-Ajouter du pain et des potions (tapez 6)");
                        int amelio = scanner.nextInt();
                        if(amelio==1){
                            hero.lifepoints= hero.lifepoints + 4;
                            System.out.println("La vie du personnage a été amélioré");
                            System.out.println("vie: "+hero.lifepoints);
                            choix =0;
                        }
                        if(amelio==2){
                            hero.weapondamage +=2;
                            System.out.println("Le heal du personnage a été amélioré");
                            System.out.println("heal: "+hero.weapondamage);
                            choix =0;
                            
                        }
                        if(amelio==3){
                            hero.armor +=1;
                            System.out.println("L'armure du personnage a été amélioré");
                            System.out.println("armure: "+hero.armor);
                            choix =0;
                            
                        }
                        if(amelio==5){
                            if(consumables.size()==0){
                                System.out.println("Vous avez aucune potion ni de pain à améliorer");
                            }
                            else{
                                for(int f=1;f<=consumables.size();f++){
                                    consumable conso = consumables.get(f-1);
                                    if(conso instanceof food){
                                        conso.vie+=1;
                                    }
                                    if(consumables instanceof potion){
                                        conso.givemana+=1;
                                    }
                                }
                                System.out.println("Tous les consomables ont été améliorés.");
                                choix=0;
                            }
                            
                        }
                        if(amelio==6){
                            consumables.add(new food());
                            consumables.add(new potion());
                            System.out.println("1 potion et 1 pain ont été ajoutés à votre sac");
                            choix=0;
                            
                        }
                        if(amelio==4){
                            hero.manapoints+=5;
                            System.out.println("5 points de mana ont été ajoutés");
                            choix=0;
                        }
                    }
                }

                
                if(hero instanceof mage){
                    System.out.println("Voici un mage. Voici ces stats après son combat:");
                    System.out.println("Vie: "+hero.lifepoints);
                    System.out.println("Dégats: "+hero.weapondamage);
                    System.out.println("Armure: "+hero.armor);
                    System.out.println("Mana: "+hero.manapoints);
                    int choix =1;
                    while(choix!=0){
                        System.out.println("Vous avez le choix entre:");
                        System.out.println("-Améliorer la vie (tapez 1)");
                        System.out.println("-Améliorer les dégats (tapez 2)");
                        System.out.println("-Améliorer l'armure (tapez 3)");
                        System.out.println("-Ajouter du mana (tapez 4)");
                        System.out.println("-Améliorer l'effi du pain et potions (tapez 5)");
                        System.out.println("-Ajouter du pain et des potions (tapez 6)");
                        int amelio = scanner.nextInt();
                        if(amelio==1){
                            hero.lifepoints= hero.lifepoints + 4;
                            System.out.println("La vie du personnage a été amélioré");
                            choix = 0;
                        }
                        if(amelio==2){
                            hero.weapondamage +=2;
                            System.out.println("L'attaque du personnage a été amélioré");
                            System.out.println("dégats: "+hero.weapondamage);
                            choix =0;                        
                        }
                        if(amelio==3){
                            hero.armor +=1;
                            System.out.println("L'armure du personnage a été amélioré");
                            System.out.println("armure: "+hero.armor);
                            choix =0;
                            
                        }
                        if(amelio==5){
                            if(consumables.size()==0){
                                System.out.println("Vous avez aucune potion ni de pain à améliorer");
                            }
                            else{
                                for(int f=1;f<=consumables.size();f++){
                                    consumable conso = consumables.get(f-1);
                                    if(conso instanceof food){
                                        conso.vie+=1;
                                    }
                                    if(consumables instanceof potion){
                                        conso.givemana+=1;
                                    }
                                }
                                System.out.println("Tous les consomables ont été améliorés.");
                                choix=0;
                            }
                            
                        }
                        if(amelio==6){
                            consumables.add(new food());
                            consumables.add(new potion());
                            System.out.println("1 potion et 1 pain ont été ajoutés à votre sac");
                            choix=0;
                            
                        }
                        if(amelio==4){
                            hero.manapoints+=5;
                            System.out.println("5 points de mana ont été ajoutés");
                            choix=0;
                            
                        }
                    }
                }

                
            } 
        }
        else{
            System.out.println("Votre équipe a été décimée !");
            System.out.println("Merci d'avoir joué au jeu");
            //fin du jeu
            
        }

    }
}
 





