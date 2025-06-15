package com.hainam.errorcodes;

import java.util.logging.Logger;

interface Printer {
    void print(String message);
}

class ConsolePrinter implements Printer {
    private static final Logger logger = Logger.getLogger(ConsolePrinter.class.getName());

    @Override
    public void print(String message) {
        logger.info(message);
    }
}

class Report {
    private Printer printer;

    public Report(Printer printer) {
        this.printer = printer;
    }

    void generate() {
        printer.print("Generating report...");
    }
}

class Main {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        Report report = new Report(printer);
        report.generate();
    }
}
