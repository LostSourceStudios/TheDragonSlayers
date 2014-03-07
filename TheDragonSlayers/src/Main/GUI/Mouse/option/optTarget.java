package Main.GUI.Mouse.option;

import java.awt.Image;

import Main.Game;
import Main.GUI.Target.targetThing;

public class optTarget extends options {

	public optTarget(Image icon) {
		super(icon);
	}

	public void ifSelected() {

		for (int i = 0; i < Game.level.mobs.size(); i++) {
			if (Game.level.mobs.get(i).box.r.intersects(FastOption.x, FastOption.y, 1, 1)) {
				if (!(Game.level.mobs.get(i).type=="player"))targetThing.targeted = Game.level.mobs.get(i);
				break;
			} else {
				targetThing.targeted = null;
			}
			
		}

	}

	public void update() {

	}

}
