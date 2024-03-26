package gui.GUI4;

import java.util.Arrays;

public class Testing {

    private static <T, R> void transform(T[] in, R[] out, Transform<T, R> trans) {
        for (int i = 0; i < in.length; i++) {
            R modified = trans.apply(in[i]);
            out[i] = modified;
        }
    }

    public static void main(String[] args) {

        StrToInt strToInt = new StrToInt();

        String[] sin = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(sin) + '\n');

        Integer[] iout = new Integer[sin.length];
        transform(sin, iout, (val -> val.length()));

        System.out.println(Arrays.toString(iout) + '\n');

        Character[] cout = new Character[sin.length];
        transform(sin, cout, (val -> val.charAt(0)));

        System.out.println(Arrays.toString(cout) + '\n');


        String[] sout = new String[sin.length];
        transform(sin, sout, (val -> val.toUpperCase()));
        System.out.println(Arrays.toString(sout) + '\n');

    }

}
