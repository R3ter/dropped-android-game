package com.mygdx.DroppedGrinning.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new com.mygdx.DroppedGrinning.MyGdxGame(null), config);
        config.width=600;
        config.height=800;


	}
}
