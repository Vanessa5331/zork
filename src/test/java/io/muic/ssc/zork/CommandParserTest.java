package io.muic.ssc.zork;

import org.junit.jupiter.api.Test;

class CommandParserTest {

    @Test
    void testParser() {
        CommandParser commandParser = new CommandParser();
        System.out.println(commandParser.parse("exit", true).toString());
        System.out.println(commandParser.parse("exit", false).toString());
        System.out.println(commandParser.parse("help", true).toString());
        System.out.println(commandParser.parse("help", false).toString());
    }
}