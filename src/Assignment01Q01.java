public class Assignment01Q01 {
    public static void main(String[] args) {
        for(String st: args) {
            if (!st.isEmpty()){
                char ch = st.charAt(0);
                if ((int) ch % 5 == 0) {
                    System.out.println(ch);
                }
            }
        }
    }
}
