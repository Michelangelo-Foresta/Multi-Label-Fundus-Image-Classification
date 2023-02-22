package packages;

import deepnetts.net.ConvolutionalNetwork;
import javax.imageio.ImageIO;
import javax.visrec.ml.classification.ImageClassifier;
import javax.visrec.ri.ml.classification.ImageClassifierNetwork;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TrainedModel {
    public static Map<String, Float> getDiagnosis(BufferedImage Image) {

        BufferedImage image = null;
        ImageClassifier<BufferedImage> imageClassifier = null;
        try {
            image = ImageIO.read(new File("C:\\Users\\15145\\Desktop\\Normal\\99_right.jpg"));
            image = ResizeImage.resizeImage(image, 128, 128);
            ConvolutionalNetwork trainedNet = null;
            trainedNet = ConvolutionalNetwork.load("src\\packages\\model\\deepNetwork1.dnet", ConvolutionalNetwork.class);
            imageClassifier = new ImageClassifierNetwork(trainedNet);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return imageClassifier.classify(image);
    }
}
