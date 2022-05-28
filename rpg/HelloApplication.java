package com.example.rpg;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.paint.Color;

import java.util.concurrent.atomic.AtomicInteger;

import javafx.scene.Group;
import javafx.scene.transform.Rotate;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Image background = new Image("file:assets/capture.jpg");
        Image healer = new Image("file:assets/healer.png");
        Image heartrender = new Image("file:assets/heartrender.png");
        Image inferni = new Image("file:assets/inferni.png");
        Image squaller = new Image("file:assets/squaller.png");
        Image darklinge = new Image("file:assets/darklinge.png");
        Image volcra = new Image("file:assets/volcra.jpg");
        Image heartrenderCrest = new Image("file:assets/heartrenderCrest.jpg");
        Image squallerCrest = new Image("file:assets/squallerCrest.jpg");
        Image inferniCrest = new Image("file:assets/inferniCrest.jpg");
        Image healerCrest = new Image("file:assets/healerCrest.jpg");
        Image heart = new Image("file:assets/heart.png");

        ImageView bg =new ImageView(background);

        /*ImageView ivVolcra=new ImageView(darklinge);
        ivVolcra.setX(100);
        ivVolcra.setY(130);
        ivVolcra.setFitHeight(400);
        ivVolcra.setPreserveRatio(true);
        ImageView ivInferni =new ImageView(inferni);
        ivInferni.setX(800);
        ivInferni.setY(130);
        ivInferni.setFitHeight(400);
        ivInferni.setPreserveRatio(true);*/


        Label titre= new Label("Choose your order");
        titre.setFont(new Font("castellar",80));
        titre.setTextFill(Color.web("#FFF"));
        titre.setLayoutX(150);
        titre.setLayoutY(150);
        // Create all the buttons
        //create button yellow
        ImageView viewHealer = new ImageView(healerCrest);
        Button button1 = new Button("",viewHealer);

        button1.setLayoutX(350);
        button1.setLayoutY(300);
        viewHealer.setFitWidth(100);
        viewHealer.setPreserveRatio(true);
        //create button red
        ImageView viewrouge = new ImageView(heartrenderCrest);
        Button button2 = new Button("",viewrouge);

        button2.setLayoutX(500);
        button2.setLayoutY(300);
        viewrouge.setFitWidth(100);
        viewrouge.setPreserveRatio(true);
        //create button green
        ImageView viewvert = new ImageView(squallerCrest);
        Button button3 = new Button("",viewvert);

        button3.setLayoutX(650);
        button3.setLayoutY(300);
        viewvert.setFitWidth(100);
        viewvert.setPreserveRatio(true);
        //create button blue
        ImageView viewbleu = new ImageView(inferniCrest);
        Button button4 = new Button("",viewbleu);

        button4.setLayoutX(800);
        button4.setLayoutY(300);
        viewbleu.setFitWidth(100);
        viewbleu.setPreserveRatio(true);

        root.getChildren().addAll(bg,button1,button2,button3,button4, titre);
        Scene scene = new Scene(root, 1250, 650);
        ArrayList liste=new ArrayList<>();
        ArrayList<Hero> listeHunter=new ArrayList<>();
        ArrayList<Hero> listeWarrior=new ArrayList<>();
        ArrayList<ImageView> listeHeartEnemy=new ArrayList<>();
        ArrayList<ImageView> listeHeartHero=new ArrayList<>();

        ArrayList<Enemy> listeVillain=new ArrayList<>();
        button1.setOnAction(event -> {
            hide(titre, button1,button2,button3,button4);
            callVillain(listeVillain, volcra, root, heart,listeHeartEnemy);
            Mage mage= new Mage(5,5,4);
            callHero(listeHunter,heartrender,root,heart,listeHeartHero,mage);


            Enemy enemy= listeVillain.get(0);

            punch(root,mage, enemy, heart,listeHeartEnemy,listeHeartHero, listeVillain,volcra);

        });
        button2.setOnAction(event -> {
            hide(titre, button1,button2,button3,button4);
            callVillain(listeVillain, volcra, root, heart,listeHeartEnemy);
            healer heal= new healer(5,2,3);
            callHero(listeHunter,healer,root,heart,listeHeartHero,heal);


            Enemy enemy= listeVillain.get(0);

            punch(root,heal, enemy, heart,listeHeartEnemy,listeHeartHero, listeVillain,volcra);

        });
        button4.setOnAction(event ->{
            hide(titre, button1,button2,button3,button4);
            callVillain(listeVillain, volcra, root, heart,listeHeartEnemy);
            Hunter hunter =new Hunter(5,4,7,4,3);
            callHero(listeHunter,inferni,root,heart,listeHeartHero,hunter);


            Enemy enemy= listeVillain.get(0);

            punch(root,hunter, enemy, heart,listeHeartEnemy,listeHeartHero, listeVillain,volcra);

        });

        button3.setOnAction(event ->{
            hide(titre, button1,button2,button3,button4);
            callVillain(listeVillain, volcra, root, heart,listeHeartEnemy);
            Warrior warrior=new Warrior(2,3,3);
            callHero(listeWarrior,squaller,root,heart,listeHeartHero, warrior);


            Enemy enemy= listeVillain.get(0);

            punch(root,warrior, enemy, heart,listeHeartEnemy,listeHeartHero, listeVillain,volcra);

        });




        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
    public static void hide(Label titre, Button b1, Button b2, Button b3, Button b4){
        titre.setOpacity(0);
        b1.setOpacity(0);
        b2.setOpacity(0);
        b3.setOpacity(0);
        b4.setOpacity(0);



    }
    public static void callVillain(ArrayList<Enemy> listeEnemy, Image volcra, Group root, Image image, ArrayList<ImageView> listeHeartEnemy){
        int Minimum=1;
        int Maximum=6;
        int chiffre1 = Minimum + (int)(Math.random() * ((Maximum - Minimum) + 1));
        listeEnemy.clear();

        BasicEnemy enemy=new BasicEnemy(chiffre1,3);
        listeEnemy.add(enemy);
        ImageView ivVolcra= new ImageView(volcra);
        ivVolcra.setX(100);
        ivVolcra.setY(130);
        ivVolcra.setFitHeight(400);
        ivVolcra.setPreserveRatio(true);
        showHearts(chiffre1,root,image,55, listeHeartEnemy);





        root.getChildren().addAll(ivVolcra);


    }
    public static void callHero(ArrayList<Hero> listeHero, Image squaller, Group root, Image image,ArrayList<ImageView> listeHeartHero,Hero hero){

        int life=hero.getLifePoints();
        listeHero.add(hero);
        ImageView ivSqualler= new ImageView(squaller);
        ivSqualler.setX(800);
        ivSqualler.setY(130);
        ivSqualler.setFitHeight(400);
        ivSqualler.setPreserveRatio(true);
        showHearts(life,root,image,800,listeHeartHero);





        root.getChildren().addAll(ivSqualler);


    }
    public static void showHearts(int number, Group root, Image heart, int chiffre, ArrayList<ImageView> listeHeart){
        int a=listeHeart.size();
        for (int i=0; i < (a); i++){
            ImageView iv=listeHeart.get(i);
            iv.setOpacity(0);


        }
        listeHeart.clear();
        for (int i=1; i <= (number); i++){
            ImageView iv=new ImageView(heart);
            iv.setFitHeight(35);
            iv.setX(chiffre+45*i);
            iv.setY(540);
            iv.setPreserveRatio(true);
            root.getChildren().add(iv);
            listeHeart.add(iv);

        }
    }
    public static void punch( Group root,Hero hero,Enemy enemy, Image heart,ArrayList<ImageView> listeHeartEnemy,ArrayList<ImageView>listeHeartHero, ArrayList<Enemy> listeEnemy, Image volcra){

        int power= hero.getPower();

        int life= enemy.getLifepoints();
        System.out.println("power:"+power);
        System.out.println("life"+life);
        Button button= new Button("punch");
        button.setLayoutX(750);
        button.setLayoutY(250);
        root.getChildren().add(button);
        button.setOnAction(event ->{
            int chiffre3=life-power;
            enemy.lifepoints=chiffre3;
            System.out.println(chiffre3);
            if (chiffre3<0){
                showHearts(0, root, heart,55,listeHeartEnemy);
                Button button2= new Button("next villain");
                button2.setLayoutX(70);
                button2.setLayoutY(570);
                root.getChildren().add(button2);
                button2.setOnAction(event2 ->{
                    callVillain(listeEnemy,volcra,root,heart,listeHeartEnemy);
                    punch(root, hero, enemy, heart, listeHeartEnemy, listeHeartHero, listeEnemy, volcra);
                });

            }else {
                showHearts(chiffre3, root, heart,55,listeHeartEnemy);
                attackEnemy(root,hero,enemy,heart,listeHeartHero,listeHeartEnemy,listeEnemy,volcra);
            }

        });

    }
    public static void attackEnemy( Group root,Hero hero,Enemy enemy, Image heart,ArrayList<ImageView> listeHeartHero,ArrayList<ImageView> listeHeartEnemy, ArrayList<Enemy> listeEnemy, Image volcra){

        int power= enemy.getPower();

        int life= hero.getLifePoints();
        System.out.println(power);
        System.out.println(life);
        Button button= new Button("next");
        button.setLayoutX(1100);
        button.setLayoutY(500);
        root.getChildren().add(button);
        button.setOnAction(event ->{
            int chiffre3=life-power;
            Hero.lifePoints=chiffre3;
            System.out.println(chiffre3);
            if (chiffre3<0){
                showHearts(0, root, heart,800,listeHeartHero);
                System.out.println("you died");
            }else {
                showHearts(chiffre3, root, heart,800,listeHeartHero);
                punch(root,hero,enemy,heart,listeHeartEnemy,listeHeartHero,listeEnemy,volcra);
            }

        });}
    public static void attack( Group root){


        Button button= new Button("throw");
        button.setLayoutX(750);
        button.setLayoutY(350);
        root.getChildren().add(button);


    }


}