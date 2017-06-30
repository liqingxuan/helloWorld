public class Sample {

    public int[] weightedSample(double[] weights, int n) {
        int[] result = new int[n];
        double sumWeight = 0;
        double[] prob = new double[n + 1];
        for (int i = 0; i < n; i++) {
            sumWeight += weights[i];
        }
        for (int i = 1; i <= n; i++) {
            prob[i] = weights[i - 1] / sumWeight;
        }
        for (int i = 1; i <= n; i++) {
            prob[i] = prob[i - 1] + prob[i];
        }
        for (int i = 0; i < 1000; i++) {
            double sample = Math.random();
            for (int j = 0; j < n; j++) {
                if (prob[j] <= sample && sample < prob[j + 1]) {
                    result[j] = result[j] + 1;
                    break;
                    //return j;
                }
            }
        }
        return result;
    }
}