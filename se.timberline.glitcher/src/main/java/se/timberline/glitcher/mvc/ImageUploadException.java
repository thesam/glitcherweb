package se.timberline.glitcher.mvc;

import java.io.IOException;

public class ImageUploadException extends RuntimeException {

	public ImageUploadException(String string) {
		super(string);
	}

	public ImageUploadException(String string, IOException e) {
		super(string,e);
	}

}
