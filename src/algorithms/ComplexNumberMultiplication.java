package algorithms;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String num1, String num2) {
        String[] strs1 = num1.split("\\+");
        String[] strs2 = num2.split("\\+");
        int real1 = Integer.parseInt(strs1[0]);
        int real2 = Integer.parseInt(strs2[0]);
        int img1 = Integer.parseInt(strs1[1].substring(0, strs1[1].length() - 1));
        int img2 = Integer.parseInt(strs2[1].substring(0, strs2[1].length() - 1));
        int real = real1 * real2 - img1 * img2;
        int img = real1 * img2 + real2 * img1;
        return String.valueOf(real) + "+" + String.valueOf(img) + "i";
    }

    public static void main(String[] args) {
        System.out.println(new ComplexNumberMultiplication()
                .complexNumberMultiply("1+1i", "1+1i"));
    }

}
