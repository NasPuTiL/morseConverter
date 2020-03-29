package com.lysy;

import com.lysy.morse.MorseConverter;

public class Main {

    public static void main(String[] args) {
        String mssg = "• — • •   • • —   • • •   • •          • •   • • •          • • • —   •   • — •   — • — —          • — — •   • — •   •   —   —   — • — —";

        MorseConverter mc = new MorseConverter();
        System.out.println("Result: = " + mc.convertMessage(mssg));
    }
}
