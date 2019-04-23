package com.example.autism.sakil.autism;

import java.util.List;

public class Logistic {

    private double rate;
    private double[] weights;
    private int ITERATIONS = 3000;

    public Logistic(int n) {
        this.rate = 0.0001;
        weights = new double[n];
    }

    private static double sigmoid(double z) {
        return 1.0 / (1.0 + Math.exp(-z));
    }

    public void train(List<DatasetInstance> instances) {
        for (int n=0; n<ITERATIONS; n++) {
            for (int i=0; i<instances.size(); i++) {
                int[] x = instances.get(i).x;
                double predicted = classify(x);
                int label = instances.get(i).label;
                for (int j=0; j<weights.length; j++) {
                    weights[j] = weights[j] + rate * (label - predicted) * x[j];
                }

            }

        }
    }

    public double classify(int[] x) {
        double logit = .0;
        for (int i=0; i<weights.length;i++)  {
            logit += weights[i] * x[i];
        }
        return sigmoid(logit);
    }
}
