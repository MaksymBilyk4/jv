package gui.GUI4;

public class StrToInt implements Transform<String, Integer>{
    @Override
    public Integer apply(String val) {
        return val.length();
    }



}
