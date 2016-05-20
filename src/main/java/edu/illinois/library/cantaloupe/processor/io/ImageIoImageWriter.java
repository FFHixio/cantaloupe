package edu.illinois.library.cantaloupe.processor.io;

import edu.illinois.library.cantaloupe.image.Format;
import edu.illinois.library.cantaloupe.image.OperationList;

import javax.media.jai.PlanarImage;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Image writer using ImageIO, capable of writing both Java 2D
 * {@link BufferedImage}s and JAI {@link PlanarImage}s in several formats.
 */
public class ImageIoImageWriter {

    private OperationList opList;

    /**
     * @return Set of supported output formats.
     */
    public static Set<Format> supportedFormats() {
        return new HashSet<>(Arrays.asList(Format.GIF, Format.JPG,
                Format.PNG, Format.TIF));
    }

    public ImageIoImageWriter(OperationList opList) {
        this.opList = opList;
    }

    /**
     * Writes a Java 2D {@link BufferedImage} to the given output stream.
     *
     * @param image Image to write
     * @param outputFormat Format of the output image
     * @param outputStream Stream to write the image to
     * @throws IOException
     */
    public void write(final BufferedImage image,
                      final Format outputFormat,
                      final OutputStream outputStream) throws IOException {
        switch (outputFormat) {
            case GIF:
                new ImageIoGifImageWriter(opList).write(image, outputStream);
                break;
            case JPG:
                new ImageIoJpegImageWriter(opList).write(image, outputStream);
                break;
            case PNG:
                new ImageIoPngImageWriter(opList).write(image, outputStream);
                break;
            case TIF:
                new ImageIoTiffImageWriter(opList).write(image, outputStream);
                break;
        }
    }

    /**
     * Writes a JAI {@link PlanarImage} to the given output stream.
     *
     * @param image Image to write
     * @param outputFormat Format of the output image
     * @param outputStream Stream to write the image to
     * @throws IOException
     */
    public void write(final PlanarImage image,
                      final Format outputFormat,
                      final OutputStream outputStream) throws IOException {
        switch (outputFormat) {
            case GIF:
                new ImageIoGifImageWriter(opList).write(image, outputStream);
                break;
            case JPG:
                new ImageIoJpegImageWriter(opList).write(image, outputStream);
                break;
            case PNG:
                new ImageIoPngImageWriter(opList).write(image, outputStream);
                break;
            case TIF:
                new ImageIoTiffImageWriter(opList).write(image, outputStream);
                break;
        }
    }

}
