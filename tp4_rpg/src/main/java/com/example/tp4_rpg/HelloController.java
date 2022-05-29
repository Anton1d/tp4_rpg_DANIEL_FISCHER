package com.example.tp4_rpg;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HelloController {
    public int boss;
    @FXML
    Button CombatButton;
    public static List<Hero> team;
    public List<enemy> fight_enemy;
    public Label combatText;
    public Label team1;
    public Label team2;
    public Label team3;
    public Label team4;
    public Label team5;
    public Label team6;
    public Label team7;
    public Label team8;
    public Label enemy1;public Label enemy2;public Label enemy3;public Label enemy4;public Label enemy5;public Label enemy6;public Label enemy7;public Label enemy8;


    @FXML
    public void initialize(){
            String texte = GameApplication.text();
            combatText.setText(texte);
            team = Game.team();

            for(int i=1;i<= team.size();i++){
                Hero hero = team.get(i-1);
                if(hero instanceof warior) {
                    String classe = "| Warior |";
                    int attak = hero.weapondamage;
                    int vie = hero.lifepoints;
                    int armor = hero.armor;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor;
                    if(i==1){team1.setText(var);}
                    if(i==2){team2.setText(var);}
                    if(i==3){team3.setText(var);}
                    if(i==4){team4.setText(var);}
                    if(i==5){team5.setText(var);}
                    if(i==6){team6.setText(var);}
                    if(i==7){team7.setText(var);}
                    if(i==8){team8.setText(var);}
                }
                if(hero instanceof hunter){
                    String classe = "| Hunter |";
                    int attak = hero.weapondamage;
                    int vie = hero.lifepoints;
                    int armor = hero.armor;
                    int arrow = hero.arrow;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor+"\n"+"flèches: "+arrow;
                    if(i==1){team1.setText(var);}
                    if(i==2){team2.setText(var);}
                    if(i==3){team3.setText(var);}
                    if(i==4){team4.setText(var);}
                    if(i==5){team5.setText(var);}
                    if(i==6){team6.setText(var);}
                    if(i==7){team7.setText(var);}
                    if(i==8){team8.setText(var);}
                }
                if(hero instanceof mage){
                    String classe = "| Mage |";
                    int attak = hero.weapondamage;
                    int vie = hero.lifepoints;
                    int armor = hero.armor;
                    int mana = hero.manapoints;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor+"\n"+"mana: "+mana;
                    if(i==1){team1.setText(var);}
                    if(i==2){team2.setText(var);}
                    if(i==3){team3.setText(var);}
                    if(i==4){team4.setText(var);}
                    if(i==5){team5.setText(var);}
                    if(i==6){team6.setText(var);}
                    if(i==7){team7.setText(var);}
                    if(i==8){team8.setText(var);}
                }
                if(hero instanceof healer){
                    String classe = "| Healer |";
                    int attak = hero.weapondamage;
                    int vie = hero.lifepoints;
                    int armor = hero.armor;
                    int mana = hero.manapoints;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor+"\n"+"mana: "+mana;
                    if(i==1){team1.setText(var);}
                    if(i==2){team2.setText(var);}
                    if(i==3){team3.setText(var);}
                    if(i==4){team4.setText(var);}
                    if(i==5){team5.setText(var);}
                    if(i==6){team6.setText(var);}
                    if(i==7){team7.setText(var);}
                    if(i==8){team8.setText(var);}
                }
            }
            int nbenemy = team.size();

            List<Hero> fight_hero =  team;
            fight_enemy = new ArrayList();
            //condition pour apparition d'un boss
            Random random = new Random();
            int alea = random.nextInt(10) + 1;
            if(alea==10){
                fight_enemy.add(new boss());
                boss =1;
            }
            else {
                for (int i = 1; i <= nbenemy; i++) {
                    fight_enemy.add(new basicenemy());
                }
            }
            for(int i=1;i<= fight_enemy.size();i++) {
                enemy opponent = fight_enemy.get(i - 1);
                if (opponent instanceof basicenemy) {
                    String classe = "| Basic enemy |";
                    int attak = opponent.weapondamage;
                    int vie = opponent.lifepoints;
                    int armor = opponent.armor;
                    String var = classe + "\n" + "vie: " + vie + "\n" + "attaque: " + attak + "\n" + "armure: " + armor;
                    if (i == 1) {
                        enemy1.setText(var);
                    }
                    if (i == 2) {
                        enemy2.setText(var);
                    }
                    if (i == 3) {
                        enemy3.setText(var);
                    }
                    if (i == 4) {
                        enemy4.setText(var);
                    }
                    if (i == 5) {
                        enemy5.setText(var);
                    }
                    if (i == 6) {
                        enemy6.setText(var);
                    }
                    if (i == 7) {
                        enemy7.setText(var);
                    }
                    if (i == 8) {
                        enemy8.setText(var);
                    }
                }
                if (opponent instanceof boss) {
                    String classe = "| Boss |";
                    int attak = opponent.weapondamage;
                    int vie = opponent.lifepoints;
                    int armor = opponent.armor;
                    String var = classe + "\n" + "vie: " + vie + "\n" + "attaque: " + attak + "\n" + "armure: " + armor;
                    if (i == 1) {
                        enemy1.setText(var);
                    }
                    if (i == 2) {
                        enemy2.setText(var);
                    }
                    if (i == 3) {
                        enemy3.setText(var);
                    }
                    if (i == 4) {
                        enemy4.setText(var);
                    }
                    if (i == 5) {
                        enemy5.setText(var);
                    }
                    if (i == 6) {
                        enemy6.setText(var);
                    }
                    if (i == 7) {
                        enemy7.setText(var);
                    }
                    if (i == 8) {
                        enemy8.setText(var);
                    }
                }
            }
    }
    @FXML
    protected void onCombatButtonClick(ActionEvent event){

        if(team.size()!=0 && fight_enemy.size()!=0){
            combatText.setText("Fin du tour !");
            Collections.shuffle(team);
            Collections.shuffle(fight_enemy);
            int tour_hero = team.size();
            int tour_enemy = fight_enemy.size();
            int tour = tour_enemy + tour_hero;
            while(tour !=0 ){
                Random random = new Random();
                int alea = random.nextInt(10) + 1;
                if(alea >=1 && alea <=5 && tour_enemy!=0 || tour_hero==0){
                    int vari = random.nextInt(team.size());
                    enemy enemy = fight_enemy.get(tour_enemy-1);
                    Hero cible = team.get(vari);
                    int dégats = enemy.weapondamage - cible.armor;
                    if(dégats>0){
                        cible.lifepoints = cible.lifepoints - dégats;
                    }
                    if(cible.lifepoints<=0){
                        team.remove(cible);
                        tour = 1;
                    }
                    tour_enemy = tour_enemy - 1;
                }
                else{
                    int vari = random.nextInt(fight_enemy.size());
                    Hero hero = team.get(tour_hero-1);
                    enemy cible = fight_enemy.get(vari);
                    int dégats= hero.weapondamage - cible.armor;
                    if(hero instanceof hunter){
                        if(hero.arrow >0){
                            if(dégats>0){
                                cible.lifepoints = cible.lifepoints - dégats;
                            }
                            if(cible.lifepoints<=0){
                                fight_enemy.remove(cible);
                                tour=1;
                            }
                            hero.arrow= hero.arrow -1;
                        }
                    }
                    if(hero instanceof spellcaster){
                        if(hero.manapoints >0){
                            if(hero instanceof mage){
                                if(dégats>0){
                                    cible.lifepoints = cible.lifepoints - dégats;
                                }
                                if(cible.lifepoints<=0){
                                    fight_enemy.remove(cible);
                                    tour=1;
                                }
                            }
                            if(hero instanceof healer){
                                int heal= random.nextInt(team.size());
                                Hero giveheal = team.get(heal);
                                giveheal.lifepoints += hero.weapondamage;
                            }
                            hero.manapoints= hero.manapoints -1;
                        }
                    }
                    if(hero instanceof warior){
                        if(dégats>0){
                            cible.lifepoints = cible.lifepoints - dégats;
                        }
                        if(cible.lifepoints<=0){
                            fight_enemy.remove(cible);
                            tour=1;
                        }
                    }
                    tour_hero =tour_hero - 1;
                }
                tour = tour -1;
            }
            for(int i=1;i<= team.size();i++){
                Hero hero = team.get(i-1);
                int W =0;
                int Hu=0;
                int M=0;
                int He=0;
                if(hero instanceof warior) {
                    W=1;
                    String classe = "| Warior |";
                    int attak = hero.weapondamage;
                    int vie = hero.lifepoints;
                    int armor = hero.armor;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor;
                    if(i==1){team1.setText(var);}
                    if(i==2){team2.setText(var);}
                    if(i==3){team3.setText(var);}
                    if(i==4){team4.setText(var);}
                    if(i==5){team5.setText(var);}
                    if(i==6){team6.setText(var);}
                    if(i==7){team7.setText(var);}
                    if(i==8){team8.setText(var);}
                }
                if(hero instanceof hunter){
                    Hu =1;
                    String classe = "| Hunter |";
                    int attak = hero.weapondamage;
                    int vie = hero.lifepoints;
                    int armor = hero.armor;
                    int arrow = hero.arrow;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor+"\n"+"flèches: "+arrow;
                    if(i==1){team1.setText(var);}
                    if(i==2){team2.setText(var);}
                    if(i==3){team3.setText(var);}
                    if(i==4){team4.setText(var);}
                    if(i==5){team5.setText(var);}
                    if(i==6){team6.setText(var);}
                    if(i==7){team7.setText(var);}
                    if(i==8){team8.setText(var);}
                }
                if(hero instanceof mage){
                    M=1;
                    String classe = "| Mage |";
                    int attak = hero.weapondamage;
                    int vie = hero.lifepoints;
                    int armor = hero.armor;
                    int mana = hero.manapoints;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor+"\n"+"mana: "+mana;
                    if(i==1){team1.setText(var);}
                    if(i==2){team2.setText(var);}
                    if(i==3){team3.setText(var);}
                    if(i==4){team4.setText(var);}
                    if(i==5){team5.setText(var);}
                    if(i==6){team6.setText(var);}
                    if(i==7){team7.setText(var);}
                    if(i==8){team8.setText(var);}
                }
                if(hero instanceof healer){
                    He=1;
                    String classe = "| Healer |";
                    int attak = hero.weapondamage;
                    int vie = hero.lifepoints;
                    int armor = hero.armor;
                    int mana = hero.manapoints;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor+"\n"+"mana: "+mana;
                    if(i==1){team1.setText(var);}
                    if(i==2){team2.setText(var);}
                    if(i==3){team3.setText(var);}
                    if(i==4){team4.setText(var);}
                    if(i==5){team5.setText(var);}
                    if(i==6){team6.setText(var);}
                    if(i==7){team7.setText(var);}
                    if(i==8){team8.setText(var);}
                }
            }
            int E=0;
            int B=0;
            for(int i=1;i<= fight_enemy.size();i++){
                enemy opponent = fight_enemy.get(i-1);
                if(opponent instanceof basicenemy){
                    E=1;
                    String classe = "| Basic enemy |";
                    int attak = opponent.weapondamage;
                    int vie = opponent.lifepoints;
                    int armor = opponent.armor;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor;
                    if(i==1){enemy1.setText(var);}
                    if(i==2){enemy2.setText(var);}
                    if(i==3){enemy3.setText(var);}
                    if(i==4){enemy4.setText(var);}
                    if(i==5){enemy5.setText(var);}
                    if(i==6){enemy6.setText(var);}
                    if(i==7){enemy7.setText(var);}
                    if(i==8){enemy8.setText(var);}
                }
                if(opponent instanceof boss){
                    B=1;
                    String classe = "| Boss |";
                    int attak = opponent.weapondamage;
                    int vie = opponent.lifepoints;
                    int armor = opponent.armor;
                    String var = classe + "\n"+"vie: "+vie+"\n"+"attaque: "+attak+"\n"+"armure: "+armor;
                    if(i==1){enemy1.setText(var);}
                    if(i==2){enemy2.setText(var);}
                    if(i==3){enemy3.setText(var);}
                    if(i==4){enemy4.setText(var);}
                    if(i==5){enemy5.setText(var);}
                    if(i==6){enemy6.setText(var);}
                    if(i==7){enemy7.setText(var);}
                    if(i==8){enemy8.setText(var);}
                }
            }
            if(8-fight_enemy.size()>0){
                for(int i=1;i<=8-fight_enemy.size();i++){
                    if(i==1){enemy8.setText("");}
                    if(i==2){enemy7.setText("");}
                    if(i==3){enemy6.setText("");}
                    if(i==4){enemy5.setText("");}
                    if(i==5){enemy4.setText("");}
                    if(i==6){enemy3.setText("");}
                    if(i==7){enemy2.setText("");}
                    if(i==8){enemy1.setText("");}
                }
            }
            if(8-team.size()>0){
                for(int i=1;i<=8-team.size();i++){
                    if(i==1){team8.setText("");}
                    if(i==2){team7.setText("");}
                    if(i==3){team6.setText("");}
                    if(i==4){team5.setText("");}
                    if(i==5){team4.setText("");}
                    if(i==6){team3.setText("");}
                    if(i==7){team2.setText("");}
                    if(i==8){team1.setText("");}
                }
            }

        }
        else{
            if(boss==1){
                if(boss==1 || team.size()!=0){
                    System.out.println("Vous avez gagné !");
                }
                else{
                    System.out.println("Vous avez perdu !");
                }
                System.out.println("Merci d'avoir joué au jeu, Veuillez me mettre une bonne note ^^");
                Platform.exit();
            }
            else{
                ((Node)(event.getSource())).getScene().getWindow().hide();
                try{
                    Parent root =FXMLLoader.load(getClass().getResource("wait-view.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
}