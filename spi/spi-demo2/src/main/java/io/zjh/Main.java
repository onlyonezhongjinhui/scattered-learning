package io.zjh;

import java.util.ServiceLoader;

/**
 * this is main.
 *
 * @author onlyonezhongjinhui
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<VideoUploader> videoUploaderList = ServiceLoader.load(VideoUploader.class);
        videoUploaderList.forEach(VideoUploader::upload);

        ServiceLoader<FileUploader> fileUploaderList = ServiceLoader.load(FileUploader.class);
        fileUploaderList.forEach(FileUploader::upload);

        ServiceLoader<ImageUploader> imageUploaderList = ServiceLoader.load(ImageUploader.class);
        imageUploaderList.forEach(ImageUploader::upload);
    }
}
