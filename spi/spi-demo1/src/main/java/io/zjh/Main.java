package io.zjh;

import java.util.ServiceLoader;

/**
 * this is main.
 *
 * @author onlyonezhongjinhui
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<FileUploader> fileUploader = ServiceLoader.load(FileUploader.class);
        fileUploader.forEach(FileUploader::upload);

        ServiceLoader<VideoUploader> videoUploader = ServiceLoader.load(VideoUploader.class);
        videoUploader.forEach(VideoUploader::upload);
    }
}
