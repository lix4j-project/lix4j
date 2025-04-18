package com.github.inc0grepoz.lix4j.util;

import java.util.concurrent.ThreadLocalRandom;

public enum AnsiColor
{

    // Reset
    RESET("\033[0m"),

    // Regular
    BLACK("\033[0;30m"),
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    PURPLE("\033[0;35m"),
    CYAN("\033[0;36m"),
    WHITE("\033[0;37m"),

    // Bold
    BLACK_BOLD("\033[1;30m"),
    RED_BOLD("\033[1;31m"),
    GREEN_BOLD("\033[1;32m"),
    YELLOW_BOLD("\033[1;33m"),
    BLUE_BOLD("\033[1;34m"),
    PURPLE_BOLD("\033[1;35m"),
    CYAN_BOLD("\033[1;36m"),
    WHITE_BOLD("\033[1;37m"),

    // Underline
    BLACK_UNDERLINED("\033[4;30m"),
    RED_UNDERLINED("\033[4;31m"),
    GREEN_UNDERLINED("\033[4;32m"),
    YELLOW_UNDERLINED("\033[4;33m"),
    BLUE_UNDERLINED("\033[4;34m"),
    PURPLE_UNDERLINED("\033[4;35m"),
    CYAN_UNDERLINED("\033[4;36m"),
    WHITE_UNDERLINED("\033[4;37m"),

    // Background
    BLACK_BACKGROUND("\033[40m"),
    RED_BACKGROUND("\033[41m"),
    GREEN_BACKGROUND("\033[42m"),
    YELLOW_BACKGROUND("\033[43m"),
    BLUE_BACKGROUND("\033[44m"),
    PURPLE_BACKGROUND("\033[45m"),
    CYAN_BACKGROUND("\033[46m"),
    WHITE_BACKGROUND("\033[47m"),

    // High Intensity
    BLACK_BRIGHT("\033[0;90m"),
    RED_BRIGHT("\033[0;91m"),
    GREEN_BRIGHT("\033[0;92m"),
    YELLOW_BRIGHT("\033[0;93m"),
    BLUE_BRIGHT("\033[0;94m"),
    PURPLE_BRIGHT("\033[0;95m"),
    CYAN_BRIGHT("\033[0;96m"),
    WHITE_BRIGHT("\033[0;97m"),

    // Bold High Intensity
    BLACK_BOLD_BRIGHT("\033[1;90m"),
    RED_BOLD_BRIGHT("\033[1;91m"),
    GREEN_BOLD_BRIGHT("\033[1;92m"),
    YELLOW_BOLD_BRIGHT("\033[1;93m"),
    BLUE_BOLD_BRIGHT("\033[1;94m"),
    PURPLE_BOLD_BRIGHT("\033[1;95m"),
    CYAN_BOLD_BRIGHT("\033[1;96m"),
    WHITE_BOLD_BRIGHT("\033[1;97m"),

    // High Intensity backgrounds
    BLACK_BACKGROUND_BRIGHT("\033[0;100m"),
    RED_BACKGROUND_BRIGHT("\033[0;101m"),
    GREEN_BACKGROUND_BRIGHT("\033[0;102m"),
    YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),
    BLUE_BACKGROUND_BRIGHT("\033[0;104m"),
    PURPLE_BACKGROUND_BRIGHT("\033[0;105m"),
    CYAN_BACKGROUND_BRIGHT("\033[0;106m"),
    WHITE_BACKGROUND_BRIGHT("\033[0;107m");

    public static AnsiColor randomDarkBright()
    {
        switch (ThreadLocalRandom.current().nextInt(12))
        {
        case 0:
            return RED;
        case 1:
            return YELLOW;
        case 2:
            return GREEN;
        case 3:
            return CYAN;
        case 4:
            return BLUE;
        case 5:
            return PURPLE;
        case 6:
            return RED_BRIGHT;
        case 7:
            return YELLOW_BRIGHT;
        case 8:
            return GREEN_BRIGHT;
        case 9:
            return CYAN_BRIGHT;
        case 10:
            return BLUE_BRIGHT;
        case 11:
            return PURPLE_BRIGHT;
        default:
            return null;
        }
    }

    public static AnsiColor randomDark()
    {
        switch (ThreadLocalRandom.current().nextInt(6))
        {
        case 0:
            return RED;
        case 1:
            return YELLOW;
        case 2:
            return GREEN;
        case 3:
            return CYAN;
        case 4:
            return BLUE;
        case 5:
            return PURPLE;
        default:
            return null;
        }
    }

    public static AnsiColor randomBright()
    {
        switch (ThreadLocalRandom.current().nextInt(6))
        {
        case 0:
            return RED_BRIGHT;
        case 1:
            return YELLOW_BRIGHT;
        case 2:
            return GREEN_BRIGHT;
        case 3:
            return CYAN_BRIGHT;
        case 4:
            return BLUE_BRIGHT;
        case 5:
            return PURPLE_BRIGHT;
        default:
            return null;
        }
    }

    public static AnsiColor randomBoldDark()
    {
        switch (ThreadLocalRandom.current().nextInt(6))
        {
        case 0:
            return RED_BOLD;
        case 1:
            return YELLOW_BOLD;
        case 2:
            return GREEN_BOLD;
        case 3:
            return CYAN_BOLD;
        case 4:
            return BLUE_BOLD;
        case 5:
            return PURPLE_BOLD;
        default:
            return null;
        }
    }

    public static AnsiColor randomBoldBright()
    {
        switch (ThreadLocalRandom.current().nextInt(6))
        {
        case 0:
            return RED_BOLD_BRIGHT;
        case 1:
            return YELLOW_BOLD_BRIGHT;
        case 2:
            return GREEN_BOLD_BRIGHT;
        case 3:
            return CYAN_BOLD_BRIGHT;
        case 4:
            return BLUE_BOLD_BRIGHT;
        case 5:
            return PURPLE_BOLD_BRIGHT;
        default:
            return null;
        }
    }

    private final String string;

    AnsiColor(String string)
    {
        this.string = string;
    }

    @Override
    public String toString()
    {
        return string;
    }

}
