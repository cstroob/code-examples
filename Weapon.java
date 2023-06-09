package carterstrubbe.topdowngames;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Weapon extends Craftables{

private Handler handler;
private int damage;
private boolean isFireable;
private BufferedImage[] wpn_image = new BufferedImage[12];
private BufferedImage[] att_image = new BufferedImage[4];
private BufferedImageLoader loader;
private Animation animUp;
private Animation animDown;
private Animation animLeft;
private Animation animRight;
private Animation animAttack;
private SpriteSheet ss;
private SpriteSheet ssR;
private SpriteSheet ssAtt;
protected Kid player;
private Rectangle bounds;

public Weapon(String title, int numberOfResources, int damage, boolean firable) {
super(title, numberOfResources);

this.setId(ID.Weapon);
this.setDamage(damage);
this.setIsFireable(firable);
handler = new Handler();
this.loader = new BufferedImageLoader();
this.ssR = new SpriteSheet(loader.loadImage("/DefaultCharacterSprites.png"));
this.ss = new SpriteSheet(loader.loadImage("/CraftablesSpriteSheet.png"));
this.ssAtt = new SpriteSheet(loader.loadImage("/DefaultCharacterSprites.png"));
this.bounds = new Rectangle();

} // Ending bracket of constructor

public int getDamage() {
return this.damage;
} // Ending bracket of method getDamage

public void setDamage(int newDamage) {
this.damage = newDamage;
} // Ending bracket of method setDamage

public boolean getIsFireable() {
return this.isFireable;
} // Ending bracket of method getIsFireable

public void setIsFireable(boolean status) {
this.isFireable = status;
} // Ending bracket of method setIsFireable

public void setHandler(Handler handler) {
this.handler = handler;
} // Ending bracket of method setHandler

public void setPlayer(Kid newPlayer) {
this.player = newPlayer;
} // Ending bracket of method setPlayer

public void tick() {
x += velX;
y += velY;

//movement
if(handler.isUp()) velY = -3;
else if(!handler.isDown()) velY = 0;

if(handler.isDown()) velY = 3;
else if(!handler.isUp()) velX = 0;

if(handler.isRight()) velX = 3;
else if(!handler.isLeft()) velX = 0;

if(handler.isLeft()) velX = -3;
else if(!handler.isRight()) velX = 0;

animDown.runAnimation();
animUp.runAnimation();
animLeft.runAnimation();
animRight.runAnimation();
animAttack.runAnimation();
} // Ending bracket of method tick

public void render(Graphics g) {

// 0 = down, 1 = up, 2 = left, 3 = right
this.setYBase(player.getYBase()+2);
if(player.getVelX() == 0 && player.getVelY() == 0 && !player.handlerAttack() && !player.getAttackAnimActive() && !player.getHarvestAnimActive()) {
if(player.handlerLastDirection() == 0) {
g.drawImage(wpn_image[0], player.getX(), player.getY(), null);
} else if(player.handlerLastDirection() == 1) {
g.drawImage(wpn_image[9], player.getX(), player.getY(), null);
} else if(player.handlerLastDirection() == 2) {
g.drawImage(wpn_image[3], player.getX(), player.getY(), null);
} else if(player.handlerLastDirection() == 3) {
g.drawImage(wpn_image[6], player.getX(), player.getY(), null);
} // Ending bracket of INNER if

} else
if(player.handlerIsDown() && !player.handlerIsLeft() && !player.handlerIsRight() && !player.handlerAttack()) {
animDown.drawAnimation(g, player.getX(), player.getY(), 0);

} // Ending bracket of if
if(player.handlerIsLeft() && !player.handlerAttack()) {
animLeft.drawAnimation(g, player.getX(), player.getY(), 0);

} // Ending bracket of if
if(player.handlerIsRight() && !player.handlerAttack()) {
animRight.drawAnimation(g, player.getX(), player.getY(), 0);

} // Ending bracket of if
if(player.handlerIsUp() && !player.handlerIsLeft() && !player.handlerIsRight() && !player.handlerAttack()) {
animUp.drawAnimation(g, player.getX(), player.getY(), 0);

} // Ending bracket of if
if(player.handlerAttack()) {
animAttack.drawAnimation(g, player.getX()-32, player.getY(), 0);
}

} // Ending bracket of method render

public SpriteSheet getSpriteSheet() {
return this.ss;
} // Ending bracket of method getSpriteSheet

public void setSpriteSheet(SpriteSheet newSS) {
this.ss = newSS;
} // Ending bracket of method setSpriteSheet

public SpriteSheet getSpriteSheetOverlay() {
return this.ssR;
} // Ending bracket of method getSpriteSheetOverlay

public void setSpriteSheetOverlay(SpriteSheet newSSR) {
this.ssR = newSSR;
} // Ending bracket of method setSpriteSheetOverlay

public SpriteSheet getAttackOverlay() {
return this.ssAtt;
} // Ending bracket of method getAttackOverlay

public void setAttackOverlay(SpriteSheet newSSAtt) {
this.ssAtt = newSSAtt;
} // Ending bracket of method setAttackOverlay

public void setAnimation(SpriteSheet ss, SpriteSheet ssAtt) {
wpn_image[0] = ss.grabImage(1, 1, 32, 32);
wpn_image[1] = ss.grabImage(1, 2, 32, 32);
wpn_image[2] = ss.grabImage(1, 3, 32, 32);
wpn_image[3] = ss.grabImage(2, 1, 32, 32);
wpn_image[4] = ss.grabImage(2, 2, 32, 32);
wpn_image[5] = ss.grabImage(2, 3, 32, 32);
wpn_image[6] = ss.grabImage(3, 1, 32, 32);
wpn_image[7] = ss.grabImage(3, 2, 32, 32);
wpn_image[8] = ss.grabImage(3, 3, 32, 32);
wpn_image[9] = ss.grabImage(4, 1, 32, 32);
wpn_image[10] = ss.grabImage(4, 2, 32, 32);
wpn_image[11] = ss.grabImage(4, 3, 32, 32);

att_image[0] = ssAtt.grabImage64x32(1, 2, 64, 32);
att_image[1] = ssAtt.grabImage64x32(2, 2, 64, 32);
att_image[2] = ssAtt.grabImage64x32(1, 3, 64, 32);
att_image[3] = ssAtt.grabImage64x32(2, 3, 64, 32);

animAttack = new Animation(3, att_image[2], att_image[3], att_image[2], att_image[1]);

animDown = new Animation(3, wpn_image[0], wpn_image[1], wpn_image[2]);
animUp = new Animation(3, wpn_image[9], wpn_image[10], wpn_image[11]);
animLeft = new Animation(3, wpn_image[3], wpn_image[4], wpn_image[5]);
animRight = new Animation(3, wpn_image[6], wpn_image[7], wpn_image[8]);
} // Ending bracket of method setAnimation

public Rectangle getBounds() {
return this.bounds;
} // Ending bracket of method getBounds

public void setBounds(int width, int height) {
bounds.setBounds(x, y, width, height);
} // Ending bracket of method setBounds

} // Ending bracket of class Weapons
