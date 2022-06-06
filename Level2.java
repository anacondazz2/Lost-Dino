import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bow is unlocked with a limited amount of arrows.
 * 
 * @ Patrick Hu 
 * @version (a version number or a date)
 */
public class Level2 extends GameWorld
{
    private int skelFireRate = 150;
    private int skelX = 680;
    private int shamanX = 550;
    
    public Level2()
    {
        super(800, 600, 1);
        resetArrowCount();
        // spawn player
        Player player = new Player(2);
        addObject(player, 100, getHeight() / 2);
        // spawn spear
        Spear s = new Spear();
        addObject(s, 100, getHeight() / 2);
        // create num arrow label
        initNumArrowLabel();
        // spawn two walls
        for (int i = 0, x = 190, y = 118; i < 3; i++) {
            Wall w = new Wall("vertical");
            addObject(w, x, y);
            y += w.getImage().getHeight();
        }
        for (int i = 0, x = 190, y = 486; i < 3; i++) {
            Wall w = new Wall("vertical");
            addObject(w, x, y);
            y -= w.getImage().getHeight();
        }
        // spawn skeletons
        Skeleton skel1 = new Skeleton("left", skelFireRate, true);
        addObject(skel1, skelX, 535);
        Skeleton skel2 = new Skeleton("left", skelFireRate, true);
        addObject(skel2, skelX, 60);
        Skeleton skel3 = new Skeleton("left", skelFireRate, true);
        addObject(skel3, skelX, 254);
        Skeleton skel4 = new Skeleton("left", skelFireRate, true);
        addObject(skel4, skelX, 338);
        // spawn shamans
        Shaman sha1 = new Shaman("vertical");
        addObject(sha1, shamanX, 225);
        Shaman sha2 = new Shaman("vertical");
        addObject(sha2, shamanX, 525);
        Shaman sha3 = new Shaman("vertical");
        addObject(sha3, shamanX - 100, 375);
        // spawn watermelon
        Watermelon melon = new Watermelon(2);
        addObject(melon, getWidth() - 50, getHeight() / 2);
    }
    
    public void act() {
        updateNumArrowLabel();
    }
    
    public void resetArrowCount() {
        Bow.numArrows = Bow.STARTING_NUM_ARROWS;
    }
    
    public void levelPass() {
        Greenfoot.setWorld(new Level2Pass());
    }
}