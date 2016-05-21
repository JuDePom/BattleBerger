package battleberger.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class RessourceManager implements Serializable{
	
	
	public static Map<String, BufferedImage> getImages() {
		return images;
	}

	public static void setImages(Map<String, BufferedImage> images) {
		RessourceManager.images = images;
	}

	public static String getImg_extension() {
		return img_extension;
	}

	public static void setImg_extension(String img_extension) {
		RessourceManager.img_extension = img_extension;
	}

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
