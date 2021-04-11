package io.zjh;

import java.util.ServiceLoader;

/**
 * this is main.
 *
 * @author onlyonezhongjinhui
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<Uploader> uploaders = ServiceLoader.load(Uploader.class);
        uploaders.forEach(Uploader::upload);
    }
}
