public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        if(args.length>0){
            int summands = Integer.parseInt(args[0]);
            for (int i=0; i<summands; i++) {
                approxPi += (Math.pow(-1,i)*(1.0/(1+2*i)));
            }
            approxPi*=4;
        }
        System.out.println(approxPi + " " + actualPi);
    }
}
