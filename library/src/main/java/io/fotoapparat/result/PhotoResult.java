package io.fotoapparat.result;

import java.io.File;
import java.util.concurrent.Future;

import io.fotoapparat.photo.BitmapPhoto;
import io.fotoapparat.photo.Photo;
import io.fotoapparat.result.transformer.BitmapPhotoTransformer;

/**
 * Result of taking the photo.
 */
public class PhotoResult {

	private final PendingResult<Photo> pendingResult;

	public PhotoResult(PendingResult<Photo> pendingResult) {
		this.pendingResult = pendingResult;
	}

	public static PhotoResult fromFuture(Future<Photo> photoFuture) {
		return new PhotoResult(
				PendingResult.fromFuture(photoFuture)
		);
	}

	public PendingResult<BitmapPhoto> toBitmap() {
		return pendingResult
				.transform(new BitmapPhotoTransformer());
	}

	public PendingResult<?> saveToFile(File file) {
		return null;
	}

	public PendingResult<Photo> toPendingResult() {
		return pendingResult;
	}

}