package tabletlmn;
public class NewClass
{
    private String string = "";
    public NewClass resetHidden()
    {
        return this.resetHidden("");
    }
    public NewClass resetHidden(String value)
    {
        this.ansi(Integer.toString(28));
        this.raw(value);
        return this;
    }
    public NewClass resetInvertColors()
    {
        return this.resetInvertColors("");
    }
    public NewClass resetInvertColors(String value)
    {
        this.ansi(Integer.toString(27));
        this.raw(value);
        return this;
    }
    public NewClass reset()
    {
        return this.reset("");
    }
    public NewClass reset(String value)
    {
        this.ansi(Integer.toString(0));
        this.raw(value);
        return this;
    }
    public NewClass color16(Color16 color, String value)
    {
        this.ansi(Integer.toString(color.getValue()));
        this.raw(value);

        return this;
    }
    public NewClass raw(String value)
    {
        this.string += value;
        return this;
    }
    public NewClass ansi(String value)
    {
        this.string += "\u001b[" + value + "m";
        return this;
    }
    @Override
    public String toString()
    {
        this.reset();
        return this.string;
    }
    public enum Color16
    {
        FG_RESET(39),
        FG_BLACK(30),
        FG_RED(31),
        FG_GREEN(32),
        FG_YELLOW(33),
        FG_BLUE(34),
        FG_MAGENTA(35),
        FG_CYAN(36),
        FG_LIGHT_GRAY(37),
        FG_DARK_GRAY(90),
        FG_LIGHT_RED(91),
        FG_LIGHT_GREEN(92),
        FG_LIGHT_YELLOW(93),
        FG_LIGHT_BLUE(94),
        FG_LIGHT_MAGENTA(95),
        FG_LIGHT_CYAN(96),
        FG_WHITE(97),
        BG_RESET(49),
        BG_BLACK(40),
        BG_RED(41),
        BG_GREEN(42),
        BG_YELLOW(43),
        BG_BLUE(44),
        BG_MAGENTA(45),
        BG_CYAN(46),
        BG_LIGHT_GRAY(47),
        BG_DARK_GRAY(100),
        BG_LIGHT_RED(101),
        BG_LIGHT_GREEN(102),
        BG_LIGHT_YELLOW(103),
        BG_LIGHT_BLUE(104),
        BG_LIGHT_MAGENTA(105),
        BG_LIGHT_CYAN(106),
        BG_WHITE(107);
        private int value;
        public int getValue()
        {
            return value;
        }

        Color16(int value)
        {
            this.value = value;
        }
    }
    public static void main(String[] args) {
       NewClass nclClass= new NewClass();
       NewClass sb = new NewClass();

System.out.println(
    sb.raw("Hello, ")
      .color16(NewClass.Color16.FG_RED, "red")
);
    }
}


