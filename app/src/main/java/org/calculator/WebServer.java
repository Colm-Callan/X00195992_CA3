package org.calculator;

import static spark.Spark.*;

public class WebServer {
    public static void main(String[] args) {
        port(getAssignedPort());

        staticFiles.location("/public");

        Calculator calc = new Calculator();

        get("/health", (req, res) -> "OK");

        get("/add", (req, res) -> {
            int a = Integer.parseInt(req.queryParams("a"));
            int b = Integer.parseInt(req.queryParams("b"));
            return String.valueOf(calc.add(a,b));
        });

        get("/subtract", (req, res) -> {
            int a = Integer.parseInt(req.queryParams("a"));
            int b = Integer.parseInt(req.queryParams("b"));
            return String.valueOf(calc.subtract(a,b));
        });

        get("/multiply", (req, res) -> {
            int a = Integer.parseInt(req.queryParams("a"));
            int b = Integer.parseInt(req.queryParams("b"));
            return String.valueOf(calc.multiply(a,b));
        });

        get("/divide", (req, res) -> {
            int a = Integer.parseInt(req.queryParams("a"));
            int b = Integer.parseInt(req.queryParams("b"));
            return String.valueOf(calc.divide(a,b));
        });
    }

    private static int getAssignedPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            try { return Integer.parseInt(port); } catch (Exception ignored) {}
        }
        return 8080;
    }
}