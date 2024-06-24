import static java.lang.Math.abs;

public class Race {
    private final Long time;
    private final Long recordDistance;

    public Race(long time, long recordDistance){
        this.time = time;
        this.recordDistance = recordDistance;
    }


    public long getAllBetterPossibilities(){
        // recordDistance = (time - recordPushTime) * recordPushTime, we need to calculate recordPushTime
        // -recordPushTime^2 + time*recordPushTime - recordDistance = 0
        // better possibilities = abs(x1 - x2) - 2
        double[] roots = calculateQuadraticRoots(-1, (double)time, -(double)recordDistance);
        System.out.println("Roots: " + roots[0] + ", " + roots[1]);
        return abs( (long)Math.ceil(roots[0]) - (long)Math.floor(roots[1]) ) + 1 ;
    }

    public static double[] calculateQuadraticRoots(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            throw new IllegalArgumentException("Quadratic equation has no real roots");
        }

        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        return new double[] { root1, root2 };
    }

}
