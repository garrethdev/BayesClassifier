package com.example.runnableexample;
import static com.example.runnableexample.textConstant.*;
/**
 * Created by dottig2-adm on 5/12/2016.
 */

import java.util.Arrays;

    import com.example.runnableexample.Classification;

public class RunnableExample {

    public static void main(String[] args) {

        /*
         * Create a new classifier instance. The context features are
         * Strings and the context will be classified with a String according
         * to the featureset of the context.
         */
        final Classifier<String, String> bayes =
                new BayesClassifier<String, String>();

        /*
         * The classifier can learn from classifications that are handed over
         * to the learn methods. Imagin a tokenized text as follows. The tokens
         * are the text's features. The category of the text will either be
         * positive or negative.
         */
        final String[] mscText = trainingDataSet.split("\\s");
        bayes.learn("msc", Arrays.asList(mscText));

        final String[] nonMscText = trainingSetNonMsc.split("\\s");
        bayes.learn("nommsc", Arrays.asList(nonMscText));

        /*
         * Now that the classifier has "learned" two classifications, it will
         * be able to classify similar sentences. The classify method returns
         * a Classification Object, that contains the given featureset,
         * classification probability and resulting category.
         */
        final String[] scnText1 = scntSample.split("\\s");
        final String[] mscText2 = mscSample.split("\\s");

 //       System.out.println( // will output "positive"
//                bayes.classify(Arrays.asList(scnText1)).getCategory());
        System.out.println( // will output "negative"
                bayes.classify(Arrays.asList(mscText2)));

        /*
         * The BayesClassifier extends the abstract Classifier and provides
         * detailed classification results that can be retrieved by calling
         * the classifyDetailed Method.
         *
         * The classification with the highest probability is the resulting
         * classification. The returned List will look like this.
         * [
         *   Classification [
         *     category=negative,
         *     probability=0.0078125,
         *     featureset=[today, is, a, sunny, day]
         *   ],
         *   Classification [
         *     category=positive,
         *     probability=0.0234375,
         *     featureset=[today, is, a, sunny, day]
         *   ]
         * ]
         */
        // How does this function work?
        ((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(scnText1));

        /*
         * Please note, that this particular classifier implementation will
         * "forget" learned classifications after a few learning sessions. The
         * number of learning sessions it will record can be set as follows:
//         */
        bayes.setMemoryCapacity(500); // remember the last 500 learned classifications
    }

}
