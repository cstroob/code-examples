package carterstrubbe.topdowngames;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class StoneAxe extends Weapon {


private Rock rock;
private PalmTree wood;
private BufferedImageLoader loader;
private BufferedImage thumbnail;
private SpriteSheet ss;

public StoneAxe() {
super("StoneAxe", 2, 2, false);
this.rock = new Rock();
this.wood = new PalmTree();
this.addRequiredResource(rock, 2);
this.addRequiredResource(wood, 2);
this.thumbnail = this.getSpriteSheet().grabImage(1, 1, 32, 32);
this.setFunction("Weapon");
this.loader = new BufferedImageLoader();
this.ss = new SpriteSheet(loader.loadImage("/StoneAxeCharacterOverlay.png"));
this.setSpriteSheetOverlay(ss);
this.setAnimation(ss, ss);
} // Ending bracket of constructor

public BufferedImage getThumbnail() {
return this.thumbnail;
} // Ending bracket of method getThumbnail

public SpriteSheet getSpriteSheetOverlay() {
return this.ss;
} // Ending bracket of method getSpriteSheet



} // Ending bracket of class StoneAxe
