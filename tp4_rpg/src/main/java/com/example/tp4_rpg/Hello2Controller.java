package com.example.tp4_rpg;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.IOException;
import java.util.*;

public class Hello2Controller {
    @FXML
    Button vieperso;
    Button armorperso;
    Button amoperso;
    Button consoUp;
    Button consoNum;
    public ImageView Warriorimage;public ImageView Hunterimage;public ImageView Mageimage;public ImageView Healerimage;

    public List<Hero> team;
    public List<consumable> consumables;
    public int numero;
    //public Label classe;
    public Label vie;public Label armor;public Label attk;public Label conso; public Label amo;


    @FXML
    public void initialize(){
        team = HelloController.team;
        numero= team.size();
        consumables = Game.consumables;
        reward();
    }
    public void reward() {
        Hero hero = team.get(numero-1);
        vie.setText("Vie: " + hero.lifepoints);
        armor.setText("Armor: " + hero.armor);
        attk.setText("Weapon damage: " + hero.weapondamage);
        int num1 = 0;
        int num2 = 0;
        int foodvie=0;
        int potionmana=0;
        for (int i = 1; i <= consumables.size(); i++) {
            consumable conso = consumables.get(i - 1);
            if (conso instanceof food) {
                num1 = num1 + 1;
                foodvie = conso.vie;
            }
            if (conso instanceof potion) {
                num2 = num2 + 1;
                potionmana = conso.givemana;
            }
        }
        conso.setText("Consomation: \npain: nombre " + num1 + " vie " + foodvie + "\npotion: nombre "+ num2 +" mana "+potionmana);



        if (hero instanceof warior) {
            amo.setText("");
            //classe.setText("WARIOR");
            Warriorimage.setOpacity(1.0);
            Hunterimage.setOpacity(0.0);
            Mageimage.setOpacity(0.0);
            Healerimage.setOpacity(0.0);
        }
        if (hero instanceof hunter) {
            amo.setText("Flèches: " + hero.arrow);
            //classe.setText("HUNTER");
            Warriorimage.setOpacity(0.0);
            Hunterimage.setOpacity(1.0);
            Mageimage.setOpacity(0.0);
            Healerimage.setOpacity(0.0);
        }
        if (hero instanceof mage) {
            amo.setText("Mana: " + hero.manapoints);
            //classe.setText("MAGE");
            Warriorimage.setOpacity(0.0);
            Hunterimage.setOpacity(0.0);
            Mageimage.setOpacity(1.0);
            Healerimage.setOpacity(0.0);
        }
        if (hero instanceof healer) {
            amo.setText("Mana: " + hero.manapoints);
            //classe.setText("HEALER");
            Warriorimage.setOpacity(0.0);
            Hunterimage.setOpacity(0.0);
            Mageimage.setOpacity(0.0);
            Healerimage.setOpacity(1.0);
        }
    }
    @FXML
    protected void onviepersoButtonClick(ActionEvent event){
        Hero hero =team.get(numero-1);
        hero.lifepoints+=4;
        numero-=1;
        if(numero>0){
            hero= team.get(numero-1);

            vie.setText("Vie: " + hero.lifepoints);
            armor.setText("Armor: " + hero.armor);
            attk.setText("Weapon damage: " + hero.weapondamage);
            int num1 = 0;
            int num2 = 0;
            int foodvie=0;
            int potionmana=0;
            for (int i = 1; i <= consumables.size(); i++) {
                consumable conso = consumables.get(i - 1);
                if (conso instanceof food) {
                    num1 = num1 + 1;
                    foodvie = conso.vie;
                }
                if (conso instanceof potion) {
                    num2 = num2 + 1;
                    potionmana = conso.givemana;
                }
            }
            conso.setText("Consomation: \npain: nombre " + num1 + " vie " + foodvie + "\npotion: nombre "+ num2 +" mana "+potionmana);



            if (hero instanceof warior) {
                amo.setText("");
                //classe.setText("WARIOR");
                Warriorimage.setOpacity(1.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof hunter) {
                amo.setText("Flèches: " + hero.arrow);
                //classe.setText("HUNTER");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(1.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof mage) {
                amo.setText("Mana: " + hero.manapoints);
                //classe.setText("MAGE");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(1.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof healer) {
                amo.setText("Mana: " + hero.manapoints);
                //classe.setText("HEALER");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(1.0);
            }
        }
        else{
            ((Node)(event.getSource())).getScene().getWindow().hide();
            utilisation_conso();
            try{
                Parent root =FXMLLoader.load(getClass().getResource("game-view.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @FXML
protected void onarmorpersoButtonClick(ActionEvent event){
        Hero hero =team.get(numero-1);
        hero.armor+=2;
        numero-=1;
        if(numero>0){
            hero= team.get(numero-1);

            vie.setText("Vie: " + hero.lifepoints);
            armor.setText("Armor: " + hero.armor);
            attk.setText("Weapon damage: " + hero.weapondamage);
            int num1 = 0;
            int num2 = 0;
            int foodvie=0;
            int potionmana=0;
            for (int i = 1; i <= consumables.size(); i++) {
                consumable conso = consumables.get(i - 1);
                if (conso instanceof food) {
                    num1 = num1 + 1;
                    foodvie = conso.vie;
                }
                if (conso instanceof potion) {
                    num2 = num2 + 1;
                    potionmana = conso.givemana;
                }
            }
            conso.setText("Consomation: \npain: nombre " + num1 + " vie " + foodvie + "\npotion: nombre "+ num2 +" mana "+potionmana);



            if (hero instanceof warior) {
                amo.setText("");
                //classe.setText("WARIOR");
                Warriorimage.setOpacity(1.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof hunter) {
                amo.setText("Flèches: " + hero.arrow);
                //classe.setText("HUNTER");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(1.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof mage) {
                amo.setText("Mana: " + hero.manapoints);
                //classe.setText("MAGE");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(1.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof healer) {
                amo.setText("Mana: " + hero.manapoints);
                //classe.setText("HEALER");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(1.0);
            }
        }
        else{
            ((Node)(event.getSource())).getScene().getWindow().hide();
            utilisation_conso();
            try{
                Parent root =FXMLLoader.load(getClass().getResource("game-view.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    @FXML
    protected void onamopersoButtonClick(ActionEvent event){
        Hero hero =team.get(numero-1);
        if(hero instanceof hunter){
        hero.arrow+=5;
        numero-=1;
        }
        if(hero instanceof mage){
            hero.manapoints+=5;
            numero-=1;
        }
        if(hero instanceof healer){
            hero.manapoints+=5;
            numero-=1;
        }
        if(hero instanceof warior){}
        else {
            if (numero > 0) {
                hero = team.get(numero - 1);

                vie.setText("Vie: " + hero.lifepoints);
                armor.setText("Armor: " + hero.armor);
                attk.setText("Weapon damage: " + hero.weapondamage);
                int num1 = 0;
                int num2 = 0;
                int foodvie = 0;
                int potionmana = 0;
                for (int i = 1; i <= consumables.size(); i++) {
                    consumable conso = consumables.get(i - 1);
                    if (conso instanceof food) {
                        num1 = num1 + 1;
                        foodvie = conso.vie;
                    }
                    if (conso instanceof potion) {
                        num2 = num2 + 1;
                        potionmana = conso.givemana;
                    }
                }
                conso.setText("Consomation: \npain: nombre " + num1 + " vie " + foodvie + "\npotion: nombre " + num2 + " mana " + potionmana);


                if (hero instanceof warior) {
                    amo.setText("");
                    //classe.setText("WARIOR");
                    Warriorimage.setOpacity(1.0);
                    Hunterimage.setOpacity(0.0);
                    Mageimage.setOpacity(0.0);
                    Healerimage.setOpacity(0.0);
                }
                if (hero instanceof hunter) {
                    amo.setText("Flèches: " + hero.arrow);
                    //classe.setText("HUNTER");
                    Warriorimage.setOpacity(0.0);
                    Hunterimage.setOpacity(1.0);
                    Mageimage.setOpacity(0.0);
                    Healerimage.setOpacity(0.0);
                }
                if (hero instanceof mage) {
                    amo.setText("Mana: " + hero.manapoints);
                    //classe.setText("MAGE");
                    Warriorimage.setOpacity(0.0);
                    Hunterimage.setOpacity(0.0);
                    Mageimage.setOpacity(1.0);
                    Healerimage.setOpacity(0.0);
                }
                if (hero instanceof healer) {
                    amo.setText("Mana: " + hero.manapoints);
                    //classe.setText("HEALER");
                    Warriorimage.setOpacity(0.0);
                    Hunterimage.setOpacity(0.0);
                    Mageimage.setOpacity(0.0);
                    Healerimage.setOpacity(1.0);
                }
            } else {

                ((Node)(event.getSource())).getScene().getWindow().hide();
                utilisation_conso();
                try{
                    Parent root =FXMLLoader.load(getClass().getResource("game-view.fxml"));
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
    @FXML
    protected void onconsoUpButtonClick(ActionEvent event){
        if(consumables.size()==0){}
        else{
            for(int f=1;f<=consumables.size();f++){
                consumable conso = consumables.get(f-1);
                if(conso instanceof food){
                    conso.vie+=1;
                }
                if(conso instanceof potion){
                    conso.givemana+=1;
                }
            }
            numero-=1;
            if (numero > 0) {
                Hero hero = team.get(numero - 1);
                vie.setText("Vie: " + hero.lifepoints);
                armor.setText("Armor: " + hero.armor);
                attk.setText("Weapon damage: " + hero.weapondamage);
                int num1 = 0;
                int num2 = 0;
                int foodvie = 0;
                int potionmana = 0;
                for (int i = 1; i <= consumables.size(); i++) {
                    consumable conso = consumables.get(i - 1);
                    if (conso instanceof food) {
                        num1 = num1 + 1;
                        foodvie = conso.vie;
                    }
                    if (conso instanceof potion) {
                        num2 = num2 + 1;
                        potionmana = conso.givemana;
                    }
                }
                conso.setText("Consomation: \npain: nombre " + num1 + " vie " + foodvie + "\npotion: nombre " + num2 + " mana " + potionmana);


                if (hero instanceof warior) {
                    amo.setText("");
                    //classe.setText("WARIOR");
                    Warriorimage.setOpacity(1.0);
                    Hunterimage.setOpacity(0.0);
                    Mageimage.setOpacity(0.0);
                    Healerimage.setOpacity(0.0);
                }
                if (hero instanceof hunter) {
                    amo.setText("Flèches: " + hero.arrow);
                    //classe.setText("HUNTER");
                    Warriorimage.setOpacity(0.0);
                    Hunterimage.setOpacity(1.0);
                    Mageimage.setOpacity(0.0);
                    Healerimage.setOpacity(0.0);
                }
                if (hero instanceof mage) {
                    amo.setText("Mana: " + hero.manapoints);
                    //classe.setText("MAGE");
                    Warriorimage.setOpacity(0.0);
                    Hunterimage.setOpacity(0.0);
                    Mageimage.setOpacity(1.0);
                    Healerimage.setOpacity(0.0);
                }
                if (hero instanceof healer) {
                    amo.setText("Mana: " + hero.manapoints);
                    //classe.setText("HEALER");
                    Warriorimage.setOpacity(0.0);
                    Hunterimage.setOpacity(0.0);
                    Mageimage.setOpacity(0.0);
                    Healerimage.setOpacity(1.0);
                }
            } else {

                ((Node)(event.getSource())).getScene().getWindow().hide();
                utilisation_conso();
                try{
                    Parent root =FXMLLoader.load(getClass().getResource("game-view.fxml"));
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
    @FXML
    protected void onconsoNumButtonClick(ActionEvent event){
        consumables.add(new food());
        consumables.add(new potion());
        numero-=1;
        if (numero > 0) {
            Hero hero = team.get(numero - 1);
            vie.setText("Vie: " + hero.lifepoints);
            armor.setText("Armor: " + hero.armor);
            attk.setText("Weapon damage: " + hero.weapondamage);
            int num1 = 0;
            int num2 = 0;
            int foodvie = 0;
            int potionmana = 0;
            for (int i = 1; i <= consumables.size(); i++) {
                consumable conso = consumables.get(i - 1);
                if (conso instanceof food) {
                    num1 = num1 + 1;
                    foodvie = conso.vie;
                }
                if (conso instanceof potion) {
                    num2 = num2 + 1;
                    potionmana = conso.givemana;
                }
            }
            conso.setText("Consomation: \npain: nombre " + num1 + " vie " + foodvie + "\npotion: nombre " + num2 + " mana " + potionmana);


            if (hero instanceof warior) {
                amo.setText("");
                //classe.setText("WARIOR");
                Warriorimage.setOpacity(1.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof hunter) {
                amo.setText("Flèches: " + hero.arrow);
                //classe.setText("HUNTER");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(1.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof mage) {
                amo.setText("Mana: " + hero.manapoints);
                //classe.setText("MAGE");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(1.0);
                Healerimage.setOpacity(0.0);
            }
            if (hero instanceof healer) {
                amo.setText("Mana: " + hero.manapoints);
                //classe.setText("HEALER");
                Warriorimage.setOpacity(0.0);
                Hunterimage.setOpacity(0.0);
                Mageimage.setOpacity(0.0);
                Healerimage.setOpacity(1.0);
            }
        } else {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            utilisation_conso();
            try{
                Parent root =FXMLLoader.load(getClass().getResource("game-view.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void utilisation_conso(){
        int fin=0;
        if(consumables.size()==0){
            fin=1;
        }
        while(fin==0) {
            System.out.println("Vous avez la possibilité d'utiliser vos consomable");
            System.out.println("Voici la liste des Heros et le nombre de consomable disponible:");
            int num1 = 0;
            int num2 = 0;
            int foodvie = 0;
            int potionmana = 0;
            for (int i = 1; i <= consumables.size(); i++) {
                consumable conso = consumables.get(i - 1);
                if (conso instanceof food) {
                    num1 = num1 + 1;
                    foodvie = conso.vie;
                }
                if (conso instanceof potion) {
                    num2 = num2 + 1;
                    potionmana = conso.givemana;
                }
            }
            System.out.println("Consomation: \npain: nombre " + num1 + " vie " + foodvie + "\npotion: nombre " + num2 + " mana " + potionmana);
            for (int i = 1; i <= team.size(); i++) {
                Hero hero = team.get(i - 1);
                if (hero instanceof warior) {
                    System.out.println("Warior:   (" + i + ")" + "\nVie: " + hero.lifepoints);
                }
                if (hero instanceof hunter) {
                    System.out.println("Hunter:   (" + i + ")" + "\nVie: " + hero.lifepoints);
                }
                if (hero instanceof mage) {
                    System.out.println("Mage:   (" + i + ")" + "\nVie: " + hero.lifepoints + "\nMana: " + hero.manapoints);
                }
                if (hero instanceof healer) {
                    System.out.println("Healer:   (" + i + ")" + "\nVie: " + hero.lifepoints + "\nMana: " + hero.manapoints);
                }
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Voulez vous utiliser vos consommables ?\nOUI (1)\nNON (2)");
            int utilisation = scanner.nextInt();
            if (utilisation == 2) {
                fin=1;
            } else {
                System.out.println("Veuillez entrer le chiffre correspondant au Hero");
                int numero = scanner.nextInt();
                System.out.println("Vie (1) ou mana (2)?");
                System.out.println("Veuillez entrer le chiffre correspondant au soin effectué");
                int numero1 = scanner.nextInt();
                Hero hero = team.get(numero - 1);
                if (hero instanceof spellcaster && numero1 == 2) {
                    int ok =0;
                    for (int i = 1; i <= consumables.size(); i++) {
                        consumable conso = consumables.get(i-1);
                        if(conso instanceof potion && ok==0){
                            hero.manapoints += conso.givemana;
                            consumables.remove(conso);
                            fin = 1;
                            ok = 1;
                        }
                    }
                }
                if (numero1 == 1) {
                    int okk =0;
                    for (int i = 1; i <= consumables.size(); i++) {
                        consumable conso = consumables.get(i-1);
                        if(conso instanceof  food && okk==0){
                            hero.lifepoints += conso.vie;
                            consumables.remove(conso);
                            fin = 1;
                            okk=1;
                        }
                    }
                }
            }
        }
    }
}
