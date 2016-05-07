package battleberger.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class RessourceManager {
	private static Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();
	private static String img_extension = ".png";
	
	public static BufferedImage getImage(String path){
		path += img_extension;
		if ( images.containsKey(path) )
			return images.get(path);
		
		try {
			BufferedImage img = ImageIO.read(new File(path));
			images.put(path, img);
			return img;
		} catch (IOException e) {
		}
		
		return null;
	}
}
