package inf112.skeleton.app.model.entities.cat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.model.entities.Projectile;
import inf112.skeleton.app.model.entities.rat.Rat;


public class BasicCat extends Cat {
    public BasicCat() {
        super(50, 
        100, 
        Arrays.asList(new Texture(Gdx.files.internal("cats/Spill_Kosekatt1.png")),new Texture(Gdx.files.internal("cats/Spill_Kosekatt2.png")),new Texture(Gdx.files.internal("cats/Spill_Kosekatt3.png"))), 
        Arrays.asList(new Texture(Gdx.files.internal("cats/Spill_Kosekatt1_angrip.png")),new Texture(Gdx.files.internal("cats/Spill_Kosekatt3_angrip.png")),new Texture(Gdx.files.internal("cats/Spill_Kosekatt3_angrip.png"))), 
        25.0f,
        200);
    }

    @Override
    public ArrayList<Projectile> attack(LinkedList<Rat> rats) {
        ArrayList<Projectile> projectileList = new ArrayList<>();
        if (canAttack()) {
            triggerAttackImage();
            //projectileList.add(shootAt(rats));
            rats.getFirst().takeDamage(getStrength());
            resetAttackTimer();
        }
        return projectileList;
    }

    @Override
    public Projectile shootAt(LinkedList<Rat> targets) {
        Vector2 direction = new Vector2(targets.getFirst().getPosition().x - getPosition().x, targets.getFirst().getPosition().y - getPosition().y);
        return new Projectile(new Vector2(this.getPosition()), direction, 300,  new Texture("claw.png"));
    }

    @Override
    public void upgradeDamage() {
       this.strength *= 1.25;
    }

    @Override
    public void upgradeRange() {
        this.range *= 1.25;
        this.circleUpdater();
    }

    @Override
    public void upgradeFireRate() {
        this.fireRate *= 0.75;
    }
}
