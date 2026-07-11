package com.skillfyme.demo;

/**
 * Main application class for the Jenkins Pipeline as Code demo.
 */
public final class App {

    /**
     * Private constructor prevents creation of utility class instances.
     */
    private App() {
    }

    /**
     * Returns the application message.
     *
     * @return application message
     */
    public static String getMessage() {
        return "Jenkins Pipeline as Code is working!";
    }

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        System.out.println(getMessage());
    }
}
