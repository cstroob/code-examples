package carterstrubbe.topdowngames;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Craftables extends GameObject{

private String title;
private int numberOfResourceTypes;
private BufferedImage ss;
private SpriteSheet sprite_sheet;
private boolean isObstructingPlayer;

// LinkedList indexes correlate for following two arrays
// Ex. requiredResources.get(0) = Wood; resourceAmount.get(0) = 5; Requires 5 wood.
private LinkedList<HarvestableResources> requiredResources;
private LinkedList<Integer> resourceAmount;

public Craftables(String title, int numberOfResources) {
super(0, 0, ID.Craftable, null);
this.setTitle(title);
this.setName(title);
this.setNumberOfResourceTypes(numberOfResources);
this.requiredResources = new LinkedList<HarvestableResources>();
this.resourceAmount = new LinkedList<Integer>();
BufferedImageLoader loader = new BufferedImageLoader();
ss = loader.loadImage("/CraftablesSpriteSheet.png");
sprite_sheet = new SpriteSheet(this.ss);
} // Ending bracket of constructor

public String getTitle() {
return this.title;
} // Ending bracket of method getTitle

public void setTitle(String newTitle) {
this.title = newTitle;
} // Ending bracket of method setTitle

public void setSpriteSheet(SpriteSheet newSS) {
this.sprite_sheet = newSS;
} // Ending bracket of method setSpriteSheet

public SpriteSheet getSpriteSheet() {
return this.sprite_sheet;
} // Ending bracket of method getSpriteSheet

public int numberOfResourceTypes() {
return this.numberOfResourceTypes;
} // Ending bracket of method numberOfResourceTypes

public void setNumberOfResourceTypes(int newAmount) {
this.numberOfResourceTypes = newAmount;
} // Ending bracket of method setNumberOfResourceTypes

public HarvestableResources getRequiredResource(int index) {
return this.requiredResources.get(index);
} // Ending bracket of method getRequiredResource

public int getResourceAmount(int index) {
return this.resourceAmount.get(index);
} // Ending bracket of method getResourceAmount

public void addRequiredResource(HarvestableResources resource, int amount) {
this.requiredResources.add(resource);
this.resourceAmount.add(amount);
} // Ending bracket of method setRequiredResource

public boolean compareToInventory(SubWindow[] inventory) {
boolean rv = false;
for(int i = 0; i < this.requiredResources.size(); ++i) {
for(int j = 0; j < inventory.length - 1; ++j) {
if(this.requiredResources.get(i).getName() == inventory[j].getMenuTitle()) {
if(this.resourceAmount.get(i) <= inventory[j].getCount()) {
System.out.println("Has");
rv = true;
break;
} // Ending bracket of if - Checks that amount of resource is enough
} else {
rv = false;
} // Ending bracket of if
} // Ending bracket of inner for loop
if(rv == false) {
break;
} // Ending bracket of if - Breaks if an item is not found at all in inventory
} // Ending bracket of outer for loop
return rv;
} // Ending bracket of method compareToInventory

public void removeFromInventory(SubWindow[] inventory) {
for(int i = 0; i < this.requiredResources.size(); ++i) {
System.out.println(this.requiredResources.get(i).getName());
for(int j = inventory.length-1; j >= 0; --j) {
if(this.requiredResources.get(i).getName() == inventory[j].getMenuTitle()) {
inventory[j].setCount(inventory[j].getCount() - this.resourceAmount.get(i));
break;
} // Ending bracket of if
} // Ending bracket of INNER for loop
} // Ending bracket of OUTER for loop
} // Ending bracket of method removeFromInventory

public boolean getObstruction() {
return this.isObstructingPlayer;
} // Ending bracket of method getObstruction

public void setObstruction(boolean status) {
this.isObstructingPlayer = status;
} // Ending bracket of method setObstruction

@Override
public void tick() {
// TODO Auto-generated method stub

}

@Override
public void render(Graphics g) {
// TODO Auto-generated method stub

}

@Override
public Rectangle getBounds() {
// TODO Auto-generated method stub
return null;
}

@Override
public Rectangle getHarvestBounds() {
// TODO Auto-generated method stub
return null;
}

} // Ending bracket of class Craftables
